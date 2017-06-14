/*$Id: PropertyNotFoundException.java,v 1.2 2007-08-02 17:12:46 dvojtise Exp $
* Project : fr.irisa.triskell.kermeta.kpm
* File : 	sdfg.java
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : Feb 20, 2007
* Authors : ftanguy
*/
package org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.helper;

import org.eclipse.core.resources.IResource;



@SuppressWarnings("serial")
public class PropertyNotFoundException extends Exception {

	private String qualifiedNameProperty = "";
	private IResource resource;
	
	public PropertyNotFoundException(IResource resource, String qualifiedNameProperty) {
		this.resource = resource;
		this.qualifiedNameProperty = qualifiedNameProperty;
	}
	
	@Override
	public String getMessage() {
		return "The property " + qualifiedNameProperty + " does not exist for the resource " + resource;
	}
	
}
