package org.gemoc.execution.engine.core;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public class DefaultExecutionPlatform implements IExecutionPlatform {
	
	private IModelLoader _modelLoader;
	private Solver _solver;
	private ICodeExecutor _codeExecutor;
	
	public DefaultExecutionPlatform(LanguageDefinitionExtension _languageDefinition) throws CoreException 
	{
		_modelLoader = _languageDefinition.instanciateModelLoader();
		_solver = _languageDefinition.instanciateSolver();
		_codeExecutor = _languageDefinition.instanciateCodeExecutor();
	}

	@Override
	public IModelLoader getModelLoader() 
	{
		return _modelLoader;
	}

	@Override
	public Solver getSolver() 
	{
		return _solver;
	}

	@Override
	public ICodeExecutor getCodeExecutor() 
	{
		return _codeExecutor;
	}

}
