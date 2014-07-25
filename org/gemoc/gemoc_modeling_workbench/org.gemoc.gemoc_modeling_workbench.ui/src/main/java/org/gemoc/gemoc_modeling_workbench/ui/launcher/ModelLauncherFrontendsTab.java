package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.gemoc.execution.engine.core.RunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.frontends.FrontendSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.frontends.FrontendSpecificationExtensionPoint;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

public class ModelLauncherFrontendsTab extends HelpfulModelLauncherMainTab 
{

	private HashMap<FrontendSpecificationExtension, Button> _frontends = new HashMap<>();

	@Override
	public void createControl(Composite parent) 
	{
		Composite content = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		content.setLayout(gl);
		content.layout();
		setControl(content);
		
		Group area = createGroup(content, "");
		createFrontendLayout(area);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) 
	{
		for (Entry<FrontendSpecificationExtension, Button> entry : _frontends.entrySet())
		{
			configuration.setAttribute(entry.getKey().getName(), false);
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) 
	{
		try
		{
			RunConfiguration runConfiguration = new RunConfiguration(configuration);
			for (Entry<FrontendSpecificationExtension, Button> entry : _frontends.entrySet())
			{
				entry.getValue().setSelection(runConfiguration.isFrontendActivated(entry.getKey()));				
			}
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) 
	{
		for (Entry<FrontendSpecificationExtension, Button> entry : _frontends.entrySet())
		{
			configuration.setAttribute(entry.getKey().getName(), entry.getValue().getSelection());
		}
	}

	@Override
	public String getName() 
	{
		return "Frontends";
	}
	
	private void createFrontendLayout(Composite parent) 
	{
		for (FrontendSpecificationExtension extension : FrontendSpecificationExtensionPoint.getSpecifications())
		{
			Button checkbox = createCheckButton(parent, extension.getName());
			checkbox.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateLaunchConfigurationDialog();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});
			_frontends.put(extension, checkbox);
		}				
	}
	
}
