/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XText Editor Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl#getGrammarName <em>Grammar Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XTextEditorProjectImpl extends EditorProjectImpl implements XTextEditorProject {
	/**
	 * The default value of the '{@link #getGrammarName() <em>Grammar Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammarName()
	 * @generated
	 * @ordered
	 */
	protected static final String GRAMMAR_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGrammarName() <em>Grammar Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammarName()
	 * @generated
	 * @ordered
	 */
	protected String grammarName = GRAMMAR_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XTextEditorProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.XTEXT_EDITOR_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGrammarName() {
		return grammarName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammarName(String newGrammarName) {
		String oldGrammarName = grammarName;
		grammarName = newGrammarName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.XTEXT_EDITOR_PROJECT__GRAMMAR_NAME, oldGrammarName, grammarName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case confPackage.XTEXT_EDITOR_PROJECT__GRAMMAR_NAME:
				return getGrammarName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case confPackage.XTEXT_EDITOR_PROJECT__GRAMMAR_NAME:
				setGrammarName((String)newValue);
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
			case confPackage.XTEXT_EDITOR_PROJECT__GRAMMAR_NAME:
				setGrammarName(GRAMMAR_NAME_EDEFAULT);
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
			case confPackage.XTEXT_EDITOR_PROJECT__GRAMMAR_NAME:
				return GRAMMAR_NAME_EDEFAULT == null ? grammarName != null : !GRAMMAR_NAME_EDEFAULT.equals(grammarName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (grammarName: ");
		result.append(grammarName);
		result.append(')');
		return result.toString();
	}

} //XTextEditorProjectImpl
