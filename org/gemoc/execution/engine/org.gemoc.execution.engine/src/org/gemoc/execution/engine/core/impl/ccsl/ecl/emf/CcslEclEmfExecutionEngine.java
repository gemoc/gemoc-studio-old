package org.gemoc.execution.engine.core.impl.ccsl.ecl.emf;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.dsa.EmfExecutor;
import org.gemoc.execution.engine.core.impl.ccsl.ecl.CcslEclBasicExecutionEngine;

/**
 * An implementation of the engine using the EMF Executor, the ECL events, the
 * CCSL solver and the EasyGoing Feedback Policy.
 * 
 * @author flatombe
 * 
 */
public class CcslEclEmfExecutionEngine extends CcslEclBasicExecutionEngine {

    public CcslEclEmfExecutionEngine(String ccslFilePath, String jarDsaFolderPath, String jarDependenciesFolderPath,
            String modelPath, String MMpath) {
        super(ccslFilePath, jarDsaFolderPath, jarDependenciesFolderPath, modelPath, MMpath);
        this.executor = new EmfExecutor(this.modelRoot);
    }
    
    public CcslEclEmfExecutionEngine(String languageName) throws CoreException{
    	super(languageName);
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
		    	  modelRoot = res.getContents().get(0);
		    	  //Object o = res.getContents().get(0);
		    	  //languageDSAExecutor.execute(o, "start");
		    	  runOneStep();
		      }
		    };
		    SafeRunner.run(runnable);
		
	}

}
