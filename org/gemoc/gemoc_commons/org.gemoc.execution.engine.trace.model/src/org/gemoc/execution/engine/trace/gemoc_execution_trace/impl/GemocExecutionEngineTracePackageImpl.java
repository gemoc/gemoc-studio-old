/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import fr.inria.aoste.trace.TracePackage;
import fr.inria.aoste.trace.impl.TracePackageImpl;
import java.io.IOException;
import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GemocExecutionEngineTracePackageImpl extends EPackageImpl implements GemocExecutionEngineTracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "gemoc_execution_trace.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionTraceModelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GemocExecutionEngineTracePackageImpl() {
		super(eNS_URI, GemocExecutionEngineTraceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GemocExecutionEngineTracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static GemocExecutionEngineTracePackage init() {
		if (isInited) return (GemocExecutionEngineTracePackage)EPackage.Registry.INSTANCE.getEPackage(GemocExecutionEngineTracePackage.eNS_URI);

		// Obtain or create and register package
		GemocExecutionEngineTracePackageImpl theGemocExecutionEngineTracePackage = (GemocExecutionEngineTracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GemocExecutionEngineTracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GemocExecutionEngineTracePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TracePackageImpl theTracePackage = (TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) instanceof TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) : TracePackage.eINSTANCE);

		// Load packages
		theGemocExecutionEngineTracePackage.loadPackage();

		// Create package meta-data objects
		theTracePackage.createPackageContents();

		// Initialize created meta-data
		theTracePackage.initializePackageContents();

		// Fix loaded packages
		theGemocExecutionEngineTracePackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theGemocExecutionEngineTracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GemocExecutionEngineTracePackage.eNS_URI, theGemocExecutionEngineTracePackage);
		return theGemocExecutionEngineTracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		if (choiceEClass == null) {
			choiceEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(GemocExecutionEngineTracePackage.eNS_URI).getEClassifiers().get(0);
		}
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_NextChoice() {
        return (EReference)getChoice().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_PossibleLogicalSteps() {
        return (EReference)getChoice().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_ChosenLogicalStep() {
        return (EReference)getChoice().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionTraceModel() {
		if (executionTraceModelEClass == null) {
			executionTraceModelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(GemocExecutionEngineTracePackage.eNS_URI).getEClassifiers().get(1);
		}
		return executionTraceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTraceModel_Choices() {
        return (EReference)getExecutionTraceModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GemocExecutionEngineTraceFactory getGemocExecutionEngineTraceFactory() {
		return (GemocExecutionEngineTraceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.gemoc.execution.engine.trace.gemoc_execution_trace." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //GemocExecutionEngineTracePackageImpl
