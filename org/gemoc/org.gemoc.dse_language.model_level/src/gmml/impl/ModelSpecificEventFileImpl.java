/**
 */
package gmml.impl;

import gmml.GmmlPackage;
import gmml.ImportStatement;
import gmml.ModelSpecificEvent;
import gmml.ModelSpecificEventFile;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Specific Event File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gmml.impl.ModelSpecificEventFileImpl#getImport <em>Import</em>}</li>
 *   <li>{@link gmml.impl.ModelSpecificEventFileImpl#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelSpecificEventFileImpl extends MinimalEObjectImpl.Container implements ModelSpecificEventFile {
	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected ImportStatement import_;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelSpecificEvent> events;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSpecificEventFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GmmlPackage.Literals.MODEL_SPECIFIC_EVENT_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportStatement getImport() {
		if (import_ != null && import_.eIsProxy()) {
			InternalEObject oldImport = (InternalEObject)import_;
			import_ = (ImportStatement)eResolveProxy(oldImport);
			if (import_ != oldImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__IMPORT, oldImport, import_));
			}
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportStatement basicGetImport() {
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImport(ImportStatement newImport) {
		ImportStatement oldImport = import_;
		import_ = newImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelSpecificEvent> getEvents() {
		if (events == null) {
			events = new EObjectResolvingEList<ModelSpecificEvent>(ModelSpecificEvent.class, this, GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__EVENTS:
				return getEvents();
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
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__IMPORT:
				setImport((ImportStatement)newValue);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends ModelSpecificEvent>)newValue);
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
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__IMPORT:
				setImport((ImportStatement)null);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__EVENTS:
				getEvents().clear();
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
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__IMPORT:
				return import_ != null;
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE__EVENTS:
				return events != null && !events.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelSpecificEventFileImpl
