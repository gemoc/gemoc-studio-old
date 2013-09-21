/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Trigger#getTrueTriggers <em>True Triggers</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Trigger#getFalseTriggers <em>False Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends EObject {
	/**
	 * Returns the value of the '<em><b>True Triggers</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Triggers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Triggers</em>' reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTrigger_TrueTriggers()
	 * @model
	 * @generated
	 */
	EList<BindableEntity> getTrueTriggers();

	/**
	 * Returns the value of the '<em><b>False Triggers</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Triggers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Triggers</em>' reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTrigger_FalseTriggers()
	 * @model
	 * @generated
	 */
	EList<BindableEntity> getFalseTriggers();

} // Trigger
