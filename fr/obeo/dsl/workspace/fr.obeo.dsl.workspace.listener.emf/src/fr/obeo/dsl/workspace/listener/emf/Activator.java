/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package fr.obeo.dsl.workspace.listener.emf;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Activator extends Plugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "fr.obeo.dsl.workspace.listener.emf"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static Activator plugin;

	/**
	 * Constructor.
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Log an informative message into the Eclipse log file.
	 * 
	 * @param message
	 *            the message to log
	 */
	public void info(String message) {
		log(message, IStatus.INFO);
	}

	/**
	 * Log a debug message into the Eclipse log file.
	 * 
	 * @param message
	 *            the message to log
	 */
	public void debug(String message) {
		if (isDebugEnabled()) {
			log("[DEBUG] " + message, IStatus.INFO);
		}
	}

	/**
	 * Test if the platform is in debug mode.
	 * 
	 * @return True if the platform is in debug mode.
	 */
	public boolean isDebugEnabled() {
		if (plugin != null) {
			return Platform.inDebugMode();
		}

		return false;
	}

	/**
	 * Log a message with given level into the Eclipse log file.
	 * 
	 * @param message
	 *            the message to log
	 * @param level
	 *            the message priority
	 */
	private void log(String message, int level) {
		log(new Status(level, PLUGIN_ID, message));
	}

	/**
	 * Logs the given {@link Status}.
	 * 
	 * @param status
	 *            the {@link Status}
	 */
	private void log(IStatus status) {

		if (plugin == null) {
			// TODO Do log with java ?
		} else {
			plugin.getLog().log(status);
		}
	}

	/**
	 * Log a warning message.
	 * 
	 * @param message
	 *            the exception to log
	 */
	public void warn(String message) {
		log(message, IStatus.WARNING);
	}

	/**
	 * Log an exception into the Eclipse log file.
	 * 
	 * @param e
	 *            the exception to log
	 */
	public void error(Throwable e) {
		error("Unexpected Error", e);
	}

	/**
	 * Log an exception into the Eclipse log file.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the exception to log
	 */
	public void error(String message, Throwable e) {

		Throwable t = e;
		if (e instanceof InvocationTargetException) {
			t = ((InvocationTargetException)e).getTargetException();
		}

		IStatus status;
		if (t instanceof CoreException) {
			status = ((CoreException)t).getStatus();
		} else {
			status = new Status(IStatus.ERROR, PLUGIN_ID, message, e);
		}

		log(status);
	}

}
