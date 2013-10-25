package fr.inria.aoste.timesquare.backend.emfexecution.manager;

import java.util.HashMap;

import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorConfigurator;
import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;

public class CodeExecutorConfigurator extends
		BehaviorConfigurator<EmfCodeExecutionManager> {

	public CodeExecutorConfigurator(ConfigurationHelper _ch,
			EmfCodeExecutionManager _behaviorManager) {
		super(_ch, _behaviorManager);

	}

//	public void createBehaviorforClock(IMethod method, EObject clock)
//			throws Exception {
//		activate();
//		Variable var = new Variable(clock.toString(), method.getDeclaringType());
//		System.out.println("Configuration Behavior : createBehaviorforClock");
//
//		ClockEntity ce = getConfigurationHelper().getClock(clock);
//		getBehaviorManager().addBehavior(var, method, ce,
//				getConfigurationHelper().getTicksState());
//
//	}

//	public void createBehaviorforClock(Variable var, IMethod method,
//			EObject clock) throws Exception {
//		activate();
//		System.out.println("Configuration Behavior : createBehaviorforClock");
//
//		ClockEntity ce = getConfigurationHelper().getClock(clock);
//		getBehaviorManager().addBehavior(var, method, ce,
//				getConfigurationHelper().getTicksState());
//
//	}

	public HashMap<String, Object> getData() {
		return getBehaviorManager().getData();
	}
}
