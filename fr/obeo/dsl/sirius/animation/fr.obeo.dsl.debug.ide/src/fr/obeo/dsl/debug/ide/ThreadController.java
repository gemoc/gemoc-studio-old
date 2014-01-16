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

import fr.obeo.dsl.debug.ide.IDSLDebugger.Stepping;

import org.eclipse.emf.ecore.EObject;

/**
 * Controls the execution of a Java {@link Thread}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ThreadController {

	/**
	 * The {@link IDSLDebugger} responsible for the Java {@link Thread}.
	 */
	private final IDSLDebugger debugger;

	/**
	 * The thread name.
	 */
	private final String threadName;

	/**
	 * The next instruction to suspend after a step if any, <code>null</code> otherwise.
	 */
	private EObject nextIntructionToSuspend;

	/**
	 * Determines if execution is suspended.
	 */
	private boolean suspended;

	/**
	 * Determines if execution is terminated.
	 */
	private boolean terminated;

	/**
	 * Determines if the execution is terminated.
	 */
	private Stepping stepping = Stepping.NONE;

	/**
	 * Tells if we were signaled with {@link Object#notify()}.
	 */
	private boolean wasSignalled;

	/**
	 * Constructor.
	 * 
	 * @param debugger
	 *            the {@link IDSLDebugger} responsible for the Java {@link Thread}
	 * @param threadName
	 *            the name of the thread
	 */
	public ThreadController(IDSLDebugger debugger, String threadName) {
		this.debugger = debugger;
		this.threadName = threadName;
	}

	/**
	 * Suspend on the next {@link ThreadController#control(EObject) controlled} {@link EObject instruction}.
	 */
	public void suspend() {
		this.suspended = true;
		stepping = Stepping.NONE;
	}

	/**
	 * Resume the execution.
	 */
	public synchronized void resume() {
		suspended = false;
		stepping = Stepping.NONE;
		wakeUp();
	}

	/**
	 * Terminates.
	 */
	public synchronized void terminate() {
		terminated = true;
		suspended = false;
		stepping = Stepping.NONE;
		wakeUp();
	}

	/**
	 * Resumes for a step into.
	 */
	public synchronized void stepInto() {
		this.suspended = false;
		stepping = Stepping.STEP_INTO;
		wakeUp();
	}

	/**
	 * Resumes for a step over.
	 */
	public synchronized void stepOver() {
		this.suspended = false;
		stepping = Stepping.STEP_OVER;
		wakeUp();
	}

	/**
	 * Resumes for a step return.
	 */
	public synchronized void stepReturn() {
		this.suspended = false;
		stepping = Stepping.STEP_RETURN;
		wakeUp();
	}

	/**
	 * Wakes up the {@link Thread}.
	 */
	public synchronized void wakeUp() {
		wasSignalled = true;
		notify();
	}

	/**
	 * Puts the {@link Thread} asleep.
	 */
	public synchronized void putAsleep() {
		while (!wasSignalled) {
			try {
				wait();
			} catch (InterruptedException e) {
				Activator.getDefault().error(e);
			}
		}
		wasSignalled = false;
	}

	/**
	 * Controls the given instruction.
	 * 
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @return <code>false</code> if execution shall stop, <code>true</code> if execution shall continue
	 */
	public synchronized boolean control(EObject instruction) {
		boolean res = !debugger.isTerminated() && !terminated;
		if (res) {
			if (this.suspended) { // client request
				debugger.suspended(threadName);
				debugger.updateData(threadName, instruction);
				putAsleep();
				resuming(instruction);
			} else if (debugger.shouldBreak(instruction)) { // breakpoint
				debugger.breaked(threadName);
				debugger.updateData(threadName, instruction);
				putAsleep();
				resuming(instruction);
			} else if (stepping != Stepping.NONE) { // stepping
				if (nextIntructionToSuspend == null || nextIntructionToSuspend == instruction) {
					debugger.stepped(threadName);
					debugger.updateData(threadName, instruction);
					putAsleep();
					resuming(instruction);
				}
			}
		}
		return res;
	}

	/**
	 * Resumes.
	 * 
	 * @param instruction
	 *            the {@link EObject instruction}
	 */
	private void resuming(EObject instruction) {

		switch (stepping) {
			case STEP_INTO:
				debugger.steppingInto(threadName);
				nextIntructionToSuspend = debugger.getNextInstruction(threadName, instruction, stepping);
				break;

			case STEP_OVER:
				debugger.steppingOver(threadName);
				nextIntructionToSuspend = debugger.getNextInstruction(threadName, instruction, stepping);
				break;

			case STEP_RETURN:
				debugger.steppingReturn(threadName);
				nextIntructionToSuspend = debugger.getNextInstruction(threadName, instruction, stepping);
				break;

			default:
				if (!terminated) {
					debugger.resuming(threadName); // client resume request
				} else {
					debugger.terminated(threadName); // terminated
				}
				break;
		}

	}

}
