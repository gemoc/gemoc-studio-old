package org.gemoc.gemoc_language_workbench.ui.activeFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.gemoc_language_workbench.ui.Activator;

public class ActiveFileGenmodel extends ActiveFileEcore {

	public ActiveFileGenmodel(IProject gemocLanguageProject) {
		super(gemocLanguageProject);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IFile getActiveFile() {
		IProject projectWithGenmodel = this.getProject(this.gemocLanguageProject);
		FileFinderVisitor genmodelFinder = new FileFinderVisitor("genmodel");
		
		try {

			projectWithGenmodel.accept(genmodelFinder);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}

		if(genmodelFinder.getFiles().size() > 0){
			return genmodelFinder.getFiles().get(0);
		} else {
			return null;
		}
	}

}
