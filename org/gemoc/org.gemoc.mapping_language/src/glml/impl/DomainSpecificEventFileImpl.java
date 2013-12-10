/**
 */
package glml.impl;

import glml.DomainSpecificEvent;
import glml.DomainSpecificEventFile;
import glml.GlmlPackage;
import glml.ImportStatement;

import glml.ModelSpecificEvent;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
 *   <li>{@link glml.impl.DomainSpecificEventFileImpl#getModelEvents <em>Model Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificEventFileImpl extends NamedElementImpl implements DomainSpecificEventFile {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportStatement> imports;

	/**
	 * The cached value of the '{@link #getLanguageEvents() <em>Language Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainSpecificEvent> languageEvents;

	/**
	 * The cached value of the '{@link #getModelEvents() <em>Model Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSpecificEvent> modelEvents;

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
	public EList<ImportStatement> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportStatement>(ImportStatement.class, this, GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainSpecificEvent> getLanguageEvents() {
		if (languageEvents == null) {
			languageEvents = new EObjectContainmentEList<DomainSpecificEvent>(DomainSpecificEvent.class, this, GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS);
		}
		return languageEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSpecificEvent> getModelEvents() {
		if (modelEvents == null) {
			modelEvents = new EObjectContainmentEList<ModelSpecificEvent>(ModelSpecificEvent.class, this, GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS);
		}
		return modelEvents;
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
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				return ((InternalEList<?>)getLanguageEvents()).basicRemove(otherEnd, msgs);
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS:
				return ((InternalEList<?>)getModelEvents()).basicRemove(otherEnd, msgs);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS:
				return getModelEvents();
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
				getImports().clear();
				getImports().addAll((Collection<? extends ImportStatement>)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				getLanguageEvents().clear();
				getLanguageEvents().addAll((Collection<? extends DomainSpecificEvent>)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS:
				getModelEvents().clear();
				getModelEvents().addAll((Collection<? extends ModelSpecificEvent>)newValue);
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
				getImports().clear();
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				getLanguageEvents().clear();
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS:
				getModelEvents().clear();
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
				return imports != null && !imports.isEmpty();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS:
				return languageEvents != null && !languageEvents.isEmpty();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS:
				return modelEvents != null && !modelEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificEventFileImpl
