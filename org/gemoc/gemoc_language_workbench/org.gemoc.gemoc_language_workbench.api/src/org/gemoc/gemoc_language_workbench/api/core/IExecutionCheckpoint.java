package org.gemoc.gemoc_language_workbench.api.core;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Checkpoint allowing execution.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public interface IExecutionCheckpoint {

	/**
	 * Maps {@link ResourceSet} to {@link IExecutionCheckpoint}.
	 */
	Map<ResourceSet, IExecutionCheckpoint> CHECKPOINTS = new HashMap<ResourceSet, IExecutionCheckpoint>();

	/**
	 * Tells if execution is allowed.
	 * 
	 * @param allow
	 *            if <code>true</code> execution is allowed, forbidden otherwise
	 */
	void allow(boolean allow);
}
