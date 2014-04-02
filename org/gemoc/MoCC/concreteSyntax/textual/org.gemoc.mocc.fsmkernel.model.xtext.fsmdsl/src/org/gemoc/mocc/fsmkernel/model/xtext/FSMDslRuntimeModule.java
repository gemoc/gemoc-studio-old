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
package org.gemoc.mocc.fsmkernel.model.xtext;

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import com.google.inject.Binder;
import fr.inria.aoste.timesquare.ccslkernel.xtext.util.CCSLLinkingDiagnosticMessageProvider;
import fr.inria.aoste.timesquare.ccslkernel.xtext.util.CCSLTerminalConverters;
import fr.inria.aoste.timesquare.ccslkernel.xtext.util.SimpleNamedElementProvider;



/**
 * @see CCSLLibraryRuntimeModule methods
 * @author Stfun
 * @generated NOT
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class FSMDslRuntimeModule extends org.gemoc.mocc.fsmkernel.model.xtext.AbstractFSMDslRuntimeModule {
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
	
		return SimpleNamedElementProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return CCSLTerminalConverters.class;
	}
	
	
	@Override
	public void configure(Binder binder) {

		super.configure(binder);		
		binder.bind(ILinkingDiagnosticMessageProvider.class).to(CCSLLinkingDiagnosticMessageProvider.class);
	}
	
	/*
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return CCSLImportUriGlobalScopeProvider.class;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(ImportUriResolver.class).to(
				CCSLImportURIResolver.class);
		binder.bind(ICrossReferenceSerializer.class).to(
				CCSLCrossReferenceSerializer.class);
		binder.bind(ILinkingDiagnosticMessageProvider.class).to(CCSLLinkingDiagnosticMessageProvider.class);
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SimpleNamedElementProvider.class;
	}

	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return CCSLTerminalConverters.class;
	}
	
	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return CCSLQualifiedNameConverter.class;
	}
	
	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return ExtendedCCSLResourceDescriptionStrategy.class;
	}*/
}
