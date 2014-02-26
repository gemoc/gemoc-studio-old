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
package fr.obeo.dsl.debug.ide.ui.launch;

import fr.obeo.dsl.debug.ide.Activator;
import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * DSL {@link org.eclipse.debug.ui.ILaunchConfigurationTab ILaunchConfigurationTab}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	/**
	 * The {@link Text} used for the {@link AbstractDSLLaunchConfigurationDelegate#RESOURCE_URI}.
	 */
	private Text resourceURIText;

	/**
	 * The {@link Text} used for the {@link AbstractDSLLaunchConfigurationDelegate#FIRST_INSTRUCTION_URI}.
	 */
	private Text firstInstructionURIText;

	/**
	 * Disable the update.
	 */
	private boolean disableUpdate;

	/**
	 * Supported {@link org.eclipse.core.resources.IResource IResource} extensions.
	 */
	private final String[] extensions;

	/**
	 * Constructor.
	 * 
	 * @param extensions
	 *            supported file extensions
	 */
	public DSLLaunchConfigurationTab(final String[] extensions) {
		this.extensions = extensions;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, "");
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.FIRST_INSTRUCTION_URI, "");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(final ILaunchConfiguration configuration) {
		disableUpdate = true;

		resourceURIText.setText("");
		firstInstructionURIText.setText("");

		try {
			resourceURIText.setText(configuration.getAttribute(
					AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, ""));
			firstInstructionURIText.setText(configuration.getAttribute(
					AbstractDSLLaunchConfigurationDelegate.FIRST_INSTRUCTION_URI, ""));
		} catch (CoreException e) {
			Activator.getDefault().error(e);
		}

		disableUpdate = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, resourceURIText
				.getText());
		configuration.setAttribute(AbstractDSLLaunchConfigurationDelegate.FIRST_INSTRUCTION_URI,
				firstInstructionURIText.getText());
	}

	@Override
	public boolean isValid(final ILaunchConfiguration launchConfig) {
		boolean res = false;
		String errorMessage = null;

		try {
			String resourceURI = launchConfig.getAttribute(
					AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, "");
			IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceURI));
			if (resourceFile.exists()) {
				final ResourceSet rs = new ResourceSetImpl();
				Resource resource = null;
				try {
					resource = rs.getResource(URI.createPlatformResourceURI(resourceURI, true), true);
				} catch (WrappedException e) {
					errorMessage = "Model can't be loaded: "
							+ ((WrappedException)e).exception().getLocalizedMessage() + ".";
				}
				EObject firstInstruction = null;
				try {
					firstInstruction = rs.getEObject(URI.createURI(launchConfig.getAttribute(
							AbstractDSLLaunchConfigurationDelegate.FIRST_INSTRUCTION_URI, ""), true), true);
				} catch (WrappedException e) {
					errorMessage = "First instruction can't be loaded: "
							+ ((WrappedException)e).exception().getLocalizedMessage() + ".";
				}
				if (firstInstruction == null) {
					errorMessage = "First instruction not selected.";
				}
				res = resource != null && firstInstruction != null;
			} else {
				errorMessage = "Model file does not exist.";
			}
			setErrorMessage(errorMessage);
		} catch (IllegalArgumentException e) {
			setErrorMessage("Invalid model file selected.");
		} catch (CoreException e) {
			setErrorMessage("Invalid model file selected.");
		}

		return res;
	}

	@Override
	public boolean canSave() {
		// allow save when a file location is entered - no matter if the file
		// exists or not
		return (!firstInstructionURIText.getText().isEmpty()) && (!resourceURIText.getText().isEmpty());
	}

	@Override
	public String getMessage() {
		return "Please select a model file and first instruction.";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "DSL launch";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 * @wbp.parser.entryPoint
	 */
	public void createControl(final Composite parent) {
		Composite topControl = new Composite(parent, SWT.NONE);
		topControl.setLayout(new GridLayout(1, false));

		final Group mgroup = new Group(topControl, SWT.NONE);
		mgroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		mgroup.setText("Model");
		mgroup.setLayout(new GridLayout(2, false));

		resourceURIText = new Text(mgroup, SWT.BORDER);
		resourceURIText.addModifyListener(new ModifyListener() {

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
		resourceURIText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button browseResourceButton = new Button(mgroup, SWT.NONE);
		browseResourceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				openModelSelection(parent);
			}

		});
		browseResourceButton.setText("Browse...");

		Group grpLaunch = new Group(topControl, SWT.NONE);
		grpLaunch.setLayout(new GridLayout(2, false));
		grpLaunch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpLaunch.setText("First instruction");

		firstInstructionURIText = new Text(grpLaunch, SWT.BORDER);
		firstInstructionURIText.addModifyListener(new ModifyListener() {

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
		firstInstructionURIText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button browseModelFileButton = new Button(grpLaunch, SWT.NONE);
		browseModelFileButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(resourceURIText.getText()));
				if (resourceFile.exists()) {
					final ResourceSet rs = new ResourceSetImpl();
					rs.getResource(URI.createPlatformResourceURI(resourceURIText.getText(), true), true);
					EObject firstInstruction = openFirstInstructionSelection(parent.getShell(), rs);
					if (firstInstruction != null) {
						firstInstructionURIText.setText(EcoreUtil.getURI(firstInstruction).toString());
					}
				} else {
					MessageDialog.openInformation(parent.getShell(), "Model not selected",
							"You must select a model first.");
				}
			}
		});
		browseModelFileButton.setText("Browse...");

		setControl(topControl);
	}

	/**
	 * Opens the model selection dialog.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 */
	private void openModelSelection(final Composite parent) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(parent.getShell(),
				new WorkbenchLabelProvider(), new FilteredFileContentProvider(extensions));
		dialog.setTitle("Select model file");
		dialog.setMessage("Select the model file to execute:");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		if (dialog.open() == Window.OK) {
			resourceURIText.setText(((IFile)dialog.getFirstResult()).getFullPath().toString());
		}
	}

	/**
	 * Opens the {@link EObject first instruction} selection dialog.
	 * 
	 * @param shell
	 *            the {@link Shell} to use for display
	 * @param resourceSet
	 *            the {@link ResourceSet} to get the first instruction from
	 * @return the selected first instruction {@link URI} if any selected, <code>null</code> otherwise
	 */
	public static EObject openFirstInstructionSelection(final Shell shell, ResourceSet resourceSet) {
		final EObject res;
		final ComposedAdapterFactory fatory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		fatory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		fatory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell,
				new AdapterFactoryLabelProvider(fatory), new AdapterFactoryContentProvider(fatory));
		dialog.setTitle("Select first instruction");
		dialog.setMessage("Select the first instruction:");
		dialog.setInput(resourceSet);
		if (dialog.open() == Window.OK) {
			res = (EObject)dialog.getFirstResult();
		} else {
			res = null;
		}
		fatory.dispose();
		return res;
	}

}
