/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.gemoc_language_workbench.conf.BuildOptions;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gemoc Language Workbench Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.GemocLanguageWorkbenchConfigurationImpl#getLanguageDefinition <em>Language Definition</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.GemocLanguageWorkbenchConfigurationImpl#getBuildOptions <em>Build Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GemocLanguageWorkbenchConfigurationImpl extends EObjectImpl implements GemocLanguageWorkbenchConfiguration {
	/**
	 * The cached value of the '{@link #getLanguageDefinition() <em>Language Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageDefinition()
	 * @generated
	 * @ordered
	 */
	protected LanguageDefinition languageDefinition;
	/**
	 * The cached value of the '{@link #getBuildOptions() <em>Build Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildOptions()
	 * @generated
	 * @ordered
	 */
	protected BuildOptions buildOptions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GemocLanguageWorkbenchConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageDefinition getLanguageDefinition() {
		return languageDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLanguageDefinition(LanguageDefinition newLanguageDefinition, NotificationChain msgs) {
		LanguageDefinition oldLanguageDefinition = languageDefinition;
		languageDefinition = newLanguageDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION, oldLanguageDefinition, newLanguageDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageDefinition(LanguageDefinition newLanguageDefinition) {
		if (newLanguageDefinition != languageDefinition) {
			NotificationChain msgs = null;
			if (languageDefinition != null)
				msgs = ((InternalEObject)languageDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION, null, msgs);
			if (newLanguageDefinition != null)
				msgs = ((InternalEObject)newLanguageDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION, null, msgs);
			msgs = basicSetLanguageDefinition(newLanguageDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION, newLanguageDefinition, newLanguageDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildOptions getBuildOptions() {
		return buildOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuildOptions(BuildOptions newBuildOptions, NotificationChain msgs) {
		BuildOptions oldBuildOptions = buildOptions;
		buildOptions = newBuildOptions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS, oldBuildOptions, newBuildOptions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildOptions(BuildOptions newBuildOptions) {
		if (newBuildOptions != buildOptions) {
			NotificationChain msgs = null;
			if (buildOptions != null)
				msgs = ((InternalEObject)buildOptions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS, null, msgs);
			if (newBuildOptions != null)
				msgs = ((InternalEObject)newBuildOptions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS, null, msgs);
			msgs = basicSetBuildOptions(newBuildOptions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS, newBuildOptions, newBuildOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION:
				return basicSetLanguageDefinition(null, msgs);
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS:
				return basicSetBuildOptions(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION:
				return getLanguageDefinition();
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS:
				return getBuildOptions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION:
				setLanguageDefinition((LanguageDefinition)newValue);
				return;
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS:
				setBuildOptions((BuildOptions)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION:
				setLanguageDefinition((LanguageDefinition)null);
				return;
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS:
				setBuildOptions((BuildOptions)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITION:
				return languageDefinition != null;
			case confPackage.GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__BUILD_OPTIONS:
				return buildOptions != null;
		}
		return super.eIsSet(featureID);
	}

} //GemocLanguageWorkbenchConfigurationImpl
