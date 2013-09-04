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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import fr.obeo.dsl.sirius.animation.AnimationFactory;
import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.Thread;
import fr.obeo.dsl.sirius.animation.Variable;
import fr.obeo.dsl.sirius.animation.ide.debug.DebugModelToEclipseDebugAdapterFactory;

public class SimulateStateMachine extends
		DebugModelToEclipseDebugAdapterFactory {

	private static final String SM_ACTIVETRANSITIONS = "transitions";

	public SimulateStateMachine(ILaunch launch,
			TransactionalEditingDomain domain) {
		super(launch, domain);
	}

	private Predicate<Pseudostate> INITIAL_STATE = new Predicate<Pseudostate>() {

		public boolean apply(Pseudostate arg0) {
			return arg0.getKind() == PseudostateKind.INITIAL_LITERAL;
		}

	};

	private Function<StateMachine, Thread> machineToStack = new Function<StateMachine, Thread>() {

		public Thread apply(StateMachine from) {
			Thread thread1 = AnimationFactory.eINSTANCE.createThread();
			thread1.setName(from.getName() + " execution");

			StackFrame curStack = AnimationFactory.eINSTANCE.createStackFrame();
			curStack.setName(from.getName() + " execution stack");
			thread1.getStackFrames().add(curStack);
			thread1.setTopStackFrame(curStack);
			curStack.setExecutionEnvironment(from);

			Variable self = AnimationFactory.eINSTANCE.createVariable();
			self.setName("statemachine");
			self.getElements().add(from);
			curStack.getVariables().add(self);

			Iterator<Pseudostate> it = Iterators.filter(
					Iterators.filter(from.eAllContents(), Pseudostate.class),
					INITIAL_STATE);

			Variable transitions = curStack
					.getOrCreateVariable(SM_ACTIVETRANSITIONS);
			if (it.hasNext()) {
				Pseudostate st = it.next();
				transitions.getElements().addAll(st.getOutgoings());
				curStack.setCurrentInstruction(st);
			}
			Variable modified = curStack.getOrCreateVariable("modified");

			return thread1;

		}

	};

	public void enterState(StackFrame parent, State st) {
		StackFrame ctx = parent.newFrame(st);
		if (st.getEntry() != null) {
			ctx.setCurrentInstruction(st.getEntry());
		} else {
			ctx.setCurrentInstruction(st);
		}
	}

	@Override
	public void stepInto(StackFrame host) {
		if (host.getExecutionEnvironment() instanceof State) {
			State st = (State) host.getExecutionEnvironment();
			if (st.getDoActivity() != null
					&& host.getCurrentInstruction() != st.getDoActivity()) {
				host.setCurrentInstruction(st.getDoActivity());
			} else {
				/*
				 * we did the do, now let's go to the transitions
				 */

			}
		}
	}

	@Override
	public void stepOver(StackFrame host) {
		if (host.getExecutionEnvironment() instanceof StateMachine) {
			Variable possibleTransitions = host
					.getOrCreateVariable(SM_ACTIVETRANSITIONS);
			if (possibleTransitions.getElements().size() > 0) {
				Iterator<Transition> it = Iterators.filter(possibleTransitions
						.getElements().iterator(), Transition.class);
				if (it.hasNext()) {
					Transition nxt = it.next();
					StackFrame transitionFrame = host.newFrame(nxt);
				}
			}
		}
		if (host.getExecutionEnvironment() instanceof Transition) {
			Transition t = (Transition) host.getExecutionEnvironment();
			if (host.getCurrentInstruction() == t
					&& t.getTarget() instanceof Vertex) {
				/*
				 * we did not execute the state already.
				 */
				StackFrame vertexFrame = host.newFrame(t.getTarget());

			} else {
				/*
				 * quit transition and go up to the state machine.
				 */
				Variable possibleTransitions = host.getParentStack()
						.getOrCreateVariable(SM_ACTIVETRANSITIONS);
				possibleTransitions.getElements().remove(t);
				host.popFrame();
			}

		}
		if (host.getExecutionEnvironment() instanceof Vertex) {
			Vertex state = (Vertex) host.getExecutionEnvironment();
			/*
			 * TODO : move the behavior pointer forward.
			 */
			StackFrame parentFrame = host.popFrame();
			if (parentFrame.getParentStack().getExecutionEnvironment() instanceof StateMachine) {
				Variable possibleTransitions = parentFrame.getParentStack()
						.getOrCreateVariable(SM_ACTIVETRANSITIONS);
				possibleTransitions.getElements().addAll(state.getOutgoings());
			}

		}
	}

	@Override
	public void stepReturn(StackFrame host) {
		if (host.getExecutionEnvironment() instanceof State) {
			State st = (State) host.getExecutionEnvironment();
		}

	}

	private void updateCurrentState(StackFrame host) {
		Variable currentState = host.getOrCreateVariable("currentState");
		Variable machine = host.getOrCreateVariable("statemachine");
		State cur = null;
		if (currentState.getElements().size() > 0) {
			cur = (State) currentState.getElements().get(0);
		}
		currentState.getElements().clear();
		State nextState = pickTheFirstDifferentState((StateMachine) machine
				.getElements().get(0), cur);
		if (nextState != null) {
			nextState.setName("some name " + System.currentTimeMillis());
			currentState.getElements().add(nextState);
		} else {
			System.err.println("next step is null");
		}
	}

	private State pickTheFirstDifferentState(StateMachine stateMachine,
			State prevState) {
		Iterator<State> it = Iterators.filter(stateMachine.eAllContents(),
				State.class);
		while (it.hasNext()) {
			State child = it.next();
			if (child != prevState) {
				return child;
			}
		}
		return null;
	}

	private State nextState(StateMachine stateMachine, State prevState) {
		Iterator<State> it = Iterators.filter(stateMachine.eAllContents(),
				State.class);
		while (it.hasNext()) {
			State child = it.next();
			if (child != prevState) {
				return child;
			}
		}
		return null;
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

	@Override
	public void terminate(StackFrame host) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stepInto(Thread host) {
		if (host.getTopStackFrame() != null)
			stepInto(host.getTopStackFrame());

	}

	@Override
	public void stepOver(Thread host) {
		if (host.getTopStackFrame() != null)
			stepOver(host.getTopStackFrame());

	}

	@Override
	public void stepReturn(Thread host) {
		if (host.getTopStackFrame() != null)
			stepReturn(host.getTopStackFrame());

	}
}
