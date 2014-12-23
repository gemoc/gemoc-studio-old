/**
 */
package sigpmlextended.impl;

import com.google.common.collect.LinkedListMultimap;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sigpmlextended.Place;
import sigpmlextended.SigpmlextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sigpmlextended.impl.PlaceImpl#getFifo <em>Fifo</em>}</li>
 *   <li>{@link sigpmlextended.impl.PlaceImpl#isIsInitialized <em>Is Initialized</em>}</li>
 *   <li>{@link sigpmlextended.impl.PlaceImpl#getCurrentSize <em>Current Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaceImpl extends org.gemoc.sigpml.impl.PlaceImpl implements Place {
	/**
	 * The default value of the '{@link #getFifo() <em>Fifo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFifo()
	 * @generated
	 * @ordered
	 */
	protected static final ArrayList FIFO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFifo() <em>Fifo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFifo()
	 * @generated
	 * @ordered
	 */
	protected ArrayList fifo = FIFO_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsInitialized() <em>Is Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInitialized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INITIALIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsInitialized() <em>Is Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInitialized()
	 * @generated
	 * @ordered
	 */
	protected boolean isInitialized = IS_INITIALIZED_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentSize() <em>Current Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSize()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentSize() <em>Current Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentSize()
	 * @generated
	 * @ordered
	 */
	protected int currentSize = CURRENT_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlextendedPackage.Literals.PLACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayList getFifo() {
		return fifo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFifo(ArrayList newFifo) {
		ArrayList oldFifo = fifo;
		fifo = newFifo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.PLACE__FIFO, oldFifo, fifo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInitialized() {
		return isInitialized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInitialized(boolean newIsInitialized) {
		boolean oldIsInitialized = isInitialized;
		isInitialized = newIsInitialized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.PLACE__IS_INITIALIZED, oldIsInitialized, isInitialized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentSize() {
		return currentSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentSize(int newCurrentSize) {
		int oldCurrentSize = currentSize;
		currentSize = newCurrentSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.PLACE__CURRENT_SIZE, oldCurrentSize, currentSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void push() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void pop() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkedListMultimap sharedMemory() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlextendedPackage.PLACE__FIFO:
				return getFifo();
			case SigpmlextendedPackage.PLACE__IS_INITIALIZED:
				return isIsInitialized();
			case SigpmlextendedPackage.PLACE__CURRENT_SIZE:
				return getCurrentSize();
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
			case SigpmlextendedPackage.PLACE__FIFO:
				setFifo((ArrayList)newValue);
				return;
			case SigpmlextendedPackage.PLACE__IS_INITIALIZED:
				setIsInitialized((Boolean)newValue);
				return;
			case SigpmlextendedPackage.PLACE__CURRENT_SIZE:
				setCurrentSize((Integer)newValue);
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
			case SigpmlextendedPackage.PLACE__FIFO:
				setFifo(FIFO_EDEFAULT);
				return;
			case SigpmlextendedPackage.PLACE__IS_INITIALIZED:
				setIsInitialized(IS_INITIALIZED_EDEFAULT);
				return;
			case SigpmlextendedPackage.PLACE__CURRENT_SIZE:
				setCurrentSize(CURRENT_SIZE_EDEFAULT);
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
			case SigpmlextendedPackage.PLACE__FIFO:
				return FIFO_EDEFAULT == null ? fifo != null : !FIFO_EDEFAULT.equals(fifo);
			case SigpmlextendedPackage.PLACE__IS_INITIALIZED:
				return isInitialized != IS_INITIALIZED_EDEFAULT;
			case SigpmlextendedPackage.PLACE__CURRENT_SIZE:
				return currentSize != CURRENT_SIZE_EDEFAULT;
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
		result.append(" (fifo: ");
		result.append(fifo);
		result.append(", isInitialized: ");
		result.append(isInitialized);
		result.append(", currentSize: ");
		result.append(currentSize);
		result.append(')');
		return result.toString();
	}

} //PlaceImpl
