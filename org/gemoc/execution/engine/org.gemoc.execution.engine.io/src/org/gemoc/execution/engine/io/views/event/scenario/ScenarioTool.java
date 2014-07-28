package org.gemoc.execution.engine.io.views.event.scenario;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.scenario.Scenario;
import org.gemoc.execution.engine.scenario.ScenarioFactory;
import org.gemoc.execution.engine.scenario.impl.ScenarioFactoryImpl;

public class ScenarioTool 
{
	protected Scenario _scenario;
	protected ScenarioManager _manager;
	protected Resource _resource;
	protected ScenarioFactory _factory;
	protected int _index;
	
	protected ScenarioTool(ScenarioManager manager, int index)
	{
		_manager = manager;
		_index = index;
		_scenario = null;
		_factory = ScenarioFactoryImpl.eINSTANCE;
	}
	
	protected void safeModelModification(final Runnable runnable)
	{
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(_manager.getWrapperCache().getSystem());
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {
					public void doExecute() {
						runnable.run();
					}
				});		
	}
}
