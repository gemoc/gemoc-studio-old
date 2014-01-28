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

import java.util.List;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
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

public class StandardOutputChannelImpl extends Object_ {

	protected static OpaqueBehavior writeLineMethod ;
	protected static OpaqueBehavior writeMethod;
	
	protected static final String CONSOLE_NAME = "fUML Console";
	
	protected static IOConsole console = null;
	protected IOConsoleOutputStream out = null;
	
	public static IOConsole getConsole() {
		if (console == null) {
			console = new IOConsole(CONSOLE_NAME, null);
			IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
			conMan.addConsoles(new IConsole[]{console});
		}
		return console;
	}
	
	public StandardOutputChannelImpl(Class service) {
		super() ;
		this.types.add(service) ;		
		this.out = getConsole().newOutputStream();
	}

	@Override
	public Execution dispatch(Operation operation) {
		if (operation.getName().equals("writeLine"))
			return new WriteLineExecution(operation) ;
		else if (operation.getName().equals("write"))
			return new Write(operation) ;
		// TODO complete with other operations
		return null ;
	}

	protected class WriteLineExecution extends OpaqueBehaviorExecution {

		protected Operation operation ;
		
		public WriteLineExecution(Operation operation) {
			this.operation = operation ;
		}
		
		@Override
		public Value new_() {
			return new WriteLineExecution(operation) ;
		}

		@Override
		public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
			// Supposed to have only one input argument, corresponding to parameter 'value'
			try {
				String message = ((StringValue)inputParameters.get(0).values.get(0)).value;
				out.write(message + "\n");
				out.flush() ;
				// This implementation does not produce errorStatus information.
			} catch (Exception e) {
				Debug.println("An error occured during the execution of writeLine " + e.getMessage());
			}
		}

		@Override
		public Behavior getBehavior() {
			if (writeLineMethod == null) {
				writeLineMethod = SystemServicesRegistryUtils.getInstance().generateOpaqueBehaviorSignature(operation) ;
			}
			return writeLineMethod ;
		}
		
	}
	
	protected class Write extends OpaqueBehaviorExecution {

		protected Operation operation ;
		
		public Write(Operation operation) {
			this.operation = operation ;
		}
		
		@Override
		public Value new_() {
			return new Write(operation) ;
		}

		@Override
		public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
			// Supposed to have only one input argument, corresponding to parameter 'value'
			try {
				String message = inputParameters.get(0).values.get(0).toString();
				out.write(message);
				out.flush() ;
				// This implementation does not produce errorStatus information.
			} catch (Exception e) {
				Debug.println("An error occured during the execution of write " + e.getMessage());
			}
		}

		@Override
		public Behavior getBehavior() {
			if (writeMethod == null) {
				writeMethod = SystemServicesRegistryUtils.getInstance().generateOpaqueBehaviorSignature(operation) ;
			}
			return writeMethod ;
		}
		
	}
}
