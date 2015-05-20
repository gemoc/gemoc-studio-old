package org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.pages;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.NewGemocDebugRepresentationWizard;

public class NewViewPointProjectPage extends WizardPage {

	private final NewGemocDebugRepresentationWizard newGemocDebugRepresentationWizard;

	private Text projectNameText;

	private Text viewpointSpecificationModelText;

	private Text viewpointNameText;

	private Text diagramNameText;

	private DiagramDescription diagramToExtends;

	public NewViewPointProjectPage(
			NewGemocDebugRepresentationWizard newGemocDebugRepresentationWizard) {
		super("Create Viewpoint definition project");
		this.newGemocDebugRepresentationWizard = newGemocDebugRepresentationWizard;
	}

	@Override
	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);

		final ModifyListener listener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				setPageComplete(isSet(diagramNameText)
						&& isSet(projectNameText) && isSet(viewpointNameText)
						&& isSet(viewpointSpecificationModelText));
			}

			private boolean isSet(Text text) {
				return text != null && !"".equals(text.getText());
			}

		};
		projectNameText = createProjectNameComposite(composite, listener);
		viewpointSpecificationModelText = createViewpointSpecificationModelNameComposite(
				composite, listener);
		viewpointNameText = createViewpointNameComposite(composite, listener);
		diagramNameText = createDiagramNameComposite(composite, listener);

		setControl(composite);
		setPageComplete(true);
	}

	private Text createProjectNameComposite(final Composite composite,
			ModifyListener listener) {
		GridLayout layout;
		final Composite projectNameComposite = new Composite(composite,
				SWT.NONE);
		projectNameComposite.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		projectNameComposite.setLayout(layout);
		Label label = new Label(projectNameComposite, SWT.None);
		label.setText("Project Name:");
		final Text text = new Text(projectNameComposite, SWT.SINGLE);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.addModifyListener(listener);
		text.setText("my.language.design");

		return text;
	}

	private Text createViewpointSpecificationModelNameComposite(
			final Composite composite, ModifyListener listener) {
		GridLayout layout;
		final Composite projectNameComposite = new Composite(composite,
				SWT.NONE);
		projectNameComposite.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		projectNameComposite.setLayout(layout);
		Label label = new Label(projectNameComposite, SWT.None);
		label.setText("Viewpoint Specification Model name:");
		final Text text = new Text(projectNameComposite, SWT.SINGLE);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.addModifyListener(listener);
		text.setText("language.odesign");

		return text;
	}

	private Text createViewpointNameComposite(final Composite composite,
			ModifyListener listener) {
		GridLayout layout;
		final Composite projectNameComposite = new Composite(composite,
				SWT.NONE);
		projectNameComposite.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		projectNameComposite.setLayout(layout);
		Label label = new Label(projectNameComposite, SWT.None);
		label.setText("Viewpoint Name:");
		final Text text = new Text(projectNameComposite, SWT.SINGLE);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.addModifyListener(listener);
		text.setText("LanguageViewpoint");

		return text;
	}

	private Text createDiagramNameComposite(final Composite composite,
			ModifyListener listener) {
		GridLayout layout;
		final Composite projectNameComposite = new Composite(composite,
				SWT.NONE);
		projectNameComposite.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		projectNameComposite.setLayout(layout);
		Label label = new Label(projectNameComposite, SWT.None);
		label.setText("Diagram Name:");
		final Text text = new Text(projectNameComposite, SWT.SINGLE);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text.addModifyListener(listener);
		text.setText("Language");

		return text;
	}

	@Override
	public IWizardPage getNextPage() {
		return newGemocDebugRepresentationWizard
				.getAddDebugRepresentationPage();
	}

	public String getProjectName() {
		return projectNameText.getText();
	}

	public String getViewpointSpecificationModelName() {
		return viewpointSpecificationModelText.getText();
	}

	public void setDiagramToExtend(DiagramDescription diagram) {
		diagramToExtends = diagram;
	}

	public DiagramDescription getDiagramToExtends() {
		return diagramToExtends;
	}

	public String getViewpointName() {
		return viewpointNameText.getText();
	}

	public String getDiagramName() {
		return diagramNameText.getText();
	}

}
