/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.gemoc.gemoc_language_workbench.conf.BuildOptions;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Build Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.BuildOptionsImpl#isGenerateModelLoaderService <em>Generate Model Loader Service</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.BuildOptionsImpl#isGenerateCodeExecutorService <em>Generate Code Executor Service</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.BuildOptionsImpl#isGenerateQVTOFromECL <em>Generate QVTO From ECL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BuildOptionsImpl extends EObjectImpl implements BuildOptions {
	/**
	 * The default value of the '{@link #isGenerateModelLoaderService() <em>Generate Model Loader Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateModelLoaderService()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_MODEL_LOADER_SERVICE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerateModelLoaderService() <em>Generate Model Loader Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateModelLoaderService()
	 * @generated
	 * @ordered
	 */
	protected boolean generateModelLoaderService = GENERATE_MODEL_LOADER_SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerateCodeExecutorService() <em>Generate Code Executor Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateCodeExecutorService()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_CODE_EXECUTOR_SERVICE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerateCodeExecutorService() <em>Generate Code Executor Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateCodeExecutorService()
	 * @generated
	 * @ordered
	 */
	protected boolean generateCodeExecutorService = GENERATE_CODE_EXECUTOR_SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerateQVTOFromECL() <em>Generate QVTO From ECL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateQVTOFromECL()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_QVTO_FROM_ECL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerateQVTOFromECL() <em>Generate QVTO From ECL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerateQVTOFromECL()
	 * @generated
	 * @ordered
	 */
	protected boolean generateQVTOFromECL = GENERATE_QVTO_FROM_ECL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuildOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.BUILD_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateModelLoaderService() {
		return generateModelLoaderService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateModelLoaderService(boolean newGenerateModelLoaderService) {
		boolean oldGenerateModelLoaderService = generateModelLoaderService;
		generateModelLoaderService = newGenerateModelLoaderService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.BUILD_OPTIONS__GENERATE_MODEL_LOADER_SERVICE, oldGenerateModelLoaderService, generateModelLoaderService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateCodeExecutorService() {
		return generateCodeExecutorService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateCodeExecutorService(boolean newGenerateCodeExecutorService) {
		boolean oldGenerateCodeExecutorService = generateCodeExecutorService;
		generateCodeExecutorService = newGenerateCodeExecutorService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.BUILD_OPTIONS__GENERATE_CODE_EXECUTOR_SERVICE, oldGenerateCodeExecutorService, generateCodeExecutorService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerateQVTOFromECL() {
		return generateQVTOFromECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateQVTOFromECL(boolean newGenerateQVTOFromECL) {
		boolean oldGenerateQVTOFromECL = generateQVTOFromECL;
		generateQVTOFromECL = newGenerateQVTOFromECL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.BUILD_OPTIONS__GENERATE_QVTO_FROM_ECL, oldGenerateQVTOFromECL, generateQVTOFromECL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case confPackage.BUILD_OPTIONS__GENERATE_MODEL_LOADER_SERVICE:
				return isGenerateModelLoaderService();
			case confPackage.BUILD_OPTIONS__GENERATE_CODE_EXECUTOR_SERVICE:
				return isGenerateCodeExecutorService();
			case confPackage.BUILD_OPTIONS__GENERATE_QVTO_FROM_ECL:
				return isGenerateQVTOFromECL();
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
			case confPackage.BUILD_OPTIONS__GENERATE_MODEL_LOADER_SERVICE:
				setGenerateModelLoaderService((Boolean)newValue);
				return;
			case confPackage.BUILD_OPTIONS__GENERATE_CODE_EXECUTOR_SERVICE:
				setGenerateCodeExecutorService((Boolean)newValue);
				return;
			case confPackage.BUILD_OPTIONS__GENERATE_QVTO_FROM_ECL:
				setGenerateQVTOFromECL((Boolean)newValue);
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
			case confPackage.BUILD_OPTIONS__GENERATE_MODEL_LOADER_SERVICE:
				setGenerateModelLoaderService(GENERATE_MODEL_LOADER_SERVICE_EDEFAULT);
				return;
			case confPackage.BUILD_OPTIONS__GENERATE_CODE_EXECUTOR_SERVICE:
				setGenerateCodeExecutorService(GENERATE_CODE_EXECUTOR_SERVICE_EDEFAULT);
				return;
			case confPackage.BUILD_OPTIONS__GENERATE_QVTO_FROM_ECL:
				setGenerateQVTOFromECL(GENERATE_QVTO_FROM_ECL_EDEFAULT);
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
			case confPackage.BUILD_OPTIONS__GENERATE_MODEL_LOADER_SERVICE:
				return generateModelLoaderService != GENERATE_MODEL_LOADER_SERVICE_EDEFAULT;
			case confPackage.BUILD_OPTIONS__GENERATE_CODE_EXECUTOR_SERVICE:
				return generateCodeExecutorService != GENERATE_CODE_EXECUTOR_SERVICE_EDEFAULT;
			case confPackage.BUILD_OPTIONS__GENERATE_QVTO_FROM_ECL:
				return generateQVTOFromECL != GENERATE_QVTO_FROM_ECL_EDEFAULT;
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
		result.append(" (generateModelLoaderService: ");
		result.append(generateModelLoaderService);
		result.append(", generateCodeExecutorService: ");
		result.append(generateCodeExecutorService);
		result.append(", generateQVTOFromECL: ");
		result.append(generateQVTOFromECL);
		result.append(')');
		return result.toString();
	}

} //BuildOptionsImpl
