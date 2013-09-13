/**
 * 
 */
package org.gemoc.execution.engine.core.impl.ccsl.ecl.xtend;

import org.gemoc.execution.engine.core.impl.ccsl.ecl.CcslEclBasicExecutionEngine;
import org.gemoc.execution.engine.executors.impl.xtend.XtendExecutor;

/**
 * @author flatombe
 * 
 */
public class CcslEclXtendExecutionEngine extends CcslEclBasicExecutionEngine {

    public CcslEclXtendExecutionEngine(String ccslFilePath, String jarDsaFolderPath, String jarDependenciesFolderPath,
            String modelPath, String MMpath) {
        super(ccslFilePath, jarDsaFolderPath, jarDependenciesFolderPath, modelPath, MMpath);
        this.executor = new XtendExecutor();
    }

}
