/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package fr.obeo.dsl.fuml.standardlibrary.library.unlimitednatural;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.standardlibrary.Activator;

public class Min extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
		try {
			Integer x = ((UnlimitedNaturalValue)inputParameters.get(0).values.get(0)).value;
			Integer y = ((UnlimitedNaturalValue)inputParameters.get(1).values.get(0)).value;
			UnlimitedNaturalValue result = new UnlimitedNaturalValue();
			if (x < 0) {
				result.value = y ;
			}
			else if (y < 0) {
				result.value = x ;
			}
			else {
				result.value = Math.min(x, y) ;
			}
			List<Value> outputs = new ArrayList<Value>();
	    	result.type = this.locus.factory.getBuiltInType("UnlimitedNatural");
			outputs.add(result);
			outputParameters.get(0).values = outputs;
		} catch (Exception e) {
			Activator.getDefault().error("An error occured during the execution of Min " + e.getMessage(), e);
		}
	}

	@Override
	public Value new_() {
		return new Min();
	}
}
