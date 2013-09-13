package org.gemoc.execution.engine.core;

import java.util.List;

import org.gemoc.execution.engine.Activator;
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

    protected Solver solver;
    protected Executor executor;
    protected FeedbackPolicy feedbackPolicy;

    public BasicExecutionEngine() {
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
        Activator.getMessagingSystem().info("Starting running indefinitely", Activator.PLUGIN_ID);
        this.run(-1);
        Activator.getMessagingSystem().info("Stopped running indefinitely", Activator.PLUGIN_ID);
    }

    @Override
    public void run(int numberOfSteps) {
        Activator.getMessagingSystem().info("Running " + numberOfSteps + " steps", Activator.PLUGIN_ID);
        for (int i = 0; i < numberOfSteps; i++) {
            this.runOneStep();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void runOneStep() {
        Activator.getMessagingSystem().info("### Running one step", Activator.PLUGIN_ID);
        Step step = this.solver.getNextStep();
        Activator.getMessagingSystem().debug("The solver has correctly returned a step to the engine",
                Activator.PLUGIN_ID);
        List<DomainSpecificEvent> events = this.match(step);
        Activator.getMessagingSystem().info("Number of events matched : " + events.size(), Activator.PLUGIN_ID);
        for (DomainSpecificEvent event : events) {
            FeedbackData feedback = this.executor.execute(event);
            Activator.getMessagingSystem().info(
                    "Feedback from event " + event.toString() + " is : " + feedback.toString(), Activator.PLUGIN_ID);
            this.feedbackPolicy.processFeedback(feedback, solver);
        }
        Activator.getMessagingSystem().info("### Step finished", Activator.PLUGIN_ID);
    }

    public String toString() {
        return this.getClass().getName() + "@[" + "]";
    }
}
