/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.CreateChildCommand;
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

import fr.obeo.dsl.sirius.animation.AnimationFactory;
import fr.obeo.dsl.sirius.animation.AnimationPackage;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.StackFrameState;

/**
 * This is the item provider adapter for a
 * {@link fr.obeo.dsl.sirius.animation.StackFrame} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class StackFrameItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StackFrameItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addStatePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addCurrentInstructionPropertyDescriptor(object);
			addParentStackPropertyDescriptor(object);
			addExecutionEnvironmentPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the State feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_StackFrame_state_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_StackFrame_state_feature", "_UI_StackFrame_type"),
				AnimationPackage.Literals.STACK_FRAME__STATE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_StackFrame_name_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_StackFrame_name_feature", "_UI_StackFrame_type"),
				AnimationPackage.Literals.STACK_FRAME__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Current Instruction feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCurrentInstructionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_StackFrame_currentInstruction_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_StackFrame_currentInstruction_feature",
						"_UI_StackFrame_type"),
				AnimationPackage.Literals.STACK_FRAME__CURRENT_INSTRUCTION,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Parent Stack feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addParentStackPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_StackFrame_parentStack_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_StackFrame_parentStack_feature",
						"_UI_StackFrame_type"),
				AnimationPackage.Literals.STACK_FRAME__PARENT_STACK, true,
				false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Execution Environment feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExecutionEnvironmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_StackFrame_executionEnvironment_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_StackFrame_executionEnvironment_feature",
						"_UI_StackFrame_type"),
				AnimationPackage.Literals.STACK_FRAME__EXECUTION_ENVIRONMENT,
				true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(AnimationPackage.Literals.STACK_FRAME__VARIABLES);
			childrenFeatures
					.add(AnimationPackage.Literals.STACK_FRAME__SUB_FRAMES);
			childrenFeatures.add(AnimationPackage.Literals.STACK_FRAME__DATA);
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
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns StackFrame.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @not-generated
	 */
	@Override
	public Object getImage(Object object) {
		if (object instanceof StackFrame
				&& ((StackFrame) object).getState() != StackFrameState.DONE) {
			return overlayImage(
					object,
					getResourceLocator().getImage(
							"full/obj16/StackFrame_running"));
		}
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/StackFrame"));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @not-generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StackFrame) object).getName();
		EObject executionEnvironment = ((StackFrame) object)
				.getExecutionEnvironment();
		if (executionEnvironment != null) {
			Object obj = ((AnimationItemProviderAdapterFactory) adapterFactory)
					.getRootAdapterFactory().adapt(
							(Object) executionEnvironment,
							IItemLabelProvider.class);
			if (obj instanceof IItemLabelProvider) {
				return ((IItemLabelProvider) obj).getText(executionEnvironment);
			}
		}
		return label == null || label.length() == 0 ? getString("_UI_StackFrame_type")
				: getString("_UI_StackFrame_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StackFrame.class)) {
		case AnimationPackage.STACK_FRAME__STATE:
		case AnimationPackage.STACK_FRAME__NAME:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case AnimationPackage.STACK_FRAME__VARIABLES:
		case AnimationPackage.STACK_FRAME__SUB_FRAMES:
		case AnimationPackage.STACK_FRAME__DATA:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__VARIABLES,
				AnimationFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__SUB_FRAMES,
				AnimationFactory.eINSTANCE.createStackFrame()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				AnimationFactory.eINSTANCE.createAnimationTarget()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				AnimationFactory.eINSTANCE.createStackFrame()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				AnimationFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				AnimationFactory.eINSTANCE.createThread()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				AnimationFactory.eINSTANCE.createCurrentSessions()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors
				.add(createChildParameter(
						AnimationPackage.Literals.STACK_FRAME__DATA,
						EcoreFactory.eINSTANCE
								.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add(createChildParameter(
				AnimationPackage.Literals.STACK_FRAME__DATA,
				EcoreFactory.eINSTANCE.createETypeParameter()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == AnimationPackage.Literals.STACK_FRAME__VARIABLES
				|| childFeature == AnimationPackage.Literals.STACK_FRAME__DATA
				|| childFeature == AnimationPackage.Literals.STACK_FRAME__SUB_FRAMES;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] {
					getTypeText(childObject), getFeatureText(childFeature),
					getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AnimationEditPlugin.INSTANCE;
	}

}
