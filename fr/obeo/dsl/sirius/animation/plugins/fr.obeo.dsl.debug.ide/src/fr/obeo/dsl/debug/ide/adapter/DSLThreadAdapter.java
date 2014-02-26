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
package fr.obeo.dsl.debug.ide.adapter;

import fr.obeo.dsl.debug.StackFrame;
import fr.obeo.dsl.debug.State;
import fr.obeo.dsl.debug.Thread;
import fr.obeo.dsl.debug.ThreadUtils;
import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.DSLEclipseDebugIntegration;
import fr.obeo.dsl.debug.ide.event.model.ResumeRequest;
import fr.obeo.dsl.debug.ide.event.model.StepIntoRequest;
import fr.obeo.dsl.debug.ide.event.model.StepOverRequest;
import fr.obeo.dsl.debug.ide.event.model.StepReturnRequest;
import fr.obeo.dsl.debug.ide.event.model.SuspendRequest;
import fr.obeo.dsl.debug.ide.event.model.TerminateRequest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * The {@link Thread} DSL debug model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLThreadAdapter extends AbstractDSLDebugElementAdapter implements IThread {

	/**
	 * Constructor.
	 * 
	 * @param factory
	 *            the {@link DSLEclipseDebugIntegration} factory
	 */
	public DSLThreadAdapter(DSLEclipseDebugIntegration factory) {
		super(factory);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || type == IThread.class;
	}

	/**
	 * Gets the {@link Thread}.
	 * 
	 * @return the {@link Thread}
	 */
	protected Thread getHost() {
		assert target instanceof Thread;
		return (Thread)target;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return ThreadUtils.canResume(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return ThreadUtils.canSuspend(getHost());
	}

	public boolean isSuspended() {
		return ThreadUtils.isSuspended(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		factory.getDebugger().handleEvent(new ResumeRequest(getHost().getName()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		factory.getDebugger().handleEvent(new SuspendRequest(getHost().getName()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		return ThreadUtils.canStepInto(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		return ThreadUtils.canStepOver(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		return ThreadUtils.canStepReturn(getHost());
	}

	public boolean isStepping() {
		return ThreadUtils.isStepping(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		factory.getDebugger()
				.handleEvent(
						new StepIntoRequest(getHost().getName(), getHost().getTopStackFrame()
								.getCurrentInstruction()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		factory.getDebugger()
				.handleEvent(
						new StepOverRequest(getHost().getName(), getHost().getTopStackFrame()
								.getCurrentInstruction()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {
		factory.getDebugger().handleEvent(
				new StepReturnRequest(getHost().getName(), getHost().getTopStackFrame()
						.getCurrentInstruction()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return ThreadUtils.canTerminate(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return getHost().getState() == State.TERMINATED;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		factory.getModelUpdater().terminateRequest(getHost());
		factory.getDebugger().handleEvent(new TerminateRequest(getHost().getName()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getStackFrames()
	 */
	public IStackFrame[] getStackFrames() throws DebugException {
		List<IStackFrame> res = new ArrayList<IStackFrame>();

		if (isSuspended()) {
			StackFrame currentFrame = getHost().getTopStackFrame();
			while (currentFrame != null) {
				res.add(factory.getStackFrame(currentFrame));
				currentFrame = currentFrame.getParentFrame();
			}
		}

		return res.toArray(new IStackFrame[res.size()]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IThread#hasStackFrames()
	 */
	public boolean hasStackFrames() throws DebugException {
		return getHost().getTopStackFrame() != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getPriority()
	 */
	public int getPriority() throws DebugException {
		return getHost().getPriority();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getTopStackFrame()
	 */
	public IStackFrame getTopStackFrame() throws DebugException {
		final IStackFrame res;
		if (getHost().getTopStackFrame() != null) {
			res = factory.getStackFrame(getHost().getTopStackFrame());
		} else {
			res = null;
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getName()
	 */
	public String getName() throws DebugException {
		return getHost().getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IThread#getBreakpoints()
	 */
	public IBreakpoint[] getBreakpoints() {
		final List<IBreakpoint> res = new ArrayList<IBreakpoint>();

		if (isSuspended()) {
			final URI instructionUri = EcoreUtil.getURI(getHost().getTopStackFrame().getCurrentInstruction());
			for (IBreakpoint breakpoint : DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
					getModelIdentifier())) {
				if (breakpoint instanceof DSLBreakpoint
						&& (((DSLBreakpoint)breakpoint).getURI().equals(instructionUri))) {
					res.add(breakpoint);
				}
			}
		}

		return res.toArray(new IBreakpoint[res.size()]);
	}

}
