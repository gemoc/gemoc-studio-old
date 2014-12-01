package org.gemoc.commons.eclipse.emf;

import org.eclipse.emf.common.util.URI;

public abstract class URIHelper {

	public static String removePlatformResource(URI uri)
	{
		String result = uri.toString();
		if (uri.isPlatformResource())
		{
			result = uri.toString().replace("platform:/resource", "");
		}
		return result;
	}
	
}
