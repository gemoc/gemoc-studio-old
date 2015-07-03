package org.gemoc.gemoc_language_workbench.extensions.k3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.EMFCommandTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry;

public class PlainK3ExecutionEngine extends AbstractExecutionEngine implements IStepManager {

	private Runnable _runnable;

	private org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain;

	private PlainK3MSEManager mseManager;

	public PlainK3ExecutionEngine(final IExecutionContext context, final Object caller, final Method method, final ArrayList<Object> parameters) {
		super(context);
		this.mseManager = new PlainK3MSEManager((K3Solver) context.getExecutionPlatform().getSolver());
		this.editingDomain = getEditingDomain(context.getResourceModel().getResourceSet());
		StepManagerRegistry.getInstance().registerManager(this);
		_runnable = new Runnable() {
			@Override
			public void run() {
				try {
					method.invoke(caller, parameters.get(0));
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					// We always try to commit the current transaction, if one
					// remains
					try {
						commitCurrentTransaction();
					} catch (RollbackException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
	}

	private static TransactionalEditingDomain getEditingDomain(EObject o) {
		return getEditingDomain(o.eResource().getResourceSet());
	}

	private static TransactionalEditingDomain getEditingDomain(ResourceSet rs) {
		return org.eclipse.emf.transaction.TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(rs);
	}

	@Override
	protected void executeSelectedLogicalStep() {
		if (_isStopped) {
			throw new RuntimeException(getName() + " is stopped");
		}
	}

	@Override
	protected Runnable getRunnable() {
		return _runnable;
	}

	private void notifyMSEOccurenceExecuted(MSEOccurrence occurrence) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			addon.mseOccurrenceExecuted(this, occurrence);
		}
	}

	private void notifyMSEOccurrenceAboutToStart(MSEOccurrence occurrence) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			addon.aboutToExecuteMSEOccurrence(this, occurrence);
		}
	}

	private EMFCommandTransaction currentTransaction;

	public EMFCommandTransaction createTransaction(InternalTransactionalEditingDomain editingDomain, RecordingCommand command) {

		return new EMFCommandTransaction(command, editingDomain, null);
	}

	public void commitCurrentTransaction() throws RollbackException {
		if (currentTransaction != null) {
			currentTransaction.commit();
			currentTransaction = null;
		}
	}

	public void startNewTransaction(InternalTransactionalEditingDomain editingDomain, RecordingCommand command) throws InterruptedException {
		currentTransaction = createTransaction(editingDomain, command);
		currentTransaction.start();
	}

	Stack<MSEOccurrence> _mseOccurences = new Stack<MSEOccurrence>();

	@Override
	public Object execute(Object caller, final StepCommand command, String methodName) {
		if (_isStopped) {
			throw new RuntimeException("Execution stopped");
		}

		if (caller != null && command != null && caller instanceof EObject) {
			EObject caller_cast = (EObject) caller;
			RecordingCommand rc = new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					command.execute();
				}
			};
			try {
				if (editingDomain instanceof InternalTransactionalEditingDomain) {
					InternalTransactionalEditingDomain editingDomain_cast = (InternalTransactionalEditingDomain) editingDomain;

					// We end any running transaction
					commitCurrentTransaction();

					// We raise a MSE, ie we put an MSE in the K3 "Solver"
					MSEOccurrence occurrenceRaised = mseManager.raiseMSEOccurrence(caller_cast, methodName);

					// We notify addons
					notifyMSEOccurrenceAboutToStart(occurrenceRaised);
					
					// Then we do the normal call to performExecutionStep
					// This is where it might pause, since the engine will
					// ask the K3Solver for the next step
					performExecutionStep();

					// We start a new transaction
					startNewTransaction(editingDomain_cast, rc);

					// We run the command
					// This might trigger new transaction beginnings/endings in
					// between
					command.execute();

					// We commit the transaction (which might be a different one
					// than the one created earlier, or null if two operations
					// end
					// successively)
					commitCurrentTransaction();

					// Notification end mse
					boolean hasFakeMSE = mseManager.endMSEOccurrence();
					
					// Maybe we have a fake mse to pause the execution at the end of a step
					if (hasFakeMSE)
						performExecutionStep();
					
					// We notify addons
					notifyMSEOccurenceExecuted(occurrenceRaised);

					// And we start a new transaction
					startNewTransaction(editingDomain_cast, rc);
				}

			} catch (Exception e) {
				rc.dispose();
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public boolean canHandle(Object caller) {
		if (caller instanceof EObject) {
			EObject caller_cast = (EObject) caller;
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = getEditingDomain(caller_cast);
			return editingDomain == this.editingDomain;

		}
		return false;
	}

	@Override
	public void addFutureAction(IFutureAction action) {
	}

}
