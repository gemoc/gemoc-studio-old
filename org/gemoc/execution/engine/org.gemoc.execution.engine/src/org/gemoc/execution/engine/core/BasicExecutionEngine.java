package org.gemoc.execution.engine.core;

import java.util.List;
import java.util.logging.Logger;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.Executor;
import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.feedback.data.impl.easy.EObjectFeedbackData;
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

    protected Solver solver;
    protected Executor executor;
    protected FeedbackPolicy feedbackPolicy;
    protected Logger logger;

    public BasicExecutionEngine() {
        this.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    }

    /**
     * Instantiates a list of Domain Specific Events depending on which event
     * occurrences are in the Step returned by the Solver.
     * 
     * @param step
     * @return
     */
    protected abstract List<DomainSpecificEvent> match(Step step);

    @Override
    public void run() {
        logger.info("Starting running indefinitely");
        this.run(-1);
        logger.info("Stopped running indefinitely");
    }

    @Override
    public void run(int numberOfSteps) {
        logger.info("Running " + numberOfSteps + " steps");
        for (int i = 0; i < numberOfSteps; i++) {
            this.runOneStep();
        }
    }

    @Override
    public void runOneStep() {
        logger.info("Running one step");
        Step step = this.solver.getNextStep();
        List<DomainSpecificEvent> events = this.match(step);
        for (DomainSpecificEvent event : events) {
            FeedbackData feedback = this.executor.execute(event);
            this.feedbackPolicy.processFeedback(feedback, solver);
        }
    }

    public String toString() {
        return this.getClass().getName() + "@[" + "]";
    }
}
