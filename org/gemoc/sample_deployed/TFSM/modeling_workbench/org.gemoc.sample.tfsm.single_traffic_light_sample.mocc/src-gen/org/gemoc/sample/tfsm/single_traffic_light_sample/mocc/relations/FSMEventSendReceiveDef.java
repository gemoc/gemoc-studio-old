package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.relations;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractSemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.AbstractRuntimeRelation;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractUpdateHelper;
import net.javabdd.BDD;
import fr.inria.aoste.timesquare.ccslkernel.runtime.ICCSLConstraint;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.RuntimePrecedes;

public class FSMEventSendReceiveDef extends AbstractRuntimeRelation {

    private RuntimeClock fsmeventrendezvous_leftclock;

    private RuntimeClock fsmeventrendezvous_rightclock;

    public RuntimePrecedes eventsendreceive;


    protected void init() {
        eventsendreceive = new RuntimePrecedes(fsmeventrendezvous_leftclock, fsmeventrendezvous_rightclock);
        eventsendreceive.setParent(this);
        eventsendreceive.setName("EventSendReceive");
        eventsendreceive.setAssertion(false);
    }

    public FSMEventSendReceiveDef(RuntimeClock fsmeventrendezvous_leftclock, RuntimeClock fsmeventrendezvous_rightclock) {
        super();
        this.fsmeventrendezvous_leftclock = fsmeventrendezvous_leftclock;
        this.fsmeventrendezvous_rightclock = fsmeventrendezvous_rightclock;
        init();
    }

    @Override
    protected ICCSLConstraint[] getConstraints() {
        ICCSLConstraint[] res = { eventsendreceive };
        return res;
    }

    @Override
    public void setAssertion(boolean assertion) {
        super.setAssertion(assertion);
        eventsendreceive.setAssertion(assertion);
    }

    @Override
    public void start(AbstractSemanticHelper helper)
                throws SimulationException {
        if ( ! canCallStart() ) {
            return;
        }
        super.start(helper);
        eventsendreceive.start(helper);
    }

    @Override
    public void semantic(AbstractSemanticHelper helper)
                throws SimulationException {
        if ( ! canCallSemantic() ) {
            return;
        }
        super.semantic(helper);
        eventsendreceive.semantic(helper);
    }

    @Override
    public void assertionSemantic(AbstractSemanticHelper helper) {
        eventsendreceive.assertionSemantic(helper);
        BDD andTerm = helper.createOne();
        BDD bddVar20 = helper.getAssertionVariable(eventsendreceive);
        andTerm = helper.createAnd(andTerm, bddVar20);
        helper.assertionSemantic(this, andTerm);
    }

    @Override
    public void update(AbstractUpdateHelper helper)
                throws SimulationException {
        if ( ! canCallUpdate() ) {
            return;
        }
        super.update(helper);
        eventsendreceive.update(helper);
    }

}
