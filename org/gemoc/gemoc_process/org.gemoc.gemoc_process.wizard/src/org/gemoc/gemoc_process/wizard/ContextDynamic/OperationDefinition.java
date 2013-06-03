package org.gemoc.gemoc_process.wizard.ContextDynamic;

import java.util.ArrayList;
import java.util.List;

public class OperationDefinition {
	
	String name;
	String returnType;
	List<VariableDefinition> listParameters;
	
	public OperationDefinition () {
		listParameters = new ArrayList<VariableDefinition>();
	}

}