package fr.obeo.dsl.sirius.animation.uml;

import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import fr.obeo.dsl.sirius.animation.Animator;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.Thread;
import fr.obeo.dsl.sirius.animation.Variable;

public class AnimateUMLStateMachine implements Animator {
	private static final String SM_ACTIVETRANSITIONS = "transitions";

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

	private void enterState(StackFrame parent, State st) {
		StackFrame ctx = parent.newFrame(st);
		if (st.getEntry() != null) {
			ctx.setCurrentInstruction(st.getEntry());
		} else {
			ctx.setCurrentInstruction(st);
		}
	}

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

			}

		}
		if (host.getExecutionEnvironment() instanceof Vertex) {
			Vertex state = (Vertex) host.getExecutionEnvironment();
			/*
			 * TODO : move the behavior pointer forward.
			 */
			StackFrame parentFrame = host.popFrame();
			if (parentFrame.getExecutionEnvironment() instanceof Transition) {
				Transition t = (Transition) parentFrame
						.getExecutionEnvironment();
				/*
				 * quit transition and go up to the state machine.
				 */
				Variable possibleTransitions = parentFrame.getParentStack()
						.getOrCreateVariable(SM_ACTIVETRANSITIONS);
				possibleTransitions.getElements().remove(t);
				host.popFrame();

			}
			if (parentFrame.getParentStack().getExecutionEnvironment() instanceof StateMachine) {
				Variable possibleTransitions = parentFrame.getParentStack()
						.getOrCreateVariable(SM_ACTIVETRANSITIONS);
				possibleTransitions.getElements().addAll(state.getOutgoings());
			}

		}
		/*
		 * always add a "this" variable for the current execution context
		 */
		Variable currentExecutionContext = host.getParent().getTopStackFrame()
				.getOrCreateVariable("this");
		currentExecutionContext.getElements().clear();
		currentExecutionContext.getElements().add(
				host.getExecutionEnvironment());

	}

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

	public AnimationTarget start(ResourceSet set) {
		AnimationTarget result = AnimationFactory.eINSTANCE
				.createAnimationTarget();
		result.setName("execution");
		// TODO filter UML resources
		for (Resource resource : set.getResources()) {
			Iterators.addAll(result.getThreads(), Iterators.transform(Iterators
					.filter(resource.getAllContents(), StateMachine.class),
					machineToStack));

		}
		return result;
	}

	public void terminate(StackFrame host) {
		// TODO Auto-generated method stub

	}

	public void stepInto(Thread host) {
		if (host.getTopStackFrame() != null)
			stepInto(host.getTopStackFrame());

	}

	public void stepOver(Thread host) {
		if (host.getTopStackFrame() != null)
			stepOver(host.getTopStackFrame());

	}

	public void stepReturn(Thread host) {
		if (host.getTopStackFrame() != null)
			stepReturn(host.getTopStackFrame());

	}
}
