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
package fr.obeo.timeline.model;

import fr.obeo.timeline.view.ITimelineProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A choice in time.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public final class Choice {

	/**
	 * The containing {@link TimelineWindow}.
	 */
	private final TimelineWindow timelineWindow;

	/**
	 * The index in the owning {@link TimelineWindow}.
	 */
	private final int index;

	/**
	 * Constructor.
	 * 
	 * @param timelineWindow
	 *            the containing {@link TimelineWindow}
	 * @param index
	 *            the index in the owning {@link TimelineWindow}
	 */
	public Choice(TimelineWindow timelineWindow, int index) {
		this.timelineWindow = timelineWindow;
		this.index = index;
	}

	/**
	 * Gets the containing {@link TimelineWindow}.
	 * 
	 * @return the containing {@link TimelineWindow}
	 */
	public TimelineWindow getTimelineWindow() {
		return timelineWindow;
	}

	/**
	 * Gets the {@link List} of {@link PossibleStep}.
	 * 
	 * @return the {@link List} of {@link PossibleStep}
	 */
	public List<PossibleStep> getPossibleSteps() {
		List<PossibleStep> res = new ArrayList<PossibleStep>();

		final ITimelineProvider provider = getTimelineWindow().getProvider();
		final int numberOfPossibleStepsAt = provider.getNumberOfPossibleStepsAt(index);
		for (int i = 0; i < numberOfPossibleStepsAt; ++i) {
			res.add(new PossibleStep(getTimelineWindow(), index, i));
		}

		return res;
	}

	/**
	 * Gets the index in the owning {@link TimelineWindow}.
	 * 
	 * @return the index in the owning {@link TimelineWindow}
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Gets the previous {@link Choice} in the {@link TimelineWindow}.
	 * 
	 * @return the previous {@link Choice} in the {@link TimelineWindow} if any, <code>null</code> otherwise
	 */
	public Choice getPreviousChoice() {
		final Choice res;
		if (index > 0) {
			res = new Choice(getTimelineWindow(), index - 1);
		} else {
			res = null;
		}
		return res;
	}

	/**
	 * Gets the next {@link Choice} in the {@link TimelineWindow}.
	 * 
	 * @return the next {@link Choice} in the {@link TimelineWindow} if any, <code>null</code> otherwise
	 */
	public Choice getNextChoice() {
		final Choice res;
		final int numberOfChoices = getTimelineWindow().getProvider().getNumberOfChoices();
		if (index < numberOfChoices - 1) {
			res = new Choice(getTimelineWindow(), index + 1);
		} else {
			res = null;
		}
		return res;
	}

	@Override
	public int hashCode() {
		return index;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Choice && ((Choice)obj).index == index;
	}

	/**
	 * Gets the index of the connected possible step.
	 * 
	 * @return the index of the connected possible step if any, <code>-1</code> otherwise
	 */
	public int getConnectedIndex() {
		return getTimelineWindow().getProvider().getSelectedPossibleStep(index);
	}

	/**
	 * Tells if the {@link Choice} has a {@link PossibleStep#isSelected() selectect} {@link PossibleStep}.
	 * 
	 * @return <code>true</code> if the {@link Choice} has a {@link PossibleStep#isSelected() selectect}
	 *         {@link PossibleStep} , <code>false</code> otherwise
	 */
	public boolean hasSelected() {
		return getTimelineWindow().getProvider().getSelectedPossibleStep(index) >= 0;
	}
}
