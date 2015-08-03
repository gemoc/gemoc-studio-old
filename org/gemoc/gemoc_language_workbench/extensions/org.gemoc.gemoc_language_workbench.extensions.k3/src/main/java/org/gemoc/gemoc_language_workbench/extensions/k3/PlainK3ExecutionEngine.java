package org.gemoc.gemoc_language_workbench.extensions.k3;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.gemoc.execution.engine.core.AbstractDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry;

public class PlainK3ExecutionEngine extends AbstractDeterministicExecutionEngine implements IStepManager {

	private Runnable _entryPoint;

	/**
	 * Constructs a PlainK3 execution engine using an entry point (~ a main
	 * operation) The entrypoint will register itself as a StepManager into the
	 * K3 step manager registry, and unregister itself at the end. As a
	 * StepManager, the PlainK3ExecutionEngine will receive callbacks through
	 * its "executeStep" operation.
	 * 
	 * @param context
	 *            The GEMOC execution context.
	 * @param caller
	 *            The Main object used to call the main operation entry point.
	 * @param method
	 *            The main operation entry point. Should have a single
	 *            parameter, which is the root of the executed model.
	 * @param parameters
	 *            The parameters given to the main operations. Should contain
	 *            one object which is the root of the model.
	 */
	public PlainK3ExecutionEngine(final IExecutionContext context, final Object caller, final Method method,
			final ArrayList<Object> parameters) {
		super(context);
		_entryPoint = new Runnable() {
			@Override
			public void run() {
				StepManagerRegistry.getInstance().registerManager(PlainK3ExecutionEngine.this);
				try {
					method.invoke(caller, parameters.get(0));
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					StepManagerRegistry.getInstance().unregisterManager(PlainK3ExecutionEngine.this);
				}
			}
		};

	}

	@Override
	public Runnable getEntryPoint() {
		return _entryPoint;
	}

	@Override
	/*
	 * This is the operation called from K3 code. We use this callback to pass
	 * the command to the generic executeOperation operation. (non-Javadoc)
	 * 
	 * @see fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager#
	 * executeStep(java.lang.Object,
	 * fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand,
	 * java.lang.String)
	 */
	public void executeStep(Object caller, final StepCommand command, String methodName) {
		executeOperation(caller, methodName, new Runnable() {
			@Override
			public void run() {
				command.execute();
			}
		});
	}

	@Override
	/*
	 * This is the operation used to act as a StepManager in K3. We return true
	 * if we have the same editing domain as the object. (non-Javadoc)
	 * 
	 * @see
	 * fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager#canHandle
	 * (java.lang.Object)
	 */
	public boolean canHandle(Object caller) {
		if (caller instanceof EObject) {
			EObject caller_cast = (EObject) caller;
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = getEditingDomain(caller_cast);
			return editingDomain == this.editingDomain;

		}
		return false;
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

}
