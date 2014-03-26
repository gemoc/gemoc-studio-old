package org.gemoc.gemoc_language_workbench.utils.resourcevisitors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

public class AIRDFileFinderResourceVisitor implements IResourceVisitor{
	
	public IFile eclFile = null; 
	@Override
	public boolean visit(IResource resource) throws CoreException {
		boolean mustVisitChild = true;
		if(resource instanceof IFile){
			if(resource.getFileExtension().equals("aird")){
				eclFile = ((IFile) resource);
			}
			mustVisitChild = false;
		}
		return mustVisitChild;
	}
	

}
