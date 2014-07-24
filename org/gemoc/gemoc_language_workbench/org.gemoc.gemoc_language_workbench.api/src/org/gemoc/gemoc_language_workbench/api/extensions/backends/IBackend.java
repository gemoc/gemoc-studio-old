package org.gemoc.gemoc_language_workbench.api.extensions.backends;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;

public interface IBackend extends IDisposable
{

	void initialize(GemocExecutionEngine engine);

}
