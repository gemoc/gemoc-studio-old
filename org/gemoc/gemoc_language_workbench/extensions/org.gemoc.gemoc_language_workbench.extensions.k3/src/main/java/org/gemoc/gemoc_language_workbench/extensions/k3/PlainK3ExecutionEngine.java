package org.gemoc.gemoc_language_workbench.extensions.k3;

import java.lang.reflect.Method;
import java.util.ArrayList;

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

	private InternalTransactionalEditingDomain editingDomain;

	private PlainK3MSEManager mseManager;

	public PlainK3ExecutionEngine(final IExecutionContext context, final Object caller, final Method method,
			final ArrayList<Object> parameters) {
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

	private static InternalTransactionalEditingDomain getEditingDomain(ResourceSet rs) {
		TransactionalEditingDomain edomain = org.eclipse.emf.transaction.TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(rs);
		if (edomain instanceof InternalTransactionalEditingDomain)
			return (InternalTransactionalEditingDomain) edomain;
		else
			return null;
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

	public EMFCommandTransaction createTransaction(InternalTransactionalEditingDomain editingDomain,
			RecordingCommand command) {

		return new EMFCommandTransaction(command, editingDomain, null);
	}

	public void commitCurrentTransaction() throws RollbackException {
		if (currentTransaction != null) {
			currentTransaction.commit();
			currentTransaction = null;
		}
	}

	public void startNewTransaction(InternalTransactionalEditingDomain editingDomain, RecordingCommand command)
			throws InterruptedException {
		currentTransaction = createTransaction(editingDomain, command);
		currentTransaction.start();
	}

	@Override
	public void executeStep(Object caller, final StepCommand command, String methodName) {

		// If the engine is stopped, we use this call to executeStep to stop the
		// execution
		if (_isStopped) {
			throw new RuntimeException("Execution stopped");
		}

		// We only work with calls from non-null EObjects, with non-null
		// commands
		if (caller != null && command != null && caller instanceof EObject && editingDomain != null) {

			// The call is expected to be done from an EMF model, so we cast to
			// EObject
			EObject caller_cast = (EObject) caller;

			// The StepCommand is "transformed" into a "RecordingCommand" for
			// the EMF transaction
			RecordingCommand rc = new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					command.execute();
				}
			};

			try {
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
				startNewTransaction(editingDomain, rc);

				// We run the command (which might start steps)
				command.execute();

				// We commit the transaction (which might be a different one
				// than the one created earlier, or null if two operations
				// end successively)
				commitCurrentTransaction();

				// Handling the ending of an MSE, which might create a fake
				// one to stop the engine again
				boolean isStillInStep = mseManager.endMSEOccurrence();

				// Maybe we have a fake mse to pause the execution at the
				// end of a step
				if (isStillInStep)
					performExecutionStep();

				// We notify addons that the (real) MSE ended.
				notifyMSEOccurenceExecuted(occurrenceRaised);

				// And we start a new transaction, since we might still be
				// in the middle of
				// a step.
				if (isStillInStep)
					startNewTransaction(editingDomain, rc);

			} catch (Exception e) {
				// We dispose to remove adapters
				rc.dispose();

				// We transform everything into a RuntimeException.
				// This is required because executeStep cannot throw any
				// (non-Runtime) exception, since it is used within K3AL
				// generated Java code.
				throw new RuntimeException(e);
			}
		}
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
