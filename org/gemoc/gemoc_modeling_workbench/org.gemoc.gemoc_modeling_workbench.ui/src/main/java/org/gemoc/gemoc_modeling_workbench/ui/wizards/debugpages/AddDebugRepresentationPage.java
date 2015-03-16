package org.gemoc.gemoc_modeling_workbench.ui.wizards.debugpages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.gemoc.gemoc_modeling_workbench.ui.wizards.NewGemocDebugRepresentationWizard;

public class AddDebugRepresentationPage extends WizardPage {

	private final NewGemocDebugRepresentationWizard newGemocDebugRepresentationWizard;

	private Combo debugLayerCombo;

	private String layerName;

	public AddDebugRepresentationPage(
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

		debugLayerCombo = createDebugLayerComposite(composite);

		setControl(composite);
	}

	private Combo createDebugLayerComposite(final Composite composite) {
		GridLayout layout;
		final Composite projectNameComposite = new Composite(composite,
				SWT.NONE);
		projectNameComposite.setLayoutData(new GridData(
				GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 2;
		projectNameComposite.setLayout(layout);
		Label label = new Label(projectNameComposite, SWT.NONE);
		label.setText("Debug layer:");
		final Combo combo = new Combo(projectNameComposite, SWT.SINGLE);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		combo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				layerName = combo.getText();
				setPageComplete(layerName != null && layerName.length() > 0);
			}
		});
		combo.setText("Debug");

		return combo;
	}

	public void setDiagram(DiagramDescription diagram) {
		debugLayerCombo.removeAll();
		for (Layer layer : diagram.getAllLayers()) {
			debugLayerCombo.add(layer.getName());
		}
		debugLayerCombo.setText("Debug");
	}

	public String getLayerName() {
		return layerName;
	}

}
