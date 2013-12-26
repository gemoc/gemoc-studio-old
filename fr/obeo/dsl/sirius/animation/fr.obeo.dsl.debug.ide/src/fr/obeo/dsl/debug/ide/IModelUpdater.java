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
import fr.obeo.dsl.debug.Thread;

import org.eclipse.emf.ecore.EObject;

/**
 * Class responsible for EMF debug model updates.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IModelUpdater {

	/**
	 * Requests the termination the given {@link DebugTarget}. The {@link DebugTarget}
	 * {@link DebugTarget#getfr.obeo.dsl.debug.State() fr.obeo.dsl.debug.State} must be
	 * {@link fr.obeo.dsl.debug.DebugTargetfr.obeo.dsl.debug.State#CONNECTED connected}.
	 * 
	 * @param target
	 *            the {@link DebugTarget}
	 */
	void terminateRequest(DebugTarget target);

	/**
	 * Requests disconnection the given {@link DebugTarget}.
	 * 
	 * @param target
	 *            the {@link DebugTarget}
	 */
	void disconnectRequest(DebugTarget target);

	/**
	 * Spawn a running {@link Thread} in the given {@link DebugTarget}.
	 * 
	 * @param target
	 *            the {@link DebugTarget} that will contains the spawned {@link Thread}
	 * @param threadName
	 *            the {@link Thread#getName() thread name}
	 * @param threadContext
	 *            the {@link Thread#getContext() thread context}
	 */
	void spawnRunningThreadReply(DebugTarget target, String threadName, EObject threadContext);

	/**
	 * Notify the {@link fr.obeo.dsl.debug.DebugTargetUtils#terminateRequest(DebugTarget) termination} is done
	 * for the given {@link DebugTarget}. The {@link DebugTarget}
	 * {@link DebugTarget#getfr.obeo.dsl.debug.State() fr.obeo.dsl.debug.State} must be
	 * {@link fr.obeo.dsl.debug.DebugTargetfr.obeo.dsl.debug.State#TERMINATING terminating}.
	 * 
	 * @param target
	 *            the {@link DebugTarget}
	 */
	void terminatedReply(DebugTarget target);

	/**
	 * Notify the deletion of the {@link fr.obeo.dsl.debug.Variable Variable} with the given
	 * {@link fr.obeo.dsl.debug.Variable#getName() name} in the given {@link Thread}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 * @param name
	 *            the {@link fr.obeo.dsl.debug.Variable#getName() variable name}
	 */
	void deleteVariableReply(Thread thread, String name);

	/**
	 * Notify popping the {@link Thread#getTopStackFrame() top stack frame} of the given {@link Thread}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void popStackFrameReply(Thread thread);

	/**
	 * Notify pushing a new {@link fr.obeo.dsl.debug.StackFrame StackFrame} with the given
	 * {@link fr.obeo.dsl.debug.StackFrame#getName() name} in the given {@link Thread}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 * @param name
	 *            the {@link fr.obeo.dsl.debug.StackFrame#getName() stack frame name}
	 * @param context
	 *            the {@link fr.obeo.dsl.debug.StackFrame#getContext() context}
	 * @param instruction
	 *            the {@link fr.obeo.dsl.debug.StackFrame#getCurrentInstruction() current instruction}
	 * @param canStepInto
	 *            tells if we can {@link fr.obeo.dsl.debug.StackFrame#isCanStepIntoCurrentInstruction() step
	 *            into} the current instruction
	 */
	void pushStackFrameReply(Thread thread, String name, EObject context, EObject instruction,
			boolean canStepInto);

	/**
	 * Request to step into the given {@link Thread}. The {@link Thread}
	 * {@link Thread#getfr.obeo.dsl.debug.State() fr.obeo.dsl.debug.State} must be
	 * {@link fr.obeo.dsl.debug.State#SUSPENDED suspended}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void stepIntoReply(Thread thread);

	/**
	 * Request to step over the given {@link Thread}. The {@link Thread}
	 * {@link Thread#getfr.obeo.dsl.debug.State() fr.obeo.dsl.debug.State} must be
	 * {@link fr.obeo.dsl.debug.State#SUSPENDED suspended}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void stepOverReply(Thread thread);

	/**
	 * Request to step return the given {@link Thread}. The {@link Thread}
	 * {@link Thread#getfr.obeo.dsl.debug.State() fr.obeo.dsl.debug.State} must be
	 * {@link fr.obeo.dsl.debug.State#SUSPENDED suspended} and the {@link Thread#getTopStackFrame() top stack
	 * frame} must has a {@link fr.obeo.dsl.debug.StackFrame#getParentFrame() parent frame}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void stepReturnReply(Thread thread);

	/**
	 * Requests resuming the given {@link Thread}. The {@link Thread} fr.obeo.dsl.debug.State must be
	 * {@link fr.obeo.dsl.debug.State#SUSPENDED suspended}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void resumedReply(Thread thread);

	/**
	 * Sets the {@link fr.obeo.dsl.debug.StackFrame#getCurrentInstruction() current instruction} of the
	 * {@link Thread#getTopStackFrame() top stack frame} of the given {@link Thread}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 * @param instruction
	 *            the {@link fr.obeo.dsl.debug.StackFrame#getCurrentInstruction() current instruction}
	 * @param canStepInto
	 *            tells if we can {@link fr.obeo.dsl.debug.StackFrame#isCanStepIntoCurrentInstruction() step
	 *            into the current instruction}
	 */
	void setCurrentInstructionReply(Thread thread, EObject instruction, boolean canStepInto);

	/**
	 * Notify the suspension of the given {@link Thread} to the given
	 * {@link fr.obeo.dsl.debug.StackFrame#getCurrentInstruction() instruction}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void suspendedReply(Thread thread);

	/**
	 * Notify the {@link terminateRequest termination} is done for the given {@link Thread} . The
	 * {@link Thread} {@link Thread#getfr.obeo.dsl.debug.State() fr.obeo.dsl.debug.State} must be
	 * {@link fr.obeo.dsl.debug.State#TERMINATING terminating}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void terminatedReply(Thread thread);

	/**
	 * Notify sets the {@link fr.obeo.dsl.debug.Variable Variable} with the given
	 * {@link fr.obeo.dsl.debug.Variable#getName() name} from the {@link Thread#getTopStackFrame() top stack
	 * frame} of the given {@link Thread} to the given {@link EObject value}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 * @param declarationTypeName
	 *            the {@link fr.obeo.dsl.debug.Variable#getDeclarationType() declaration type name}
	 * @param name
	 *            the {@link fr.obeo.dsl.debug.Variable#getName() variable name}
	 * @param value
	 *            the {@link Object value} to set
	 */
	void setVariableReply(Thread thread, String declarationTypeName, String name, Object value);

	/**
	 * Requests the termination the given {@link Thread}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 */
	void terminateRequest(Thread thread);
}
