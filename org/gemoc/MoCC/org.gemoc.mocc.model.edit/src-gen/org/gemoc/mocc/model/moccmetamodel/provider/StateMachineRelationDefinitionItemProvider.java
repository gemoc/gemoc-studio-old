/**
 */
package org.gemoc.mocc.model.moccmetamodel.provider;


import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypeFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationFactory;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.provider.ExternalRelationDefinitionItemProvider;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelFactory;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelFactory;
import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage;
import org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition;

/**
 * This is the item provider adapter for a {@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StateMachineRelationDefinitionItemProvider
	extends ExternalRelationDefinitionItemProvider
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
	public StateMachineRelationDefinitionItemProvider(AdapterFactory adapterFactory) {
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

			addInitialStatePropertyDescriptor(object);
			addFinalStatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Initial State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StateMachineRelationDefinition_initialState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StateMachineRelationDefinition_initialState_feature", "_UI_StateMachineRelationDefinition_type"),
				 MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Final State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinalStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StateMachineRelationDefinition_finalState_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StateMachineRelationDefinition_finalState_feature", "_UI_StateMachineRelationDefinition_type"),
				 MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE,
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
			childrenFeatures.add(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES);
			childrenFeatures.add(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS);
			childrenFeatures.add(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS);
			childrenFeatures.add(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES);
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
	 * This returns StateMachineRelationDefinition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StateMachineRelationDefinition"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StateMachineRelationDefinition)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_StateMachineRelationDefinition_type") :
			getString("_UI_StateMachineRelationDefinition_type") + " " + label;
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

		switch (notification.getFeatureID(StateMachineRelationDefinition.class)) {
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES:
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS:
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
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
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES,
				 MoccmetamodelFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS,
				 MoccmetamodelFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 MoccmetamodelFactory.eINSTANCE.createIntegerAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntDivide()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealEqual()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealInf()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealSup()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntEqual()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntInf()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntSup()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqIsEmpty()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetTail()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetHead()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqDecr()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createSeqSched()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createRealVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 MoccmetamodelFactory.eINSTANCE.createIntegerAssignment()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 TimeModelFactory.eINSTANCE.createClock()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createUnaryIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntPlus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntMinus()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntMultiply()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntDivide()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealEqual()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealInf()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealSup()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntEqual()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntInf()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntSup()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqIsEmpty()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetTail()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqGetHead()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqDecr()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createSeqSched()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createBooleanVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createIntegerVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createRealVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClassicalExpressionFactory.eINSTANCE.createNumberSeqVariableRef()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createConcreteEntity()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 ClockExpressionAndRelationFactory.eINSTANCE.createRelation()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createStringElement()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createBooleanElement()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createIntegerElement()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createRealElement()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createCharElement()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createRecordElement()));

		newChildDescriptors.add
			(createChildParameter
				(MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES,
				 BasicTypeFactory.eINSTANCE.createSequenceElement()));
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
			childFeature == MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS ||
			childFeature == MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES;

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
		return MoCCMetamodelEditPlugin.INSTANCE;
	}

}
