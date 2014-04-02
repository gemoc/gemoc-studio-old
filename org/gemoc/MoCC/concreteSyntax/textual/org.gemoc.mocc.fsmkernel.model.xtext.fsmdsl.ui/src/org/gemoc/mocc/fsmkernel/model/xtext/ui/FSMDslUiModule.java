/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.fsmkernel.model.xtext.ui;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import com.google.inject.Binder;

import fr.inria.aoste.timesquare.ccslkernel.library.xtext.ui.CCSLLibraryUiModule;
import fr.inria.aoste.timesquare.ccslkernel.library.xtext.ui.hover.CCSLLibraryHoverDocProvider;
import fr.inria.aoste.timesquare.ccslkernel.library.xtext.ui.hover.CCSLLibraryHoverProvider;
import fr.inria.aoste.timesquare.ccslkernel.xtext.util.CCSLDefaultHighlightingConfiguration;
import fr.inria.aoste.timesquare.ccslkernel.xtext.util.CCSLLanguageSpecificURIEditorOpener;
import fr.inria.aoste.timesquare.ccslkernel.xtext.util.CCSLSemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 * 
 * @see CCSLLibraryUiModule methods
 * @author Stfun
 * @generated NOT 
 */
public class FSMDslUiModule extends org.gemoc.mocc.fsmkernel.model.xtext.ui.AbstractFSMDslUiModule {
	public FSMDslUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	@Override
	public void configureHighlightingLexer(Binder binder) {
		super.configureHighlightingLexer(binder);
		binder.bind(DefaultHighlightingConfiguration.class).to(
				CCSLDefaultHighlightingConfiguration.class);
		binder.bind(ISemanticHighlightingCalculator.class).to(
				CCSLSemanticHighlightingCalculator.class);

	}
	
	public void configureLanguageSpecificURIEditorOpener(com.google.inject.Binder binder) {
		if (PlatformUI.isWorkbenchRunning())
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class)
					.to(CCSLLanguageSpecificURIEditorOpener.class);
	}

	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return CCSLLibraryHoverProvider.class;
	}
	
	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProviderr() {
		return CCSLLibraryHoverDocProvider.class;
	}
}
