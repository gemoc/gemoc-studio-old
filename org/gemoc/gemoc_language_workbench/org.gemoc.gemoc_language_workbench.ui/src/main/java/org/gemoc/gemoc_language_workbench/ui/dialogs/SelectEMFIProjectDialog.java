package org.gemoc.gemoc_language_workbench.ui.dialogs;


import java.util.Arrays;

import org.eclipse.swt.widgets.Shell;

/**
 * Dialog that allow to select an IProject that can be used as an EMF project
 * @Ie. is a Plugin project containing at least one genmodel or ecore file
 *
 */
public class SelectEMFIProjectDialog extends SelectPluginIProjectWithFileExtensionDialog {

	public SelectEMFIProjectDialog(Shell parentShell) {
		super(parentShell, Arrays.asList("ecore", "genmodel"));
	}

	

}
