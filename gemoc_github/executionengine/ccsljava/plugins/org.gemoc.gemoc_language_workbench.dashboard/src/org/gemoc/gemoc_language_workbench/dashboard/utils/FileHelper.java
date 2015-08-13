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
package org.gemoc.gemoc_language_workbench.dashboard.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

public class FileHelper {

	/**
	 * Read file as a string.
	 * 
	 * @param filePath_p
	 *            File path relative to the plug-in, plug-in id included.<br>
	 *            See {@link #getFileFullUrl(String)} documentation.
	 * @return If an error occurred {@link ICommonConstants#EMPTY_STRING} is returned.
	 */
	public static String readFile(String filePath_p) {
		byte[] rawContent = readRawFile(filePath_p);
		String result = (0 == rawContent.length) ? ICommonConstants.EMPTY_STRING : new String(rawContent);
		return result;
	}

	/**
	 * Read file as an array of bytes.
	 * 
	 * @param filePath_p
	 *            File path relative to the plug-in, plug-in id included.<br>
	 *            See {@link #getFileFullUrl(String)} documentation.
	 * @return a not null array.
	 */
	public static byte[] readRawFile(String filePath_p) {
		byte[] result = null;
		// Get stream from file.
		InputStream inputStream = getFileAsStream(filePath_p);
		// Ensure the input stream got from the file path is not null.
		if (null != inputStream) {
			result = readFile(inputStream);
		}
		return (null == result) ? new byte[0] : result;
	}

	/**
	 * Get file as a stream.
	 * 
	 * @param filePath_p
	 *            File path relative to the plug-in, plug-in id included.<br>
	 *            See {@link #getFileFullUrl(String)} documentation.
	 * @return If an error occurred null is returned.
	 */
	public static InputStream getFileAsStream(String filePath_p) {
		InputStream result = null;
		// Get input stream.
		URL fileURL = getFileFullUrl(filePath_p);
		try {
			result = fileURL.openStream();
		} catch (Exception exception_p) {
			StringBuilder loggerMessage = new StringBuilder("FileHelper.getFileAsStream(..) _ "); //$NON-NLS-1$
			loggerMessage.append("Failed to load ").append(filePath_p); //$NON-NLS-1$
			exception_p.printStackTrace();
		}
		return result;
	}

	/**
	 * Get file full url from relative one.
	 * 
	 * @param fileRelativePath_p
	 *            File path relative to workspace.<br>
	 *            It <b>must</b> start with <i>pluginId</i> or <i>project name</i>. It is also recommended
	 *            that both plug-in id and plug-in project names are the same.<br>
	 *            As a convenience, the full path will refer to the plug-in id.<br>
	 *            <b>Example</b> : <i>org.polarsys.capella.common.mdsofa/model/example.ecore</i> is a path
	 *            relative to the workspace that refers to the <i>org.polarsys.capella.common.mdsofa
	 *            plug-in</i>, having a <i>model/example.ecore</i> file in its project.<br>
	 *            In Eclipse resource system, such a path is considered as an absolute one against the
	 *            workspace root.<br>
	 *            It's still referred to as a relative path, since the returned URL is absolute in the file
	 *            system.
	 * @return
	 */
	public static URL getFileFullUrl(String fileRelativePath_p) {
		// Get the URI for given relative path.
		return getFileFullUrl(getFileFullUri(fileRelativePath_p));
	}

	/**
	 * Get a file uri from relative one which is not resolved against the eclipse platform.<br>
	 * The returned uri starts with either 'platform:/plug-in/' or 'platform:/resource/'.
	 * 
	 * @param fileRelativePath_p
	 *            File path relative to workspace.<br>
	 *            It <b>must</b> start with <code>project name</code> or <i>pluginId</i>. It is also
	 *            recommended that both plug-in id and plug-in project names are the same.<br>
	 *            As a convenience, the full path will refer to the plug-in id.<br>
	 *            <b>Example</b> : <i>org.polarsys.capella.common.mdsofa/model/example.ecore</i> is a path
	 *            relative to the workspace that refers to the <i>org.polarsys.capella.common.mdsofa
	 *            plug-in</i>, having a <i>model/example.ecore</i> file in its project.
	 * @return an {@link URI} not resolved against the eclipse platform.<br>
	 */
	public static URI getFileFullUri(String fileRelativePath_p) {
		URI fileUri = null;
		// Precondition.
		if (null == fileRelativePath_p) {
			return fileUri;
		}
		// Find project from relative first segment.
		IPath path = new Path(fileRelativePath_p);
		IProject project = getProject(path.segment(0));
		if ((null != project) && project.exists()) { // Project found, the file is in the workspace.
			fileUri = URI.createPlatformResourceURI(fileRelativePath_p, true);
		} else { // Resource not found, the file is deployed elsewhere.
			fileUri = URI.createPlatformPluginURI(fileRelativePath_p, true);
		}
		return fileUri;
	}

	/**
	 * Get project from its name.<br>
	 * It is assumed that this project name refers to a plug-in.<br>
	 * If not, the method <code>ResourcesPlugin.getWorkspace().getRoot().getProject(projectName_p)</code> is
	 * invoked as result.
	 * 
	 * @param projectName_p
	 *            A project name that points to a plug-in in the workspace.
	 * @return
	 */
	public static IProject getProject(String projectName_p) {
		IProject result = null;
		// Precondition.
		if (null == projectName_p) {
			return result;
		}
		// Get model base from project name.
		IPluginModelBase modelBase = PluginRegistry.findModel(projectName_p);
		// Precondition.
		// Warning : fix for the Eclipse platform bug that consists in having PDE in a weird state
		// regarding in-development plug-ins from launching platform as deployed ones in current one.
		if (null == modelBase) {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName_p);
		}
		result = getProject(modelBase);
		return result;
	}

	/**
	 * Get the IProject for specified plug-in model.
	 * 
	 * @param pluginModelBase_p
	 * @return null if the plug-in is not in the workspace.
	 */
	public static IProject getProject(IPluginModelBase pluginModelBase_p) {
		IProject result = null;
		// Precondition.
		if (null != pluginModelBase_p) {
			IResource underlyingResource = pluginModelBase_p.getUnderlyingResource();
			if (null != underlyingResource) {
				// Retrieve project from the model.
				result = underlyingResource.getProject();
			}
		}
		return result;
	}

	/**
	 * Get file full url from its full uri.<br>
	 * See {@link #getFileFullUri(String)} method.
	 * 
	 * @param fileFullUri_p
	 * @return
	 */
	public static URL getFileFullUrl(URI fileFullUri_p) {
		URL result = null;
		// Resolve url from returned uri.
		try {
			result = FileLocator.resolve(new URL(fileFullUri_p.toString()));
		} catch (Exception exception_p) {
			StringBuilder loggerMessage = new StringBuilder("FileHelper.getFileFullPath(..) _ "); //$NON-NLS-1$
			loggerMessage.append("Unable to resolve the url for ").append(fileFullUri_p.toString()); //$NON-NLS-1$
			exception_p.printStackTrace();
		}
		return result;
	}

	/**
	 * Read given input stream as an array of bytes.
	 * 
	 * @param inputStream_p
	 * @return a not null array.
	 */
	public static byte[] readFile(InputStream inputStream_p) {
		byte[] buffer = null;
		try {
			// Available bytes to read.
			int sizeToRead = inputStream_p.available();
			// Allocate a new buffer with the right size.
			buffer = new byte[sizeToRead];
			// Read bytes from the input stream.
			int readBytes = inputStream_p.read(buffer);
			// Total read bytes count.
			int totalReadBytes = readBytes;
			// Read again, if available bytes remain.
			while (readBytes != -1 && (totalReadBytes < sizeToRead)) {
				readBytes = inputStream_p.read(buffer, totalReadBytes, sizeToRead - totalReadBytes);
				// Add readBytes to the total read bytes count.
				if (readBytes != -1) {
					totalReadBytes += readBytes;
				}
			}
		} catch (Exception exception_p) {
			StringBuilder loggerMessage = new StringBuilder("FileHelper.readFile(..) _ "); //$NON-NLS-1$
			loggerMessage.append("Failed to read the input stream ! "); //$NON-NLS-1$
			exception_p.printStackTrace();
		} finally {
			if (null != inputStream_p) {
				try {
					inputStream_p.close();
				} catch (IOException exception_p) {
					StringBuilder loggerMessage = new StringBuilder("FileHelper.readFile(..) _ "); //$NON-NLS-1$
					loggerMessage.append("Failed to close input stream ! "); //$NON-NLS-1$
					exception_p.printStackTrace();
				}
			}
		}
		// Ensure to return a not null array.
		return (null == buffer) ? new byte[0] : buffer;
	}
}
