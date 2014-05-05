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
import fr.obeo.dsl.process.Or;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the class {@link Or}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class OrTests {

	/**
	 * Tests {@link Or#check(ProcessContext)} with <code>false</code> <code>false</code>
	 * {@link Or#getExpressions() expressions}.
	 */
	@Test
	public void checkFalseFalse() {
		final Or expression = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone falseExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		falseExpression.getTasks().add(task1);
		expression.getExpressions().add(falseExpression);
		expression.getExpressions().add(falseExpression);

		assertEquals(false, expression.check(context));
	}

	/**
	 * Tests {@link Or#check(ProcessContext)} with <code>true</code> <code>false</code>
	 * {@link Or#getExpressions() expressions}.
	 */
	@Test
	public void checkTrueFalse() {
		final Or expression = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone falseExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final AllDone trueExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		falseExpression.getTasks().add(task2);
		trueExpression.getTasks().add(task1);
		expression.getExpressions().add(falseExpression);
		expression.getExpressions().add(trueExpression);

		context.getProgress().put(task1, null);

		assertEquals(true, expression.check(context));
	}

	/**
	 * Tests {@link Or#check(ProcessContext)} with <code>false</code> <code>true</code>
	 * {@link Or#getExpressions() expressions}.
	 */
	@Test
	public void checkFalseTrue() {
		final Or expression = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone falseExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final AllDone trueExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		falseExpression.getTasks().add(task2);
		trueExpression.getTasks().add(task1);
		expression.getExpressions().add(trueExpression);
		expression.getExpressions().add(falseExpression);

		context.getProgress().put(task1, null);

		assertEquals(true, expression.check(context));
	}

	/**
	 * Tests {@link Or#check(ProcessContext)} with <code>true</code> <code>true</code>
	 * {@link Or#getExpressions() expressions}.
	 */
	@Test
	public void checkTrueTrue() {
		final Or expression = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone trueExpression = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		trueExpression.getTasks().add(task1);
		expression.getExpressions().add(trueExpression);
		expression.getExpressions().add(trueExpression);

		context.getProgress().put(task1, null);

		assertEquals(true, expression.check(context));
	}

}
