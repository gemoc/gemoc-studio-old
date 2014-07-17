package org.gemoc.gemoc_modeling_workbench.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.Dialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyIFileDialog;

public class ChooseQVTOAndGenerateExtendedCCSLFile extends GenerateExtendedCCSLFileAction
{

	/**
	 * Constructor for Action1.
	 */
	public ChooseQVTOAndGenerateExtendedCCSLFile() {
		super();
	}

	@Override
	protected String getTransformationURI() {
		SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
		dialog.setPattern("*.qvto");
		if (dialog.open() == Dialog.OK)
			return "platform:/resource" + ((IResource) dialog.getResult()[0]).getFullPath().toString();
		return null;
	}
	
	@Override
	protected String getFileExtension() {
		return "extendedCCSL";
	}

}
