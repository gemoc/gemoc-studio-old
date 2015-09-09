package org.gemoc.gexpressions.utils;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.gemoc.gexpressions.GNavigationExpression;
import org.gemoc.gexpressions.GReferenceExpression;
import org.gemoc.gexpressions.util.GexpressionsSwitch;

public class GExpressionsTypeEvaluator extends GexpressionsSwitch<EClassifier> {

	@Override
	public EClassifier caseGReferenceExpression(GReferenceExpression object) {

		if (object.getReferencedEObject() instanceof EClassifier) {
			return (EClassifier) object.getReferencedEObject();
		} else {
			return object.getReferencedEObject().eClass();
		}

	}

	@Override
	public EClassifier caseGNavigationExpression(GNavigationExpression object) {
		EObject referencedEObject = object.getReferencedEObject();
		if (referencedEObject instanceof ETypedElement) {
			ETypedElement typedElement = (ETypedElement) referencedEObject;
			return typedElement.getEType();
		} else if (referencedEObject instanceof EClassifier) {
			EClassifier classifier = (EClassifier) referencedEObject;
			return classifier;
		} else {
			return referencedEObject.eClass();
		}
	}

}
