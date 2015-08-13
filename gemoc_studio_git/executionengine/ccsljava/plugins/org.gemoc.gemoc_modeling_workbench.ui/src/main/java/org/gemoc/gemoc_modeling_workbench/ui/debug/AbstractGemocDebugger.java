package org.gemoc.gemoc_modeling_workbench.ui.debug;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

public abstract class AbstractGemocDebugger extends AbstractDSLDebugger implements IGemocDebugger, IEngineAddon{
	
	public AbstractGemocDebugger(IDSLDebugEventProcessor target) {
		super(target);
	}

	private Set<BiPredicate<IExecutionEngine, MSEOccurrence>> predicateBreakPoints = new HashSet<BiPredicate<IExecutionEngine, MSEOccurrence>>();
	private Set<BiPredicate<IExecutionEngine, MSEOccurrence>> predicateBreaks = new HashSet<BiPredicate<IExecutionEngine, MSEOccurrence>>();

	
	@Override
	public void addPredicateBreakpoint(BiPredicate<IExecutionEngine, MSEOccurrence> predicate) {
		predicateBreakPoints.add(predicate);
	}

	@Override
	public void addPredicateBreak(BiPredicate<IExecutionEngine, MSEOccurrence> predicate) {
		predicateBreaks.add(predicate);
	}
	


	protected boolean shouldBreakPredicates(IExecutionEngine engine, MSEOccurrence mseOccurrence) {

		// We look at predicate breaks to remove the ones that are true
		boolean shouldBreak2 = false;
		Set<BiPredicate<IExecutionEngine, MSEOccurrence>> toRemove = new HashSet<BiPredicate<IExecutionEngine, MSEOccurrence>>();
		for (BiPredicate<IExecutionEngine, MSEOccurrence> pred : predicateBreaks) {
			if (pred.test(engine, mseOccurrence)) {
				shouldBreak2 = true;
				toRemove.add(pred);
			}
		}
		predicateBreaks.removeAll(toRemove);
		if (shouldBreak2)
			return true;

		// If no break yet, we look at predicate breakpoints
		for (BiPredicate<IExecutionEngine, MSEOccurrence> pred : predicateBreakPoints) {
			if (pred.test(engine, mseOccurrence)) {
				return true;
			}
		}

		return false;

	}
	
	

}
