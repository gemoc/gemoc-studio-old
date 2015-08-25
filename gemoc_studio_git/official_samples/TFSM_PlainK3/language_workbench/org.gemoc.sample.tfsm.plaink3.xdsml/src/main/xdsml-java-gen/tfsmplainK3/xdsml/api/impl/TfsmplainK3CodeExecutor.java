/* GENERATED FILE, do not modify manually                                                    *
 * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */
package tfsmplainK3.xdsml.api.impl;
import org.gemoc.execution.engine.commons.dsa.executors.CodeExecutorDispatcher;
public class TfsmplainK3CodeExecutor extends CodeExecutorDispatcher 
		implements org.gemoc.gemoc_language_workbench.extensions.k3.dsa.api.IK3DSAExecutorClassLoader  {
	public TfsmplainK3CodeExecutor(){
	    // add K3 DSA specific executor
		addExecutor(new org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl.Kermeta3AspectsCodeExecutor(this,
			"org.gemoc.sample.tfsm.plaink3.dsa"));
		// fall back executor : search classic java method
		addExecutor(new org.gemoc.execution.engine.commons.dsa.executors.JavaCodeExecutor());
	}
	public String getDSAProjectName(){
		//TODO please implement
		return "";
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