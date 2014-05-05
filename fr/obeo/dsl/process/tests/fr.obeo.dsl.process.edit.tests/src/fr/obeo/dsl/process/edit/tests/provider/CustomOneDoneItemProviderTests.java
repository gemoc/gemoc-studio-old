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
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.ProcessPackage;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link fr.obeo.dsl.process.provider.CustomOneDoneItemProvider CustomOneDoneItemProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomOneDoneItemProviderTests {

	/**
	 * The factory that provides tested {@link org.eclipse.emf.common.notify.Adapter adapters}.
	 */
	AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * Tests the tasks choice of value.
	 */
	@Test
	public void tasksChoiceOfValuePrecondition() {
		final OneDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.setPrecondition(exp);

		final IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(exp,
				IItemPropertySource.class);
		final IItemPropertyDescriptor descriptor = itemPropertySource.getPropertyDescriptor(exp,
				ProcessPackage.eINSTANCE.getTasksExpression_Tasks());

		Collection<?> values = descriptor.getChoiceOfValues(exp);
		assertEquals(0, values.size());

		task1.getPrecedingTasks().add(task2);

		values = descriptor.getChoiceOfValues(exp);
		assertEquals(1, values.size());
		assertEquals(task2, values.iterator().next());

		composedTask.getTasks().add(task1);
		composedTask.getInitialTasks().add(task1);
		composedTask.getPrecedingTasks().add(task3);

		values = descriptor.getChoiceOfValues(exp);
		assertEquals(2, values.size());
		Iterator<?> iterator = values.iterator();
		assertEquals(task2, iterator.next());
		assertEquals(task3, iterator.next());
	}

	/**
	 * Tests the tasks choice of value.
	 */
	@Test
	public void tasksChoiceOfValueDoneExpression() {
		final OneDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.setDoneExpression(exp);

		final IItemPropertySource itemPropertySource = (IItemPropertySource)factory.adapt(exp,
				IItemPropertySource.class);
		final IItemPropertyDescriptor descriptor = itemPropertySource.getPropertyDescriptor(exp,
				ProcessPackage.eINSTANCE.getTasksExpression_Tasks());

		Collection<?> values = descriptor.getChoiceOfValues(exp);
		assertEquals(0, values.size());

		task1.getTasks().add(task2);
		task1.getFinalTasks().add(task2);

		values = descriptor.getChoiceOfValues(exp);
		assertEquals(1, values.size());
		assertEquals(task2, values.iterator().next());

		task1.getTasks().add(task3);
		task1.getFinalTasks().add(task3);

		values = descriptor.getChoiceOfValues(exp);
		assertEquals(2, values.size());
		Iterator<?> iterator = values.iterator();
		assertEquals(task2, iterator.next());
		assertEquals(task3, iterator.next());
	}

}
