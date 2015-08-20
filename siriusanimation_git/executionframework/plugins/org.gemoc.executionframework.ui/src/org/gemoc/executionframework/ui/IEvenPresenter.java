package org.gemoc.executionframework.ui;

import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * a class tha implement IEvenPresenter is a graphical UI that 
 * presents/displays {@link fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent
 * ModelSpecificEvent}
 * When asked it should highlight/focus on the requested  ModelSpecificEvent
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public interface IEvenPresenter {

	/**
	 * Ask the view to present or highlight the given {@link List} of
	 * {@link fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent ModelSpecificEvent}
	 * 
	 * @param events
	 *            {@link fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent ModelSpecificEvent} to highlight
	 */
	void present(List<URI> events);

}
