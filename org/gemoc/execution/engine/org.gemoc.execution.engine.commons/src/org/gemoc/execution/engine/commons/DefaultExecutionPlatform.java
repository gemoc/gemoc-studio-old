package org.gemoc.execution.engine.commons;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.execution.engine.commons.solvers.ccsl.SolverMock;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public class DefaultExecutionPlatform implements IExecutionPlatform {
	
	private IModelLoader _modelLoader;
	private ISolver _solver;
	private ICodeExecutor _codeExecutor;
	private Collection<IEngineHook> _hooks;
	private Collection<IMSEStateController> _clockControllers;
	private Object _javaEntryPoint;
	
	public DefaultExecutionPlatform(LanguageDefinitionExtension _languageDefinition) throws CoreException 
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
		_hooks = _languageDefinition.instanciateEngineHooks();
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
	public Collection<IEngineHook> getHooks() 
	{
		return _hooks;
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
		_hooks.clear();
	}
	
	// 			_javaEntryPoint = _languageDefinition.instanciateJavaEntryPoint();

}
