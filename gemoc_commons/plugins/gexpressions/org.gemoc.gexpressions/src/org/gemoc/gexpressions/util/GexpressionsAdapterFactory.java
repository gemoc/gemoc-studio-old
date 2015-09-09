/**
 */
package org.gemoc.gexpressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.gexpressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.gexpressions.GexpressionsPackage
 * @generated
 */
public class GexpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GexpressionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GexpressionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GexpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GexpressionsSwitch<Adapter> modelSwitch =
		new GexpressionsSwitch<Adapter>() {
			@Override
			public Adapter caseGProgram(GProgram object) {
				return createGProgramAdapter();
			}
			@Override
			public Adapter caseGImportStatement(GImportStatement object) {
				return createGImportStatementAdapter();
			}
			@Override
			public Adapter caseGExpression(GExpression object) {
				return createGExpressionAdapter();
			}
			@Override
			public Adapter caseGNavigationExpression(GNavigationExpression object) {
				return createGNavigationExpressionAdapter();
			}
			@Override
			public Adapter caseGReferenceExpression(GReferenceExpression object) {
				return createGReferenceExpressionAdapter();
			}
			@Override
			public Adapter caseGPrimaryExpression(GPrimaryExpression object) {
				return createGPrimaryExpressionAdapter();
			}
			@Override
			public Adapter caseGStringExpression(GStringExpression object) {
				return createGStringExpressionAdapter();
			}
			@Override
			public Adapter caseGBooleanExpression(GBooleanExpression object) {
				return createGBooleanExpressionAdapter();
			}
			@Override
			public Adapter caseGNumericExpression(GNumericExpression object) {
				return createGNumericExpressionAdapter();
			}
			@Override
			public Adapter caseGIntegerExpression(GIntegerExpression object) {
				return createGIntegerExpressionAdapter();
			}
			@Override
			public Adapter caseGDoubleExpression(GDoubleExpression object) {
				return createGDoubleExpressionAdapter();
			}
			@Override
			public Adapter caseGIfExpression(GIfExpression object) {
				return createGIfExpressionAdapter();
			}
			@Override
			public Adapter caseGBraceExpression(GBraceExpression object) {
				return createGBraceExpressionAdapter();
			}
			@Override
			public Adapter caseGEnumLiteralExpression(GEnumLiteralExpression object) {
				return createGEnumLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseGBinaryOperatorExpression(GBinaryOperatorExpression object) {
				return createGBinaryOperatorExpressionAdapter();
			}
			@Override
			public Adapter caseGUnaryOperatorExpression(GUnaryOperatorExpression object) {
				return createGUnaryOperatorExpressionAdapter();
			}
			@Override
			public Adapter caseGBooleanOperatorExpression(GBooleanOperatorExpression object) {
				return createGBooleanOperatorExpressionAdapter();
			}
			@Override
			public Adapter caseGAndExpression(GAndExpression object) {
				return createGAndExpressionAdapter();
			}
			@Override
			public Adapter caseGXorExpression(GXorExpression object) {
				return createGXorExpressionAdapter();
			}
			@Override
			public Adapter caseGOrExpression(GOrExpression object) {
				return createGOrExpressionAdapter();
			}
			@Override
			public Adapter caseGEqualityExpression(GEqualityExpression object) {
				return createGEqualityExpressionAdapter();
			}
			@Override
			public Adapter caseGRelationExpression(GRelationExpression object) {
				return createGRelationExpressionAdapter();
			}
			@Override
			public Adapter caseGAdditionExpression(GAdditionExpression object) {
				return createGAdditionExpressionAdapter();
			}
			@Override
			public Adapter caseGMultiplicationExpression(GMultiplicationExpression object) {
				return createGMultiplicationExpressionAdapter();
			}
			@Override
			public Adapter caseGNegationExpression(GNegationExpression object) {
				return createGNegationExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GProgram <em>GProgram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GProgram
	 * @generated
	 */
	public Adapter createGProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GImportStatement <em>GImport Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GImportStatement
	 * @generated
	 */
	public Adapter createGImportStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GExpression <em>GExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GExpression
	 * @generated
	 */
	public Adapter createGExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GNavigationExpression <em>GNavigation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GNavigationExpression
	 * @generated
	 */
	public Adapter createGNavigationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GReferenceExpression <em>GReference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GReferenceExpression
	 * @generated
	 */
	public Adapter createGReferenceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GPrimaryExpression <em>GPrimary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GPrimaryExpression
	 * @generated
	 */
	public Adapter createGPrimaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GStringExpression <em>GString Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GStringExpression
	 * @generated
	 */
	public Adapter createGStringExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GBooleanExpression <em>GBoolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GBooleanExpression
	 * @generated
	 */
	public Adapter createGBooleanExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GNumericExpression <em>GNumeric Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GNumericExpression
	 * @generated
	 */
	public Adapter createGNumericExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GIntegerExpression <em>GInteger Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GIntegerExpression
	 * @generated
	 */
	public Adapter createGIntegerExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GDoubleExpression <em>GDouble Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GDoubleExpression
	 * @generated
	 */
	public Adapter createGDoubleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GIfExpression <em>GIf Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GIfExpression
	 * @generated
	 */
	public Adapter createGIfExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GBraceExpression <em>GBrace Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GBraceExpression
	 * @generated
	 */
	public Adapter createGBraceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GEnumLiteralExpression <em>GEnum Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GEnumLiteralExpression
	 * @generated
	 */
	public Adapter createGEnumLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GBinaryOperatorExpression <em>GBinary Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GBinaryOperatorExpression
	 * @generated
	 */
	public Adapter createGBinaryOperatorExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GUnaryOperatorExpression <em>GUnary Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GUnaryOperatorExpression
	 * @generated
	 */
	public Adapter createGUnaryOperatorExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GBooleanOperatorExpression <em>GBoolean Operator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GBooleanOperatorExpression
	 * @generated
	 */
	public Adapter createGBooleanOperatorExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GAndExpression <em>GAnd Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GAndExpression
	 * @generated
	 */
	public Adapter createGAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GXorExpression <em>GXor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GXorExpression
	 * @generated
	 */
	public Adapter createGXorExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GOrExpression <em>GOr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GOrExpression
	 * @generated
	 */
	public Adapter createGOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GEqualityExpression <em>GEquality Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GEqualityExpression
	 * @generated
	 */
	public Adapter createGEqualityExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GRelationExpression <em>GRelation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GRelationExpression
	 * @generated
	 */
	public Adapter createGRelationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GAdditionExpression <em>GAddition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GAdditionExpression
	 * @generated
	 */
	public Adapter createGAdditionExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GMultiplicationExpression <em>GMultiplication Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GMultiplicationExpression
	 * @generated
	 */
	public Adapter createGMultiplicationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gexpressions.GNegationExpression <em>GNegation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gexpressions.GNegationExpression
	 * @generated
	 */
	public Adapter createGNegationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GexpressionsAdapterFactory
