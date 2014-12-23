package org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.expressions;

import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractSemanticHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeConcatenation;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.BDDHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeSequence;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeDeath;
import fr.inria.aoste.timesquare.ccslkernel.runtime.ValueProvider;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.AbstractRuntimeExpression;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.ExpressionClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeConcatenation.ConcatState;
import fr.inria.aoste.timesquare.ccslkernel.runtime.expressions.RuntimeWait;
import fr.inria.aoste.timesquare.ccslkernel.runtime.helpers.AbstractUpdateHelper;
import fr.inria.aoste.timesquare.ccslkernel.runtime.IRuntimeContainer;

public class FilterByDef extends AbstractRuntimeExpression implements IRuntimeContainer {

    private RuntimeClock filterbyclock;

    private RuntimeSequence<Integer> filterbyseq;

    private ValueProvider<RuntimeSequence<Integer>> filterBySeqProvider;

    private ValueProvider<Integer> seqHeadProvider =  new ValueProvider<Integer>() {
      public Integer getValue() {
        return getSeqHead();
      }
    };

    private RuntimeSequence<Integer> seqtail;

    private ValueProvider<RuntimeSequence<Integer>> seqTailProvider =  new ValueProvider<RuntimeSequence<Integer>>() {
      public RuntimeSequence<Integer> getValue() {
        return getSeqTail();
      }
    };

    public ExpressionClock filterby_waithead_clock = null;

    public RuntimeWait filterby_waithead;

    private int selectedCase = -1;

    public RuntimeDeath filterby_death;

    public ExpressionClock filterby_death_clock = null;

    public ConcatState filterby_concatwaitConcatState;

    public RuntimeClock filterby_concatwait_clock = new RuntimeClock("filterby_concatwait_clock");

    public RuntimeDeath killit;

    public ExpressionClock killit_clock = null;


    protected void init() {
        if ( filterby_waithead_clock == null ) {
            filterby_waithead_clock = new ExpressionClock("FilterBy_waitHead");
        }
        filterby_waithead_clock.setDense(false);
        filterby_waithead_clock.setParent(this);
        filterby_waithead_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        filterby_waithead = new RuntimeWait(filterby_waithead_clock, filterbyclock, seqHeadProvider);
        filterby_waithead.setName("FilterBy_waitHead");
        filterby_waithead.setParent(this);
        filterby_death = new RuntimeDeath(filterby_death_clock);
        filterby_death.setName("FilterBy_death");
        filterby_death.setParent(this);
        if ( filterby_death_clock == null ) {
            filterby_death_clock = new ExpressionClock("FilterBy_death");
        }
        filterby_death_clock.setDense(false);
        filterby_death_clock.setParent(this);
        filterby_death_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        filterby_concatwait_clock.setDense(false);
        filterby_concatwait_clock.setParent(this);
        filterby_concatwait_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
        killit = new RuntimeDeath(killit_clock);
        killit.setName("killIt");
        killit.setParent(this);
        if ( killit_clock == null ) {
            killit_clock = new ExpressionClock("killIt");
        }
        killit_clock.setDense(false);
        killit_clock.setParent(this);
        killit_clock.bddVariableNumber = BDDHelper.newBDDVariableNumber();
    }

    public FilterByDef(ExpressionClock implicitClock, RuntimeClock filterbyclock, RuntimeSequence<Integer> filterbyseq) {
        super(implicitClock);
        this.filterbyclock = filterbyclock;
        this.filterbyseq = filterbyseq;
        init();
    }

    public FilterByDef(ExpressionClock implicitClock, RuntimeClock filterbyclock, ValueProvider<RuntimeSequence<Integer>> filterbyseq) {
        super(implicitClock);
        this.filterbyclock = filterbyclock;
        this.filterBySeqProvider = filterbyseq;
        init();
    }

    private Integer getSeqHead() {
        Integer sym24 = (Integer)filterbyseq.getHead();
        return sym24;
    }

    private RuntimeSequence<Integer> getSeqTail() {
        RuntimeSequence<Integer> sym25 = filterbyseq.getTail();
        return sym25;
    }

    private Boolean getExpression26() {
        Boolean sym27 = filterbyseq.isEmpty();
        return sym27;
    }

    private Boolean getExpression28() {
        Boolean sym29 = filterbyseq.isEmpty();
        Boolean sym30 = ( ! sym29);
        return sym30;
    }

    @Override
    public void start(AbstractSemanticHelper helper)
                throws SimulationException {
        if ( ! canCallStart() ) {
            return;
        }
        super.start(helper);
        if ( filterBySeqProvider != null ) {
            filterbyseq = filterBySeqProvider.getValue();
        }
        if ( getExpression26() ) {
            selectedCase = 1;
            filterby_death.start(helper);
        }
        else         if ( getExpression28() ) {
            selectedCase = 2;
            filterby_concatwaitConcatState = ConcatState.FOLLOWLEFT;
            filterby_waithead.start(helper);
        }
        else {
            selectedCase = 0;
            killit.start(helper);
        }
    }

    @Override
    public void semantic(AbstractSemanticHelper helper)
                throws SimulationException {
        if ( ! canCallSemantic() ) {
            return;
        }
        super.semantic(helper);
        if ( getExpression26() ) {
            if ( selectedCase != 1 ) {
                filterby_death.start(helper);
            }
            selectedCase = 1;
            helper.registerClockEquality(filterby_death_clock, getExpressionClock());
            helper.registerClockUse(filterby_death_clock);
            helper.registerClockUse( getExpressionClock() );
            filterby_death.semantic(helper);
        }
        else         if ( getExpression28() ) {
            if ( selectedCase != 2 ) {
                filterby_concatwaitConcatState = ConcatState.FOLLOWLEFT;
                filterby_waithead.start(helper);
            }
            selectedCase = 2;
            helper.registerClockEquality(filterby_concatwait_clock, getExpressionClock());
            helper.registerClockUse(filterby_concatwait_clock);
            helper.registerClockUse( getExpressionClock() );
            if ( filterby_concatwaitConcatState == ConcatState.FOLLOWLEFT ) {
                filterby_waithead.semantic(helper);
                helper.registerClockEquality(filterby_waithead_clock, filterby_concatwait_clock);
                helper.registerClockUse(filterby_waithead_clock);
                helper.registerClockUse(filterby_concatwait_clock);
            }
            else             if ( filterby_concatwaitConcatState == ConcatState.FOLLOWRIGHT ) {
            }
        }
        else {
            if ( selectedCase != 0 ) {
                killit.start(helper);
            }
            selectedCase = 0;
            helper.registerClockEquality(killit_clock, getExpressionClock());
            helper.registerClockUse(killit_clock);
            helper.registerClockUse( getExpressionClock() );
            killit.semantic(helper);
        }
    }

    @Override
    public void update(AbstractUpdateHelper helper)
                throws SimulationException {
        if ( ! canCallUpdate() ) {
            return;
        }
        super.update(helper);
        if ( getExpression26() ) {
            filterby_death.update(helper);
            if ( filterby_death.isDead() ) {
                terminate(helper);
            }
        }
        else         if ( getExpression28() ) {
            if ( filterby_concatwaitConcatState == ConcatState.FOLLOWLEFT ) {
                filterby_waithead.update(helper);
                if ( filterby_waithead.isDead() ) {
                    // Recursive call here.
                    filterbyseq = getSeqTail();
                    filterby_concatwaitConcatState = ConcatState.FOLLOWLEFT;
                    helper.registerClockToStart(filterby_waithead_clock);
                }
            }
            else             if ( filterby_concatwaitConcatState == ConcatState.FOLLOWRIGHT ) {
                // Recursive call. Code is here but will never run because of previous test.
                filterbyseq = getSeqTail();
                filterby_concatwaitConcatState = ConcatState.FOLLOWLEFT;
                helper.registerClockToStart(filterby_waithead_clock);
            }
        }
        else {
            killit.update(helper);
            if ( killit.isDead() ) {
                terminate(helper);
            }
        }
    }

}
