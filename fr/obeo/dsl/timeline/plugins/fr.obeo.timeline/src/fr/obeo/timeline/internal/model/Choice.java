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
package fr.obeo.timeline.internal.model;

import fr.obeo.timeline.view.ITimelineProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A Choice.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public final class Choice {

	/**
	 * Shift for the {@link Choice#hashCode() hash code}.
	 */
	private static final int SHIFT = 8;

	/**
	 * The containing {@link TimelineWindow}.
	 */
	private final TimelineWindow timelineWindow;

	/**
	 * The timeline index.
	 */
	private final int index;

	/**
	 * The choice index.
	 */
	private final int choice;

	/**
	 * Constructor.
	 * 
	 * @param timelineWindow
	 *            the containing {@link TimelineWindow}
	 * @param index
	 *            the timeline index
	 * @param choice
	 *            the choice index
	 */
	public Choice(TimelineWindow timelineWindow, int index, int choice) {
		this.timelineWindow = timelineWindow;
		this.index = index;
		this.choice = choice;
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
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return getTimelineWindow().getProvider().getTextAt(index, choice);
	}

	/**
	 * Tells if the choice has been selected.
	 * 
	 * @return <code>true</code> if the choice has been selected.
	 */
	public boolean isSelected() {
		return getTimelineWindow().getProvider().isSelected(index, choice);
	}

	/**
	 * Gets the owning {@link Tic}.
	 * 
	 * @return the owning {@link Tic}
	 */
	public Tic getTic() {
		return new Tic(getTimelineWindow(), index);
	}

	/**
	 * Gets the previous {@link Choice} in the {@link Tic}.
	 * 
	 * @return the previous {@link Choice} in the {@link Tic} if any, <code>null</code> otherwise
	 */
	public Choice getPreviousChoice() {
		final Choice res;

		if (choice > 0) {
			res = new Choice(getTimelineWindow(), index, choice - 1);
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the next {@link Choice} in the {@link Tic}.
	 * 
	 * @return the next {@link Choice} in the {@link Tic} if any, <code>null</code> otherwise
	 */
	public Choice getNextChoice() {
		final Choice res;

		if (choice < getTimelineWindow().getProvider().getNumberOfchoicesAt(index)) {
			res = new Choice(getTimelineWindow(), index, choice + 1);
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the index in the owning {@link Tic}.
	 * 
	 * @return the index in the owning {@link Tic}
	 */
	public int getIndex() {
		return choice;
	}

	/**
	 * Gets the {@link List} of preceding {@link Connection}.
	 * 
	 * @return the {@link List} of preceding {@link Connection}
	 */
	public List<Connection> getPreceding() {
		final List<Connection> res = new ArrayList<Connection>();

		final ITimelineProvider provider = getTimelineWindow().getProvider();
		if (index > getTimelineWindow().getStart()) {
			final int preceding = provider.getPreceding(index, choice);
			if (preceding >= 0) {
				res.add(new Connection(new Choice(getTimelineWindow(), index - 1, preceding), this));
			}
		}

		return res;
	}

	/**
	 * Gets the {@link List} of following {@link Connection}.
	 * 
	 * @return the {@link List} of following {@link Connection}
	 */
	public List<Connection> getFollowing() {
		final List<Connection> res = new ArrayList<Connection>();

		final ITimelineProvider provider = getTimelineWindow().getProvider();
		if (index + 1 < getTimelineWindow().getEnd()) {
			final int following = provider.getFollowing(index, choice);
			if (following >= 0) {
				res.add(new Connection(this, new Choice(getTimelineWindow(), index + 1, following)));
			}
		}

		return res;
	}

	@Override
	public int hashCode() {
		return (index << SHIFT) + choice;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Choice && ((Choice)obj).index == index && ((Choice)obj).choice == choice;
	}

	public Object getObject() {
		return getTimelineWindow().getProvider().getAt(index, choice);
	}

}
