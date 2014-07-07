package org.gemoc.execution.engine.core;

import fr.inria.aoste.trace.LogicalStep;

/**
 * Animator interface.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 * 
 */
public interface IGemocModelAnimator {

	/**
	 * Activates the given {@link LogicalStep}.
	 * 
	 * @param step
	 *            the {@link LogicalStep}
	 * @param context
	 *            the context {@link Object}
	 */
	void activate(Object context, LogicalStep step);

	/**
	 * Clears {@link IGemocModelAnimator#activate(LogicalStep) activated}
	 * {@link LogicalStep}.
	 * 
	 * @param context
	 *            the context {@link Object}
	 */
	void clear(Object context);

}
