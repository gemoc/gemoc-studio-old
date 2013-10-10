package org.gemoc.execution.engine.api_implementations.moc;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

public class MockConstraint {
	private EObject target;
	private EOperation operation;
	private int time;

	public MockConstraint(EObject target, EOperation operation, int time) {
		this.target = target;
		this.operation = operation;
		this.time = time;
	}
	
	public EObject getTarget() {
		return target;
	}

	public EOperation getOperation() {
		return operation;
	}

	public int getTime() {
		return time;
	}

	public MockConstraint(EObject target, String operationName, int time) {
		this(target, getEOperationFromName(target, operationName), time);
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
