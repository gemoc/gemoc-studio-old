package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Point;

import swing2swt.layout.FlowLayout;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction.CreateDomainModelAction;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.BeanProperties;

public class GemocXDSMLFormComposite extends Composite {
	private DataBindingContext m_bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtLanguageName;
	private Text txtEMFProject;
	private Text txtRootContainerModelElement;
	private Text txtXTextEditorProject;
	private Text txtSiriusEditorProject;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text;
	
	
	GemocLanguageWorkbenchConfiguration rootModelElement;
	AdapterFactoryEditingDomain editingDomain;
	
	XDSMLModelWrapper xdsmlWrappedObject = new XDSMLModelWrapper();

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
		linkEMFProject.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				/*
				 * IProject updatedGemocLanguageProject = context.getXdsmlFile()
				 * .getProject(); CreateDomainModelWizardContextAction action =
				 * new CreateDomainModelWizardContextAction(
				 * updatedGemocLanguageProject); action.actionToExecute =
				 * CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
				 * action.execute();
				 */
				if (!txtEMFProject.getText().isEmpty()) {
					// open the ecore or the project ?
				}
			}
		});

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
		linkGenmodel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		linkGenmodel.setText("<a>genmodel</a>");
		toolkit.adapt(linkGenmodel, true, true);

		text = new Text(grpDomainModelDefinition, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1));
		toolkit.adapt(text, true, true);

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

		Button btnNewButton = new Button(grpDomainModelDefinition, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		btnNewButton.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnNewButton, true, true);
		btnNewButton.setText("Select");

		Group grpConcreteSyntaxDefinition = new Group(this, SWT.NONE);
		grpConcreteSyntaxDefinition.setText("Concrete syntax definition");
		toolkit.adapt(grpConcreteSyntaxDefinition);
		toolkit.paintBordersFor(grpConcreteSyntaxDefinition);
		grpConcreteSyntaxDefinition.setLayout(new GridLayout(1, false));

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

		Button btnNewButton_1 = new Button(grpTextualEditor, SWT.NONE);
		btnNewButton_1.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnNewButton_1, true, true);
		btnNewButton_1.setText("Browse");

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

		Button btnBrowse_1 = new Button(grpGraphicalEditor, SWT.NONE);
		btnBrowse_1.setText("Browse");
		btnBrowse_1.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnBrowse_1, true, true);

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

		Link link_7 = new Link(grpAnimationDefinition, 0);
		link_7.setText("<a>Sirius viewpoint design project</a>");
		toolkit.adapt(link_7, true, true);

		text_9 = new Text(grpAnimationDefinition, SWT.BORDER);
		GridData gd_text_9 = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_text_9.widthHint = 182;
		text_9.setLayoutData(gd_text_9);
		toolkit.adapt(text_9, true, true);

		Button button_2 = new Button(grpAnimationDefinition, SWT.NONE);
		button_2.setText("Browse");
		toolkit.adapt(button_2, true, true);
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

		Link link_4 = new Link(grpDsaDefinition, SWT.NONE);
		link_4.setBounds(0, 0, 49, 15);
		toolkit.adapt(link_4, true, true);
		link_4.setText("<a>K3 project</a>");

		text_6 = new Text(grpDsaDefinition, SWT.BORDER);
		GridData gd_text_6 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_6.widthHint = 215;
		text_6.setLayoutData(gd_text_6);
		text_6.setBounds(0, 0, 76, 21);
		toolkit.adapt(text_6, true, true);

		Button btnNewButton_2 = new Button(grpDsaDefinition, SWT.NONE);
		btnNewButton_2.setBounds(0, 0, 75, 25);
		toolkit.adapt(btnNewButton_2, true, true);
		btnNewButton_2.setText("browse");

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

		text_8 = new Text(grpMocDefinitionLibrary, SWT.BORDER);
		GridData gd_text_8 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_8.widthHint = 178;
		text_8.setLayoutData(gd_text_8);
		text_8.setBounds(0, 0, 76, 21);
		toolkit.adapt(text_8, true, true);

		Button button_1 = new Button(grpMocDefinitionLibrary, SWT.NONE);
		button_1.setText("browse");
		button_1.setBounds(0, 0, 50, 25);
		toolkit.adapt(button_1, true, true);

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

		Link link_5 = new Link(grpDSEDefinition, 0);
		link_5.setText("<a>ECL project</a>");
		link_5.setBounds(0, 0, 53, 15);
		toolkit.adapt(link_5, true, true);

		text_7 = new Text(grpDSEDefinition, SWT.BORDER);
		GridData gd_text_7 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_7.widthHint = 212;
		text_7.setLayoutData(gd_text_7);
		text_7.setBounds(0, 0, 76, 21);
		toolkit.adapt(text_7, true, true);

		Button button = new Button(grpDSEDefinition, SWT.NONE);
		button.setText("browse");
		button.setBounds(0, 0, 50, 25);
		toolkit.adapt(button, true, true);

		m_bindingContext = initDataBindings();
	}

	public void initControl(AdapterFactoryEditingDomain editingDomain) {
		if (editingDomain != null){
			this.editingDomain = editingDomain;
			editingDomain.toString();
			if(editingDomain.getResourceSet().getResources().size() > 0){
				if(editingDomain.getResourceSet().getResources().get(0).getContents().size() > 0){
					EObject eObject = editingDomain.getResourceSet().getResources().get(0).getContents().get(0);
					if(eObject instanceof GemocLanguageWorkbenchConfiguration){
						GemocLanguageWorkbenchConfiguration confModelElement = (GemocLanguageWorkbenchConfiguration)eObject;
						rootModelElement = confModelElement;
						//txtLanguageName.setText(confModelElement.getLanguageDefinition().getName());
						xdsmlWrappedObject.init(confModelElement.getLanguageDefinition());
					}
				}
			}
		}
		
		initControlFromWrappedObject();

		initListeners();
	}
	
	protected void initControlFromWrappedObject(){
		txtLanguageName.setText(xdsmlWrappedObject.getLanguageName());
	}
	
	protected void initListeners(){
		txtLanguageName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// Get the widget whose text was modified
			    final Text text = (Text) e.widget;
			    TransactionalEditingDomain teditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
				editingDomain.getCommandStack().execute(
						new RecordingCommand(teditingDomain) {
							public void doExecute() {
								rootModelElement.getLanguageDefinition().setName(text.getText());
							}
						});
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
		return bindingContext;
	}
}
