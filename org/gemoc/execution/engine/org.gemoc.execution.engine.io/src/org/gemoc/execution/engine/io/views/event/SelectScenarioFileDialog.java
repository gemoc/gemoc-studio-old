package org.gemoc.execution.engine.io.views.event;

import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectSpecificFileDialog;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

public class SelectScenarioFileDialog extends SelectSpecificFileDialog {

	@Override
	protected FileFinderVisitor instanciateFinder() {
		return new FileFinderVisitor("scenario");
	}
}
