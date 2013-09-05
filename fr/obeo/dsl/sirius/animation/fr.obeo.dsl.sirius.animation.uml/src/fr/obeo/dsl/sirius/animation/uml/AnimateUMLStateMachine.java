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
			thread1.getStackFrames().add(curStack);
			thread1.setTopStackFrame(curStack);
			curStack.setExecutionEnvironment(from);

			Variable self = AnimationFactory.eINSTANCE.createVariable();
			self.setName("statemachine");
			self.getElements().add(from);
			curStack.getVariables().add(self);
			curStack.setCurrentInstruction(from);

			Variable modified = curStack.getOrCreateVariable("modified");

			return thread1;

		}

	};

	/*
	 * steping over a statemachine SO : first instruction : initial state.
	 * update possible next states SO : pick the next state, add new possible
	 * states.
	 */

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

		/*
		 * SM / SM -> SM/InitialState + candidate transitions -> SM/une
		 * transition + candidate transition-- -> SM/State + candidate
		 * transitions++ -> SM/une transition + candidate transition--
		 */
		if (host.getExecutionEnvironment() instanceof StateMachine) {
			Variable possibleTransitions = host
					.getOrCreateVariable(SM_ACTIVETRANSITIONS);

			if (host.getCurrentInstruction() instanceof Vertex) {
				Vertex v = (Vertex) host.getCurrentInstruction();
				possibleTransitions.getElements().addAll(v.getOutgoings());
				if (possibleTransitions.getElements().size() > 0) {
					Transition t = (Transition) possibleTransitions
							.getElements().get(0);
					host.setCurrentInstruction(t);
					possibleTransitions.getElements().remove(t);
				}
			} else if (host.getCurrentInstruction() instanceof Transition) {
				Transition t = (Transition) host.getCurrentInstruction();
				host.setCurrentInstruction(t.getTarget());
			} else if (host.getCurrentInstruction() != null) {
				Iterator<Pseudostate> it = Iterators.filter(Iterators.filter(
						host.getCurrentInstruction().eAllContents(),
						Pseudostate.class), INITIAL_STATE);
				if (it.hasNext()) {
					host.setCurrentInstruction(it.next());
				}
			}

			/*
			 * always add a "this" variable for the current execution context
			 */
			Variable currentExecutionContext = host.getParent()
					.getTopStackFrame().getOrCreateVariable("this");
			currentExecutionContext.getElements().clear();
			currentExecutionContext.getElements().add(
					host.getExecutionEnvironment());

			Variable instruction = host.getParent().getTopStackFrame()
					.getOrCreateVariable("current");
			currentExecutionContext.getElements().clear();
			currentExecutionContext.getElements().add(
					host.getCurrentInstruction());

		}

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
