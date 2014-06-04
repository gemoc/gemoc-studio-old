package org.gemoc.gemoc_language_workbench.ui.dse;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_commons.core.resources.AbstractProjectNature;

public class GemocDSENature extends AbstractProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "org.gemoc.gemoc_language_workbench.ui.dse_nature";

	@Override
	public void configure() throws CoreException {
		addBuilder(GemocDSEBuilder.BUILDER_ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeBuilder(GemocDSEBuilder.BUILDER_ID);
	}

}
