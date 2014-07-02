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
		public void numberOfticksChanged(int numberOfticks) {
			// nothing to do here
		}

		@Override
		public void numberOfchoicesAtChanged(int index, int numberOfChoice) {
			// nothing to do here
		}

		@Override
		public void textAtChanged(int index, String text) {
			// nothing to do here
		}

		@Override
		public void atChanged(int index, int choice, Object object) {
			// nothing to do here
		}

		@Override
		public void isSelectedChanged(int index, int choice, boolean selected) {
			// nothing to do here
		}

		@Override
		public void textAtChanged(int index, int choice, String text) {
			// nothing to do here
		}

		@Override
		public void followingChanged(int index, int choice, int following) {
			// nothing to do here
		}

		@Override
		public void precedingChanged(int index, int choice, int preceding) {
			// nothing to do here
		}

	}

	/**
	 * Notifies the number of ticks in the timeline has changed.
	 * 
	 * @param numberOfticks
	 *            the number of ticks in the timeline
	 */
	void numberOfticksChanged(int numberOfticks);

	/**
	 * Notifies the number of choices at the given timeline index has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param numberOfChoice
	 *            the number of choices at the given timeline index
	 */
	void numberOfchoicesAtChanged(int index, int numberOfChoice);

	/**
	 * Notifies the text for the given index of the timeline has changed.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param text
	 *            the text for the given index of the timeline
	 */
	void textAtChanged(int index, String text);

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
	void atChanged(int index, int choice, Object object);

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
	void isSelectedChanged(int index, int choice, boolean selected);

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
	void textAtChanged(int index, int choice, String text);

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
	void followingChanged(int index, int choice, int following);

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
	void precedingChanged(int index, int choice, int preceding);

}
