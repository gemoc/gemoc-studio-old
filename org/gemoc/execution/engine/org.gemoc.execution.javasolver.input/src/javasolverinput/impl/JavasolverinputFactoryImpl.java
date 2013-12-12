/**
 */
package javasolverinput.impl;

import javasolverinput.*;

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
public class JavasolverinputFactoryImpl extends EFactoryImpl implements JavasolverinputFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavasolverinputFactory init() {
		try {
			JavasolverinputFactory theJavasolverinputFactory = (JavasolverinputFactory)EPackage.Registry.INSTANCE.getEFactory(JavasolverinputPackage.eNS_URI);
			if (theJavasolverinputFactory != null) {
				return theJavasolverinputFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavasolverinputFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavasolverinputFactoryImpl() {
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
			case JavasolverinputPackage.JAVA_SOLVER_INPUT_FILE: return createJavaSolverInputFile();
			case JavasolverinputPackage.BOOT_STRAPPED_CONSTRAINT_ARGUMENT: return createBootStrappedConstraintArgument();
			case JavasolverinputPackage.PRECEDES: return createPrecedes();
			case JavasolverinputPackage.CLOCK: return createClock();
			case JavasolverinputPackage.CUSTOM_CONSTRAINT: return createCustomConstraint();
			case JavasolverinputPackage.RELATION_DECLARATION: return createRelationDeclaration();
			case JavasolverinputPackage.PARAMETER: return createParameter();
			case JavasolverinputPackage.RELATION_DEFINITION: return createRelationDefinition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaSolverInputFile createJavaSolverInputFile() {
		JavaSolverInputFileImpl javaSolverInputFile = new JavaSolverInputFileImpl();
		return javaSolverInputFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BootStrappedConstraintArgument createBootStrappedConstraintArgument() {
		BootStrappedConstraintArgumentImpl bootStrappedConstraintArgument = new BootStrappedConstraintArgumentImpl();
		return bootStrappedConstraintArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precedes createPrecedes() {
		PrecedesImpl precedes = new PrecedesImpl();
		return precedes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clock createClock() {
		ClockImpl clock = new ClockImpl();
		return clock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomConstraint createCustomConstraint() {
		CustomConstraintImpl customConstraint = new CustomConstraintImpl();
		return customConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDeclaration createRelationDeclaration() {
		RelationDeclarationImpl relationDeclaration = new RelationDeclarationImpl();
		return relationDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDefinition createRelationDefinition() {
		RelationDefinitionImpl relationDefinition = new RelationDefinitionImpl();
		return relationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavasolverinputPackage getJavasolverinputPackage() {
		return (JavasolverinputPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavasolverinputPackage getPackage() {
		return JavasolverinputPackage.eINSTANCE;
	}

} //JavasolverinputFactoryImpl
