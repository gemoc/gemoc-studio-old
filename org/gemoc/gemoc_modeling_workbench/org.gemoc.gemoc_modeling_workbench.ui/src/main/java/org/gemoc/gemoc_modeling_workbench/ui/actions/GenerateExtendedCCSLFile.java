package org.gemoc.gemoc_modeling_workbench.ui.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.utils.ccsl.QvtoTransformationPerformer;
import org.gemoc.workbench.modeling.LanguageFinder;

public class GenerateExtendedCCSLFile implements IObjectActionDelegate {

	private IFile modelFile=null;
	private String qvtoUriString;
	private String modelUriString;
	/**
	 * Constructor for Action1.
	 */
	public GenerateExtendedCCSLFile() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	private void doQvToTransfo(){
		int numberOfCharToRemove = modelFile.getFullPath().toString().length() - modelFile.getFileExtension().length() -1;
		String outputPath = modelFile.getFullPath().toString().substring(0, numberOfCharToRemove) + "_executionModel.extendedCCSL";
		QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
		performer.run(qvtoUriString, modelUriString, outputPath);
	}
	
	
	private void createCCSLModel() {
		if (modelUriString == null || modelUriString.isEmpty()) {
			return;
		}
		
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
		} else {
			//get the Qvto file
			qvtoUriString = confElement.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
			doQvToTransfo();			
		}
		return;
	}
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
	    modelUriString = modelFile.getProject().getName()+"/"+modelFile.getProjectRelativePath().toOSString();	
		createCCSLModel();
	}

	/**path
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		modelFile=null;
		if (selection instanceof TreeSelection) {
			TreeSelection ts = (TreeSelection) selection;
			Iterator it = ts.iterator();
			while(it.hasNext()){
				Object o = it.next();
				if (o instanceof IFile) {
//					IFile f = (IFile)o;
//					if (f.getFileExtension().compareTo("qvto")==0){
//						qvtoFile = (IFile) o;
//					}else{
						modelFile = (IFile) o;
//					}
					
					
				}
			}
			
		}
	}

}
