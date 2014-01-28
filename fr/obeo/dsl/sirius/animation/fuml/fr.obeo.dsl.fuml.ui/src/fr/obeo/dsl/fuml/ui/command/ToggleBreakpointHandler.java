package fr.obeo.dsl.fuml.ui.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.obeo.dsl.debug.ide.ui.DSLToggleBreakpointsUtils;
import fr.obeo.dsl.fuml.ui.launch.FUMLDelegate;

public class ToggleBreakpointHandler extends AbstractHandler {

	private final DSLToggleBreakpointsUtils tobbleBreakpoint = new DSLToggleBreakpointsUtils(
			FUMLDelegate.MODEL_ID);

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IEditorPart part = HandlerUtil.getActiveEditorChecked(event);
		final ISelection selection = HandlerUtil
				.getCurrentSelectionChecked(event);
		if (tobbleBreakpoint.canToggleBreakpoints(part, selection)) {
			try {
				tobbleBreakpoint.toggleBreakpoints(part, selection);
			} catch (CoreException e) {
				// TODO
				e.printStackTrace();
			}
		}

		return null;
	}

}
