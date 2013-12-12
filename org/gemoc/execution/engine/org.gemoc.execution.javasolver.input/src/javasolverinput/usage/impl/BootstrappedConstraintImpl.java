/**
 */
package javasolverinput.usage.impl;

import javasolverinput.usage.BootstrappedConstraint;
import javasolverinput.usage.UsagePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bootstrapped Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class BootstrappedConstraintImpl extends ConstraintImpl implements BootstrappedConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected BootstrappedConstraintImpl() {
		super();
		this.setName(this.eClass().getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagePackage.Literals.BOOTSTRAPPED_CONSTRAINT;
	}

} //BootstrappedConstraintImpl
