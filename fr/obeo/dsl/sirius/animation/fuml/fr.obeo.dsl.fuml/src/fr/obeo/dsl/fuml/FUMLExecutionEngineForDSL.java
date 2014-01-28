package fr.obeo.dsl.fuml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
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

public class FUMLExecutionEngineForDSL extends FUMLExecutionEngine {
	
	public final static String THREAD_NAME = "Main";	
	
	private FUMLDebugger debugger;
	
	/* (non-Javadoc)
	 * @see fr.obeo.dsl.fuml.engine.AbstractExecutionEngine#init(org.eclipse.emf.ecore.EObject, java.lang.String[], fr.obeo.dsl.fuml.debug.FUMLDebugTarget, int, int, int)
	 */
	public void init(EObject eObjectToExecute, String[] args) {
		if (eObjectToExecute instanceof Behavior) {
			main = (Behavior)eObjectToExecute ;
			FUMLExecutionEngine.eInstance = this ;
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.obeo.dsl.fuml.engine.AbstractExecutionEngine#initializeArguments(java.lang.String[])
	 */
	@Override
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

	public void start() {
		if (!this.started) {
			Runnable execution = new Runnable() {
				public void run() {
					if (main != null) {
						if (getDebugger() != null) {
							getDebugger().spawnRunningThread(Thread.currentThread().getName(), FUMLExecutionEngineForDSL.main);
						}
						start(main) ;
						if (getDebugger() != null && !getDebugger().isTerminated(Thread.currentThread().getName())) {
							getDebugger().terminated(Thread.currentThread().getName());
						}
					}
				}
			};
			Thread mainThread = new Thread(execution, FUMLExecutionEngineForDSL.THREAD_NAME) ;
			mainThread.start() ;
		}
	}

	@Override
	public FUMLDebugger getDebugger() {
		return debugger;
	}

	public void setDebugger(FUMLDebugger debugger) {
		this.debugger = debugger;
	}

}
