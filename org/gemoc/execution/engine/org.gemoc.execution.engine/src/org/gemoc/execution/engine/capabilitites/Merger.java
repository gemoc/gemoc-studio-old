package org.gemoc.execution.engine.capabilitites;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.merge.AbstractMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;

class Merger extends AbstractMerger {

	public Merger() 
	{
		setRegistry(EMFCompareRCPPlugin.getDefault().getMergerRegistry());
	}
	
	@Override
	public boolean isMergerFor(Diff target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void copyRightToLeft(Diff target, Monitor monitor) {
		this.mergeDiff(target, true, monitor);
	}

	@Override
	public void copyLeftToRight(Diff target, Monitor monitor) {
		this.mergeDiff(target, false, monitor);
	}

}
