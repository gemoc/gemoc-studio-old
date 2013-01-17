/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Class Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.MetaClassRef#getEClassifier <em>EClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getMetaClassRef()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface MetaClassRef extends CDOObject {
    /**
	 * Returns the value of the '<em><b>EClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>EClassifier</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>EClassifier</em>' reference.
	 * @see #setEClassifier(EClassifier)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getMetaClassRef_EClassifier()
	 * @model required="true"
	 * @generated
	 */
    EClassifier getEClassifier();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.MetaClassRef#getEClassifier <em>EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClassifier</em>' reference.
	 * @see #getEClassifier()
	 * @generated
	 */
    void setEClassifier(EClassifier value);

} // MetaClassRef
