package org.gemoc.execution.javasolver.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javasolverinput.Clock;
import javasolverinput.JavaSolverInputFile;
import javasolverinput.JavasolverinputPackage;
import javasolverinput.Precedes;
import javasolverinput.Relation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gemoc.gemoc_language_workbench.api.moc.SolverInputBuilder;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public class JavaSolver implements Solver {

	private Collection<Clock> clocks;
	private Map<Clock, Map<Integer, Boolean>> trace;
	private Collection<Relation> constraints;
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

	private Boolean isTicking(Clock clock) {
		Boolean res = null;
		for (Relation relation : this.constraints) {
			if (relation instanceof Precedes) {
				if (((Precedes) relation).getClock1().equals(clock)) {
					res = true;
				} else if (((Precedes) relation).getClock2().equals(clock)) {
					Integer n1 = this.getNumberOfTicks(((Precedes) relation)
							.getClock1());
					Integer n2 = this.getNumberOfTicks(clock);
					if (n1 >= n2) {
						res = true;
					} else {
						res = false;
					}
				}
			} else {
				throw new RuntimeException("Impossible relation.");
			}
		}
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
			if (this.isTicking(clock)) {
				res.getEventOccurrences().add(
						this.createEventOccurrenceFromClock(clock));
			}
		}
		return res;
	}

	private EventOccurrence createEventOccurrenceFromClock(Clock clock) {
		EventOccurrence eventOccurrence = myFactory.createEventOccurrence();
		eventOccurrence.setFState(FiredStateKind.TICK);

		ModelElementReference clockReference = myFactory
				.createModelElementReference();
		clockReference.getElementRef().add(clock);

		eventOccurrence.setReferedElement(clockReference);

		return eventOccurrence;
	}

	@Override
	public SolverInputBuilder getSolverInputBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSolverInputFile(URI modelOfExecutionURI) {
		ResourceSet resSet = new ResourceSetImpl();
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		JavasolverinputPackage.eINSTANCE.eClass();
		Resource resource = resSet.getResource(modelOfExecutionURI, true);
		JavaSolverInputFile input = (JavaSolverInputFile) resource
				.getContents().get(0);

		this.clocks = input.getClocks();
		this.constraints = input.getConstraints();
		this.inputName = input.getName();

		this.trace = new HashMap<Clock, Map<Integer, Boolean>>();
		for (Clock clock : this.clocks) {
			Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
			this.trace.put(clock, map);
		}
		this.myFactory = TraceFactory.eINSTANCE;

	}

}
