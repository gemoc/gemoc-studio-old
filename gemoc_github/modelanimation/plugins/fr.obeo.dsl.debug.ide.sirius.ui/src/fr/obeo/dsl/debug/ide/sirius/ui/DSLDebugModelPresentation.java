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
package fr.obeo.dsl.debug.ide.sirius.ui;

import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.adapter.DSLDebugTargetAdapter;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

/**
 * The {@link org.eclipse.debug.ui.IDebugModelPresentation IDebugModelPresentation} for the DSL debug model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLDebugModelPresentation extends fr.obeo.dsl.debug.ide.ui.DSLDebugModelPresentation {

	// FIXME this code is ugly but should work... the right way to do this is to add
	// DialectUIManager.getEditorInput(...) and DialectUIManager.getEditorID(...)
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=426431

	/**
	 * The opened {@link IEditorPart}.
	 */
	IEditorPart editor;

	@Override
	public IEditorInput getEditorInput(Object element) {
		final IEditorInput res;

		final URI instructionURI;
		if (element instanceof EObject) {
			instructionURI = EcoreUtil.getURI((EObject)element);
		} else if (element instanceof DSLBreakpoint) {
			instructionURI = ((DSLBreakpoint)element).getURI();
		} else {
			instructionURI = null;
		}

		editor = null;
		if (instructionURI != null) {

			final Session session;
			final Session inSession;
			if (element instanceof EObject) {
				inSession = SessionManager.INSTANCE.getSession((EObject)element);
			} else {
				inSession = null;
			}
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
					editor = DialectUIManager.INSTANCE.openEditor(session, representation,
							new NullProgressMonitor());
					res = editor.getEditorInput();
				} else {
					res = super.getEditorInput(instructionURI);
				}
			} else {
				res = super.getEditorInput(instructionURI);
			}
		} else {
			return null;
		}

		return res;
	}

	/**
	 * Selects a {@link Session} from the given {@link List} of {@link Session}.
	 * 
	 * @param sessions
	 *            the {@link List} of {@link Session}
	 * @return a selected {@link Session} from the given {@link List} of {@link Session}
	 */
	protected Session selectSession(List<Session> sessions) {
		return sessions.get(0);
	}

	/**
	 * Selects a {@link DRepresentation} from the given {@link List} of {@link DRepresentation}.
	 * 
	 * @param representations
	 *            the {@link List} of {@link DRepresentation}
	 * @return a selected {@link DRepresentation} from the given {@link List} of {@link DRepresentation}
	 */
	protected DRepresentation selectRepresentation(List<DRepresentation> representations) {
		return representations.get(0);
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		final String res;

		if (editor != null) {
			res = editor.getEditorSite().getId();
		} else {
			res = super.getEditorId(input, element);
		}

		return res;
	}

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame instanceof DSLStackFrameAdapter) {
			changeCurrentStackFrame(frame);
			if (editorPart instanceof DialectEditor) {
				final EObject instruction = ((DSLStackFrameAdapter)frame).getCurrentInstruction();
				SiriusEditorUtils.showInstruction((DialectEditor)editorPart, instruction);
			} else {
				super.addAnnotations(editorPart, frame);
			}
		}

		return true;
	}

	/**
	 * Changes the current {@link IStackFrame}.
	 * 
	 * @param frame
	 *            the selected {@link IStackFrame}
	 */
	protected void changeCurrentStackFrame(IStackFrame frame) {
		final IDebugTarget debugTarget = frame.getDebugTarget();
		for (IDSLCurrentInstructionListener listener : ((DSLDebugTargetAdapter)debugTarget)
				.getCurrentInstructionListeners()) {
			listener.setCurrentFrame(frame.getModelIdentifier(), ((DSLStackFrameAdapter)frame).getHost());
		}
	}

	@Override
	public void removeAnnotations(IEditorPart editorPart, IThread thread) {
		// nothing to do here
	}

}
