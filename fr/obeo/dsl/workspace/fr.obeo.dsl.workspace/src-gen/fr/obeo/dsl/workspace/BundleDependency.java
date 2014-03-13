/**
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 */
package fr.obeo.dsl.workspace;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Bundle Dependency</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#getId <em>Id</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#getLowerVersion <em>Lower Version</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#isLowerVersionIncluded <em>Lower Version Included</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#getUpperVersion <em>Upper Version</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#isUpperVersionIncluded <em>Upper Version Included</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#isExported <em>Exported</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.BundleDependency#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency()
 * @model
 * @generated
 */
public interface BundleDependency extends Dependency {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Lower Version</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Version</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lower Version</em>' attribute.
	 * @see #setLowerVersion(String)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_LowerVersion()
	 * @model required="true"
	 * @generated
	 */
	String getLowerVersion();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#getLowerVersion
	 * <em>Lower Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Lower Version</em>' attribute.
	 * @see #getLowerVersion()
	 * @generated
	 */
	void setLowerVersion(String value);

	/**
	 * Returns the value of the '<em><b>Lower Version Included</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Version Included</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lower Version Included</em>' attribute.
	 * @see #setLowerVersionIncluded(boolean)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_LowerVersionIncluded()
	 * @model required="true"
	 * @generated
	 */
	boolean isLowerVersionIncluded();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#isLowerVersionIncluded
	 * <em>Lower Version Included</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Lower Version Included</em>' attribute.
	 * @see #isLowerVersionIncluded()
	 * @generated
	 */
	void setLowerVersionIncluded(boolean value);

	/**
	 * Returns the value of the '<em><b>Upper Version</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Version</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Upper Version</em>' attribute.
	 * @see #setUpperVersion(String)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_UpperVersion()
	 * @model required="true"
	 * @generated
	 */
	String getUpperVersion();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#getUpperVersion
	 * <em>Upper Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Upper Version</em>' attribute.
	 * @see #getUpperVersion()
	 * @generated
	 */
	void setUpperVersion(String value);

	/**
	 * Returns the value of the '<em><b>Upper Version Included</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Version Included</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Upper Version Included</em>' attribute.
	 * @see #setUpperVersionIncluded(boolean)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_UpperVersionIncluded()
	 * @model required="true"
	 * @generated
	 */
	boolean isUpperVersionIncluded();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#isUpperVersionIncluded
	 * <em>Upper Version Included</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Upper Version Included</em>' attribute.
	 * @see #isUpperVersionIncluded()
	 * @generated
	 */
	void setUpperVersionIncluded(boolean value);

	/**
	 * Returns the value of the '<em><b>Exported</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exported</em>' attribute.
	 * @see #setExported(boolean)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_Exported()
	 * @model required="true"
	 * @generated
	 */
	boolean isExported();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#isExported <em>Exported</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Exported</em>' attribute.
	 * @see #isExported()
	 * @generated
	 */
	void setExported(boolean value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getBundleDependency_Optional()
	 * @model required="true"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.BundleDependency#isOptional <em>Optional</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

} // BundleDependency
