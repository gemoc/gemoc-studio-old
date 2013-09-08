
package org.gemoc.mocc.model.xtext;

import org.gemoc.mocc.model.xtext.MoCLibStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MoCLibStandaloneSetup extends MoCLibStandaloneSetupGenerated{

	public static void doSetup() {
		new MoCLibStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

