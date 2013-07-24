package org.gemoc.execution.engine.solvers;

/**
 * A solver is the visible interface of a constraint system that defines the
 * Model of Computation.
 * 
 * @author flatombe
 */
public interface Solver {
    public Step getNextStep();
}
