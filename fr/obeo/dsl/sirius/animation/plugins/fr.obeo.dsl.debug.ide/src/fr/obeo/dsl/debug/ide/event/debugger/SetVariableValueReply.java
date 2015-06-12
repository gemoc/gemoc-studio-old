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

/**
 * Reply sent when the value of a variable has been changed after a request.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SetVariableValueReply extends AbstractVariableReply {

	/**
	 * The value to set.
	 */
	Object value;

	/**
	 * Constructor for {@link fr.obeo.dsl.debug.Thread Thread}.
	 * 
	 * @param threadName
	 *            the {@link fr.obeo.dsl.debug.Thread#getName() thread name}
	 * @param stackName
	 *            the {@link fr.obeo.dsl.debug.StackFrame#getName() stack frame name}
	 * @param variableName
	 *            the {@link fr.obeo.dsl.debug.Variable#getName() variable name}
	 * @param value
	 *            the value to set
	 */
	public SetVariableValueReply(String threadName, String stackName, String variableName, Object value) {
		super(threadName, stackName, variableName);
		this.value = value;
	}

	/**
	 * Gets the value to set.
	 * 
	 * @return the value to set
	 */
	public Object getValue() {
		return value;
	}
}
