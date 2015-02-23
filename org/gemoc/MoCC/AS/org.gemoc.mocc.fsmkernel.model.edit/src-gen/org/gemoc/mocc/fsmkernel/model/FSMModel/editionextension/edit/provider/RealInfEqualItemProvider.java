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


import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionFactory;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.provider.BooleanExpressionItemProvider;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.gemoc.mocc.fsmkernel.model.FSMModel.edit.provider.FSMModelEditPlugin;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual;

/**
 * This is the item provider adapter for a {@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RealInfEqualItemProvider
	extends BooleanExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealInfEqualItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE);
			childrenFeatures.add(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE);
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
	 * This returns RealInfEqual.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RealInfEqual"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RealInfEqual)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_RealInfEqual_type") :
			getString("_UI_RealInfEqual_type") + " " + label;
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

		switch (notification.getFeatureID(RealInfEqual.class)) {
			case EditionExtensionPackage.REAL_INF_EQUAL__LEFT_VALUE:
			case EditionExtensionPackage.REAL_INF_EQUAL__RIGHT_VALUE:
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
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createRealSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealRef()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createRealSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealRef()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE,
				 ClassicalExpressionFactory.eINSTANCE.createRealVariableRef()));
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
			childFeature == EditionExtensionPackage.Literals.REAL_INF_EQUAL__LEFT_VALUE ||
			childFeature == EditionExtensionPackage.Literals.REAL_INF_EQUAL__RIGHT_VALUE;

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
