/**
 */
package glml.impl;

import glml.DomainSpecificEventFile;
import glml.GlmlPackage;
import glml.ImportStatement;
import glml.LanguageSpecificEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Specific Event File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link glml.impl.DomainSpecificEventFileImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificEventFileImpl#getLanguageEvents <em>Language Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificEventFileImpl extends MinimalEObjectImpl.Container implements DomainSpecificEventFile {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected ImportStatement imports;

	/**
	 * The cached value of the '{@link #getLanguageEvents() <em>Language Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageSpecificEvent> languageEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSpecificEventFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlmlPackage.Literals.DOMAIN_SPECIFIC_EVENT_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportStatement getImports() {
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImports(ImportStatement newImports, NotificationChain msgs) {
		ImportStatement oldImports = imports;
		imports = newImports;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS, oldImports, newImports);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImports(ImportStatement newImports) {
		if (newImports != imports) {
			NotificationChain msgs = null;
			if (imports != null)
				msgs = ((InternalEObject)imports).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS, null, msgs);
			if (newImports != null)
				msgs = ((InternalEObject)newImports).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS, null, msgs);
			msgs = basicSetImports(newImports, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS, newImports, newImports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LanguageSpecificEvent> getLanguageEvents() {
		if (languageEvents == null) {
			languageEvents = new EObjectContainmentEList<LanguageSpecificEvent>(LanguageSpecificEvent.class, this, GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS);
		}
		return languageEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS:
				return basicSetImports(null, msgs);
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				return ((InternalEList<?>)getLanguageEvents()).basicRemove(otherEnd, msgs);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS:
				return getImports();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				return getLanguageEvents();
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS:
				setImports((ImportStatement)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				getLanguageEvents().clear();
				getLanguageEvents().addAll((Collection<? extends LanguageSpecificEvent>)newValue);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS:
				setImports((ImportStatement)null);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				getLanguageEvents().clear();
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS:
				return imports != null;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				return languageEvents != null && !languageEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificEventFileImpl
