package org.gemoc.execution.engine.core;

import glml.ModelSpecificEvent;

import java.util.Collection;


/**
 * Basic EnventInjector that injects all possible events
 * @author dvojtise
 *
 */
public class BasicEventInjector implements EventInjector {

	@Override
	public Collection<ModelSpecificEvent> getEventToInject(
			Collection<ModelSpecificEvent> possibleEvents) {
		return possibleEvents;
	}

}
