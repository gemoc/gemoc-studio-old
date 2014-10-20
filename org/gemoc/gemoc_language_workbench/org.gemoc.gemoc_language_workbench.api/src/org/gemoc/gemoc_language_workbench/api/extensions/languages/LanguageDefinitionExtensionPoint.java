package org.gemoc.gemoc_language_workbench.api.extensions.languages;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.ExtensionPoint;

public class LanguageDefinitionExtensionPoint extends ExtensionPoint<LanguageDefinitionExtension>
{


	public static final String GEMOC_LANGUAGE_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.xdsml";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF = "XDSML_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_NAME_ATT = "name";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT = "initializer_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT = "modelLoader_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT = "solver_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT = "codeExecutor_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EVENTEXECUTOR_ATT = "eventExecutor_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_PATH_ATT = "mocEventsResourcePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT = "domainSpecificEventsResourcePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_XDSML_FILE_PATH_ATT = "xdsmlFilePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MODEL_OF_EXECUTION_BUILDER_ATT = "modelOfExecutionBuilder";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT = "toCCSLQVTOFilePath";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF = "Engine_hook_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_HOOK_DEF_ENGINE_HOOK_ATT = "engineHook_class";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_EVENT_OCCURENCE_INJECTOR_DEFINITION = "Event_Occurence_Injector_Definition";
	public static final String GEMOC_LANGUAGE_EXTENSION_POINT_EVENT_OCCURENCE_INJECTOR_CLASS_DEFINITION= "Event_Occurence_Injector_Class";
	
	
	protected LanguageDefinitionExtensionPoint() 
	{
		super(LanguageDefinitionExtension.class);
	}

	private static LanguageDefinitionExtensionPoint _singleton;
	
	private static LanguageDefinitionExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new LanguageDefinitionExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<LanguageDefinitionExtension> getSpecifications() 
	{
		return getExtensionPoint().internal_getSpecifications();
	}
	
	static public LanguageDefinitionExtension findDefinition(String languageName)
	{
		for (LanguageDefinitionExtension extension : getSpecifications())
		{
			if (extension.getName().equals(languageName))
			{
				return extension;
			}
		}
		return null;
	}


	@Override
	protected String getExtensionPointName()
	{
		return GEMOC_LANGUAGE_EXTENSION_POINT;
	}
		
}
