package org.gemoc.gemoc_language_workbench.utils.ui.dialogs;

import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.AIRDFileFinderResourceVisitor;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

public class SelectAIRDIFileDialog extends SelectSpecificFileDialog {

	@Override
	protected FileFinderVisitor instanciateFinder() {
		return new AIRDFileFinderResourceVisitor();
	}
	
}
