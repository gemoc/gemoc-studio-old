
package org.gemoc.sample.legacyfsm.xsfsm.trace.tracemanager;

import java.util.List;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

public class FsmTraceStepFactory implements IStepFactory {

	@Override
	public fr.inria.diverse.trace.commons.model.trace.Step createStep(
			fr.inria.diverse.trace.commons.model.trace.MSE mse, List<Object> parameters, List<Object> result) {

		fr.inria.diverse.trace.commons.model.trace.Step step = null;
		org.eclipse.emf.ecore.EClass ec = mse.getCaller().eClass();
		String stepRule = fr.inria.diverse.trace.commons.EcoreCraftingUtil.getFQN(ec, ".") + "."
				+ mse.getAction().getName();

		if (mse.getAction().getName().equalsIgnoreCase("ticks")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getFSMClock().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_FSMClock_Ticks();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("trigger")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_FSMEvent_Trigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("unTrigger")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_FSMEvent_UnTrigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE.getState()
						.getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_State_Visit();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("init")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE.getTimeFSM()
						.getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_TimeFSM_Init();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("fire")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_Transition_Fire();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_Transition_Visit();
		}

		else {
			step = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE.createGenericSequentialStep();
		}

		fr.inria.diverse.trace.commons.model.trace.MSEOccurrence mseocc = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE
				.createMSEOccurrence();
		mseocc.setMse(mse);
		mseocc.getParameters().addAll(parameters);
		mseocc.getResult().addAll(result);
		step.setMseoccurrence(mseocc);

		return step;
	}
}
