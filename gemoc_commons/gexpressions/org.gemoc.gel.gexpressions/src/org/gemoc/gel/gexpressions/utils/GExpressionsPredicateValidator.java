package org.gemoc.gel.gexpressions.utils;

import org.gemoc.gel.gexpressions.GBooleanExpression;
import org.gemoc.gel.gexpressions.GBooleanOperatorExpression;
import org.gemoc.gel.gexpressions.GEqualityExpression;
import org.gemoc.gel.gexpressions.GExpression;
import org.gemoc.gel.gexpressions.GNegationExpression;
import org.gemoc.gel.gexpressions.GRelationExpression;
import org.gemoc.gel.gexpressions.util.GexpressionsSwitch;

/**
 * Returns whether or not the GExpression is a predicate (returns a boolean).
 * Not meant to be super detailed, this is just for some very basic validation.
 * Should be extended and the case for GReferenceExpression should be customized
 * to one's needs.
 * 
 * @author flatombe
 *
 */
public class GExpressionsPredicateValidator extends GexpressionsSwitch<Boolean> {

	@Override
	public Boolean caseGBooleanExpression(GBooleanExpression object) {
		return true;
	}

	@Override
	public Boolean caseGBooleanOperatorExpression(
			GBooleanOperatorExpression object) {
		return true;
	}

	@Override
	public Boolean caseGNegationExpression(GNegationExpression object) {
		return true;
	}

	@Override
	public Boolean caseGRelationExpression(GRelationExpression object) {
		return true;
	}

	@Override
	public Boolean caseGEqualityExpression(GEqualityExpression object) {
		return true;
	}

	@Override
	public Boolean caseGExpression(GExpression object) {
		return false;
	}
}
