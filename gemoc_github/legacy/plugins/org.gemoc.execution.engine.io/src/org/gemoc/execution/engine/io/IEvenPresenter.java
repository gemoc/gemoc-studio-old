package org.gemoc.execution.engine.io;

import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * Presents {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event
 * Event}
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public interface IEvenPresenter {

	/**
	 * Presents the given {@link List} of
	 * {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event Event}
	 * 
	 * @param events
	 *            {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event
	 *            Event}
	 */
	void present(List<URI> events);

}
