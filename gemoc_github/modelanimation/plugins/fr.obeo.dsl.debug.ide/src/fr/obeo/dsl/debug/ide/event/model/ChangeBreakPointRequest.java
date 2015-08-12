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

import java.io.Serializable;

import org.eclipse.emf.common.util.URI;

/**
 * Request sent to change a breakpoint.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ChangeBreakPointRequest extends AbstractBreakpointRequest {

	/**
	 * The attribute to change.
	 */
	private final String attribute;

	/**
	 * The new value of the attribute.
	 */
	private final Serializable value;

	/**
	 * Constructor.
	 * 
	 * @param uri
	 *            the {@link URI} pointing the {@link rg.eclipse.emf.ecore.EObject instruction}
	 * @param attribute
	 *            the attribute to change
	 * @param value
	 *            the new value of the attribute
	 */
	public ChangeBreakPointRequest(URI uri, String attribute, Serializable value) {
		super(uri);
		this.attribute = attribute;
		this.value = value;
	}

	/**
	 * Gets the attribute to change.
	 * 
	 * @return the attribute to change
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * Gets the new value of the attribute.
	 * 
	 * @return the new value of the attribute
	 */
	public Serializable getValue() {
		return value;
	}

}
