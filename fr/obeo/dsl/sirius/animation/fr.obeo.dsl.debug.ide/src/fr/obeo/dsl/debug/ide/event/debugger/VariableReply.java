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
 * Reply sent when the thread has a new variable.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class VariableReply extends AbstractThreadReply {

	/**
	 * The declaration type name.
	 */
	private final String declarationTypeName;

	/**
	 * The variable name.
	 */
	private final String name;

	/**
	 * The variable values.
	 */
	private final Object value;

	/**
	 * Constructor for {@link fr.obeo.dsl.debug.Thread Thread}.
	 * 
	 * @param threadName
	 *            the {@link fr.obeo.dsl.debug.Thread#getName() thread name}
	 * @param declarationTypeName
	 *            the declaration type name
	 * @param name
	 *            the variable name
	 * @param value
	 *            the variable value
	 */
	public VariableReply(String threadName, String declarationTypeName, String name, Object value) {
		super(threadName);
		this.declarationTypeName = declarationTypeName;
		this.name = name;
		this.value = value;
	}

	/**
	 * Gets the declaration type name.
	 * 
	 * @return the declaration type name
	 */
	public String getDeclarationTypeName() {
		return declarationTypeName;
	}

	/**
	 * Gets the variable name.
	 * 
	 * @return the variable name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the variable value.
	 * 
	 * @return the variable value
	 */
	public Object getValue() {
		return value;
	}

}
