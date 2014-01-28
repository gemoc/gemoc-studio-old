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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.ValueSpecification;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Evaluation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fr.obeo.dsl.fuml.debug.Debug;

public abstract class ExecutionFactory {

	/*
	 * The locus at which this factory resides.
	 */
	public Locus locus;

	/*
	 * The set of opaque behavior executions to be used to execute the primitive
	 * behaviors known to the factory.
	 */
	public List<OpaqueBehaviorExecution> primitiveBehaviorPrototypes = new ArrayList<OpaqueBehaviorExecution>();

	/*
	 * The set of primitive types that have corresponding literal value
	 * specifications. Must include Integer, Boolean, String and
	 * UnlimitedNatural.
	 */
	public List<PrimitiveType> builtInTypes = new ArrayList<PrimitiveType>();

	/*
	 * The set of semantic strategies currently registered with this execution
	 * factory.
	 */
	public List<SemanticStrategy> strategies = new ArrayList<SemanticStrategy>();

	public Execution createExecution(Behavior behavior, Object_ context) {
		// Create an execution object for a given behavior.
		// The execution will take place at the locus of the factory in the
		// given context.
		// If the context is empty, the execution is assumed to provide its own
		// context.
		Execution execution;
		if(behavior instanceof OpaqueBehavior) {
			execution = this.instantiateOpaqueBehaviorExecution((OpaqueBehavior)behavior);
		} else {
			execution = (Execution)this.instantiateVisitor(behavior);
			execution.types.add(behavior);
			execution.createFeatureValues();
		}
		this.locus.add(execution);
		if(context == null) {
			execution.context = execution;
		} else {
			execution.context = context;
		}
		return execution;
	}

	public Evaluation createEvaluation(ValueSpecification specification) {
		// Create an evaluation object for a given value specification.
		// The evaluation will take place at the locus of the factory.
		Evaluation evaluation = (Evaluation)this.instantiateVisitor(specification);
		evaluation.specification = specification;
		evaluation.locus = this.locus;
		return evaluation;
	}

	public abstract SemanticVisitor instantiateVisitor(Element element);

	public OpaqueBehaviorExecution instantiateOpaqueBehaviorExecution(OpaqueBehavior behavior) {
		// Return a copy of the prototype for the primitive behavior execution
		// of the given opaque behavior.
		OpaqueBehaviorExecution execution = null;
		int i = 1;
		while(execution == null & i <= this.primitiveBehaviorPrototypes.size()) {
			// Debug.println("[instantiateOpaqueExecution] Checking " +
			// this.primitiveBehaviorPrototypes.get(i).objectId() + "...");
			OpaqueBehaviorExecution prototype = this.primitiveBehaviorPrototypes.get(i - 1);
			if (prototype.getBehavior() == behavior) {
				execution = (OpaqueBehaviorExecution)(prototype.copy());
			}
			i = i + 1;
		}
		if(execution == null) {
			Debug.println("[instantiateOpaqueExecution] No prototype execution found for " + behavior.getName() + ".");
		}
		return execution;
	}

	public void addPrimitiveBehaviorPrototype(OpaqueBehaviorExecution execution) {
		// Add an opaque behavior execution to use as a prototype for
		// instantiating the corresponding primitive opaque behavior.
		// Precondition: No primitive behavior prototype for the type of the
		// given execution should already exist.
		this.primitiveBehaviorPrototypes.add(execution);
	}

	public void addBuiltInType(PrimitiveType type) {
		// Add the given primitive type as a built-in type.
		// Precondition: No built-in type with the same name should already
		// exist.
		this.builtInTypes.add(type);
	}

	public PrimitiveType getBuiltInType(String name) {
		// Return the built-in type with the given name.
		PrimitiveType type = null;
		int i = 1;
		while(type == null & i <= this.builtInTypes.size()) {
			PrimitiveType primitiveType = this.builtInTypes.get(i - 1);
			if(primitiveType.getName().equals(name)) {
				type = primitiveType;
			}
			i = i + 1;
		}
		return type;
	}

	public void setStrategy(SemanticStrategy strategy) {
		// Set the strategy for a semantic variation point. Any existing
		// strategy for the same SVP is replaced.
		int i = this.getStrategyIndex(strategy.getName());
		if(i <= this.strategies.size()) {
			this.strategies.remove(i - 1);
		}
		this.strategies.add(strategy);
	}

	public SemanticStrategy getStrategy(String name) {
		// Get the strategy with the given name.
		int i = this.getStrategyIndex(name);
		SemanticStrategy strategy = null;
		if(i <= this.strategies.size()) {
			strategy = this.strategies.get(i - 1);
		}
		return strategy;
	}

	public Integer getStrategyIndex(String name) {
		// Get the index of the strategy with the given name.
		// If there is no such strategy, return the size of the strategies list.
		List<SemanticStrategy> strategies = this.strategies;
		int i = 1;
		boolean unmatched = true;
		while(unmatched & (i <= strategies.size())) {
			if(strategies.get(i - 1).getName().equals(name)) {
				unmatched = false;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
}
