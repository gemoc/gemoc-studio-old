/**
 */
package tfsmextended.tfsmextended.impl;

import org.eclipse.emf.ecore.EClass;

import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor;
import tfsmextended.tfsmextended.EventGuard;
import tfsmextended.tfsmextended.TfsmextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EventGuardImpl extends org.gemoc.sample.tfsm.impl.EventGuardImpl implements EventGuard {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventGuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmextendedPackage.Literals.EVENT_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(IVisitor visitor) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //EventGuardImpl
