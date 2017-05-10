
package org.gemoc.sample.legacyfsm.xsfsm.trace.tracemanager;

import java.util.List;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

public class FsmTraceStepFactory implements IStepFactory {

	@Override
	public fr.inria.diverse.trace.commons.model.trace.Step<?> createStep(
			fr.inria.diverse.trace.commons.model.trace.MSE mse, List<Object> parameters, List<Object> result) {

		fr.inria.diverse.trace.commons.model.trace.Step<?> step = null;
		org.eclipse.emf.ecore.EClass ec = mse.getCaller().eClass();
		String stepRule = fr.inria.diverse.trace.commons.EcoreCraftingUtil.getFQN(ec, ".") + "."
				+ mse.getAction().getName();

		if (mse.getAction().getName().equalsIgnoreCase("step")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE.getState()
						.getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_State_Step();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("initializeModel")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getStateMachine().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_StateMachine_InitializeModel();
		} else

		if (mse.getAction().getName().equalsIgnoreCase("fire")
				&& (ec.getClassifierID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
						.getTransition().getClassifierID()))

		{
			step = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_Transition_Fire();
		}

		else {
			step = fr.inria.diverse.trace.commons.model.generictrace.GenerictraceFactory.eINSTANCE
					.createGenericSequentialStep();
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
