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
package fr.obeo.dsl.workspace.listener.tests.filter;

import fr.obeo.dsl.workspace.listener.filter.And;
import fr.obeo.dsl.workspace.listener.filter.IFilter;
import fr.obeo.dsl.workspace.listener.tests.change.TestChange;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link And} class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class AndTests {

	/**
	 * Tests {@link And#keep(fr.obeo.dsl.workspace.listener.change.IChange)} <code>true</code> and
	 * <code>true</code>.
	 */
	@Test
	public void filterTrueTrue() {
		final And and = new And(IFilter.TRUE, IFilter.TRUE);

		final TestChange change = new TestChange();
		assertEquals(change, and.keep(change));
	}

	/**
	 * Tests {@link And#keep(fr.obeo.dsl.workspace.listener.change.IChange)} <code>true</code> and
	 * <code>false</code>.
	 */
	@Test
	public void filterTrueFalse() {
		final And and = new And(IFilter.TRUE, IFilter.FALSE);

		assertEquals(null, and.keep(new TestChange()));
	}

	/**
	 * Tests {@link And#keep(fr.obeo.dsl.workspace.listener.change.IChange)} <code>false</code> and
	 * <code>true</code>.
	 */
	@Test
	public void filterFalseTrue() {
		final And and = new And(IFilter.FALSE, IFilter.TRUE);

		assertEquals(null, and.keep(new TestChange()));
	}

	/**
	 * Tests {@link And#keep(fr.obeo.dsl.workspace.listener.change.IChange)} <code>false</code> and
	 * <code>false</code>.
	 */
	@Test
	public void filterFalseFalse() {
		final And and = new And(IFilter.FALSE, IFilter.FALSE);

		assertEquals(null, and.keep(new TestChange()));
	}

}
