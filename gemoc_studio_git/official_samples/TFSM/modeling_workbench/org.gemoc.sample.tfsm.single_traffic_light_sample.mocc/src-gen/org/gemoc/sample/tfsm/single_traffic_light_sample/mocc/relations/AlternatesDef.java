package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.relations;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractSemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.AbstractRuntimeRelation;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.BDDHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractUpdateHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeSequence;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeDefer;
import net.javabdd.BDD;
import fr.inria.aoste.timesquare.ccslkernel.runtime.ICCSLConstraint;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.RuntimePrecedes;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.ExpressionClock;

public class AlternatesDef extends AbstractRuntimeRelation {

    private RuntimeClock alternatesleftclock;

    private RuntimeClock alternatesrightclock;

    public RuntimePrecedes alt_c1precedesc2;

    private RuntimeSequence<Integer> seqoneinfinite = new RuntimeSequence<Integer>();

    public ExpressionClock alt_c1delayedbyone_clock = null;

    public RuntimeDefer alt_c1delayedbyone;

    public RuntimePrecedes alt_c2precedesc1delayedbyone;


    protected void init() {
        alt_c1precedesc2 = new RuntimePrecedes(alternatesleftclock, alternatesrightclock);
        alt_c1precedesc2.setParent(this);
        alt_c1precedesc2.setName("Alt_c1PrecedesC2");
        alt_c1precedesc2.setAssertion(false);
        Integer sym21[] = { 1 };
        seqoneinfinite.setInfinitePart(sym21);
        if ( alt_c1delayedbyone_clock == null ) {
            alt_c1delayedbyone_clock = new ExpressionClock("Alt_c1DelayedByOne");
        }
        alt_c1delayedbyone_clock.setDense(false);
        alt_c1delayedbyone_clock.setParent(this);
        alt_c1delayedbyone_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        alt_c1delayedbyone = new RuntimeDefer(alt_c1delayedbyone_clock, alternatesleftclock, alternatesleftclock, seqoneinfinite);
        alt_c1delayedbyone.setName("Alt_c1DelayedByOne");
        alt_c1delayedbyone.setParent(this);
        alt_c2precedesc1delayedbyone = new RuntimePrecedes(alternatesrightclock, alt_c1delayedbyone_clock);
        alt_c2precedesc1delayedbyone.setParent(this);
        alt_c2precedesc1delayedbyone.setName("Alt_c2precedesC1DelayedByOne");
        alt_c2precedesc1delayedbyone.setAssertion(false);
    }

    public AlternatesDef(RuntimeClock alternatesleftclock, RuntimeClock alternatesrightclock) {
        super();
        this.alternatesleftclock = alternatesleftclock;
        this.alternatesrightclock = alternatesrightclock;
        init();
    }

    @Override
    protected ICCSLConstraint[] getConstraints() {
        ICCSLConstraint[] res = { alt_c1precedesc2, alt_c1delayedbyone, alt_c2precedesc1delayedbyone };
        return res;
    }

    @Override
    public void setAssertion(boolean assertion) {
        super.setAssertion(assertion);
        alt_c1precedesc2.setAssertion(assertion);
        alt_c2precedesc1delayedbyone.setAssertion(assertion);
    }

    @Override
    public void start(AbstractSemanticHelper helper)
                throws SimulationException {
        if ( ! canCallStart() ) {
            return;
        }
        super.start(helper);
        alt_c1precedesc2.start(helper);
        alt_c2precedesc1delayedbyone.start(helper);
        alt_c1delayedbyone.start(helper);
    }

    @Override
    public void semantic(AbstractSemanticHelper helper)
                throws SimulationException {
        if ( ! canCallSemantic() ) {
            return;
        }
        super.semantic(helper);
        alt_c1precedesc2.semantic(helper);
        alt_c2precedesc1delayedbyone.semantic(helper);
        alt_c1delayedbyone.semantic(helper);
    }

    @Override
    public void assertionSemantic(AbstractSemanticHelper helper) {
        alt_c1precedesc2.assertionSemantic(helper);
        alt_c2precedesc1delayedbyone.assertionSemantic(helper);
        BDD andTerm = helper.createOne();
        BDD bddVar22 = helper.getAssertionVariable(alt_c1precedesc2);
        andTerm = helper.createAnd(andTerm, bddVar22);
        BDD bddVar23 = helper.getAssertionVariable(alt_c2precedesc1delayedbyone);
        andTerm = helper.createAnd(andTerm, bddVar23);
        helper.assertionSemantic(this, andTerm);
    }

    @Override
    public void update(AbstractUpdateHelper helper)
                throws SimulationException {
        if ( ! canCallUpdate() ) {
            return;
        }
        super.update(helper);
        alt_c1precedesc2.update(helper);
        alt_c2precedesc1delayedbyone.update(helper);
        alt_c1delayedbyone.update(helper);
    }

}
