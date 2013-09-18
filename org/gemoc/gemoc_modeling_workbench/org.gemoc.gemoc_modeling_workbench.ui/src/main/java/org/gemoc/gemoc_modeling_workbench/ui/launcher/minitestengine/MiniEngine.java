package org.gemoc.gemoc_modeling_workbench.ui.launcher.minitestengine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.gemoc.gemoc_language_workbench.ui.api.IXDSMLExecutor;
import org.gemoc.gemoc_language_workbench.ui.api.IXDSMLInitializer;
import org.gemoc.gemoc_language_workbench.ui.api.IXDSMLModelLoader;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

public class MiniEngine {
	
	protected IXDSMLModelLoader modelLoader;
	protected IXDSMLInitializer languageInitializer;
	protected IXDSMLExecutor languageDSAExecutor;
	
	
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
			if(omodelLoader instanceof IXDSMLModelLoader){
				this.modelLoader = (IXDSMLModelLoader) omodelLoader;
			}
			final Object oinitializer = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT);
			if(oinitializer instanceof IXDSMLInitializer){
				this.languageInitializer = (IXDSMLInitializer) oinitializer;
			}

			final Object oexecutor = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
			if(oexecutor instanceof IXDSMLExecutor){
				this.languageDSAExecutor = (IXDSMLExecutor) oexecutor;
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
		    	  modelLoader.loadModel(modelURI);
		    	  languageDSAExecutor.execute("");
		      }
		    };
		    SafeRunner.run(runnable);
		
	}
	

}
