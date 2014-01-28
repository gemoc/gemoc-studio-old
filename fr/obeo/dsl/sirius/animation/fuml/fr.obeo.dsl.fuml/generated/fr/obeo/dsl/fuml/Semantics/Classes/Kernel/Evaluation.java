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
package fr.obeo.dsl.fuml.Semantics.Classes.Kernel;

import org.eclipse.uml2.uml.ValueSpecification;

import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.SemanticVisitor;

public abstract class Evaluation extends SemanticVisitor {

	/*
	 * The value specification to be evaluated.
	 */
	public ValueSpecification specification;

	/*
	 * The locus at which this evaluation is taking place.
	 */
	public Locus locus;

	public abstract Value evaluate();
}
