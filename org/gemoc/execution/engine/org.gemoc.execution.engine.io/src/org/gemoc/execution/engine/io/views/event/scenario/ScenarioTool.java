package org.gemoc.execution.engine.io.views.event.scenario;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.core.CommandExecution;
import org.gemoc.execution.engine.io.views.event.ModelSpecificEventContext;
import org.gemoc.execution.engine.scenario.Fragment;
import org.gemoc.execution.engine.scenario.Scenario;
import org.gemoc.execution.engine.scenario.ScenarioFactory;
import org.gemoc.execution.engine.scenario.impl.ScenarioFactoryImpl;

public class ScenarioTool 
{

	protected ModelSpecificEventContext _mseContext;
	protected Scenario _scenario;
	protected Fragment _fragment;
	protected Resource _resource;
	protected ScenarioFactory _factory;
	
	protected ScenarioTool(ModelSpecificEventContext mseContext)
	{
		_mseContext = mseContext;
		_scenario = null;
		_fragment = null;
		_factory = ScenarioFactoryImpl.eINSTANCE;
	}
	
	protected void safeModelModification(final Runnable runnable, String label)
	{
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(_resource);
		RecordingCommand command = new RecordingCommand(editingDomain, label) {
			public void doExecute() {
				runnable.run();
			}
		};
		CommandExecution.execute(editingDomain, command);
	}
	
	public Scenario getScenario()
	{
		return _scenario;
	}
	
	public Fragment getFragment()
	{
		return _fragment;
	}
}
