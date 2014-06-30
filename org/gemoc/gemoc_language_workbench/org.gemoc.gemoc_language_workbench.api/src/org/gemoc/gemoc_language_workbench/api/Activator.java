package org.gemoc.gemoc_language_workbench.api;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.kermeta.utils.systemservices.eclipse.api.ConsoleLogLevel;
import org.kermeta.utils.systemservices.eclipse.api.EclipseMessagingSystem;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	
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

	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.gemoc_language_workbench.api"; //$NON-NLS-1$

	protected static EclipseMessagingSystem messagingSystem = null;

	public static void warn(String msg, Throwable e) {
		Activator.getDefault().getLog()
				.log(new Status(Status.WARNING, PLUGIN_ID, Status.OK, msg, e));
	}

	public static void error(String msg, Throwable e) {
		Activator.getDefault().getLog()
				.log(new Status(Status.ERROR, PLUGIN_ID, Status.OK, msg, e));
	}

	public static EclipseMessagingSystem getMessagingSystem() {
		if (messagingSystem == null) {
			messagingSystem = new EclipseMessagingSystem(PLUGIN_ID, "GEMOC API");
			((EclipseMessagingSystem) messagingSystem)
					.setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
		}
		return messagingSystem;
	}

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
