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
import fr.obeo.dsl.process.And;
import fr.obeo.dsl.process.AnyDone;
import fr.obeo.dsl.process.Expression;
import fr.obeo.dsl.process.ExpressionParser;
import fr.obeo.dsl.process.Not;
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.Or;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.TasksExpression;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests the class {@link ExpressionParser}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ExpressionParserTests {

	/**
	 * Tests {@link ExpressionParser#initialize(String, java.util.Collection)}.
	 */
	@Test
	public void initialize() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		final String text = "text";

		parser.setText(text);
		parser.setPossibleTasks(tasks);

		assertEquals(text, parser.getText());
		assertEquals(0, parser.getOffset());
		assertEquals(null, parser.getEReference());
		assertEquals(3, parser.getPossibleTasks().size());
		assertEquals(task1, parser.getPossibleTasks().get(0));
		assertEquals(task2, parser.getPossibleTasks().get(1));
		assertEquals(task3, parser.getPossibleTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTaskReference().
	 */
	@Test
	public void readTaskReference() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("text");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTaskReference();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 0 - Error can't read task reference", e.getMessage());
			assertEquals(0, parser.getOffset());
			assertEquals(null, parser.getEReference());
		}

		parser.setText("\"task1\"");
		parser.setPossibleTasks(tasks);
		assertEquals(task1, parser.readTaskReference());

		parser.setText("  \"task1\"");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTaskReference();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 0 - Error can't read task reference", e.getMessage());
			assertEquals(0, parser.getOffset());
			assertEquals(null, parser.getEReference());
		}

		parser.setText("\"task1\"  ");
		parser.setPossibleTasks(tasks);
		assertEquals(task1, parser.readTaskReference());
		assertEquals(7, parser.getOffset());
	}

	/**
	 * Tests {@link ExpressionParser#readTaskReference().
	 */
	@Test
	public void readTaskReferenceEscaped() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1\"\"");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("\"task1\"");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTaskReference();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 0 - Error can't reference task with name : task1", e.getMessage());
			assertEquals(0, parser.getOffset());
			assertEquals(null, parser.getEReference());
		}
		parser.setText("\"task1\\\"\\\"\"");
		parser.setPossibleTasks(tasks);
		assertEquals(task1, parser.readTaskReference());
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAllDone() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("AllDone(\"task1\")");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AllDone);
		assertEquals(1, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAllDoneMany() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AllDone(\"task1\",\"task2\",\"task3\")");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AllDone);
		assertEquals(3, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
		assertEquals(task2, exp.getTasks().get(1));
		assertEquals(task3, exp.getTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAllDoneFragment() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AllDone(\"task1\"");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 15 - Error can't read AllDone", e.getMessage());
			assertEquals(15, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}

		parser.setText("AllDone(\"task1\",");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 16 - Error can't read task reference", e.getMessage());
			assertEquals(16, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAllDoneWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("AllDone ( \"task1\" ) ");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AllDone);
		assertEquals(1, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAllDoneManyWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AllDone ( \"task1\" , \"task2\" , \"task3\" ) ");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AllDone);
		assertEquals(3, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
		assertEquals(task2, exp.getTasks().get(1));
		assertEquals(task3, exp.getTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAllDoneFragmentWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AllDone ( \"task1\" ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 18 - Error can't read AllDone", e.getMessage());
			assertEquals(18, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}

		parser.setText("AllDone ( \"task1\" , ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read task reference", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAnyDone() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("AnyDone(\"task1\")");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AnyDone);
		assertEquals(1, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAnyDoneMany() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AnyDone(\"task1\",\"task2\",\"task3\")");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AnyDone);
		assertEquals(3, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
		assertEquals(task2, exp.getTasks().get(1));
		assertEquals(task3, exp.getTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAnyDoneFragment() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AnyDone(\"task1\"");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 15 - Error can't read AnyDone", e.getMessage());
			assertEquals(15, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}

		parser.setText("AnyDone(\"task1\",");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 16 - Error can't read task reference", e.getMessage());
			assertEquals(16, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAnyDoneWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("AnyDone ( \"task1\" ) ");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AnyDone);
		assertEquals(1, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAnyDoneManyWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AnyDone ( \"task1\" , \"task2\" , \"task3\" ) ");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof AnyDone);
		assertEquals(3, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
		assertEquals(task2, exp.getTasks().get(1));
		assertEquals(task3, exp.getTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionAnyDoneFragmentWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("AnyDone ( \"task1\" ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 18 - Error can't read AnyDone", e.getMessage());
			assertEquals(18, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}

		parser.setText("AnyDone ( \"task1\" , ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read task reference", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionOneDone() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("OneDone(\"task1\")");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof OneDone);
		assertEquals(1, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionOneDoneMany() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("OneDone(\"task1\",\"task2\",\"task3\")");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof OneDone);
		assertEquals(3, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
		assertEquals(task2, exp.getTasks().get(1));
		assertEquals(task3, exp.getTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionOneDoneFragment() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("OneDone(\"task1\"");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 15 - Error can't read OneDone", e.getMessage());
			assertEquals(15, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}

		parser.setText("OneDone(\"task1\",");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 16 - Error can't read task reference", e.getMessage());
			assertEquals(16, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionOneDoneWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("OneDone ( \"task1\" ) ");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof OneDone);
		assertEquals(1, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionOneDoneManyWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("OneDone ( \"task1\" , \"task2\" , \"task3\" ) ");
		parser.setPossibleTasks(tasks);
		final TasksExpression exp = parser.readTasksExpression();
		assertTrue(exp instanceof OneDone);
		assertEquals(3, exp.getTasks().size());
		assertEquals(task1, exp.getTasks().get(0));
		assertEquals(task2, exp.getTasks().get(1));
		assertEquals(task3, exp.getTasks().get(2));
	}

	/**
	 * Tests {@link ExpressionParser#readTasksExpression().
	 */
	@Test
	public void readTasksExpressionOneDoneFragmentWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("OneDone ( \"task1\" ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 18 - Error can't read OneDone", e.getMessage());
			assertEquals(18, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}

		parser.setText("OneDone ( \"task1\" , ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readTasksExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read task reference", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getTasksExpression_Tasks(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionNot() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("Not(AllDone(\"task1\"))");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof Not);
		assertTrue(((Not)exp).getExpression() instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionNotMany() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Not(AllDone(\"task1\"),AllDone(\"task2\"),AllDone(\"task3\"))");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read Not", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getNot_Expression(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionNotFragment() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Not(AllDone(\"task1\")");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read Not", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getNot_Expression(), parser.getEReference());
		}

		parser.setText("Not(AllDone(\"task1\"),");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read Not", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getNot_Expression(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionNotWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("Not ( AllDone(\"task1\") ) ");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof Not);
		assertTrue(((Not)exp).getExpression() instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionNotManyWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Not ( AllDone(\"task1\") , AllDone(\"task2\") , AllDone(\"task3\") ) ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 23 - Error can't read Not", e.getMessage());
			assertEquals(23, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getNot_Expression(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionNotFragmentWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Not ( AllDone(\"task1\") ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 23 - Error can't read Not", e.getMessage());
			assertEquals(23, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getNot_Expression(), parser.getEReference());
		}

		parser.setText("Not ( AllDone(\"task1\") , ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 23 - Error can't read Not", e.getMessage());
			assertEquals(23, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getNot_Expression(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionAnd() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("And(AllDone(\"task1\"))");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof And);
		assertEquals(1, ((And)exp).getExpressions().size());
		assertTrue(((And)exp).getExpressions().get(0) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionAndMany() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("And(AllDone(\"task1\"),AllDone(\"task2\"),AllDone(\"task3\"))");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof And);
		assertEquals(3, ((And)exp).getExpressions().size());
		assertTrue(((And)exp).getExpressions().get(0) instanceof AllDone);
		assertTrue(((And)exp).getExpressions().get(1) instanceof AllDone);
		assertTrue(((And)exp).getExpressions().get(2) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionAndFragment() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("And(AllDone(\"task1\")");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read And", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getAnd_Expressions(), parser.getEReference());
		}

		parser.setText("And(AllDone(\"task1\"),");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 21 - Error can't read Expression", e.getMessage());
			assertEquals(21, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getAnd_Expressions(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionAndWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("And ( AllDone(\"task1\") ) ");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof And);
		assertEquals(1, ((And)exp).getExpressions().size());
		assertTrue(((And)exp).getExpressions().get(0) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionAndManyWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("And ( AllDone(\"task1\") , AllDone(\"task2\") , AllDone(\"task3\") ) ");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof And);
		assertEquals(3, ((And)exp).getExpressions().size());
		assertTrue(((And)exp).getExpressions().get(0) instanceof AllDone);
		assertTrue(((And)exp).getExpressions().get(1) instanceof AllDone);
		assertTrue(((And)exp).getExpressions().get(2) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionAndFragmentWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("And ( AllDone(\"task1\") ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 23 - Error can't read And", e.getMessage());
			assertEquals(23, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getAnd_Expressions(), parser.getEReference());
		}

		parser.setText("And ( AllDone(\"task1\") , ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 25 - Error can't read Expression", e.getMessage());
			assertEquals(25, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getAnd_Expressions(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionOr() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("Or(AllDone(\"task1\"))");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof Or);
		assertEquals(1, ((Or)exp).getExpressions().size());
		assertTrue(((Or)exp).getExpressions().get(0) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionOrMany() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Or(AllDone(\"task1\"),AllDone(\"task2\"),AllDone(\"task3\"))");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof Or);
		assertEquals(3, ((Or)exp).getExpressions().size());
		assertTrue(((Or)exp).getExpressions().get(0) instanceof AllDone);
		assertTrue(((Or)exp).getExpressions().get(1) instanceof AllDone);
		assertTrue(((Or)exp).getExpressions().get(2) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionOrFragment() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Or(AllDone(\"task1\")");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 19 - Error can't read Or", e.getMessage());
			assertEquals(19, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getOr_Expressions(), parser.getEReference());
		}

		parser.setText("Or(AllDone(\"task1\"),");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 20 - Error can't read Expression", e.getMessage());
			assertEquals(20, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getOr_Expressions(), parser.getEReference());
		}
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionOrWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		parser.setText("Or ( AllDone(\"task1\") ) ");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof Or);
		assertEquals(1, ((Or)exp).getExpressions().size());
		assertTrue(((Or)exp).getExpressions().get(0) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionOrManyWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Or ( AllDone(\"task1\") , AllDone(\"task2\") , AllDone(\"task3\") ) ");
		parser.setPossibleTasks(tasks);
		final Expression exp = parser.readLogicalExpression();
		assertTrue(exp instanceof Or);
		assertEquals(3, ((Or)exp).getExpressions().size());
		assertTrue(((Or)exp).getExpressions().get(0) instanceof AllDone);
		assertTrue(((Or)exp).getExpressions().get(1) instanceof AllDone);
		assertTrue(((Or)exp).getExpressions().get(2) instanceof AllDone);
	}

	/**
	 * Tests {@link ExpressionParser#readLogicalExpression().
	 */
	@Test
	public void readLogicalExpressionOrFragmentWithSpaces() {
		final ExpressionParser parser = new ExpressionParser();

		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		parser.setText("Or ( AllDone(\"task1\") ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 22 - Error can't read Or", e.getMessage());
			assertEquals(22, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getOr_Expressions(), parser.getEReference());
		}

		parser.setText("Or ( AllDone(\"task1\") , ");
		parser.setPossibleTasks(tasks);
		try {
			parser.readLogicalExpression();
			fail();
		} catch (IllegalStateException e) {
			assertEquals("at 24 - Error can't read Expression", e.getMessage());
			assertEquals(24, parser.getOffset());
			assertEquals(ProcessPackage.eINSTANCE.getOr_Expressions(), parser.getEReference());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void toStringNull() {
		ExpressionParser.toString(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringAllDone() {
		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();

		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2\\");
		exp.getTasks().add(task1);

		assertEquals("AllDone(\"task1\")", ExpressionParser.toString(exp));

		exp.getTasks().add(task2);
		assertEquals("AllDone(\"task1\",\"task2\\\\\")", ExpressionParser.toString(exp));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringAnyDone() {
		final AnyDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnyDone();

		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2\\");
		exp.getTasks().add(task1);

		assertEquals("AnyDone(\"task1\")", ExpressionParser.toString(exp));

		exp.getTasks().add(task2);
		assertEquals("AnyDone(\"task1\",\"task2\\\\\")", ExpressionParser.toString(exp));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringOneDone() {
		final OneDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();

		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2\\");
		exp.getTasks().add(task1);

		assertEquals("OneDone(\"task1\")", ExpressionParser.toString(exp));

		exp.getTasks().add(task2);
		assertEquals("OneDone(\"task1\",\"task2\\\\\")", ExpressionParser.toString(exp));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringNotNullExpression() {
		final Not exp = ProcessPackage.eINSTANCE.getProcessFactory().createNot();

		assertEquals("Not()", ExpressionParser.toString(exp));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringNot() {
		final Not exp = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final OneDone oneDone = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		exp.setExpression(oneDone);

		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2\\");
		oneDone.getTasks().add(task1);

		assertEquals("Not(OneDone(\"task1\"))", ExpressionParser.toString(exp));

		oneDone.getTasks().add(task2);
		assertEquals("Not(OneDone(\"task1\",\"task2\\\\\"))", ExpressionParser.toString(exp));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringAnd() {
		final And exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final OneDone oneDone1 = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		exp.getExpressions().add(oneDone1);
		final OneDone oneDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();

		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2\\");
		oneDone1.getTasks().add(task1);
		oneDone2.getTasks().add(task2);

		assertEquals("And(OneDone(\"task1\"))", ExpressionParser.toString(exp));

		exp.getExpressions().add(oneDone2);
		assertEquals("And(OneDone(\"task1\"),OneDone(\"task2\\\\\"))", ExpressionParser.toString(exp));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Test
	public void toStringOr() {
		final Or exp = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final OneDone oneDone1 = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		exp.getExpressions().add(oneDone1);
		final OneDone oneDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();

		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2\\");
		oneDone1.getTasks().add(task1);
		oneDone2.getTasks().add(task2);

		assertEquals("Or(OneDone(\"task1\"))", ExpressionParser.toString(exp));

		exp.getExpressions().add(oneDone2);
		assertEquals("Or(OneDone(\"task1\"),OneDone(\"task2\\\\\"))", ExpressionParser.toString(exp));
	}

}
