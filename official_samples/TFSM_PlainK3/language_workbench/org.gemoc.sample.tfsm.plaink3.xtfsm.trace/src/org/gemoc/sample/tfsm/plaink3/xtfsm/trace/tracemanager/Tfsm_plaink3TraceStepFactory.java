
package org.gemoc.sample.tfsm.plaink3.xtfsm.trace.tracemanager;

import java.util.List;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

public class Tfsm_plaink3TraceStepFactory implements IStepFactory {

	@Override
	public fr.inria.diverse.trace.commons.model.trace.Step createStep(
			fr.inria.diverse.trace.commons.model.trace.MSE mse, List<Object> parameters, List<Object> result) {

		fr.inria.diverse.trace.commons.model.trace.Step step = null;
		org.eclipse.emf.ecore.EClass ec = mse.getCaller().eClass();
		String stepRule = fr.inria.diverse.trace.commons.EcoreCraftingUtil.getFQN(ec, ".") + "."
				+ mse.getAction().getName();

		if (mse.getAction().getName().equalsIgnoreCase("ticks")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getFSMClock().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_FSMClock_Ticks();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("trigger")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_FSMEvent_Trigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("unTrigger")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_FSMEvent_UnTrigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getState().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_State_Visit();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("init")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getTFSM().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_TFSM_Init();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("fire")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_Transition_Fire();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_Transition_Visit();
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
