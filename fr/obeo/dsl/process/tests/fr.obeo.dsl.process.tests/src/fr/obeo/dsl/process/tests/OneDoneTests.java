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
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the class {@link OneDone}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class OneDoneTests {

	/**
	 * Tests {@link fr.obeo.dsl.process.Expression#check(fr.obeo.dsl.process.ProcessContext)} with no
	 * {@link r.obeo.dsl.process.TasksExpression#getTasks() tasks}.
	 */
	@Test
	public void checkNoTasks() {
		final OneDone expression = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		assertEquals(false, expression.check(context));
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.Expression#check(fr.obeo.dsl.process.ProcessContext)} with none done.
	 */
	@Test
	public void checkNoneDone() {
		final OneDone expression = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		expression.getTasks().add(task1);
		expression.getTasks().add(task2);
		expression.getTasks().add(task3);

		assertEquals(false, expression.check(context));
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.Expression#check(fr.obeo.dsl.process.ProcessContext)} with one done.
	 */
	@Test
	public void checkOneDone() {
		final OneDone expression = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		expression.getTasks().add(task1);
		expression.getTasks().add(task2);
		expression.getTasks().add(task3);

		context.getProgress().put(task1, null);

		assertEquals(true, expression.check(context));
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.Expression#check(fr.obeo.dsl.process.ProcessContext)} with two done.
	 */
	@Test
	public void checkTwoDone() {
		final OneDone expression = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		expression.getTasks().add(task1);
		expression.getTasks().add(task2);
		expression.getTasks().add(task3);

		context.getProgress().put(task1, null);
		context.getProgress().put(task2, null);

		assertEquals(false, expression.check(context));
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.Expression#check(fr.obeo.dsl.process.ProcessContext)} with all done.
	 */
	@Test
	public void checkAllDone() {
		final OneDone expression = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		expression.getTasks().add(task1);
		expression.getTasks().add(task2);
		expression.getTasks().add(task3);

		context.getProgress().put(task1, null);
		context.getProgress().put(task2, null);
		context.getProgress().put(task3, null);

		assertEquals(false, expression.check(context));
	}

}
