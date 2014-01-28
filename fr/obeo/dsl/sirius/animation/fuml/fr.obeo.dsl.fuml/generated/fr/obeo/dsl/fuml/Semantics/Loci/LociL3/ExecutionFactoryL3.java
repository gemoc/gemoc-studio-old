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
package fr.obeo.dsl.fuml.Semantics.Loci.LociL3;

import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.ReadExtentAction;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;
import org.eclipse.uml2.uml.ReclassifyObjectAction;
import org.eclipse.uml2.uml.ReduceAction;
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;
import org.eclipse.uml2.uml.StructuredActivityNode;

import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.AcceptEventActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.ReadExtentActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.ReadIsClassifiedObjectActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.ReclassifyObjectActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.ReduceActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.StartClassifierBehaviorActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions.StartObjectBehaviorActionActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.CompleteStructuredActivities.ConditionalNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.CompleteStructuredActivities.LoopNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.CompleteStructuredActivities.StructuredActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.ExtraStructuredActivities.ExpansionNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.ExtraStructuredActivities.ExpansionRegionActivation;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL2.ExecutionFactoryL2;

public class ExecutionFactoryL3 extends ExecutionFactoryL2 {

	public SemanticVisitor instantiateVisitor(Element element) {
		// Instantiate a visitor object for the given element (at Conformance
		// Level 3)
		SemanticVisitor visitor = null;
		if(element instanceof ConditionalNode) {
			visitor = new ConditionalNodeActivation();
		} else if(element instanceof LoopNode) {
			visitor = new LoopNodeActivation();
		} else if(element instanceof ExpansionRegion) {
			visitor = new ExpansionRegionActivation();
		}
		// Note: Since ConditionalNode, LoopNode and ExpansionRegion are
		// subclasses of
		// StructuredActivityNode, element must be tested against the three
		// subclasses before
		// the superclass
		else if(element instanceof StructuredActivityNode) {
			visitor = new StructuredActivityNodeActivation();
		} else if(element instanceof ExpansionNode) {
			visitor = new ExpansionNodeActivation();
		} else if(element instanceof ReadExtentAction) {
			visitor = new ReadExtentActionActivation();
		} else if(element instanceof ReadIsClassifiedObjectAction) {
			visitor = new ReadIsClassifiedObjectActionActivation();
		} else if(element instanceof ReclassifyObjectAction) {
			visitor = new ReclassifyObjectActionActivation();
		} else if(element instanceof StartObjectBehaviorAction) {
			visitor = new StartObjectBehaviorActionActivation();
		} else if(element instanceof StartClassifierBehaviorAction) {
			visitor = new StartClassifierBehaviorActionActivation();
		} else if(element instanceof AcceptEventAction) {
			visitor = new AcceptEventActionActivation();
		} else if(element instanceof ReduceAction) {
			visitor = new ReduceActionActivation();
		} else {
			visitor = super.instantiateVisitor(element);
		}
		return visitor;
	}
}
