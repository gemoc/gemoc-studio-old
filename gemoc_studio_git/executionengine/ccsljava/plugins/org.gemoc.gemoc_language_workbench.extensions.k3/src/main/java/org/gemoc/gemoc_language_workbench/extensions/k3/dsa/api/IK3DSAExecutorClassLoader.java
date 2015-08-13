package org.gemoc.gemoc_language_workbench.extensions.k3.dsa.api;

import java.io.InputStream;

public interface IK3DSAExecutorClassLoader {

	public Class<?> getClassForName(String className)  throws ClassNotFoundException ;
	public InputStream getResourceAsStream(String resourceName);
}
