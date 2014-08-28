package org.gemoc.gemoc_modeling_workbench.ui.actions;


public class GenerateTimeModelFile extends GenerateExtendedCCSLFile
{

	/**
	 * Constructor for Action1.
	 */
	public GenerateTimeModelFile() 
	{
		super();
	}

	@Override
	protected String getFileExtension() {
		return "timemodel";
	}

}
