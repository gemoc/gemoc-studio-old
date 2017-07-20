/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.sigpml.k3dsa;

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.api.IK3DSAExecutorClassLoader;

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

