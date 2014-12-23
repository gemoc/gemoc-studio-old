package org.gemoc.gemoc_language_workbench.ui.dialogs;

import java.util.Arrays;

import org.eclipse.swt.widgets.Shell;

public class SelectDSEIProjectDialog extends SelectPluginIProjectWithFileExtensionDialog {

	public SelectDSEIProjectDialog(Shell parentShell) {
		super(parentShell, Arrays.asList("ecl"));
	}

}
