package org.gemoc.gemoc_modeling_workbench.ui.builder;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_commons.core.resources.AbstractProjectNature;

public class GemocReflectiveModelNature extends AbstractProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "org.gemoc.gemoc_modeling_workbench.ui.gemocReflectiveModelNature";

	@Override
	public void configure() throws CoreException {
		addBuilder(GemocReflectiveModelBuilder.BUILDER_ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeBuilder(GemocReflectiveModelBuilder.BUILDER_ID);
	}
	
}
