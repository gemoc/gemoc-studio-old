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

import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

/**
 * A custom {@link ComposedTaskItemProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomComposedTaskItemProvider extends ComposedTaskItemProvider {

	/**
	 * "_UI_ComposedTask_type" contant.
	 */
	private static final String UI_COMPOSED_TASK_TYPE = "_UI_ComposedTask_type";

	/**
	 * "_UI_PropertyDescriptor_description" constant.
	 */
	private static final String UI_PROPERTY_DESCRIPTOR_DESCRIPTION = "_UI_PropertyDescriptor_description";

	/**
	 * Constructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory}
	 */
	public CustomComposedTaskItemProvider(AdapterFactory adapterFactory) {
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
	protected void addInitialTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComposedTask_initialTasks_feature"), getString(
						UI_PROPERTY_DESCRIPTOR_DESCRIPTION, "_UI_ComposedTask_initialTasks_feature",
						UI_COMPOSED_TASK_TYPE), ProcessPackage.Literals.COMPOSED_TASK__INITIAL_TASKS, true,
				false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				final Collection<?> res;

				if (object instanceof ComposedTask) {
					res = ((ComposedTask)object).getTasks();
				} else {
					res = super.getChoiceOfValues(object);
				}

				return res;
			}

		});
	}

	@Override
	protected void addFinalTasksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ComposedTask_finalTasks_feature"), getString(
						UI_PROPERTY_DESCRIPTOR_DESCRIPTION, "_UI_ComposedTask_finalTasks_feature",
						UI_COMPOSED_TASK_TYPE), ProcessPackage.Literals.COMPOSED_TASK__FINAL_TASKS, true,
				false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				final Collection<?> res;

				if (object instanceof ComposedTask) {
					res = ((ComposedTask)object).getTasks();
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
			res = overlayImage(object, getResourceLocator().getImage("full/obj16/ComposedTask_initial"));
		} else if (ProcessUtils.isFinalTask((Task)object)) {
			res = overlayImage(object, getResourceLocator().getImage("full/obj16/ComposedTask_final"));
		} else {
			res = overlayImage(object, getResourceLocator().getImage("full/obj16/ComposedTask"));
		}

		return res;
	}

	@Override
	public String getText(Object object) {
		String label = ((ComposedTask)object).getName();

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
			res = getString(UI_COMPOSED_TASK_TYPE) + state;
		} else {
			res = getString(UI_COMPOSED_TASK_TYPE) + " " + label + state;
		}

		return res;
	}

}
