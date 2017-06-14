/*$Id: PreferenceInitializer.java 12145 2010-08-11 07:34:13Z dvojtise $
* Project : org.kermeta.utils.provisionner.eclipse
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 2010
* Authors : 
*			Didier Vojtisek <didier.vojtisek@inria.fr>
*/
package org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.Activator;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		store.setDefault(PreferenceConstants.P_CAPTURE_SYSTEM_ERROUT, true);
		store.setDefault(PreferenceConstants.P_MAX_CONSOLE_OUTPUT, 80000);
		
	}

}
