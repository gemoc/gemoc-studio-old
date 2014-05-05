/**
 */
package fr.obeo.dsl.process.impl;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.impl.ProcessContextImpl#getDefinition <em>Definition</em>}</li>
 * <li>{@link fr.obeo.dsl.process.impl.ProcessContextImpl#getProgress <em>Progress</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProcessContextImpl extends EObjectImpl implements ProcessContext {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected fr.obeo.dsl.process.Process definition;

	/**
	 * The cached value of the '{@link #getProgress() <em>Progress</em>}' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected EMap<ActionTask, Object> progress;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcessContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.PROCESS_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_CONTEXT__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fr.obeo.dsl.process.Process getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (fr.obeo.dsl.process.Process)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ProcessPackage.PROCESS_CONTEXT__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fr.obeo.dsl.process.Process basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefinition(fr.obeo.dsl.process.Process newDefinition) {
		fr.obeo.dsl.process.Process oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_CONTEXT__DEFINITION,
					oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<ActionTask, Object> getProgress() {
		if (progress == null) {
			progress = new EcoreEMap<ActionTask, Object>(ProcessPackage.Literals.TASK_TO_ARTIFACT_MAP,
					TaskToArtifactMapImpl.class, this, ProcessPackage.PROCESS_CONTEXT__PROGRESS);
		}
		return progress;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__PROGRESS:
				return ((InternalEList<?>)getProgress()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				return getName();
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				if (resolve)
					return getDefinition();
				return basicGetDefinition();
			case ProcessPackage.PROCESS_CONTEXT__PROGRESS:
				if (coreType)
					return getProgress();
				else
					return getProgress().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				setDefinition((fr.obeo.dsl.process.Process)newValue);
				return;
			case ProcessPackage.PROCESS_CONTEXT__PROGRESS:
				((EStructuralFeature.Setting)getProgress()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				setDefinition((fr.obeo.dsl.process.Process)null);
				return;
			case ProcessPackage.PROCESS_CONTEXT__PROGRESS:
				getProgress().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				return definition != null;
			case ProcessPackage.PROCESS_CONTEXT__PROGRESS:
				return progress != null && !progress.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // ProcessContextImpl
