/**
 */
package gmml.impl;

import gmml.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GmmlFactoryImpl extends EFactoryImpl implements GmmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GmmlFactory init() {
		try {
			GmmlFactory theGmmlFactory = (GmmlFactory)EPackage.Registry.INSTANCE.getEFactory(GmmlPackage.eNS_URI);
			if (theGmmlFactory != null) {
				return theGmmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GmmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GmmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GmmlPackage.MODEL_SPECIFIC_EVENT_FILE: return createModelSpecificEventFile();
			case GmmlPackage.MODEL_SPECIFIC_EVENT: return createModelSpecificEvent();
			case GmmlPackage.IMPORT_STATEMENT: return createImportStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSpecificEventFile createModelSpecificEventFile() {
		ModelSpecificEventFileImpl modelSpecificEventFile = new ModelSpecificEventFileImpl();
		return modelSpecificEventFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSpecificEvent createModelSpecificEvent() {
		ModelSpecificEventImpl modelSpecificEvent = new ModelSpecificEventImpl();
		return modelSpecificEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportStatement createImportStatement() {
		ImportStatementImpl importStatement = new ImportStatementImpl();
		return importStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GmmlPackage getGmmlPackage() {
		return (GmmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GmmlPackage getPackage() {
		return GmmlPackage.eINSTANCE;
	}

} //GmmlFactoryImpl
