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
package org.gemoc.gemoc_language_workbench.guideline.process;

import fr.obeo.dsl.workspace.listener.WorkspaceUtils;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.guideline.process.specific.GemocLanguageDiscovery;
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
	public static final String PLUGIN_ID = "org.gemoc.gemoc_language_workbench.guideline.process"; //$NON-NLS-1$

	/**
	 * The {@link Activator}.
	 */
	private static Activator plugin;

	/**
	 * The {@link GemocLanguageDiscovery}.
	 */
	private GemocLanguageDiscovery processDiscovery;

	/**
	 * Constructor.
	 */
	public Activator() {
	}

	/**
	 * Gets the {@link GemocLanguageDiscovery}.
	 * 
	 * @return the {@link GemocLanguageDiscovery}
	 */
	public GemocLanguageDiscovery getProcessDiscovery() {
		return processDiscovery;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		processDiscovery = new GemocLanguageDiscovery();
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		WorkspaceUtils.getListener(activeWorkbenchWindow.getActivePage())
				.addProcessor(processDiscovery, true);
		WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace()).addProcessor(processDiscovery, true);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		processDiscovery.stop();
		WorkspaceUtils.removeProcessor(processDiscovery);

		final IWorkbench workbench = PlatformUI.getWorkbench();
		final IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			WorkspaceUtils.getListener(activeWorkbenchWindow.getActivePage()).removeProcessor(
					processDiscovery);
		}
		WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace()).removeProcessor(processDiscovery);

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
