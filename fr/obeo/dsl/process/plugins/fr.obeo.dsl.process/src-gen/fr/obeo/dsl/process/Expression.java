/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Expression</b></em>'. <!--
 * end-user-doc --> <!-- begin-model-doc --> A boolean expression that can be {@link Expression#check()
 * checked}. <!-- end-model-doc -->
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getExpression()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Expression extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Checks this {@link Expression}.
	 * <!-- end-model-doc -->
	 * 
	 * @model required="true" contextRequired="true"
	 * @generated
	 */
	boolean check(ProcessContext context);

} // Expression
