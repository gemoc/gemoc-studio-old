package fr.inria.aoste.timesquare.backend.vcdgenerator;

import org.eclipse.emf.ecore.EObject;

import fr.inria.aoste.timesquare.backend.manager.utils.IFilter;
import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.timesquare.trace.util.adapter.AdapterRegistry;

public final class FilterClock implements IFilter<ClockEntity> {
	
	@Override
	public boolean accept(ClockEntity o) {
		EObject eo = HelperFactory.getLastReference(o.getModelElementReference());
		return AdapterRegistry.getAdapter(eo).isClock(eo);
	}
}