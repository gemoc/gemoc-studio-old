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
package fr.obeo.dsl.process.provider;

import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.TasksExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

/**
 * A custom {@link AllDoneItemProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomAllDoneItemProvider extends AllDoneItemProvider {

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory}
	 */
	public CustomAllDoneItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_TasksExpression_tasks_feature"), getString(
						"_UI_PropertyDescriptor_description", "_UI_TasksExpression_tasks_feature",
						"_UI_TasksExpression_type"), ProcessPackage.Literals.TASKS_EXPRESSION__TASKS, true,
				false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				final Collection<?> res;

				if (object instanceof TasksExpression) {
					res = ProcessUtils.getPossibleTasks((TasksExpression)object);
				} else {
					res = super.getChoiceOfValues(object);
				}

				return res;
			}
		});

	}

}
