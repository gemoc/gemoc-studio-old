/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.debug.ide.event;

import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.DSLDebugTargetAdapter;
import fr.obeo.dsl.debug.ide.event.debugger.IDSLDebuggerReply;
import fr.obeo.dsl.debug.ide.event.model.IDSLModelRequest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * Dispatches {@link IDSLDebugEvent} between the {@link IDSLDebugger debugger} and the
 * {@link DSLDebugTargetAdapter model}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLDebugEventDispatcher extends Job implements IDSLDebugEventProcessor {

	/**
	 * The {@link Job#getName() job name}.
	 */
	public static final String NAME = "DSL debugger event dispatcher";

	/**
	 * {@link List} of events to dispatch.
	 */
	private final List<IDSLDebugEvent> events = new ArrayList<IDSLDebugEvent>();

	/**
	 * Tells that our job is over.
	 */
	private boolean terminated;

	/**
	 * The {@link IDSLDebugEvent debugger}.
	 */
	private IDSLDebugger debugger;

	/**
	 * The {@link DSLDebugTargetAdapter model}.
	 */
	private DSLDebugTargetAdapter model;

	/**
	 * Constructor.
	 */
	public DSLDebugEventDispatcher() {
		super(NAME);
		setSystem(true);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		while (!terminated) {
			// wait for new events
			if (events.isEmpty()) {
				try {
					synchronized(this) {
						wait();
					}
				} catch (InterruptedException e) {
					// nothing to do here
				}
			}

			if (!monitor.isCanceled()) {
				IDSLDebugEvent event = null;
				synchronized(events) {
					if (!events.isEmpty()) {
						event = events.remove(0);
					}
				}

				if (event != null) {
					handleEvent(event);
				}
			} else {
				terminate();
			}
		}

		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)
	 */
	public void handleEvent(final IDSLDebugEvent event) {
		// forward event handling to target
		if (event instanceof IDSLDebuggerReply) {
			model.handleEvent(event);
		} else if (event instanceof IDSLModelRequest) {
			debugger.handleEvent(event);
		} else {
			throw new RuntimeException("Unknown event detected: " + event);
		}
	}

	/**
	 * Add the given {@link IDSLDebugEvent} for future dispatch.
	 * 
	 * @param event
	 *            the {@link IDSLDebugEvent}
	 */
	public void addEvent(final IDSLDebugEvent event) {
		synchronized(events) {
			events.add(event);
		}

		synchronized(this) {
			notifyAll();
		}
	}

	/**
	 * Terminates the dispatcher.
	 */
	public void terminate() {
		terminated = true;

		// wake up job
		synchronized(this) {
			notifyAll();
		}
	}

	public void setDebugger(IDSLDebugger debugger) {
		this.debugger = debugger;
	}

	public void setModel(DSLDebugTargetAdapter model) {
		this.model = model;
	}

}
