/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.OpaqueBehavior;

import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;

public abstract class AbstractOpaqueBehaviorExecutionRegistry implements IOpaqueBehaviorExecutionRegistry {

	protected EObject contextEObject = null;

	protected Locus locus = null;

	protected Map<String, OpaqueBehavior> opaqueBehaviorsMap = null;

	public IOpaqueBehaviorExecutionRegistry init(Object parameters) {
		if(parameters instanceof EObject)
			this.contextEObject = (EObject)parameters;
		return this;
	}

	public void registerOpaqueBehaviorExecutions(Locus locus) {
		this.locus = locus;
	}

	protected void buildOpaqueBehaviorsMap(final String LIBRARY_NAME) {
// FIXME should work
		opaqueBehaviorsMap = new HashMap<String, OpaqueBehavior>();

			URI libraryUri = URI.createURI("pathmap://PAPYRUS_fUML_LIBRARY/fUML_Library.uml");
			ResourceSet resourceSet = contextEObject.eResource().getResourceSet();
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			for(Iterator<EObject> i = libraryResource.getAllContents(); i.hasNext();) {
				EObject cddOpaqueBehavior = i.next();
				if(cddOpaqueBehavior instanceof OpaqueBehavior) {
					OpaqueBehavior f = (OpaqueBehavior)cddOpaqueBehavior;
					opaqueBehaviorsMap.put(f.getQualifiedName(), f);
				}
			}
	}

	protected void registerOpaqueBehaviorExecution(OpaqueBehaviorExecution behaviorExecution, String behaviorQualifiedName) {
		behaviorExecution.types.add(this.opaqueBehaviorsMap.get(behaviorQualifiedName));
		locus.factory.primitiveBehaviorPrototypes.add(behaviorExecution);
	}
}
