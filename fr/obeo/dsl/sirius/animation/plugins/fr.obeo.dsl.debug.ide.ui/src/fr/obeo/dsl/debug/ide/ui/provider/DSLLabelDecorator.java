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
package fr.obeo.dsl.debug.ide.ui.provider;

import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.ui.DebugIdeUiPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * A {@link ILabelDecorator} adding the breakpoint decorator.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLLabelDecorator extends BaseLabelProvider implements ILabelDecorator, IBreakpointListener {

	/**
	 * The {@link Image} cache.
	 */
	protected final Map<ImageDescriptor, Image> imagesCache = new HashMap<ImageDescriptor, Image>();

	/**
	 * Enabled breakpoint {@link Image}.
	 */
	private final Image breakpointEnabled = new Image(Display.getDefault(), ExtendedImageRegistry
			.getInstance().getImageDescriptor(
					DebugIdeUiPlugin.INSTANCE.getImage("full/deco16/breakpoint_enabled")).getImageData());

	/**
	 * Disabled breakpoint {@link Image}.
	 */
	private final Image breakpointDisabled = new Image(Display.getDefault(), ExtendedImageRegistry
			.getInstance().getImageDescriptor(
					DebugIdeUiPlugin.INSTANCE.getImage("full/deco16/breakpoint_disabled")).getImageData());

	/**
	 * {@link Map} of {@link URI} pointing {@link DSLBreakpoint}.
	 */
	private final Map<URI, Set<DSLBreakpoint>> breakpoints = new HashMap<URI, Set<DSLBreakpoint>>();

	/**
	 * The {@link ResourceSet} used to load {@link EObject instruction} from the {@link DSLBreakpoint}.
	 */
	private ResourceSet resourceSet;

	/**
	 * The debug model identifier.
	 */
	private final String identifier;

	/**
	 * Constructor.
	 * 
	 * @param identifier
	 *            the debug model identifier
	 */
	public DSLLabelDecorator(String identifier) {
		this(null, identifier);
	}

	/**
	 * Constructor.
	 * 
	 * @param resourceSet
	 *            the {@link ResourceSet} used to load {@link EObject instruction} from the
	 *            {@link DSLBreakpoint}
	 * @param identifier
	 *            the debug model identifier
	 */
	public DSLLabelDecorator(ResourceSet resourceSet, String identifier) {
		this.resourceSet = resourceSet;
		this.identifier = identifier;
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
		for (IBreakpoint breakpoint : DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
				getModelIdentifier())) {
			if (breakpoint instanceof DSLBreakpoint) {
				addBreakpoint((DSLBreakpoint)breakpoint);
			}
		}
	}

	/**
	 * Gets the debug model identifier.
	 * 
	 * @return the debug model identifier
	 */
	protected String getModelIdentifier() {
		return identifier;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointAdded(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public void breakpointAdded(IBreakpoint breakpoint) {
		if (breakpoint instanceof DSLBreakpoint
				&& breakpoint.getModelIdentifier().equals(getModelIdentifier())) {
			addBreakpoint((DSLBreakpoint)breakpoint);
			fireLabelProviderChanged(breakpoint);
		}
	}

	/**
	 * Fires {@link LabelProviderChangedEvent} for the given {@link DSLBreakpoint}.
	 * 
	 * @param breakpoint
	 *            the {@link DSLBreakpoint}
	 */
	protected void fireLabelProviderChanged(IBreakpoint breakpoint) {
		if (resourceSet != null) {
			final Object instruction = getElement(resourceSet, (DSLBreakpoint)breakpoint);
			if (instruction != null) {
				final LabelProviderChangedEvent event = new LabelProviderChangedEvent(this, instruction);
				Display.getDefault().asyncExec(new Runnable() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see java.lang.Runnable#run()
					 */
					public void run() {
						fireLabelProviderChanged(event);
					}
				});
			}
		}
	}

	/**
	 * Gets the element to pass in the {@link LabelProviderChangedEvent} from the given {@link DSLBreakpoint}
	 * and {@link ResourceSet}.
	 * 
	 * @param rs
	 *            the {@link ResourceSet}
	 * @param breakpoint
	 *            the {@link DSLBreakpoint}
	 * @return the element to pass in the {@link LabelProviderChangedEvent} from the given
	 *         {@link DSLBreakpoint} and {@link ResourceSet}
	 */
	protected Object getElement(ResourceSet rs, DSLBreakpoint breakpoint) {
		return rs.getEObject(((DSLBreakpoint)breakpoint).getURI(), false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointRemoved(org.eclipse.debug.core.model.IBreakpoint,
	 *      org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (breakpoint instanceof DSLBreakpoint
				&& breakpoint.getModelIdentifier().equals(getModelIdentifier())) {
			removeBreakpoint((DSLBreakpoint)breakpoint);
			fireLabelProviderChanged(breakpoint);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.IBreakpointListener#breakpointChanged(org.eclipse.debug.core.model.IBreakpoint,
	 *      org.eclipse.core.resources.IMarkerDelta)
	 */
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		try {
			if (breakpoint instanceof DSLBreakpoint
					&& breakpoint.getModelIdentifier().equals(getModelIdentifier())
					&& delta.getAttribute(IBreakpoint.ENABLED) != null
					&& breakpoint.isEnabled() != ((Boolean)delta.getAttribute(IBreakpoint.ENABLED))
							.booleanValue()) {
				fireLabelProviderChanged(breakpoint);
			}
		} catch (CoreException e) {
			// ignore
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateImage(org.eclipse.swt.graphics.Image,
	 *      java.lang.Object)
	 */
	public Image decorateImage(Image image, Object element) {
		Image res;

		if (element instanceof EObject) {
			final DSLBreakpoint breakpoint;
			final Set<DSLBreakpoint> brkps = breakpoints.get(EcoreUtil.getURI((EObject)element));
			if (brkps != null) {
				Iterator<DSLBreakpoint> it = brkps.iterator();
				if (it.hasNext()) {
					breakpoint = it.next();
				} else {
					breakpoint = null;
				}
			} else {
				breakpoint = null;
			}
			if (breakpoint != null) {
				final OverlayImageDescriptor descriptor;
				try {
					if (breakpoint.isEnabled()) {
						descriptor = new OverlayImageDescriptor(image, breakpointEnabled);
					} else {
						descriptor = new OverlayImageDescriptor(image, breakpointDisabled);
					}
					Image cachedImage = imagesCache.get(descriptor);
					if (cachedImage == null) {
						cachedImage = descriptor.createImage();
						imagesCache.put(descriptor, cachedImage);
					}
					res = cachedImage;
				} catch (CoreException e) {
					res = image;
					DebugIdeUiPlugin.getPlugin().getLog().log(
							new Status(IStatus.ERROR, DebugIdeUiPlugin.ID, e.getLocalizedMessage(), e));
				}
			} else {
				res = image;
			}
		} else {
			res = image;
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILabelDecorator#decorateText(java.lang.String, java.lang.Object)
	 */
	public String decorateText(String text, Object element) {
		final String res;

		if (element instanceof EObject) {
			final Set<DSLBreakpoint> brkps = breakpoints.get(EcoreUtil.getURI((EObject)element));
			if (brkps != null && brkps.size() != 0) {
				res = text + " (breakpoint)";
			} else {
				res = text;
			}
		} else {
			res = text;
		}

		return res;
	}

	/**
	 * Adds the given {@link DSLBreakpoint}.
	 * 
	 * @param breakpoint
	 *            the {@link DSLBreakpoint}
	 */
	protected void addBreakpoint(DSLBreakpoint breakpoint) {
		Set<DSLBreakpoint> brkps = breakpoints.get(breakpoint.getURI());
		if (brkps == null) {
			brkps = new HashSet<DSLBreakpoint>();
			breakpoints.put(breakpoint.getURI(), brkps);
		}
		brkps.add(breakpoint);
	}

	/**
	 * Removes the given {@link DSLBreakpoint}.
	 * 
	 * @param breakpoint
	 *            the {@link DSLBreakpoint}
	 */
	protected void removeBreakpoint(DSLBreakpoint breakpoint) {
		Set<DSLBreakpoint> brkps = breakpoints.get(breakpoint.getURI());
		if (brkps != null) {
			brkps.remove(breakpoint);
		}
	}

	@Override
	public void dispose() {
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
		breakpointEnabled.dispose();
		breakpointDisabled.dispose();
		for (Image cachedImage : imagesCache.values()) {
			cachedImage.dispose();
		}
		super.dispose();
	}

	/**
	 * Sets the {@link ResourceSet}.
	 * 
	 * @param resourceSet
	 *            the {@link ResourceSet}
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

}
