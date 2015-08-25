package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.TrafficControl.blocks;

import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.RuntimeExclusion;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.relations.FSMEventSendReceiveDef;
import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeBlock;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions.DelayForDef;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions.SampledOnDef;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.BDDHelper;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.relations.AlternatesDef;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions.OneTickAndNoMoreDef;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeUnion;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.RuntimeCoincides;
import fr.inria.aoste.timesquare.ccslkernel.runtime.IRuntimeContainer;
import fr.inria.aoste.timesquare.ccslkernel.runtime.relations.RuntimeNonStrictPrecedes;
import fr.inria.aoste.timesquare.ccslkernel.runtime.ICCSLConstraint;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.ExpressionClock;

public class MainBlockBlock extends AbstractRuntimeBlock {

    private RuntimeClock minutes_ticks = null;

    private RuntimeClock initsemaphore_to_red_fire = null;

    private RuntimeClock red_to_green_fire = null;

    private RuntimeClock green_to_red_fire = null;

    private RuntimeClock switch_occurs = null;

    private RuntimeClock initsemaphore_entering = null;

    private RuntimeClock green_entering = null;

    private RuntimeClock red_entering = null;

    private RuntimeClock initsemaphore_leaving = null;

    private RuntimeClock green_leaving = null;

    private RuntimeClock red_leaving = null;

    private RuntimeClock semaphore_start = null;

    private RuntimeClock semaphore_stall = null;

    public Integer initsemaphore_to_redguard_initsemaphore_to_red_afterduration = 1;

    public Integer red_to_greenguard_red_to_green_afterduration = 3;

    public ExpressionClock switchintermediate_alltriggeringoccurrences1_clock = null;

    public RuntimeUnion switchintermediate_alltriggeringoccurrences1;

    public ExpressionClock green_to_red_sampledon_eventoccursafterorwhilestateentering_clock = null;

    public SampledOnDef green_to_red_sampledon_eventoccursafterorwhilestateentering;

    public ExpressionClock initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock = null;

    public DelayForDef initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering;

    public ExpressionClock red_to_green_delayfor_delayisexpired_wrt_stateentering_clock = null;

    public DelayForDef red_to_green_delayfor_delayisexpired_wrt_stateentering;

    public ExpressionClock initsemaphoreintermediate_allfiredoutgoingtransition1_clock = null;

    public RuntimeUnion initsemaphoreintermediate_allfiredoutgoingtransition1;

    public ExpressionClock greenintermediate_allfiredoutgoingtransition1_clock = null;

    public RuntimeUnion greenintermediate_allfiredoutgoingtransition1;

    public ExpressionClock redintermediate_allfiredoutgoingtransition1_clock = null;

    public RuntimeUnion redintermediate_allfiredoutgoingtransition1;

    public ExpressionClock greenintermediate_allinputtransition1_clock = null;

    public RuntimeUnion greenintermediate_allinputtransition1;

    public ExpressionClock redintermediate_allinputtransition1_clock = null;

    public RuntimeUnion redintermediate_allinputtransition1;

    public ExpressionClock semaphoreintermediate_onlyonefirst1_clock = null;

    public OneTickAndNoMoreDef semaphoreintermediate_onlyonefirst1;

    public FSMEventSendReceiveDef switchfsmeventsendreceive_occurswhensolicitate;

    public RuntimeCoincides green_to_redcoincides_firewheneventoccursonetransition;

    public RuntimeCoincides initsemaphore_to_redcoincides_firewhentemporalguardholdsonetransition;

    public RuntimeCoincides red_to_greencoincides_firewhentemporalguardholdsonetransition;

    public AlternatesDef initsemaphorealternates_enteroncebeforetoleave;

    public AlternatesDef greenalternates_enteroncebeforetoleave;

    public AlternatesDef redalternates_enteroncebeforetoleave;

    public RuntimeCoincides initsemaphorecoincides_firingatransitionalternateswithleavingstate;

    public RuntimeCoincides greencoincides_firingatransitionalternateswithleavingstate;

    public RuntimeCoincides redcoincides_firingatransitionalternateswithleavingstate;

    public RuntimeNonStrictPrecedes greencauses_stateentering;

    public RuntimeNonStrictPrecedes redcauses_stateentering;

    public RuntimeExclusion semaphoreintermediate_onestateatatime1_2;

    public RuntimeExclusion semaphoreintermediate_onestateatatime1_3;

    public RuntimeExclusion semaphoreintermediate_onestateatatime2_3;

    public RuntimeExclusion semaphoreintermediate_onetransitionatatime1_2;

    public RuntimeExclusion semaphoreintermediate_onetransitionatatime1_3;

    public RuntimeExclusion semaphoreintermediate_onetransitionatatime2_3;

    public RuntimeCoincides semaphorecoincides_firstisinitialstate;

    public RuntimeCoincides semaphorecoincides_firstonlyonce;


    public MainBlockBlock(IRuntimeContainer parent, String name) {
        super(parent, name);
        init();
    }

    protected void init() {
        if ( minutes_ticks == null ) {
            minutes_ticks = new RuntimeClock("minutes_ticks");
        }
        minutes_ticks.setDense(false);
        minutes_ticks.setParent(this);
        minutes_ticks.linkedElements.add("TrafficControl::minutes");
        minutes_ticks.linkedElements.add("tfsm::FSMClock::ticks");
        minutes_ticks.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( initsemaphore_to_red_fire == null ) {
            initsemaphore_to_red_fire = new RuntimeClock("initSemaphore_to_Red_fire");
        }
        initsemaphore_to_red_fire.setDense(false);
        initsemaphore_to_red_fire.setParent(this);
        initsemaphore_to_red_fire.linkedElements.add("TrafficControl::Semaphore::initSemaphore_to_Red");
        initsemaphore_to_red_fire.linkedElements.add("tfsm::Transition::fire");
        initsemaphore_to_red_fire.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( red_to_green_fire == null ) {
            red_to_green_fire = new RuntimeClock("Red_to_Green_fire");
        }
        red_to_green_fire.setDense(false);
        red_to_green_fire.setParent(this);
        red_to_green_fire.linkedElements.add("TrafficControl::Semaphore::Red_to_Green");
        red_to_green_fire.linkedElements.add("tfsm::Transition::fire");
        red_to_green_fire.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( green_to_red_fire == null ) {
            green_to_red_fire = new RuntimeClock("Green_to_Red_fire");
        }
        green_to_red_fire.setDense(false);
        green_to_red_fire.setParent(this);
        green_to_red_fire.linkedElements.add("TrafficControl::Semaphore::Green_to_Red");
        green_to_red_fire.linkedElements.add("tfsm::Transition::fire");
        green_to_red_fire.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( switch_occurs == null ) {
            switch_occurs = new RuntimeClock("switch_occurs");
        }
        switch_occurs.setDense(false);
        switch_occurs.setParent(this);
        switch_occurs.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( initsemaphore_entering == null ) {
            initsemaphore_entering = new RuntimeClock("initSemaphore_entering");
        }
        initsemaphore_entering.setDense(false);
        initsemaphore_entering.setParent(this);
        initsemaphore_entering.linkedElements.add("TrafficControl::Semaphore::initSemaphore");
        initsemaphore_entering.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( green_entering == null ) {
            green_entering = new RuntimeClock("Green_entering");
        }
        green_entering.setDense(false);
        green_entering.setParent(this);
        green_entering.linkedElements.add("TrafficControl::Semaphore::Green");
        green_entering.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( red_entering == null ) {
            red_entering = new RuntimeClock("Red_entering");
        }
        red_entering.setDense(false);
        red_entering.setParent(this);
        red_entering.linkedElements.add("TrafficControl::Semaphore::Red");
        red_entering.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( initsemaphore_leaving == null ) {
            initsemaphore_leaving = new RuntimeClock("initSemaphore_leaving");
        }
        initsemaphore_leaving.setDense(false);
        initsemaphore_leaving.setParent(this);
        initsemaphore_leaving.linkedElements.add("TrafficControl::Semaphore::initSemaphore");
        initsemaphore_leaving.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( green_leaving == null ) {
            green_leaving = new RuntimeClock("Green_leaving");
        }
        green_leaving.setDense(false);
        green_leaving.setParent(this);
        green_leaving.linkedElements.add("TrafficControl::Semaphore::Green");
        green_leaving.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( red_leaving == null ) {
            red_leaving = new RuntimeClock("Red_leaving");
        }
        red_leaving.setDense(false);
        red_leaving.setParent(this);
        red_leaving.linkedElements.add("TrafficControl::Semaphore::Red");
        red_leaving.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( semaphore_start == null ) {
            semaphore_start = new RuntimeClock("Semaphore_start");
        }
        semaphore_start.setDense(false);
        semaphore_start.setParent(this);
        semaphore_start.bddVariableNumber = initsemaphore_entering.bddVariableNumber;
        if ( semaphore_stall == null ) {
            semaphore_stall = new RuntimeClock("Semaphore_stall");
        }
        semaphore_stall.setDense(false);
        semaphore_stall.setParent(this);
        semaphore_stall.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        if ( switchintermediate_alltriggeringoccurrences1_clock == null ) {
            switchintermediate_alltriggeringoccurrences1_clock = new ExpressionClock("switchintermediate_AllTriggeringOccurrences1");
        }
        switchintermediate_alltriggeringoccurrences1_clock.setDense(false);
        switchintermediate_alltriggeringoccurrences1_clock.setParent(this);
        switchintermediate_alltriggeringoccurrences1_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        switchintermediate_alltriggeringoccurrences1 = new RuntimeUnion(switchintermediate_alltriggeringoccurrences1_clock, green_to_red_fire, green_to_red_fire);
        switchintermediate_alltriggeringoccurrences1.setName("switchintermediate_AllTriggeringOccurrences1");
        switchintermediate_alltriggeringoccurrences1.setParent(this);
        if ( green_to_red_sampledon_eventoccursafterorwhilestateentering_clock == null ) {
            green_to_red_sampledon_eventoccursafterorwhilestateentering_clock = new ExpressionClock("Green_to_Red_SampledOn_eventOccursAfterOrWhileStateEntering");
        }
        green_to_red_sampledon_eventoccursafterorwhilestateentering_clock.setDense(false);
        green_to_red_sampledon_eventoccursafterorwhilestateentering_clock.setParent(this);
        green_to_red_sampledon_eventoccursafterorwhilestateentering_clock.bddVariableNumber = green_to_red_fire.bddVariableNumber;
        green_to_red_sampledon_eventoccursafterorwhilestateentering = new SampledOnDef(green_to_red_sampledon_eventoccursafterorwhilestateentering_clock, green_entering, switch_occurs);
        green_to_red_sampledon_eventoccursafterorwhilestateentering.setName("Green_to_Red_SampledOn_eventOccursAfterOrWhileStateEntering");
        green_to_red_sampledon_eventoccursafterorwhilestateentering.setParent(this);
        if ( initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock == null ) {
            initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock = new ExpressionClock("initSemaphore_to_Red_DelayFor_delayIsExpired_wrt_StateEntering");
        }
        initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock.setDense(false);
        initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock.setParent(this);
        initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock.bddVariableNumber = initsemaphore_to_red_fire.bddVariableNumber;
        initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering = new DelayForDef(initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock, initsemaphore_entering, minutes_ticks, initsemaphore_to_redguard_initsemaphore_to_red_afterduration);
        initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering.setName("initSemaphore_to_Red_DelayFor_delayIsExpired_wrt_StateEntering");
        initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering.setParent(this);
        if ( red_to_green_delayfor_delayisexpired_wrt_stateentering_clock == null ) {
            red_to_green_delayfor_delayisexpired_wrt_stateentering_clock = new ExpressionClock("Red_to_Green_DelayFor_delayIsExpired_wrt_StateEntering");
        }
        red_to_green_delayfor_delayisexpired_wrt_stateentering_clock.setDense(false);
        red_to_green_delayfor_delayisexpired_wrt_stateentering_clock.setParent(this);
        red_to_green_delayfor_delayisexpired_wrt_stateentering_clock.bddVariableNumber = red_to_green_fire.bddVariableNumber;
        red_to_green_delayfor_delayisexpired_wrt_stateentering = new DelayForDef(red_to_green_delayfor_delayisexpired_wrt_stateentering_clock, red_entering, minutes_ticks, red_to_greenguard_red_to_green_afterduration);
        red_to_green_delayfor_delayisexpired_wrt_stateentering.setName("Red_to_Green_DelayFor_delayIsExpired_wrt_StateEntering");
        red_to_green_delayfor_delayisexpired_wrt_stateentering.setParent(this);
        if ( initsemaphoreintermediate_allfiredoutgoingtransition1_clock == null ) {
            initsemaphoreintermediate_allfiredoutgoingtransition1_clock = new ExpressionClock("initSemaphoreintermediate_allFiredoutgoingTransition1");
        }
        initsemaphoreintermediate_allfiredoutgoingtransition1_clock.setDense(false);
        initsemaphoreintermediate_allfiredoutgoingtransition1_clock.setParent(this);
        initsemaphoreintermediate_allfiredoutgoingtransition1_clock.bddVariableNumber = initsemaphore_leaving.bddVariableNumber;
        initsemaphoreintermediate_allfiredoutgoingtransition1 = new RuntimeUnion(initsemaphoreintermediate_allfiredoutgoingtransition1_clock, initsemaphore_to_red_fire, initsemaphore_to_red_fire);
        initsemaphoreintermediate_allfiredoutgoingtransition1.setName("initSemaphoreintermediate_allFiredoutgoingTransition1");
        initsemaphoreintermediate_allfiredoutgoingtransition1.setParent(this);
        if ( greenintermediate_allfiredoutgoingtransition1_clock == null ) {
            greenintermediate_allfiredoutgoingtransition1_clock = new ExpressionClock("Greenintermediate_allFiredoutgoingTransition1");
        }
        greenintermediate_allfiredoutgoingtransition1_clock.setDense(false);
        greenintermediate_allfiredoutgoingtransition1_clock.setParent(this);
        greenintermediate_allfiredoutgoingtransition1_clock.bddVariableNumber = green_leaving.bddVariableNumber;
        greenintermediate_allfiredoutgoingtransition1 = new RuntimeUnion(greenintermediate_allfiredoutgoingtransition1_clock, green_to_red_fire, green_to_red_fire);
        greenintermediate_allfiredoutgoingtransition1.setName("Greenintermediate_allFiredoutgoingTransition1");
        greenintermediate_allfiredoutgoingtransition1.setParent(this);
        if ( redintermediate_allfiredoutgoingtransition1_clock == null ) {
            redintermediate_allfiredoutgoingtransition1_clock = new ExpressionClock("Redintermediate_allFiredoutgoingTransition1");
        }
        redintermediate_allfiredoutgoingtransition1_clock.setDense(false);
        redintermediate_allfiredoutgoingtransition1_clock.setParent(this);
        redintermediate_allfiredoutgoingtransition1_clock.bddVariableNumber = red_leaving.bddVariableNumber;
        redintermediate_allfiredoutgoingtransition1 = new RuntimeUnion(redintermediate_allfiredoutgoingtransition1_clock, red_to_green_fire, red_to_green_fire);
        redintermediate_allfiredoutgoingtransition1.setName("Redintermediate_allFiredoutgoingTransition1");
        redintermediate_allfiredoutgoingtransition1.setParent(this);
        if ( greenintermediate_allinputtransition1_clock == null ) {
            greenintermediate_allinputtransition1_clock = new ExpressionClock("Greenintermediate_allInputTransition1");
        }
        greenintermediate_allinputtransition1_clock.setDense(false);
        greenintermediate_allinputtransition1_clock.setParent(this);
        greenintermediate_allinputtransition1_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        greenintermediate_allinputtransition1 = new RuntimeUnion(greenintermediate_allinputtransition1_clock, red_to_green_fire, red_to_green_fire);
        greenintermediate_allinputtransition1.setName("Greenintermediate_allInputTransition1");
        greenintermediate_allinputtransition1.setParent(this);
        if ( redintermediate_allinputtransition1_clock == null ) {
            redintermediate_allinputtransition1_clock = new ExpressionClock("Redintermediate_allInputTransition1");
        }
        redintermediate_allinputtransition1_clock.setDense(false);
        redintermediate_allinputtransition1_clock.setParent(this);
        redintermediate_allinputtransition1_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        redintermediate_allinputtransition1 = new RuntimeUnion(redintermediate_allinputtransition1_clock, initsemaphore_to_red_fire, green_to_red_fire);
        redintermediate_allinputtransition1.setName("Redintermediate_allInputTransition1");
        redintermediate_allinputtransition1.setParent(this);
        if ( semaphoreintermediate_onlyonefirst1_clock == null ) {
            semaphoreintermediate_onlyonefirst1_clock = new ExpressionClock("Semaphoreintermediate_onlyOneFirst1");
        }
        semaphoreintermediate_onlyonefirst1_clock.setDense(false);
        semaphoreintermediate_onlyonefirst1_clock.setParent(this);
        semaphoreintermediate_onlyonefirst1_clock.bddVariableNumber = initsemaphore_entering.bddVariableNumber;
        semaphoreintermediate_onlyonefirst1 = new OneTickAndNoMoreDef(semaphoreintermediate_onlyonefirst1_clock, semaphore_start);
        semaphoreintermediate_onlyonefirst1.setName("Semaphoreintermediate_onlyOneFirst1");
        semaphoreintermediate_onlyonefirst1.setParent(this);
        switchfsmeventsendreceive_occurswhensolicitate = new FSMEventSendReceiveDef(switchintermediate_alltriggeringoccurrences1_clock, switch_occurs);
        switchfsmeventsendreceive_occurswhensolicitate.setParent(this);
        switchfsmeventsendreceive_occurswhensolicitate.setName("switchFSMEventSendReceive_occursWhenSolicitate");
        switchfsmeventsendreceive_occurswhensolicitate.setAssertion(false);
        green_to_redcoincides_firewheneventoccursonetransition = new RuntimeCoincides(green_to_red_sampledon_eventoccursafterorwhilestateentering_clock, green_to_red_fire);
        green_to_redcoincides_firewheneventoccursonetransition.setParent(this);
        green_to_redcoincides_firewheneventoccursonetransition.setName("Green_to_RedCoincides_fireWhenEventOccursOneTransition");
        green_to_redcoincides_firewheneventoccursonetransition.setAssertion(false);
        initsemaphore_to_redcoincides_firewhentemporalguardholdsonetransition = new RuntimeCoincides(initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering_clock, initsemaphore_to_red_fire);
        initsemaphore_to_redcoincides_firewhentemporalguardholdsonetransition.setParent(this);
        initsemaphore_to_redcoincides_firewhentemporalguardholdsonetransition.setName("initSemaphore_to_RedCoincides_fireWhenTemporalGuardHoldsOneTransition");
        initsemaphore_to_redcoincides_firewhentemporalguardholdsonetransition.setAssertion(false);
        red_to_greencoincides_firewhentemporalguardholdsonetransition = new RuntimeCoincides(red_to_green_delayfor_delayisexpired_wrt_stateentering_clock, red_to_green_fire);
        red_to_greencoincides_firewhentemporalguardholdsonetransition.setParent(this);
        red_to_greencoincides_firewhentemporalguardholdsonetransition.setName("Red_to_GreenCoincides_fireWhenTemporalGuardHoldsOneTransition");
        red_to_greencoincides_firewhentemporalguardholdsonetransition.setAssertion(false);
        initsemaphorealternates_enteroncebeforetoleave = new AlternatesDef(initsemaphore_entering, initsemaphore_leaving);
        initsemaphorealternates_enteroncebeforetoleave.setParent(this);
        initsemaphorealternates_enteroncebeforetoleave.setName("initSemaphoreAlternates_enterOnceBeforeToLeave");
        initsemaphorealternates_enteroncebeforetoleave.setAssertion(false);
        greenalternates_enteroncebeforetoleave = new AlternatesDef(green_entering, green_leaving);
        greenalternates_enteroncebeforetoleave.setParent(this);
        greenalternates_enteroncebeforetoleave.setName("GreenAlternates_enterOnceBeforeToLeave");
        greenalternates_enteroncebeforetoleave.setAssertion(false);
        redalternates_enteroncebeforetoleave = new AlternatesDef(red_entering, red_leaving);
        redalternates_enteroncebeforetoleave.setParent(this);
        redalternates_enteroncebeforetoleave.setName("RedAlternates_enterOnceBeforeToLeave");
        redalternates_enteroncebeforetoleave.setAssertion(false);
        initsemaphorecoincides_firingatransitionalternateswithleavingstate = new RuntimeCoincides(initsemaphoreintermediate_allfiredoutgoingtransition1_clock, initsemaphore_leaving);
        initsemaphorecoincides_firingatransitionalternateswithleavingstate.setParent(this);
        initsemaphorecoincides_firingatransitionalternateswithleavingstate.setName("initSemaphoreCoincides_firingATransitionAlternatesWithLeavingState");
        initsemaphorecoincides_firingatransitionalternateswithleavingstate.setAssertion(false);
        greencoincides_firingatransitionalternateswithleavingstate = new RuntimeCoincides(greenintermediate_allfiredoutgoingtransition1_clock, green_leaving);
        greencoincides_firingatransitionalternateswithleavingstate.setParent(this);
        greencoincides_firingatransitionalternateswithleavingstate.setName("GreenCoincides_firingATransitionAlternatesWithLeavingState");
        greencoincides_firingatransitionalternateswithleavingstate.setAssertion(false);
        redcoincides_firingatransitionalternateswithleavingstate = new RuntimeCoincides(redintermediate_allfiredoutgoingtransition1_clock, red_leaving);
        redcoincides_firingatransitionalternateswithleavingstate.setParent(this);
        redcoincides_firingatransitionalternateswithleavingstate.setName("RedCoincides_firingATransitionAlternatesWithLeavingState");
        redcoincides_firingatransitionalternateswithleavingstate.setAssertion(false);
        greencauses_stateentering = new RuntimeNonStrictPrecedes(greenintermediate_allinputtransition1_clock, green_entering);
        greencauses_stateentering.setParent(this);
        greencauses_stateentering.setName("GreenCauses_stateEntering");
        greencauses_stateentering.setAssertion(false);
        redcauses_stateentering = new RuntimeNonStrictPrecedes(redintermediate_allinputtransition1_clock, red_entering);
        redcauses_stateentering.setParent(this);
        redcauses_stateentering.setName("RedCauses_stateEntering");
        redcauses_stateentering.setAssertion(false);
        semaphoreintermediate_onestateatatime1_2 = new RuntimeExclusion(red_entering, initsemaphore_entering);
        semaphoreintermediate_onestateatatime1_2.setParent(this);
        semaphoreintermediate_onestateatatime1_2.setName("Semaphoreintermediate_oneStateAtATime1_2");
        semaphoreintermediate_onestateatatime1_2.setAssertion(false);
        semaphoreintermediate_onestateatatime1_3 = new RuntimeExclusion(green_entering, initsemaphore_entering);
        semaphoreintermediate_onestateatatime1_3.setParent(this);
        semaphoreintermediate_onestateatatime1_3.setName("Semaphoreintermediate_oneStateAtATime1_3");
        semaphoreintermediate_onestateatatime1_3.setAssertion(false);
        semaphoreintermediate_onestateatatime2_3 = new RuntimeExclusion(green_entering, red_entering);
        semaphoreintermediate_onestateatatime2_3.setParent(this);
        semaphoreintermediate_onestateatatime2_3.setName("Semaphoreintermediate_oneStateAtATime2_3");
        semaphoreintermediate_onestateatatime2_3.setAssertion(false);
        semaphoreintermediate_onetransitionatatime1_2 = new RuntimeExclusion(red_to_green_fire, initsemaphore_to_red_fire);
        semaphoreintermediate_onetransitionatatime1_2.setParent(this);
        semaphoreintermediate_onetransitionatatime1_2.setName("Semaphoreintermediate_oneTransitionAtATime1_2");
        semaphoreintermediate_onetransitionatatime1_2.setAssertion(false);
        semaphoreintermediate_onetransitionatatime1_3 = new RuntimeExclusion(green_to_red_fire, initsemaphore_to_red_fire);
        semaphoreintermediate_onetransitionatatime1_3.setParent(this);
        semaphoreintermediate_onetransitionatatime1_3.setName("Semaphoreintermediate_oneTransitionAtATime1_3");
        semaphoreintermediate_onetransitionatatime1_3.setAssertion(false);
        semaphoreintermediate_onetransitionatatime2_3 = new RuntimeExclusion(green_to_red_fire, red_to_green_fire);
        semaphoreintermediate_onetransitionatatime2_3.setParent(this);
        semaphoreintermediate_onetransitionatatime2_3.setName("Semaphoreintermediate_oneTransitionAtATime2_3");
        semaphoreintermediate_onetransitionatatime2_3.setAssertion(false);
        semaphorecoincides_firstisinitialstate = new RuntimeCoincides(semaphore_start, initsemaphore_entering);
        semaphorecoincides_firstisinitialstate.setParent(this);
        semaphorecoincides_firstisinitialstate.setName("SemaphoreCoincides_firstIsInitialState");
        semaphorecoincides_firstisinitialstate.setAssertion(false);
        semaphorecoincides_firstonlyonce = new RuntimeCoincides(semaphore_start, semaphoreintermediate_onlyonefirst1_clock);
        semaphorecoincides_firstonlyonce.setParent(this);
        semaphorecoincides_firstonlyonce.setName("SemaphoreCoincides_firstOnlyOnce");
        semaphorecoincides_firstonlyonce.setAssertion(false);
    }

    public RuntimeClock getMinutes_ticks() {
        if ( minutes_ticks == null ) {
            minutes_ticks = new RuntimeClock("minutes_ticks");
        }
        return minutes_ticks;
    }

    public RuntimeClock getInitSemaphore_to_Red_fire() {
        if ( initsemaphore_to_red_fire == null ) {
            initsemaphore_to_red_fire = new RuntimeClock("initSemaphore_to_Red_fire");
        }
        return initsemaphore_to_red_fire;
    }

    public RuntimeClock getRed_to_Green_fire() {
        if ( red_to_green_fire == null ) {
            red_to_green_fire = new RuntimeClock("Red_to_Green_fire");
        }
        return red_to_green_fire;
    }

    public RuntimeClock getGreen_to_Red_fire() {
        if ( green_to_red_fire == null ) {
            green_to_red_fire = new RuntimeClock("Green_to_Red_fire");
        }
        return green_to_red_fire;
    }

    public RuntimeClock getSwitch_occurs() {
        if ( switch_occurs == null ) {
            switch_occurs = new RuntimeClock("switch_occurs");
        }
        return switch_occurs;
    }

    public RuntimeClock getInitSemaphore_entering() {
        if ( initsemaphore_entering == null ) {
            initsemaphore_entering = new RuntimeClock("initSemaphore_entering");
        }
        return initsemaphore_entering;
    }

    public RuntimeClock getGreen_entering() {
        if ( green_entering == null ) {
            green_entering = new RuntimeClock("Green_entering");
        }
        return green_entering;
    }

    public RuntimeClock getRed_entering() {
        if ( red_entering == null ) {
            red_entering = new RuntimeClock("Red_entering");
        }
        return red_entering;
    }

    public RuntimeClock getInitSemaphore_leaving() {
        if ( initsemaphore_leaving == null ) {
            initsemaphore_leaving = new RuntimeClock("initSemaphore_leaving");
        }
        return initsemaphore_leaving;
    }

    public RuntimeClock getGreen_leaving() {
        if ( green_leaving == null ) {
            green_leaving = new RuntimeClock("Green_leaving");
        }
        return green_leaving;
    }

    public RuntimeClock getRed_leaving() {
        if ( red_leaving == null ) {
            red_leaving = new RuntimeClock("Red_leaving");
        }
        return red_leaving;
    }

    public RuntimeClock getSemaphore_start() {
        if ( semaphore_start == null ) {
            semaphore_start = new RuntimeClock("Semaphore_start");
        }
        return semaphore_start;
    }

    public RuntimeClock getSemaphore_stall() {
        if ( semaphore_stall == null ) {
            semaphore_stall = new RuntimeClock("Semaphore_stall");
        }
        return semaphore_stall;
    }

    @Override
    protected ICCSLConstraint[] getConstraints() {
        ICCSLConstraint[] sym16 = { switchintermediate_alltriggeringoccurrences1, green_to_red_sampledon_eventoccursafterorwhilestateentering, initsemaphore_to_red_delayfor_delayisexpired_wrt_stateentering, red_to_green_delayfor_delayisexpired_wrt_stateentering, initsemaphoreintermediate_allfiredoutgoingtransition1, greenintermediate_allfiredoutgoingtransition1, redintermediate_allfiredoutgoingtransition1, greenintermediate_allinputtransition1, redintermediate_allinputtransition1, semaphoreintermediate_onlyonefirst1, switchfsmeventsendreceive_occurswhensolicitate, green_to_redcoincides_firewheneventoccursonetransition, initsemaphore_to_redcoincides_firewhentemporalguardholdsonetransition, red_to_greencoincides_firewhentemporalguardholdsonetransition, initsemaphorealternates_enteroncebeforetoleave, greenalternates_enteroncebeforetoleave, redalternates_enteroncebeforetoleave, initsemaphorecoincides_firingatransitionalternateswithleavingstate, greencoincides_firingatransitionalternateswithleavingstate, redcoincides_firingatransitionalternateswithleavingstate, greencauses_stateentering, redcauses_stateentering, semaphoreintermediate_onestateatatime1_2, semaphoreintermediate_onestateatatime1_3, semaphoreintermediate_onestateatatime2_3, semaphoreintermediate_onetransitionatatime1_2, semaphoreintermediate_onetransitionatatime1_3, semaphoreintermediate_onetransitionatatime2_3, semaphorecoincides_firstisinitialstate, semaphorecoincides_firstonlyonce };
        return sym16;
    }

    @Override
    public AbstractRuntimeBlock[] getSubBlocks() {
        AbstractRuntimeBlock[] sym16 = {  };
        return sym16;
    }

}
