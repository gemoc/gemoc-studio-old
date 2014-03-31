/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.debug.ide.sirius.ui.launch;

import fr.obeo.dsl.debug.ide.Activator;
import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;
import fr.obeo.dsl.debug.ide.ui.launch.FilteredFileContentProvider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * A Sirius implementation of {@link fr.obeo.dsl.debug.ide.ui.launch.DSLLaunchConfigurationTab
 * DSLLaunchConfigurationTab}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLLaunchConfigurationTab extends fr.obeo.dsl.debug.ide.ui.launch.DSLLaunchConfigurationTab {

	/**
	 * The {@link Text} used for the {@link AbstractDSLLaunchConfigurationDelegateUI#SIRIUS_RESOURCE_URI}.
	 */
	private Text siriusResourceURIText;

	/**
	 * Constructor.
	 * 
	 * @param extensions
	 *            supported file extensions
	 */
	public DSLLaunchConfigurationTab(String[] extensions) {
		super(extensions);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI, "");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(final ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		disableUpdate = true;

		siriusResourceURIText.setText("");

		try {
			siriusResourceURIText.setText(configuration.getAttribute(
					AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, ""));
		} catch (CoreException e) {
			Activator.getDefault().error(e);
		}

		disableUpdate = false;
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI,
				siriusResourceURIText.getText());
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		boolean res = super.isValid(launchConfig);
		String errorMessage = null;

		try {
			if (res) {
				String siriusResourceURI = launchConfig.getAttribute(
						AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI, "");
				IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(siriusResourceURI));
				Resource resource = null;
				if (resourceFile.exists()) {
					final ResourceSet rs = new ResourceSetImpl();
					try {
						resource = rs.getResource(URI.createPlatformResourceURI(siriusResourceURI, true),
								true);
					} catch (WrappedException e) {
						errorMessage = "Sirius session model can't be loaded: "
								+ ((WrappedException)e).exception().getLocalizedMessage() + ".";
					}
				}
				res = resource != null;
				setErrorMessage(errorMessage);
			}
		} catch (IllegalArgumentException e) {
			setErrorMessage("Invalid model file selected.");
		} catch (CoreException e) {
			setErrorMessage("Invalid model file selected.");
		}

		return res;
	}

	@Override
	public boolean canSave() {
		return super.canSave() && (!siriusResourceURIText.getText().isEmpty());
	}

	@Override
	public void createControl(final Composite parent) {
		super.createControl(parent);
		Composite topControl = new Composite(parent, SWT.NONE);
		topControl.setLayout(new GridLayout(1, false));

		final Group mgroup = new Group(topControl, SWT.NONE);
		mgroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		mgroup.setText("Model");
		mgroup.setLayout(new GridLayout(2, false));

		siriusResourceURIText = new Text(mgroup, SWT.BORDER);
		siriusResourceURIText.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(final ModifyEvent e) {
				if (!disableUpdate) {
					updateLaunchConfigurationDialog();
				}
			}
		});
		siriusResourceURIText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button browseResourceButton = new Button(mgroup, SWT.NONE);
		browseResourceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				openSiriusModelSelection(parent);
			}

		});
		browseResourceButton.setText("Browse...");
	}

	/**
	 * Opens the model selection dialog.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 */
	private void openSiriusModelSelection(final Composite parent) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(parent.getShell(),
				new WorkbenchLabelProvider(), new FilteredFileContentProvider(
						new String[] {SiriusUtil.SESSION_RESOURCE_EXTENSION }));
		dialog.setTitle("Select model file");
		dialog.setMessage("Select the model file to execute:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		if (dialog.open() == Window.OK) {
			siriusResourceURIText.setText(((IFile)dialog.getFirstResult()).getFullPath().toString());
		}
	}

}
