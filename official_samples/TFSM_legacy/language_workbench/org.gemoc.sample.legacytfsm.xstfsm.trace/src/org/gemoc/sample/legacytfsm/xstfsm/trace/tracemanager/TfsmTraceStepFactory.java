
package org.gemoc.sample.legacytfsm.xstfsm.trace.tracemanager;

import java.util.List;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

public class TfsmTraceStepFactory implements IStepFactory {

	@Override
	public fr.inria.diverse.trace.commons.model.trace.Step createStep(
			fr.inria.diverse.trace.commons.model.trace.MSE mse, List<Object> parameters, List<Object> result) {

		fr.inria.diverse.trace.commons.model.trace.Step step = null;
		org.eclipse.emf.ecore.EClass ec = mse.getCaller().eClass();
		String stepRule = fr.inria.diverse.trace.commons.EcoreCraftingUtil.getFQN(ec, ".") + "."
				+ mse.getAction().getName();

		if (mse.getAction().getName().equalsIgnoreCase("ticks")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getFSMClock().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_FSMClock_Ticks();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("trigger")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_FSMEvent_Trigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("unTrigger")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_FSMEvent_UnTrigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getState().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_State_Visit();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("init")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getTimeFSM().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_TimeFSM_Init();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("fire")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_Transition_Fire();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_Transition_Visit();
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
