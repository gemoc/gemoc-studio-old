package org.gemoc.gemoc_process.wizard.ContextDynamic;

public class VariableDefinition {
	
	String name;
	String returnType;
	
	public VariableDefinition (String name, String returnType) {
		this.name = name;
		this.returnType = returnType;
	}

	public String toString () {
		return this.name + " : " + this.returnType;
	}
}
