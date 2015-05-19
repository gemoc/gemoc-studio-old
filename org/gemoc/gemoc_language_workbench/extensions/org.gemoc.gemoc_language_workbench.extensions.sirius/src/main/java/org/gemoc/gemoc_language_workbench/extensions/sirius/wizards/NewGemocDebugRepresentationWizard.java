package org.gemoc.gemoc_language_workbench.extensions.sirius.wizards;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.query.ViewpointQuery;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramExtensionDescription;
import org.eclipse.sirius.ui.tools.api.project.ViewpointSpecificationProject;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.gemoc.gemoc_language_workbench.extensions.sirius.Activator;
import org.gemoc.gemoc_language_workbench.extensions.sirius.command.AddDebugLayerHandler;
import org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.pages.AddDebugRepresentationPage;
import org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.pages.DebugRepresentationSelectionPage;
import org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.pages.NewViewPointProjectPage;
import org.gemoc.gemoc_language_workbench.extensions.sirius.wizards.pages.SelectDiagramDefinitionPage;

/**
 * Wizard to create a new debug representation.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public class NewGemocDebugRepresentationWizard extends Wizard implements
		IWorkbenchWizard {

	private class FinishRunnable implements IRunnableWithProgress {

		boolean result = true;

		@Override
		public void run(IProgressMonitor monitor)
				throws InvocationTargetException, InterruptedException {
			if (getDebugRepresentationSelectionPage().getSelected() == DebugRepresentationSelectionPage.CREATE_VIEWPOINT_DEFINITION) {
				try {
					final String layerName = getAddDebugRepresentationPage()
							.getLayerName();
					final IProject project = ViewpointSpecificationProject
							.createNewViewpointSpecificationProject(
									getNewViewPointProjectPage()
											.getProjectName(),
									getNewViewPointProjectPage()
											.getViewpointSpecificationModelName());
					final Group group = getGroup();
					final DiagramDescription diagramDescription = createDiagramDescription(
							group, getNewViewPointProjectPage()
									.getViewpointName(),
							getNewViewPointProjectPage().getDiagramName());
					final String projectName = project.getName();
					final IFolder serviceFolder = project.getFolder(new Path(
							"src/"
									+ projectName.replaceAll("\\.", "/")
											.toLowerCase() + "/services"));
					final String languageName = diagramDescription.getName();
					final String qualifiedServiceClassName = AddDebugLayerHandler
							.getOrCreateServiceClass(serviceFolder,
									projectName, languageName, layerName,
									monitor);
					AddDebugLayerHandler.emfModifications(monitor, layerName,
							diagramDescription, languageName,
							qualifiedServiceClassName);
				} catch (CoreException e) {
					Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
					result = false;
				} catch (IOException e) {
					Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
					result = false;
				}
			} else if (getDebugRepresentationSelectionPage().getSelected() == DebugRepresentationSelectionPage.CREATE_VIEWPOINT_EXTENSION) {
				try {
					final String layerName = getAddDebugRepresentationPage()
							.getLayerName();
					final IProject project = ViewpointSpecificationProject
							.createNewViewpointSpecificationProject(
									getNewViewPointProjectPage()
											.getProjectName(),
									getNewViewPointProjectPage()
											.getViewpointSpecificationModelName());
					final Group group = getGroup();
					final DiagramExtensionDescription diagramExtensionDescription = createDiagramExtensionDescription(
							group, getNewViewPointProjectPage()
									.getViewpointName(),
							getNewViewPointProjectPage().getDiagramName(),
							getSelectDiagramDefinitionPage()
									.getSelectedDiagram());
					final String projectName = project.getName();
					final IFolder serviceFolder = project.getFolder(new Path(
							"src/"
									+ projectName.replaceAll("\\.", "/")
											.toLowerCase() + "/services"));
					final String languageName = diagramExtensionDescription
							.getName();
					final String qualifiedServiceClassName = AddDebugLayerHandler
							.getOrCreateServiceClass(serviceFolder,
									projectName, languageName, layerName,
									monitor);
					AddDebugLayerHandler.emfModifications(monitor, layerName,
							diagramExtensionDescription, languageName,
							qualifiedServiceClassName);
				} catch (CoreException e) {
					Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
					result = false;
				} catch (IOException e) {
					Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
					result = false;
				}
			} else if (getDebugRepresentationSelectionPage().getSelected() == DebugRepresentationSelectionPage.ADD_DEBUG_LAYER) {
				try {
					final String layerName = getAddDebugRepresentationPage()
							.getLayerName();
					DiagramDescription diagramDescription = getSelectDiagramDefinitionPage()
							.getSelectedDiagram();
					final String languageName = diagramDescription.getName();
					final IFile file = (IFile) ResourcesPlugin
							.getWorkspace()
							.getRoot()
							.findMember(
									diagramDescription.eResource().getURI()
											.toPlatformString(true));
					PlatformUI
							.getWorkbench()
							.getActiveWorkbenchWindow()
							.getActivePage()
							.openEditor(
									new FileEditorInput(file),
									PlatformUI.getWorkbench()
											.getEditorRegistry()
											.getDefaultEditor(file.getName())
											.getId());
					final Group group = getGroup();
					for (Viewpoint viewpoint : group.getOwnedViewpoints()) {
						for (RepresentationDescription representation : viewpoint
								.getOwnedRepresentations()) {
							if (diagramDescription.getName().equals(
									representation.getName())) {
								diagramDescription = (DiagramDescription) representation;
								break;
							}
						}
					}
					final IProject project = file.getProject();
					final String projectName = project.getName();
					final IFolder serviceFolder = project.getFolder(new Path(
							"src/"
									+ projectName.replaceAll("\\.", "/")
											.toLowerCase() + "/services"));
					String qualifiedServiceClassName;
					qualifiedServiceClassName = AddDebugLayerHandler
							.getOrCreateServiceClass(serviceFolder,
									projectName, languageName, layerName,
									monitor);
					AddDebugLayerHandler.emfModifications(monitor, layerName,
							diagramDescription, languageName,
							qualifiedServiceClassName);
				} catch (IOException e) {
					Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
					result = false;
				} catch (CoreException e) {
					Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
					result = false;
				}
			}
		}

		private DiagramExtensionDescription createDiagramExtensionDescription(
				final Group group, final String viewpointName,
				final String diagramName,
				final DiagramDescription diagramDescription) {
			final EditingDomain editingDomain = (EditingDomain) ((IEditingDomainProvider) group
					.eResource().getResourceSet()).getEditingDomain();
			final ChangeCommand recordingCommand = new ChangeCommand(
					group.eResource()) {

				private DiagramExtensionDescription diagramExtensionDesctiption;

				@Override
				protected void doExecute() {
					final Viewpoint viewpoint = DescriptionPackage.eINSTANCE
							.getDescriptionFactory().createViewpoint();
					viewpoint.setName(viewpointName);
					group.getOwnedViewpoints().add(viewpoint);
					diagramExtensionDesctiption = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
							.getDescriptionFactory()
							.createDiagramExtensionDescription();
					diagramExtensionDesctiption.setName(diagramName);
					diagramExtensionDesctiption
							.setViewpointURI(new ViewpointQuery(
									(Viewpoint) diagramDescription.eContainer())
									.getViewpointURI().get().toString());
					diagramExtensionDesctiption
							.setRepresentationName(diagramDescription.getName());
					viewpoint.getOwnedRepresentationExtensions().add(
							diagramExtensionDesctiption);
				}

				@Override
				public Collection<?> getResult() {
					ArrayList<DiagramExtensionDescription> res = new ArrayList<DiagramExtensionDescription>();
					res.add(diagramExtensionDesctiption);
					return res;
				}

			};
			editingDomain.getCommandStack().execute(recordingCommand);

			return (DiagramExtensionDescription) recordingCommand.getResult()
					.iterator().next();
		}

		private Group getGroup() {
			final Group res;
			final IEditorPart editor = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editor instanceof IEditingDomainProvider) {
				final EditingDomain editingDomain = ((IEditingDomainProvider) editor)
						.getEditingDomain();
				final ResourceSet resourceSet = editingDomain.getResourceSet();
				Group group = null;

				for (Resource resource : resourceSet.getResources()) {
					for (EObject eObj : resource.getContents()) {
						if (eObj instanceof Group) {
							group = (Group) eObj;
							break;
						}
					}
				}
				res = group;
			} else {
				res = null;
			}

			return res;
		}

		private DiagramDescription createDiagramDescription(final Group group,
				final String viewpointName, final String diagramName) {
			final EditingDomain editingDomain = (EditingDomain) ((IEditingDomainProvider) group
					.eResource().getResourceSet()).getEditingDomain();
			final ChangeCommand recordingCommand = new ChangeCommand(
					group.eResource()) {

				private DiagramDescription diagramDesctiption;

				@Override
				protected void doExecute() {
					final Viewpoint viewpoint = DescriptionPackage.eINSTANCE
							.getDescriptionFactory().createViewpoint();
					viewpoint.setName(viewpointName);
					group.getOwnedViewpoints().add(viewpoint);
					diagramDesctiption = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
							.getDescriptionFactory().createDiagramDescription();
					diagramDesctiption.setName(diagramName);
					viewpoint.getOwnedRepresentations().add(diagramDesctiption);
				}

				@Override
				public Collection<?> getResult() {
					ArrayList<DiagramDescription> res = new ArrayList<DiagramDescription>();
					res.add(diagramDesctiption);
					return res;
				}

			};
			editingDomain.getCommandStack().execute(recordingCommand);

			return (DiagramDescription) recordingCommand.getResult().iterator()
					.next();
		}

		public boolean getResult() {
			return result;
		}

	}

	private DebugRepresentationSelectionPage debugRepresentationSelectionPage = new DebugRepresentationSelectionPage(
			this);

	private SelectDiagramDefinitionPage selectDiagramDefinitionPage = new SelectDiagramDefinitionPage(
			this);

	private NewViewPointProjectPage newViewPointProjectPage = new NewViewPointProjectPage(
			this);

	private AddDebugRepresentationPage addDebugRepresentationPage = new AddDebugRepresentationPage(
			this);

	public NewGemocDebugRepresentationWizard() {
		super();
		setWindowTitle("Create GEMOC debug representation");
	}

	@Override
	public void addPages() {
		addPage(debugRepresentationSelectionPage);
		addPage(selectDiagramDefinitionPage);
		addPage(newViewPointProjectPage);
		addPage(addDebugRepresentationPage);
	}

	@Override
	public boolean canFinish() {
		boolean newViewpoint = debugRepresentationSelectionPage.getSelected() == DebugRepresentationSelectionPage.CREATE_VIEWPOINT_DEFINITION
				&& newViewPointProjectPage.isPageComplete()
				&& addDebugRepresentationPage.isPageComplete();
		boolean newViewpointExtension = debugRepresentationSelectionPage
				.getSelected() == DebugRepresentationSelectionPage.CREATE_VIEWPOINT_EXTENSION
				&& selectDiagramDefinitionPage.isPageComplete()
				&& newViewPointProjectPage.isPageComplete()
				&& addDebugRepresentationPage.isPageComplete();
		boolean newLayer = debugRepresentationSelectionPage.getSelected() == DebugRepresentationSelectionPage.ADD_DEBUG_LAYER
				&& selectDiagramDefinitionPage.isPageComplete()
				&& addDebugRepresentationPage.isPageComplete();
		return newViewpoint || newViewpointExtension || newLayer;
	}

	@Override
	public boolean performFinish() {
		final FinishRunnable finisher = new FinishRunnable();
		try {
			getContainer().run(false, true, finisher);
		} catch (InvocationTargetException e) {
			Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
		} catch (InterruptedException e) {
			Activator.getMessagingSystem().error(e.getMessage(), Activator.PLUGIN_ID, e);
		}

		return finisher.getResult();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// nothing to do here
	}

	public DebugRepresentationSelectionPage getDebugRepresentationSelectionPage() {
		return debugRepresentationSelectionPage;
	}

	public SelectDiagramDefinitionPage getSelectDiagramDefinitionPage() {
		return selectDiagramDefinitionPage;
	}

	public NewViewPointProjectPage getNewViewPointProjectPage() {
		return newViewPointProjectPage;
	}

	public AddDebugRepresentationPage getAddDebugRepresentationPage() {
		return addDebugRepresentationPage;
	}

}
