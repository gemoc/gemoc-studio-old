package org.gemoc.gemoc_language_workbench.ui.dialogs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.utils.Activator;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

public class SelectDSAIProjectDialog extends SelectAnyIProjectDialog {

	public SelectDSAIProjectDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected boolean select(IResource resource) {
		boolean result = super.select(resource);
		if(resource instanceof IProject){
			// must contain a kp file (meaning kermeta 2 project)
			boolean hasKpFile = false;
			boolean hasXTendFile = false;
			FileFinderVisitor kpProjectVisitor = new FileFinderVisitor("kp");
			try {
				resource.accept(kpProjectVisitor);
				hasKpFile =  kpProjectVisitor.getFile() != null;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
			// or must contains xtend files // TODO must find a more precise way to detect k3 projects
			FileFinderVisitor xtendProjectVisitor = new FileFinderVisitor("xtend");
			try {
				resource.accept(xtendProjectVisitor);
				hasXTendFile = xtendProjectVisitor.getFile() != null;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
			result = result && (hasKpFile || hasXTendFile);
		}
		// TODO project must have java nature 
		return result;
	}
}
