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

/**
 * Listener for {@link ITimelineProvider} changes.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ITimelineListener {

	/**
	 * Stub implementation.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	class Stub implements ITimelineListener {

		@Override
		public void numberOfChoicesChanged(int numberOfChoices) {
			// nothing to do here
		}

		@Override
		public void numberOfPossibleStepsAtChanged(int index, int numberOfPossibleStep) {
			// nothing to do here
		}

		@Override
		public void textAtChanged(int index, String text) {
			// nothing to do here
		}

		@Override
		public void atChanged(int index, int possibleStep, Object object) {
			// nothing to do here
		}

		@Override
		public void isSelectedChanged(int index, int possibleStep, boolean selected) {
			// nothing to do here
		}

		@Override
		public void textAtChanged(int index, int possibleStep, String text) {
			// nothing to do here
		}

		@Override
		public void followingChanged(int index, int possibleStep, int following) {
			// nothing to do here
		}

		@Override
		public void precedingChanged(int index, int possibleStep, int preceding) {
			// nothing to do here
		}

	}

	/**
	 * Notifies the number of choices in the timeline has changed.
	 * 
	 * @param numberOfChoices
	 *            the number of choices in the timeline
	 */
	void numberOfChoicesChanged(int numberOfChoices);

	/**
	 * Notifies the number of possible steps at the given timeline index has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param numberOfpossibleStep
	 *            the number of possible steps at the given timeline index
	 */
	void numberOfPossibleStepsAtChanged(int index, int numberOfpossibleStep);

	/**
	 * Notifies the text for the given index of the timeline has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param text
	 *            the text for the given index of the timeline
	 */
	void textAtChanged(int index, String text);

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
	 *            the {@link Object} at the given possible step (timeline index and possible step index)
	 */
	void atChanged(int index, int possibleStep, Object object);

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
	 *            <code>true</code> if the possible step is now selected, <code>false</code> otherwise
	 */
	void isSelectedChanged(int index, int possibleStep, boolean selected);

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
	void textAtChanged(int index, int possibleStep, String text);

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
	void followingChanged(int index, int possibleStep, int following);

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
	void precedingChanged(int index, int possibleStep, int preceding);

}
