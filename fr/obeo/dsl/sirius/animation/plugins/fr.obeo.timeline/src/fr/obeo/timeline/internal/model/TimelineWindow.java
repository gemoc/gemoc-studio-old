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

import fr.obeo.timeline.view.ITimelineListener;
import fr.obeo.timeline.view.ITimelineProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * A window over a large timeline.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TimelineWindow implements ITimelineListener {

	/**
	 * The {@link ITimelineProvider} used to populate the model.
	 */
	private ITimelineProvider provider;

	/**
	 * The {@link List} of {@link ITimelineListener} to notify.
	 */
	private List<ITimelineWindowListener> listeners = new ArrayList<ITimelineWindowListener>();

	/**
	 * The start index.
	 */
	private int start;

	/**
	 * The length of the window.
	 */
	private int length;

	/**
	 * The maximum index of a connected choice.
	 */
	private int maxConnectionIndex = -1;

	/**
	 * Constructor.
	 * 
	 * @param providier
	 *            the {@link ITimelineProvider} used to populate the model
	 */
	public TimelineWindow(ITimelineProvider providier) {
		this.provider = providier;
	}

	/**
	 * Gets the {@link ITimelineProvider}.
	 * 
	 * @return the {@link ITimelineProvider}
	 */
	public ITimelineProvider getProvider() {
		return provider;
	}

	/**
	 * Gets the {@link List} of {@link Tic}.
	 * 
	 * @return the {@link List} of {@link Tic}
	 */
	public List<Tic> getTics() {
		final List<Tic> res = new ArrayList<Tic>();

		final int end = Math.min(getStart() + getLength(), getProvider().getNumberOfTicks());
		for (int i = getStart(); i < end; ++i) {
			res.add(new Tic(this, i));
		}

		return res;
	}

	/**
	 * Gets the maximum connected choice index.
	 * 
	 * @return the maximum connected choice index
	 */
	public int getMaxConnectionIndex() {
		if (maxConnectionIndex < 0) {
			final int end = Math.min(getEnd(), getProvider().getNumberOfTicks());
			for (int tic = 0; tic < end; ++tic) {
				final int numberOfchoicesAt = getProvider().getNumberOfchoicesAt(tic);
				for (int choice = 0; choice < numberOfchoicesAt; ++choice) {
					if (getProvider().getPreceding(tic, choice) > 0
							|| getProvider().getFollowing(tic, choice) > 0) {
						maxConnectionIndex = Math.max(maxConnectionIndex, choice);
					}
				}
			}
		}
		return maxConnectionIndex;
	}

	/**
	 * Gets the start index.
	 * 
	 * @return the start index
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Sets the start index.
	 * 
	 * @param start
	 *            the new start index
	 */
	public void setStart(int start) {
		maxConnectionIndex = -1;
		if (this.start != start) {
			this.start = start;
			for (ITimelineWindowListener listener : listeners) {
				listener.startChanged(start);
			}
		}
	}

	/**
	 * Gets the length of the window.
	 * 
	 * @return the length of the window
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Gets the end index.
	 * 
	 * @return the end index
	 */
	public int getEnd() {
		return getStart() + getLength();
	}

	/**
	 * Sets the length of the window.
	 * 
	 * @param length
	 *            the length of the window
	 */
	public void setLength(int length) {
		maxConnectionIndex = -1;
		if (this.length != length) {
			this.length = length;
			for (ITimelineWindowListener listener : listeners) {
				listener.lengthChanged(length);
			}
		}
	}

	/**
	 * Sets a new {@link ITimelineProvider}.
	 * 
	 * @param provider
	 *            the {@link ITimelineProvider}
	 */
	public void setProvider(ITimelineProvider provider) {
		if (!this.provider.equals(provider)) {
			this.provider = provider;
			for (ITimelineWindowListener listener : listeners) {
				listener.providerChanged(provider);
			}
			setStart(0);
		}
	}

	/**
	 * Tells if the given index is in the {@link TimelineWindow}.
	 * 
	 * @param index
	 *            the index to check
	 * @return <code>true</code> if the given index is in the {@link TimelineWindow}, <code>false</code>
	 *         otherwise
	 */
	private boolean isInWindow(int index) {
		return getStart() <= index && index < getEnd();
	}

	/**
	 * Adds a {@link ITimelineWindowListener}.
	 * 
	 * @param listener
	 *            the {@link ITimelineWindowListener}
	 */
	public void addTimelineWindowListener(ITimelineWindowListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes a {@link ITimelineWindowListener}.
	 * 
	 * @param listener
	 *            the {@link ITimelineWindowListener}
	 */
	public void removeTimelineWindowListener(ITimelineWindowListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void numberOfticksChanged(int numberOfticks) {
		for (ITimelineWindowListener listener : listeners) {
			listener.numberOfticksChanged(numberOfticks);
		}
	}

	@Override
	public void numberOfchoicesAtChanged(int index, int numberOfChoice) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.numberOfchoicesAtChanged(index, numberOfChoice);
			}
		}
	}

	@Override
	public void textAtChanged(int index, String text) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.textAtChanged(index, text);
			}
		}
	}

	@Override
	public void atChanged(int index, int choice, Object object) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.atChanged(index, choice, object);
			}
		}
	}

	@Override
	public void isSelectedChanged(int index, int choice, boolean selected) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.isSelectedChanged(index, choice, selected);
			}
		}
	}

	@Override
	public void textAtChanged(int index, int choice, String text) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.textAtChanged(index, choice, text);
			}
		}
	}

	@Override
	public void followingChanged(int index, int choice, int following) {
		if (isInWindow(index) && isInWindow(index + 1)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.followingChanged(index, choice, following);
			}
		}
	}

	@Override
	public void precedingChanged(int index, int choice, int preceding) {
		if (isInWindow(index - 1) && isInWindow(index)) {
			for (ITimelineWindowListener listener : listeners) {
				listener.precedingChanged(index, choice, preceding);
			}
		}
	}

}
