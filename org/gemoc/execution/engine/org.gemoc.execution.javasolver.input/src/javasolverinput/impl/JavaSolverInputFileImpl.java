/**
 */
package javasolverinput.impl;

import java.util.Collection;

import javasolverinput.Clock;
import javasolverinput.JavaSolverInputFile;
import javasolverinput.JavasolverinputPackage;
import javasolverinput.Relation;

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
 *   <li>{@link javasolverinput.impl.JavaSolverInputFileImpl#getClocks <em>Clocks</em>}</li>
 *   <li>{@link javasolverinput.impl.JavaSolverInputFileImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaSolverInputFileImpl extends NamedElementImpl implements JavaSolverInputFile {
	/**
	 * The cached value of the '{@link #getClocks() <em>Clocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<Clock> clocks;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> constraints;

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
	public EList<Clock> getClocks() {
		if (clocks == null) {
			clocks = new EObjectContainmentEList<Clock>(Clock.class, this, JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCKS);
		}
		return clocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Relation>(Relation.class, this, JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS);
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCKS:
				return ((InternalEList<?>)getClocks()).basicRemove(otherEnd, msgs);
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCKS:
				return getClocks();
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCKS:
				getClocks().clear();
				getClocks().addAll((Collection<? extends Clock>)newValue);
				return;
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Relation>)newValue);
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCKS:
				getClocks().clear();
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CLOCKS:
				return clocks != null && !clocks.isEmpty();
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JavaSolverInputFileImpl
