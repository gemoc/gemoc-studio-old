package org.gemoc.sample.tfsm.xdsml.engineAddon;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.sample.tfsm.xdsml.Activator;


public class TfsmEngineAddon extends org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon {

	public static final String PRE_START_PREFIX = "pre.start.engine.";
	public static final String GROOVY_SCRIPT_FILE = "groovy.script.file";
	public static final String GROOVY_OPERATION = "groovy.operation";
	
	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
		// Use the engine hook to start a groovy script that is referenced in a property file co-located with the model that will be run
		// this groovy script can start a model specifiv GUI for example
		Properties properties = new Properties();
		String propertyPath = engine.getExecutionContext().getResourceModel().getURI().trimFileExtension().toPlatformString(true).toString()+".properties";
		IFile propertyFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(propertyPath);
		if(propertyFile != null && propertyFile.exists()){
			InputStream inStream;
			try {
				inStream = propertyFile.getContents();
			
				properties.load(inStream);
				
				String groovyScript = properties.getProperty(PRE_START_PREFIX+GROOVY_SCRIPT_FILE);
				String methodName =  properties.getProperty(PRE_START_PREFIX+GROOVY_OPERATION);
				if(groovyScript != null && !groovyScript.isEmpty() && methodName!= null && !methodName.isEmpty()){
					String groovyScriptAbsolutePath = groovyScript.startsWith("platform") ? ResourcesPlugin.getWorkspace().getRoot().findMember(URI.createURI(groovyScript).toPlatformString(true)).getLocation().toString() : groovyScript;
					executeScript(methodName, groovyScriptAbsolutePath);
				}
				
			} catch (Exception e) {
				String errorMessage = e.getClass().getSimpleName() + " when trying to execute a Groovy expression. "+e.getMessage();
//				 Activator.getMessagingSystem().error(errorMessage,
//				 Activator.PLUGIN_ID);
//				 Activator.error(errorMessage, e);
			}
		}
		
	}
	
	public static Object executeScript(String expression, String absolutePathToGroovyControl){
		try {
			GroovyObject groovyObj;
			// use this class class loader, this isn't perfect since the script may use more classe, but this is a start ...
			GroovyClassLoader gcl = new GroovyClassLoader(TfsmEngineAddon.class.getClassLoader());
			Class<?> clazz = null;

			clazz = gcl.parseClass(new File(absolutePathToGroovyControl));

			groovyObj = (GroovyObject) clazz.newInstance();
			Object r = groovyObj.invokeMethod(expression, new Object[] {});
			return r;
		} catch (Exception e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute a Groovy expression";
//			 Activator.getMessagingSystem().error(errorMessage,
//			 Activator.PLUGIN_ID);
//			 Activator.error(errorMessage, e);
		}
		return null;
	}

}
