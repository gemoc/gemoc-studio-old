/**
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
 */
package fr.obeo.dsl.debug.provider;

import fr.obeo.dsl.debug.DebugFactory;
import fr.obeo.dsl.debug.DebugPackage;
import fr.obeo.dsl.debug.StackFrame;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link fr.obeo.dsl.debug.StackFrame} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class StackFrameItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public StackFrameItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addContextPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addCurrentInstructionPropertyDescriptor(object);
			addCanStepIntoCurrentInstructionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Context feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addContextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_Contextual_context_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Contextual_context_feature",
						"_UI_Contextual_type"), DebugPackage.Literals.CONTEXTUAL__CONTEXT, true, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(), getString("_UI_StackFrame_name_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_StackFrame_name_feature",
						"_UI_StackFrame_type"), DebugPackage.Literals.STACK_FRAME__NAME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Current Instruction feature. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCurrentInstructionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_StackFrame_currentInstruction_feature"), getString(
						"_UI_PropertyDescriptor_description", "_UI_StackFrame_currentInstruction_feature",
						"_UI_StackFrame_type"), DebugPackage.Literals.STACK_FRAME__CURRENT_INSTRUCTION, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Can Step Into Current Instruction feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCanStepIntoCurrentInstructionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory)
				.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_StackFrame_canStepIntoCurrentInstruction_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_StackFrame_canStepIntoCurrentInstruction_feature", "_UI_StackFrame_type"),
				DebugPackage.Literals.STACK_FRAME__CAN_STEP_INTO_CURRENT_INSTRUCTION, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for
	 * an {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand}
	 * or {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DebugPackage.Literals.STACK_FRAME__VARIABLES);
			childrenFeatures.add(DebugPackage.Literals.STACK_FRAME__CHILD_FRAME);
			childrenFeatures.add(DebugPackage.Literals.STACK_FRAME__REGISTER_GROUPS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns StackFrame.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StackFrame"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StackFrame)object).getName();
		return label == null || label.length() == 0 ? getString("_UI_StackFrame_type")
				: getString("_UI_StackFrame_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and
	 * by creating a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StackFrame.class)) {
			case DebugPackage.STACK_FRAME__NAME:
			case DebugPackage.STACK_FRAME__CAN_STEP_INTO_CURRENT_INSTRUCTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false,
						true));
				return;
			case DebugPackage.STACK_FRAME__VARIABLES:
			case DebugPackage.STACK_FRAME__CHILD_FRAME:
			case DebugPackage.STACK_FRAME__REGISTER_GROUPS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true,
						false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be
	 * created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(DebugPackage.Literals.STACK_FRAME__VARIABLES,
				DebugFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(DebugPackage.Literals.STACK_FRAME__VARIABLES,
				DebugFactory.eINSTANCE.createRegister()));

		newChildDescriptors.add(createChildParameter(DebugPackage.Literals.STACK_FRAME__CHILD_FRAME,
				DebugFactory.eINSTANCE.createStackFrame()));

		newChildDescriptors.add(createChildParameter(DebugPackage.Literals.STACK_FRAME__REGISTER_GROUPS,
				DebugFactory.eINSTANCE.createRegisterGroup()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DebugEditPlugin.INSTANCE;
	}

}
