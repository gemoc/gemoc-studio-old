package fr.obeo.dsl.fuml.standardlibrary.library.real;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.RealValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.standardlibrary.Activator;

public class Inv extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
		try {
	        Double inv = 0.0;
			Double x = ((RealValue)inputParameters.get(0).values.get(0)).value;
			if (x == inv)
				throw new ArithmeticException("(arg == 0)") ;
			else {
				inv = 1 / x;
			}
			RealValue result = new RealValue();
			result.value = inv;
	    	result.type = this.locus.factory.getBuiltInType("Real");
	    	List<Value> outputs = new ArrayList<Value>();
			outputs.add(result);
			outputParameters.get(0).values = outputs;
		}
		catch (ArithmeticException a) {
			Activator.getDefault().error("An error occured during the execution of Inv " + a.getMessage(), a);
			RealValue result = new RealValue();
			result.value = 0.0;
	    	result.type = this.locus.factory.getBuiltInType("Real");
	    	List<Value> outputs = new ArrayList<Value>();
			outputs.add(result);
			outputParameters.get(0).values = outputs;
		}
		catch (Exception e) {
			Activator.getDefault().error("An error occured during the execution of Inv " + e.getMessage(), e);
		}
	}

	@Override
	public Value new_() {
		// ADDED:
		return new Abs();
	}
}