/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.uml;

import java.util.Iterator;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

import fr.obeo.dsl.sirius.animation.AnimationFactory;
import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.Thread;
import fr.obeo.dsl.sirius.animation.Variable;
import fr.obeo.dsl.sirius.animation.ide.debug.DebugModelToEclipseDebugAdapterFactory;

public class SimulateStateMachine extends
		DebugModelToEclipseDebugAdapterFactory {

	public SimulateStateMachine(ILaunch launch,
			TransactionalEditingDomain domain) {
		super(launch, domain);
	}

	private Function<StateMachine, Thread> machineToStack = new Function<StateMachine, Thread>() {

		public Thread apply(StateMachine from) {
			Thread thread1 = AnimationFactory.eINSTANCE.createThread();
			thread1.setName(from.getName() + " execution");

			StackFrame curStack = AnimationFactory.eINSTANCE.createStackFrame();
			curStack.setName(from.getName() + " execution stack");
			thread1.getStackFrames().add(curStack);
			curStack.setSourceElement(from);

			Variable self = AnimationFactory.eINSTANCE.createVariable();
			self.setName("statemachine");
			self.getElements().add(from);
			curStack.getVariables().add(self);

			/*
			 * pick the first state
			 */
			Variable currentState = getOrCreateVariable(curStack,
					"currentState");
			if (from.getSubmachineStates().size() > 0) {
				currentState.getElements().add(
						from.getSubmachineStates().get(0));
			}

			return thread1;

		}

	};

	@Override
	public void stepInto(StackFrame host) {
		updateCurrentState(host);
	}

	@Override
	public void stepOver(StackFrame host) {
		updateCurrentState(host);

	}

	private void updateCurrentState(StackFrame host) {
		Variable currentState = getOrCreateVariable(host, "currentState");
		Variable machine = getOrCreateVariable(host, "statemachine");
		EObject prevState = currentState.getElements().iterator().next();
		currentState.getElements().clear();
		State nextState = pickTheFirstDifferentState((StateMachine) machine
				.getElements().get(0), (State) prevState);
		if (nextState != null) {
			currentState.getElements().add(nextState);
		}
	}

	private State pickTheFirstDifferentState(StateMachine stateMachine, State prevState) {
		for (State child : stateMachine.getSubmachineStates()) {
			if (child!=prevState)
			{
				return child;
			}
		}
		return null;
	}

	private Variable getOrCreateVariable(StackFrame host, String string) {
		Variable found = null;
		Iterator<Variable> it = host.getVariables().iterator();
		while (found == null && it.hasNext()) {
			Variable cur = it.next();
			if (string.equals(cur.getName()))
				found = cur;
		}
		if (found == null) {
			Variable currentState = AnimationFactory.eINSTANCE.createVariable();
			currentState.setName("currentState");
			host.getVariables().add(currentState);
		}
		return found;
	}

	@Override
	public AnimationTarget start() {

		AnimationTarget result = AnimationFactory.eINSTANCE
				.createAnimationTarget();
		result.setName("execution");
		// TODO filter UML resources
		for (Resource resource : domain.getResourceSet().getResources()) {
			Iterators.addAll(result.getThreads(), Iterators.transform(Iterators
					.filter(resource.getAllContents(), StateMachine.class),
					machineToStack));

		}
		return result;
	}
}
