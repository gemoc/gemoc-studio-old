package org.gemoc.gemoc_modeling_workbench.ui.launcher.minitestengine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

public class MiniEngine {
	
	protected ModelLoader modelLoader;
	protected LanguageInitializer languageInitializer;
	protected IDSAExecutor languageDSAExecutor;
	
	
	public MiniEngine(String languageName ) throws CoreException{
		IConfigurationElement confElement = null;
		IConfigurationElement[] confElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.gemoc.gemoc_language_workbench.xdsml");
		// retrieve the extension for the chosen language
		for (int i = 0; i < confElements.length; i++) {
			if(confElements[i].getAttribute("name").equals(languageName)){
				confElement =confElements[i];
			}
		}
		// get the extension objects
		if(confElement != null){
			final Object omodelLoader = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
			if(omodelLoader instanceof ModelLoader){
				this.modelLoader = (ModelLoader) omodelLoader;
			}
			final Object oinitializer = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT);
			if(oinitializer instanceof LanguageInitializer){
				this.languageInitializer = (LanguageInitializer) oinitializer;
			}

			final Object oexecutor = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
			if(oexecutor instanceof IDSAExecutor){
				this.languageDSAExecutor = (IDSAExecutor) oexecutor;
			}
		}
	}
	
	public void launchEngine(final String modelURI){
		ISafeRunnable runnable = new ISafeRunnable() {
		      @Override
		      public void handleException(Throwable e) {
		        Activator.error(e.getMessage(), e);
		      }

		      @Override
		      public void run() throws Exception {
		    	  languageInitializer.initialize();
		    	  Resource res = modelLoader.loadModel(modelURI);
		    	  Object o = res.getContents().get(0);
		    	  System.out.println("launchEngine.run loadedobject ="+o);
		    	  System.out.println("launchEngine.run execute getname="+languageDSAExecutor.execute(o, "getName", null));
		    	  languageDSAExecutor.execute(o, "start", null);
		      }
		    };
		    SafeRunner.run(runnable);
		
	}
	

}
