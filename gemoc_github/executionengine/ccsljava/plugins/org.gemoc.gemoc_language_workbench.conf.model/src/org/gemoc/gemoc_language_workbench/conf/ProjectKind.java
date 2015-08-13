/**
 */
package org.gemoc.gemoc_language_workbench.conf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Project Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getProjectKind()
 * @model
 * @generated
 */
public enum ProjectKind implements Enumerator {
	/**
	 * The '<em><b>Eclipse Plugin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ECLIPSE_PLUGIN_VALUE
	 * @generated
	 * @ordered
	 */
	ECLIPSE_PLUGIN(0, "eclipsePlugin", "eclipsePlugin"),

	/**
	 * The '<em><b>Maven Jar</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAVEN_JAR_VALUE
	 * @generated
	 * @ordered
	 */
	MAVEN_JAR(1, "mavenJar", "mavenJar");

	/**
	 * The '<em><b>Eclipse Plugin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Eclipse Plugin</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ECLIPSE_PLUGIN
	 * @model name="eclipsePlugin"
	 * @generated
	 * @ordered
	 */
	public static final int ECLIPSE_PLUGIN_VALUE = 0;

	/**
	 * The '<em><b>Maven Jar</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Maven Jar</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAVEN_JAR
	 * @model name="mavenJar"
	 * @generated
	 * @ordered
	 */
	public static final int MAVEN_JAR_VALUE = 1;

	/**
	 * An array of all the '<em><b>Project Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProjectKind[] VALUES_ARRAY =
		new ProjectKind[] {
			ECLIPSE_PLUGIN,
			MAVEN_JAR,
		};

	/**
	 * A public read-only list of all the '<em><b>Project Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProjectKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Project Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProjectKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProjectKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Project Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProjectKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProjectKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Project Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProjectKind get(int value) {
		switch (value) {
			case ECLIPSE_PLUGIN_VALUE: return ECLIPSE_PLUGIN;
			case MAVEN_JAR_VALUE: return MAVEN_JAR;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ProjectKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ProjectKind
