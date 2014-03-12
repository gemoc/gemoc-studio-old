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
package fr.obeo.dsl.workspace.listener.internal;

import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.IListenerFactory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchWindow;

/**
 * Factory creating {@link IListener}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ListenerFactory implements IListenerFactory<Object> {

	/**
	 * Mapping from {@link Class} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...) to {@link IListenerFactory}.
	 */
	protected final Map<Class<?>, IListenerFactory<?>> map = new HashMap<Class<?>, IListenerFactory<?>>();

	// TODO support inheritance... ?

	/**
	 * Constructor.
	 */
	public ListenerFactory() {
		map.put(Workspace.class, new IListenerFactory<IWorkspace>() {
			public IListener createListener(IWorkspace workspace) {
				return new WorkspaceListener(workspace);
			}
		});
		map.put(Workbench.class, new IListenerFactory<IWorkbench>() {
			public IListener createListener(IWorkbench workbench) {
				return new WorkbenchWindowListener(workbench);
			}
		});
		map.put(WorkbenchWindow.class, new IListenerFactory<IWorkbenchWindow>() {
			public IListener createListener(IWorkbenchWindow workbenchWindow) {
				return new WorkbenchPageListener(workbenchWindow);
			}
		});
		map.put(WorkbenchPage.class, new IListenerFactory<IWorkbenchPage>() {
			public IListener createListener(IWorkbenchPage workbenchPage) {
				return new WorkbenchPartListener(workbenchPage);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListenerFactory#createListener(java.lang.Object)
	 */
	public IListener createListener(Object object) {
		final IListener res;

		@SuppressWarnings("unchecked")
		IListenerFactory<Object> factory = (IListenerFactory<Object>)map.get(object.getClass());
		if (factory != null) {
			res = factory.createListener(object);
		} else {
			res = null;
		}

		return res;
	}

}
