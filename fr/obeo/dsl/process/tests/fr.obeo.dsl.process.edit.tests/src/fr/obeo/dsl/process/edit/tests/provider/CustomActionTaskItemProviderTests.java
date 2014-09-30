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
package fr.obeo.dsl.process.edit.tests.provider;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;

import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link fr.obeo.dsl.process.provider.CustomActionTaskItemProvider CustomActionTaskItemProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomActionTaskItemProviderTests {

	/**
	 * The factory that provides tested {@link org.eclipse.emf.common.notify.Adapter adapters}.
	 */
	AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * Tests the preceding tasks choice of value.
	 */
	@Test
	public void precedingTasksChoiceOfValue() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");

		final IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(task1,
				IItemPropertySource.class);
		final IItemPropertyDescriptor descriptor = itemPropertySource.getPropertyDescriptor(task1,
				ProcessPackage.eINSTANCE.getTask_PrecedingTasks());

		Collection<?> values = descriptor.getChoiceOfValues(task1);
		assertEquals(0, values.size());

		composedTask.getTasks().add(task1);

		values = descriptor.getChoiceOfValues(task1);
		assertEquals(1, values.size());
		assertEquals(task1, values.iterator().next());

		composedTask.getTasks().add(task2);

		values = descriptor.getChoiceOfValues(task1);
		assertEquals(2, values.size());
		Iterator<?> iterator = values.iterator();
		assertEquals(task1, iterator.next());
		assertEquals(task2, iterator.next());
	}

	/**
	 * Tests the following tasks choice of value.
	 */
	@Test
	public void followingTasksChoiceOfValue() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");

		final IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(task1,
				IItemPropertySource.class);
		final IItemPropertyDescriptor descriptor = itemPropertySource.getPropertyDescriptor(task1,
				ProcessPackage.eINSTANCE.getTask_FollowingTasks());

		Collection<?> values = descriptor.getChoiceOfValues(task1);
		assertEquals(0, values.size());

		composedTask.getTasks().add(task1);

		values = descriptor.getChoiceOfValues(task1);
		assertEquals(1, values.size());
		assertEquals(task1, values.iterator().next());

		composedTask.getTasks().add(task2);

		values = descriptor.getChoiceOfValues(task1);
		assertEquals(2, values.size());
		Iterator<?> iterator = values.iterator();
		assertEquals(task1, iterator.next());
		assertEquals(task2, iterator.next());
	}

	/**
	 * Tests the observed variables choice of value.
	 */
	@Test
	public void observedVariablesChoiceOfValue() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		composedTask.getInitialTasks().add(task1);
		task1.getPrecedingTasks().add(task3);
		final ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable1.setName("variable1");
		final ProcessVariable variable2 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable2.setName("variable2");
		final ProcessVariable variable3 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable3.setName("variable3");
		task2.getWrittenVariables().add(variable2);
		task3.getWrittenVariables().add(variable3);

		final IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(task1,
				IItemPropertySource.class);
		final IItemPropertyDescriptor descriptor = itemPropertySource.getPropertyDescriptor(task1,
				ProcessPackage.eINSTANCE.getActionTask_ObservedVariables());

		Collection<?> values = descriptor.getChoiceOfValues(task1);

		assertEquals(2, values.size());
		Iterator<?> iterator = values.iterator();
		assertEquals(variable3, iterator.next());
		assertEquals(variable2, iterator.next());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.provider.CustomActionTaskItemProvider#getImage(Object)}.
	 */
	@Test
	public void getImage() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		final IItemLabelProvider provider = (IItemLabelProvider)factory
				.adapt(task1, IItemLabelProvider.class);

		Object image = provider.getImage(task1);
		assertTrue(image instanceof URL);
		assertTrue(image.toString().endsWith("icons/full/obj16/ActionTask.gif"));

		composedTask.getTasks().add(task1);
		composedTask.getInitialTasks().add(task1);

		image = provider.getImage(task1);
		assertTrue(image instanceof URL);
		assertTrue(image.toString().endsWith("icons/full/obj16/ActionTask_initial.gif"));

		composedTask.getInitialTasks().remove(task1);
		composedTask.getFinalTasks().add(task1);

		image = provider.getImage(task1);
		assertTrue(image instanceof URL);
		assertTrue(image.toString().endsWith("icons/full/obj16/ActionTask_final.gif"));

		composedTask.getInitialTasks().add(task1);
		composedTask.getFinalTasks().add(task1);

		image = provider.getImage(task1);
		assertTrue(image instanceof URL);
		assertTrue(image.toString().endsWith("icons/full/obj16/ActionTask_initial.gif"));
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.provider.CustomActionTaskItemProvider#getText(Object)}.
	 */
	@Test
	public void getText() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		final IItemLabelProvider provider = (IItemLabelProvider)factory
				.adapt(task1, IItemLabelProvider.class);

		String text = provider.getText(task1);
		assertEquals("Action Task task1", text);

		composedTask.getTasks().add(task1);
		composedTask.getInitialTasks().add(task1);

		text = provider.getText(task1);
		assertEquals("Action Task task1 (initial)", text);

		composedTask.getInitialTasks().remove(task1);
		composedTask.getFinalTasks().add(task1);

		text = provider.getText(task1);
		assertEquals("Action Task task1 (final)", text);

		composedTask.getInitialTasks().add(task1);
		composedTask.getFinalTasks().add(task1);

		text = provider.getText(task1);
		assertEquals("Action Task task1 (initial)", text);
	}

}
