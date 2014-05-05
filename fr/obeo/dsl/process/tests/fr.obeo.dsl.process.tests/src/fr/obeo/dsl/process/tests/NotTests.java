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
package fr.obeo.dsl.process.tests;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.AllDone;
import fr.obeo.dsl.process.Not;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the class {@link Not}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class NotTests {

	/**
	 * Tests {@link Not#check(ProcessContext)} with <code>false</code> {@link Not#getExpression() expression}.
	 */
	@Test
	public void checkFalse() {
		final Not expression = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final AllDone falseExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		falseExpression.getTasks().add(task1);
		expression.setExpression(falseExpression);

		assertEquals(true, expression.check(context));
	}

	/**
	 * Tests {@link Not#check(ProcessContext)} with <code>true</code> {@link Not#getExpression() expression}.
	 */
	@Test
	public void checkTrue() {
		final Not expression = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final AllDone trueExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		trueExpression.getTasks().add(task1);
		expression.setExpression(trueExpression);

		context.getProgress().put(task1, null);

		assertEquals(false, expression.check(context));
	}

}
