package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.wizards.NewClassCreationWizard;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.util.PDEJavaHelperUI;
import org.eclipse.pde.internal.ui.util.SWTUtil;
import org.eclipse.pde.internal.ui.util.TextUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.gemoc.commons.eclipse.ui.OpenEditor;
import org.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;

/*
 * IMPORTANT : this file has been edited using Windows builder.
 * This is why the structure is quite "unstructured" and use long methods.
 * The data binding is also managed via Windows Builder.
 */

public class GemocXDSMLAdvancedFormComposite extends AbstractGemocFormComposite {
	private DataBindingContext m_bindingContext;
	

	protected XDSMLModelWrapper xdsmlWrappedObject = new XDSMLModelWrapper();

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtModelLoaderClass;
	private Text txtCodeExecutorClass;
	private Text txtQvtoURI;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public GemocXDSMLAdvancedFormComposite(Composite parent, int style) {
		super(parent, SWT.NONE);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new ColumnLayout());

		Group grpDomainModelDefinition = new Group(this, SWT.NONE);
		grpDomainModelDefinition.setText("Domain Model");
		toolkit.adapt(grpDomainModelDefinition);
		toolkit.paintBordersFor(grpDomainModelDefinition);
		grpDomainModelDefinition.setLayout(new GridLayout(3, false));

		Label lblDomainCustomIntroduction = new Label(grpDomainModelDefinition, SWT.NONE);
		lblDomainCustomIntroduction.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblDomainCustomIntroduction
				.setText("Optionnaly provide you own custom model loader.");
		lblDomainCustomIntroduction.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblDomainCustomIntroduction, true, true);
		
		Link linkModelLoaderClass = new Link(grpDomainModelDefinition, SWT.NONE);
		linkModelLoaderClass.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		linkModelLoaderClass.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkModelLoaderClass, true, true);
		linkModelLoaderClass.setText("<a>Model loader class name</a>");

		txtModelLoaderClass = new Text(grpDomainModelDefinition, SWT.BORDER);
		GridData gd_txtEMFProject = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtEMFProject.widthHint = 226;
		txtModelLoaderClass.setLayoutData(gd_txtEMFProject);
		txtModelLoaderClass.setBounds(0, 0, 244, 21);
		toolkit.adapt(txtModelLoaderClass, true, true);

		Button btnBrowseModelLoaderClass = new Button(grpDomainModelDefinition,
				SWT.NONE);

		btnBrowseModelLoaderClass.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseModelLoaderClass, true, true);
		btnBrowseModelLoaderClass.setText("Browse");

		
		Group grpBehaviorDefinition = new Group(this, SWT.NONE);
		grpBehaviorDefinition.setText("Behavior definition");
		toolkit.adapt(grpBehaviorDefinition);
		toolkit.paintBordersFor(grpBehaviorDefinition);
		grpBehaviorDefinition.setLayout(new GridLayout(1, false));

		Group grpDsaDefinition = new Group(grpBehaviorDefinition, SWT.NONE);
		grpDsaDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpDsaDefinition.setText("DSA definition");
		toolkit.adapt(grpDsaDefinition);
		toolkit.paintBordersFor(grpDsaDefinition);
		grpDsaDefinition.setLayout(new GridLayout(3, false));

		Label lblDSACustomIntroduction = new Label(grpDsaDefinition, SWT.NONE);
		lblDSACustomIntroduction.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblDSACustomIntroduction
				.setText("Optionnaly provide you own custom code executor.");
		lblDSACustomIntroduction.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblDSACustomIntroduction, true, true);
		
		Link linkCodeExecutorClass = new Link(grpDsaDefinition, SWT.NONE);
		linkCodeExecutorClass.setToolTipText("if not set, a default K3 code executor will be generated for the DSA.\r\nIf set, this is the name of a class in the xdsml project classpath.");
		toolkit.adapt(linkCodeExecutorClass, true, true);
		linkCodeExecutorClass.setText("<a>Code executor class name</a>");

		txtCodeExecutorClass = new Text(grpDsaDefinition, SWT.BORDER);
		txtCodeExecutorClass.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		toolkit.adapt(txtCodeExecutorClass, true, true);

		Button btnBrowseCodeExecutorClass = new Button(grpDsaDefinition,
				SWT.NONE);
		toolkit.adapt(btnBrowseCodeExecutorClass, true, true);
		btnBrowseCodeExecutorClass.setText("Browse");

		Group grpDSEDefinition = new Group(grpBehaviorDefinition, SWT.NONE);
		grpDSEDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpDSEDefinition.setText("DSE definition");
		toolkit.adapt(grpDSEDefinition);
		toolkit.paintBordersFor(grpDSEDefinition);
		grpDSEDefinition.setLayout(new GridLayout(3, false));

		Label lblDSEIntroduction = new Label(grpDSEDefinition, SWT.NONE);
		lblDSEIntroduction.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblDSEIntroduction
				.setText("Optionnaly provide your own qvto transformation for the DSE.");
		lblDSEIntroduction.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblDSEIntroduction, true, true);


		Link linkQvtoURI = new Link(grpDSEDefinition, SWT.NONE);
		linkQvtoURI.setToolTipText("Path to the qvto file that is produced by the DSE project.");
		toolkit.adapt(linkQvtoURI, true, true);
		linkQvtoURI.setText("<a>Qvto File path</a>");

		txtQvtoURI = new Text(grpDSEDefinition, SWT.BORDER);
		txtQvtoURI.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		toolkit.adapt(txtQvtoURI, true, true);

		Button btnBrowseQvtoURI = new Button(grpDSEDefinition,
				SWT.NONE);
		toolkit.adapt(btnBrowseQvtoURI, true, true);
		btnBrowseQvtoURI.setText("Browse");
		
		initLinkListeners(linkModelLoaderClass, linkCodeExecutorClass, linkQvtoURI);

		initButtonListeners( btnBrowseModelLoaderClass, btnBrowseCodeExecutorClass, btnBrowseQvtoURI);
		m_bindingContext = initDataBindings();

	}

	public void initControl(AdapterFactoryEditingDomain editingDomain) {
		if (editingDomain != null) {
			this.editingDomain = editingDomain;
			editingDomain.toString();

			if (editingDomain.getResourceSet().getResources().size() > 0) {
				if (editingDomain.getResourceSet().getResources().get(0)
						.getContents().size() > 0) {
					EObject eObject = editingDomain.getResourceSet()
							.getResources().get(0).getContents().get(0);
					if (eObject instanceof LanguageDefinition) {
						rootModelElement = (LanguageDefinition) eObject;
						// txtLanguageName.setText(confModelElement.getLanguageDefinition().getName());
						XDSMLModelWrapperHelper.init(xdsmlWrappedObject,
								rootModelElement);

					}
				}
			}
		}

		m_bindingContext = initDataBindings();
		
		initControlFromWrappedObject();

		initTxtListeners();

	}

	/**
	 * Sets the initial values of the fields when opening the view
	 */
	public void initControlFromWrappedObject() {
		
		txtCodeExecutorClass.setText(xdsmlWrappedObject.getCodeExecutorClass());
		txtQvtoURI.setText(xdsmlWrappedObject.getQvtoURI());
	}

	/**
	 * Initialize the modifyListener for the txt field They are in charge of
	 * reflecting the change to the underlying model via the bean Note that they
	 * must act in a TransactionalEditingDomain in order to be correctly handled
	 */
	protected void initTxtListeners() {
		// all the listeners that will really edit the model
		txtModelLoaderClass.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setModelLoaderClass(text
										.getText());
							}
						});
			}
		});

		txtCodeExecutorClass.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setCodeExecutorClass(text
										.getText());
							}
						});
			}
		});

		txtQvtoURI.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setQvtoURI(text
										.getText());
							}
						});
			}
		});
	}

	/**
	 * Creates the listeners in charge of the behavior for the links
	 */
	protected void initLinkListeners(Link linkModelLoader, Link linkCodeExecutor, Link linkQvtoFile) {
		
		linkModelLoader.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			//	if (!txtCodeExecutorClass.getText().isEmpty()) {
					
					//String value = txtCodeExecutorClass.getText();
					IProject project = getCurrentIFile().getProject();
					/*BundlePluginModel bmodel = new BundlePluginModel();
					//bmodel.setBundleDescription(Activator.);
					JavaAttributeValue javaAttributeValue = new JavaAttributeValue(project, bmodel, null, value);
					javaAttributeValue.
					value = PDEJavaHelperUI.createClass(value, project, javaAttributeValue, false);
					if (value != null)
						txtCodeExecutorClass.setText(value);
						*/
					String name = TextUtil.trimNonAlphaChars(txtModelLoaderClass.getText()).replace('$', '.');
					try {
						if (project.hasNature(JavaCore.NATURE_ID)) {
							IJavaProject javaProject = JavaCore.create(project);
							IJavaElement result = null;
							if (name.length() > 0)
								result = javaProject.findType(name);
							if (result != null)
								JavaUI.openInEditor(result);
							else {
								NewClassCreationWizard wizard = new NewClassCreationWizard();
								//wizard.init(Plugin., currentSelection);
								WizardDialog dialog = new WizardDialog(PDEPlugin.getActiveWorkbenchShell(), wizard);
								dialog.create();
								SWTUtil.setDialogSize(dialog, 400, 500);
								int dResult = dialog.open();
								if (dResult == Window.OK)
									txtModelLoaderClass.setText(wizard.getCreatedElement().getElementName());
							}
						}
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JavaModelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		
		linkCodeExecutor.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			//	if (!txtCodeExecutorClass.getText().isEmpty()) {
					
					//String value = txtCodeExecutorClass.getText();
					IProject project = getCurrentIFile().getProject();
					/*BundlePluginModel bmodel = new BundlePluginModel();
					//bmodel.setBundleDescription(Activator.);
					JavaAttributeValue javaAttributeValue = new JavaAttributeValue(project, bmodel, null, value);
					javaAttributeValue.
					value = PDEJavaHelperUI.createClass(value, project, javaAttributeValue, false);
					if (value != null)
						txtCodeExecutorClass.setText(value);
						*/
					String name = TextUtil.trimNonAlphaChars(txtCodeExecutorClass.getText()).replace('$', '.');
					try {
						if (project.hasNature(JavaCore.NATURE_ID)) {
							IJavaProject javaProject = JavaCore.create(project);
							IJavaElement result = null;
							if (name.length() > 0)
								result = javaProject.findType(name);
							if (result != null)
								JavaUI.openInEditor(result);
							else {
								NewClassCreationWizard wizard = new NewClassCreationWizard();
								//wizard.init(Plugin., currentSelection);
								WizardDialog dialog = new WizardDialog(PDEPlugin.getActiveWorkbenchShell(), wizard);
								dialog.create();
								SWTUtil.setDialogSize(dialog, 400, 500);
								int dResult = dialog.open();
								if (dResult == Window.OK)
									txtCodeExecutorClass.setText(wizard.getCreatedElement().getElementName());
							}
						}
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JavaModelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		
		linkQvtoFile.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtQvtoURI.getText().isEmpty()) {
					// find the file
					IFile file = ResourcesPlugin
							.getWorkspace()
							.getRoot()
							.getFile(
									new Path(txtQvtoURI.getText()));
					if (file.exists()) {
						// open the editor on the file
						OpenEditor.openIFile(file);
						return;
					}
				}
			}
		});

	}

	/**
	 * Creates the listeners in charge of the behavior for the buttons
	 */
	protected void initButtonListeners(	Button btnModelLoaderClass,
			Button btnBrowseCodeExecutorClass,
			Button btnBrowseQvtoFile) {
		btnModelLoaderClass.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					String className = txtModelLoaderClass.getText();
					IResource resource = getCurrentIFile();
					String type = PDEJavaHelperUI.selectType(resource, IJavaElementSearchConstants.CONSIDER_CLASSES, className, null);
					if (type != null)
						txtModelLoaderClass.setText(type);
									
					break;
				}
			}
		});
		btnBrowseCodeExecutorClass.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					String className = txtCodeExecutorClass.getText();
					IResource resource = getCurrentIFile();
					String type = PDEJavaHelperUI.selectType(resource, IJavaElementSearchConstants.CONSIDER_CLASSES, className, null);
					if (type != null)
						txtCodeExecutorClass.setText(type);
									
					break;
				}
			}
		});
		btnBrowseQvtoFile.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
					dialog.setPattern("*.qvto");
					if (dialog.open() == Dialog.OK) {
						txtQvtoURI.setText(((IResource) dialog.getResult()[0])
										.getFullPath().toString());
					}
					break;
				}
			}
		});
		
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtCodeExecutorClassObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtCodeExecutorClass);
		IObservableValue codeExecutorClassXdsmlWrappedObjectObserveValue = BeanProperties.value("codeExecutorClass").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtCodeExecutorClassObserveWidget, codeExecutorClassXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtQvtoURIObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtQvtoURI);
		IObservableValue qvtoURIXdsmlWrappedObjectObserveValue = BeanProperties.value("qvtoURI").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtQvtoURIObserveWidget, qvtoURIXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtModelLoaderClassObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtModelLoaderClass);
		IObservableValue modelLoaderClassXdsmlWrappedObjectObserveValue = BeanProperties.value("modelLoaderClass").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtModelLoaderClassObserveWidget, modelLoaderClassXdsmlWrappedObjectObserveValue, null, null);
		//
		return bindingContext;
	}
}
