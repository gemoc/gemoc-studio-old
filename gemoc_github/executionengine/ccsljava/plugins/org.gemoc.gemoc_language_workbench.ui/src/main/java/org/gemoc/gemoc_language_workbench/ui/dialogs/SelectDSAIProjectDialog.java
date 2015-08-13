package org.gemoc.gemoc_language_workbench.ui.dialogs;

import java.util.Arrays;

import org.eclipse.swt.widgets.Shell;

public class SelectDSAIProjectDialog extends SelectPluginIProjectWithFileExtensionDialog {

	public SelectDSAIProjectDialog(Shell parentShell) {
		super(parentShell, Arrays.asList("kp","xtend","k3sle"));
	}

}
