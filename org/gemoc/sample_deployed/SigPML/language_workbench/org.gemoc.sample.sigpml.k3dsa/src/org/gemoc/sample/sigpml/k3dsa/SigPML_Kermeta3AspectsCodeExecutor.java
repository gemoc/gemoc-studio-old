package org.gemoc.sample.sigpml.k3dsa;

import org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl.Kermeta3AspectsCodeExecutor;

public class SigPML_Kermeta3AspectsCodeExecutor extends Kermeta3AspectsCodeExecutor {
	public SigPML_Kermeta3AspectsCodeExecutor() {
		super(new SigPML_IK3DSAExecutorClassLoader(), "org.gemoc.sample.sigpml.k3dsa");
	}

}

