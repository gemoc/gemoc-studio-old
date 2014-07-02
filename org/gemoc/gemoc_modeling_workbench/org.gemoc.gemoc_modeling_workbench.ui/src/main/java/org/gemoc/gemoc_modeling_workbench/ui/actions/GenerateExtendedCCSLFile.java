package org.gemoc.gemoc_modeling_workbench.ui.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.api.extension.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.api.extension.LanguageDefinitionExtension;

public class GenerateExtendedCCSLFile extends GenerateExtendedCCSLFileAction {

	/**
	 * Constructor for Action1.
	 */
	public GenerateExtendedCCSLFile() 
	{
		super();
	}

	@Override
	protected String getTransformationURI() 
	{
		//use the extension of the model file
		String languageName = modelUriString.substring(
												modelUriString.lastIndexOf('.') + 1, 
												modelUriString.length());
				
		LanguageDefinition languageDefinition = LanguageDefinitionExtension.findDefinition(languageName);		
		if (languageDefinition == null)
		{
			MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
													"No language found",
													null,
													"No language found for file extension " + languageName + ".",
													MessageDialog.ERROR,
													new String[0],
													-1);
			dialog.open();
			return null;
		}
		String uri = languageDefinition.getQVTOPath();
		if (!uri.startsWith("platform:/plugin"))
			uri = "platform:/plugin" + uri;
		return uri;
	}


}
