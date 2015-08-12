package org.gemoc.commons.eclipse.pde.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.pde.internal.ui.wizards.tools.ConvertProjectToPluginOperation;

public class PluginConverter {

	
	final static public void convert(IProject project) 
			throws InvocationTargetException, InterruptedException
	{
		ConvertProjectToPluginOperation convertOperation = new ConvertProjectToPluginOperation(new IProject[]{project}, false);
		convertOperation.run(new NullProgressMonitor());
	}
	
}
