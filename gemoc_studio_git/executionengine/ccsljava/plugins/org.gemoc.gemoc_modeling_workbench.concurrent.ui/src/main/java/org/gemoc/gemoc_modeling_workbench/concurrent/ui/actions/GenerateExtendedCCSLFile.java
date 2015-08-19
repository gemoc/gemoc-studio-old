package org.gemoc.gemoc_modeling_workbench.concurrent.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.gemoc.commons.eclipse.emf.EMFResource;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;

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
		String fileExtension = modelUriString.substring(
												modelUriString.lastIndexOf('.') + 1, 
												modelUriString.length());
			
		List<ConcurrentLanguageDefinitionExtension> applicableLanguageDefinitions = new ArrayList<ConcurrentLanguageDefinitionExtension>();
		for(ConcurrentLanguageDefinitionExtension lde : ConcurrentLanguageDefinitionExtensionPoint.getSpecifications()){
			try{
				String xdsmluri = lde.getXDSMLFilePath();
				if (!xdsmluri.startsWith("platform:/plugin"))
					xdsmluri = "platform:/plugin" + xdsmluri;
				Object o = EMFResource.getFirstContent(xdsmluri);
				if(o != null && o instanceof LanguageDefinition){
					LanguageDefinition ld = (LanguageDefinition)o;
					if(ld.getFileExtensions().contains(fileExtension)){
						applicableLanguageDefinitions.add(lde);
					}
				}
			}
			catch(Exception e){}
		}
		
		ConcurrentLanguageDefinitionExtension selectedLanguageDefinition= null;
		if (applicableLanguageDefinitions.size() == 0)
		{
			MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
													"No applicable language found",
													null,
													"No applicable language found for file extension " + fileExtension + ".",
													MessageDialog.ERROR,
													new String[0],
													-1);
			dialog.open();
			return null;
		}
		else if(applicableLanguageDefinitions.size() == 1){
			selectedLanguageDefinition = applicableLanguageDefinitions.get(0);
		} else {
			
			
			ListDialog dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()); 
			
			dialog.setContentProvider(new ArrayContentProvider());
			dialog.setTitle("Language selection");
			dialog.setMessage("Which language do you want to use");
			dialog.setLabelProvider(new ArrayLabelProvider());
			List<Object[]> input = new ArrayList<Object[]>();
			for(LanguageDefinitionExtension lde :applicableLanguageDefinitions){
				input.add(new Object[]{lde.getName(),lde});
			}
			dialog.setInput(input);
			// user pressed cancel
			if (dialog.open() != Window.OK) {
			    return null;
			}
			Object[] result = dialog.getResult();
			if(result.length == 0){
				MessageDialog dialog2 = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
						"Please select a language",
						null,
						"Please select a language for file extension " + fileExtension + ".",
						MessageDialog.ERROR,
						new String[0],
						-1);
				dialog2.open();
				return null;
			}
			Object[] selected = ((Object[])result[0]);
			selectedLanguageDefinition = (ConcurrentLanguageDefinitionExtension) selected[1];
		}
		
		String uri = selectedLanguageDefinition.getQVTOPath();
		if (!uri.startsWith("platform:/plugin"))
			uri = "platform:/plugin" + uri;
		return uri;
	}

	@Override
	protected String getMoCFileExtension() {
		return "extendedCCSL";
	}
	
	
	static class ArrayLabelProvider extends LabelProvider implements ITableLabelProvider{
		public String getText(Object element) {
		return ((Object[]) element)[0].toString();
		}
		
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
		return null;
		}
		 
		@Override
		public String getColumnText(Object element, int columnIndex) {
			Object[] ss = (Object[]) element;
		return ss[columnIndex].toString();
		}
		 
		}
	

}
