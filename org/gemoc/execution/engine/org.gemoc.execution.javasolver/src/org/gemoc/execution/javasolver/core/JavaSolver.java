package org.gemoc.execution.javasolver.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javasolverinput.JavaSolverInputFile;
import javasolverinput.JavasolverinputPackage;
import javasolverinput.usage.Clock;
import javasolverinput.usage.Constraint;
import javasolverinput.usage.CustomConstraint;
import javasolverinput.usage.Once;
import javasolverinput.usage.Precedes;
import javasolverinput.usage.WaitUntil;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.moc.SolverInputBuilder;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.NamedReference;
import fr.inria.aoste.trace.TraceFactory;

public class JavaSolver implements Solver {

	private Collection<Clock> clocks;
	private Map<Clock, Map<Integer, Boolean>> trace;
	private Collection<Constraint> constraints;
	private String inputName;
	private TraceFactory myFactory = null;

	public JavaSolver() {
	}

	@Override
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		throw new UnsupportedOperationException();
	}

	private Boolean isTicking(Clock clock, Collection<Constraint> constraints) {
		Boolean res = null;
		for (Constraint constraint : constraints) {
			if (constraint instanceof Precedes) {
				res = this.semanticsOfPrecedes((Precedes) constraint, clock);
			} else if (constraint instanceof Once) {
				res = this.semanticsOfOnce((Once) constraint, clock);
			} else if (constraint instanceof WaitUntil) {
				res = this.semanticsOfWaitUntil((WaitUntil) constraint, clock);
			} else if (constraint instanceof CustomConstraint) {
				res = res
						&& this.isTicking(clock,
								((CustomConstraint) constraint).getType()
										.getDefinition().getConstraints());
			} else {
				throw new RuntimeException("Impossible relation.");
			}
		}
		return res;
	}

	private Boolean semanticsOfPrecedes(Precedes constraint, Clock clock) {
		Boolean res = false;
		if (constraint.getArguments().size() != 2) {
			throw new IllegalArgumentException(
					"Constraint Precedes should have two and only two arguments");
		} else {
			List<EObject> arguments = constraint.getArguments();
			for (EObject eo : arguments) {
				if (!(eo instanceof Clock)) {
					throw new IllegalArgumentException(
							"Constraint Precedes arguments should be clocks");
				}
			}
			Clock c1 = (Clock) arguments.get(0);
			Clock c2 = (Clock) arguments.get(1);

			if (c1.equals(clock)) {
				res = true;
			} else if (c2.equals(clock)) {
				Integer n1 = this.getNumberOfTicks(c1);
				Integer n2 = this.getNumberOfTicks(clock);
				res = n1 >= n2;
			}
		}
		return res;
	}

	private Boolean semanticsOfOnce(Once constraint, Clock clock) {
		Boolean res = false;
		if (constraint.getArguments().size() != 1) {
			throw new IllegalArgumentException(
					"Constraint Once should have one and only one argument");
		} else {
			List<EObject> arguments = constraint.getArguments();
			for (EObject eo : arguments) {
				if (!(eo instanceof Clock)) {
					throw new IllegalArgumentException(
							"Constraint Once arguments should be a clock");
				}
			}
			Clock c = (Clock) arguments.get(0);

			if (c.equals(clock)) {
				res = this.getNumberOfTicks(clock) == 0;
			}
		}
		return res;
	}

	private Boolean semanticsOfWaitUntil(WaitUntil constraint, Clock clock) {
		Boolean res = false;
		if (constraint.getArguments().size() != 1) {
			throw new IllegalArgumentException(
					"Constraint WaitUntil should have one and only one argument");
		} else {
			List<EObject> arguments = constraint.getArguments();
			if (!(arguments.get(0) instanceof Clock)) {
				throw new IllegalArgumentException(
						"The argument of WaitUntil should be a Clock");
			}
			Clock c = (Clock) arguments.get(0);
			Integer date = ((WaitUntil) constraint).getDate();

			if (c.equals(clock)) {
				Integer lastIndex = this.getLastIndex(clock);
				res = date == lastIndex + 1;
			}
		}
		return res;
	}

	private Boolean isTickingAndRegister(Clock clock,
			Collection<Constraint> constraints) {
		Boolean res = this.isTicking(clock, constraints);
		Map<Integer, Boolean> map = this.trace.get(clock);
		map.put(this.getLastIndex(clock) + 1, res);
		return res;
	}

	private Integer getNumberOfTicks(Clock clock) {
		Map<Integer, Boolean> map = this.trace.get(clock);
		Collection<Boolean> values = map.values();
		Integer res = 0;
		for (Boolean value : values) {
			if (value) {
				res++;
			}
		}
		return res;
	}

	private Integer getLastIndex(Clock clock) {
		Map<Integer, Boolean> map = this.trace.get(clock);
		Integer lastRound = 0;
		for (Integer i : map.keySet()) {
			lastRound = Math.max(i, lastRound);
		}
		return lastRound;
	}

	@Override
	public LogicalStep getNextStep() {
		LogicalStep res = myFactory.createLogicalStep();
		for (Clock clock : this.clocks) {
			if (this.isTickingAndRegister(clock, this.constraints)) {
				res.getEventOccurrences().add(
						this.createEventOccurrenceFromClock(clock));
			}
		}
		return res;
	}

	private EventOccurrence createEventOccurrenceFromClock(Clock clock) {
		EventOccurrence eventOccurrence = myFactory.createEventOccurrence();
		eventOccurrence.setFState(FiredStateKind.TICK);

		// ModelElementReference clockReference = myFactory
		// .createModelElementReference();
		// clockReference.getElementRef().add(clock);
		NamedReference clockReference = myFactory.createNamedReference();
		clockReference.setValue(clock.getName());

		eventOccurrence.setReferedElement(clockReference);

		return eventOccurrence;
	}

	@Override
	public SolverInputBuilder getSolverInputBuilder() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSolverInputFile(URI modelOfExecutionURI) {
		ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("javasolverinput", new XMIResourceFactoryImpl());
		JavasolverinputPackage.eINSTANCE.eClass();

		// Resource resource = resSet.getResource(modelOfExecutionURI, true);
		Resource resource = resSet
				.getResource(
						URI.createFileURI("/home/flatombe/thesis/gemoc/git/gemoc-dev/org/gemoc/sample/tfsm_k3/org.gemoc.sample.tfsm.instances/TrafficControl/test/MySolverInput.javasolverinput"),
						true);

		JavaSolverInputFile input = (JavaSolverInputFile) resource
				.getContents().get(0);

		this.clocks = input.getClockDeclarations();
		this.constraints = input.getConstraints();
		this.inputName = input.getName();

		this.trace = new HashMap<Clock, Map<Integer, Boolean>>();
		for (Clock clock : this.clocks) {
			Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			this.trace.put(clock, map);
		}
		this.myFactory = TraceFactory.eINSTANCE;

	}

	public String toString() {
		return this.getClass().getSimpleName() + "@[" + this.inputName + "]";
	}

}
