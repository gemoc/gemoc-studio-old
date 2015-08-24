package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractSemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractUpdateHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeSequence;
import fr.inria.aoste.timesquare.ccslkernel.runtime.ValueProvider;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeDefer;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.AbstractRuntimeExpression;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.ExpressionClock;

public class DelayForDef extends AbstractRuntimeExpression {

    private RuntimeClock delayforclocktodelay;

    private RuntimeClock delayforclockforcounting;

    private Integer delayfordelay;

    private ValueProvider<Integer> delayForDelayProvider;

    private RuntimeSequence<Integer> seqfordelayfor = new RuntimeSequence<Integer>();

    public RuntimeDefer delayfor_defer;


    protected void init() {
        Integer sym19[] = { delayfordelay };
        seqfordelayfor.setInfinitePart(sym19);
        delayfor_defer = new RuntimeDefer(getExpressionClock(), delayforclocktodelay, delayforclockforcounting, seqfordelayfor);
        delayfor_defer.setName("DelayFor_defer");
        delayfor_defer.setParent(this);
        delayfor_defer.setParent(this);
    }

    public DelayForDef(ExpressionClock implicitClock, RuntimeClock delayforclocktodelay, RuntimeClock delayforclockforcounting, Integer delayfordelay) {
        super(implicitClock);
        this.delayforclocktodelay = delayforclocktodelay;
        this.delayforclockforcounting = delayforclockforcounting;
        this.delayfordelay = delayfordelay;
        init();
    }

    public DelayForDef(ExpressionClock implicitClock, RuntimeClock delayforclocktodelay, RuntimeClock delayforclockforcounting, ValueProvider<Integer> delayfordelay) {
        super(implicitClock);
        this.delayforclocktodelay = delayforclocktodelay;
        this.delayforclockforcounting = delayforclockforcounting;
        this.delayForDelayProvider = delayfordelay;
        init();
    }

    public AbstractRuntimeExpression getRootExpression() {
        return delayfor_defer;
    }

    @Override
    public void start(AbstractSemanticHelper helper)
                throws SimulationException {
        if (  ! canCallStart() ) {
            return;
        }
        super.start(helper);
        if ( delayForDelayProvider != null ) {
            delayfordelay = delayForDelayProvider.getValue();
        }
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
