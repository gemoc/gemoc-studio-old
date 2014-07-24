package fr.obeo.dsl.workspace.listener;

import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.internal.ListenerFactory;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;

/**
 * Utility class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public final class WorkspaceUtils {

	/**
	 * Mapping from {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...) to {@link IListener}.
	 */
	private static final Map<Object, IListener> LISTENERS = new HashMap<Object, IListener>();

	/**
	 * The {@link IListenerFactory} to use if {@link IListener} creation is needed.
	 */
	private static final IListenerFactory<Object> LISTENER_FACTORY = new ListenerFactory();

	/**
	 * Constructor.
	 */
	private WorkspaceUtils() {
		// nothing to do here
	}

	/**
	 * Gets the {@link IListenerFactory} to use if {@link IListener} creation is needed.
	 * 
	 * @return the {@link IListenerFactory} to use if {@link IListener} creation is needed
	 */
	private static IListenerFactory<Object> getListenerFactory() {
		return LISTENER_FACTORY;
	}

	/**
	 * Gets a {@link IListener} for the given {@link Object} from Eclipse (
	 * {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...).
	 * 
	 * @param object
	 *            the {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *            {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *            {@link org.eclipse.ui.IWorkbench IWorkbench}, ...)
	 * @return a {@link IListener} for the given {@link Object} from Eclipse (
	 *         {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *         {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *         {@link org.eclipse.ui.IWorkbench IWorkbench}, ...) if any exists, <code>null</code> otherwise
	 */
	public static IListener getListener(Object object) {
		IListener res = LISTENERS.get(object);

		if (res == IListener.NO_LISTENER) {
			res = null;
		}

		return res;
	}

	/**
	 * Creates a {@link IListener} for the given {@link Object} from Eclipse (
	 * {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...).
	 * 
	 * @param object
	 *            the {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *            {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *            {@link org.eclipse.ui.IWorkbench IWorkbench}, ...)
	 * @return a new {@link IListener} for the given {@link Object} from Eclipse (
	 *         {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *         {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *         {@link org.eclipse.ui.IWorkbench IWorkbench}, ...) if any can be created, <code>null</code>
	 *         otherwise
	 */
	public static IListener createListener(Object object) {
		final IListener res = getListenerFactory().createListener(object);
		if (res == null) {
			LISTENERS.put(object, IListener.NO_LISTENER);
		} else {
			LISTENERS.put(object, res);
		}

		return res;
	}

	/**
	 * Deletes a {@link IListener} for the given {@link Object} from Eclipse (
	 * {@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 * {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot}, {@link org.eclipse.ui.IWorkbench
	 * IWorkbench}, ...).
	 * 
	 * @param object
	 *            the {@link Object} from Eclipse ({@link org.eclipse.core.resources.IWorkspace IWorkspace},
	 *            {@link org.eclipse.core.resources.IWorkspaceRoot IWorkspaceRoot},
	 *            {@link org.eclipse.ui.IWorkbench IWorkbench}, ...)
	 */
	public static void deleteListener(Object object) {
		final IListener listener = LISTENERS.remove(object);
		if (listener != null) {
			listener.dispose();
		}
	}

	/**
	 * Removes the given {@link IChangeProcessor} from all {@link IListener}.
	 * 
	 * @param processor
	 *            the {@link IChangeProcessor} to remove
	 */
	public static void removeProcessor(IChangeProcessor processor) {
		for (IListener listener : LISTENERS.values()) {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Gets the {@link AbstractResourceChange#getObject() resource object} or the
	 * {@link ResourceMoved#getDestination() destination}.
	 * 
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @return the {@link AbstractResourceChange#getObject() resource object} or the
	 *         {@link ResourceMoved#getDestination() destination}
	 */
	public static IResource getResource(AbstractResourceChange change) {
		final IResource res;

		if (change instanceof ResourceMoved) {
			res = ((ResourceMoved)change).getDestination();
		} else {
			res = change.getObject();
		}

		return res;
	}

}
