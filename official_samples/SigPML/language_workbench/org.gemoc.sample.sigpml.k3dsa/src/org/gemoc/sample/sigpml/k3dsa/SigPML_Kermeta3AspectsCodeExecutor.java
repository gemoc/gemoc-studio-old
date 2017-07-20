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

import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.extensions.k3.dsa.impl.Kermeta3AspectsCodeExecutor;

public class SigPML_Kermeta3AspectsCodeExecutor extends Kermeta3AspectsCodeExecutor {
	public SigPML_Kermeta3AspectsCodeExecutor() {
		super(new SigPML_IK3DSAExecutorClassLoader(), "org.gemoc.sample.sigpml.k3dsa");
	}

}

