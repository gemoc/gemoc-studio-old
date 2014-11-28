/**
 * Copyright (c) 2012 Eclipse contributors and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package fr.obeo.dsl.debug.ide.ui.provider;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * A column label provider that delegates to a label provider and a label decorator.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DecoratingColumLabelProvider extends ColumnLabelProvider {

	/**
	 * The {@link ILabelProvider} to decorate.
	 */
	protected final ILabelProvider labelProvider;

	/**
	 * The {@link IFontProvider} to decorate.
	 */
	protected final IFontProvider fontProvider;

	/**
	 * The {@link IColorProvider} to decorate.
	 */
	protected final IColorProvider colorProvider;

	/**
	 * The {@link ILabelDecorator} adding decoration.
	 */
	protected final ILabelDecorator labelDecorator;

	/**
	 * The {@link CellLabelProvider} adding decoration.
	 */
	protected final CellLabelProvider cellLabelProvider;

	/**
	 * Constructor.
	 * 
	 * @param labelProvider
	 *            the {@link ILabelProvider} to decorate
	 * @param labelDecorator
	 *            the {@link ILabelDecorator} adding decoration
	 */
	public DecoratingColumLabelProvider(ILabelProvider labelProvider, ILabelDecorator labelDecorator) {
		this.labelProvider = labelProvider;
		if (labelProvider instanceof IFontProvider) {
			this.fontProvider = (IFontProvider)labelProvider;
		} else {
			this.fontProvider = null;
		}
		if (labelProvider instanceof IColorProvider) {
			this.colorProvider = (IColorProvider)labelProvider;
		} else {
			this.colorProvider = null;
		}

		this.labelDecorator = labelDecorator;
		if (labelDecorator instanceof CellLabelProvider) {
			this.cellLabelProvider = (CellLabelProvider)labelDecorator;
		} else {
			this.cellLabelProvider = null;
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		if (labelDecorator != null) {
			labelDecorator.addListener(listener);
		}
		super.addListener(listener);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		if (labelDecorator != null) {
			labelDecorator.addListener(listener);
		}
		super.removeListener(listener);
	}

	@Override
	public Font getFont(Object element) {
		final Font res;

		if (fontProvider == null) {
			res = null;
		} else {
			res = fontProvider.getFont(element);
		}

		return res;
	}

	@Override
	public Color getBackground(Object element) {
		final Color res;

		if (colorProvider == null) {
			res = null;
		} else {
			res = colorProvider.getBackground(element);
		}

		return res;
	}

	@Override
	public Color getForeground(Object element) {
		final Color res;

		if (colorProvider == null) {
			res = null;
		} else {
			res = colorProvider.getForeground(element);
		}

		return res;
	}

	@Override
	public Image getImage(Object element) {
		final Image res;

		final Image image = labelProvider.getImage(element);
		if (image != null) {
			res = labelDecorator.decorateImage(image, element);
		} else {
			res = image;
		}

		return res;
	}

	@Override
	public String getText(Object element) {
		return labelDecorator.decorateText(labelProvider.getText(element), element);
	}

	@Override
	public Image getToolTipImage(Object element) {
		final Image res;

		if (cellLabelProvider == null) {
			res = null;
		} else {
			res = cellLabelProvider.getToolTipImage(element);
		}

		return res;
	}

	@Override
	public String getToolTipText(Object element) {
		final String res;

		if (cellLabelProvider == null) {
			res = null;
		} else {
			res = cellLabelProvider.getToolTipText(element);
		}

		return res;
	}

	@Override
	public Color getToolTipBackgroundColor(Object element) {
		final Color res;

		if (cellLabelProvider == null) {
			res = null;
		} else {
			res = cellLabelProvider.getToolTipBackgroundColor(element);
		}

		return res;
	}

	@Override
	public Color getToolTipForegroundColor(Object element) {
		final Color res;

		if (cellLabelProvider == null) {
			res = null;
		} else {
			res = cellLabelProvider.getToolTipForegroundColor(element);
		}

		return res;
	}

	@Override
	public Font getToolTipFont(Object element) {
		final Font res;

		if (cellLabelProvider == null) {
			res = null;
		} else {
			res = cellLabelProvider.getToolTipFont(element);
		}

		return res;
	}

	@Override
	public Point getToolTipShift(Object element) {
		final Point res;

		if (cellLabelProvider == null) {
			res = null;
		} else {
			res = cellLabelProvider.getToolTipShift(element);
		}

		return res;
	}

	@Override
	public boolean useNativeToolTip(Object element) {
		final boolean res;

		if (cellLabelProvider == null) {
			res = false;
		} else {
			res = cellLabelProvider.useNativeToolTip(element);
		}

		return res;
	}

	@Override
	public int getToolTipTimeDisplayed(Object element) {
		final int res;

		if (cellLabelProvider == null) {
			res = 0;
		} else {
			res = cellLabelProvider.getToolTipTimeDisplayed(element);
		}

		return res;
	}

	@Override
	public int getToolTipDisplayDelayTime(Object element) {
		final int res;

		if (cellLabelProvider == null) {
			res = 0;
		} else {
			res = cellLabelProvider.getToolTipDisplayDelayTime(element);
		}

		return res;
	}

	@Override
	public int getToolTipStyle(Object element) {
		final int res;

		if (cellLabelProvider == null) {
			res = 0;
		} else {
			res = cellLabelProvider.getToolTipStyle(element);
		}

		return res;
	}

	@Override
	public void dispose() {
		super.dispose();
		labelProvider.dispose();
		labelDecorator.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return labelProvider.isLabelProperty(element, property);
	}
}
