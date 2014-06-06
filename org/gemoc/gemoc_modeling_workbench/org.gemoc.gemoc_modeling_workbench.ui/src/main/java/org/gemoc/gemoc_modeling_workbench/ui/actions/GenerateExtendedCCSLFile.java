package org.gemoc.gemoc_modeling_workbench.ui.actions;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.workbench.modeling.LanguageFinder;

public class GenerateExtendedCCSLFile extends GenerateExtendedCCSLFileAction {

	/**
	 * Constructor for Action1.
	 */
	public GenerateExtendedCCSLFile() {
		super();
	}

	@Override
	protected String getTransformationURI() {
		//use the extension of the model file
		String languageName = modelUriString.substring(modelUriString.lastIndexOf('.')+1, modelUriString.length());
				
		IConfigurationElement confElement = LanguageFinder.findDefinition(languageName);
		
		if (confElement == null)
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
		String uri = confElement.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
		if (!uri.startsWith("platform:/plugin"))
			uri = "platform:/plugin" + uri;
		return uri;
	}


}
