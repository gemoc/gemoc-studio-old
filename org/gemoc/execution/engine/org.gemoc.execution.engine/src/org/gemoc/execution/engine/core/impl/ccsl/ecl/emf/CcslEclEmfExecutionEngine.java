package org.gemoc.execution.engine.core.impl.ccsl.ecl.emf;

import org.gemoc.execution.engine.core.impl.ccsl.ecl.CcslEclBasicExecutionEngine;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;

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

}
