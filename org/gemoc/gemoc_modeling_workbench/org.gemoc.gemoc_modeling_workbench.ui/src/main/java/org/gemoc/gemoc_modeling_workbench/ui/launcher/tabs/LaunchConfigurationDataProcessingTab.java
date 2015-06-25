package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import java.util.Collection;
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
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon_group.EngineAddonGroupSpecificationExtension;

public abstract class LaunchConfigurationDataProcessingTab extends LaunchConfigurationTab
{

	private HashMap<EngineAddonSpecificationExtension, Button> _components = new HashMap<>();
	private HashMap<EngineAddonSpecificationExtension, Boolean> _componentsActive = new HashMap<>();

	protected LaunchConfigurationDataProcessingTab()
	{
		for (EngineAddonSpecificationExtension extension : getExtensionSpecifications())
		{
			_components.put(extension, null);
		}
	}

	protected abstract Collection<EngineAddonSpecificationExtension> getExtensionSpecifications();
	protected abstract Collection<EngineAddonGroupSpecificationExtension> getGroupExtensionSpecifications();

	@Override
	public void createControl(Composite parent) 
	{
		Composite content = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		content.setLayout(gl);
		content.layout();
		setControl(content);

		createLayout(content);
	}
	
	private void createLayout(Composite parent) 
	{
		HashMap<String, Group> groupmap = new HashMap<String, Group>();
		
		
		for(EngineAddonGroupSpecificationExtension extension : getGroupExtensionSpecifications()){
			groupmap.put(extension.getId(),  createGroup(parent, extension.getName()));
		}

		groupmap.put("",  createGroup(parent, ""));
		
		for (EngineAddonSpecificationExtension extension : _components.keySet())
		{
			Group parentGroup = groupmap.get("");
			if(extension.getAddonGroupId() != null){
				// refine the parentGroup if specified
				parentGroup = groupmap.get(extension.getAddonGroupId());
				if(parentGroup == null){
					// back to the unsorted group
					parentGroup = groupmap.get("");
				}
			} 
			
			Button checkbox = createCheckButton(parentGroup, extension.getName());
			if(extension.getShortDescription() != null){
				checkbox.setToolTipText(extension.getShortDescription());
			}
			//checkbox.setSelection(extension.getDefaultActivationValue());
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
		for (EngineAddonSpecificationExtension entry : _components.keySet())
		{
			configuration.setAttribute(entry.getName(), entry.getDefaultActivationValue());
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) 
	{
		for (EngineAddonSpecificationExtension extension : _components.keySet())
		{
			try {
				boolean value = configuration.getAttribute(extension.getName(), true);
//				_componentsActive.put(extension, value);
				Button checkbox = _components.get(extension);
				checkbox.setSelection(value);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) 
	{
		for (Entry<EngineAddonSpecificationExtension, Button> entry : _components.entrySet())
		{
			configuration.setAttribute(entry.getKey().getName(), entry.getValue().getSelection());
		}
	}

}
