package org.gemoc.sample.tfsm.plaink3.trace.tracemanager;

import java.util.List;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

public class Tfsm_plaink3TraceStepFactory implements IStepFactory {

	@Override
	public org.gemoc.executionframework.engine.mse.MSEOccurrence createMSEOccurrence(
			org.gemoc.executionframework.engine.mse.MSE mse, List<Object> parameters, List<Object> result) {

		String stepRule = fr.inria.diverse.trace.commons.EcoreCraftingUtil.getFQN(mse.getCaller().eClass(), ".") + "."
				+ mse.getAction().getName();
		org.gemoc.executionframework.engine.mse.MSEOccurrence mseocc = null;

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.FSMClock.ticks")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_FSMClock_Ticks();
		} else

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.FSMEvent.trigger")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_FSMEvent_Trigger();
		} else

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.FSMEvent.unTrigger")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_FSMEvent_UnTrigger();
		} else

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.State.visit")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_State_Visit();
		} else

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.TFSM.init")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_TFSM_Init();
		} else

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.Transition.fire")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_Transition_Fire();
		} else

		if (stepRule.equalsIgnoreCase("tfsm_plaink3.Transition.visit")) {
			mseocc = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_Transition_Visit();
		}

		else
			mseocc = org.gemoc.executionframework.engine.mse.MseFactory.eINSTANCE.createMSEOccurrence();

		if (mseocc != null) {
			mseocc.setMse(mse);
			mseocc.getParameters().addAll(parameters);
			mseocc.getResult().addAll(result);
		}
		return mseocc;
	}
}
