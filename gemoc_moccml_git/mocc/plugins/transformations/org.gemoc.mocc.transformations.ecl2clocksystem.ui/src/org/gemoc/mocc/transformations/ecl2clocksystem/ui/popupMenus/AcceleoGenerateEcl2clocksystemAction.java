/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.gemoc.mocc.transformations.ecl2clocksystem.ui.popupMenus;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.gemoc.mocc.transformations.ecl2clocksystem.ui.Activator;
import org.gemoc.mocc.transformations.ecl2clocksystem.ui.common.GenerateAll;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

/**
 * Ecl2clocksystem code generation.
 */
public class AcceleoGenerateEcl2clocksystemAction extends ActionDelegate implements IActionDelegate {
	
	/**
	 * Input model file
	 */
	IFile model = null;
	
	/**
	 * Generation folder
	 */
	public static final String GEN_FOLDER="clocksystem-gen";
	
	/**
	 * Selected model files.
	 */
	protected List<IFile> files;

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.ui.actions.ActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			files = ((IStructuredSelection) selection).toList();
		}
	}
	

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.ui.actions.ActionDelegate#run(org.eclipse.jface.action.IAction)
	 * @generated
	 */
	public void run(IAction action) {
		if (files != null) {
			IRunnableWithProgress operation = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					try {
						Iterator<IFile> filesIt = files.iterator();
						while (filesIt.hasNext()) {
							model = (IFile)filesIt.next();
							URI modelURI = URI.createPlatformResourceURI(model.getFullPath().toString(), true);
							try {
								IContainer target = model.getProject().getFolder(GEN_FOLDER);
								GenerateAll generator = new GenerateAll(modelURI, target, getArguments());
								generator.doGenerate(monitor);
								
							} catch (IOException e) {
								IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
								Activator.getDefault().getLog().log(status);
							} finally {
								model.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
							}
						}
					} catch (CoreException e) {
						IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
						Activator.getDefault().getLog().log(status);
					}
				}
			};
			try {
				PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
			} catch (InvocationTargetException e) {
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				Activator.getDefault().getLog().log(status);
			} catch (InterruptedException e) {
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				Activator.getDefault().getLog().log(status);
			}
		}
	}

	/**
	 * Computes the arguments of the generator.
	 * 
	 * @return the arguments
	 * @generated NOT
	 */
	protected List<? extends Object> getArguments() {
		final List<String> arguments = new ArrayList<String>();
		try {
			IFile propertyFile = model.getProject().getFile("moc2as.properties");
			if(!propertyFile.exists()){
				return null;
			}
			Properties properties = new Properties();
			properties.load(propertyFile.getContents());
			
			String rootElement = properties.getProperty("rootElement");
			if(rootElement==null || rootElement.isEmpty()){
				return null;
			}
			
			String uristring = model.getLocation().toOSString();
		    final URI uri = URI.createFileURI(uristring);

			String targetFileName = uri.lastSegment().replace(".ecl",	"_toClockSystem.mtl");
			arguments.add(targetFileName);
			arguments.add(rootElement); 
			
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} catch (CoreException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		}
		return arguments;
	}

}