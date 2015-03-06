package org.gemoc.gemoc_language_workbench.extensions.sirius.modelloader;

import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.resource.ResourceSetFactory;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.tools.internal.command.ChangeLayerActivationCommand;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.palette.ToolFilter;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.tool.AbstractToolDescription;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.XtextPlatformResourceURIHandler;
import org.eclipse.xtext.util.StringInputStream;
import org.gemoc.execution.engine.core.CommandExecution;
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
				session = openNewSiriusSession(context, context.getRunConfiguration()
						.getAnimatorURI());
				resourceSet = session.getTransactionalEditingDomain()
						.getResourceSet();
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		} else 
		{			
			resourceSet = new ResourceSetImpl();
		}
		resource = resourceSet.getResources().get(0);
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

	private Session openNewSiriusSession(IExecutionContext context, URI sessionResourceURI)
			throws CoreException 
	{
		// calculating new model URI
		String additionalInfo = "?mm=http://tfsmextended";		
		String modelURIAsString = context.getRunConfiguration().getExecutedModelURI().toString().replace("platform:/", "melange:/") + additionalInfo;
		URI modelURI = URI.createURI(modelURIAsString);

		// create and configure resource set
		final ResourceSet rs = createAndConfigureResourceSet(additionalInfo, modelURI);
		
		// load model resource and resolve all proxies
		Resource r = rs.getResource(modelURI, true);
		
		// calculating aird URI
		URI airdURI = URI.createURI(sessionResourceURI.toString().replace("platform:/", "melange:/"));		
		//URI airdURI = sessionResourceURI;

		// create and load sirius session
		final Session session = DebugSessionFactory.INSTANCE.createSession(rs, airdURI);
		final IProgressMonitor monitor = new NullProgressMonitor();
		final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		session.open(monitor);
		EcoreUtil.resolveAll(rs);
		// activating layers
		for (DView view : session.getSelectedViews()) {
			for (DRepresentation representation : view
					.getOwnedRepresentations()) {
				final DSemanticDiagramSpec diagram = (DSemanticDiagramSpec) representation;

				final List<EObject> elements = new ArrayList<EObject>();
				elements.add(diagram);

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
				
				RecordingCommand command = new RecordingCommand(
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
				};
				CommandExecution.execute(editingDomain, command);
			}
		}
		return session;
	}

	private ResourceSet createAndConfigureResourceSet(String additionalInfo, URI modelURI) 
	{
		final ResourceSet rs = ResourceSetFactory.createFactory().createResourceSet(modelURI);
		// fix sirius to prevent non intentional model savings
		rs.getURIConverter().getURIHandlers().add(0, new DebugURIHandler());
		final String fileExtension = modelURI.fileExtension();
		final XMLURIHandler handler = new XMLURIHandler(additionalInfo, fileExtension);
		handler.setResourceSet(rs);
		rs.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, handler);
		rs.setURIConverter(new MelangeURIConverter(fileExtension));
		return rs;
	}

	
	class MelangeURIConverter extends ExtensibleURIConverterImpl
	{

		private String _fileExtension;

		public MelangeURIConverter(String fileExtension)
		{
			_fileExtension = fileExtension;
		}

		@Override
		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException 
		{
			InputStream result = null;
			// the URI to use for model loading is not melange:/... but platform:/... and without the ?xx=...
			URI uriToUse = uri;
			boolean useSuperMethod = true;
			
			if (uri.scheme().equals("melange"))
			{
				String uriAsString = uri.toString().replace("melange:/", "platform:/");
				if (uri.fileExtension() != null
					&& uri.fileExtension().equals(_fileExtension))
				{
					useSuperMethod = false;
					uriAsString = uriAsString.substring(0, uriAsString.indexOf('?'));
					uriToUse = URI.createURI(uriAsString);
					InputStream originalInputStream = null;
					try
					{
						originalInputStream = super.createInputStream(uriToUse, options);								
						String originalContent = convertStreamToString(originalInputStream);
						String modifiedContent = originalContent.replace("http://www.gemoc.org/sample/tfsm", "http://tfsmextended");
						result = new StringInputStream(modifiedContent);
					}
					finally
					{
						if (originalInputStream != null)
						{
							originalInputStream.close();
						}
					}
				}
				else
				{
					uriToUse = URI.createURI(uriAsString);					
				}
			}

			if (useSuperMethod)
			{				
				result = super.createInputStream(uriToUse, options);								
			}
			
//			// making sure that uri can be modified
//			if (uri.fileExtension() != null
//				&& uri.fileExtension().equals(_fileExtension)
//				&& uri.scheme().equals("melange"))
//			{
//				String uriAsString = uri.toString().replace("melange:/", "platform:/");
//				uriAsString = uriAsString.substring(0, uriAsString.indexOf('?'));
//				uriToUse = URI.createURI(uriAsString);
//				InputStream originalInputStream = null;
//				try
//				{
//					originalInputStream = super.createInputStream(uriToUse, options);								
//					String originalContent = convertStreamToString(originalInputStream);
//					String modifiedContent = originalContent.replace("http://www.gemoc.org/sample/tfsm", "http://tfsmextended");
//					result = new StringInputStream(modifiedContent);
//				}
//				finally
//				{
//					if (originalInputStream != null)
//					{
//						originalInputStream.close();
//					}
//				}
//			}
//			else
//			{
//			}
			return result;
		}
				
		private String convertStreamToString(java.io.InputStream is) 
		{
		    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		    return s.hasNext() ? s.next() : "";
		}
	}
	
	class XMLURIHandler extends XtextPlatformResourceURIHandler
	{
		
		private String _queryParameters;
		private String _fileExtension;
		
		public XMLURIHandler(String queryParameters, String fileExtension) 
		{
			_queryParameters = queryParameters;
			_fileExtension = fileExtension;
		}
		
		@Override
		public URI resolve(URI uri) 
		{
			URI resolvedURI = super.resolve(uri);
			if (resolvedURI.scheme().equals("melange")
				&& resolvedURI.fileExtension().equals(_fileExtension)
				&& !resolvedURI.toString().contains("?"))
			{				
				String fileExtensionWithPoint = "." + _fileExtension;
				int lastIndexOfFileExtension = resolvedURI.toString().lastIndexOf(fileExtensionWithPoint);
				String part1 = resolvedURI.toString().substring(0, lastIndexOfFileExtension);
				String part2 = fileExtensionWithPoint + _queryParameters;
				String part3 = resolvedURI.toString().substring(lastIndexOfFileExtension + fileExtensionWithPoint.length());
				String newURIAsString = part1 + part2 + part3;
				return URI.createURI(newURIAsString);
			}
			return resolvedURI;
		}
	}
		
}
