package org.gemoc.commons.eclipse.core.resources;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class Marker {

	static public void addMarker(IResource resource, String markerType, String message, int severity) throws CoreException
	{
		addMarker(resource, markerType, message, -1, severity);
	}

	static public void addMarker(IResource resource, String markerType, String message, int lineNumber, int severity) throws CoreException
	{
		IMarker marker = resource.createMarker(markerType);
		marker.setAttribute(IMarker.MESSAGE, message);
		marker.setAttribute(IMarker.SEVERITY, severity);
		if (lineNumber == -1) {
			lineNumber = 1;
		}
		marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
	}
	
	static public void removeMarkers(IResource resource, String markerType) throws CoreException
	{
		resource.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE);
	}
}
