package org.gemoc.gemoc_language_workbench.api.extensions.frontends;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;

public interface IFrontend extends IDisposable
{

	void initialize(GemocExecutionEngine engine);

}
