package org.gemoc.gemoc_language_workbench.ui.dialogs;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.utils.Activator;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

/**
 * Dialog that allow to select an IProject that can be used as a Sirius Viewpoint specification project
 * @author dvojtise
 *
 */
public class SelectODesignIProjectDialog extends SelectAnyIProjectDialog {

	public SelectODesignIProjectDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected boolean select(IResource resource) {
		boolean result = super.select(resource);
		// must contain an odesign file
		if(resource instanceof IProject){
			FileFinderVisitor projectVisitor = new FileFinderVisitor("odesign");
			try {
				resource.accept(projectVisitor);
				result = result && projectVisitor.getFiles().size() > 0;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		return result;
	}

}
