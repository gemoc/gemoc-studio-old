package org.gemoc.execution.engine.events;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.actions.DomainSpecificAction;

/**
 * Domain-Specific Events contain a reference to a DomainSpecificAction that can
 * be triggered by the Executor (on the specified target), a pattern of some
 * structure that represents its mapping with the MoC side (CCSL clocks for
 * example). Attribute first is just something to guess which event the feedback
 * wants to point at just knowing the target of the event (typically
 * Start/Fire/Init should be first, while Continue/Stop/Halt should not).
 * 
 * @author flatombe
 */
public interface DomainSpecificEvent {
	public DomainSpecificAction getAction();

	public EObject getTarget();

	public Boolean isEntryPoint();
}
