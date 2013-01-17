/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getSubComponents <em>Sub Components</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getReferencedComponents <em>Referenced Components</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getBundles <em>Bundles</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getExpectedDependencies <em>Expected Dependencies</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getExpectedExtensions <em>Expected Extensions</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getPorts <em>Ports</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Component#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Component extends CDOObject {
    /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_Name()
	 * @model
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.Component#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Sub Components</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Component}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Components</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_SubComponents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
    EList<Component> getSubComponents();

    /**
	 * Returns the value of the '<em><b>Referenced Components</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Components</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_ReferencedComponents()
	 * @model
	 * @generated
	 */
	EList<Component> getReferencedComponents();

				/**
	 * Returns the value of the '<em><b>Bundles</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Bundle}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bundles</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundles</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_Bundles()
	 * @model ordered="false"
	 * @generated
	 */
    EList<Bundle> getBundles();

    /**
	 * Returns the value of the '<em><b>Expected Dependencies</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Component}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expected Dependencies</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Dependencies</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_ExpectedDependencies()
	 * @model
	 * @generated
	 */
    EList<Component> getExpectedDependencies();

    /**
	 * Returns the value of the '<em><b>Expected Extensions</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Component}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expected Extensions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Extensions</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_ExpectedExtensions()
	 * @model
	 * @generated
	 */
    EList<Component> getExpectedExtensions();

    /**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Port}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_Ports()
	 * @model containment="true"
	 * @generated
	 */
    EList<Port> getPorts();

    /**
	 * Returns the value of the '<em><b>Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClassifier}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Classifiers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifiers</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_Classifiers()
	 * @model containment="true"
	 * @generated
	 */
    EList<EClassifier> getClassifiers();

    /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getComponent_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.Component#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
    void setDescription(String value);

} // Component
