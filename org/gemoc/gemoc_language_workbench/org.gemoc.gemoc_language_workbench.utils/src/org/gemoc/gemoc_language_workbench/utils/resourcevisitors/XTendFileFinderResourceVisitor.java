package org.gemoc.gemoc_language_workbench.utils.resourcevisitors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

public class XTendFileFinderResourceVisitor implements IResourceVisitor{
	
	public IFile xtendFiles = null; 
	@Override
	public boolean visit(IResource resource) throws CoreException {
		boolean mustVisitChild = true;
		if(resource instanceof IFile){
			if(resource.getFileExtension().equals("xtend")){
				xtendFiles = ((IFile) resource);
			}
			mustVisitChild = false;
		}
		return mustVisitChild;
	}
	

}
