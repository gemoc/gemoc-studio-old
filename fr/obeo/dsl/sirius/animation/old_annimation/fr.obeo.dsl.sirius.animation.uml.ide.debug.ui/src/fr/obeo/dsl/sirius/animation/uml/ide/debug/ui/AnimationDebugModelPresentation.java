/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.uml.ide.debug.ui;

import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.google.common.collect.Sets;

import fr.obeo.dsl.sirius.animation.provider.AnimationItemProviderAdapterFactory;
import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.DRepresentationElement;
import fr.obeo.dsl.viewpoint.business.api.query.DRepresentationElementQuery;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIManager;

public class AnimationDebugModelPresentation implements IDebugModelPresentation {

	private static ComposedAdapterFactory adapterFactory = createAdapterFactory();

	private static ComposedAdapterFactory createAdapterFactory() {
		return adapterFactory;
	}

	private AdapterFactoryLabelProvider labelProvider;

	public AnimationDebugModelPresentation() {
		super();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		AnimationItemProviderAdapterFactory animationFactory = new AnimationItemProviderAdapterFactory();
		adapterFactory
				.addAdapterFactory(animationFactory);
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		this.labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	public IEditorInput getEditorInput(Object element) {
		if (element instanceof EObject) {
			EObject elementToOpenElement = (EObject) element;
			Session session = SessionManager.INSTANCE
					.getSession(elementToOpenElement);
			if (session != null) {
				Set<DRepresentation> representations = Sets.newLinkedHashSet();
				for (Setting setting : session.getSemanticCrossReferencer()
						.getInverseReferences(elementToOpenElement)) {
					if (setting.getEObject() instanceof DRepresentationElement) {
						representations.add(new DRepresentationElementQuery(
								(DRepresentationElement) setting.getEObject())
								.getParentRepresentation());
					}
					if (setting.getEObject() instanceof DRepresentation) {
						representations.add((DRepresentation) setting
								.getEObject());
					}
				}
				IEditorPart last = null;
				for (DRepresentation dRepresentation : representations) {
					last = DialectUIManager.INSTANCE.openEditor(session,
							dRepresentation);
				}
				if (last != null) {
					return last.getEditorInput();
				}

			}

			URIEditorInput input = new URIEditorInput(
					EcoreUtil.getURI((EObject) element));
			return input;
		} else {
			return null;
		}
	}

	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof EObject) {
			URI uri = EcoreUtil.getURI((EObject) element);			
			/*
			 * FIXME : easy but broken way to find the editor id from an
			 * EObject.
			 */
//			IEditorDescriptor descriptor = PlatformUI.getWorkbench()
//					.getEditorRegistry()
//					.getDefaultEditor("some name." + uri.fileExtension());
//			return descriptor.getId();
			return null;
		} else {
			return null;
		}
	}

	public void setAttribute(String attribute, Object value) {
		// TODO Auto-generated method stub

	}

	public void computeDetail(IValue value, IValueDetailListener listener) {
		// TODO Auto-generated method stub

	}

	public void addListener(ILabelProviderListener listener) {
		labelProvider.addListener(listener);

	}

	public void dispose() {
		labelProvider.dispose();

	}

	public boolean isLabelProperty(Object element, String property) {
		return labelProvider.isLabelProperty(unwrapp(element), property);
	}

	private Object unwrapp(Object element) {
		if (element instanceof Adapter) {
			return ((Adapter) element).getTarget();
		}
		return element;
	}

	public void removeListener(ILabelProviderListener listener) {
		labelProvider.removeListener(listener);

	}

	public Image getImage(Object element) {
		return labelProvider.getImage(unwrapp(element));
	}

	public String getText(Object element) {
		return labelProvider.getText(unwrapp(element));

	}

}
