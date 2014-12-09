package org.gemoc.gemoc_language_workbench.extensions.sirius.modelloader;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.resource.ResourceSetFactory;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.ui.tools.internal.commands.ChangeLayerActivationCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.gemoc.execution.engine.core.DebugURIHandler;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;

public class DefaultModelLoader implements IModelLoader {

	@Override
	public Resource loadModel(IExecutionContext context) 
			throws RuntimeException
	{
		Resource resource = null;
		ResourceSet resourceSet;
		if (context.getExecutionMode().equals(ExecutionMode.Animation)
			&& context.getRunConfiguration().getAnimatorURI() != null)
		{
			killPreviousSiriusSession(context.getRunConfiguration().getAnimatorURI());
			Session session;
			try {
				session = openNewSiriusSession(context.getRunConfiguration().getAnimatorURI());
				resourceSet = session.getTransactionalEditingDomain().getResourceSet();
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		else
		{
			resourceSet = new ResourceSetImpl();
		}
		resource = resourceSet.getResource(context.getRunConfiguration().getExecutedModelURI(), true);		
		return resource;
	}

	
	private void killPreviousSiriusSession(URI sessionResourceURI) 
	{
		Session session = SessionManager.INSTANCE.getExistingSession(sessionResourceURI);
		if (session != null) {
			session.close(new NullProgressMonitor());
			SessionManager.INSTANCE.remove(session);			
		}
	}
	
	
	private Session openNewSiriusSession(URI sessionResourceURI) throws CoreException {
		final ResourceSet set = ResourceSetFactory.createFactory().createResourceSet(sessionResourceURI);
		set.getURIConverter().getURIHandlers().add(0, new DebugURIHandler());
		final Session session = DebugSessionFactory.INSTANCE.createSession(set, sessionResourceURI);
		final IProgressMonitor monitor = new NullProgressMonitor();
		session.open(monitor);
		for (DView view : session.getSelectedViews())
		{
			for (DRepresentation representation : view.getOwnedRepresentations())
			{
				final DSemanticDiagramSpec diagram = (DSemanticDiagramSpec)representation;
				DialectUIManager.INSTANCE.openEditor(session, representation, monitor);

				final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
				final CommandStack commandStack = editingDomain.getCommandStack();
				commandStack.execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						for(Layer l : diagram.getDescription().getAdditionalLayers())
						{
							boolean mustBeActive = l.getName().toUpperCase().contains("DEBUG")
									|| l.getName().toUpperCase().contains("ANIMATION");
							if (mustBeActive
									&& !diagram.getActivatedLayers().contains(l))
							{
								ChangeLayerActivationCommand c = new ChangeLayerActivationCommand(
										editingDomain, 
										diagram, 
										l, 
										monitor);
								c.execute();															
							}
						}
					}
				});
			}
		}

		return session;
	}
}
