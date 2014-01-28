/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package fr.obeo.dsl.fuml.standardlibrary.library.list;

import java.util.ArrayList;
import java.util.List;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.standardlibrary.Activator;

public class ListConcat extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
		try {
			List<Value> list1 = inputParameters.get(0).values;
			List<Value> list2 = inputParameters.get(1).values;
			List<Value> result = new ArrayList<Value>();
			result.addAll(list1) ;
			result.addAll(list2) ;
			outputParameters.get(0).values = result;
		} catch (Exception e) {
			Activator.getDefault().error("An error occured during the execution of ListConcat " + e.getMessage(), e);
		}
	}

	@Override
	public Value new_() {
		return new ListConcat();
	}
}
