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
 * A timeline provider.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface ITimelineProvider {

	/**
	 * Gets the number of ticks in the timeline.
	 * 
	 * @return the number of ticks in the timeline
	 */
	int getNumberOfTicks();

	/**
	 * Gets the number of choices at the given timeline index.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @return the number of choices at the given timeline index
	 */
	int getNumberOfchoicesAt(int index);

	/**
	 * Gets the text for the given index of the timeline.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @return the text for the given index of the timeline
	 */
	String getTextAt(int index);

	/**
	 * Tells if the given choice (timeline index and choice index) is selected.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @return <code>true</code> if the given choice (timeline index and choice index) is selected,
	 *         <code>false</code> otherwise
	 */
	boolean isSelected(int index, int choice);

	/**
	 * Gets the {@link Object} at the given choice (timeline index and choice index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @return the {@link Object} at the given choice (timeline index and choice index) if any,
	 *         <code>null</code> otherwise
	 */
	Object getAt(int index, int choice);

	/**
	 * Gets the text for the given choice (timeline index and choice index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @return the text for the given choice (timeline index and choice index)
	 */
	String getTextAt(int index, int choice);

	/**
	 * Gets the following choice index for the given choice (timeline index and choice index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @return the following choice for the given choice (timeline index and choice index) if any,
	 *         <code>-1</code> otherwise
	 */
	int getFollowing(int index, int choice);

	/**
	 * Gets the preceding choice index for the given choice (timeline index and choice index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfTicks() nbticks}[)
	 * @param choice
	 *            the choice index ([0..{@link ITimelineProvider#getNumberOfchoicesAt(int) nbChoices}[)
	 * @return the preceding choice for the given choice (timeline index and choice index) if any,
	 *         <code>-1</code> otherwise
	 */
	int getPreceding(int index, int choice);

	/**
	 * Adds a {@link ITimelineListener}.
	 * 
	 * @param listener
	 *            the {@link ITimelineListener}
	 */
	void addTimelineListener(ITimelineListener listener);

	/**
	 * Removes a {@link ITimelineListener}.
	 * 
	 * @param listener
	 *            the {@link ITimelineListener}
	 */
	void removeTimelineListener(ITimelineListener listener);

}
