package org.gemoc.commons.eclipse.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;

public class TableViewerHelper
{

	public static void resizeColumns(TableViewer viewer)
	{
	    for (TableColumn tc : viewer.getTable().getColumns())
		    tc.pack();
	}
	
}
