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
				}
			}
		};

	}

	@Override
	public Runnable getEntryPoint() {
		return _entryPoint;
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
	public void executeStep(Object caller, final StepCommand command, String methodName) {
		executeOperation(caller, methodName, new Runnable() {
			@Override
			public void run() {
				command.execute();
			}
		});
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
