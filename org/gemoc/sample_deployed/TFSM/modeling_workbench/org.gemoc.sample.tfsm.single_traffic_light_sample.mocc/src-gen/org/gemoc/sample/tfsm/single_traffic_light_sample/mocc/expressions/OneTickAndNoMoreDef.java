package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractSemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractUpdateHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeSequence;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.AbstractRuntimeExpression;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions.FilterByDef;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.ExpressionClock;

public class OneTickAndNoMoreDef extends AbstractRuntimeExpression {

    private RuntimeClock onetickandnomoreclock;

    private RuntimeSequence<Integer> oneinfinite = new RuntimeSequence<Integer>();

    public FilterByDef onetickandnomore_onlyone;


    protected void init() {
        Integer sym17[] = { 1 };
        oneinfinite.setFinitePart(sym17);
        Integer sym18[] = { 0 };
        oneinfinite.setInfinitePart(sym18);
        onetickandnomore_onlyone = new FilterByDef((ExpressionClock)getExpressionClock(), onetickandnomoreclock, oneinfinite);
        onetickandnomore_onlyone.setName("OneTickAndNoMore_onlyOne");
        onetickandnomore_onlyone.setParent(this);
        onetickandnomore_onlyone.setParent(this);
    }

    public OneTickAndNoMoreDef(ExpressionClock implicitClock, RuntimeClock onetickandnomoreclock) {
        super(implicitClock);
        this.onetickandnomoreclock = onetickandnomoreclock;
        init();
    }

    public AbstractRuntimeExpression getRootExpression() {
        return onetickandnomore_onlyone;
    }

    @Override
    public void start(AbstractSemanticHelper helper)
                throws SimulationException {
        if (  ! canCallStart() ) {
            return;
        }
        super.start(helper);
        getRootExpression().start(helper);
    }

    @Override
    public void semantic(AbstractSemanticHelper helper)
                throws SimulationException {
        if (  ! canCallSemantic() ) {
            return;
        }
        super.semantic(helper);
        getRootExpression().semantic(helper);
    }

    @Override
    public void update(AbstractUpdateHelper helper)
                throws SimulationException {
        if (  ! canCallUpdate() ) {
            return;
        }
        super.update(helper);
        getRootExpression().update(helper);
    }

}
