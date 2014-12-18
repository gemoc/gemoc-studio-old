package org.gemoc.commons.eclipse.emf;

import org.eclipse.emf.common.util.URI;

public abstract class URIHelper {

	public static String removePlatformScheme(URI uri)
	{
		String result = uri.toString();
		if (uri.isPlatformResource())
		{
			result = uri.toString().replace("platform:/resource", "");
		}		
		else if (uri.isPlatformPlugin())
		{
			result = uri.toString().replace("platform:/plugin", "");
		}
		return result;
	}
	
}
