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
package fr.obeo.dsl.process;

/**
 * Abstract implementation of {@link ActionTask#getInstanceClassName()}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IActionTaskProcessor {

	/**
	 * Validates it states in the given {@link ProcessContext} by calling
	 * {@link ProcessContext#setDone(ActionTask, Object)},
	 * {@link ProcessContext#setUndone(ActionTask, String)}. It can also manage {@link ProcessVariable} by
	 * calling {@link ProcessContext#setVariableValue(ProcessVariable, Object, ActionTask)}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	void validate(ProcessContext context);

	/**
	 * The given {@link ProcessVariable} has changed from the old value to the new value in the given
	 * {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @param oldValue
	 *            the old value
	 * @param newValue
	 *            the new value
	 */
	void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue, Object newValue);

	/**
	 * Executes the {@link ActionTask} in the given{@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	void doAction(ProcessContext context);

	/**
	 * Undoes execution of the {@link ActionTask} in the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	void undoAction(ProcessContext context);

	/**
	 * Gets the {@link ActionTask} definition.
	 * 
	 * @return the {@link ActionTask} definition
	 */
	ActionTask getActionTask();

}
