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
package fr.obeo.dsl.fuml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;

import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.BooleanValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.IntegerValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.StringValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Executor;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL3.ExecutionFactoryL3;
import fr.obeo.dsl.fuml.registry.DefaultSemanticStrategyRegistry;
import fr.obeo.dsl.fuml.registry.IOpaqueBehaviorExecutionRegistry;
import fr.obeo.dsl.fuml.registry.ISystemServicesRegistry;

public abstract class FUMLExecutionEngine {

	protected final static String LIBRAY_EXTENSION_POINT_ID = "fr.obeo.dsl.fuml.library";
	protected final static String SERVICES_EXTENSION_POINT_ID = "fr.obeo.dsl.fuml.services" ;

	protected static Behavior main = null;

	protected String[] args ;

	protected List<ParameterValue> arguments ;

	protected Locus locus ;

	protected boolean started = false ;
	
	public static FUMLExecutionEngine eInstance ;

	// Starts the execution of the given behavior
	public void start(Behavior behavior) {
		if(behavior != null) {
			main = behavior;
			// creates the locus, executor and execution factory
			this.locus = new Locus();
			this.locus.setExecutor(new Executor());
			this.locus.setFactory(new ExecutionFactoryL3());
			// initializes built-in primitive types
			this.initializeBuiltInPrimitiveTypes(locus);
			// Initializes opaque behavior executions
			this.registerOpaqueBehaviorExecutions(locus);
			// Initializes system services
			this.registerSystemServices(locus) ;
			// Initializes semantic strategies
			this.registerSemanticStrategies(locus);
			// Initializes arguments
			this.initializeArguments(this.args) ;
			// Finally launches the execution
			this.started = true ;
			this.locus.executor.execute(main, null,this.arguments);
//			eInstance.getControlDelegate().waitForTermination() ;
		}
	}

	public void initializeArguments(String[] args) {
		this.args = args ;
		if (this.locus == null) {
			return ;
		}

		this.arguments = new ArrayList<ParameterValue>() ;
		if (this.args == null)
			return ;

		List<Value> tmpArgs = new ArrayList<Value>() ;

		// analyzes arguments versus parameters of the main behavior
		List<Parameter> parameters = main.getOwnedParameters() ;
		if (parameters == null)
			return ;
		List<Parameter> parametersWhichNeedArguments = new ArrayList<Parameter>() ;
		// There must be the same number of parameters (except the return parameter)
		for (Parameter p : parameters) {
			if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
				parametersWhichNeedArguments.add(p) ;
		}
		if (parametersWhichNeedArguments.size() != this.args.length)
			return ;

		// iterates on parameters, and tries to create tokens corresponding to arguments
		int i = 0 ;
		for (Parameter p : parametersWhichNeedArguments) {
			Type t = p.getType() ;
			if (t != null) {
				PrimitiveType pt = this.locus.factory.getBuiltInType(t.getName()) ;
				if (pt == null)
					return ;
				if (pt.getName().equals("Integer")) {
					IntegerValue value = new IntegerValue() ;
					value.value = new Integer(this.args[i]) ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("String")) {
					StringValue value = new StringValue() ;
					value.value = this.args[i] ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("Boolean")) {
					BooleanValue value = new BooleanValue() ;
					value.value = new Boolean(this.args[i]) ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("UnlimitedNatural")) {
					UnlimitedNaturalValue value = new UnlimitedNaturalValue() ;
					value.value = new Integer(args[i]) ;
					tmpArgs.add(value) ;
				}
				else {
					return ; // Unsupported type. TODO Consider Real 
				}
			}
			i++ ;
		}

		i = 0 ;
		// creates actual arguments
		for (Value v : tmpArgs) {
			ParameterValue arg = new ParameterValue() ;
			arg.parameter = parameters.get(i) ;
			arg.values = new ArrayList<Value>() ;
			arg.values.add(v) ;
			this.arguments.add(arg) ;
			i++ ;
		}
	}
	
	// Register semantic strategies available in the environment
	protected void registerSemanticStrategies(Locus locus) {
		// TODO Introduce an extension point
		new DefaultSemanticStrategyRegistry().registerSemanticStrategies(locus);
	}

	// Register OpaqueBehaviorExecutions available in the environment
	protected void registerOpaqueBehaviorExecutions(Locus locus) {
		// Load any OpaqueBehaviorExecution library contributing to the extension LIBRAY_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(LIBRAY_EXTENSION_POINT_ID);
		try {
			for(int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadLibrary(o, locus, main);
			}
		} catch (CoreException ex) {
			Activator.getDefault().error(ex);
		} catch (Exception ex) {
			Activator.getDefault().error(ex);
		}
	}

	// Register System Services available in the environment
	protected void registerSystemServices(Locus locus) {
		// Load any contribution to the extension SERVICES_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(SERVICES_EXTENSION_POINT_ID);
		try {
			for(int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadServices(o, locus, main);
			}
		} catch (CoreException ex) {
			Activator.getDefault().error(ex);
		} catch (Exception ex) {
			Activator.getDefault().error(ex);
		}
	}

	// Initializes primitive types of the locus with content of UMLPrimitiveTypes
	protected void initializeBuiltInPrimitiveTypes(Locus locus) {
		// FIXME should work
					URI libraryUri = URI.createURI("pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml");
					ResourceSet resourceSet = main.eResource().getResourceSet();
					Resource libraryResource = resourceSet.getResource(libraryUri, true);
					Package libraryObject = (Package)libraryResource.getContents().get(0);
					for(Element e : libraryObject.getOwnedElements()) {
						if(e instanceof PrimitiveType)
							locus.factory.builtInTypes.add((PrimitiveType)e);
					}
			}

	// Loads a library of OpaqueBehaviorExecutions using the safe runner pattern
	protected static void loadLibrary(final Object o, final Locus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {
			
			public void handleException(Throwable e) {
				Activator.getDefault().error(e);
			}

			public void run() throws Exception {
				((IOpaqueBehaviorExecutionRegistry)o).init(context).registerOpaqueBehaviorExecutions(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	// Loads System services using the safe runner pattern
	protected static void loadServices(final Object o, final Locus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				Activator.getDefault().error(e);
			}

			public void run() throws Exception {
				((ISystemServicesRegistry)o).init(context).registerSystemServices(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	/**
	 * Returns the ControlDelegate object associated with this engine.
	 * This object can be used by fUML visitors as a kind of control manager,
	 * which is charge of managing debug specific aspects (e.g., suspension,
	 * termination, animation, etc.)
	 * 
	 * @return The ControlDelegate object associated with this engine
	 */
	public abstract FUMLDebugger getDebugger() ;
	
}
