package org.gemoc.execution.engine.core;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.EMFCommandTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry;

public class PlainK3ExecutionEngine extends AbstractExecutionEngine implements IMSEOccurrenceListener, IStepManager {

	private Runnable _runnable;

	private org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain;

	public PlainK3ExecutionEngine(final IExecutionContext context, final Object caller, final Method method, final ArrayList<Object> parameters) {
		super(context);
		MSEManager.getInstance().reset();
		this.editingDomain = getEditingDomain(context.getResourceModel().getResourceSet());
		this.reset();
		StepManagerRegistry.getInstance().registerManager(this);
		_runnable = new Runnable() {
			@Override
			public void run() {
				try {
					MSEManager.getInstance().addListener(PlainK3ExecutionEngine.this);
					method.invoke(caller, parameters.get(0));
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					MSEManager.getInstance().removeListener(PlainK3ExecutionEngine.this);
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
	public void addFutureAction(IFutureAction action) {
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

	@Override
	public void mseOccurenceRaised(MSEOccurrence occurrence) {
		if (_isStopped) {
			throw new RuntimeException("Execution stopped");
		}
		// before coming here, it is absolutely necessary to have visited the
		// solver first.
		try {
			performExecutionStep();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void mseOccurenceAboutToBeRaised(MSEOccurrence occurrence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mseOccurenceEnded(MSEOccurrence occurrence) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			addon.mseOccurrenceExecuted(this, occurrence);
		}
	}

	private EMFCommandTransaction currentTransaction;

	public void reset() {
		currentTransaction = null;
	}

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

	@Override
	public Object execute(Object caller, final StepCommand command, String methodName) {
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

					// Notification start mse
					// This is where the engine might be pause with the current
					// design (ie. using StepByStepUserDecider)
					// And we clearly are in between two transactions, so no
					// more
					// annoying window :)
					org.gemoc.execution.engine.core.MSEManager.getInstance().raiseMSEOccurrence(caller_cast, methodName);

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
					org.gemoc.execution.engine.core.MSEManager.getInstance().endMSEOccurrence();

					// And we start a new transaction
					startNewTransaction(editingDomain_cast, rc);
				}

			} catch (RollbackException e) {
				// TODO what to do here? Maybe the exception should be sent
				// upstream
				// But not possible if we don't generate a "throws" in the java
				// code
				rc.dispose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

}
