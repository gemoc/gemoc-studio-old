package org.gemoc.sequential_addons.modelchangelistener.messages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FieldChange {
	
	public enum ChangeType { ADD, MODIFY, REMOVE }
	
	private EStructuralFeature feature;
	private EObject eObject;
	private Object value;
	private ChangeType changeType;
	
	public FieldChange(EStructuralFeature feature, EObject eObject, Object value, ChangeType changeType) {
		this.feature = feature;
		this.eObject = eObject;
		this.value = value;
		this.changeType = changeType;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public EObject geteObject() {
		return eObject;
	}

	public Object getValue() {
		return value;
	}
	
	public ChangeType getChangeType() {
		return changeType;
	}
}
