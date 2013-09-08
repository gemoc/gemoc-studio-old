/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.State#getOutputTransitions <em>Output Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.State#getInputTransitions <em>Input Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Output Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.model.moccmetamodel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Transitions</em>' reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getState_OutputTransitions()
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getOutputTransitions();

	/**
	 * Returns the value of the '<em><b>Input Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.model.moccmetamodel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Transitions</em>' reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getState_InputTransitions()
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getInputTransitions();

} // State
