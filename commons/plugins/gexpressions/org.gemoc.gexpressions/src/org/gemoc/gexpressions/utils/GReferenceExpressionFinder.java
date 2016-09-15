package org.gemoc.gexpressions.utils;

import java.util.Collections;
import java.util.List;

import org.gemoc.gexpressions.GBinaryOperatorExpression;
import org.gemoc.gexpressions.GNavigationExpression;
import org.gemoc.gexpressions.GPrimaryExpression;
import org.gemoc.gexpressions.GReferenceExpression;
import org.gemoc.gexpressions.GUnaryOperatorExpression;
import org.gemoc.gexpressions.util.GexpressionsSwitch;

/**
 * Collects the GReferenceExpression which are leaves of a more complex
 * expression. Places them in the correct order, e.g. Expression (A.b() or
 * C.d()) will return [A, C]
 * 
 * @author flatombe
 *
 */
public class GReferenceExpressionFinder extends
		GexpressionsSwitch<List<GReferenceExpression>> {

	@Override
	public List<GReferenceExpression> caseGPrimaryExpression(
			GPrimaryExpression object) {
		return Collections.emptyList();
	}

	@Override
	public List<GReferenceExpression> caseGUnaryOperatorExpression(
			GUnaryOperatorExpression object) {
		return this.doSwitch(object.getOperand());
	}

	@Override
	public List<GReferenceExpression> caseGBinaryOperatorExpression(
			GBinaryOperatorExpression object) {
		List<GReferenceExpression> res = this.doSwitch(object.getLeftOperand());
		res.addAll(this.doSwitch(object.getRightOperand()));
		return res;
	}

	@Override
	public List<GReferenceExpression> caseGNavigationExpression(
			GNavigationExpression object) {
		return this.doSwitch(object.getBody());
	}

	@Override
	public List<GReferenceExpression> caseGReferenceExpression(
			GReferenceExpression object) {
		return Collections.singletonList(object);
	}

}
