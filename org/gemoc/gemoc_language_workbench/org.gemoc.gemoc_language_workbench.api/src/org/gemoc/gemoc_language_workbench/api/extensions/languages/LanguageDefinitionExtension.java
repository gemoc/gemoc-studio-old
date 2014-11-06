package org.gemoc.gemoc_language_workbench.api.extensions.languages;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;


public class LanguageDefinitionExtension extends Extension
{

	
	final public ICodeExecutor instanciateCodeExecutor() 
			throws CoreException 
	{
		Object instance = instanciate(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
		if (instance instanceof ICodeExecutor) {
			return(ICodeExecutor) instance;
		}
		throwInstanciationCoreException();
		return null;
	}
		
	final public Solver instanciateSolver() 
			throws CoreException 
	{
		Object instance = instanciate(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
		if (instance instanceof Solver) {
			return (Solver) instance;
		}
		throwInstanciationCoreException();
		return null;
	}
	
	final public IModelLoader instanciateModelLoader() 
			throws CoreException 
	{
		Object instance = instanciate(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
		if (instance instanceof IModelLoader) {
			return (IModelLoader) instance;
		}
		throwInstanciationCoreException();
		return null;
	}
	
	final public String getQVTOPath()
	{
		return _configurationElement.getAttribute(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
	}
	
	final public Collection<IEngineHook> instanciateEngineHooks() 
			throws CoreException 
	{
		HashSet<IEngineHook> engineHooks = new HashSet<IEngineHook>();
		for(IConfigurationElement childConfElement : _configurationElement.getChildren(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF)){
			childConfElement.getName();				
			final Object oEngineHook = childConfElement.createExecutableExtension(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF_ENGINE_HOOK_ATT);
			if(oEngineHook instanceof IEngineHook){
				engineHooks.add((IEngineHook) oEngineHook);
			}
		}
		return engineHooks;
	}

	final public Collection<IMSEStateController> instanciateMSEStateControllers() 
			throws CoreException 
	{
		HashSet<IMSEStateController> controllers = new HashSet<IMSEStateController>();
		for(IConfigurationElement childConfElement : _configurationElement.getChildren(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_DEFINITION)){
			childConfElement.getName();				
			final Object c = childConfElement.createExecutableExtension(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_CLASS_DEFINITION);
			if(c instanceof IMSEStateController){
				controllers.add((IMSEStateController) c);
			}
		}
		return controllers;
	}

	public String getName() 
	{
		return getAttribute(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_NAME_ATT);
	}
}
