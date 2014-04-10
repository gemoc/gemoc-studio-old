package org.gemoc.gemoc_commons.ui;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ViewHelper {

	
	public static <ViewType> ViewType retrieveView(String viewId) 
	{
		Class<ViewType> c;
		IViewPart viewPart = ViewHelper.retrieveViewPart(viewId);
		ViewType view = null;
		try {
			view = (ViewType)viewPart;
		} 
		catch(Exception e) {
			
		}
		return view;
	}

	
	/***
	 * Will look after the view.
	 * If not found, will try to show and look for it.
	 * If showing view not possible, return null.
	 * @param viewId
	 * @return The view part if found or null otherwise
	 */
	public static IViewPart retrieveViewPart(String viewId) 
	{
		IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(viewId);
		if (viewPart == null) {
			try 
			{
				viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewId);
			}
			catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return viewPart;		
	}
	
}
