package org.gemoc.gemoc_language_workbench.api.extension;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Status;
import org.gemoc.gemoc_language_workbench.api.Activator;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;


public class LanguageDefinition {

	private IConfigurationElement _configurationElement;
	
	public LanguageDefinition(IConfigurationElement confElement)
	{
		_configurationElement = confElement;
	}
	
	final public CodeExecutor instanciateCodeExecutor() 
			throws CoreException 
	{
		Object instance = instanciate(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
		if (instance instanceof CodeExecutor) {
			return(CodeExecutor) instance;
		}
		throwCoreException();
		return null;
	}
	
	final public EventExecutor instanciateEventExecutor() 
			throws CoreException 
	{
		Object instance = instanciate(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EVENTEXECUTOR_ATT);
		if (instance instanceof EventExecutor) {
			return(EventExecutor) instance;
		}
		throwCoreException();
		return null;
	}
	
	final public Solver instanciateSolver() 
			throws CoreException 
	{
		Object instance = instanciate(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
		if (instance instanceof Solver) {
			return (Solver) instance;
		}
		throwCoreException();
		return null;
	}
	
	final public FeedbackPolicy instanciateFeedbackPolicy() 
			throws CoreException 
	{
		Object oFeedbackPolicy = instanciate(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_FEEDBACKPOLICY_ATT);
		if (oFeedbackPolicy instanceof FeedbackPolicy) {
			return(FeedbackPolicy) oFeedbackPolicy;
		}
		throwCoreException();
		return null;
	}
	
	private void throwCoreException() 
			throws CoreException
	{
		String message = "Instanciation succeeded but object is not of correct type.";
		CoreException exception = new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
		throw exception;
	}

	private Object instanciate(String attributeName) 
			throws CoreException
	{
		try
		{
			return _configurationElement.createExecutableExtension(attributeName);
		}
		catch(CoreException e)
		{
			String message = "Instanciation of one agent failed (see inner exception).";
			CoreException exception = new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message, e));
			throw exception;
		}
	}
	
	final public String getQVTOPath()
	{
		return _configurationElement.getAttribute(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
	}
	
	final public Collection<IEngineHook> instanciateEngineHooks() 
			throws CoreException 
	{
		HashSet<IEngineHook> engineHooks = new HashSet<IEngineHook>();
		for(IConfigurationElement childConfElement : _configurationElement.getChildren(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF)){
			childConfElement.getName();				
			final Object oEngineHook = childConfElement.createExecutableExtension(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF_ENGINE_HOOK_ATT);
			if(oEngineHook instanceof IEngineHook){
				engineHooks.add((IEngineHook) oEngineHook);
			}
		}
		return engineHooks;
	}

	final public Collection<IClockController> instanciateClockControllers() 
			throws CoreException 
	{
		HashSet<IClockController> eventOccurenceInjectors = new HashSet<IClockController>();
		for(IConfigurationElement childConfElement : _configurationElement.getChildren(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_EVENT_OCCURENCE_INJECTOR_DEFINITION)){
			childConfElement.getName();				
			final Object injector = childConfElement.createExecutableExtension(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_EVENT_OCCURENCE_INJECTOR_CLASS_DEFINITION);
			if(injector instanceof IClockController){
				eventOccurenceInjectors.add((IClockController) injector);
			}
		}
		return eventOccurenceInjectors;
	}
}
