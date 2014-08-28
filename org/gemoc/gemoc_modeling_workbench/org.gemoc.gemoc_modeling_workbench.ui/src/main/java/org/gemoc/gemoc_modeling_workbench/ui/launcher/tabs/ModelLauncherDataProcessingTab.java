package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;

public abstract class ModelLauncherDataProcessingTab extends HelpfulModelLauncherMainTab
{

	private HashMap<IDataProcessingComponentExtension, Button> _components = new HashMap<>();

	protected ModelLauncherDataProcessingTab()
	{
		for (IDataProcessingComponentExtension extension : getExtensionSpecifications())
		{
			_components.put(extension, null);
		}
	}

	protected abstract Collection<IDataProcessingComponentExtension> getExtensionSpecifications();

	@Override
	public void createControl(Composite parent) 
	{
		Composite content = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		content.setLayout(gl);
		content.layout();
		setControl(content);

		Group area2 = createGroup(content, "");
		createLayout(area2);
	}
	
	private void createLayout(Composite parent) 
	{
		for (IDataProcessingComponentExtension extension : _components.keySet())
		{
			Button checkbox = createCheckButton(parent, extension.getName());
			checkbox.setSelection(extension.getDefaultActivationValue());
			checkbox.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateLaunchConfigurationDialog();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});
			_components.put(extension, checkbox);
		}
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) 
	{
		for (IDataProcessingComponentExtension entry : _components.keySet())
		{
			configuration.setAttribute(entry.getName(), entry.getDefaultActivationValue());
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) 
	{}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) 
	{
		for (Entry<IDataProcessingComponentExtension, Button> entry : _components.entrySet())
		{
			configuration.setAttribute(entry.getKey().getName(), entry.getValue().getSelection());
		}
	}

}
