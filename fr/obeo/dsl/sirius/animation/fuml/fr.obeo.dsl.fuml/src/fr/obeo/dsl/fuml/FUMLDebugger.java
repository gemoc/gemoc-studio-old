package fr.obeo.dsl.fuml;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;

public class FUMLDebugger extends AbstractDSLDebugger {

	private final FUMLExecutionEngineForDSL engine;

	private Object_ context;

	private boolean frameCreated;

	private final Map<StructuralFeature, FeatureValue> lastValues = new HashMap<StructuralFeature, FeatureValue>();

	public FUMLDebugger(IDSLDebugEventProcessor target,
			FUMLExecutionEngineForDSL engine) {
		super(target);
		this.engine = engine;
	}

	public void start() {
		engine.start();
	}

	public void disconnect() {
		// TODO Auto-generated method stub
	}

	public boolean canStepInto(String threadName, EObject instruction) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean control(String threadName,
			ActivityNodeActivation activityNodeActivation) {
		final boolean res;
		final EObject instruction = activityNodeActivation.node;
		if (instruction != null) {
			context = activityNodeActivation.getExecutionContext();
			res = control(threadName, instruction);
		} else {
			res = true; // fUML workaround
		}
		return res;
	}

	public boolean control(String threadName,
			ActivityEdgeInstance activityEdgeInstance) {
		final boolean res;
		final EObject instruction = activityEdgeInstance.edge;
		if (instruction != null) {
			context = activityEdgeInstance.group.getActivityExecution().context;
			res = control(threadName, instruction);
		} else {
			res = true; // fUML workaround
		}
		return res;
	}

	public void updateData(String threadName, EObject instruction) {
		if (!frameCreated) {
			pushStackFrame(threadName,
					FUMLExecutionEngineForDSL.main.getName(),
					FUMLExecutionEngineForDSL.main, instruction);
			frameCreated = true;
		} else {
			setCurrentInstruction(threadName, instruction);
		}

		for (FeatureValue value : context.getFeatureValues()) {
			final FeatureValue lastValue = lastValues.get(value.feature);
			if (lastValue == null || !lastValue.hasEqualValues(value)) {
				variable(threadName, value.feature.getType().getName(),
						value.feature.getName(), value.values);
				lastValues.put(value.feature, value.copy());
			}
		}
		variable(threadName, instruction.eClass().getName(), "instruction", instruction);
	}

	public fr.obeo.dsl.debug.ide.EObject getNextInstruction(String threadName,
			fr.obeo.dsl.debug.ide.EObject currentInstruction, Stepping stepping) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateVariableValue(String threadName,
			String variableName, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getVariableValue(String threadName, String stackName,
			String variableName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setVariableValue(String threadName, String stackName,
			String variableName, Object value) {
		// TODO Auto-generated method stub
		
	}

}
