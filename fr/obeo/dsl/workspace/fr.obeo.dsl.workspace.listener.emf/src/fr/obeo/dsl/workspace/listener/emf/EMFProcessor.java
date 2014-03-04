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
package fr.obeo.dsl.workspace.listener.emf;

import fr.obeo.dsl.workspace.BundleDependency;
import fr.obeo.dsl.workspace.Container;
import fr.obeo.dsl.workspace.Dependency;
import fr.obeo.dsl.workspace.File;
import fr.obeo.dsl.workspace.Folder;
import fr.obeo.dsl.workspace.Project;
import fr.obeo.dsl.workspace.Resource;
import fr.obeo.dsl.workspace.State;
import fr.obeo.dsl.workspace.WorkspacePackage;
import fr.obeo.dsl.workspace.WorkspaceRoot;
import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.IAdd;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.IRemove;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceDescriptionChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.workbench.PageActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowDeactivated;
import fr.obeo.dsl.workspace.workbench.EditorReference;
import fr.obeo.dsl.workspace.workbench.ViewReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchPackage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPartReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Creates an EMF representation of the workspace and workbench.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EMFProcessor implements IChangeProcessor {

	/**
	 * Mapping from {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...) to {@link EObject}.
	 */
	private final Map<Object, EObject> map = new HashMap<Object, EObject>();

	/**
	 * The {@link State}.
	 */
	private final State state;

	/**
	 * Constructor.
	 */
	public EMFProcessor() {
		state = WorkspacePackage.eINSTANCE.getWorkspaceFactory().createState();
		final WorkspaceRoot workspace = WorkspacePackage.eINSTANCE.getWorkspaceFactory()
				.createWorkspaceRoot();
		state.setWorkspace(workspace);
		map.put(ResourcesPlugin.getWorkspace().getRoot(), workspace);
		WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace()).addProcessor(this, true);
		final WorkbenchRoot workbench = WorkbenchPackage.eINSTANCE.getWorkbenchFactory()
				.createWorkbenchRoot();
		state.setWorkbench(workbench);
		map.put(PlatformUI.getWorkbench(), workbench);
		WorkspaceUtils.getListener(PlatformUI.getWorkbench()).addProcessor(this, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		if (change instanceof IAdd<?>) {
			EObject eObj = create(change.getObject());
			map.put(change.getObject(), eObj);
			IListener listener = WorkspaceUtils.getListener(change.getObject());
			if (listener != null && shouldListenTo(change.getObject())) {
				listener.addProcessor(this, true);
			}
		} else if (change instanceof IRemove<?>) {
			EObject eObj = map.remove(change.getObject());
			if (eObj != null) {
				EcoreUtil.delete(eObj); // TODO optimize with a cross referencer
			}
		} else if (change instanceof ResourceOpened) {
			resourceOpened((ResourceOpened)change);
		} else if (change instanceof ResourceDescriptionChanged) {
			resourceDescriptionChanged((ResourceDescriptionChanged)change);
		} else if (change instanceof ResourceMoved) {
			resourceMoved((ResourceMoved)change);
		} else if (change instanceof WindowActivated) {
			windowActivated((WindowActivated)change);
		} else if (change instanceof WindowDeactivated) {
			windowDeactivated((WindowDeactivated)change);
		} else if (change instanceof PageActivated) {
			pageActivated((PageActivated)change);
		} else if (change instanceof PartActivated) {
			partActivated((PartActivated)change);
		} else if (change instanceof PartDeactivated) {
			partDeactivated((PartDeactivated)change);
		}
	}

	/**
	 * Process the given {@link ResourceDescriptionChanged} change.
	 * 
	 * @param change
	 *            the {@link ResourceDescriptionChanged} change
	 */
	protected void resourceDescriptionChanged(ResourceDescriptionChanged change) {
		if (change.getObject() instanceof IProject) {
			final IProject project = (IProject)change.getObject();
			final Project eProject = (Project)getObject(project);
			try {
				for (String natureId : project.getDescription().getNatureIds()) {
					eProject.getNatureId().add(natureId);
				}
			} catch (CoreException e) {
				Activator.getDefault().error(e);
			}
			checkBundleDependencies(project, eProject);
		}
	}

	/**
	 * Process the given {@link ResourceOpened} change.
	 * 
	 * @param change
	 *            the {@link ResourceOpened} change
	 */
	protected void resourceOpened(ResourceOpened change) {
		if (change.getObject() instanceof IProject) {
			final IProject project = (IProject)change.getObject();
			final Project eProject = (Project)getObject(project);
			try {
				for (String natureId : project.getDescription().getNatureIds()) {
					eProject.getNatureId().add(natureId);
				}
			} catch (CoreException e) {
				Activator.getDefault().error(e);
			}
			checkBundleDependencies(project, eProject);
		}
	}

	/**
	 * Process the given {@link PartDeactivated} change.
	 * 
	 * @param change
	 *            the {@link PartDeactivated} change
	 */
	protected void partDeactivated(PartDeactivated change) {
		final IWorkbenchPartReference part = change.getObject();
		final WorkbenchPage ePage = (WorkbenchPage)getObject(part.getPage());
		if (ePage != null) {
			ePage.setActivePart(null);
		}
	}

	/**
	 * Process the given {@link WindowDeactivated} change.
	 * 
	 * @param change
	 *            the {@link WindowDeactivated} change
	 */
	protected void windowDeactivated(WindowDeactivated change) {
		final IWorkbenchWindow window = change.getObject();
		final WorkbenchRoot eWorkbench = (WorkbenchRoot)getObject(window.getWorkbench());
		eWorkbench.setActiveWindow(null);
	}

	/**
	 * Process the given {@link ResourceMoved} change.
	 * 
	 * @param change
	 *            the {@link ResourceMoved} change
	 */
	protected void resourceMoved(ResourceMoved change) {
		final IResource origin = change.getObject();
		final IResource destination = change.getDestination();
		final Resource eOrigin = (Resource)getObject(origin);
		final IContainer destinationParent = destination.getParent();
		Container eDestinationParent = (Container)getObject(destinationParent);

		if (eDestinationParent == null) {
			if (destinationParent instanceof IProject) {
				eDestinationParent = createProject((IProject)destinationParent);
			} else {
				eDestinationParent = createFolder((IFolder)destinationParent);
			}
			map.put(destinationParent, eDestinationParent);
		}
		eDestinationParent.getMembers().add(eOrigin);
		eOrigin.setName(destination.getName());
		map.remove(origin);
		map.put(destination, eOrigin);
	}

	/**
	 * Process the given {@link PartActivated} change.
	 * 
	 * @param change
	 *            the {@link PartActivated} change
	 */
	protected void partActivated(PartActivated change) {
		final IWorkbenchPartReference part = change.getObject();
		final WorkbenchPartReference ePart = (WorkbenchPartReference)getObject(part);
		final WorkbenchPage ePage = (WorkbenchPage)getObject(part.getPage());
		if (ePage != null) {
			ePage.setActivePart(ePart);
		}
	}

	/**
	 * Process the given {@link PageActivated} change.
	 * 
	 * @param change
	 *            the {@link PageActivated} change
	 */
	protected void pageActivated(PageActivated change) {
		final IWorkbenchPage page = change.getObject();
		final WorkbenchPage ePage = (WorkbenchPage)getObject(page);
		final WorkbenchWindow eWindow = (WorkbenchWindow)getObject(page.getWorkbenchWindow());
		if (eWindow != null) {
			eWindow.setActivePage(ePage);
		}
	}

	/**
	 * Process the given {@link WindowActivated} change.
	 * 
	 * @param change
	 *            the {@link WindowActivated} change
	 */
	protected void windowActivated(WindowActivated change) {
		final IWorkbenchWindow window = change.getObject();
		final WorkbenchWindow eWorkbenchWindow = (WorkbenchWindow)getObject(window);
		final WorkbenchRoot eWorkbench = (WorkbenchRoot)getObject(window.getWorkbench());
		eWorkbench.setActiveWindow(eWorkbenchWindow);
	}

	/**
	 * Should we listen to the given {@link Object} from Eclipse (
	 * {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...) to {@link EObject}.
	 * 
	 * @param object
	 *            the {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *            {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *            {@link org.eclipse.ui.IWorkbench IWorkbench}, ...) to {@link EObject}
	 * @return <code>true</code> if we should listen, <code>false</code> otherwise
	 */
	protected boolean shouldListenTo(Object object) {
		return true;
	}

	/**
	 * Creates an {@link EObject} from the given {@link Object}.
	 * 
	 * @param object
	 *            the {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *            {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *            {@link org.eclipse.ui.IWorkbench IWorkbench}, ...)
	 * @return the created {@link EObject}
	 */
	protected EObject create(Object object) {
		final EObject res;

		if (object instanceof IProject) {
			res = createProject((IProject)object);
		} else if (object instanceof IFolder) {
			res = createFolder((IFolder)object);
		} else if (object instanceof IFile) {
			res = createFile((IFile)object);
		} else if (object instanceof IWorkbenchWindow) {
			res = createWorkbenchWindow((IWorkbenchWindow)object);
		} else if (object instanceof IWorkbenchPage) {
			res = createWorkbenchPage((IWorkbenchPage)object);
		} else if (object instanceof IEditorReference) {
			res = createEditorReference((IEditorReference)object);
		} else if (object instanceof IViewReference) {
			res = createViewReference((IViewReference)object);
		} else {
			throw new IllegalStateException("don't know how to handle " + object.getClass().getName());
		}

		return res;
	}

	/**
	 * Creates a {@link ViewReference} from the given {@link IViewReference}.
	 * 
	 * @param viewReference
	 *            the {@link IViewReference}
	 * @return the created {@link ViewReference}
	 */
	protected ViewReference createViewReference(IViewReference viewReference) {
		final ViewReference res = WorkbenchPackage.eINSTANCE.getWorkbenchFactory().createViewReference();

		res.setId(viewReference.getId());
		res.setTitle(viewReference.getTitle());
		res.setTitleToolTip(viewReference.getTitleToolTip());
		res.setName(viewReference.getPartName());

		final WorkbenchPage ePage = (WorkbenchPage)getObject(viewReference.getPage());
		ePage.getViews().add(res);

		return res;
	}

	/**
	 * Creates a {@link EditorReference} from the given {@link IEditorReference}.
	 * 
	 * @param editorReference
	 *            the {@link IEditorReference}
	 * @return the created {@link EditorReference}
	 */
	protected EditorReference createEditorReference(IEditorReference editorReference) {
		final EditorReference res = WorkbenchPackage.eINSTANCE.getWorkbenchFactory().createEditorReference();

		res.setId(editorReference.getId());
		res.setTitle(editorReference.getTitle());
		res.setTitleToolTip(editorReference.getTitleToolTip());
		res.setName(editorReference.getPartName());

		final WorkbenchPage ePage = (WorkbenchPage)getObject(editorReference.getPage());
		ePage.getEditors().add(res);

		return res;
	}

	/**
	 * Creates a {@link WorkbenchPage} from the given {@link IWorkbenchPage}.
	 * 
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @return the created {@link WorkbenchPage}
	 */
	protected WorkbenchPage createWorkbenchPage(IWorkbenchPage page) {
		final WorkbenchPage res = WorkbenchPackage.eINSTANCE.getWorkbenchFactory().createWorkbenchPage();

		final WorkbenchWindow eWindow = (WorkbenchWindow)getObject(page.getWorkbenchWindow());
		eWindow.getPages().add(res);

		return res;
	}

	/**
	 * Creates a {@link WorkbenchWindow} from the given {@link IWorkbenchWindow}.
	 * 
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @return the created {@link WorkbenchWindow}
	 */
	protected WorkbenchWindow createWorkbenchWindow(IWorkbenchWindow window) {
		final WorkbenchWindow res = WorkbenchPackage.eINSTANCE.getWorkbenchFactory().createWorkbenchWindow();
		state.getWorkbench().getWindows().add(res);
		return res;
	}

	/**
	 * Creates a {@link File} from the given {@link IFile}.
	 * 
	 * @param file
	 *            the {@link IFile}
	 * @return the created {@link File}
	 */
	protected File createFile(IFile file) {
		final File res = WorkspacePackage.eINSTANCE.getWorkspaceFactory().createFile();

		res.setName(file.getName());

		createContainers(file, res);

		return res;
	}

	/**
	 * Creates a {@link Folder} from the given {@link IFolder}.
	 * 
	 * @param folder
	 *            the {@link IFolder}
	 * @return the created {@link Folder}
	 */
	protected Folder createFolder(IFolder folder) {
		final Folder res = WorkspacePackage.eINSTANCE.getWorkspaceFactory().createFolder();

		res.setName(folder.getName());

		createContainers(folder, res);

		return res;
	}

	/**
	 * Creates a {@link Project} from the given {@link IProject}.
	 * 
	 * @param project
	 *            the {@link IProject}
	 * @return the created {@link Project}
	 */
	protected Project createProject(IProject project) {
		final Project res = WorkspacePackage.eINSTANCE.getWorkspaceFactory().createProject();

		res.setName(project.getName());
		if (project.isOpen()) {
			try {
				for (String natureId : project.getDescription().getNatureIds()) {
					res.getNatureId().add(natureId);
				}
			} catch (CoreException e) {
				Activator.getDefault().error(e);
			}
			checkBundleDependencies(project, res);
		}

		state.getWorkspace().getMembers().add(res);

		return res;
	}

	/**
	 * Checks if there are bundle dependencies.
	 * 
	 * @param project
	 *            the {@link IProject}
	 * @param eProject
	 *            the {@link Project}
	 */
	protected void checkBundleDependencies(IProject project, Project eProject) {
		if (PDE.hasPluginNature(project)) {
			final BundleContext context = Activator.getDefault().getBundle().getBundleContext();
			@SuppressWarnings("unchecked")
			ServiceReference<IBundleProjectService> ref = (ServiceReference<IBundleProjectService>)context
					.getServiceReference(IBundleProjectService.class.getName());
			if (ref != null) {
				IBundleProjectService service = context.getService(ref);
				if (service != null) {
					deleteBundleDependencies(eProject);
					try {
						final IBundleProjectDescription projectDesc = service.getDescription(project);
						for (IRequiredBundleDescription bundleDesc : projectDesc.getRequiredBundles()) {
							final BundleDependency dep = WorkspacePackage.eINSTANCE.getWorkspaceFactory()
									.createBundleDependency();
							dep.setId(bundleDesc.getName());
							dep.setLowerVersion(bundleDesc.getVersionRange().getLeft().toString());
							dep.setLowerVersionIncluded(bundleDesc.getVersionRange().getIncludeMinimum());
							dep.setUpperVersion(bundleDesc.getVersionRange().getRight().toString());
							dep.setUpperVersionIncluded(bundleDesc.getVersionRange().getIncludeMaximum());
							dep.setExported(bundleDesc.isExported());
							dep.setOptional(bundleDesc.isOptional());
							eProject.getDependencies().add(dep);
						}
					} catch (CoreException e) {
						Activator.getDefault().error(e);
					}
				}
				context.ungetService(ref);
			}
		}
	}

	/**
	 * Deletes {@link BundleDependency} for the given {@link Project}.
	 * 
	 * @param eProject
	 *            the {@link Project}
	 */
	protected void deleteBundleDependencies(Project eProject) {
		List<Dependency> toDelete = new ArrayList<Dependency>();
		for (Dependency dep : eProject.getDependencies()) {
			if (dep instanceof BundleDependency) {
				toDelete.add(dep);
			}
		}
		for (Dependency dep : toDelete) {
			EcoreUtil.delete(dep); // TODO optimize with a cross referencer
		}
	}

	/**
	 * Creates containers for the given resource.
	 * 
	 * @param resource
	 *            the Eclipse {@link IResource}
	 * @param eResource
	 *            the {@link Resource}
	 */
	protected void createContainers(IResource resource, Resource eResource) {
		final IContainer container = resource.getParent();
		Container eContainer = (Container)map.get(container);
		if (eContainer == null) {
			if (container instanceof IProject) {
				eContainer = createProject((IProject)container);
			} else if (container instanceof IFolder) {
				eContainer = createFolder((IFolder)container);
			}
			map.put(container, eContainer);
		}
		eContainer.getMembers().add(eResource);
	}

	/**
	 * Gets the {@link Resource} with the given {@link Resource#getName() name} from the given
	 * {@link Container}.
	 * 
	 * @param eContainer
	 *            the {@link Container}
	 * @param name
	 *            the {@link Resource#getName() name}
	 * @return the {@link Resource} with the given {@link Resource#getName() name} from the given
	 *         {@link Container} if any, <code>null</code> otherwise
	 */
	protected Resource getResource(Container eContainer, String name) {
		Resource res = null;

		for (Resource r : eContainer.getMembers()) {
			if (r.getName().equals(name)) {
				res = r;
				break;
			}
		}

		return res;
	}

	/**
	 * Gets {{@link EObject} corresponding to the given {@link Object} from Eclipse (
	 * {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...).
	 * 
	 * @param object
	 *            the {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *            {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *            {@link org.eclipse.ui.IWorkbench IWorkbench}, ...)
	 * @return the corresponding {@link EObject} if any, <code>null</code> otherwise
	 */
	public EObject getObject(Object object) {
		return map.get(object);
	}

}
