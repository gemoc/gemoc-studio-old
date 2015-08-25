package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractSemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeConcatenation;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.BDDHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractUpdateHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeStrictSampling;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.AbstractRuntimeExpression;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.ExpressionClock;

public class SampledOnDef extends AbstractRuntimeExpression {

    private RuntimeClock sampledonsampledclock;

    private RuntimeClock sampledontrigger;

    public RuntimeConcatenation sampledonrootconcat;

    public ExpressionClock onesampled_clock = null;

    public RuntimeStrictSampling onesampled;


    protected void init() {
        if ( onesampled_clock == null ) {
            onesampled_clock = new ExpressionClock("OneSampled");
        }
        onesampled_clock.setDense(false);
        onesampled_clock.setParent(this);
        onesampled_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        sampledonrootconcat = new RuntimeConcatenation(getExpressionClock(), onesampled_clock, getExpressionClock());
        sampledonrootconcat.setName("SampledOnrootConcat");
        sampledonrootconcat.setParent(this);
        sampledonrootconcat.setParent(this);
        onesampled = new RuntimeStrictSampling(onesampled_clock, sampledonsampledclock, sampledontrigger);
        onesampled.setName("OneSampled");
        onesampled.setParent(this);
        onesampled.setParent(this);
    }

    public SampledOnDef(ExpressionClock implicitClock, RuntimeClock sampledonsampledclock, RuntimeClock sampledontrigger) {
        super(implicitClock);
        this.sampledonsampledclock = sampledonsampledclock;
        this.sampledontrigger = sampledontrigger;
        init();
    }

    public AbstractRuntimeExpression getRootExpression() {
        return sampledonrootconcat;
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
