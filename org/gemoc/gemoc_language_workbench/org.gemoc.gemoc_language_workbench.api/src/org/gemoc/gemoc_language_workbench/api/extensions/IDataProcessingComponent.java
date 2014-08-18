package org.gemoc.gemoc_language_workbench.api.extensions;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;

public interface IDataProcessingComponent extends IDisposable
{

	void initialize(GemocExecutionEngine engine);

}
