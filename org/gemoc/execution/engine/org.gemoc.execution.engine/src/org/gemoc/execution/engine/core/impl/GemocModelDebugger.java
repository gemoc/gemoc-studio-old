package org.gemoc.execution.engine.core.impl;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;

import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;
import glml.ModelSpecificAction;
import glml.ModelSpecificEvent;

public class GemocModelDebugger extends AbstractDSLDebugger {

	private final ObservableBasicExecutionEngine engine;

	private boolean frameCreated;

	public GemocModelDebugger(IDSLDebugEventProcessor target,
			ObservableBasicExecutionEngine engine) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateData(String threadName, EObject instruction) {
		if (!frameCreated) {
			pushStackFrame(threadName,
					instruction.eClass().getName(), instruction,
					instruction);
			frameCreated = true;
		} else {
			setCurrentInstruction(threadName, instruction);
		}

		// TODO populate variables...
		// variable(threadName, instruction.eClass().getName(), "instruction",
		// instruction);
	}

	@Override
	public boolean shouldBreak(EObject instruction) {
		boolean res = false;
		if(super.shouldBreak(instruction)){
			res = true;
		}
		/*if (instruction instanceof ModelSpecificEvent) {
			ModelSpecificEvent event = (ModelSpecificEvent) instruction;
			for (ModelSpecificAction action : event.getModelSpecificActions()) {
				if (super.shouldBreak(action.getTarget())) {
					res = true;
					break;
				}
			}
		}*/
		return res;
	}

}
