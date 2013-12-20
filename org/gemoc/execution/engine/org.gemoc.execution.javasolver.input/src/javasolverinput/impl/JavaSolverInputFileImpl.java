/**
 */
package javasolverinput.impl;

import java.util.Collection;

import javasolverinput.JavaSolverInputFile;
import javasolverinput.JavasolverinputPackage;

import javasolverinput.usage.Clock;
import javasolverinput.usage.Constraint;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Solver Input File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link javasolverinput.impl.JavaSolverInputFileImpl#getClockDeclarations <em>Clock Declarations</em>}</li>
 *   <li>{@link javasolverinput.impl.JavaSolverInputFileImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaSolverInputFileImpl extends NamedElementImpl implements JavaSolverInputFile {
	/**
	 * The cached value of the '{@link #getClockDeclarations() <em>Clock Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClockDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<Clock> clockDeclarations;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaSolverInputFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavasolverinputPackage.Literals.JAVA_SOLVER_INPUT_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Clock> getClockDeclarations() {
		if (clockDeclarations == null) {
			clockDeclarations = new EObjectContainmentEList<Clock>(Clock.class, this, JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS);
		}
		return clockDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS:
				return ((InternalEList<?>)getClockDeclarations()).basicRemove(otherEnd, msgs);
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS:
				return getClockDeclarations();
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				return getConstraints();
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS:
				getClockDeclarations().clear();
				getClockDeclarations().addAll((Collection<? extends Clock>)newValue);
				return;
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS:
				getClockDeclarations().clear();
				return;
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				getConstraints().clear();
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS:
				return clockDeclarations != null && !clockDeclarations.isEmpty();
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JavaSolverInputFileImpl
