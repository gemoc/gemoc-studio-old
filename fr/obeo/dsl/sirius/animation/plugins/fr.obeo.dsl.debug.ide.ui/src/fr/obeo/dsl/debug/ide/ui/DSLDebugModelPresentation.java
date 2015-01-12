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

import fr.obeo.dsl.debug.Variable;
import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.adapter.value.DSLObjectValue;
import fr.obeo.dsl.debug.ide.adapter.variable.DSLObjectVariable;
import fr.obeo.dsl.debug.provider.CustomDebugItemProviderAdapterFactory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugEditorPresentation;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

/**
 * The {@link IDebugModelPresentation} for the DSL debug model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLDebugModelPresentation implements IDebugModelPresentation, IDebugEditorPresentation {

	/**
	 * The {@link Image} cache.
	 */
	protected final Map<ImageDescriptor, Image> imagesCache = new HashMap<ImageDescriptor, Image>();

	/**
	 * The EMF {@link ILabelProvider}.
	 */
	private final ILabelProvider eLabelProvider;

	/**
	 * Constructor.
	 */
	public DSLDebugModelPresentation() {
		super();
		final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		CustomDebugItemProviderAdapterFactory debugFactory = new CustomDebugItemProviderAdapterFactory();
		adapterFactory.addAdapterFactory(debugFactory);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		eLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		eLabelProvider.addListener(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		for (Image cachedImage : imagesCache.values()) {
			cachedImage.dispose();
		}
		eLabelProvider.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		final boolean res;

		final Object unwrapped = unwrapp(element);
		if (unwrapped instanceof Variable) {
			res = isLabelProperty(((Variable)unwrapped).getValue(), property);
		} else {
			res = eLabelProvider.isLabelProperty(unwrapp(element), property);
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		eLabelProvider.removeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorInput(java.lang.Object)
	 */
	public IEditorInput getEditorInput(Object element) {
		return EMFEditorUtils.getEditorInput(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ISourcePresentation#getEditorId(org.eclipse.ui.IEditorInput,
	 *      java.lang.Object)
	 */
	public String getEditorId(IEditorInput input, Object element) {
		final String res;

		res = EMFEditorUtils.getEditorID(input, element);

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
		final Image res;

		final Object unwrapped = unwrapp(element);
		if (unwrapped instanceof Variable) {
			res = getImage(((Variable)unwrapped).getValue());
		} else if (element instanceof DSLBreakpoint) {
			final Object image = ((DSLBreakpoint)element).getImage();
			if (image instanceof ComposedImage) {
				((ComposedImage)image).getImages().add(
						DebugIdeUiPlugin.INSTANCE.getImage("full/deco16/breakpoint_enabled"));
			}
			final ImageDescriptor descriptor = ExtendedImageRegistry.getInstance().getImageDescriptor(image);
			Image cachedImage = imagesCache.get(descriptor);
			if (cachedImage == null) {
				cachedImage = new Image(Display.getDefault(), descriptor.getImageData());
				imagesCache.put(descriptor, cachedImage);
			}
			res = cachedImage;
		} else {
			res = eLabelProvider.getImage(unwrapped);
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.IDebugModelPresentation#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		final String res;

		final Object unwrapped = unwrapp(element);
		if (unwrapped instanceof Variable) {
			res = getText(((Variable)unwrapped).getValue());
		} else if (element instanceof DSLBreakpoint) {
			res = ((DSLBreakpoint)element).getText();
		} else {
			res = eLabelProvider.getText(unwrapped);
		}

		return res;
	}

	public void computeDetail(IValue value, IValueDetailListener listener) {
		// TODO Auto-generated method stub
	}

	/**
	 * Unwrap the {@link Adapter#getTarget() target} if the given element is an {@link Adapter}.
	 * 
	 * @param element
	 *            the {@link Object element}
	 * @return the {@link Adapter#getTarget() target} if the given element is an {@link Adapter}, the given
	 *         element itself otherwise
	 */
	private Object unwrapp(Object element) {
		final Object res;

		if (element instanceof DSLObjectVariable) {
			res = ((DSLObjectVariable)element).getObject();
		} else if (element instanceof DSLObjectValue) {
			res = ((DSLObjectValue)element).getValue();
		} else if (element instanceof Adapter) {
			res = ((Adapter)element).getTarget();
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
			final EObject instruction = ((DSLStackFrameAdapter)frame).getCurrentInstruction();
			final URI instructionUri = EcoreUtil.getURI(instruction);
			EMFEditorUtils.selectInstruction(editorPart, instructionUri);
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
