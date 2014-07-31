package org.gemoc.gemoc_language_workbench.utils.resourcevisitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * ResourceVisitor that look and gathers ecore files
 * @author dvojtise
 *
 */
public class GenmodelFileFinderResourceVisitor implements IResourceVisitor{
	public List<IFile> genmodelFiles = new ArrayList<IFile>(); 
	@Override
	public boolean visit(IResource resource) throws CoreException {
		boolean mustVisitChild = true;
		if(resource instanceof IFile){
			if(resource.getFileExtension().equals("genmodel")){
				genmodelFiles.add((IFile) resource);
			}
			mustVisitChild = false;
		}
		return mustVisitChild;
	}
	
}