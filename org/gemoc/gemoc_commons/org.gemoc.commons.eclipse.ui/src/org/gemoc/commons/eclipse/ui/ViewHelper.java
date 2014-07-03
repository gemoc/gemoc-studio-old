package org.gemoc.commons.eclipse.ui;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ViewHelper {

	
	/***
	 * Will look after the view.
	 * If not found, will try to show and look for it.
	 * If showing view not possible, return null.
	 * @param viewId
	 * @return The view part if found or null otherwise
	 */
	@SuppressWarnings("unchecked")
	public static <ViewType> ViewType retrieveView(String viewId) 
	{
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
	public static IViewPart retrieveViewPart(final String viewId) 
	{
		RetrieveViewPartRunnable runnable = new RetrieveViewPartRunnable(viewId);
		PlatformUI.getWorkbench()
			.getDisplay()
			.syncExec(runnable);
		return runnable.getViewPart();		
	}
	
	private static class RetrieveViewPartRunnable implements Runnable 
	{

		public RetrieveViewPartRunnable(String viewId)
		{
			_viewId = viewId;
		}
		
		private String _viewId;
		private IViewPart _viewPart = null;
		public IViewPart getViewPart()
		{
			return _viewPart;
		}
		
		@Override
		public void run() {
			_viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(_viewId);
			if (_viewPart == null) 
			{
				try {
					_viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(_viewId);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}
