package org.gemoc.execution.engine.io.views.obeo;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.business.api.dialect.marker.TraceabilityMarkerNavigationProvider;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.IInstructionRevealer;

public class InstructionRevealer implements IInstructionRevealer
{

	private IPath _debuggerViewPath;
	
	public InstructionRevealer(IPath debuggerViewPath)
	{
		_debuggerViewPath = debuggerViewPath;
	}
	
	/**
	 * Show the given {@link EObject instruction}.
	 * @param airdURI 
	 * 
	 * @param instruction
	 *            the {@link EObject instruction} to show
	 */
	public void showInstruction(final EObject instruction) {
		final URI resourceURI = instruction.eResource().getURI();
		if (resourceURI.isPlatformResource()) {
			final String resourcePath = resourceURI.toPlatformString(true);
			final IResource resource = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourcePath));
			try {
				final IMarker marker = resource.createMarker(EValidator.MARKER);
				marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(instruction).toString());
				Session siriusSession = null;
				if (siriusSession == null) 
				{
					URI airdURI = URI.createPlatformResourceURI(_debuggerViewPath.toOSString(), true);
					siriusSession = SessionManager.INSTANCE.getExistingSession(airdURI);
				}
				if (siriusSession == null)
					return;
				if (!siriusSession.isOpen()) {
					siriusSession.open(new NullProgressMonitor());
				}
				SessionUIManager.INSTANCE.getOrCreateUISession(siriusSession);
				final TraceabilityMarkerNavigationProvider navigationProvider = new TraceabilityMarkerNavigationProvider(siriusSession);
				navigationProvider.gotoMarker(marker);
				marker.delete();
			} catch (CoreException e) {
				Activator.getDefault().error(e.getMessage());
			}
		}
	}
	
}
