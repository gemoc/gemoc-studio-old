package org.gemoc.gemoc_language_workbench.utils.resourcevisitors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

public class FileFinderVisitor implements IResourceVisitor {

	public FileFinderVisitor(String fileExtension) 
	{
		_fileExtension = fileExtension;
	}
	
	private String _fileExtension;
	private IFile _file;
	
	public IFile getFile() {
		return _file;
	}

	@Override
	public boolean visit(IResource resource) throws CoreException {
		boolean mustVisitChild = true;
		if(resource instanceof IFile){
			if(resource.getFileExtension().equals(_fileExtension)){
				_file = ((IFile) resource);
			}
			mustVisitChild = false;
		}
		return mustVisitChild;
	}

}
