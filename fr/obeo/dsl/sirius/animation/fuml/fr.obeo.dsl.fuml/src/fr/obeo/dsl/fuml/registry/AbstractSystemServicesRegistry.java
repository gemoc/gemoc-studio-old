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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class ;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;

/**
 * Abstract implementation of ISystemServicesRegistry.
 * Clients should consider extending this abstract implementation rather than directly implementing ISystemServicesRegistry
 *
 */
public abstract class AbstractSystemServicesRegistry implements ISystemServicesRegistry {

	protected EObject contextEObject ;

	protected Locus locus ;

	/* (non-Javadoc)
	 * @see fr.obeo.dsl.fuml.registry.ISystemServicesRegistry#init(java.lang.Object)
	 */
	public ISystemServicesRegistry init(Object parameters) {
		if(parameters instanceof EObject)
			this.contextEObject = (EObject)parameters;
		return this;
	}

	/* (non-Javadoc)
	 * @see fr.obeo.dsl.fuml.registry.ISystemServicesRegistry#registerSystemServices(fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus)
	 */
	public void registerSystemServices(Locus locus) {
		this.locus = locus ;
		List<Object_> services = this.instantiateServices() ;
		// Guarantees that created services are added to the locus
		for (Object_ o : services) {
			o.locus = locus ;
			locus.extensionalValues.add(o) ;
		}
	}
	
	/**
	 * Clients should implement this method by calling this.instantiateServices(libraryName, serviceQualifiedNames,
	 * where libraryName is the name of a registered library containing the service classes to be instantiated, 
	 * and serviceQualifiedNames is the list of qualified names of service classes to be instantiated
	 * 
	 * @return A List<Object_> containing instantiated services, to be added to a specific locus
	 */
	protected abstract List<Object_> instantiateServices() ;
	
	/**
	 * Convenience method which calls the instantiate method on each service identified in the given serviceQualifiedNames list,
	 * for the library identified by the given libraryName.
	 * libraryName shall refer to the name of a registered library (registered using the oep.uml.extensionpoints.UMLLibrary)
	 * serviceQualifiedNames shall contain qualified names of classes defined in the library identified by libraryName
	 * 
	 * @param libraryName The name of the registered library containing the service classes to be instantiated 
	 * @param serviceQualifiedNames The list of qualified names of service classes to be instantiated
	 * @return A List<Object_> containing instantiated services, to be added to a specific locus
	 */
	protected List<Object_> instantiateServices(String libraryName, List<String> serviceQualifiedNames) {
		List<Object_> serviceInstances = new ArrayList<Object_>() ;
// FIXME should work
			URI libraryUri = URI.createURI("pathmap://PAPYRUS_fUML_LIBRARY/fUML_Library.uml");
			ResourceSet resourceSet = contextEObject.eResource().getResourceSet();
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			for(Iterator<EObject> i = libraryResource.getAllContents(); i.hasNext();) {
				EObject cddService = i.next();
				if(cddService instanceof Class) {
					if (serviceQualifiedNames.contains(((Class)cddService).getQualifiedName())) {
						serviceInstances.add(this.instantiateService((Class)cddService)) ;
					}
				}
			}
		return serviceInstances ;
	}
	
	/**
	 * Constructs a service instance from a given service class.
	 * The service instance is returned in the form of a fuml Object_.
	 * The return Object_ typically overrids Objec_.dispatch(Operation)
	 * 
	 * @param service The class representing the service to be instantiated
	 * @return The instance of the service class, to be added at a specific locus
	 */
	protected abstract Object_ instantiateService(Class service) ;

}
