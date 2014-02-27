package org.gemoc.execution.engine.core;

import glml.ModelSpecificEvent;

import java.util.Collection;

public interface EventInjector {
	
	Collection<ModelSpecificEvent> getEventToInject(Collection<ModelSpecificEvent> possibleEvents);
}
