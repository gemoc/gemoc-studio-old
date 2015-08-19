package org.gemoc.gemoc_modeling_workbench.ui.commands;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.sirius.ui.DebugSiriusIdeUiPlugin;
import fr.obeo.dsl.debug.ide.sirius.ui.SiriusEditorUtils;
import fr.obeo.dsl.debug.ide.ui.EMFEditorUtils;
import fr.obeo.timeline.editpart.PossibleStepEditPart;
import fr.obeo.timeline.model.PossibleStep;

public class ShowCallerHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil
				.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			final Object selected = ((IStructuredSelection) selection)
					.getFirstElement();
			if (selected instanceof PossibleStepEditPart) {
				final PossibleStep step = ((PossibleStepEditPart) selected)
						.getModel();
				Object element = step.getPossibleStep();
				if (element instanceof LogicalStep) {
					final Set<EObject> callers = new LinkedHashSet<EObject>();
					for (MSEOccurrence mseOccurrence : ((LogicalStep) element)
							.getMseOccurrences()) {
						if (mseOccurrence.getMse().getCaller() != null) {
							callers.add(mseOccurrence.getMse().getCaller());
						}
					}
					openEditorsAndShowInstructions(new ArrayList<EObject>(
							callers));
				}
			}
		}

		return null;
	}

	protected Map<IEditorPart, List<EObject>> openEditorsAndShowInstructions(
			List<EObject> instructions) {
		final Map<IEditorPart, List<EObject>> result = new LinkedHashMap<IEditorPart, List<EObject>>();

		for (EObject instruction : instructions) {
			final IEditorPart editor = openEditor(instruction);
			List<EObject> eObjects = result.get(editor);
			if (eObjects == null) {
				eObjects = new ArrayList<EObject>();
				result.put(editor, eObjects);
			}
			eObjects.add(instruction);
		}

		for (Entry<IEditorPart, List<EObject>> entry : result.entrySet()) {
			if (entry.getKey() instanceof DialectEditor) {
				SiriusEditorUtils.showInstructions(
						(DialectEditor) entry.getKey(), instructions);
			} else {
				final List<URI> instructionURIs = new ArrayList<URI>();
				for (EObject instruction : instructions) {
					final URI instructionURI = EcoreUtil.getURI(instruction);
					if (instructionURI != null) {
						instructionURIs.add(instructionURI);
					}
				}
				EMFEditorUtils.selectInstructions(entry.getKey(),
						instructionURIs);
			}
		}

		return result;
	}

	private IEditorPart openEditor(EObject instruction) {
		final IEditorPart res;

		final URI instructionURI = EcoreUtil.getURI(instruction);

		if (instructionURI != null) {

			final Session session;
			final Session inSession = SessionManager.INSTANCE.getSession(instruction);
			if (inSession != null) {
				session = inSession;
			} else {
				List<Session> sessions = SiriusEditorUtils.getSessions(instructionURI);
				if (sessions.size() > 1) {
					session = selectSession(sessions);
				} else if (sessions.size() == 1) {
					session = sessions.get(0);
				} else {
					session = null;
				}
			}

			if (session != null) {
				List<DRepresentation> representations = SiriusEditorUtils.getRepresentations(session,
						instructionURI);

				final DRepresentation representation;
				if (representations.size() > 1) {
					representation = selectRepresentation(representations);
				} else if (representations.size() == 1) {
					representation = representations.get(0);
				} else {
					representation = null;
				}

				if (representation != null) {
					res = DialectUIManager.INSTANCE.openEditor(session, representation,
							new NullProgressMonitor());
				} else {
					res = openEMFEditor(instruction);
				}
			} else {
				res = openEMFEditor(instruction);
			}
		} else {
			return null;
		}

		return res;
	}

	/**
	 * Opens an EMF editor for the given instruction
	 * 
	 * @param instruction
	 *            the instruction {@link EObject}
	 * @returns the opened {@link IEditorPart} if any opened, <code>null</code>
	 *          otherwise
	 */
	private IEditorPart openEMFEditor(EObject instruction) {
		IEditorPart editor = null;

		try {
			final IEditorInput input = EMFEditorUtils
					.getEditorInput(instruction);
			final String editorId = EMFEditorUtils.getEditorID(input,
					instruction);
			if (input != null && editorId != null) {
				editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage().openEditor(input, editorId);
			} else {
				editor = null;
			}
		} catch (PartInitException e) {
			DebugSiriusIdeUiPlugin.getPlugin().log(e);
		}

		return editor;
	}

	/**
	 * Selects a {@link Session} from the given {@link List} of {@link Session}.
	 * 
	 * @param sessions
	 *            the {@link List} of {@link Session}
	 * @return a selected {@link Session} from the given {@link List} of
	 *         {@link Session}
	 */
	protected Session selectSession(List<Session> sessions) {
		return sessions.get(0);
	}

	/**
	 * Selects a {@link DRepresentation} from the given {@link List} of
	 * {@link DRepresentation}.
	 * 
	 * @param representations
	 *            the {@link List} of {@link DRepresentation}
	 * @return a selected {@link DRepresentation} from the given {@link List} of
	 *         {@link DRepresentation}
	 */
	protected DRepresentation selectRepresentation(
			List<DRepresentation> representations) {
		return representations.get(0);
	}

}
