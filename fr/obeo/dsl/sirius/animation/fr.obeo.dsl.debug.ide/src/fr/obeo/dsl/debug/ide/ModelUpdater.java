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

import org.eclipse.emf.ecore.EObject;

/**
 * An EMF {@link IModelUpdater}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ModelUpdater implements IModelUpdater {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminateRequest(fr.obeo.dsl.debug.DebugTarget)
	 */
	public void terminateRequest(DebugTarget target) {
		DebugTargetUtils.terminateRequest(target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#disconnectRequest(fr.obeo.dsl.debug.DebugTarget)
	 */
	public void disconnectRequest(DebugTarget target) {
		DebugTargetUtils.disconnectRequest(target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#spawnRunningThreadReply(fr.obeo.dsl.debug.DebugTarget,
	 *      java.lang.String, org.eclipse.emf.ecore.EObject)
	 */
	public void spawnRunningThreadReply(DebugTarget target, String threadName, EObject threadContext) {
		DebugTargetUtils.spawnRunningThreadReply(target, threadName, threadContext);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminatedReply(fr.obeo.dsl.debug.DebugTarget)
	 */
	public void terminatedReply(DebugTarget target) {
		DebugTargetUtils.terminatedReply(target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#deleteVariableReply(fr.obeo.dsl.debug.Thread,
	 *      java.lang.String)
	 */
	public void deleteVariableReply(Thread thread, String name) {
		ThreadUtils.deleteVariableReply(thread, name);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#popStackFrameReply(fr.obeo.dsl.debug.Thread)
	 */
	public void popStackFrameReply(Thread thread) {
		ThreadUtils.popStackFrameReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#pushStackFrameReply(fr.obeo.dsl.debug.Thread,
	 *      java.lang.String, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, boolean)
	 */
	public void pushStackFrameReply(Thread thread, String name, EObject context, EObject instruction,
			boolean canStepInto) {
		ThreadUtils.pushStackFrameReply(thread, name, context, instruction, canStepInto);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#stepIntoReply(fr.obeo.dsl.debug.Thread)
	 */
	public void stepIntoReply(Thread thread) {
		ThreadUtils.stepIntoReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#stepOverReply(fr.obeo.dsl.debug.Thread)
	 */
	public void stepOverReply(Thread thread) {
		ThreadUtils.stepOverReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#stepReturnReply(fr.obeo.dsl.debug.Thread)
	 */
	public void stepReturnReply(Thread thread) {
		ThreadUtils.stepReturnReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#resumedReply(fr.obeo.dsl.debug.Thread)
	 */
	public void resumedReply(Thread thread) {
		ThreadUtils.resumedReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#setCurrentInstructionReply(fr.obeo.dsl.debug.Thread,
	 *      org.eclipse.emf.ecore.EObject, boolean)
	 */
	public void setCurrentInstructionReply(Thread thread, EObject instruction, boolean canStepInto) {
		ThreadUtils.setCurrentInstructionReply(thread, instruction, canStepInto);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#suspendedReply(fr.obeo.dsl.debug.Thread)
	 */
	public void suspendedReply(Thread thread) {
		ThreadUtils.suspendedReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminatedReply(fr.obeo.dsl.debug.Thread)
	 */
	public void terminatedReply(Thread thread) {
		ThreadUtils.terminatedReply(thread);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#setVariableReply(fr.obeo.dsl.debug.Thread, java.lang.String,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setVariableReply(Thread thread, String declarationTypeName, String name, Object value) {
		ThreadUtils.setVariableReply(thread, declarationTypeName, name, value);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.IModelUpdater#terminateRequest(fr.obeo.dsl.debug.Thread)
	 */
	public void terminateRequest(Thread thread) {
		ThreadUtils.terminateRequest(thread);
	}

}
