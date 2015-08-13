package org.gemoc.gemoc_language_workbench.extensions.sirius.modelloader;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.ecore.extender.business.api.permission.IAuthorityListener;
import org.eclipse.sirius.ecore.extender.business.api.permission.LockStatus;
import org.eclipse.sirius.ecore.extender.business.internal.permission.AbstractPermissionAuthority;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionCheckpoint;

public class DebugPermissionAuthority extends AbstractPermissionAuthority
		implements IExecutionCheckpoint {

	/**
	 * Strictly positive if allowed.
	 */
	private int allow;

	public void allow(boolean allow) {
		if (allow) {
			this.allow++;
		} else {
			this.allow--;
		}
	}

	@Override
	public boolean canEditFeature(EObject eObj, String featureName) {
		return allow > 0;
	}

	@Override
	public boolean canEditInstance(EObject eObj) {
		return allow > 0;
	}
	
	@Override
	public boolean canCreateIn(EObject eObj) {
		return allow > 0;
	}

	@Override
	public boolean canDeleteInstance(EObject target) {
		return allow > 0;
	}

	@Override
	public void notifyInstanceChange(EObject instance) {
		// nothing to do here
	}

	@Override
	public void notifyNewInstanceCreation(EObject instance) {
		// nothing to do here
	}

	@Override
	public void notifyInstanceDeletion(EObject instance) {
		// nothing to do here
	}

	@Override
	public void setReportIssues(boolean report) {
		// nothing to do here
	}
	
	@Override
	public void notifyLock(Collection<? extends EObject> elements) {
		for (IAuthorityListener listener : listeners) {
			listener.notifyIsLocked((Collection<EObject>) elements);
		}
	}

	@Override
	public void notifyUnlock(Collection<? extends EObject> elements) {
		for (IAuthorityListener listener : listeners) {
			listener.notifyIsReleased((Collection<EObject>) elements);
		}
	}

	@Override
	public LockStatus getLockStatus(EObject element) {
		return LockStatus.NOT_LOCKED;
	}

}
