package fr.obeo.dsl.fuml.standardlibrary.library.real;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.IntegerValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.RealValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.standardlibrary.Activator;

public class ToInteger extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
		try {
			Double x = ((RealValue)inputParameters.get(0).values.get(0)).value;
			String y = x.toString();
			IntegerValue result = new IntegerValue();
			result.value = new Integer(y);
	    	result.type = this.locus.factory.getBuiltInType("Real");
			List<Value> outputs = new ArrayList<Value>();
			outputs.add(result);
			outputParameters.get(0).values = outputs;
		} catch (Exception e) {
			Activator.getDefault().error("An error occured during the execution of ToInteger " + e.getMessage(), e);
		}
	}

	@Override
	public Value new_() {
		// ADDED
		return new ToInteger();
	}
}