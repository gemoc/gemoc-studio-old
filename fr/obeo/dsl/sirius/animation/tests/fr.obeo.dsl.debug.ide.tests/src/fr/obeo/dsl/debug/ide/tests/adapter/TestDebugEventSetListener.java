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
package fr.obeo.dsl.debug.ide.tests.adapter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.IDebugEventSetListener;

/**
 * Implementation of {@link IDebugEventSetListener} for test purpose.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TestDebugEventSetListener implements IDebugEventSetListener {

	/**
	 * {@link List} of received {@link DebugEvent}.
	 */
	final List<DebugEvent[]> eventsList = new ArrayList<DebugEvent[]>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IDebugEventSetListener#handleDebugEvents(org.eclipse.debug.core.DebugEvent[])
	 */
	public synchronized void handleDebugEvents(DebugEvent[] events) {
		eventsList.add(events);
		notify();
	}

	/**
	 * Gets the {@link List} of received {@link DebugEvent}.
	 * 
	 * @return the {@link List} of received {@link DebugEvent}
	 */
	public List<DebugEvent[]> getEventsList() {
		return eventsList;
	}

	/**
	 * Wait until an a call to {@link TestDebugEventSetListener#handleDebugEvents(DebugEvent[])} is done.
	 */
	public synchronized void waitForEvent() {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
