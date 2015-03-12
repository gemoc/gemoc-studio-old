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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.edit.provider;


import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.provider.BinaryIntegerExpressionItemProvider;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.edit.provider.FSMModelEditPlugin;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfDivideAssignement;

/**
 * This is the item provider adapter for a {@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfDivideAssignement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IntSelfDivideAssignementItemProvider
	extends BinaryIntegerExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSelfDivideAssignementItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns IntSelfDivideAssignement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IntSelfDivideAssignement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IntSelfDivideAssignement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IntSelfDivideAssignement_type") :
			getString("_UI_IntSelfDivideAssignement_type") + " " + label;
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
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfDivideAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__LEFT_VALUE,
				 FSMModelFactory.eINSTANCE.createIntegerAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createIntSelfDivideAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE,
				 FSMModelFactory.eINSTANCE.createIntegerAssignement()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__LEFT_VALUE ||
			childFeature == ClassicalExpressionPackage.Literals.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return FSMModelEditPlugin.INSTANCE;
	}

}
