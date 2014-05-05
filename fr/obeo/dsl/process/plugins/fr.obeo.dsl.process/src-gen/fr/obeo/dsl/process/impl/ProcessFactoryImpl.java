/**
 */
package fr.obeo.dsl.process.impl;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.AllDone;
import fr.obeo.dsl.process.And;
import fr.obeo.dsl.process.AnyDone;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Not;
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.Or;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessFactory;
import fr.obeo.dsl.process.ProcessPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ProcessFactoryImpl extends EFactoryImpl implements ProcessFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ProcessFactory init() {
		try {
			ProcessFactory theProcessFactory = (ProcessFactory)EPackage.Registry.INSTANCE
					.getEFactory("http://www.obeo.fr/dsl/process");
			if (theProcessFactory != null) {
				return theProcessFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProcessFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProcessPackage.PROCESS:
				return createProcess();
			case ProcessPackage.COMPOSED_TASK:
				return createComposedTask();
			case ProcessPackage.ACTION_TASK:
				return createActionTask();
			case ProcessPackage.ALL_DONE:
				return createAllDone();
			case ProcessPackage.ANY_DONE:
				return createAnyDone();
			case ProcessPackage.ONE_DONE:
				return createOneDone();
			case ProcessPackage.NOT:
				return createNot();
			case ProcessPackage.AND:
				return createAnd();
			case ProcessPackage.OR:
				return createOr();
			case ProcessPackage.PROCESS_CONTEXT:
				return createProcessContext();
			case ProcessPackage.TASK_TO_ARTIFACT_MAP:
				return (EObject)createTaskToArtifactMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fr.obeo.dsl.process.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposedTask createComposedTask() {
		ComposedTaskImpl composedTask = new ComposedTaskImpl();
		return composedTask;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActionTask createActionTask() {
		ActionTaskImpl actionTask = new ActionTaskImpl();
		return actionTask;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AllDone createAllDone() {
		AllDoneImpl allDone = new AllDoneImpl();
		return allDone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnyDone createAnyDone() {
		AnyDoneImpl anyDone = new AnyDoneImpl();
		return anyDone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OneDone createOneDone() {
		OneDoneImpl oneDone = new OneDoneImpl();
		return oneDone;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessContext createProcessContext() {
		ProcessContextImpl processContext = new ProcessContextImpl();
		return processContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Map.Entry<ActionTask, Object> createTaskToArtifactMap() {
		TaskToArtifactMapImpl taskToArtifactMap = new TaskToArtifactMapImpl();
		return taskToArtifactMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessPackage getProcessPackage() {
		return (ProcessPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProcessPackage getPackage() {
		return ProcessPackage.eINSTANCE;
	}

} // ProcessFactoryImpl
