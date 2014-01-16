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

import fr.obeo.dsl.debug.DebugTarget;
import fr.obeo.dsl.debug.DebugTargetUtils;
import fr.obeo.dsl.debug.Thread;
import fr.obeo.dsl.debug.ThreadUtils;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * An EMF transaction {@link IModelUpdater}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TransactionalModelUpdater extends ModelUpdater {

	/**
	 * The {@link TransactionalEditingDomain} to use.
	 */
	protected final TransactionalEditingDomain domain;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 *            the {@link TransactionalEditingDomain} to use
	 */
	public TransactionalModelUpdater(TransactionalEditingDomain domain) {
		this.domain = domain;
	}

	/**
	 * Executes the given {@link Command}.
	 * 
	 * @param command
	 *            the {@link Command}
	 */
	protected void doExecute(Command command) {
		domain.getCommandStack().execute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminateRequest(fr.obeo.dsl.debug.DebugTarget)
	 */
	public void terminateRequest(final DebugTarget target) {
		final Command command = new RecordingCommand(domain, "Terminate Request") {

			@Override
			protected void doExecute() {
				DebugTargetUtils.terminateRequest(target);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#disconnectRequest(fr.obeo.dsl.debug.DebugTarget)
	 */
	public void disconnectRequest(final DebugTarget target) {
		final Command command = new RecordingCommand(domain, "Disconnect Request") {

			@Override
			protected void doExecute() {
				DebugTargetUtils.disconnectRequest(target);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#spawnRunningThreadReply(fr.obeo.dsl.debug.DebugTarget,
	 *      java.lang.String, org.eclipse.emf.ecore.EObject)
	 */
	public void spawnRunningThreadReply(final DebugTarget target, final String threadName,
			final EObject threadContext) {
		final Command command = new RecordingCommand(domain, "Spawn Running Thread Reply") {

			@Override
			protected void doExecute() {
				DebugTargetUtils.spawnRunningThreadReply(target, threadName, threadContext);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminatedReply(fr.obeo.dsl.debug.DebugTarget)
	 */
	public void terminatedReply(final DebugTarget target) {
		final Command command = new RecordingCommand(domain, "Terminated Reply") {

			@Override
			protected void doExecute() {
				DebugTargetUtils.terminatedReply(target);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#deleteVariableReply(fr.obeo.dsl.debug.Thread,
	 *      java.lang.String)
	 */
	public void deleteVariableReply(final Thread thread, final String name) {
		final Command command = new RecordingCommand(domain, "Delete Variable Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.deleteVariableReply(thread, name);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#popStackFrameReply(fr.obeo.dsl.debug.Thread)
	 */
	public void popStackFrameReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Pop Stack Frame Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.popStackFrameReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#pushStackFrameReply(fr.obeo.dsl.debug.Thread,
	 *      java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, boolean)
	 */
	public void pushStackFrameReply(final Thread thread, final String name, final EObject context,
			final EObject instruction, final boolean canStepInto) {
		final Command command = new RecordingCommand(domain, "Push Stack Frame Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.pushStackFrameReply(thread, name, context, instruction, canStepInto);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#stepIntoReply(fr.obeo.dsl.debug.Thread)
	 */
	public void stepIntoReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Step Into Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.stepIntoReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#stepOverReply(fr.obeo.dsl.debug.Thread)
	 */
	public void stepOverReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Step Over Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.stepOverReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#stepReturnReply(fr.obeo.dsl.debug.Thread)
	 */
	public void stepReturnReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Step Return Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.stepReturnReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#resumedReply(fr.obeo.dsl.debug.Thread)
	 */
	public void resumedReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Resumed Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.resumedReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#setCurrentInstructionReply(fr.obeo.dsl.debug.Thread,
	 *      org.eclipse.emf.ecore.EObject, boolean)
	 */
	public void setCurrentInstructionReply(final Thread thread, final EObject instruction,
			final boolean canStepInto) {
		final Command command = new RecordingCommand(domain, "Set Current Instruction Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.setCurrentInstructionReply(thread, instruction, canStepInto);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#suspendedReply(fr.obeo.dsl.debug.Thread)
	 */
	public void suspendedReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Suspended Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.suspendedReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminatedReply(fr.obeo.dsl.debug.Thread)
	 */
	public void terminatedReply(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Terminated Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.terminatedReply(thread);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#setVariableReply(fr.obeo.dsl.debug.Thread, java.lang.String,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setVariableReply(final Thread thread, final String declarationTypeName, final String name,
			final Object value) {
		final Command command = new RecordingCommand(domain, "Set Variable Reply") {

			@Override
			protected void doExecute() {
				ThreadUtils.setVariableReply(thread, declarationTypeName, name, value);
			}

		};
		doExecute(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminateRequest(fr.obeo.dsl.debug.Thread)
	 */
	public void terminateRequest(final Thread thread) {
		final Command command = new RecordingCommand(domain, "Terminate Request") {

			@Override
			protected void doExecute() {
				ThreadUtils.terminateRequest(thread);
			}

		};
		doExecute(command);
	}

}
