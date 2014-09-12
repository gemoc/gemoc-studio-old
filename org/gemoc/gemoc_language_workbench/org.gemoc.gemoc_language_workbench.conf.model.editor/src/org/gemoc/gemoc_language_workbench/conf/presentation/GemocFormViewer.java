package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class GemocFormViewer extends ContentViewer {

	protected GemocXDSMLFormComposite viewControl;
	
	protected AdapterFactoryEditingDomain editingDomain;
	
	public GemocFormViewer(Composite parent) {
		createViewCrontrol(parent);
	}

	protected void createViewCrontrol(Composite parent){
		viewControl = new GemocXDSMLFormComposite(parent, SWT.NONE);
		//viewControl.initControl(this.getContentProvider());
		
	}
	
	@Override
	public Control getControl() {
		return viewControl;
	}

	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		toString();
		
	}

	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		// TODO Auto-generated method stub
		toString();
	}


    /**
     * This viewer's content provider, or <code>null</code> if none.
     */
    private IContentProvider contentProvider = null;
    
	 /**
     * Returns the content provider used by this viewer, 
     * or <code>null</code> if this view does not yet have a content
     * provider.
     * <p>
     * The <code>ContentViewer</code> implementation of this method returns the content
     * provider recorded is an internal state variable. 
     * Overriding this method is generally not required; 
     * however, if overriding in a subclass, 
     * <code>super.getContentProvider</code> must be invoked.
     * </p>
     *
     * @return the content provider, or <code>null</code> if none
     */
    public IContentProvider getContentProvider() {
        return contentProvider;
    }

	/**
     * Sets the content provider used by this viewer.
     * <p>
     * The <code>ContentViewer</code> implementation of this method records the 
     * content provider in an internal state variable.
     * Overriding this method is generally not required; 
     * however, if overriding in a subclass,
     * <code>super.setContentProvider</code> must be invoked.
     * </p>
     *
     * @param contentProvider the content provider
     * @see #getContentProvider
     */
    public void setContentProvider(IContentProvider contentProvider) {
        Assert.isNotNull(contentProvider);
        IContentProvider oldContentProvider = this.contentProvider;
        this.contentProvider = contentProvider;
        if (oldContentProvider != null) {
            Object currentInput = getInput();
            oldContentProvider.inputChanged(this, currentInput, null);
            oldContentProvider.dispose();
            contentProvider.inputChanged(this, null, currentInput);
            refresh();
        }
		viewControl.initControl(editingDomain);
    }

	public void setEditingDomain(AdapterFactoryEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

}
