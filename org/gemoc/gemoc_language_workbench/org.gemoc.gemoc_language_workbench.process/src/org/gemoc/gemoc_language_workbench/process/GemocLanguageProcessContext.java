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

import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.impl.ProcessContextImpl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;

public class GemocLanguageProcessContext extends ProcessContextImpl {

	private GemocLanguageWorkbenchConfiguration _xdsmlModel;
	
	private URI _xdsmlURI = null;
	

	public GemocLanguageProcessContext() 
	{
		super();
	}
	
	public void initialize(Process process, URI newUri)
	{
		setDefinition(process);
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
			updateXdsmlConfigModel();
		}
	}
	
	private void updateXdsmlConfigModel()
	{
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource r = resourceSet.getResource(_xdsmlURI, true);
		_xdsmlModel = (GemocLanguageWorkbenchConfiguration)r.getContents().get(0);
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
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			file = (IFile) workspaceRoot.findMember(_xdsmlURI.toPlatformString(true));
		}
		return file;
	}
	
}
