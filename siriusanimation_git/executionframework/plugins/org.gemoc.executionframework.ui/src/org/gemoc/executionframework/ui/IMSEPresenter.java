package org.gemoc.executionframework.ui;

import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * a class that implements IMSEPresenter is a graphical UI that 
 * presents or displays {@link fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent
 * ModelSpecificEvent}s
 * When asked it should highlight or focus on the requested  ModelSpecificEvents
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public interface IMSEPresenter {

	/**
	 * Ask the view to present or highlight the given {@link List} of
	 * {@link fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent ModelSpecificEvent}
	 * 
	 * @param events
	 *            {@link fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent ModelSpecificEvent} to highlight
	 */
	void present(List<URI> events);

}
