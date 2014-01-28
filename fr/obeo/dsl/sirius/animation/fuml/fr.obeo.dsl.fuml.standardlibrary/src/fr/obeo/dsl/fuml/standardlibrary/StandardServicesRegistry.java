/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package fr.obeo.dsl.fuml.standardlibrary;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Class;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.registry.AbstractSystemServicesRegistry;
import fr.obeo.dsl.fuml.standardlibrary.library.io.StandardInputChannelImpl;
import fr.obeo.dsl.fuml.standardlibrary.library.io.StandardOutputChannelImpl;

/**
 * Registers system services related to the foundational model library.
 * This includes standard input/ouput channel services
 *
 */
public class StandardServicesRegistry extends AbstractSystemServicesRegistry {

	protected final static String FUML_LIBRARY_NAME = "FoundationalModelLibrary";
	protected final static String STANDARD_INPUT_CHANNEL_SERVICE_NAME = "FoundationalModelLibrary::BasicInputOutput::StandardInputChannel" ; 
	protected final static String STANDARD_OUTPUT_CHANNEL_SERVICE_NAME = "FoundationalModelLibrary::BasicInputOutput::StandardOutputChannel" ;

	/* (non-Javadoc)
	 * @see fr.obeo.dsl.fuml.registry.AbstractSystemServicesRegistry#instantiateServices()
	 */
	@Override
	public List<Object_> instantiateServices() {
		List<String> serviceQualifiedNames = new ArrayList<String>() ;
		serviceQualifiedNames.add(STANDARD_INPUT_CHANNEL_SERVICE_NAME) ;
		serviceQualifiedNames.add(STANDARD_OUTPUT_CHANNEL_SERVICE_NAME) ;
		return this.instantiateServices(FUML_LIBRARY_NAME, serviceQualifiedNames);
	}

	/* (non-Javadoc)
	 * @see fr.obeo.dsl.fuml.registry.AbstractSystemServicesRegistry#instantiateService(org.eclipse.uml2.uml.Class)
	 */
	@Override
	protected Object_ instantiateService(Class service) {
		if (service.getQualifiedName().equals(STANDARD_INPUT_CHANNEL_SERVICE_NAME)) {
			return new StandardInputChannelImpl(service) ;
		}
		else if (service.getQualifiedName().equals(STANDARD_OUTPUT_CHANNEL_SERVICE_NAME)) {
			return new StandardOutputChannelImpl(service) ;
		}
		return null;
	}
	
	

}
