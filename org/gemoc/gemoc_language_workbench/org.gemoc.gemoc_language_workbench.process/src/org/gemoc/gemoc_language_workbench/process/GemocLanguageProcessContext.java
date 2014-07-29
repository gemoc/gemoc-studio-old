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
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;

public class GemocLanguageProcessContext extends ProcessContextImpl {

	/**
	 * cache of the xdsml model
	 */
	protected GemocLanguageWorkbenchConfiguration xdsmlConfigModel;
	
	protected URI uri=null;
	
	protected IFile xdsmlIFile=null;

	

	public GemocLanguageProcessContext() {
		super();
	}
	
	public void initialize(Process process, URI newUri, IFile xdsmlIFile){
		setDefinition(process);
		this.xdsmlIFile = xdsmlIFile;
		setXdsmlConfigURI(newUri);
		
	}
	
	public void setXdsmlConfigURI(URI newUri){
		if(newUri != uri){
			uri = newUri;
			updateXdsmlConfigModel();
		}
	}
	
	
	public void updateXdsmlConfigModel(){
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource r = resourceSet.getResource(uri, true);
		xdsmlConfigModel = (GemocLanguageWorkbenchConfiguration)r
				.getContents().get(0);
	}


	// getter and setters
	// ------------------
	
	public GemocLanguageWorkbenchConfiguration getXdsmlConfigModel() {
		return xdsmlConfigModel;
	}

	public URI getXdsmlConfigURI(){
		return uri;
	}

	public IFile getXdsmlIFile() {
		return xdsmlIFile;
	}
	public void setXdsmlIFile(IFile resource) {
		xdsmlIFile = resource;
		
	}
}
