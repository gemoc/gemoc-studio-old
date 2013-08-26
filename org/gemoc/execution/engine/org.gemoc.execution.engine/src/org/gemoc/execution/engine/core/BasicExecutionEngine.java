package org.gemoc.execution.engine.core;

import java.util.List;

import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.Executor;
import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.solvers.Solver;
import org.gemoc.execution.engine.solvers.Step;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol.
 * 
 * 
 * @author flatombe
 * 
 */
public abstract class BasicExecutionEngine implements ExecutionEngine {

    private Boolean finished;
    private Integer rounds;
    protected Solver solver;
    protected Executor executor;
    @SuppressWarnings("rawtypes")
    protected FeedbackPolicy feedbackPolicy;

    /**
     * Basic constructor for the engine.
     */
    public BasicExecutionEngine() {
        this.finished = false;
        this.rounds = 0;
    }

    /**
     * 
     * @return the executor used by the engine implementation.
     */
    public Executor getExecutor() {
        return this.executor;
    }

    /**
     * 
     * @return the feedback policy used by the engine implementation.
     */
    @SuppressWarnings("rawtypes")
    public FeedbackPolicy getFeedbackPolicy() {
        return this.feedbackPolicy;
    }

    /**
     * 
     * @return the current round number.
     */
    public int getRounds() {
        return this.rounds;
    }

    /**
     * 
     * @return the solver used by the engine implementation.
     */
    public Solver getSolver() {
        return this.solver;
    }

    /**
     * 
     * @param step
     * @return the list of the DomainSpecificEvent corresponding to the
     *         EventOccurrence present in the Step
     */
    protected abstract List<DomainSpecificEvent> match(Step step);

    @Override
    public void run() {
        this.run(-1);
    }

    /**
     * Run the engine for a given number of rounds or until the execution is
     * finished.
     * 
     * @param maxRounds
     */
    @SuppressWarnings("unchecked")
    public void run(int maxRounds) {
        while (!this.finished) {
            this.rounds++;

            Step step = this.getSolver().getNextStep();
            List<DomainSpecificEvent> events = this.match(step);

            for (DomainSpecificEvent event : events) {
                FeedbackData feedback = this.getExecutor().execute(event);
                this.getFeedbackPolicy().processFeedback(feedback, this.getSolver(), events);
            }

            this.finished = this.finished || this.rounds < maxRounds;
        } // end while
    }

}
