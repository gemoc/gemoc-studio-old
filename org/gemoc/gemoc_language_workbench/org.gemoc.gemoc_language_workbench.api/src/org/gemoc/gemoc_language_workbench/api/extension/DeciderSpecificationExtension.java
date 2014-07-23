package org.gemoc.gemoc_language_workbench.api.extension;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class DeciderSpecificationExtension {

	public static final String GEMOC_DECIDER_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.deciders";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_NAME = "Name";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_CLASS = "Class";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_Description = "Description";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_ICONPATH = "Icon";

	
	static public Collection<DeciderSpecification> getSpecifications()
	{
		IConfigurationElement[] confElements = Platform.getExtensionRegistry().getConfigurationElementsFor(GEMOC_DECIDER_EXTENSION_POINT);
		ArrayList<DeciderSpecification> specs = new ArrayList<DeciderSpecification>();
		for (int i = 0; i < confElements.length; i++) 
		{
			DeciderSpecification s = new DeciderSpecification(confElements[i]);
			specs.add(s);
		}	
		return specs;
	}
	
}
