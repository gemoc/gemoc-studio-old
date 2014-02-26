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
package fr.obeo.dsl.debug.ide.event.debugger;

import org.eclipse.emf.ecore.EObject;

/**
 * Reply sent when the thread has to set the current instrcution.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SetCurrentInstructionReply extends AbstractThreadReply {

	/**
	 * The current instruction.
	 */
	private final EObject instruction;

	/**
	 * Tells if we can step into the current instruction.
	 */
	private final boolean canStepInto;

	/**
	 * Constructor for {@link fr.obeo.dsl.debug.Thread Thread}.
	 * 
	 * @param threadName
	 *            the {@link fr.obeo.dsl.debug.Thread#getName() thread name}
	 * @param instruction
	 *            the current instruction
	 * @param canStepInto
	 *            tells if we can step into the current instruction
	 */
	public SetCurrentInstructionReply(String threadName, EObject instruction, boolean canStepInto) {
		super(threadName);
		this.instruction = instruction;
		this.canStepInto = canStepInto;
	}

	/**
	 * Gets the current instruction.
	 * 
	 * @return the current instruction
	 */
	public EObject getInstruction() {
		return instruction;
	}

	/**
	 * Tells if we can step into the current instruction.
	 * 
	 * @return <code>true</code> if we can step into the current instruction, <code>false</code> otherwise
	 */
	public boolean isCanStepInto() {
		return canStepInto;
	}

}
