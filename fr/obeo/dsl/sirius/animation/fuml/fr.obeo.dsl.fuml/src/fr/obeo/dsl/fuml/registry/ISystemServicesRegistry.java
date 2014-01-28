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

package fr.obeo.dsl.fuml.registry;

import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;


/**
 * The main entry point for the fr.obeo.dsl.fuml.services extension point, 
 * which enables to pre-instantiate services objects at the locus before any execution starts.
 * Contributing to this extension point simply consists in implementing this interface.
 *
 * @see AbstractSystemServicesRegistry, which provides an abstract implementation for this interface.
 *
 */
public interface ISystemServicesRegistry {

	/**
	 * Performs some initializations on the context ISystemServicesRegistry.
	 * This method should be called before calling registerSystemServices.
	 * 
	 * @param parameters The object representing the initialization parameters for the context ISystemServicesRegistry
	 * @return The initialized ISystemServicesRegistry
	 */
	public ISystemServicesRegistry init(Object parameters);
	
	/**
	 * Register specific system services at the given locus
	 * 
	 * @param locus The locus where services have to be registered
	 */
	public void registerSystemServices(Locus locus) ;
	
}
