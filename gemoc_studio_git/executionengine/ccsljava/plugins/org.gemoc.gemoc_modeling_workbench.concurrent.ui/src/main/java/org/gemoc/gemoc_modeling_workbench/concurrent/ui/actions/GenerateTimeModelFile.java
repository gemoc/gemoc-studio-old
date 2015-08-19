package org.gemoc.gemoc_modeling_workbench.concurrent.ui.actions;


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
	protected String getMoCFileExtension() {
		return "timemodel";
	}

}
