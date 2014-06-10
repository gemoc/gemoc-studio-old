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
		if (numberOfticks != getNumberOfTicks()) {
			for (ITimelineListener listener : listeners) {
				listener.numberOfticksChanged(numberOfticks);
			}
		}
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
		if (numberOfChoice != getNumberOfchoicesAt(index)) {
			for (ITimelineListener listener : listeners) {
				listener.numberOfchoicesAtChanged(index, numberOfChoice);
			}
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
		if (text != getTextAt(index)) {
			for (ITimelineListener listener : listeners) {
				listener.textAtChanged(index, text);
			}
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
		final Object at = getAt(index, choice);
		if ((object == null && at != null) || (object != null && !object.equals(at))) {
			for (ITimelineListener listener : listeners) {
				listener.atChanged(index, choice, object);
			}
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
		if (text != getTextAt(index)) {
			for (ITimelineListener listener : listeners) {
				listener.textAtChanged(index, choice, text);
			}
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
		if (following != getFollowing(index, choice)) {
			for (ITimelineListener listener : listeners) {
				listener.followingChanged(index, choice, following);
			}
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
		if (preceding != getFollowing(index, choice)) {
			for (ITimelineListener listener : listeners) {
				listener.precedingChanged(index, choice, preceding);
			}
		}
	}

	@Override
	public void addTimelineListener(ITimelineListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeTimelineListener(ITimelineListener listener) {
		listeners.remove(listener);
	}

}
