/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */
package org.gemoc.sample.tfsm.raspberry.engine;
import org.gemoc.execution.engine.commons.dsa.executors.CodeExecutorDispatcher;
public class TfsmCodeExecutor extends CodeExecutorDispatcher 
		implements org.gemoc.gemoc_language_workbench.extensions.k3.dsa.api.IK3DSAExecutorClassLoader  {
	public TfsmCodeExecutor(){
	    // add K3 DSA specific executor
		addExecutor(new org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl.Kermeta3AspectsCodeExecutor(this,
			"org.gemoc.sample.tfsm.k3dsa"));
		// fall back executor : search classic java method
		addExecutor(new org.gemoc.execution.engine.commons.dsa.executors.JavaCodeExecutor());
	}
   @Override
	public Class<?> getClassForName(String className) throws ClassNotFoundException {
		return Class.forName(className);
	}
	@Override
	public java.io.InputStream getResourceAsStream(String resourceName) {
		//this.getClass().getResourceAsStream(resourceName);
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName);
	}
}