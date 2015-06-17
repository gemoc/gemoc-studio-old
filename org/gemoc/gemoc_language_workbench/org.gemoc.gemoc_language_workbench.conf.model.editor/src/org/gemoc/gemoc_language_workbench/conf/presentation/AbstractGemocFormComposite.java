package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;

public abstract class AbstractGemocFormComposite extends Composite {


	protected LanguageDefinition rootModelElement;
	protected AdapterFactoryEditingDomain editingDomain;

	
	public AbstractGemocFormComposite(Composite parent, int style) {
		super(parent, style);
	}

	abstract public void initControl(AdapterFactoryEditingDomain editingDomain);
	abstract public void initControlFromWrappedObject();
	
	protected IFile getCurrentIFile() {
		String platformString;
		if(rootModelElement.eResource() != null){
			platformString = rootModelElement.eResource().getURI()
				.toPlatformString(true);
		} else {
			// maybe freshly created and the element doesn't have its eResource set
			// trying using the editingDomain
			platformString = editingDomain.getResourceSet().getResources().get(0).getURI().toPlatformString(true);
		}
		return ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(platformString));

	}
}
