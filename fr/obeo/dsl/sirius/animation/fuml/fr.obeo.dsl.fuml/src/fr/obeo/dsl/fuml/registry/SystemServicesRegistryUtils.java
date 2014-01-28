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

import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.UMLFactory;

public class SystemServicesRegistryUtils {
	
	protected static SystemServicesRegistryUtils eInstance ;
	
	private SystemServicesRegistryUtils() {} ;
	
	public static SystemServicesRegistryUtils getInstance() {
		if (eInstance == null)
			eInstance = new SystemServicesRegistryUtils() ;
		return eInstance ;
	}
	
	public OpaqueBehavior generateOpaqueBehaviorSignature(Operation operation) {
		OpaqueBehavior method = UMLFactory.eINSTANCE.createOpaqueBehavior() ;
		method.setName(operation.getName() + "Method") ;
		for (Parameter p : operation.getOwnedParameters()) {
			Parameter behaviorParameter = method.createOwnedParameter(p.getName(), p.getType()) ;
			behaviorParameter.setDirection(p.getDirection()) ;
			behaviorParameter.setLower(p.getLower()) ;
			behaviorParameter.setUpper(p.getUpper()) ;
		}
		return method ;
	}
	
	// TODO may be useful to do something similar for activities
}
