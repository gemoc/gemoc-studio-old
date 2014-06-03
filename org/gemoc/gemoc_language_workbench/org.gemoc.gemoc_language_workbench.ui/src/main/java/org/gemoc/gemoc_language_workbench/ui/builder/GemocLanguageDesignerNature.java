package org.gemoc.gemoc_language_workbench.ui.builder;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_commons.core.resources.AbstractProjectNature;

public class GemocLanguageDesignerNature extends AbstractProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "org.gemoc.gemoc_language_workbench.ui.gemocLanguageDesignerNature";

	@Override
	public void configure() throws CoreException {
		addBuilder(GemocLanguageDesignerBuilder.BUILDER_ID);
	}

	@Override
	public void deconfigure() throws CoreException {
		removeBuilder(GemocLanguageDesignerBuilder.BUILDER_ID);
	}
	
}
