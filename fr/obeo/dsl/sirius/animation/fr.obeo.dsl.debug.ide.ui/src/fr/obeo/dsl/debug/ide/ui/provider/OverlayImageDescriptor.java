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

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/**
 * A {@link CompositeImageDescriptor} that overlay an {@link Image} on top of a base {@link Image}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class OverlayImageDescriptor extends CompositeImageDescriptor {

	/**
	 * Base {@link Image}.
	 */
	private final Image image;

	/**
	 * Overlay {@link Image}.
	 */
	private final Image overlay;

	/**
	 * The size of the {@link OverlayImageDescriptor#image}.
	 */
	private final Point size;

	/**
	 * Constructor.
	 * 
	 * @param image
	 *            the base {@link Image}
	 * @param overlay
	 *            the overlay {@link Image}
	 */
	public OverlayImageDescriptor(Image image, Image overlay) {
		this.image = image;
		final Rectangle bounds = image.getBounds();
		this.size = new Point(bounds.width, bounds.height);
		this.overlay = overlay;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.resource.CompositeImageDescriptor#drawCompositeImage(int, int)
	 */
	protected void drawCompositeImage(int arg0, int arg1) {
		drawImage(image.getImageData(), 0, 0);
		ImageData overlayImageData = overlay.getImageData();
		drawImage(overlayImageData, 0, 0);
	}

	protected Point getSize() {
		return size;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof OverlayImageDescriptor && image.equals(((OverlayImageDescriptor)obj).image)
				&& overlay.equals(((OverlayImageDescriptor)obj).overlay);
	}

	@Override
	public int hashCode() {
		return image.hashCode() ^ overlay.hashCode();
	}

}
