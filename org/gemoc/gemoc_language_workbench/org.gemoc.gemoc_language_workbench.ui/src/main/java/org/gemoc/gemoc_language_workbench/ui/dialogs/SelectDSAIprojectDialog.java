package org.gemoc.gemoc_language_workbench.ui.dialogs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.resourcevisitors.KpFileFinderResourceVisitor;

public class SelectDSAIprojectDialog extends SelectAnyIProjectDialog {

	public SelectDSAIprojectDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected boolean select(IResource resource) {
		boolean result = super.select(resource);
		// must contain an kp file (meaning kermeta project)
		if(resource instanceof IProject){
			KpFileFinderResourceVisitor kpProjectVisitor = new KpFileFinderResourceVisitor();
			try {
				resource.accept(kpProjectVisitor);
				result = result && kpProjectVisitor.kpFiles.size() > 0;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		// TODO project must have java nature 
		return result;
	}
}
