/**
 */
package gemoc_language_designer_conf.impl;

import gemoc_language_designer_conf.GemocLanguageDesignerConfiguration;
import gemoc_language_designer_conf.Gemoc_language_designer_confPackage;
import gemoc_language_designer_conf.LanguageDefinition;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gemoc Language Designer Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gemoc_language_designer_conf.impl.GemocLanguageDesignerConfigurationImpl#getLanguageDefinitions <em>Language Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GemocLanguageDesignerConfigurationImpl extends EObjectImpl implements GemocLanguageDesignerConfiguration {
	/**
	 * The cached value of the '{@link #getLanguageDefinitions() <em>Language Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageDefinition> languageDefinitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GemocLanguageDesignerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gemoc_language_designer_confPackage.Literals.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LanguageDefinition> getLanguageDefinitions() {
		if (languageDefinitions == null) {
			languageDefinitions = new EObjectContainmentEList<LanguageDefinition>(LanguageDefinition.class, this, Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS);
		}
		return languageDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS:
				return ((InternalEList<?>)getLanguageDefinitions()).basicRemove(otherEnd, msgs);
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
			case Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS:
				return getLanguageDefinitions();
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
			case Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS:
				getLanguageDefinitions().clear();
				getLanguageDefinitions().addAll((Collection<? extends LanguageDefinition>)newValue);
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
			case Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS:
				getLanguageDefinitions().clear();
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
			case Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS:
				return languageDefinitions != null && !languageDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GemocLanguageDesignerConfigurationImpl
