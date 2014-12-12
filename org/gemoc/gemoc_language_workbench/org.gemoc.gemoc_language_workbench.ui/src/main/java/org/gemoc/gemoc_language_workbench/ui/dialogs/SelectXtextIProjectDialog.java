package org.gemoc.gemoc_language_workbench.ui.dialogs;


import org.eclipse.swt.widgets.Shell;

/**
 * Dialog that allow to select an IProject that can be used as an Xtext project
 * @author dvojtise
 *
 */
public class SelectXtextIProjectDialog extends SelectPluginIProjectWithFileExtensionDialog {

	public SelectXtextIProjectDialog(Shell parentShell) {
		super(parentShell, "xtext");
	}

	

}
