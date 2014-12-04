/**
 */
package tfsmextended.tfsmextended.impl;

import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;

import tfsmextended.tfsmextended.Guard;
import tfsmextended.tfsmextended.TfsmextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class GuardImpl extends org.gemoc.sample.tfsm.impl.GuardImpl implements Guard {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmextendedPackage.Literals.GUARD;
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

} //GuardImpl
