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

import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

import org.eclipse.emf.ecore.EObject;

/**
 * An {@link AbstractDSLDebugger} for test purpose.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TestDSLDebugger extends AbstractDSLDebugger {

	/**
	 * A call to {@link IDSLDebugger#disconnect()} call has been made.
	 */
	private boolean disconnectCall;

	/**
	 * A call to {@link IDSLDebugger#start()} call has been made.
	 */
	private boolean startCall;

	/**
	 * A call to {@link IDSLDebugger#stepInto(String)} call has been made.
	 */
	private boolean stepIntoCall;

	/**
	 * A call to {@link IDSLDebugger#stepOver(String)} call has been made.
	 */
	private boolean stepOverCall;

	/**
	 * A call to {@link IDSLDebugger#stepReturn(String)} call has been made.
	 */
	private boolean stepReturnCall;

	/**
	 * A call to {@link IDSLDebugger#resume()} call has been made.
	 */
	private boolean resumeCall;

	/**
	 * A call to {@link IDSLDebugger#resume(String)} call has been made.
	 */
	private boolean resumeThreadCall;

	/**
	 * A call to {@link IDSLDebugger#suspend()} call has been made.
	 */
	private boolean suspendCall;

	/**
	 * A call to {@link IDSLDebugger#suspend(String)} call has been made.
	 */
	private boolean suspendThreadCall;

	/**
	 * A call to {@link IDSLDebugger#terminate()} call has been made.
	 */
	private boolean terminateCall;

	/**
	 * A call to {@link IDSLDebugger#terminate(String)} call has been made.
	 */
	private boolean terminateThreadCall;

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
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#start()
	 */
	public void start() {
		startCall = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#disconnect()
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
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#canStepInto(java.lang.String, org.eclipse.emf.ecore.EObject)
	 */
	public boolean canStepInto(String threadName, EObject instruction) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#updateData(java.lang.String, org.eclipse.emf.ecore.EObject)
	 */
	public void updateData(String threadName, EObject instruction) {
		// TODO Auto-generated method stub

	}

	/**
	 * A call to {@link IDSLDebugger#disconnect()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#disconnect()} has been made.
	 */
	public boolean hasDisconnectCall() {
		return disconnectCall;
	}

	/**
	 * A call to {@link IDSLDebugger#start()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#start()} has been made.
	 */
	public boolean hasStartCall() {
		return startCall;
	}

	/**
	 * A call to {@link IDSLDebugger#stepInto(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#stepInto(String)} has been made.
	 */
	public boolean hasStepIntoCall() {
		return stepIntoCall;
	}

	/**
	 * A call to {@link IDSLDebugger#stepOver(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#stepOver(String)} has been made.
	 */
	public boolean hasStepOverCall() {
		return stepOverCall;
	}

	/**
	 * A call to {@link IDSLDebugger#stepReturn(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#stepReturn(String)} has been made.
	 */
	public boolean hasStepReturnCall() {
		return stepReturnCall;
	}

	/**
	 * A call to {@link IDSLDebugger#resume()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#resume()} has been made.
	 */
	public boolean hasResumeCall() {
		return resumeCall;
	}

	/**
	 * A call to {@link IDSLDebugger#resume(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#resume(String)} has been made.
	 */
	public boolean hasResumeThreadCall() {
		return resumeThreadCall;
	}

	/**
	 * A call to {@link IDSLDebugger#suspend()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#suspend()} has been made.
	 */
	public boolean hasSuspendCall() {
		return suspendCall;
	}

	/**
	 * A call to {@link IDSLDebugger#suspend(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#suspend(String)} has been made.
	 */
	public boolean hasSuspendThreadCall() {
		return suspendThreadCall;
	}

	/**
	 * A call to {@link IDSLDebugger#terminate()} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#terminate()} has been made.
	 */
	public boolean hasTerminateCall() {
		return terminateCall;
	}

	/**
	 * A call to {@link IDSLDebugger#terminate(String)} call has been made.
	 * 
	 * @return <code>true</code> if a call to {@link IDSLDebugger#terminate(String)} has been made.
	 */
	public boolean hasTerminateThreadCall() {
		return terminateThreadCall;
	}

}
