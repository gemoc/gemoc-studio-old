package org.gemoc.gexpressions.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.gemoc.gexpressions.GExpression;
import org.gemoc.gexpressions.GNavigationExpression;
import org.gemoc.gexpressions.GReferenceExpression;
import org.gemoc.gexpressions.util.GexpressionsSwitch;

/**
 * Replaces in the GReferenceExpression an EClass by the given EObject (if types
 * correspond) and removes the EOperationNavigationExpression term at the end of
 * the expression. Useful to partially evaluate an expression to determine on
 * which EObject the EOperation should be called.
 * 
 * Example : "MyEClass.foo.bar.do()" returns "MyEObject.foo.bar". This
 * expression can then be interpreted to get the value of the "bar" feature.
 * 
 * @author flatombe
 *
 */
public class EClassByEObjectReplacerAndEOperationRemover extends
		GexpressionsSwitch<GExpression> {
	private EObject context;

	public EClassByEObjectReplacerAndEOperationRemover(EObject context) {
		this.context = context;
	}

	@Override
	public GExpression caseGReferenceExpression(GReferenceExpression object) {
		EObject eo = object.getReferencedEObject();
		if (eo instanceof EClass) {
			EClass eClass = (EClass) eo;
			if (GExpressionsHelper
					.eClassIsSuperTypeOf(eClass, context.eClass())) {
				object.setReferencedEObject(context);
			}
		}
		return object;
	}

	@Override
	public GExpression caseGNavigationExpression(GNavigationExpression object) {
		EObject referencedEObject = object.getReferencedEObject();
		if (referencedEObject instanceof EStructuralFeature) {
			object.setBody(this.doSwitch(object.getBody()));
			return object;
		} else {
			return this.doSwitch(object.getBody());
		}
	}

	@Override
	public GExpression caseGExpression(GExpression object) {
		return object;
	}

}
