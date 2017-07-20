/*******************************************************************************
 * Copyright (c) 2015  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.tfsm.raspberry.engine;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;

public class RunConfiguration implements IRunConfiguration 
{

	public RunConfiguration(URI modelURI)
	{
		_modelURI = modelURI;
	}
	
	@Override
	public String getLanguageName() 
	{
		return null;
	}

	private URI _modelURI;
	@Override
	public URI getExecutedModelURI() 
	{
		return _modelURI;
	}

	@Override
	public URI getAnimatorURI() 
	{
		return null;
	}

	@Override
	public int getAnimationDelay() 
	{
		return 0;
	}

	@Override
	public int getDeadlockDetectionDepth() 
	{
		return 10;
	}

	@Override
	public Collection<EngineAddonSpecificationExtension> getEngineAddonExtensions() 
	{
		return new ArrayList<EngineAddonSpecificationExtension>();
	}

	@Override
	public String getDeciderName() 
	{
		return null;
	}

	@Override
	public String getExecutionEntryPoint() 
	{
		return null;
	}

}
