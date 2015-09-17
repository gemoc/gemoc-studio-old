package org.gemoc.commons.eclipse.ui.dialogs;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.swt.widgets.Shell;

public class SelectPluginIProjectDialog extends SelectAnyIProjectDialog {

	public SelectPluginIProjectDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected boolean select(IResource resource) {
		boolean result = super.select(resource);
		if(resource instanceof IProject){
			// must contain a manifest.mf file
			boolean hasManifestFile = ((IProject)resource).findMember("META-INF/MANIFEST.MF") != null;
			/*
			FileFinderVisitor projectVisitor = new FileFinderVisitor("mf");
			try {
				resource.accept(projectVisitor);
				hasManifestFile = projectVisitor.getFile() != null;
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}*/
			result = result && hasManifestFile;
		}
		return result;
	}
}
