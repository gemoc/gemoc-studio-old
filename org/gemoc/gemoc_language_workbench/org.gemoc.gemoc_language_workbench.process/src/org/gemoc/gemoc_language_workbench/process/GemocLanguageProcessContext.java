/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.process;

import fr.obeo.dsl.process.impl.ProcessContextImpl;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.process.utils.EMFResource;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;

public class GemocLanguageProcessContext extends ProcessContextImpl {

	private GemocLanguageWorkbenchConfiguration _xdsmlModel;
	
	private URI _xdsmlURI = null;
	

	public GemocLanguageProcessContext() 
	{
		super();
	}
	
	public void initialize(URI newUri)
	{
		if (newUri !=  null)
		{
			setName(newUri.toPlatformString(true));
			setXdsmlConfigURI(newUri);
		}		
	}
	
	public void setXdsmlConfigURI(URI newUri)
	{
		if (newUri != _xdsmlURI)
		{
			_xdsmlURI = newUri;
			_xdsmlModel = (GemocLanguageWorkbenchConfiguration)EMFResource.getFirstContent(_xdsmlURI);
		}
	}
	
	// getter and setters
	// ------------------
	
	public GemocLanguageWorkbenchConfiguration getXdsmlModel() 
	{
		return _xdsmlModel;
	}

	public URI getXdsmlURI()
	{
		return _xdsmlURI;
	}

	public IFile getXdsmlFile() 
	{
		IFile file = null;
		if (_xdsmlURI != null)
		{
			file = EclipseResource.getFile(_xdsmlURI);
		}
		return file;
	}
	
}
