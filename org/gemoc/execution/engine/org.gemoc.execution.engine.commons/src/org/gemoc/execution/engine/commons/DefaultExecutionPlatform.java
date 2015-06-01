package org.gemoc.execution.engine.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.execution.engine.commons.solvers.ccsl.SolverMock;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public class DefaultExecutionPlatform implements IExecutionPlatform {
	
	private IModelLoader _modelLoader;
	private ISolver _solver;
	private ICodeExecutor _codeExecutor;
	private Collection<IEngineAddon> _addons;
	private Collection<IMSEStateController> _clockControllers;
	
	public DefaultExecutionPlatform(LanguageDefinitionExtension _languageDefinition, IRunConfiguration runConfiguration) throws CoreException 
	{
		_modelLoader = _languageDefinition.instanciateModelLoader();
		try
		{
			_solver = _languageDefinition.instanciateSolver();			
		}
		catch (CoreException e)
		{
			_solver = new SolverMock();
		}
		_codeExecutor = _languageDefinition.instanciateCodeExecutor();		
		_addons = _languageDefinition.instanciateEngineAddons();
		
		for (EngineAddonSpecificationExtension extension : runConfiguration.getEngineAddonExtensions())
		{
			addEngineAddon(extension.instanciateComponent());
		}
		for (IEngineAddon addon : _languageDefinition.instanciateEngineAddons())
		{
			addEngineAddon(addon);			
		}
		_clockControllers = _languageDefinition.instanciateMSEStateControllers();
	}

	@Override
	public IModelLoader getModelLoader() 
	{
		return _modelLoader;
	}

	@Override
	public ISolver getSolver() 
	{
		return _solver;
	}

	@Override
	public ICodeExecutor getCodeExecutor() 
	{
		return _codeExecutor;
	}

	@Override
	public Iterable<IEngineAddon> getEngineAddons() 
	{
		synchronized(_addonLock)
		{
			return Collections.unmodifiableCollection(new ArrayList<IEngineAddon>(_addons));
		}
	}

	@Override
	public Collection<IMSEStateController> getMSEStateControllers() 
	{
		return _clockControllers;
	}

	@Override
	public void dispose() 
	{
		_clockControllers.clear();
		_addons.clear();
		_solver.dispose();
	}

	private Object _addonLock = new Object();
	
	@Override
	public void addEngineAddon(IEngineAddon addon) 
	{
		synchronized (_addonLock) 
		{
			_addons.add(addon);
		}
	}

	@Override
	public void removeEngineAddon(IEngineAddon addon) 
	{
		synchronized (_addonLock) 
		{
			_addons.remove(addon);
		}
	}
	
}
