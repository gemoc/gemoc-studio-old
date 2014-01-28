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

package fr.obeo.dsl.fuml.standardlibrary.library.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.StringValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.debug.Debug;
import fr.obeo.dsl.fuml.registry.SystemServicesRegistryUtils;

public class StandardInputChannelImpl extends Object_ {
	
	protected static OpaqueBehavior readLineMethod ;
	protected static BufferedReader bufferedReader ;
	
	protected InputStream in = null;

	public StandardInputChannelImpl(Class service) {
		super() ;
		this.types.add(service) ;
		this.in = StandardOutputChannelImpl.getConsole().getInputStream();
	}

	@Override
	public Execution dispatch(Operation operation) {
		if (operation.getName().equals("readLine"))
			return new ReadLineExecution(operation) ;
		// TODO complete with other operations
		return null ;
	}

	protected class ReadLineExecution extends OpaqueBehaviorExecution {

		protected Operation operation ;
		
		public ReadLineExecution(Operation operation) {
			this.operation = operation ;
		}
		
		@Override
		public Value new_() {
			return new ReadLineExecution(operation) ;
		}

		@Override
		public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
			// This implementation does not produce errorStatus information.
			try {
				if (bufferedReader == null)
					bufferedReader = new BufferedReader(new InputStreamReader(in)) ;
				String line = bufferedReader.readLine() ;
				StringValue result = new StringValue() ;
				result.value = "" + line ;
				List<Value> outputs = new ArrayList<Value>();
				outputs.add(result);
				outputParameters.get(0).values = outputs;
			} catch (Exception e) {
				Debug.println("An error occured during the execution of readLine " + e.getMessage());
			}
		}

		@Override
		public Behavior getBehavior() {
			if (readLineMethod == null) {
				readLineMethod = SystemServicesRegistryUtils.getInstance().generateOpaqueBehaviorSignature(operation) ;
			}
			return readLineMethod ;
		}
		
	}
	
}
