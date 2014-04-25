package org.gemoc.gemoc_language_workbench.utils.ui.dialogs;

import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.ECLFileFinderResourceVisitor;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

public class SelectECLIFileDialog extends SelectSpecificFileDialog {

	@Override
	protected FileFinderVisitor instanciateFinder() {
		return new ECLFileFinderResourceVisitor();
	}

}
