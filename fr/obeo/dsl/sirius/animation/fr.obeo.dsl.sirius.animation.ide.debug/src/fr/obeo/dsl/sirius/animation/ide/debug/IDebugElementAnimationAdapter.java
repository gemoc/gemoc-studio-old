/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.ide.debug;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.StackFrameState;
import fr.obeo.dsl.sirius.animation.TargetState;

public class IDebugElementAnimationAdapter extends AdapterImpl implements
		IDebugElement {
	protected ILaunch launch;

	protected DebugModelToEclipseDebugAdapterFactory factory;

	public IDebugElementAnimationAdapter(ILaunch launch,
			DebugModelToEclipseDebugAdapterFactory factory) {
		super();
		this.launch = launch;
		this.factory = factory;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == factory || type == IDebugElement.class;
	}

	public String getModelIdentifier() {
		return "fr.obeo.dsl.sirius.modelAnimation";
	}

	public IDebugTarget getDebugTarget() {
		return (IDebugTarget) factory.adapt(findParentTarget(),
				IDebugTarget.class);
	}

	protected AnimationTarget findParentTarget() {
		AnimationTarget parentTarget = null;
		EObject start = null;
		if (getTarget() instanceof EObject) {
			start = (EObject) getTarget();
		} else if (getTarget() instanceof SettingWrapper) {
			start = ((SettingWrapper) getTarget()).getWrapped().getEObject();
		}
		if (start != null) {
			EObject cur = start;
			while (cur != null) {
				if (cur instanceof AnimationTarget) {
					parentTarget = (AnimationTarget) cur;
				}
				cur = cur.eContainer();
			}
		}
		return parentTarget;
	}

	public ILaunch getLaunch() {
		return this.launch;
	}

	/**
	 * Fires a debug event
	 * 
	 * @param event
	 *            the event to be fired
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { event });
	}

	@Override
	public void notifyChanged(Notification msg) {
		super.notifyChanged(msg);
		if (!msg.isTouch()) {

			int debugEventKind = DebugEvent.CHANGE;
			switch (msg.getEventType()) {
			case Notification.SET:
				debugEventKind = DebugEvent.CHANGE;
				if (msg.getNewValue() == TargetState.TERMINATED) {
					debugEventKind = DebugEvent.TERMINATE;
				}
				if (msg.getNewValue() == TargetState.RUNNING) {
					debugEventKind = DebugEvent.RESUME;
				}
				if (msg.getNewValue() == TargetState.SUSPENDED) {
					debugEventKind = DebugEvent.SUSPEND;
				}
				if (msg.getNewValue() == StackFrameState.STEPING_INTO) {
					debugEventKind = DebugEvent.STEP_INTO;
				}
				if (msg.getNewValue() == StackFrameState.STEPING_OVER) {
					debugEventKind = DebugEvent.STEP_OVER;
				}
				if (msg.getNewValue() == StackFrameState.STEPING_RETURN) {
					debugEventKind = DebugEvent.STEP_RETURN;
				}
				if (msg.getNewValue() == StackFrameState.DONE) {
					debugEventKind = DebugEvent.STEP_END;
				}

				break;
			case Notification.ADD:
			case Notification.ADD_MANY:
				if (msg.getFeature() instanceof EReference
						&& ((EReference) msg.getFeature()).isContainment()) {
					debugEventKind = DebugEvent.CREATE;
				} else {
					debugEventKind = DebugEvent.CHANGE;
				}
				break;
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
				if (msg.getFeature() instanceof EReference
						&& ((EReference) msg.getFeature()).isContainment()) {
					/*
					 * no remove event ?
					 */
				} else {
					debugEventKind = DebugEvent.CHANGE;
				}
				break;
			}
			if (msg.getNotifier() instanceof Notifier)
				for (Adapter adapter : ((Notifier) msg.getNotifier())
						.eAdapters()) {
					if (adapter instanceof IDebugElement) {
						fireEvent(new DebugEvent(adapter, debugEventKind));
					}
				}
		}
	}

}
