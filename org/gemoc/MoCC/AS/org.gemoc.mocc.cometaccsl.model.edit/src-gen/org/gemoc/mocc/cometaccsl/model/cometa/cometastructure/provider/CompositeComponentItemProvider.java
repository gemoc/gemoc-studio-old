/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.provider;


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

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructureFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimeFactory;

import org.gemoc.mocc.cometaccsl.model.cometa.edit.provider.CometaEditPlugin;

/**
 * This is the item provider adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeComponentItemProvider
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
	public CompositeComponentItemProvider(AdapterFactory adapterFactory) {
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
			addVersionPropertyDescriptor(object);
			addDefinitionPropertyDescriptor(object);
			addBehaviorMapPropertyDescriptor(object);
			addMocDomainPropertyDescriptor(object);
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
				 getString("_UI_NamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
				 CometaPackage.Literals.NAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedElement_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_version_feature", "_UI_NamedElement_type"),
				 CometaPackage.Literals.NAMED_ELEMENT__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Definition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefinitionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedElement_definition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_definition_feature", "_UI_NamedElement_type"),
				 CometaPackage.Literals.NAMED_ELEMENT__DEFINITION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Behavior Map feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBehaviorMapPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructureElement_behaviorMap_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructureElement_behaviorMap_feature", "_UI_StructureElement_type"),
				 CometastructurePackage.Literals.STRUCTURE_ELEMENT__BEHAVIOR_MAP,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Moc Domain feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMocDomainPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StructureElement_mocDomain_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StructureElement_mocDomain_feature", "_UI_StructureElement_type"),
				 CometastructurePackage.Literals.STRUCTURE_ELEMENT__MOC_DOMAIN,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(CometastructurePackage.Literals.STRUCTURE_ELEMENT__PARAMETERS);
			childrenFeatures.add(CometastructurePackage.Literals.MO_CCOMPONENT__OWNED_PORT_INSTANCES);
			childrenFeatures.add(CometastructurePackage.Literals.CONTAINER__PARTS);
			childrenFeatures.add(CometastructurePackage.Literals.COMPOSITE_COMPONENT__CONNECTORS);
			childrenFeatures.add(CometastructurePackage.Literals.COMPOSITE_COMPONENT__SUB_COMPONENTS);
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
	 * This returns CompositeComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CompositeComponent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CompositeComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CompositeComponent_type") :
			getString("_UI_CompositeComponent_type") + " " + label;
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

		switch (notification.getFeatureID(CompositeComponent.class)) {
			case CometastructurePackage.COMPOSITE_COMPONENT__NAME:
			case CometastructurePackage.COMPOSITE_COMPONENT__VERSION:
			case CometastructurePackage.COMPOSITE_COMPONENT__DEFINITION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CometastructurePackage.COMPOSITE_COMPONENT__PARAMETERS:
			case CometastructurePackage.COMPOSITE_COMPONENT__OWNED_PORT_INSTANCES:
			case CometastructurePackage.COMPOSITE_COMPONENT__PARTS:
			case CometastructurePackage.COMPOSITE_COMPONENT__CONNECTORS:
			case CometastructurePackage.COMPOSITE_COMPONENT__SUB_COMPONENTS:
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
				(CometastructurePackage.Literals.STRUCTURE_ELEMENT__PARAMETERS,
				 CometatimeFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(CometastructurePackage.Literals.MO_CCOMPONENT__OWNED_PORT_INSTANCES,
				 CometastructureFactory.eINSTANCE.createMoCPort()));

		newChildDescriptors.add
			(createChildParameter
				(CometastructurePackage.Literals.CONTAINER__PARTS,
				 CometastructureFactory.eINSTANCE.createPart()));

		newChildDescriptors.add
			(createChildParameter
				(CometastructurePackage.Literals.COMPOSITE_COMPONENT__CONNECTORS,
				 CometastructureFactory.eINSTANCE.createMoCConnector()));

		newChildDescriptors.add
			(createChildParameter
				(CometastructurePackage.Literals.COMPOSITE_COMPONENT__SUB_COMPONENTS,
				 CometastructureFactory.eINSTANCE.createCompositeComponent()));

		newChildDescriptors.add
			(createChildParameter
				(CometastructurePackage.Literals.COMPOSITE_COMPONENT__SUB_COMPONENTS,
				 CometastructureFactory.eINSTANCE.createBasicComponent()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CometaEditPlugin.INSTANCE;
	}

}
