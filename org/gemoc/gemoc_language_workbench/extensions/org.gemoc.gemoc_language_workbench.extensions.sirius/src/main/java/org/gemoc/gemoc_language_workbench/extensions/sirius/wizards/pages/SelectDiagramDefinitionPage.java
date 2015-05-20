package org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.pages;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.NewGemocDebugRepresentationWizard;

/**
 * The diagram selection page.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public class SelectDiagramDefinitionPage extends WizardPage {

	private final NewGemocDebugRepresentationWizard newGemocDebugRepresentationWizard;

	private TreeViewer viewer;

	private DiagramDescription selected;

	private final ComposedAdapterFactory adapterFactory;

	public SelectDiagramDefinitionPage(
			NewGemocDebugRepresentationWizard newGemocDebugRepresentationWizard) {
		super("Select diagram definition");
		this.newGemocDebugRepresentationWizard = newGemocDebugRepresentationWizard;

		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	@Override
	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		composite.setLayout(layout);

		viewer = new TreeViewer(composite, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL);
		viewer.getControl()
				.setLayoutData(
						new GridData(GridData.FILL_HORIZONTAL
								| GridData.FILL_VERTICAL));
		viewer.setContentProvider(new AdapterFactoryContentProvider(
				adapterFactory) {

			@Override
			public Object[] getElements(Object object) {
				final Object[] res;

				if (object instanceof List) {
					List<?> list = (List<?>) object;
					res = list.toArray(new Object[list.size()]);
				} else {
					res = super.getElements(object);
				}

				return res;
			}

			@Override
			public Object[] getChildren(Object object) {
				return null;
			}

			@Override
			public Object getParent(Object object) {
				return null;
			}

			@Override
			public boolean hasChildren(Object object) {
				return false;
			}

		});
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					selected = (DiagramDescription) ((IStructuredSelection) event
							.getSelection()).getFirstElement();
					if (selected != null) {
						if (newGemocDebugRepresentationWizard
								.getDebugRepresentationSelectionPage()
								.getSelected() == DebugRepresentationSelectionPage.CREATE_VIEWPOINT_EXTENSION) {
							newGemocDebugRepresentationWizard
									.getNewViewPointProjectPage()
									.setDiagramToExtend(selected);
						} else if (newGemocDebugRepresentationWizard
								.getDebugRepresentationSelectionPage()
								.getSelected() == DebugRepresentationSelectionPage.ADD_DEBUG_LAYER) {
							newGemocDebugRepresentationWizard
									.getAddDebugRepresentationPage()
									.setDiagram(selected);
						}
					}
					setPageComplete(selected != null);
				}
			}
		});

		setControl(composite);
		setPageComplete(selected != null);
	}

	public DiagramDescription getSelectedDiagram() {
		return selected;
	}

	public void setDescriptions(List<DiagramDescription> descriptions) {
		viewer.setInput(descriptions);
		selected = null;
		setPageComplete(false);
	}

	@Override
	public void dispose() {
		super.dispose();
		viewer.getLabelProvider().dispose();
		viewer.getContentProvider().dispose();
		viewer.getControl().dispose();
		adapterFactory.dispose();
	}

	@Override
	public IWizardPage getNextPage() {
		final IWizardPage res;

		if (newGemocDebugRepresentationWizard
				.getDebugRepresentationSelectionPage().getSelected() == DebugRepresentationSelectionPage.CREATE_VIEWPOINT_EXTENSION) {
			res = newGemocDebugRepresentationWizard
					.getNewViewPointProjectPage();
		} else if (newGemocDebugRepresentationWizard
				.getDebugRepresentationSelectionPage().getSelected() == DebugRepresentationSelectionPage.ADD_DEBUG_LAYER) {
			res = newGemocDebugRepresentationWizard
					.getAddDebugRepresentationPage();
		} else {
			res = null;
		}

		return res;
	}

}