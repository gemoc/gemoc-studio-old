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
package fr.obeo.timeline.view;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract implementation of {@link ITimelineProvider} managing notifications to {@link ITimelineListener}
 * .
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractTimelineProvider implements ITimelineProvider {

	/**
	 * The {@link List} of {@link ITimelineListener} to notify.
	 */
	private List<ITimelineListener> listeners = new ArrayList<ITimelineListener>();

	/**
	 * Notifies the number of ticks in the timeline has changed.
	 * 
	 * @param numberOfticks
	 *            the number of ticks in the timeline
	 */
	public void notifyNumberOfticksChanged(int numberOfticks) {
		for (ITimelineListener listener : getListeners()) {
			listener.numberOfticksChanged(numberOfticks);
		}
	}

	/**
	 * Gets the {@link List} of {@link ITimelineListener}.
	 * 
	 * @return the {@link List} of {@link ITimelineListener}
	 */
	private List<ITimelineListener> getListeners() {
		final List<ITimelineListener> l;
		synchronized(listeners) {
			l = new ArrayList<ITimelineListener>(listeners);
		}
		return l;
	}

	/**
	 * Notifies the number of choices at the given timeline index has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param numberOfChoice
	 *            the number of choices at the given timeline index
	 */
	public void notifyNumberOfchoicesAtChanged(int index, int numberOfChoice) {
		for (ITimelineListener listener : getListeners()) {
			listener.numberOfchoicesAtChanged(index, numberOfChoice);
		}
	}

	/**
	 * Notifies the text for the given index of the timeline has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param text
	 *            the text for the given index of the timeline
	 */
	public void notifyTextAtChanged(int index, String text) {
		for (ITimelineListener listener : getListeners()) {
			listener.textAtChanged(index, text);
		}
	}

	/**
	 * Notifies the {@link Object} at the given choice (timeline index and choice index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @param object
	 *            the {@link Object} at the given choice (timeline index and choice index)
	 */
	public void notifyAtChanged(int index, int choice, Object object) {
		for (ITimelineListener listener : getListeners()) {
			listener.atChanged(index, choice, object);
		}
	}

	/**
	 * Notifies the given choice (timeline index and choice index) has been selected or de-selected.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @param selected
	 *            <code>true</code> if the choice ise now selected, <code>false</code> otherwise
	 */
	public void notifyIsSelectedChanged(int index, int choice, boolean selected) {
		for (ITimelineListener listener : getListeners()) {
			listener.isSelectedChanged(index, choice, selected);
		}
	}

	/**
	 * Notifies the text for the given choice (timeline index and choice index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @param text
	 *            the text for the given choice (timeline index and choice index)
	 */
	public void notifyTextAtChanged(int index, int choice, String text) {
		for (ITimelineListener listener : getListeners()) {
			listener.textAtChanged(index, choice, text);
		}
	}

	/**
	 * Notifies the following choice index for the given choice (timeline index and choice index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @param following
	 *            the following choice for the given choice (timeline index and choice index) if any,
	 *            <code>-1</code> otherwise
	 */
	public void notifyFollowingChanged(int index, int choice, int following) {
		for (ITimelineListener listener : getListeners()) {
			listener.followingChanged(index, choice, following);
		}
	}

	/**
	 * Notifies the preceding choice index for the given choice (timeline index and choice index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @param preceding
	 *            the preceding choice for the given choice (timeline index and choice index) if any,
	 *            <code>-1</code> otherwise
	 */
	public void notifyPrecedingChanged(int index, int choice, int preceding) {
		for (ITimelineListener listener : getListeners()) {
			listener.precedingChanged(index, choice, preceding);
		}
	}

	@Override
	public void addTimelineListener(ITimelineListener listener) {
		synchronized(listeners) {
			listeners.add(listener);
		}
	}

	@Override
	public void removeTimelineListener(ITimelineListener listener) {
		synchronized(listeners) {
			listeners.remove(listener);
		}
	}

}
