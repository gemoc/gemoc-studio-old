package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.sirius.ui.DSLDebugModelPresentation;

public class GemocDebugModelPresentation extends DSLDebugModelPresentation {

	@Override
	public IEditorInput getEditorInput(Object element) {
		final IEditorInput res;

		if (element instanceof Event
				&& ((Event) element).getReferencedObjectRefs().size() > 0) {
			res = super.getEditorInput(((Event) element)
					.getReferencedObjectRefs().get(0));
		} else {
			res = super.getEditorInput(element);
		}

		return res;
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		final String res;

		if (element instanceof Event
				&& ((Event) element).getReferencedObjectRefs().size() > 0) {
			res = super.getEditorId(input, ((Event) element)
					.getReferencedObjectRefs().get(0));
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
				EObject instruction = ((DSLStackFrameAdapter) frame)
						.getCurrentInstruction();
				if (instruction instanceof LogicalStep) {
					final List<Event> tickedEvents = LogicalStepHelper
							.getTickedEvents((LogicalStep) instruction);
					showEvents(tickedEvents);
					for (Event event : tickedEvents) {
						if (event.getReferencedObjectRefs().size() != 0) {
							showInstruction(editorPart, event
									.getReferencedObjectRefs().get(0));
						}
					}
				} else {
					showInstruction(editorPart, instruction);
				}
			} else {
				super.addAnnotations(editorPart, frame);
			}
		}

		return true;
	}

	private void showEvents(List<Event> events) {
		// TODO
	}

}
