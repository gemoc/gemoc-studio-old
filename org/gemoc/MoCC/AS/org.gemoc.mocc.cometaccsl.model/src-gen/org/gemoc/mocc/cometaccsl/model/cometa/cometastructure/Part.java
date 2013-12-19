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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Part: Part are containers insofar as they are able to contain / define a semantic layer. Part refers to existing components and represents a duplication of the latter.
 * The Part participates in the description of topologies by offering the possibility to describe the concept of "black-box" reproducing the behavior of a composite or atomic
 * execution control module. Elements of type Part have ports connecting them with the rest of the structure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getComponentType <em>Component Type</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getPart()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='PartHasSameNumberOfPortsThanItsComponent EachPortIsDefinedInComponent NoRedondancyInPortsNames'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot PartHasSameNumberOfPortsThanItsComponent='ports->size()=componentType.ownedPortInstances->size()' EachPortIsDefinedInComponent='ports->forAll(self.componentType.ownedPortInstances->collect(name)->includes(name))' NoRedondancyInPortsNames='self.ports->forAll(p1, p2 | p1<>p2 implies p1.name<>p2.name)'"
 * @generated
 */
public interface Part extends NamedElement, Container {
	/**
	 * Returns the value of the '<em><b>Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Type</em>' reference.
	 * @see #setComponentType(MoCComponent)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getPart_ComponentType()
	 * @model required="true"
	 * @generated
	 */
	MoCComponent getComponentType();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getComponentType <em>Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Type</em>' reference.
	 * @see #getComponentType()
	 * @generated
	 */
	void setComponentType(MoCComponent value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getPart_Ports()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCPort> getPorts();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Container)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getPart_Container()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container#getParts
	 * @model opposite="parts" transient="false"
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

} // Part
