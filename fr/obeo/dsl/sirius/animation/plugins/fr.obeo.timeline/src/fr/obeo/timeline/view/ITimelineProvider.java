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
	 * Gets the number of choices in the timeline.
	 * 
	 * @return the number of choices in the timeline
	 */
	int getNumberOfChoices();

	/**
	 * Gets the number of possible steps at the given timeline index.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @return the number of possible steps at the given timeline index
	 */
	int getNumberOfPossibleStepsAt(int index);

	/**
	 * Gets the text for the given index of the timeline.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @return the text for the given index of the timeline
	 */
	String getTextAt(int index);

	/**
	 * Tells if the given possible step (timeline index and possible step index) is selected.
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @return the selected possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *         nbPossibleSteps}[) if any, <code>-1</code> otherwise
	 */
	int getSelectedPossibleStep(int index);

	/**
	 * Gets the {@link Object} at the given possible step (timeline index and possible step index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @return the {@link Object} at the given possible step (timeline index and possible step index) if any,
	 *         <code>null</code> otherwise
	 */
	Object getAt(int index, int possibleStep);

	/**
	 * Gets the {@link Object} at the given possible step (timeline index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @return the {@link Object} at the given possible step (timeline index and possible step index) if any,
	 *         <code>null</code> otherwise
	 */
	Object getAt(int index);

	/**
	 * Gets the text for the given possible step (timeline index and possible step index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possible
	 *            step the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @return the text for the given possible step (timeline index and possibe step index)
	 */
	String getTextAt(int index, int possibleStep);

	/**
	 * Gets the following possible step index for the given possible step (timeline index and possible step
	 * index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @return the following possible step for the given possible step (timeline index and possible step
	 *         index) if any, <code>-1</code> otherwise
	 */
	int getFollowing(int index, int possibleStep);

	/**
	 * Gets the preceding possible step index for the given possible step (timeline index and possible step
	 * index).
	 * 
	 * @param index
	 *            the timeline index ([0..{@link ITimelineProvider#getNumberOfChoices() nbChoices}[)
	 * @param possibleStep
	 *            the possible step index ([0..{@link ITimelineProvider#getNumberOfPossibleStepsAt(int)
	 *            nbPossibleSteps}[)
	 * @return the preceding possible step for the given possible step (timeline index and possible step
	 *         index) if any, <code>-1</code> otherwise
	 */
	int getPreceding(int index, int possibleStep);

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
