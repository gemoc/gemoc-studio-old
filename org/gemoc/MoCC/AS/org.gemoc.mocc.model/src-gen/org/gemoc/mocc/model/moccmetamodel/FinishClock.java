/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Finish Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.FinishClock#getClock <em>Clock</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getFinishClock()
 * @model
 * @generated
 */
public interface FinishClock extends Action {
	/**
	 * Returns the value of the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock</em>' reference.
	 * @see #setClock(BindableEntity)
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getFinishClock_Clock()
	 * @model required="true"
	 * @generated
	 */
	BindableEntity getClock();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.model.moccmetamodel.FinishClock#getClock <em>Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock</em>' reference.
	 * @see #getClock()
	 * @generated
	 */
	void setClock(BindableEntity value);

} // FinishClock
