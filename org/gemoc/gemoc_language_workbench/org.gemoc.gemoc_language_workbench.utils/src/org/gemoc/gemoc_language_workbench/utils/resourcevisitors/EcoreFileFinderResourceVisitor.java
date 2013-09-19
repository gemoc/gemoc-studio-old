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
public class EcoreFileFinderResourceVisitor implements IResourceVisitor{
	public List<IFile> ecoreFiles = new ArrayList<IFile>(); 
	@Override
	public boolean visit(IResource resource) throws CoreException {
		boolean mustVisitChild = true;
		if(resource instanceof IFile){
			if(resource.getFileExtension().equals("ecore")){
				ecoreFiles.add((IFile) resource);
			}
			mustVisitChild = false;
		}
		return mustVisitChild;
	}
	
}