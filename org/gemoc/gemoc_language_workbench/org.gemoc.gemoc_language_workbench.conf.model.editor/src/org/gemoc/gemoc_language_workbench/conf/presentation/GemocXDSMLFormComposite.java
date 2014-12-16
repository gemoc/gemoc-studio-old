package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardDialog;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.gemoc.commons.eclipse.ui.OpenEditor;
import org.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.ui.commands.ENamedElementQualifiedNameLabelProvider;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyConcreteEClassDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyEObjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectDSAIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectDSEIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectEMFIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectMoCCIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectODesignIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectPluginIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectXtextIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSEWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSEWizardContextAction.CreateDSEAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction.CreateDomainModelAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction.CreateEditorProjectAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateMOCCWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateMOCCWizardContextAction.CreateMOCCAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.contextDSA.CreateDSAWizardContextActionDSAK3;

/*
 * IMPORTANT : this file has been edited using Windows builder.
 * This is why the structure is quite "unstructured" and use long methods.
 * The data binding is also managed via Windows Builder.
 */

public class GemocXDSMLFormComposite extends AbstractGemocFormComposite {
	private DataBindingContext m_bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtLanguageName;
	private Text txtEMFProject;
	private Text txtRootContainerModelElement;
	private Text txtXTextEditorProject;
	private Text txtSiriusEditorProject;
	private Text txtDSAProject;
	private Text txtDSEProject;
	private Text txtMoCCProject;
	private Text txtSiriusAnimationProject;
	private Text txtGenmodel;

	

	protected XDSMLModelWrapper xdsmlWrappedObject = new XDSMLModelWrapper();
	private Label lblSupportedFileExtensions;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public GemocXDSMLFormComposite(Composite parent, int style) {
		super(parent, SWT.NONE);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new ColumnLayout());

		Group grpLanguageDefinition = new Group(this, SWT.NONE);
		grpLanguageDefinition.setText("Language definition");
		toolkit.adapt(grpLanguageDefinition);
		toolkit.paintBordersFor(grpLanguageDefinition);
		grpLanguageDefinition.setLayout(new GridLayout(2, false));

		Label lblThisSectionDescribes = new Label(grpLanguageDefinition,
				SWT.WRAP);
		lblThisSectionDescribes.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				false, false, 2, 1));
		toolkit.adapt(lblThisSectionDescribes, true, true);
		lblThisSectionDescribes
				.setText("This section describes general information about this language.");

		Label lblNewLabel = new Label(grpLanguageDefinition, SWT.NONE);
		toolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Language name");

		txtLanguageName = new Text(grpLanguageDefinition, SWT.BORDER);
		txtLanguageName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
				false, 1, 1));
		toolkit.adapt(txtLanguageName, true, true);
		new Label(grpLanguageDefinition, SWT.NONE);
		new Label(grpLanguageDefinition, SWT.NONE);

		Group grpDomainModelDefinition = new Group(this, SWT.NONE);
		grpDomainModelDefinition.setText("Domain Model");
		toolkit.adapt(grpDomainModelDefinition);
		toolkit.paintBordersFor(grpDomainModelDefinition);
		grpDomainModelDefinition.setLayout(new GridLayout(3, false));

		Link linkEMFProject = new Link(grpDomainModelDefinition, SWT.NONE);
		linkEMFProject.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		linkEMFProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkEMFProject, true, true);
		linkEMFProject.setText("<a>EMF project</a>");

		txtEMFProject = new Text(grpDomainModelDefinition, SWT.BORDER);
		GridData gd_txtEMFProject = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtEMFProject.widthHint = 226;
		txtEMFProject.setLayoutData(gd_txtEMFProject);
		txtEMFProject.setBounds(0, 0, 244, 21);
		toolkit.adapt(txtEMFProject, true, true);

		Button btnBrowseEMFProject = new Button(grpDomainModelDefinition,
				SWT.NONE);

		btnBrowseEMFProject.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseEMFProject, true, true);
		btnBrowseEMFProject.setText("Browse");

		Link linkGenmodel = new Link(grpDomainModelDefinition, 0);
		linkGenmodel.setToolTipText("URI of the main genmodel for the Domain project.");
		linkGenmodel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		linkGenmodel.setText("<a>Genmodel URI</a>");
		toolkit.adapt(linkGenmodel, true, true);

		txtGenmodel = new Text(grpDomainModelDefinition, SWT.BORDER);
		txtGenmodel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		toolkit.adapt(txtGenmodel, true, true);

		Button btnBrowseGenmodel = new Button(grpDomainModelDefinition,
				SWT.NONE);

		btnBrowseGenmodel.setText("Browse");
		toolkit.adapt(btnBrowseGenmodel, true, true);

		Label lblRootContainerModel = new Label(grpDomainModelDefinition,
				SWT.NONE);
		lblRootContainerModel.setBounds(0, 0, 55, 15);
		toolkit.adapt(lblRootContainerModel, true, true);
		lblRootContainerModel.setText("Root container model element");

		txtRootContainerModelElement = new Text(grpDomainModelDefinition,
				SWT.BORDER);
		txtRootContainerModelElement.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));
		txtRootContainerModelElement.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtRootContainerModelElement, true, true);

		Button btSelectRootModelElement = new Button(grpDomainModelDefinition,
				SWT.NONE);
		btSelectRootModelElement.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		btSelectRootModelElement.setBounds(0, 0, 75, 25);
		toolkit.adapt(btSelectRootModelElement, true, true);
		btSelectRootModelElement.setText("Select");

		Group grpConcreteSyntaxDefinition = new Group(this, SWT.NONE);
		grpConcreteSyntaxDefinition.setText("Concrete syntax definition");
		toolkit.adapt(grpConcreteSyntaxDefinition);
		toolkit.paintBordersFor(grpConcreteSyntaxDefinition);
		grpConcreteSyntaxDefinition.setLayout(new GridLayout(1, false));
		
		lblSupportedFileExtensions = new Label(grpConcreteSyntaxDefinition, SWT.NONE);
		toolkit.adapt(lblSupportedFileExtensions, true, true);
		lblSupportedFileExtensions.setText("Supported file extensions :");

		Group grpTextualEditor = new Group(grpConcreteSyntaxDefinition,
				SWT.NONE);
		grpTextualEditor.setLayout(new GridLayout(3, false));
		GridData gd_grpTextualEditor = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1);
		gd_grpTextualEditor.heightHint = 49;
		grpTextualEditor.setLayoutData(gd_grpTextualEditor);
		grpTextualEditor.setText("Textual editor");
		grpTextualEditor.setBounds(0, 0, 70, 82);
		toolkit.adapt(grpTextualEditor);
		toolkit.paintBordersFor(grpTextualEditor);

		Link linkXTextEditorProject = new Link(grpTextualEditor, SWT.NONE);
		linkXTextEditorProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkXTextEditorProject, true, true);
		linkXTextEditorProject.setText("<a>xText project</a>");

		txtXTextEditorProject = new Text(grpTextualEditor, SWT.BORDER);
		GridData gd_txtXTextEditorProject = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1);
		gd_txtXTextEditorProject.widthHint = 279;
		txtXTextEditorProject.setLayoutData(gd_txtXTextEditorProject);
		txtXTextEditorProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtXTextEditorProject, true, true);

		Button btnBrowseXtextEditor = new Button(grpTextualEditor, SWT.NONE);
		btnBrowseXtextEditor.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnBrowseXtextEditor, true, true);
		btnBrowseXtextEditor.setText("Browse");

		Group grpGraphicalEditor = new Group(grpConcreteSyntaxDefinition,
				SWT.NONE);
		grpGraphicalEditor.setLayout(new GridLayout(3, false));
		grpGraphicalEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpGraphicalEditor.setText("Graphical editor");
		grpGraphicalEditor.setBounds(0, 0, 70, 82);
		toolkit.adapt(grpGraphicalEditor);
		toolkit.paintBordersFor(grpGraphicalEditor);

		Link linkSiriusEditorProject = new Link(grpGraphicalEditor, 0);
		linkSiriusEditorProject
				.setText("<a>Sirius viewpoint design project</a>");
		linkSiriusEditorProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkSiriusEditorProject, true, true);

		txtSiriusEditorProject = new Text(grpGraphicalEditor, SWT.BORDER);
		GridData gd_txtSiriusEditorProject = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtSiriusEditorProject.widthHint = 181;
		txtSiriusEditorProject.setLayoutData(gd_txtSiriusEditorProject);
		txtSiriusEditorProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtSiriusEditorProject, true, true);

		Button btnBrowseSiriusEditor = new Button(grpGraphicalEditor, SWT.NONE);
		btnBrowseSiriusEditor.setText("Browse");
		btnBrowseSiriusEditor.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnBrowseSiriusEditor, true, true);

		Group grpAnimationDefinition = new Group(grpConcreteSyntaxDefinition,
				SWT.NONE);
		grpAnimationDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpAnimationDefinition.setText("Animation definition");
		toolkit.adapt(grpAnimationDefinition);
		toolkit.paintBordersFor(grpAnimationDefinition);
		grpAnimationDefinition.setLayout(new GridLayout(3, false));

		Label lblThisSectionDescribes_3 = new Label(grpAnimationDefinition,
				SWT.NONE);
		lblThisSectionDescribes_3.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblThisSectionDescribes_3
				.setText("This section describes the animation views for this language.");
		toolkit.adapt(lblThisSectionDescribes_3, true, true);

		Link linkSiriusAnimatorProject = new Link(grpAnimationDefinition, 0);
		linkSiriusAnimatorProject
				.setText("<a>Sirius viewpoint design project</a>");
		toolkit.adapt(linkSiriusAnimatorProject, true, true);

		txtSiriusAnimationProject = new Text(grpAnimationDefinition, SWT.BORDER);
		GridData gd_txtSiriusAnimationProject = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_txtSiriusAnimationProject.widthHint = 182;
		txtSiriusAnimationProject.setLayoutData(gd_txtSiriusAnimationProject);
		toolkit.adapt(txtSiriusAnimationProject, true, true);

		Button btnBrowseSiriusAnimator = new Button(grpAnimationDefinition,
				SWT.NONE);
		btnBrowseSiriusAnimator.setText("Browse");

		toolkit.adapt(btnBrowseSiriusAnimator, true, true);
		new Label(grpAnimationDefinition, SWT.NONE);
		new Label(grpAnimationDefinition, SWT.NONE);
		new Label(grpAnimationDefinition, SWT.NONE);

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

		Label lblNewLabel_1 = new Label(grpDsaDefinition, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 3, 1));
		lblNewLabel_1.setBounds(0, 0, 55, 15);
		toolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1
				.setText("This section describes the execution function and data about this language.");

		Link linkDSAProject = new Link(grpDsaDefinition, SWT.NONE);
		linkDSAProject.setBounds(0, 0, 49, 15);
		toolkit.adapt(linkDSAProject, true, true);
		linkDSAProject.setText("<a>K3 project</a>");

		txtDSAProject = new Text(grpDsaDefinition, SWT.BORDER);
		GridData gd_txtDSAProject = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDSAProject.widthHint = 215;
		txtDSAProject.setLayoutData(gd_txtDSAProject);
		txtDSAProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtDSAProject, true, true);

		Button btnBrowseDSAProject = new Button(grpDsaDefinition, SWT.NONE);
		btnBrowseDSAProject.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnBrowseDSAProject, true, true);
		btnBrowseDSAProject.setText("Browse");

		
		
		Group grpMocDefinitionLibrary = new Group(grpBehaviorDefinition,
				SWT.NONE);
		grpMocDefinitionLibrary.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));
		grpMocDefinitionLibrary.setText("MoC definition library");
		toolkit.adapt(grpMocDefinitionLibrary);
		toolkit.paintBordersFor(grpMocDefinitionLibrary);
		grpMocDefinitionLibrary.setLayout(new GridLayout(3, false));

		Label lblThisSectionDescribes_2 = new Label(grpMocDefinitionLibrary,
				SWT.NONE);
		lblThisSectionDescribes_2.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblThisSectionDescribes_2
				.setText("This section describes the reusable MoC definitions used by this language.");
		lblThisSectionDescribes_2.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblThisSectionDescribes_2, true, true);

		Link linkMoCCMLProject = new Link(grpMocDefinitionLibrary, 0);
		linkMoCCMLProject.setText("<a>MoCCML project</a>");
		linkMoCCMLProject.setBounds(0, 0, 60, 15);
		toolkit.adapt(linkMoCCMLProject, true, true);

		txtMoCCProject = new Text(grpMocDefinitionLibrary, SWT.BORDER);
		GridData gd_txtMoCCProject = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtMoCCProject.widthHint = 178;
		txtMoCCProject.setLayoutData(gd_txtMoCCProject);
		txtMoCCProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtMoCCProject, true, true);

		Button btnBrowseMoCCProject = new Button(grpMocDefinitionLibrary,
				SWT.NONE);
		btnBrowseMoCCProject.setText("Browse");
		btnBrowseMoCCProject.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseMoCCProject, true, true);

		Group grpDSEDefinition = new Group(grpBehaviorDefinition, SWT.NONE);
		grpDSEDefinition.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		grpDSEDefinition.setText("DSE definition");
		toolkit.adapt(grpDSEDefinition);
		toolkit.paintBordersFor(grpDSEDefinition);
		grpDSEDefinition.setLayout(new GridLayout(3, false));

		Label lblThisSectionDescribes_1 = new Label(grpDSEDefinition, SWT.NONE);
		lblThisSectionDescribes_1.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		lblThisSectionDescribes_1
				.setText("This section describes the Domain Specific Event of this language.");
		lblThisSectionDescribes_1.setBounds(0, 0, 397, 15);
		toolkit.adapt(lblThisSectionDescribes_1, true, true);

		Link linkDSEProject = new Link(grpDSEDefinition, 0);
		linkDSEProject.setText("<a>ECL project</a>");
		linkDSEProject.setBounds(0, 0, 53, 15);
		toolkit.adapt(linkDSEProject, true, true);

		txtDSEProject = new Text(grpDSEDefinition, SWT.BORDER);
		GridData gd_txtDSEProject = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDSEProject.widthHint = 212;
		txtDSEProject.setLayoutData(gd_txtDSEProject);
		txtDSEProject.setBounds(0, 0, 76, 21);
		toolkit.adapt(txtDSEProject, true, true);

		Button btnBrowseDSEProject = new Button(grpDSEDefinition, SWT.NONE);
		btnBrowseDSEProject.setText("Browse");
		btnBrowseDSEProject.setBounds(0, 0, 50, 25);
		toolkit.adapt(btnBrowseDSEProject, true, true);
		
		initLinkListeners(linkEMFProject, linkGenmodel, linkXTextEditorProject,
				linkSiriusEditorProject, linkSiriusAnimatorProject,
				linkDSAProject, linkDSEProject, linkMoCCMLProject);

		initButtonListeners(btnBrowseEMFProject, btnBrowseGenmodel,
				btSelectRootModelElement, btnBrowseXtextEditor,
				btnBrowseSiriusEditor, btnBrowseSiriusAnimator,
				btnBrowseDSAProject, btnBrowseMoCCProject, btnBrowseDSEProject);

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
		txtLanguageName.setText(xdsmlWrappedObject.getLanguageName());
		txtEMFProject.setText(xdsmlWrappedObject.getDomainModelProjectName());
		txtGenmodel.setText(xdsmlWrappedObject.getGenmodelLocationURI());
		txtRootContainerModelElement.setText(xdsmlWrappedObject
				.getRootContainerModelElement());
		txtXTextEditorProject.setText(xdsmlWrappedObject
				.getXTextEditorProjectName());
		txtSiriusEditorProject.setText(xdsmlWrappedObject
				.getSiriusEditorProjectName());
		txtSiriusAnimationProject.setText(xdsmlWrappedObject
				.getSiriusAnimatorProjectName());
		txtDSAProject.setText(xdsmlWrappedObject.getDSAProjectName());
		txtDSEProject.setText(xdsmlWrappedObject.getDSEProjectName());
		txtMoCCProject.setText(xdsmlWrappedObject.getMoCCProjectName());	
		lblSupportedFileExtensions.setText(xdsmlWrappedObject.getSupportedFileExtension());
	}

	/**
	 * Initialize the modifyListener for the txt field They are in charge of
	 * reflecting the change to the underlying model via the bean Note that they
	 * must act in a TransactionalEditingDomain in order to be correctly handled
	 */
	protected void initTxtListeners() {
		// all the listeners that will really edit the model

		txtLanguageName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								rootModelElement.setName(text.getText());
							}
						});
			}
		});
		txtEMFProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject
										.setDomainModelProjectName(text
												.getText());
								/*
								 * rootModelElement.getLanguageDefinition()
								 * .getDomainModelProject()
								 * .setProjectName(text.getText());
								 */
							}
						});
			}
		});
		txtXTextEditorProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								for (EditorProject editor : rootModelElement
										.getEditorProjects()) {
									if (editor instanceof XTextEditorProject) {
										editor.setProjectName(text.getText());
									}
								}
							}
						});
			}
		});
		txtSiriusEditorProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject
										.setSiriusEditorProjectName(text
												.getText());
							}
						});
			}
		});
		txtGenmodel.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setGenmodelLocationURI(text
										.getText());
							}
						});
			}
		});
		txtRootContainerModelElement.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject
										.setRootContainerModelElement(text
												.getText());
							}
						});
			}
		});

		txtSiriusAnimationProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject
										.setSiriusAnimatorProjectName(text
												.getText());
							}
						});
			}
		});

		txtDSAProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setDSAProjectName(text
										.getText());
							}
						});
			}
		});
		txtDSEProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setDSEProjectName(text
										.getText());
							}
						});
			}
		});
		txtMoCCProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
				final Text text = (Text) e.widget;
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								xdsmlWrappedObject.setMoCCProjectName(text
										.getText());
							}
						});
			}
		});

	}

	/**
	 * Creates the listeners in charge of the behavior for the links
	 */
	protected void initLinkListeners(Link linkEMFProject, Link linkGenmodel,
			Link linkXTextEditorProject, Link linkSiriusEditorProject,
			Link linkSiriusAnimatorProject, Link linkDSAProject, 
			Link linkDSEProject,  Link linkMoCCMLProject) {
		linkEMFProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtEMFProject.getText().isEmpty()) {
					// open the relevant files of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtEMFProject.getText());
					if (project.exists()) {
						// open the editor on one of the ecore files
						OpenEditor.openPossibleFileWithExtensionInProject(project, "ecore");
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateDomainModelWizardContextAction action = new CreateDomainModelWizardContextAction(
										rootModelElement);
								action.actionToExecute = CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
								action.execute();
								initControlFromWrappedObject();
							}
						});
			}
		});

		linkGenmodel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtGenmodel.getText().isEmpty()) {
					// open the genmodel file
					IFile file = ResourcesPlugin
							.getWorkspace()
							.getRoot()
							.getFile(
									new Path(txtGenmodel.getText()
											.replaceFirst("platform:/resource",
													"")));
					if (file.exists()) {
						// open the editor on the manifest file
						OpenEditor.openIFile(file);
						return;
					}
				}
			}
		});

		linkXTextEditorProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtXTextEditorProject.getText().isEmpty()) {
					// open the relevant files of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtXTextEditorProject.getText());
					if (project.exists()) {
						// open the editor on one of the xtext files
						OpenEditor.openPossibleFileWithExtensionInProject(project, "xtext");
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(
										rootModelElement);
								action.actionToExecute = CreateEditorProjectAction.CREATE_NEW_XTEXT_PROJECT;
								action.execute();
								initControlFromWrappedObject();
							}
						});
			}
		});

		linkSiriusEditorProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtSiriusEditorProject.getText().isEmpty()) {
					// open the relevant files of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtSiriusEditorProject.getText());
					if (project.exists()) {
						// open the editor on one of the odesign files
						OpenEditor.openPossibleFileWithExtensionInProject(project, "odesign");
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(
										rootModelElement);
								action.actionToExecute = CreateEditorProjectAction.CREATE_NEW_SIRIUS_PROJECT;
								action.execute();
								initControlFromWrappedObject();
							}
						});
			}
		});

		linkSiriusAnimatorProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtSiriusAnimationProject.getText().isEmpty()) {
					// open the relevant files of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtSiriusAnimationProject.getText());
					if (project.exists()) {
						// open the editor on one of the odesign files
						OpenEditor.openPossibleFileWithExtensionInProject(project, "odesign");
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(
										rootModelElement);
								action.actionToExecute = CreateEditorProjectAction.CREATE_NEW_SIRIUS_PROJECT;
								action.execute();
								initControlFromWrappedObject();
							}
						});
			}
		});

		linkDSAProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtDSAProject.getText().isEmpty()) {
					// open the relevant files of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtDSAProject.getText());
					if (project.exists()) {
						// open the editor on one of the ecl files
						OpenEditor.openPossibleFileWithExtensionInProject(project, "xtend");
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateDSAWizardContextActionDSAK3 action = new CreateDSAWizardContextActionDSAK3(
										getCurrentIFile().getProject(),
										rootModelElement);
								action.createNewDSAProject();
								initControlFromWrappedObject();
							}
						});
			}
		});

		linkDSEProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtDSEProject.getText().isEmpty()) {
					// open the relevant files of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtDSEProject.getText());
					if (project.exists()) {
						// open the editor on one of the ecl files
						OpenEditor.openPossibleFileWithExtensionInProject(project, "ecl");
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateDSEWizardContextAction action = new CreateDSEWizardContextAction(
										getCurrentIFile().getProject(),
										rootModelElement);
								action.actionToExecute = CreateDSEAction.CREATE_NEW_DSE_PROJECT;
								action.execute();
								initControlFromWrappedObject();
							}
						});
			}
		});

		linkMoCCMLProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (!txtMoCCProject.getText().isEmpty()) {
					// open the MANIFEST.MF of the project
					IProject project = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(txtMoCCProject.getText());
					if (project.exists()) {
						// open the editor on the manifest file
						OpenEditor.openManifestForProject(project);
						return;
					}
				}
				// open the wizard to propose to create the project
				TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								CreateMOCCWizardContextAction action = new CreateMOCCWizardContextAction(
										getCurrentIFile().getProject(),
										rootModelElement);
								action.actionToExecute = CreateMOCCAction.CREATE_NEW_MOCC_PROJECT;
								action.execute();
								initControlFromWrappedObject();
							}
						});
			}
		});

	}

	/**
	 * Creates the listeners in charge of the behavior for the buttons
	 */
	protected void initButtonListeners(Button btnBrowseEMFProject,
			Button btnBrowseGenmodel, Button btSelectRootModelElement,
			Button btnBrowseXtextEditor, Button btnBrowseSiriusEditor,
			Button btnBrowseSiriusAnimator, Button btnBrowseDSAProject,
			Button btnBrowseMoCCProject, 
			Button btnBrowseDSEProject) {
		btnBrowseEMFProject.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectEMFIProjectDialog dialog = new SelectEMFIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtEMFProject.setText(((IProject) dialog.getResult()[0])
								.getName());
					}
					break;
				}
			}
		});

		btnBrowseGenmodel.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
					dialog.setPattern("*.genmodel");
					if (dialog.open() == Dialog.OK) {
						txtGenmodel.setText("platform:/resource"
								+ ((IResource) dialog.getResult()[0])
										.getFullPath().toString());
					}
					break;
				}
			}
		});
		btSelectRootModelElement.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					String xdsmlURIAsString = xdsmlWrappedObject.languageDefinition.getDomainModelProject().getGenmodeluri();
					if (xdsmlURIAsString != null) {
						LabelProvider labelProvider = new ENamedElementQualifiedNameLabelProvider();
						ResourceSet resSet = new ResourceSetImpl();
						resSet.getResource(URI.createURI(xdsmlURIAsString), true);
						SelectAnyEObjectDialog dialog = new SelectAnyConcreteEClassDialog(resSet, labelProvider);
						int res = dialog.open();
						if (res == WizardDialog.OK) {
							// update the project model
							// xdsmlWrappedObject.setRootContainerModelElement(labelProvider.getText(dialog.getFirstResult()));
							txtRootContainerModelElement.setText(labelProvider
									.getText(dialog.getFirstResult()));
						}
					}
					break;
				}
			}
		});

		btnBrowseXtextEditor.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectXtextIProjectDialog dialog = new SelectXtextIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtXTextEditorProject.setText(((IProject) dialog
								.getResult()[0]).getName());
					}
					break;
				}
			}
		});
		btnBrowseSiriusEditor.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectODesignIProjectDialog dialog = new SelectODesignIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtSiriusEditorProject.setText(((IProject) dialog
								.getResult()[0]).getName());
					}
					break;
				}
			}
		});
		btnBrowseSiriusAnimator.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectODesignIProjectDialog dialog = new SelectODesignIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtSiriusAnimationProject.setText(((IProject) dialog
								.getResult()[0]).getName());
					}
					break;
				}
			}
		});
		btnBrowseDSAProject.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectDSAIProjectDialog dialog = new SelectDSAIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtDSAProject.setText(((IProject) dialog.getResult()[0])
								.getName());
					}
					break;
				}
			}
		});
		
		
		btnBrowseMoCCProject.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectPluginIProjectDialog dialog = new SelectMoCCIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtMoCCProject.setText(((IProject) dialog.getResult()[0])
								.getName());
					}
					break;
				}
			}
		});
		btnBrowseDSEProject.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					SelectPluginIProjectDialog dialog = new SelectDSEIProjectDialog(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell());
					int res = dialog.open();
					if (res == WizardDialog.OK) {
						// update the project model
						txtDSEProject.setText(((IProject) dialog.getResult()[0])
								.getName());
					}
					break;
				}
			}
		});
		
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtLanguageNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtLanguageName);
		IObservableValue languageNameXdsmlWrappedObjectObserveValue = BeanProperties.value("languageName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtLanguageNameObserveWidget, languageNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtEMFProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtEMFProject);
		IObservableValue eMFProjectXdsmlWrappedObjectObserveValue = BeanProperties.value("domainModelProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtEMFProjectObserveWidget, eMFProjectXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtXTextEditorProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtXTextEditorProject);
		IObservableValue xTextEditorProjectXdsmlWrappedObjectObserveValue = BeanProperties.value("XTextEditorProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtXTextEditorProjectObserveWidget, xTextEditorProjectXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtSiriusEditorProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSiriusEditorProject);
		IObservableValue siriusEditorProjectXdsmlWrappedObjectObserveValue = BeanProperties.value("siriusEditorProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtSiriusEditorProjectObserveWidget, siriusEditorProjectXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtSiriusAnimationProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSiriusAnimationProject);
		IObservableValue siriusAnimatorProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("siriusAnimatorProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtSiriusAnimationProjectObserveWidget, siriusAnimatorProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtGenmodelObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtGenmodel);
		IObservableValue genmodelLocationURIXdsmlWrappedObjectObserveValue = BeanProperties.value("genmodelLocationURI").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtGenmodelObserveWidget, genmodelLocationURIXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtDSAProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtDSAProject);
		IObservableValue dSAProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("DSAProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtDSAProjectObserveWidget, dSAProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtMoCCProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtMoCCProject);
		IObservableValue moCCProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("moCCProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtMoCCProjectObserveWidget, moCCProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtDSEProjectObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtDSEProject);
		IObservableValue dSEProjectNameXdsmlWrappedObjectObserveValue = BeanProperties.value("DSEProjectName").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtDSEProjectObserveWidget, dSEProjectNameXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextTxtRootContainerModelElementObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtRootContainerModelElement);
		IObservableValue rootContainerModelElementXdsmlWrappedObjectObserveValue = BeanProperties.value("rootContainerModelElement").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextTxtRootContainerModelElementObserveWidget, rootContainerModelElementXdsmlWrappedObjectObserveValue, null, null);
		//
		IObservableValue observeTextLblSupportedFileExtensionsObserveWidget = WidgetProperties.text().observe(lblSupportedFileExtensions);
		IObservableValue supportedFileExtensionXdsmlWrappedObjectObserveValue = BeanProperties.value("supportedFileExtension").observe(xdsmlWrappedObject);
		bindingContext.bindValue(observeTextLblSupportedFileExtensionsObserveWidget, supportedFileExtensionXdsmlWrappedObjectObserveValue, null, null);
		//
		return bindingContext;
	}
}
