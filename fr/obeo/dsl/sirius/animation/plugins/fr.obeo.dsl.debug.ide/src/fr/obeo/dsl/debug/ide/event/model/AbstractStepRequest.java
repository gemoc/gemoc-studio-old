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
package fr.obeo.dsl.debug.ide.event.model;

import org.eclipse.emf.ecore.EObject;

/**
 * Request sent to step the execution of the debugger.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractStepRequest extends AbstractThreadRequest {

	/**
	 * The {@link EObject} representing the current instruction. NOTE: this instruction should only be used
	 * for synchronization checks.
	 */
	private final EObject instruction;

	/**
	 * Constructor.
	 * 
	 * @param threadName
	 *            the {@link fr.obeo.dsl.debug.Thread#getName() thread name}
	 * @param instruction
	 *            the {@link EObject} representing the current instruction
	 */
	public AbstractStepRequest(String threadName, EObject instruction) {
		super(threadName);
		this.instruction = instruction;
	}

	/**
	 * Gets the {@link EObject} representing the current instruction.
	 * 
	 * @return the {@link EObject} representing the current instruction
	 */
	public EObject getInstrcution() {
		return instruction;
	}

}
