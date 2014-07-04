package org.gemoc.gemoc_modeling_workbench.ui.actions;


public class ChooseQVTOAndGenerateTimeModelFile extends ChooseQVTOAndGenerateExtendedCCSLFile {

	/**
	 * Constructor for Action1.
	 */
	public ChooseQVTOAndGenerateTimeModelFile() {
		super();
	}

	@Override
	protected String getFileExtension() {
		return "timemodel";
	}
	
}
