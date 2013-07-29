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


import fr.obeo.dsl.sirius.animation.AnimationFactory;
import fr.obeo.dsl.sirius.animation.AnimationPackage;
import fr.obeo.dsl.sirius.animation.StackFrame;

import fr.obeo.dsl.viewpoint.ViewpointFactory;

import fr.obeo.dsl.viewpoint.ViewpointPackage;
import fr.obeo.dsl.viewpoint.description.DescriptionFactory;

import fr.obeo.dsl.viewpoint.description.audit.AuditFactory;

import fr.obeo.dsl.viewpoint.description.concern.ConcernFactory;

import fr.obeo.dsl.viewpoint.description.contribution.ContributionFactory;

import fr.obeo.dsl.viewpoint.description.filter.FilterFactory;

import fr.obeo.dsl.viewpoint.description.style.StyleFactory;

import fr.obeo.dsl.viewpoint.description.tool.ToolFactory;

import fr.obeo.dsl.viewpoint.description.validation.ValidationFactory;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

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
 * This is the item provider adapter for a {@link fr.obeo.dsl.sirius.animation.StackFrame} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StackFrameItemProvider
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
	public StackFrameItemProvider(AdapterFactory adapterFactory) {
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

			addIsSteppingPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addSourceElementPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Stepping feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsSteppingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StackFrame_isStepping_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StackFrame_isStepping_feature", "_UI_StackFrame_type"),
				 AnimationPackage.Literals.STACK_FRAME__IS_STEPPING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_StackFrame_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StackFrame_name_feature", "_UI_StackFrame_type"),
				 AnimationPackage.Literals.STACK_FRAME__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source Element feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourceElementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_StackFrame_sourceElement_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_StackFrame_sourceElement_feature", "_UI_StackFrame_type"),
				 AnimationPackage.Literals.STACK_FRAME__SOURCE_ELEMENT,
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
			childrenFeatures.add(AnimationPackage.Literals.STACK_FRAME__VARIABLES);
			childrenFeatures.add(AnimationPackage.Literals.STACK_FRAME__SUB_FRAMES);
			childrenFeatures.add(AnimationPackage.Literals.STACK_FRAME__DATA);
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
	 * This returns StackFrame.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @not-generated
	 */
	@Override
	public Object getImage(Object object) {
		if (object instanceof StackFrame && ((StackFrame) object).isIsStepping()) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/StackFrame_running"));
		}
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StackFrame"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StackFrame)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_StackFrame_type") :
			getString("_UI_StackFrame_type") + " " + label;
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

		switch (notification.getFeatureID(StackFrame.class)) {
			case AnimationPackage.STACK_FRAME__IS_STEPPING:
			case AnimationPackage.STACK_FRAME__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AnimationPackage.STACK_FRAME__VARIABLES:
			case AnimationPackage.STACK_FRAME__SUB_FRAMES:
			case AnimationPackage.STACK_FRAME__DATA:
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
				(AnimationPackage.Literals.STACK_FRAME__VARIABLES,
				 AnimationFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__SUB_FRAMES,
				 AnimationFactory.eINSTANCE.createStackFrame()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 AnimationFactory.eINSTANCE.createAnimationTarget()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 AnimationFactory.eINSTANCE.createStackFrame()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 AnimationFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 AnimationFactory.eINSTANCE.createThread()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 AnimationFactory.eINSTANCE.createCurrentSessions()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createIgnoreFeatureContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createSetFeatureContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createAddFeatureContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createRemoveFeatureContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createClearFeatureContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createResetFeatureContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createDirectEObjectReference()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createComputedEObjectReference()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createContribution()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ContributionFactory.eINSTANCE.createContributionPoint()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEEnumLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEFactory()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEObject()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEOperation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEParameter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEReference()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.create(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY)));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createEGenericType()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 EcoreFactory.eINSTANCE.createETypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDAnalysis()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDView()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDRepresentationContainer()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createMetaModelExtension()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDSemanticDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createHideFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createHideLabelFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createFoldingPointFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createFoldingFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createAppliedCompositeFilters()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createAbsoluteBoundsFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDecoration()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDEObjectLink()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDDiagramLink()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDSourceFileLink()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDNode()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDNodeContainer()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDNodeList()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDNodeListElement()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDEdge()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDDiagramSet()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createBasicLabelStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createLabelStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDot()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createGaugeSection()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createFlatContainerStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createShapeContainerStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createSquare()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createEllipse()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createLozenge()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createBundledImage()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createWorkspaceImage()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createCustomStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createEdgeStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDAnalysisCustomData()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createGaugeCompositeStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createBorderedStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createNote()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDragAndDropTarget()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createFilterVariableHistory()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createFilterVariableValue()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createRGBValues()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDAnalysisSessionEObject()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createCollapseFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createSessionManagerEObject()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDFile()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDResourceContainer()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDProject()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDFolder()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createDModel()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createBeginLabelStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createCenterLabelStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createEndLabelStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ViewpointFactory.eINSTANCE.createBracketEdgeStyle()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createViewpoint()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createDiagramDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createDiagramImportDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createDiagramExtensionDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createMetamodelExtensionSetting()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createJavaExtension()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createIdentifiedElement()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createNodeMapping()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createContainerMapping()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createNodeMappingImport()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createContainerMappingImport()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createEdgeMapping()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createEdgeMappingImport()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createDAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createConditionalNodeStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createConditionalEdgeStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createConditionalContainerStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createOrderedTreeLayout()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createCompositeLayout()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createDecorationDescriptionsSet()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createMappingBasedDecoration()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createSemanticBasedDecoration()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createLayer()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createOptionalLayer()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createCustomization()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createVSMElementCustomization()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createVSMElementCustomizationReuse()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createEAttributeCustomization()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createEReferenceCustomization()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createFixedColor()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createSystemColor()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createInterpolatedColor()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createColorStep()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createUserFixedColor()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createEnvironment()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createSytemColorsPalette()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createUserColorsPalette()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createAnnotationEntry()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createComputedColor()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 DescriptionFactory.eINSTANCE.createDAnnotationEntry()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createBorderedStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createBasicLabelStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createLabelStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createLabelBorderStyles()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createLabelBorderStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createCustomStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createSquareDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createLozengeNodeDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createEllipseNodeDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createBundledImageDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createNoteDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createDotDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createGaugeCompositeStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createFlatContainerStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createShapeContainerStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createWorkspaceImageDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createEdgeStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createTooltipStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createGaugeSectionDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createBeginLabelStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createCenterLabelStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createEndLabelStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 StyleFactory.eINSTANCE.createBracketEdgeStyleDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createToolSection()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createToolGroup()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createToolGroupExtension()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createToolDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createNodeCreationDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createEdgeCreationDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createContainerCreationDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createContainerDropDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createPasteDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDeleteElementDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDoubleClickDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDeleteHook()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDeleteHookParameter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createReconnectEdgeDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createRequestDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSelectionWizardDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createPaneBasedSelectionWizardDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createMenuItemDescriptionReference()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createOperationAction()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createExternalJavaAction()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createExternalJavaActionCall()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createPopupMenu()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDirectEditLabel()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createBehaviorTool()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createAcceleoVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSourceEdgeCreationVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSourceEdgeViewCreationVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createTargetEdgeCreationVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createTargetEdgeViewCreationVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createElementDropVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createElementSelectVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createElementVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createElementViewVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createElementDeleteVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createElementDoubleClickVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createNodeCreationVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDropContainerVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSelectContainerVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createContainerViewVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSelectModelElementVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createEditMaskVariables()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createInitialNodeCreationOperation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createInitialOperation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createInitEdgeCreationOperation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createInitialContainerDropOperation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createCreateInstance()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createChangeContext()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSetValue()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSetObject()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createUnset()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createMoveElement()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createRemoveElement()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createFor()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createCreateView()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createCreateEdgeView()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createIf()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDeleteView()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createNavigation()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createNameVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createExternalJavaActionParameter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDiagramCreationDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDiagramNavigationDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createToolFilterDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createFeatureChangeListener()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createCase()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createDefault()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ToolFactory.eINSTANCE.createSwitch()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 FilterFactory.eINSTANCE.createMappingFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 FilterFactory.eINSTANCE.createCompositeFilterDescription()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 FilterFactory.eINSTANCE.createVariableFilter()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 FilterFactory.eINSTANCE.createFilterVariable()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ValidationFactory.eINSTANCE.createValidationSet()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ValidationFactory.eINSTANCE.createSemanticValidationRule()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ValidationFactory.eINSTANCE.createViewValidationRule()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ValidationFactory.eINSTANCE.createRuleAudit()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ValidationFactory.eINSTANCE.createValidationFix()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 AuditFactory.eINSTANCE.createTemplateInformationSection()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ConcernFactory.eINSTANCE.createConcernSet()));

		newChildDescriptors.add
			(createChildParameter
				(AnimationPackage.Literals.STACK_FRAME__DATA,
				 ConcernFactory.eINSTANCE.createConcernDescription()));
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
			childFeature == AnimationPackage.Literals.STACK_FRAME__VARIABLES ||
			childFeature == AnimationPackage.Literals.STACK_FRAME__DATA ||
			childFeature == AnimationPackage.Literals.STACK_FRAME__SUB_FRAMES;

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
		return AnimationEditPlugin.INSTANCE;
	}

}
