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

/**
 * A {@link fr.obeo.dsl.debug.Thread thread} contextual {@link IDSLModelRequest request}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractVariableRequest extends AbstractThreadRequest {

	/**
	 * The {@link fr.obeo.dsl.debug.StackFrame#getName() stack name}.
	 */
	private final String stackName;

	/**
	 * The {@link fr.obeo.dsl.debug.Variable#getName() variable name}.
	 */
	private final String variableName;

	/**
	 * Constructor.
	 * 
	 * @param threadName
	 *            the {@link fr.obeo.dsl.debug.Thread#getName() thread name}
	 * @param stackName
	 *            the {@link fr.obeo.dsl.debug.StackFrame#getName() thread name}
	 * @param variableName
	 *            the {@link fr.obeo.dsl.debug.Variable#getName() variable name}
	 */
	public AbstractVariableRequest(String threadName, String stackName, String variableName) {
		super(threadName);
		this.stackName = stackName;
		this.variableName = variableName;
	}

	/**
	 * Gets the {@link fr.obeo.dsl.debug.StackFrame#getName() stack name}.
	 * 
	 * @return the {@link fr.obeo.dsl.debug.StackFrame#getName() stack name}
	 */
	public String getStackName() {
		return stackName;
	}

	/**
	 * Gets the {@link fr.obeo.dsl.debug.Variable#getName() variable name}.
	 * 
	 * @return the {@link fr.obeo.dsl.debug.Variable#getName() variable name}
	 */
	public String getVariableName() {
		return variableName;
	}

}
