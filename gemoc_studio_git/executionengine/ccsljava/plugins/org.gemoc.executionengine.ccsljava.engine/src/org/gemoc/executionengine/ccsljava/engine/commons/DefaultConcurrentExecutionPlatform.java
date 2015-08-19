package org.gemoc.executionengine.ccsljava.engine.commons;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.execution.engine.commons.DefaultExecutionPlatform;
import org.gemoc.executionengine.ccsljava.api.core.IConcurrentExecutionPlatform;
import org.gemoc.executionengine.ccsljava.api.dsa.executors.ICodeExecutor;
import org.gemoc.executionengine.ccsljava.api.dse.IMSEStateController;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;

public class DefaultConcurrentExecutionPlatform extends DefaultExecutionPlatform implements IConcurrentExecutionPlatform  {
	
	private ICodeExecutor _codeExecutor;
	//private Collection<IEngineAddon> _addons;
	private Collection<IMSEStateController> _clockControllers;
	
	public DefaultConcurrentExecutionPlatform(ConcurrentLanguageDefinitionExtension _languageDefinition, IRunConfiguration runConfiguration) throws CoreException 
	{
		super(_languageDefinition, runConfiguration);		
		_codeExecutor = _languageDefinition.instanciateCodeExecutor();
		_clockControllers = _languageDefinition.instanciateMSEStateControllers();
	}


	@Override
	public ICodeExecutor getCodeExecutor() 
	{
		return _codeExecutor;
	}

//	@Override
//	public Iterable<IEngineAddon> getEngineAddons() 
//	{
//		synchronized(_addonLock)
//		{
//			return Collections.unmodifiableCollection(new ArrayList<IEngineAddon>(_addons));
//		}
//	}

	@Override
	public Collection<IMSEStateController> getMSEStateControllers() 
	{
		return _clockControllers;
	}

	@Override
	public void dispose() 
	{
		super.dispose();
		_clockControllers.clear();
	}

	@Override
	public IConcurrentExecutionPlatform asConcurrentExecutionPlatform() {
		if( this instanceof IConcurrentExecutionPlatform) return this;
		else return null;
	}

//	private Object _addonLock = new Object();
//	
//	@Override
//	public void addEngineAddon(IEngineAddon addon) 
//	{
//		synchronized (_addonLock) 
//		{
//			_addons.add(addon);
//		}
//	}
//
//	@Override
//	public void removeEngineAddon(IEngineAddon addon) 
//	{
//		synchronized (_addonLock) 
//		{
//			_addons.remove(addon);
//		}
//	}
	
}
