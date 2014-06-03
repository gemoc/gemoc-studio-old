package org.gemoc.dse.ecl.moc2as.ui.builder;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_commons.core.resources.AbstractProjectNature;

public class GemocDSENature extends AbstractProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "org.gemoc.dse.ecl.moc2as.ui.gemocDSENature";

	@Override
	public void configure() throws CoreException {
		addBuilder(GemocDSEBuilder.BUILDER_ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeBuilder(GemocDSEBuilder.BUILDER_ID);
	}

}
