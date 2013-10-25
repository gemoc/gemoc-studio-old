package org.gemoc.execution.javasolver.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

public class MockConstraint {
	private EObject target;
	private EOperation operation;

	public MockConstraint(EObject target, EOperation operation) {
		this.target = target;
		this.operation = operation;
	}

	public EObject getTarget() {
		return target;
	}

	public EOperation getOperation() {
		return operation;
	}

	public MockConstraint(EObject target, String operationName) {
		this(target, getEOperationFromName(target, operationName));
	}

	public boolean equals(MockConstraint constraint) {
		return this.target == constraint.getTarget()
				& this.operation == constraint.getOperation();
	}

	private static EOperation getEOperationFromName(EObject eo, String name) {
		for (EOperation operation : eo.eClass().getEAllOperations()) {
			if (operation.getName().equals(name)) {
				return operation;
			}
		}
		return null;
	}
}
