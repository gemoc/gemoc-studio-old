package org.gemoc.sequential_addons.modelchangelistener.messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.gemoc.gemoc_language_workbench.api.core.IBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ISequentialExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public class SimpleModelChangeListenerAddon extends DefaultEngineAddon implements IModelChangeListenerAddon {

	private EContentAdapter adapter;
	private ISequentialExecutionEngine engine;
	private Map<IEngineAddon, List<FieldChange>> changes;
	private Set<IEngineAddon> registeredAddons;

	private void addFeatureChange(EStructuralFeature feature, EObject eObject, Object value,
			FieldChange.ChangeType changeType) {

		registeredAddons.stream().forEach(
				addon -> changes.get(addon).add(new FieldChange(feature, eObject, value, changeType)));
	}

	public SimpleModelChangeListenerAddon(final ISequentialExecutionEngine engine) {
		this.engine = engine;
		changes = new HashMap<>();
		registeredAddons = new HashSet<>();
		adapter = new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				int eventType = notification.getEventType();
				Object notifier = notification.getNotifier();
				if (eventType < Notification.EVENT_TYPE_COUNT && notifier instanceof EObject && !notification.isTouch()) {
					switch (notification.getEventType()) {
					case Notification.ADD:
					case Notification.ADD_MANY:
						addFeatureChange((EStructuralFeature) notification.getFeature(),
								(EObject) notification.getNotifier(), notification.getNewValue(),
								FieldChange.ChangeType.ADD);
						break;
					case Notification.REMOVE:
					case Notification.REMOVE_MANY:
						addFeatureChange((EStructuralFeature) notification.getFeature(),
								(EObject) notification.getNotifier(), notification.getOldValue(),
								FieldChange.ChangeType.REMOVE);
						break;
					case Notification.MOVE:
					case Notification.SET:
					case Notification.UNSET:
						addFeatureChange((EStructuralFeature) notification.getFeature(),
								(EObject) notification.getNotifier(), notification.getNewValue(),
								FieldChange.ChangeType.MODIFY);
						break;
					}
				}
			}
		};
		Set<Resource> allResources = org.gemoc.commons.eclipse.emf.EMFResource.getRelatedResources(this.engine
				.getExecutionContext().getResourceModel());
		allResources.stream().forEach(r -> {
			r.eAdapters().add(adapter);
		});
	}

	@Override
	public List<FieldChange> getChanges(IEngineAddon addon) {
		List<FieldChange> result = changes.get(addon);
		if (registeredAddons.contains(addon)) {
			changes.put(addon, new ArrayList<FieldChange>());
		}
		return result;
	}

	@Override
	public boolean registerAddon(IEngineAddon addon) {
		boolean res = registeredAddons.add(addon);
		if (res) {
			changes.put(addon, new ArrayList<FieldChange>());
		}
		return res;
	}

	@Override
	public void engineAboutToStop(IBasicExecutionEngine engine) {
		Set<Resource> allResources = org.gemoc.commons.eclipse.emf.EMFResource.getRelatedResources(this.engine
				.getExecutionContext().getResourceModel());
		allResources.stream().forEach(r -> {
			r.eAdapters().remove(adapter);
		});
	}
}
