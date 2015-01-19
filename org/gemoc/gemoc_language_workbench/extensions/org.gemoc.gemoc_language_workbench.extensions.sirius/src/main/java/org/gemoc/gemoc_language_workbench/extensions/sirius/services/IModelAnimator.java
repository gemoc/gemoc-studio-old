package org.gemoc.gemoc_language_workbench.extensions.sirius.services;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

/**
 * Animator interface.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 * 
 */
public interface IModelAnimator extends IEngineAddon {

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
	 * Clears {@link IModelAnimator#activate(LogicalStep) activated}
	 * {@link LogicalStep}.
	 * 
	 * @param context
	 *            the context {@link Object}
	 */
	void clear(Object context);

}
