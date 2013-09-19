/**
 */
package org.gemoc.gemoc_language_workbench.conf.provider;


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

import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.confFactory;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * This is the item provider adapter for a {@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LanguageDefinitionItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_LanguageDefinition_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_LanguageDefinition_name_feature", "_UI_LanguageDefinition_type"),
				 confPackage.Literals.LANGUAGE_DEFINITION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(confPackage.Literals.LANGUAGE_DEFINITION__DSA_PROJECT);
			childrenFeatures.add(confPackage.Literals.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT);
			childrenFeatures.add(confPackage.Literals.LANGUAGE_DEFINITION__EDITOR_PROJECTS);
			childrenFeatures.add(confPackage.Literals.LANGUAGE_DEFINITION__MO_CMODEL_PROJECT);
			childrenFeatures.add(confPackage.Literals.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS);
			childrenFeatures.add(confPackage.Literals.LANGUAGE_DEFINITION__DSE_PROJECT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns LanguageDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LanguageDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((LanguageDefinition)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LanguageDefinition_type") :
			getString("_UI_LanguageDefinition_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(LanguageDefinition.class)) {
			case confPackage.LANGUAGE_DEFINITION__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECT:
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
			case confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECT:
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__DSA_PROJECT,
				 confFactory.eINSTANCE.createKermeta2DSAProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__DSA_PROJECT,
				 confFactory.eINSTANCE.createK3DSAProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT,
				 confFactory.eINSTANCE.createEMFEcoreProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__EDITOR_PROJECTS,
				 confFactory.eINSTANCE.createODProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__EDITOR_PROJECTS,
				 confFactory.eINSTANCE.createTreeEditorProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__EDITOR_PROJECTS,
				 confFactory.eINSTANCE.createXTextEditorProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__MO_CMODEL_PROJECT,
				 confFactory.eINSTANCE.createCCSLMoCProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__MO_CMODEL_PROJECT,
				 confFactory.eINSTANCE.createModHelXMoCProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS,
				 confFactory.eINSTANCE.createSiriusAnimatorProject()));

		newChildDescriptors.add
			(createChildParameter
				(confPackage.Literals.LANGUAGE_DEFINITION__DSE_PROJECT,
				 confFactory.eINSTANCE.createECLProject()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return gemoc_language_workbench_confEditPlugin.INSTANCE;
	}

}
