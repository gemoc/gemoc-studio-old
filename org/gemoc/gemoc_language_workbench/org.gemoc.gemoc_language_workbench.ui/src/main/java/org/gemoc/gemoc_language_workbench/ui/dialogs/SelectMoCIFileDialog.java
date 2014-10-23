package org.gemoc.gemoc_language_workbench.ui.dialogs;

import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.commons.eclipse.ui.dialogs.SelectSpecificFileDialog;


public class SelectMoCIFileDialog extends SelectSpecificFileDialog {

	@Override
	protected FileFinderVisitor instanciateFinder() {
		return new FileFinderVisitor("moccml");
	}

}
