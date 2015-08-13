package org.gemoc.gemoc_language_workbench.api.core;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public interface IFutureAction {

	ModelSpecificEvent getTriggeringMSE();

	void perform();

}
