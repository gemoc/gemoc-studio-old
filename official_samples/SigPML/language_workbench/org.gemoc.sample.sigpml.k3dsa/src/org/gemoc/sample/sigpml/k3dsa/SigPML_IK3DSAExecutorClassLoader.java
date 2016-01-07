package org.gemoc.sample.sigpml.k3dsa;

import org.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.api.IK3DSAExecutorClassLoader;

public class SigPML_IK3DSAExecutorClassLoader implements IK3DSAExecutorClassLoader{
	public static void main(String[] args) {
	}

	public static ClassLoader getContextClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
	
	public Class<?> getClassForName(String className)
			throws ClassNotFoundException {
		return Class.forName(className);
	}

	public java.io.InputStream getResourceAsStream(String resourceName) {
		//ClassLoader cl = this.getClass().getClassLoader();
		//InputStream is = ClassLoader.getSystemResourceAsStream(resourceName);
		return Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(resourceName);
	}
}

