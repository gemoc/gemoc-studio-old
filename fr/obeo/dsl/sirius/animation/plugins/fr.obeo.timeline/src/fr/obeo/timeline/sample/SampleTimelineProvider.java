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
package fr.obeo.timeline.sample;

import fr.obeo.timeline.view.AbstractTimelineProvider;

/**
 * A sample {@link fr.obeo.timeline.view.ITimelineProvider ITimelineProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SampleTimelineProvider extends AbstractTimelineProvider {

	/**
	 * The size of the sample timeline.
	 */
	private static final int SIZE = 100000;

	/**
	 * Sizes of tics.
	 */
	private final int[] choices;

	/**
	 * Selected choice.
	 */
	private final int[] selected;

	int size;

	/**
	 * Constructor.
	 */
	public SampleTimelineProvider() {
		choices = new int[SIZE];
		selected = new int[SIZE];
		for (int i = 0; i < choices.length; ++i) {
			choices[i] = -1; // no choices
			selected[i] = -1; // no selection
		}

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (size = 1; size <= choices.length; ++size) {
					notifyNumberOfticksChanged(size);
					final int index = size - 1;
					try {
						Thread.sleep(300);
						final int nbChoices = 1 + (int)(Math.random() * 5);
						choices[index] = nbChoices; // create choices
						notifyNumberOfchoicesAtChanged(index, nbChoices);
						Thread.sleep(300);
						selected[index] = (int)(Math.random() * nbChoices); // make a selection
						notifyIsSelectedChanged(index, selected[index], true);
						Thread.sleep(150);
						if (index - 1 >= 0) {
							notifyFollowingChanged(index - 1, selected[index - 1], selected[index]);
							Thread.sleep(150);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		};
		new Thread(runnable).start();
	}

	@Override
	public int getNumberOfTicks() {
		return size;
	}

	@Override
	public int getNumberOfchoicesAt(int index) {
		return choices[index];
	}

	@Override
	public String getTextAt(int index) {
		return String.valueOf(index);
	}

	@Override
	public Object getAt(int index, int choice) {
		return "something";
	}

	@Override
	public Object getAt(int index) {
		return "something";
	}

	@Override
	public int getSelectedChoice(int index) {
		return selected[index];
	}

	@Override
	public String getTextAt(int index, int choice) {
		return "choice " + choice;
	}

	@Override
	public int getFollowing(int index, int choice) {
		final int res;

		if (index < getNumberOfTicks() - 1 && choice == selected[index]) {
			res = selected[index + 1];
		} else {
			res = -1;
		}

		return res;
	}

	@Override
	public int getPreceding(int index, int choice) {
		final int res;

		if (index > 0 && choice == selected[index]) {
			res = selected[index - 1];
		} else {
			res = -1;
		}

		return res;
	}

}
