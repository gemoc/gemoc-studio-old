package org.gemoc.gemoc_language_workbench.api.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class LanguageDefinitionExtension
{

	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_NAME = "org.gemoc.gemoc_language_workbench.xdsml";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF = "XDSML_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT = "initializer_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT = "modelLoader_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT = "solver_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT = "codeExecutor_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EVENTEXECUTOR_ATT = "eventExecutor_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_FEEDBACKPOLICY_ATT = "feedbackPolicy_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_PATH_ATT = "mocEventsResourcePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT = "domainSpecificEventsResourcePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_XDSML_FILE_PATH_ATT = "xdsmlFilePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MODEL_OF_EXECUTION_BUILDER_ATT = "modelOfExecutionBuilder";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT = "toCCSLQVTOFilePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF = "Engine_hook_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF_ENGINE_HOOK_ATT = "engineHook_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_EVENT_OCCURENCE_INJECTOR_DEFINITION = "Event_Occurence_Injector_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_EVENT_OCCURENCE_INJECTOR_CLASS_DEFINITION= "Event_Occurence_Injector_Class";
	
	
	static public IConfigurationElement findDefinition(String languageName)
	{
		IConfigurationElement confElement = null;
		IConfigurationElement[] confElements = Platform.getExtensionRegistry().getConfigurationElementsFor(GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		// retrieve the extension for the chosen language
		for (int i = 0; i < confElements.length; i++) 
		{
			if(confElements[i].getAttribute("name").toUpperCase().equals(languageName.toUpperCase()))
			{
				confElement =confElements[i];
			}
		}		
		return confElement;
	}
	
}
