/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.debug.ide;

import fr.obeo.dsl.debug.ide.event.IDSLDebugEvent;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;
import fr.obeo.dsl.debug.ide.event.debugger.BreakpointReply;
import fr.obeo.dsl.debug.ide.event.debugger.DeleteVariableReply;
import fr.obeo.dsl.debug.ide.event.debugger.PopStackFrameReply;
import fr.obeo.dsl.debug.ide.event.debugger.PushStackFrameReply;
import fr.obeo.dsl.debug.ide.event.debugger.ResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.SetCurrentInstructionReply;
import fr.obeo.dsl.debug.ide.event.debugger.SpawnRunningThreadReply;
import fr.obeo.dsl.debug.ide.event.debugger.StepIntoResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.StepOverResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.StepReturnResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.SteppedReply;
import fr.obeo.dsl.debug.ide.event.debugger.SuspendedReply;
import fr.obeo.dsl.debug.ide.event.debugger.TerminatedReply;
import fr.obeo.dsl.debug.ide.event.debugger.VariableReply;
import fr.obeo.dsl.debug.ide.event.model.AbstractStepRequest;
import fr.obeo.dsl.debug.ide.event.model.DisconnectRequest;
import fr.obeo.dsl.debug.ide.event.model.ResumeRequest;
import fr.obeo.dsl.debug.ide.event.model.StartRequest;
import fr.obeo.dsl.debug.ide.event.model.StepIntoRequest;
import fr.obeo.dsl.debug.ide.event.model.StepOverRequest;
import fr.obeo.dsl.debug.ide.event.model.StepReturnRequest;
import fr.obeo.dsl.debug.ide.event.model.SuspendRequest;
import fr.obeo.dsl.debug.ide.event.model.TerminateRequest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EObject;

/**
 * Base {@link IDSLDebugger debugger} implementation.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractDSLDebugger implements IDSLDebugger {

	/**
	 * The {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 * communication or the {@link fr.obeo.dsl.debug.ide.DSLDebugTargetAdapter target} for synchronous
	 * communication.
	 */
	private final IDSLDebugEventProcessor target;

	/**
	 * Tells if the debugger is terminated.
	 */
	private boolean terminated;

	/**
	 * Thread name to current instruction. For check purpose only.
	 */
	private final Map<String, EObject> currentInstructions = new HashMap<String, EObject>();

	/**
	 * Mapping form thread name to the thread controller.
	 */
	private final Map<String, ThreadController> controllers = new ConcurrentHashMap<String, ThreadController>();

	/**
	 * Instructions marked as breakpoints. TODO find something more powerful (expression, EClass, etc...)
	 */
	private final Set<EObject> breakpoints = new HashSet<EObject>();

	/**
	 * Constructor.
	 * 
	 * @param target
	 *            the {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 *            communication or the {@link fr.obeo.dsl.debug.ide.DSLDebugTargetAdapter target} for
	 *            synchronous communication
	 */
	public AbstractDSLDebugger(IDSLDebugEventProcessor target) {
		this.target = target;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)
	 */
	public void handleEvent(IDSLDebugEvent event) {
		if (event instanceof DisconnectRequest) {
			disconnect();
		} else if (event instanceof AbstractStepRequest) {
			handleStepRequest((AbstractStepRequest)event);
		} else if (event instanceof ResumeRequest) {
			handleResumeRequest((ResumeRequest)event);
		} else if (event instanceof SuspendRequest) {
			handleSuspendRequest((SuspendRequest)event);
		} else if (event instanceof TerminateRequest) {
			handleTerminateRequest((TerminateRequest)event);
		} else if (event instanceof StartRequest) {
			start();
		}
	}

	/**
	 * Handles {@link TerminateRequest}.
	 * 
	 * @param terminateRequest
	 *            the {@link TerminateRequest}
	 */
	private void handleTerminateRequest(TerminateRequest terminateRequest) {
		final String threadName = terminateRequest.getThreadName();
		if (threadName != null) {
			terminate(threadName);
			// target.handleEvent(new TerminatedReply(threadName));
		} else {
			terminate();
			target.handleEvent(new TerminatedReply());
		}
	}

	/**
	 * Handles {@link SuspendRequest}.
	 * 
	 * @param suspendRequest
	 *            the {@link SuspendRequest}
	 */
	private void handleSuspendRequest(SuspendRequest suspendRequest) {
		final String threadName = suspendRequest.getThreadName();
		if (threadName != null) {
			suspend(threadName);
		} else {
			suspend();
		}
	}

	/**
	 * Handles {@link ResumeRequest}.
	 * 
	 * @param resumeRequest
	 *            the {@link ResumeRequest}
	 */
	private void handleResumeRequest(ResumeRequest resumeRequest) {
		final String threadName = resumeRequest.getThreadName();
		if (threadName != null) {
			resume(threadName);
		} else {
			resume();
		}
	}

	/**
	 * Handles {@link AbstractStepRequest}.
	 * 
	 * @param stepRequest
	 *            the {@link AbstractStepRequest}
	 */
	private void handleStepRequest(AbstractStepRequest stepRequest) {
		final String threadName = stepRequest.getThreadName();
		if (stepRequest.getInstrcution() != currentInstructions.get(threadName)) {
			throw new IllegalStateException("instruction desynchronization.");
		}
		if (stepRequest instanceof StepIntoRequest) {
			stepInto(threadName);
		} else if (stepRequest instanceof StepOverRequest) {
			stepOver(threadName);
		} else if (stepRequest instanceof StepReturnRequest) {
			stepReturn(threadName);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#stepped(java.lang.String)
	 */
	public void stepped(final String threadName) {
		target.handleEvent(new SteppedReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#suspended(java.lang.String)
	 */
	public void suspended(String threadName) {
		target.handleEvent(new SuspendedReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#breaked(java.lang.String)
	 */
	public void breaked(String threadName) {
		target.handleEvent(new BreakpointReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#resuming(java.lang.String)
	 */
	public void resuming(String threadName) {
		target.handleEvent(new ResumingReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#steppingInto(java.lang.String)
	 */
	public void steppingInto(String threadName) {
		target.handleEvent(new StepIntoResumingReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#steppingOver(java.lang.String)
	 */
	public void steppingOver(String threadName) {
		target.handleEvent(new StepOverResumingReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#steppingReturn(java.lang.String)
	 */
	public void steppingReturn(String threadName) {
		target.handleEvent(new StepReturnResumingReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#terminated()
	 */
	public void terminated() {
		target.handleEvent(new TerminatedReply());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#spawnRunningThread(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void spawnRunningThread(String threadName, EObject context) {
		target.handleEvent(new SpawnRunningThreadReply(threadName, context));
		controllers.put(threadName, createThreadHandler(threadName));
	}

	/**
	 * Creates a {@link ThreadController} for the given thread. if the thread is a new Java {@link Thread} a
	 * new instance should be created, if not the {@link ThreadController} for the existing Java
	 * {@link Thread} should be returned.
	 * 
	 * @param threadName
	 *            the thread name
	 * @return if the thread is a new Java {@link Thread} a new instance should be created, if not the
	 *         {@link ThreadController} for the existing Java {@link Thread} should be returned
	 */
	protected ThreadController createThreadHandler(String threadName) {
		return new ThreadController(this, threadName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#setTerminated(boolean)
	 */
	public void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#isTerminated()
	 */
	public boolean isTerminated() {
		return terminated;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#getNextInstruction(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject, fr.obeo.dsl.debug.ide.IDSLDebugger.Stepping)
	 */
	public EObject getNextInstruction(String threadName, EObject currentInstruction, Stepping stepping) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#shouldBreak(org.eclipse.emf.ecore.EObject)
	 */
	public boolean shouldBreak(EObject instruction) {
		return breakpoints.contains(instruction);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#addBreakPoint(org.eclipse.emf.ecore.EObject)
	 */
	public void addBreakPoint(EObject instruction) {
		breakpoints.add(instruction);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#removeBreakPoint(org.eclipse.emf.ecore.EObject)
	 */
	public void removeBreakPoint(EObject instruction) {
		breakpoints.remove(instruction);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#control(java.lang.String, org.eclipse.emf.ecore.EObject)
	 */
	public boolean control(String threadName, EObject instruction) {
		final boolean res;
		if (!isTerminated()) {
			res = controllers.get(threadName).control(instruction);
		} else {
			res = false;
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#resume(java.lang.String)
	 */
	public void resume(String threadName) {
		controllers.get(threadName).resume();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#stepInto(java.lang.String)
	 */
	public void stepInto(String threadName) {
		controllers.get(threadName).stepInto();
	};

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#stepOver(java.lang.String)
	 */
	public void stepOver(String threadName) {
		controllers.get(threadName).stepOver();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#stepReturn(java.lang.String)
	 */
	public void stepReturn(String threadName) {
		controllers.get(threadName).stepReturn();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#suspend(java.lang.String)
	 */
	public void suspend(String threadName) {
		controllers.get(threadName).suspend();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#terminate()
	 */
	public void terminate() {
		setTerminated(true);
		for (ThreadController controler : controllers.values()) {
			synchronized(controler) {
				controler.wakeUp();
			}
		}
		controllers.clear();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#terminate(java.lang.String)
	 */
	public void terminate(String threadName) {
		controllers.get(threadName).terminate();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#suspend()
	 */
	public void suspend() {
		for (ThreadController controler : controllers.values()) {
			controler.suspend();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#resume()
	 */
	public void resume() {
		for (ThreadController controler : controllers.values()) {
			controler.resume();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#variable(java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.Object)
	 */
	public void variable(String threadName, String declarationTypeName, String name, Object value) {
		target.handleEvent(new VariableReply(threadName, declarationTypeName, name, value));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#deleteVariable(java.lang.String, java.lang.String)
	 */
	public void deleteVariable(String threadName, String name) {
		target.handleEvent(new DeleteVariableReply(threadName, name));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#pushStackFrame(java.lang.String, java.lang.String,
	 *      org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	public void pushStackFrame(String threadName, String frameName, EObject context, EObject instruction) {
		currentInstructions.put(threadName, instruction);
		target.handleEvent(new PushStackFrameReply(threadName, frameName, context, instruction, canStepInto(
				threadName, instruction)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#popStackFrame(java.lang.String)
	 */
	public void popStackFrame(String threadName) {
		target.handleEvent(new PopStackFrameReply(threadName));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#setCurrentInstruction(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void setCurrentInstruction(String threadName, EObject instruction) {
		currentInstructions.put(threadName, instruction);
		target.handleEvent(new SetCurrentInstructionReply(threadName, instruction, canStepInto(threadName,
				instruction)));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#terminated(java.lang.String)
	 */
	public void terminated(String threadName) {
		target.handleEvent(new TerminatedReply(threadName));
		controllers.remove(threadName);
		if (controllers.size() == 0) {
			setTerminated(true);
			terminated();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#isTerminated(java.lang.String)
	 */
	public boolean isTerminated(String threadName) {
		return !controllers.containsKey(threadName);
	}

}
