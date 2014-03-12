/**
 */
package gepl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gepl.GeplFactory
 * @model kind="package"
 * @generated
 */
public interface GeplPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gepl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.gemoc.org/patterns_language/gepl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gemoc.patterns_language.gepl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeplPackage eINSTANCE = gepl.impl.GeplPackageImpl.init();

	/**
	 * The meta object id for the '{@link gepl.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.PatternImpl
	 * @see gepl.impl.GeplPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 0;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gepl.impl.EveryImpl <em>Every</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.EveryImpl
	 * @see gepl.impl.GeplPackageImpl#getEvery()
	 * @generated
	 */
	int EVERY = 1;

	/**
	 * The feature id for the '<em><b>Atom</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERY__ATOM = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Every</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERY_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Every</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERY_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gepl.impl.MocEventImpl <em>Moc Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.MocEventImpl
	 * @see gepl.impl.GeplPackageImpl#getMocEvent()
	 * @generated
	 */
	int MOC_EVENT = 2;

	/**
	 * The number of structural features of the '<em>Moc Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_EVENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Moc Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gepl.impl.ECLEventImpl <em>ECL Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.ECLEventImpl
	 * @see gepl.impl.GeplPackageImpl#getECLEvent()
	 * @generated
	 */
	int ECL_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EVENT__ELEMENT = MOC_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ECL Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EVENT_FEATURE_COUNT = MOC_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ECL Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EVENT_OPERATION_COUNT = MOC_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gepl.impl.AtomImpl <em>Atom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.AtomImpl
	 * @see gepl.impl.GeplPackageImpl#getAtom()
	 * @generated
	 */
	int ATOM = 4;

	/**
	 * The number of structural features of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Atom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gepl.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.ReferenceImpl
	 * @see gepl.impl.GeplPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__EVENT = ATOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = ATOM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gepl.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gepl.impl.AndImpl
	 * @see gepl.impl.GeplPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 6;

	/**
	 * The feature id for the '<em><b>First Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__FIRST_PARAMETER = ATOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__SECOND_PARAMETER = ATOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = ATOM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = ATOM_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link gepl.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see gepl.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for class '{@link gepl.Every <em>Every</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Every</em>'.
	 * @see gepl.Every
	 * @generated
	 */
	EClass getEvery();

	/**
	 * Returns the meta object for the containment reference '{@link gepl.Every#getAtom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Atom</em>'.
	 * @see gepl.Every#getAtom()
	 * @see #getEvery()
	 * @generated
	 */
	EReference getEvery_Atom();

	/**
	 * Returns the meta object for class '{@link gepl.MocEvent <em>Moc Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moc Event</em>'.
	 * @see gepl.MocEvent
	 * @generated
	 */
	EClass getMocEvent();

	/**
	 * Returns the meta object for class '{@link gepl.ECLEvent <em>ECL Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECL Event</em>'.
	 * @see gepl.ECLEvent
	 * @generated
	 */
	EClass getECLEvent();

	/**
	 * Returns the meta object for the reference '{@link gepl.ECLEvent#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see gepl.ECLEvent#getElement()
	 * @see #getECLEvent()
	 * @generated
	 */
	EReference getECLEvent_Element();

	/**
	 * Returns the meta object for class '{@link gepl.Atom <em>Atom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atom</em>'.
	 * @see gepl.Atom
	 * @generated
	 */
	EClass getAtom();

	/**
	 * Returns the meta object for class '{@link gepl.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see gepl.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the containment reference '{@link gepl.Reference#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event</em>'.
	 * @see gepl.Reference#getEvent()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Event();

	/**
	 * Returns the meta object for class '{@link gepl.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see gepl.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for the containment reference '{@link gepl.And#getFirstParameter <em>First Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Parameter</em>'.
	 * @see gepl.And#getFirstParameter()
	 * @see #getAnd()
	 * @generated
	 */
	EReference getAnd_FirstParameter();

	/**
	 * Returns the meta object for the containment reference '{@link gepl.And#getSecondParameter <em>Second Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Parameter</em>'.
	 * @see gepl.And#getSecondParameter()
	 * @see #getAnd()
	 * @generated
	 */
	EReference getAnd_SecondParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeplFactory getGeplFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link gepl.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.PatternImpl
		 * @see gepl.impl.GeplPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '{@link gepl.impl.EveryImpl <em>Every</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.EveryImpl
		 * @see gepl.impl.GeplPackageImpl#getEvery()
		 * @generated
		 */
		EClass EVERY = eINSTANCE.getEvery();

		/**
		 * The meta object literal for the '<em><b>Atom</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVERY__ATOM = eINSTANCE.getEvery_Atom();

		/**
		 * The meta object literal for the '{@link gepl.impl.MocEventImpl <em>Moc Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.MocEventImpl
		 * @see gepl.impl.GeplPackageImpl#getMocEvent()
		 * @generated
		 */
		EClass MOC_EVENT = eINSTANCE.getMocEvent();

		/**
		 * The meta object literal for the '{@link gepl.impl.ECLEventImpl <em>ECL Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.ECLEventImpl
		 * @see gepl.impl.GeplPackageImpl#getECLEvent()
		 * @generated
		 */
		EClass ECL_EVENT = eINSTANCE.getECLEvent();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_EVENT__ELEMENT = eINSTANCE.getECLEvent_Element();

		/**
		 * The meta object literal for the '{@link gepl.impl.AtomImpl <em>Atom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.AtomImpl
		 * @see gepl.impl.GeplPackageImpl#getAtom()
		 * @generated
		 */
		EClass ATOM = eINSTANCE.getAtom();

		/**
		 * The meta object literal for the '{@link gepl.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.ReferenceImpl
		 * @see gepl.impl.GeplPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__EVENT = eINSTANCE.getReference_Event();

		/**
		 * The meta object literal for the '{@link gepl.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gepl.impl.AndImpl
		 * @see gepl.impl.GeplPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '<em><b>First Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND__FIRST_PARAMETER = eINSTANCE.getAnd_FirstParameter();

		/**
		 * The meta object literal for the '<em><b>Second Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND__SECOND_PARAMETER = eINSTANCE.getAnd_SecondParameter();

	}

} //GeplPackage
