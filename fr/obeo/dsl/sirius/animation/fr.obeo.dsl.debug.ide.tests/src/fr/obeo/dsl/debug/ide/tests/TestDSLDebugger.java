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
package fr.obeo.dsl.debug.ide.tests;

import fr.obeo.dsl.debug.DebugPackage;
import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

import org.eclipse.emf.ecore.EObject;

/**
 * An {@link AbstractDSLDebugger} for test purpose.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TestDSLDebugger extends AbstractDSLDebugger {

	/**
	 * An interpreter.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private class Interpreter implements Runnable {
		/**
		 * {@inheritDoc}
		 * 
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			spawnRunningThread(Thread.currentThread().getName(), INSTRUCTION_1);
			boolean terminated = false;
			while (!terminated) {
				terminated = control(Thread.currentThread().getName(), INSTRUCTION_1);
				if (!terminated) {
					terminated = control(Thread.currentThread().getName(), INSTRUCTION_2);
				}
				if (!terminated) {
					terminated = control(Thread.currentThread().getName(), INSTRUCTION_3);
				}
			}
			if (isTerminated(Thread.currentThread().getName())) {
				terminate(Thread.currentThread().getName());
			}
		}
	}

	/**
	 * The thread name.
	 */
	public static final String THREAD_NAME_1 = "THREAD_1";

	/**
	 * The thread name.
	 */
	public static final String THREAD_NAME_2 = "THREAD_2";

	/**
	 * The first {@link EObject instruction}.
	 */
	public static final EObject INSTRUCTION_1 = DebugPackage.eINSTANCE.getDebugFactory().createVariable();

	/**
	 * The second {@link EObject instruction}.
	 */
	public static final EObject INSTRUCTION_2 = DebugPackage.eINSTANCE.getDebugFactory().createVariable();

	/**
	 * The third {@link EObject instruction}.
	 */
	public static final EObject INSTRUCTION_3 = DebugPackage.eINSTANCE.getDebugFactory().createVariable();

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#disconnect()} call has been made.
	 */
	private boolean disconnectCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#start()} call has been made.
	 */
	private boolean startCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepInto(String)} call has been made.
	 */
	private boolean stepIntoCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepOver(String)} call has been made.
	 */
	private boolean stepOverCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepReturn(String)} call has been made.
	 */
	private boolean stepReturnCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#resume()} call has been made.
	 */
	private boolean resumeCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#resume(String)} call has been made.
	 */
	private boolean resumeThreadCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#suspend()} call has been made.
	 */
	private boolean suspendCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#suspend(String)} call has been made.
	 */
	private boolean suspendThreadCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#terminate()} call has been made.
	 */
	private boolean terminateCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#terminate(String)} call has been made.
	 */
	private boolean terminateThreadCall;

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#updateData(String, EObject)} call has been made.
	 */
	private boolean updateDataCall;

	/**
	 * A call to
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#getNextInstruction(String, EObject, fr.obeo.dsl.debug.ide.IDSLDebugger.Stepping)}
	 * call has been made.
	 */
	private boolean getNextInstructionCall;

	/**
	 * Constructor.
	 * 
	 * @param target
	 *            the {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 *            communication or the {@link fr.obeo.dsl.debug.ide.DSLDebugTargetAdapter target} for
	 *            synchronous communication
	 */
	public TestDSLDebugger(IDSLDebugEventProcessor target) {
		super(target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.fr.obeo.dsl.debug.ide.IDSLDebugger#start()
	 */
	public void start() {
		startCall = true;
		new Thread(new Interpreter(), THREAD_NAME_1).start();
		new Thread(new Interpreter(), THREAD_NAME_2).start();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.fr.obeo.dsl.debug.ide.IDSLDebugger#disconnect()
	 */
	public void disconnect() {
		disconnectCall = true;
	}

	@Override
	public void stepInto(String threadName) {
		stepIntoCall = true;
		super.stepInto(threadName);
	}

	@Override
	public void stepOver(String threadName) {
		stepOverCall = true;
		super.stepOver(threadName);
	}

	@Override
	public void stepReturn(String threadName) {
		stepReturnCall = true;
		super.stepReturn(threadName);
	}

	@Override
	public void resume() {
		resumeCall = true;
		super.resume();
	}

	@Override
	public void resume(String threadName) {
		resumeThreadCall = true;
		super.resume(threadName);
	}

	@Override
	public void suspend() {
		suspendCall = true;
		super.suspend();
	}

	@Override
	public void suspend(String threadName) {
		suspendThreadCall = true;
		super.suspend(threadName);
	}

	@Override
	public void terminate() {
		terminateCall = true;
		super.terminate();
	}

	@Override
	public void terminate(String threadName) {
		terminateThreadCall = true;
		super.terminate(threadName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.fr.obeo.dsl.debug.ide.IDSLDebugger#canStepInto(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public boolean canStepInto(String threadName, EObject instruction) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.fr.obeo.dsl.debug.ide.IDSLDebugger#updateData(java.lang.String,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void updateData(String threadName, EObject instruction) {
		updateDataCall = true;
	}

	@Override
	public EObject getNextInstruction(String threadName, EObject currentInstruction, Stepping stepping) {
		getNextInstructionCall = true;
		return super.getNextInstruction(threadName, currentInstruction, stepping);
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#disconnect()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#disconnect()} has been
	 *         made.
	 */
	public boolean hasDisconnectCall() {
		return disconnectCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#start()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#start()} has been
	 *         made.
	 */
	public boolean hasStartCall() {
		return startCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepInto(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepInto(String)} has
	 *         been made.
	 */
	public boolean hasStepIntoCall() {
		return stepIntoCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepOver(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepOver(String)} has
	 *         been made.
	 */
	public boolean hasStepOverCall() {
		return stepOverCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepReturn(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#stepReturn(String)}
	 *         has been made.
	 */
	public boolean hasStepReturnCall() {
		return stepReturnCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#resume()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#resume()} has been
	 *         made.
	 */
	public boolean hasResumeCall() {
		return resumeCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#resume(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#resume(String)} has
	 *         been made.
	 */
	public boolean hasResumeThreadCall() {
		return resumeThreadCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#suspend()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#suspend()} has been
	 *         made.
	 */
	public boolean hasSuspendCall() {
		return suspendCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#suspend(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#suspend(String)} has
	 *         been made.
	 */
	public boolean hasSuspendThreadCall() {
		return suspendThreadCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#terminate()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#terminate()} has been
	 *         made.
	 */
	public boolean hasTerminateCall() {
		return terminateCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#terminate(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#terminate(String)} has
	 *         been made.
	 */
	public boolean hasTerminateThreadCall() {
		return terminateThreadCall;
	}

	/**
	 * A call to {@link fr.obeo.dsl.debug.ide.IDSLDebugger#updateData(String, EObject)} call has been made.
	 * 
	 * @return <code>true</code> if a call to
	 *         {@link fr.obeo.dsl.debug.ide.IDSLDebugger#updateData(String, EObject)} has been made.
	 */
	public boolean hasUpdateDataCall() {
		return updateDataCall;
	}

	/**
	 * A call to
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#getNextInstruction(String, EObject, fr.obeo.dsl.debug.ide.IDSLDebugger.Stepping)}
	 * call has been made.
	 * 
	 * @return <code>true</code> if a call to
	 *         {@link fr.obeo.dsl.debug.ide.IDSLDebugger#getNextInstruction(String, EObject, fr.obeo.dsl.debug.ide.IDSLDebugger.Stepping)}
	 *         has been made.
	 */
	public boolean hasGetNextInstructionCall() {
		return getNextInstructionCall;
	}

}
