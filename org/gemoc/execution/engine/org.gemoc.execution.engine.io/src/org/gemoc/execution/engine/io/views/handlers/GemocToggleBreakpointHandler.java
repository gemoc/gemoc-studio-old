package org.gemoc.execution.engine.io.views.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.execution.engine.io.views.event.ModelSpecificEventWrapper;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;

import fr.obeo.dsl.debug.ide.ui.DSLToggleBreakpointsUtils;

public class GemocToggleBreakpointHandler extends AbstractHandler {

	/**
	 * The {@link DSLToggleBreakpointsUtils}.
	 */
	protected final DSLToggleBreakpointsUtils breakpointUtils;

	/**
	 * Constructor.
	 */
	public GemocToggleBreakpointHandler() {
		breakpointUtils = new DSLToggleBreakpointsUtils(LogicalStepsView.MODEL_ID) {
			
			@Override
			protected EObject getInstruction(Object selected) {
				final EObject res;
				
				if (selected instanceof ModelSpecificEventWrapper) {
					res = ((ModelSpecificEventWrapper) selected).getMSE();
				} else {
					res = super.getInstruction(selected);
				}

				return res;
			}
			
		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil
				.getCurrentSelectionChecked(event);
		try {
			breakpointUtils.toggleBreakpoints(selection);
		} catch (CoreException e) {
			throw new ExecutionException("Error while toggling breakpoint.", e);
		}

		return null;
	}

}
