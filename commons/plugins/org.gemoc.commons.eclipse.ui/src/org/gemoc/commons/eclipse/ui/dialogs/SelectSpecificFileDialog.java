package org.gemoc.commons.eclipse.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.commons.eclipse.ui.Activator;

public abstract class SelectSpecificFileDialog extends SelectAnyIFileDialog {

	
	
	@Override
	protected boolean select(IResource resource) {
		boolean result = super.select(resource);
		if(resource instanceof IFile) {			
			FileFinderVisitor finder = instanciateFinder();
			try {
				resource.accept(finder);
				result = finder.getFile() != null;				
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}	
		} 
		return result;
	}

	protected abstract FileFinderVisitor instanciateFinder();
	
}
