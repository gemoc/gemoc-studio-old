package org.gemoc.gemoc_commons.resource.merging;

import org.eclipse.core.resources.IFile;

public class ResourcesMergeScripting {

	public static ResourceMerger allResourcesFrom(IFile inputFile) {
		return new ResourceMerger(inputFile);
	}

}
