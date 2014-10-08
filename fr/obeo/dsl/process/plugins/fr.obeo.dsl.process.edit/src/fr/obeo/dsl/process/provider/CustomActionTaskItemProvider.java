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

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

/**
 * A custom {@link ActionTaskItemProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomActionTaskItemProvider extends ActionTaskItemProvider {

	/**
	 * "_UI_PropertyDescriptor_description" constant.
	 */
	private static final String UI_PROPERTY_DESCRIPTOR_DESCRIPTION = "_UI_PropertyDescriptor_description";

	/**
	 * "_UI_ActionTask_type" constant.
	 */
	private static final String UI_ACTION_TASK_TYPE = "_UI_ActionTask_type";

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory}
	 */
	public CustomActionTaskItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addPrecedingTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Task_precedingTasks_feature"),
				getString(UI_PROPERTY_DESCRIPTOR_DESCRIPTION, "_UI_Task_precedingTasks_feature",
						"_UI_Task_type"), ProcessPackage.Literals.TASK__PRECEDING_TASKS, true, false, true,
				null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				final Collection<?> res;

				if (object instanceof Task) {
					res = ProcessUtils.getSameLevelTasks((Task)object);
				} else {
					res = super.getChoiceOfValues(object);
				}

				return res;
			}

		});
	}

	@Override
	protected void addFollowingTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Task_followingTasks_feature"),
				getString(UI_PROPERTY_DESCRIPTOR_DESCRIPTION, "_UI_Task_followingTasks_feature",
						"_UI_Task_type"), ProcessPackage.Literals.TASK__FOLLOWING_TASKS, true, false, true,
				null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				final Collection<?> res;

				if (object instanceof Task) {
					res = ProcessUtils.getSameLevelTasks((Task)object);
				} else {
					res = super.getChoiceOfValues(object);
				}

				return res;
			}

		});
	}

	@Override
	protected void addObservedVariablesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ActionTask_observedVariables_feature"), getString(
						UI_PROPERTY_DESCRIPTOR_DESCRIPTION, "_UI_ActionTask_observedVariables_feature",
						UI_ACTION_TASK_TYPE), ProcessPackage.Literals.ACTION_TASK__OBSERVED_VARIABLES, true,
				false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				final Collection<?> res;
				if (object instanceof ActionTask) {
					res = ProcessUtils.getAvailableProcessVariables((ActionTask)object);
				} else {
					res = super.getChoiceOfValues(object);
				}
				return res;
			}

		});
	}

	@Override
	public Object getImage(Object object) {
		final Object res;

		if (ProcessUtils.isInitialTask((Task)object)) {
			res = overlayImage(object, getResourceLocator().getImage("full/obj16/ActionTask_initial"));
		} else if (ProcessUtils.isFinalTask((Task)object)) {
			res = overlayImage(object, getResourceLocator().getImage("full/obj16/ActionTask_final"));
		} else {
			res = overlayImage(object, getResourceLocator().getImage("full/obj16/ActionTask"));
		}

		return res;
	}

	@Override
	public String getText(Object object) {
		String label = ((ActionTask)object).getName();

		final String state;
		if (ProcessUtils.isInitialTask((Task)object)) {
			state = " (initial)";
		} else if (ProcessUtils.isFinalTask((Task)object)) {
			state = " (final)";
		} else {
			state = "";
		}

		final String res;

		if (label == null || label.length() == 0) {
			res = getString(UI_ACTION_TASK_TYPE) + state;
		} else {
			res = getString(UI_ACTION_TASK_TYPE) + " " + label + state;
		}

		return res;
	}

}
