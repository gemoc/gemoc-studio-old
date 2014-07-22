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
	 * Notifies the number of choices in the timeline has changed.
	 * 
	 * @param numberOfChoices
	 *            the number of choices in the timeline
	 */
	public void notifyNumberOfChoicesChanged(int numberOfChoices) {
		for (ITimelineListener listener : getListeners()) {
			listener.numberOfChoicesChanged(numberOfChoices);
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
	 * Notifies the number of possible steps at the given timeline index has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param numberOfPossibleStep
	 *            the number of possibleSteps at the given timeline index
	 */
	public void notifyNumberOfPossibleStepsAtChanged(int index, int numberOfPossibleStep) {
		for (ITimelineListener listener : getListeners()) {
			listener.numberOfPossibleStepsAtChanged(index, numberOfPossibleStep);
		}
	}

	/**
	 * Notifies the text for the given index of the timeline has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param text
	 *            the text for the given index of the timeline
	 */
	public void notifyTextAtChanged(int index, String text) {
		for (ITimelineListener listener : getListeners()) {
			listener.textAtChanged(index, text);
		}
	}

	/**
	 * Notifies the {@link Object} at the given possible step (timeline index and possible step index) has
	 * changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @param object
	 *            the {@link Object} at the given possible step (timeline index and posible step index)
	 */
	public void notifyAtChanged(int index, int possibleStep, Object object) {
		for (ITimelineListener listener : getListeners()) {
			listener.atChanged(index, possibleStep, object);
		}
	}

	/**
	 * Notifies the given possible step (timeline index and possible step index) has been selected or
	 * de-selected.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @param selected
	 *            <code>true</code> if the possibleStep is now selected, <code>false</code> otherwise
	 */
	public void notifyIsSelectedChanged(int index, int possibleStep, boolean selected) {
		for (ITimelineListener listener : getListeners()) {
			listener.isSelectedChanged(index, possibleStep, selected);
		}
	}

	/**
	 * Notifies the text for the given possible step (timeline index and possible step index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @param text
	 *            the text for the given possible step (timeline index and possible step index)
	 */
	public void notifyTextAtChanged(int index, int possibleStep, String text) {
		for (ITimelineListener listener : getListeners()) {
			listener.textAtChanged(index, possibleStep, text);
		}
	}

	/**
	 * Notifies the following possible step index for the given possible step (timeline index and possible
	 * step index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @param following
	 *            the following possible step for the given possible step (timeline index and possible step
	 *            index) if any, <code>-1</code> otherwise
	 */
	public void notifyFollowingChanged(int index, int possibleStep, int following) {
		for (ITimelineListener listener : getListeners()) {
			listener.followingChanged(index, possibleStep, following);
		}
	}

	/**
	 * Notifies the preceding possible step index for the given possible step (timeline index and possible
	 * step index) has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @param preceding
	 *            the preceding possible step for the given possible step (timeline index and possible step
	 *            index) if any, <code>-1</code> otherwise
	 */
	public void notifyPrecedingChanged(int index, int possibleStep, int preceding) {
		for (ITimelineListener listener : getListeners()) {
			listener.precedingChanged(index, possibleStep, preceding);
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
