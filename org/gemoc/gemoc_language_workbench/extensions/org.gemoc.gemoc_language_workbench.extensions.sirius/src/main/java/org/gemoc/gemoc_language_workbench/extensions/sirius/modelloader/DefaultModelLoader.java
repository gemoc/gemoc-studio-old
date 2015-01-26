package org.gemoc.gemoc_language_workbench.extensions.sirius.modelloader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.resource.ResourceSetFactory;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.tools.internal.command.ChangeLayerActivationCommand;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.palette.ToolFilter;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority;
import org.eclipse.sirius.ecore.extender.business.api.permission.PermissionAuthorityRegistry;
import org.eclipse.sirius.ecore.extender.business.internal.permission.PermissionAuthorityRegistryImpl;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.tool.AbstractToolDescription;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.core.DebugURIHandler;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionCheckpoint;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.extensions.sirius.debug.DebugSessionFactory;
import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocAnimatorServices;

import fr.obeo.dsl.debug.ide.sirius.ui.services.AbstractDSLDebuggerServices;

public class DefaultModelLoader implements IModelLoader {

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	@Override
	public Resource loadModel(IExecutionContext context)
			throws RuntimeException {
		Resource resource = null;
		ResourceSet resourceSet;
		if (context.getExecutionMode().equals(ExecutionMode.Animation)
				&& context.getRunConfiguration().getAnimatorURI() != null) {
			killPreviousSiriusSession(context.getRunConfiguration()
					.getAnimatorURI());
			Session session;
			try {
				session = openNewSiriusSession(context.getRunConfiguration()
						.getAnimatorURI());
				resourceSet = session.getTransactionalEditingDomain()
						.getResourceSet();
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		} else {
			resourceSet = new ResourceSetImpl();
		}
		resource = resourceSet.getResource(context.getRunConfiguration()
				.getExecutedModelURI(), true);
		return resource;
	}

	private void killPreviousSiriusSession(URI sessionResourceURI) {
		Session session = SessionManager.INSTANCE
				.getExistingSession(sessionResourceURI);
		if (session != null) {
			session.close(new NullProgressMonitor());
			SessionManager.INSTANCE.remove(session);
		}
	}

	private Session openNewSiriusSession(URI sessionResourceURI)
			throws CoreException {
		final ResourceSet rs = ResourceSetFactory.createFactory()
				.createResourceSet(sessionResourceURI);
		rs.getURIConverter().getURIHandlers().add(0, new DebugURIHandler());
		final Session session = DebugSessionFactory.INSTANCE.createSession(rs,
				sessionResourceURI);
		final IProgressMonitor monitor = new NullProgressMonitor();
		final TransactionalEditingDomain editingDomain = session
				.getTransactionalEditingDomain();
		final CommandStack commandStack = editingDomain.getCommandStack();
		final List<EObject> elements = new ArrayList<EObject>();
		final DebugPermissionAuthority debugPermissionAuthority = addDebugPermissionAuthority(rs, elements);
		session.open(monitor);
		session.addListener(new SessionListener() {

			@Override
			public void notify(int changeKind) {
				if (changeKind == SessionListener.CLOSED) {
					removeDebugPermissionAuthority(rs);
				}
			}
		});
		for (DView view : session.getSelectedViews()) {
			for (DRepresentation representation : view
					.getOwnedRepresentations()) {
				final DSemanticDiagramSpec diagram = (DSemanticDiagramSpec) representation;

				elements.add(diagram);
				debugPermissionAuthority.notifyLock(elements);

				final IEditorPart editorPart = DialectUIManager.INSTANCE.openEditor(session, representation,
						monitor);
				if (editorPart instanceof DDiagramEditor) {
					((DDiagramEditor)editorPart).getPaletteManager().addToolFilter(new ToolFilter() {
						
						@Override
						public boolean filter(DDiagram diagram, AbstractToolDescription tool) {
							return true;
						}
					});
				}
				IExecutionCheckpoint checkpoint = IExecutionCheckpoint.CHECKPOINTS.get(editingDomain.getResourceSet());
				try {
					if (checkpoint != null) {
						checkpoint.allow(true);
					}
					commandStack.execute(new RecordingCommand(
							editingDomain, "Activating animator and debug layers") {
						@Override
						protected void doExecute() {
							for (Layer l : diagram.getDescription()
									.getAdditionalLayers()) {
								boolean mustBeActive = AbstractDSLDebuggerServices.LISTENER
										.isRepresentationToRefresh(MODEL_ID,
												diagram.getDescription().getName(), l.getName())
												|| AbstractGemocAnimatorServices.ANIMATOR
												.isRepresentationToRefresh(
														diagram.getDescription().getName(),
														l.getName());
								if (mustBeActive
										&& !diagram.getActivatedLayers()
										.contains(l)) {
									ChangeLayerActivationCommand c = new ChangeLayerActivationCommand(
											editingDomain, diagram, l, monitor);
									c.execute();
								}
							}
						}
					});
				} finally {
					if (checkpoint != null) {
						checkpoint.allow(false);
					}
				}
			}
		}

		return session;
	}

	/**
	 * Add a newly created {@link DebugPermissionAuthority} to the given
	 * {@link ResourceSet}.
	 * 
	 * @param rs
	 *            the {@link ResourceSet}
	 * @param elements 
	 * @param commandStack 
	 * @return the created {@link DebugPermissionAuthority}
	 */
	private DebugPermissionAuthority addDebugPermissionAuthority(ResourceSet rs, List<EObject> elements) {
		final DebugPermissionAuthority res = new DebugPermissionAuthority(elements);

		IExecutionCheckpoint.CHECKPOINTS.put(rs, res);
		getMapping().put(rs, res);

		return res;
	}

	/**
	 * Removes the {@link DebugPermissionAuthority} associated with the given
	 * {@link ResourceSet}.
	 * 
	 * @param rs
	 *            the {@link ResourceSet}
	 * @param commandStack 
	 */
	private void removeDebugPermissionAuthority(ResourceSet rs) {
		IExecutionCheckpoint.CHECKPOINTS.remove(rs);
		getMapping().remove(rs);
	}

	/**
	 * Gets the registry mapping. This is dirty but it prevents the
	 * {@link DebugPermissionAuthority} to be associated with irrelevant
	 * {@link ResourceSet}.
	 * 
	 * @return the registry mapping
	 */
	private Map<ResourceSet, IPermissionAuthority> getMapping() {
		Map<ResourceSet, IPermissionAuthority> res = null;

		Field mapField = null;
		for (Field field : PermissionAuthorityRegistryImpl.class
				.getDeclaredFields()) {
			if ("resourceSetToAuthority".equals(field.getName())) {
				mapField = field;
				break;
			}
		}
		if (mapField != null) {
			try {
				mapField.setAccessible(true);
				res = (Map<ResourceSet, IPermissionAuthority>) mapField
						.get(PermissionAuthorityRegistry.getDefault());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				mapField.setAccessible(false);
			}
		} else {
			throw new IllegalStateException(
					"PermissionAuthorityRegistryImpl.resourceSetToAuthority doesn't exist anymore ?");
		}

		return res;
	}
}
