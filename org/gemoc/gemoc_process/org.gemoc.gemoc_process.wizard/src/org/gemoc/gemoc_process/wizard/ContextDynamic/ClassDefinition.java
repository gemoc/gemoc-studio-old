package org.gemoc.gemoc_process.wizard.ContextDynamic;

import java.util.ArrayList;
import java.util.List;

public class ClassDefinition {
	
	List<OperationDefinition> listOperations;
	List<VariableDefinition> listAttributes;
	
	public ClassDefinition () {
		listOperations = new ArrayList<OperationDefinition>();
		listAttributes = new ArrayList<VariableDefinition>();
	}

	public void addOperation(OperationDefinition operation) {
		listOperations.add(operation);
	}
	
	public void removeOperation (int index) {
		listOperations.remove(index);
	}
	
	public void addAttribute (VariableDefinition attribute) {
		listAttributes.add(attribute);
	}
	
	public void removeAttribute (int index) {
		listAttributes.remove(index);
	}
}
