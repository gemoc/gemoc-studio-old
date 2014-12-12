package org.gemoc.commons.eclipse.core.resources;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

public class FileFinderVisitor implements IResourceVisitor {

	/**
	 * Searched file extension
	 * @param fileExtension, must not be null, however it can be the empty string
	 */
	public FileFinderVisitor(String fileExtension) 
	{
		_fileExtension = fileExtension;
	}
	
	private String _fileExtension;
	
	protected List<IFile> _files = new ArrayList<IFile>();
	
	/**
	 * @return the first file found, or null if not file found
	 */
	public IFile getFile() {
		if(_files.isEmpty()) return null;
		return _files.get(0);
	}
	/** 
	 * 
	 * @return a list of the files found
	 */
	public List<IFile> getFiles() {
		return _files;
	}

	@Override
	public boolean visit(IResource resource) throws CoreException {
		boolean mustVisitChild = true;
		if(resource instanceof IFile){
			String resourceExtension = resource.getFileExtension();
			if(resourceExtension == null){
				resourceExtension = "";
			}
			if(resourceExtension.equals(_fileExtension)){
				_files.add((IFile) resource);
			}
			mustVisitChild = false;
		}
		return mustVisitChild;
	}

}
