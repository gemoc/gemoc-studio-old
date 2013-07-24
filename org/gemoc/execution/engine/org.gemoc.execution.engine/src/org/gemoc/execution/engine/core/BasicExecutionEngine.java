package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.Executor;
import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.solvers.Solver;
import org.gemoc.execution.engine.solvers.Step;

import fr.inria.aoste.timesquare.ECL.EventKind;
import fr.inria.aoste.timesquare.ccslkernel.solver.TimeModel.SolverClock;

public abstract class BasicExecutionEngine implements ExecutionEngine {

    private boolean finished = false;
    private int rounds = 0;
    protected Solver solver;
    protected Executor executor;
    protected FeedbackPolicy feedbackPolicy;

    public FeedbackPolicy getFeedbackPolicy() {
        return this.feedbackPolicy;
    }

    public BasicExecutionEngine() {
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int getRounds() {
        return this.rounds;
    }

    public Solver getSolver() {
        return this.solver;
    }

    private void integrateFeedback(FeedbackData feedback) {
        
    }

    private List<DomainSpecificEvent> match(Step step) {
        List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();

        return res;
    }

    @Override
    public void run() {
        this.run(-1);
    }

    public void run(int maxRounds) {
        while (!this.finished) {
            this.rounds++;

            Step step = this.getSolver().getNextStep();
            List<DomainSpecificEvent> events = this.match(step);

            for (DomainSpecificEvent event : events) {
                FeedbackData feedback = this.getExecutor().execute(event);
                this.getFeedbackPolicy().processFeedback(feedback, this.getSolver());
            }

            this.finished = this.finished || this.rounds < maxRounds;
        } // end while
    }

}
