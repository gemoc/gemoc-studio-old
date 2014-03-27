package org.gemoc.execution.engine.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

public class GemocModelDebugger extends AbstractDSLDebugger {

	private final ObservableBasicExecutionEngine engine;

	private boolean frameCreated;

	private boolean stepIntoFrameCreated;

	private boolean steppingInto;

	public GemocModelDebugger(IDSLDebugEventProcessor target, ObservableBasicExecutionEngine engine) {
		super(target);
		this.engine = engine;
		engine.setDebugger(this);
	}

	@Override
	public void start() {
		engine.start();
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canStepInto(String threadName, EObject instruction) {
		return instruction instanceof LogicalStep;
	}

	@Override
	public void updateData(String threadName, EObject instruction) {
		if (!frameCreated) {
			pushStackFrame(threadName, LogicalStepHelper.getLogicalStepName((LogicalStep) instruction), instruction, instruction);
			frameCreated = true;
		} else {
//			if (steppingInto && !stepIntoFrameCreated) {
//				pushStackFrame(threadName, instruction.toString(), instruction, instruction);
//				stepIntoFrameCreated = true;
//			} else {
//				if (stepIntoFrameCreated) {
//					popStackFrame(threadName);
//					stepIntoFrameCreated = false;
//				}
				setCurrentInstruction(threadName, instruction);
//			}
		}

		// TODO populate variables...
		// variable(threadName, instruction.eClass().getName(), "instruction",
		// instruction);
	}


	@Override
	public boolean shouldBreak(EObject instruction) {
		boolean res = false;
		if (instruction instanceof LogicalStep) {
			steppingInto = false;
			for (Event event : LogicalStepHelper.getTickedEvents((LogicalStep) instruction)) {
				if (event.getReferencedObjectRefs().size() != 0) {
					res = super.shouldBreak(event.getReferencedObjectRefs().get(0));
					if (res) {
						break;
					}
				}
			}
		} else if (steppingInto) {
			res = super.shouldBreak(instruction);
		}
		return res;
	}

	@Override
	public void steppingInto(String threadName) {
		super.steppingInto(threadName);
		steppingInto = true;
	}

	@Override
	public boolean control(String threadName, EObject instruction) {
		final boolean res;

		if (steppingInto || instruction instanceof LogicalStep) {
			res = super.control(threadName, instruction);
		} else {
			res = !isTerminated();
		}

		return res;
	}

}
