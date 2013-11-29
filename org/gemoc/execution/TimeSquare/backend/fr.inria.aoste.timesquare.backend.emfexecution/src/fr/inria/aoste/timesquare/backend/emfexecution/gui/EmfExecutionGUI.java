
/*****************************************************************************
 * Copyright (c) 2013 AOSTE I3S/UNS/INRIA.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Julien DeAntoni julien.deantoni@polytech.unice.fr (AOSTE I3S/UNS/INRIA) initial API and implementation
 *
 *****************************************************************************/

package fr.inria.aoste.timesquare.backend.emfexecution.gui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;

import fr.inria.aoste.timesquare.backend.emfexecution.Activator;
import fr.inria.aoste.timesquare.backend.emfexecution.manager.EmfCodeExecutionManager;
import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManager;
import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManagerGUI;
import fr.inria.aoste.timesquare.utils.ui.listeners.FileExtensionFilter;

public class EmfExecutionGUI extends BehaviorManagerGUI {

	private Composite container;

	private String _modelFilePath;

//	private ILabelProvider fLabelProvider = new WorkbenchLabelProvider();

	private ITreeContentProvider fContentProvider = new WorkbenchContentProvider();

	private String message = "choose the configuration file";

	private TreeViewer fViewer;

	private IStatus fCurrStatus = Status.OK_STATUS;

	private ISelectionStatusValidator fValidator = null;

	boolean fIsEmpty = false;

	
	
	public EmfExecutionGUI() {
	}

	protected Label createMessageArea(Composite composite) {
		Label label = new Label(composite, SWT.NONE);
		if (message != null) {
			label.setText(message);
		}
		label.setFont(composite.getFont());
		return label;
	}
	
	public final class SelectionConfFile implements ISelectionStatusValidator {
		public IStatus validate(Object[] selection) {
			boolean enableOK = false;
			if (selection!=null && selection.length != 0) {
				if ((selection[0] instanceof IFile)) {
					
					enableOK = true;

					return enableOK ?
							new Status(IStatus.OK, Activator.PLUGIN_ID, 0, "", null) :
							new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, "your file selection is incorrect", null);
				}
			}
			return 	new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, "please choose a file", null);
		}
	}

	protected TreeViewer createTreeViewer(Composite parent) {
		int style = SWT.BORDER | (SWT.SINGLE);

		fViewer = new TreeViewer(new Tree(parent, style));
		fViewer.setContentProvider(fContentProvider);
		fViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				result = (((IStructuredSelection) event.getSelection()).toList()).toArray();
				updateOKStatus();
			}
		});

		fViewer.addFilter(new FileExtensionFilter(new String[] { "emfExecConf" }));
		fValidator = new SelectionConfFile();
		fViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				updateOKStatus();

				if (!(fCurrStatus.isOK())) {
					ISelection selection = event.getSelection();
					if (selection instanceof IStructuredSelection) {
						Object item = ((IStructuredSelection) selection).getFirstElement();
						if (fViewer.getExpandedState(item)) {
							fViewer.collapseToLevel(item, 1);
						} else {
							fViewer.expandToLevel(item, 1);
						}
					}
				}
			}
		});
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		fViewer.setInput(root);

		return fViewer;
	}
	
	@Override
	public Point getMinimumSize() {	
		return new Point(350, 250);
	}

	@Override
	public void updateOKStatus() {
		if (!fIsEmpty) {
			if (fValidator != null) {
				fCurrStatus = fValidator.validate(getResult());
				if (dialog != null)
					dialog.updateStatus(fCurrStatus);
			} else {
				fCurrStatus = Status.OK_STATUS;
			}
		} else {
			fCurrStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "no file found", null);
		}
		if (dialog != null)
			dialog.updateStatus(fCurrStatus);
	}

	public Object[] getResult() {
		return result;
	}

	private Object[] result;

	Label messageLabel = null;

	/**
	 * @wbp.parser.entryPoint
	 */
	public Control createDialogArea(Composite composite) {
		try {
			if (composite == null) {
				return null;
			}
			container = composite;
			messageLabel = createMessageArea(container);
			TreeViewer treeViewer = createTreeViewer(container);
			GridData data = new GridData(GridData.FILL_BOTH);
			data.minimumHeight = 250;
			data.minimumWidth = 450;
			Tree treeWidget = treeViewer.getTree();
			treeWidget.setLayoutData(data);
			treeWidget.setFont(composite.getFont());

			_modelFilePath = "";
			if (getBehaviorManager().getConfigurationIFile() != null) {
				treeViewer.setSelection(new StructuredSelection(getBehaviorManager().getConfigurationIFile()));
			}
			return container;
		} catch (Exception e) {
			System.err.println("Error");
		}
		return composite;
	}

	public void okPressed() {
		try {

			addClockBehavior();
		} catch (Throwable e) {
			e.printStackTrace();
			System.err.print(e.getMessage());
		}
	}

	public void addClockBehavior() throws Throwable {
		if (getResult() != null && getResult().length != 0) {
			_modelFilePath = ((IFile) getResult()[0]).getFullPath().toString();
		}
		if (_modelFilePath != null && _modelFilePath.length() != 0) {
			getBehaviorManager().setModelFileName(_modelFilePath);			
			getBehaviorManager().manageBehavior(_configurationHelper);
		} else {
			System.err.println("Error in add");
		}
	}

	@Override
	protected EmfCodeExecutionManager getBehaviorManager() {
		return (EmfCodeExecutionManager) super.getBehaviorManager();
	}

	@Override
	public void setBehaviorManager(BehaviorManager behaviorManager) {
		if (behaviorManager instanceof EmfCodeExecutionManager)
			super.setBehaviorManager(behaviorManager);
	}

	public void cancelPressed() {
	}

}
