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
package org.gemoc.mocc.fsmkernel.model.FSMModel.edit.provider;


import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypeFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionFactory;

/**
 * This is the item provider adapter for a {@link org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DeclarationBlockItemProvider
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
	public DeclarationBlockItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES);
			childrenFeatures.add(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS);
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
	 * This returns DeclarationBlock.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DeclarationBlock"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_DeclarationBlock_type");
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

		switch (notification.getFeatureID(DeclarationBlock.class)) {
			case FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES:
			case FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS:
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
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 FSMModelFactory.eINSTANCE.createIntegerAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createIntInfEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createIntSupEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createRealInfEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createRealSupEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createIntSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createIntSelfDivideAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createRealSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 TimeModelFactory.eINSTANCE.createClock()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntDivide()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealInf()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealSup()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntInf()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntSup()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqIsEmpty()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetTail()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetHead()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqDecr()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqSched()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createConcreteEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createRelation()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createStringElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createBooleanElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createIntegerElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createRealElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createCharElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createRecordElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createSequenceElement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 FSMModelFactory.eINSTANCE.createIntegerAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createIntInfEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createIntSupEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createRealInfEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createRealSupEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createIntSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createIntSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createIntSelfDivideAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createRealSelfPlusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMinusAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 EditionExtensionFactory.eINSTANCE.createRealSelfMultiplyAssignement()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntDivide()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealInf()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealSup()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntEqual()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntInf()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntSup()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqIsEmpty()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetTail()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetHead()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqDecr()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqSched()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqRef()));

		newChildDescriptors.add
			(createChildParameter
				(FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqVariableRef()));
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
			childFeature == FSMModelPackage.Literals.DECLARATION_BLOCK__CONCRETE_ENTITIES ||
			childFeature == FSMModelPackage.Literals.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS;

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
