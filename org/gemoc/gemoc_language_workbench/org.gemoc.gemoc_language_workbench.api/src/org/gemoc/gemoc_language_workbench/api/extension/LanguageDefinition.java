package org.gemoc.gemoc_language_workbench.api.extension;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public class LanguageDefinition {

	final static public CodeExecutor instanciateCodeExecutor(IConfigurationElement confElement) 
			throws CoreException 
	{
		Object instance = instanciate(confElement, LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
		if (instance instanceof CodeExecutor) {
			return(CodeExecutor) instance;
		}
		return null;
	}
	
	final public static EventExecutor instanciateEventExecutor(IConfigurationElement confElement) 
			throws CoreException 
	{
		Object instance = instanciate(confElement, LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EVENTEXECUTOR_ATT);
		if (instance instanceof EventExecutor) {
			return(EventExecutor) instance;
		}
		return null;
	}
	
	final static public Solver instanciateSolver(IConfigurationElement confElement) 
			throws CoreException 
	{
		Object instance = instanciate(confElement, LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
		if (instance instanceof Solver) {
			return (Solver) instance;
		}
		return null;
	}
	
	final static public FeedbackPolicy instanciateFeedbackPolicy(IConfigurationElement confElement) 
			throws CoreException 
	{
		Object oFeedbackPolicy = instanciate(confElement, LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_FEEDBACKPOLICY_ATT);
		if (oFeedbackPolicy instanceof FeedbackPolicy) {
			return(FeedbackPolicy) oFeedbackPolicy;
		}
		return null;
	}
	
	static private Object instanciate(IConfigurationElement element, String attributeName) 
			throws CoreException
	{
		return element.createExecutableExtension(attributeName);
	}
}
