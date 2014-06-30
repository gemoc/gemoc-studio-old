package org.gemoc.workbench.modeling;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class LanguageFinder {

	static public IConfigurationElement findDefinition(String languageName)
	{
		IConfigurationElement confElement = null;
		IConfigurationElement[] confElements = Platform.getExtensionRegistry().getConfigurationElementsFor(org.gemoc.gemoc_language_workbench.api.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_NAME);
		// retrieve the extension for the chosen language
		for (int i = 0; i < confElements.length; i++) {
			if(confElements[i].getAttribute("name").toUpperCase().equals(languageName.toUpperCase())){
				confElement =confElements[i];
			}
		}		
		return confElement;
	}
	
}
