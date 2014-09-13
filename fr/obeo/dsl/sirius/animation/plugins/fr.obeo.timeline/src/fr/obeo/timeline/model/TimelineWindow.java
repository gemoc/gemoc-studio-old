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
	private final List<ITimelineWindowListener> listeners = new ArrayList<ITimelineWindowListener>();

	/**
	 * The start index.
	 */
	private int start;

	/**
	 * The length of the window.
	 */
	private int length;

	/**
	 * The maximum index of the selected possible step.
	 */
	private int maxSelectedIndex = -1;

	/**
	 * Constructor.
	 * 
	 * @param provider
	 *            the {@link ITimelineProvider} used to populate the model
	 */
	public TimelineWindow(ITimelineProvider provider) {
		setProvider(provider, 0);
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
	 * Gets the {@link List} of {@link Choice}.
	 * 
	 * @return the {@link List} of {@link Choice}
	 */
	public List<Choice> getChoices() {
		final List<Choice> res = new ArrayList<Choice>();

		if (getProvider() != null) {
			final int begin = getStart();
			final int end = Math.min(begin + getLength(), getProvider().getNumberOfChoices());
			for (int i = begin; i < end; ++i) {
				res.add(new Choice(this, i));
			}
		}

		return res;
	}

	/**
	 * Gets the maximum selected possible step index.
	 * 
	 * @return the maximum selected possible step index
	 */
	public int getMaxSelectedIndex() {
		if (maxSelectedIndex < 0) {
			final int end = Math.min(getEnd(), getProvider().getNumberOfChoices());
			for (int choice = 0; choice < end; ++choice) {
				maxSelectedIndex = Math.max(maxSelectedIndex, getProvider().getSelectedPossibleStep(choice));
			}
		}
		return maxSelectedIndex;
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
		maxSelectedIndex = -1;
		if (this.start != start) {
			this.start = start;
			for (ITimelineWindowListener listener : getListeners()) {
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
		maxSelectedIndex = -1;
		if (this.length != length) {
			this.length = length;
			for (ITimelineWindowListener listener : getListeners()) {
				listener.lengthChanged(length);
			}
		}
	}

	/**
	 * Sets a new {@link ITimelineProvider}.
	 * 
	 * @param newProvider
	 *            the {@link ITimelineProvider}
	 * @param newStart
	 *            the new start
	 */
	public void setProvider(ITimelineProvider newProvider, int newStart) {
		if ((this.provider != null && !this.provider.equals(newProvider))
				|| (newProvider != null && !newProvider.equals(this.provider))) {
			if (this.provider != null) {
				this.provider.removeTimelineListener(this);
			}
			this.provider = newProvider;
			if (this.provider != null) {
				this.provider.addTimelineListener(this);
				for (ITimelineWindowListener listener : getListeners()) {
					listener.providerChanged(newProvider);
				}
				maxSelectedIndex = -1;
				if (newStart >= 0 && newStart <= provider.getNumberOfChoices()) {
					setStart(newStart);
				}
			}
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
		synchronized(listeners) {
			listeners.add(listener);
		}
	}

	/**
	 * Removes a {@link ITimelineWindowListener}.
	 * 
	 * @param listener
	 *            the {@link ITimelineWindowListener}
	 */
	public void removeTimelineWindowListener(ITimelineWindowListener listener) {
		synchronized(listeners) {
			listeners.remove(listener);
		}
	}

	@Override
	public void numberOfChoicesChanged(int numberOfChoices) {
		if (isInWindow(numberOfChoices)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.numberOfChoicesChanged(numberOfChoices);
			}
		}
	}

	@Override
	public void numberOfPossibleStepsAtChanged(int index, int numberOfPossibleStep) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.numberOfPossibleStepsAtChanged(index, numberOfPossibleStep);
			}
		}
	}

	@Override
	public void textAtChanged(int index, String text) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.textAtChanged(index, text);
			}
		}
	}

	@Override
	public void atChanged(int index, int possibleStep, Object object) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.atChanged(index, possibleStep, object);
			}
		}
	}

	@Override
	public void isSelectedChanged(int index, int possibleStep, boolean selected) {
		if (isInWindow(index)) {
			maxSelectedIndex = Math.max(maxSelectedIndex, possibleStep);
			for (ITimelineWindowListener listener : getListeners()) {
				listener.isSelectedChanged(index, possibleStep, selected);
			}
		}
	}

	@Override
	public void textAtChanged(int index, int possibleStep, String text) {
		if (isInWindow(index)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.textAtChanged(index, possibleStep, text);
			}
		}
	}

	@Override
	public void followingChanged(int index, int possibleStep, int following) {
		if (isInWindow(index) && isInWindow(index + 1)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.followingChanged(index, possibleStep, following);
			}
		}
	}

	@Override
	public void precedingChanged(int index, int possibleStep, int preceding) {
		if (isInWindow(index - 1) && isInWindow(index)) {
			for (ITimelineWindowListener listener : getListeners()) {
				listener.precedingChanged(index, possibleStep, preceding);
			}
		}
	}

	/**
	 * Gets the {@link List} of {@link ITimelineWindowListener}.
	 * 
	 * @return the {@link List} of {@link ITimelineWindowListener}
	 */
	private List<ITimelineWindowListener> getListeners() {
		final List<ITimelineWindowListener> l;
		synchronized(listeners) {
			l = new ArrayList<ITimelineWindowListener>(listeners);
		}
		return l;
	}

}
