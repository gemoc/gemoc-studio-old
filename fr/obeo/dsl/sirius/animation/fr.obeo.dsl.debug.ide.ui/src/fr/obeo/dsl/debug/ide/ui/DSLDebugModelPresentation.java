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
package fr.obeo.dsl.debug.ide.ui;

import fr.obeo.dsl.debug.Contextual;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.provider.DebugItemProviderAdapterFactory;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * The {@link IDebugModelPresentation} for the DSL debug model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation {

	/**
	 * The {@link org.eclipse.jface.viewers.ILabelProvider ILabelProvider} factory.
	 */
	private final AdapterFactoryLabelProvider labelProvider;

	/**
	 * Constructor.
	 */
	public DSLDebugModelPresentation() {
		super();
		final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		DebugItemProviderAdapterFactory animationFactory = new DebugItemProviderAdapterFactory();
		adapterFactory.addAdapterFactory(animationFactory);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		labelProvider.addListener(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		labelProvider.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return labelProvider.isLabelProperty(unwrapp(element), property);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		labelProvider.removeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		final URIEditorInput res;

		if (element instanceof EObject) {
			res = new URIEditorInput(EcoreUtil.getURI((EObject)element));
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput,
	 *      java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		final String res;

		if (element instanceof EObject && input instanceof URIEditorInput) {
			res = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					((URIEditorInput)input).getURI().lastSegment()).getId();
		} else {
			res = null;
		}

		return res;
	}

	public void setAttribute(String attribute, Object value) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#getImage(java.lang.Object)
	 */
	public Image getImage(final Object element) {
		return labelProvider.getImage(unwrapp(element));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		return labelProvider.getText(unwrapp(element));
	}

	public void computeDetail(IValue value, IValueDetailListener listener) {
		// TODO Auto-generated method stub
	}

	/**
	 * Unwrap the {@link Adapter#getTarget() target} if the given element is an {@link Adapter} and the
	 * {@link Contextual#getContext() contextual object} if possible.
	 * 
	 * @param element
	 *            the {@link Object element}
	 * @return the {@link Adapter#getTarget() traget} if the given element is an {@link Adapter}, the given
	 *         element itself otherwise
	 */
	private Object unwrapp(Object element) {
		final Object res;
		if (element instanceof Adapter) {
			final Notifier target = ((Adapter)element).getTarget();
			if (target instanceof Contextual) {
				res = ((Contextual)target).getContext();
			} else {
				res = target;
			}
		} else {
			res = element;
		}
		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugEditorPresentation#addAnnotations(org.eclipse.ui.IEditorPart,
	 *      org.eclipse.debug.core.model.IStackFrame)
	 */
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame instanceof DSLStackFrameAdapter) {
			if (editorPart instanceof IViewerProvider) {
				if (editorPart instanceof IEditingDomainProvider) {
					final EditingDomain domain = ((IEditingDomainProvider)editorPart).getEditingDomain();
					final EObject instruction = ((DSLStackFrameAdapter)frame).getCurrentInstruction();
					final EObject selection = domain.getResourceSet().getEObject(
							EcoreUtil.getURI(instruction), false);
					((IViewerProvider)editorPart).getViewer().setSelection(
							new StructuredSelection(selection), true);
				}
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugEditorPresentation#removeAnnotations(org.eclipse.ui.IEditorPart,
	 *      org.eclipse.debug.core.model.IThread)
	 */
	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
		// nothing to do here
	}

}
