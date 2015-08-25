package org.gemoc.sample.tfsm.raspberry.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public class ExecutionPlatform implements IExecutionPlatform 
{

	public ExecutionPlatform() 
	{
		_solver = new TFSMSolver();
		_codeExecutor = new TfsmCodeExecutor();
		_engineAddons = new ArrayList<>();
	}
	
	@Override
	public void dispose() 
	{
		// should call dispose on the solver here, missing API
	}

	private TFSMSolver _solver;
	@Override
	public ISolver getSolver() 
	{
		return _solver;
	}

	private ICodeExecutor _codeExecutor;
	@Override
	public ICodeExecutor getCodeExecutor() 
	{
		return _codeExecutor;
	}

	@Override
	public IModelLoader getModelLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEngineAddon(IEngineAddon addon) 
	{
		_engineAddons.add(addon);
	}

	@Override
	public void removeEngineAddon(IEngineAddon addon) 
	{
		_engineAddons.remove(addon);
	}

	private List<IEngineAddon> _engineAddons;
	@Override
	public Iterable<IEngineAddon> getEngineAddons() 
	{
		return _engineAddons;
	}

	@Override
	public Collection<IMSEStateController> getMSEStateControllers() 
	{
		return new ArrayList<IMSEStateController>();
	}

}
