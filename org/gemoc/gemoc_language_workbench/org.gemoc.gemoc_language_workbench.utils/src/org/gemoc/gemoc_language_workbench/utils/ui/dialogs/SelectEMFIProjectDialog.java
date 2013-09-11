package org.gemoc.gemoc_language_workbench.utils.ui.dialogs;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.utils.Activator;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.EcoreFileFinderResourceVisitor;

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
			EcoreFileFinderResourceVisitor ecoreProjectVisitor = new EcoreFileFinderResourceVisitor();
			try {
				resource.accept(ecoreProjectVisitor);
				result = result && ecoreProjectVisitor.ecoreFiles.size() > 0;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		// TODO project must have java nature 
		return result;
	}

}
