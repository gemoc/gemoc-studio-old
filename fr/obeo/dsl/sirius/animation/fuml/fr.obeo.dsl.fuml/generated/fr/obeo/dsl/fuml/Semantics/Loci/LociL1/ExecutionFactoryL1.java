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
package fr.obeo.dsl.fuml.Semantics.Loci.LociL1;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.InstanceValueEvaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.LiteralBooleanEvaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.LiteralIntegerEvaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.LiteralNullEvaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.LiteralRealEvaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.LiteralStringEvaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.LiteralUnlimitedNaturalEvaluation;

public class ExecutionFactoryL1 extends ExecutionFactory {

	public SemanticVisitor instantiateVisitor(Element element) {
		// Instantiate a visitor object for the given element (at Conformance
		// Level 1)
		SemanticVisitor visitor = null;
		if(element instanceof LiteralBoolean) {
			visitor = new LiteralBooleanEvaluation();
		} else if(element instanceof LiteralString) {
			visitor = new LiteralStringEvaluation();
		} else if(element instanceof LiteralNull) {
			visitor = new LiteralNullEvaluation();
		} else if(element instanceof InstanceValue) {
			visitor = new InstanceValueEvaluation();
		} else if(element instanceof LiteralUnlimitedNatural) {
			visitor = new LiteralUnlimitedNaturalEvaluation();
		} else if(element instanceof LiteralInteger) {
			visitor = new LiteralIntegerEvaluation();
		} else if(element instanceof LiteralReal) {
			visitor = new LiteralRealEvaluation();
		}
		return visitor;
	}
}
