/**
 * 
 */
package org.gemoc.execution.engine.actions.impl.simple;

import java.lang.reflect.Method;

import org.gemoc.execution.engine.actions.DomainSpecificAction;

import fr.inria.aoste.trace.Reference;

/**
 * Basic implementation of DomainSpecificAction, contains the EObject and a
 * Method to apply on the EObject.
 * 
 * TODO : change name of the class it's terrible
 * 
 * @author flatombe
 * 
 */
public class MethodReferenceAction implements DomainSpecificAction {
	private Method method;

	private Reference target;

	public MethodReferenceAction(Reference target, Reference method) {
		/*
		 * this.target = target; try { this.method =
		 * target.getClass().getMethod(methodName); } catch
		 * (NoSuchMethodException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SecurityException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * // TODO : comment fournir à l'instanciation d'une DSA les bons
		 * objets? public DomainSpecificAction createDSA(ClockEntity ce) {
		 * EObject linkedOperation = ce.getReferencedElement().get(1); if
		 * (linkedOperation instanceof EOperation) { String operationName =
		 * this.getSimpleName(linkedOperation); MethodReferenceAction action =
		 * new MethodReferenceAction(ce.getModelElementReference(),
		 * operationName); } }
		 */
	}

	@Override
	public Method getMethod() {
		return this.method;
	}

	@Override
	public Reference getTarget() {
		return this.target;
	}

	public String toString() {
		return "MethodReferenceAction@[" + this.target.toString() + " ; "
				+ this.method.getName() + "]";
	}
}
