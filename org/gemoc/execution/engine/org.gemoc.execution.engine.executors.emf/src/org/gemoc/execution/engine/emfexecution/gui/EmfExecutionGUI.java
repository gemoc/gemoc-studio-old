/*****************************************************************************
 * Copyright (c) 2013 AOSTE I3S/UNS/INRIA.
 * 
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Julien DeAntoni julien.deantoni@polytech.unice.fr (AOSTE
 * I3S/UNS/INRIA) initial API and implementation
 * 
 *****************************************************************************/

package org.gemoc.execution.engine.emfexecution.gui;

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
import org.gemoc.execution.engine.emfexecution.Activator;
import org.gemoc.execution.engine.emfexecution.manager.EmfCodeExecutionManager;

import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManager;
import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManagerGUI;
import fr.inria.aoste.timesquare.utils.ui.listeners.FileExtensionFilter;

public class EmfExecutionGUI extends BehaviorManagerGUI {

    public final class SelectionConfFile implements ISelectionStatusValidator {
        @Override
        public IStatus validate(Object[] selection) {
            boolean enableOK = false;
            if (selection != null && selection.length != 0) {
                if ((selection[0] instanceof IFile)) {

                    enableOK = EmfExecutionGUI.this.getBehaviorManager().loadJarFile((IFile) selection[0]);

                    return enableOK ? new Status(IStatus.OK, Activator.PLUGIN_ID, 0, "", null) : new Status(
                            IStatus.ERROR, Activator.PLUGIN_ID, 0, "your file selection is incorrect", null);
                }
            }
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, "please choose a file", null);
        }
    }

    private Composite container;

    // private ILabelProvider fLabelProvider = new WorkbenchLabelProvider();

    private String _confFilePath;

    private ITreeContentProvider fContentProvider = new WorkbenchContentProvider();

    private String message = "choose emf execution configuration file";

    private TreeViewer fViewer;

    private IStatus fCurrStatus = Status.OK_STATUS;

    private ISelectionStatusValidator fValidator = null;

    boolean fIsEmpty = false;

    private Object[] result;

    Label messageLabel = null;

    public EmfExecutionGUI() {
    }

    public void addClockBehavior() throws Throwable {
        if (this.getResult() != null && this.getResult().length != 0) {
            this._confFilePath = ((IFile) this.getResult()[0]).getFullPath().toString();
        }
        if (this._confFilePath != null && this._confFilePath.length() != 0) {
            this.getBehaviorManager().setConfigurationFileName(this._confFilePath);
            this.getBehaviorManager().manageBehavior(this._configurationHelper);
        } else {
            System.err.println("Error in add");
        }
    }

    @Override
    public void cancelPressed() {
    }

    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public Control createDialogArea(Composite composite) {
        try {
            if (composite == null) {
                return null;
            }
            this.container = composite;
            this.messageLabel = this.createMessageArea(this.container);
            TreeViewer treeViewer = this.createTreeViewer(this.container);
            GridData data = new GridData(GridData.FILL_BOTH);
            data.minimumHeight = 250;
            data.minimumWidth = 450;
            Tree treeWidget = treeViewer.getTree();
            treeWidget.setLayoutData(data);
            treeWidget.setFont(composite.getFont());

            this._confFilePath = "";
            if (this.getBehaviorManager().getConfigurationIFile() != null) {
                treeViewer.setSelection(new StructuredSelection(this.getBehaviorManager().getConfigurationIFile()));
            }
            return this.container;
        } catch (Exception e) {
            System.err.println("Error");
        }
        return composite;
    }

    protected Label createMessageArea(Composite composite) {
        Label label = new Label(composite, SWT.NONE);
        if (this.message != null) {
            label.setText(this.message);
        }
        label.setFont(composite.getFont());
        return label;
    }

    protected TreeViewer createTreeViewer(Composite parent) {
        int style = SWT.BORDER | (SWT.SINGLE);

        this.fViewer = new TreeViewer(new Tree(parent, style));
        this.fViewer.setContentProvider(this.fContentProvider);
        this.fViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                EmfExecutionGUI.this.result = (((IStructuredSelection) event.getSelection()).toList()).toArray();
                EmfExecutionGUI.this.updateOKStatus();
            }
        });

        this.fViewer.addFilter(new FileExtensionFilter(new String[] { "emfExecConf" }));
        this.fValidator = new SelectionConfFile();
        this.fViewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                EmfExecutionGUI.this.updateOKStatus();

                if (!(EmfExecutionGUI.this.fCurrStatus.isOK())) {
                    ISelection selection = event.getSelection();
                    if (selection instanceof IStructuredSelection) {
                        Object item = ((IStructuredSelection) selection).getFirstElement();
                        if (EmfExecutionGUI.this.fViewer.getExpandedState(item)) {
                            EmfExecutionGUI.this.fViewer.collapseToLevel(item, 1);
                        } else {
                            EmfExecutionGUI.this.fViewer.expandToLevel(item, 1);
                        }
                    }
                }
            }
        });
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        this.fViewer.setInput(root);

        return this.fViewer;
    }

    @Override
    protected EmfCodeExecutionManager getBehaviorManager() {
        return (EmfCodeExecutionManager) super.getBehaviorManager();
    }

    @Override
    public Point getMinimumSize() {
        return new Point(350, 250);
    }

    public Object[] getResult() {
        return this.result;
    }

    @Override
    public void okPressed() {
        try {

            this.addClockBehavior();
        } catch (Throwable e) {
            e.printStackTrace();
            System.err.print(e.getMessage());
        }
    }

    @Override
    public void setBehaviorManager(BehaviorManager behaviorManager) {
        if (behaviorManager instanceof EmfCodeExecutionManager) {
            super.setBehaviorManager(behaviorManager);
        }
    }

    @Override
    public void updateOKStatus() {
        if (!this.fIsEmpty) {
            if (this.fValidator != null) {
                this.fCurrStatus = this.fValidator.validate(this.getResult());
                if (this.dialog != null) {
                    this.dialog.updateStatus(this.fCurrStatus);
                }
            } else {
                this.fCurrStatus = Status.OK_STATUS;
            }
        } else {
            this.fCurrStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "no file found", null);
        }
        if (this.dialog != null) {
            this.dialog.updateStatus(this.fCurrStatus);
        }
    }

}
