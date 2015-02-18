package org.gemoc.gemoc_language_workbench.extensions.sirius.modelloader;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionAuthority;
import org.eclipse.sirius.ecore.extender.business.api.permission.IPermissionProvider;
import org.gemoc.execution.engine.core.DebugURIHandler;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionCheckpoint;

public class DebugPermissionProvider implements IPermissionProvider {

	@Override
	public boolean provides(ResourceSet set) {
		final boolean res;
		
		if (set !=null
			&& set.getURIConverter() != null) {
			URIConverter converter = set.getURIConverter();
			if (converter.getURIHandlers().size() > 0) {
				res = converter.getURIHandlers().get(0) instanceof DebugURIHandler;
			} else {
				res = false;
			}
		} else {
			res = false;
		}
		
		return res;
	}

	@Override
	public IPermissionAuthority getAuthority(final ResourceSet set) {
		final DebugPermissionAuthority res = new DebugPermissionAuthority();

		IExecutionCheckpoint.CHECKPOINTS.put(set, res);
		if (set.getResources().size() > 0) {
			final Session session = SessionManager.INSTANCE.getSession(set
					.getResources().get(0));
			if (session != null) {
				session.addListener(new SessionListener() {

					@Override
					public void notify(int changeKind) {
						if (changeKind == SessionListener.CLOSED) {
							IExecutionCheckpoint.CHECKPOINTS.remove(set);
						}
					}
				});
			}
		}

		return res;
	}

}
