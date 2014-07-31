package org.gemoc.gemoc_language_workbench.ui.dialogs;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.utils.Activator;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

/**
 * Dialog that allow to select an IProject that can be used as an EMF project
 * @author dvojtise
 *
 */
public class SelectEMFIProjectDialog extends SelectAnyIProjectDialog {

	public SelectEMFIProjectDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected boolean select(IResource resource) {
		boolean result = super.select(resource);
		// must contain an ecore file
		if(resource instanceof IProject){
			FileFinderVisitor ecoreProjectVisitor = new FileFinderVisitor("ecore");
			try {
				resource.accept(ecoreProjectVisitor);
				result = result && ecoreProjectVisitor.getFiles().size() > 0;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		// TODO project must have java nature 
		return result;
	}

}
