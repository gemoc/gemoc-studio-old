package org.gemoc.commons.eclipse.ui;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;

public class TreeViewerHelper
{

	public static void resizeColumns(TreeViewer viewer)
	{
	    for (TreeColumn tc : viewer.getTree().getColumns())
		    tc.pack();
	}
	
}
