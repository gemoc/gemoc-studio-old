package fr.obeo.dsl.sirius.animation.uml;

import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Behavior;
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


	public void stepInto(StackFrame host) {
		if (host.getExecutionEnvironment() instanceof StateMachine) {
			/*
			 * if Env is statemachine and instruction is state, we have to go into the state.
			 */
			if (host.getCurrentInstruction() instanceof State) {
				State st = (State) host.getCurrentInstruction();
				StackFrame stateFrame = host.newFrame(st);
				stateFrame.setCurrentInstruction(st);
			}
		} else if (host.getExecutionEnvironment() instanceof State) {
			if (host.getCurrentInstruction() instanceof State) {
				State st = (State) host.getCurrentInstruction();
				/*
				 * we are into the state, we should do the doActivity.
				 */
				if (st.getDoActivity()!=null) {
					 host.setCurrentInstruction(st.getDoActivity());
					 host.getOrCreateVariable("behavior").getElements().add(st.getDoActivity());
				}
			} else if (host.getCurrentInstruction() instanceof Behavior) {
				/*
				 * we did the doBehavior, lets pop the context
				 */
				host.popFrame();
			}
			
		}
	}

	public void stepOver(StackFrame host) {
		if (host.getExecutionEnvironment() instanceof StateMachine) {
			Variable possibleTransitions = host
					.getOrCreateVariable(SM_ACTIVETRANSITIONS);

			if (host.getCurrentInstruction() instanceof Vertex) {
				Vertex v = (Vertex) host.getCurrentInstruction();
				possibleTransitions.getElements().addAll(v.getOutgoings());
				if (possibleTransitions.getElements().size() > 0) {
					Transition t = (Transition) possibleTransitions
							.getElements().get(possibleTransitions.getElements().size() -1);
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
					.getTopStackFrame().getOrCreateVariable("context");
			currentExecutionContext.getElements().clear();
			currentExecutionContext.getElements().add(
					host.getExecutionEnvironment());

			Variable instruction = host.getParent().getTopStackFrame()
					.getOrCreateVariable("current");
			instruction.getElements().clear();
			instruction.getElements().add(host.getCurrentInstruction());

		}

	}

	public void stepReturn(StackFrame host) {
		if (host.getExecutionEnvironment() instanceof State) {
			State st = (State) host.getExecutionEnvironment();
		}

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
