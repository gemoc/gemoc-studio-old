package org.gemoc.execution.engine.events;

/**
 * Domain-Specific Events
 * 
 * @author flatombe
 */
public interface DomainSpecificEvent {
    public DomainSpecificAction getAction();
    
}
