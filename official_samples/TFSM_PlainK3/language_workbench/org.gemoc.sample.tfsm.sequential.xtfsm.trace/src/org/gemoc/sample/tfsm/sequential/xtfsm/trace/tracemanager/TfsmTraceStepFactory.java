
package org.gemoc.sample.tfsm.sequential.xtfsm.trace.tracemanager;

import java.util.List;
import org.eclipse.gemoc.trace.gemoc.api.IStepFactory;

public class TfsmTraceStepFactory implements IStepFactory {

	@Override
	public org.eclipse.gemoc.trace.commons.model.trace.Step createStep(
			org.eclipse.gemoc.trace.commons.model.trace.MSE mse, List<Object> parameters, List<Object> result) {

		org.eclipse.gemoc.trace.commons.model.trace.Step step = null;
		org.eclipse.emf.ecore.EClass ec = mse.getCaller().eClass();
		String stepRule = org.eclipse.gemoc.trace.commons.EcoreCraftingUtil.getFQN(ec, ".") + "."
				+ mse.getAction().getName();

		if (mse.getAction().getName().equalsIgnoreCase("ticks")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
						.getFSMClock().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_FSMClock_Ticks();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("trigger")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_FSMEvent_Trigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("unTrigger")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
						.getFSMEvent().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_FSMEvent_UnTrigger();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE.getState()
						.getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_State_Visit();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("init")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE.getTFSM()
						.getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_TFSM_Init();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("fire")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_Transition_Fire();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("visit")
				&& (ec.getClassifierID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_Transition_Visit();
		}

		else {
			step = org.eclipse.gemoc.trace.commons.model.trace.TraceFactory.eINSTANCE.createGenericSequentialStep();
		}

		org.eclipse.gemoc.trace.commons.model.trace.MSEOccurrence mseocc = org.eclipse.gemoc.trace.commons.model.trace.TraceFactory.eINSTANCE
				.createMSEOccurrence();
		mseocc.setMse(mse);
		mseocc.getParameters().addAll(parameters);
		mseocc.getResult().addAll(result);
		step.setMseoccurrence(mseocc);

		return step;
	}
}
