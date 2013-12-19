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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.provider;


import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypeFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationFactory;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelFactory;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.edit.provider.CometaEditPlugin;

import org.gemoc.mocc.cometaccsl.model.cometa.provider.MoCLibraryItemProvider;

/**
 * This is the item provider adapter for a {@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CCSLLibraryItemProvider
	extends MoCLibraryItemProvider
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
	public CCSLLibraryItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_NamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
				 TimeModelPackage.Literals.NAMED_ELEMENT__NAME,
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
			childrenFeatures.add(ClockExpressionAndRelationPackage.Literals.LIBRARY__EXPRESSION_LIBRARIES);
			childrenFeatures.add(ClockExpressionAndRelationPackage.Literals.LIBRARY__RELATION_LIBRARIES);
			childrenFeatures.add(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES);
			childrenFeatures.add(ClockExpressionAndRelationPackage.Literals.LIBRARY__IMPORTS);
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
	 * This returns CCSLLibrary.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CCSLLibrary"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CCSLLibrary)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CCSLLibrary_type") :
			getString("_UI_CCSLLibrary_type") + " " + label;
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

		switch (notification.getFeatureID(CCSLLibrary.class)) {
			case CcslmocPackage.CCSL_LIBRARY__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES:
			case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES:
			case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES:
			case CcslmocPackage.CCSL_LIBRARY__IMPORTS:
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
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__EXPRESSION_LIBRARIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createExpressionLibrary()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__RELATION_LIBRARIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createRelationLibrary()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createString()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createBoolean()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createInteger()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createReal()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createChar()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createRecord()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createDiscreteClockType()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createDenseClockType()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__PREDEFINED_TYPES,
				 BasicTypeFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(ClockExpressionAndRelationPackage.Literals.LIBRARY__IMPORTS,
				 TimeModelFactory.eINSTANCE.createImportStatement()));
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
