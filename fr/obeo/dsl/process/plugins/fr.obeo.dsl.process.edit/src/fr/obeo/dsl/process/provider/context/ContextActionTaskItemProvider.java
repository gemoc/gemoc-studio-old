/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.process.provider.context;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IProcessContextProvider;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.provider.ActionTaskItemProvider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * {@link fr.obeo.dsl.process.ProcessContext ProcessContext} aware {@link ActionTaskItemProvider}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ContextActionTaskItemProvider extends ActionTaskItemProvider {

	/**
	 * The {@link IProcessContextProvider} providing the {@link ProcessContent}.
	 */
	private final IProcessContextProvider provider;

	/**
	 * Contstructor.
	 * 
	 * @param adapterFactory
	 *            the {@link AdapterFactory}
	 * @param provider
	 *            the {@link IProcessContextProvider}
	 */
	public ContextActionTaskItemProvider(AdapterFactory adapterFactory, IProcessContextProvider provider) {
		super(adapterFactory);
		this.provider = provider;
	}

	@Override
	public Object getImage(Object object) {
		final Task task = (Task)object;
		final List<Object> images = new ArrayList<Object>(2);
		images.add(super.getImage(object));
		if (ProcessUtils.evaluatePrecondition(provider.getProcessContext(), task)) {
			if (ProcessUtils.isDone(provider.getProcessContext(), task)) {
				images.add(getResourceLocator().getImage("full/deco16/greenTaskMarker"));
			} else {
				images.add(getResourceLocator().getImage("full/deco16/yellowTaskMarker"));
			}
		} else {
			images.add(getResourceLocator().getImage("full/deco16/greyTaskMarker"));
		}
		return new ComposedImage(images);
	}

	@Override
	public String getText(Object object) {
		return super.getText(object);
	}

	@Override
	public void notifyChanged(Notification notification) {
		if (notification.getFeatureID(ActionTask.class) == -ProcessPackage.PROCESS_FEATURE_COUNT) {
			provider.refresh(notification.getNotifier()); // workaround
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
		} else {
			super.notifyChanged(notification);
		}
	}

}
