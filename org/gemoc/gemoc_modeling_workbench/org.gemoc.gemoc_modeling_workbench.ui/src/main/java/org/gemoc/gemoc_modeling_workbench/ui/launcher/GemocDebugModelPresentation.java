package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.core.LogicalStepHelper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.sirius.ui.DSLDebugModelPresentation;

public class GemocDebugModelPresentation extends DSLDebugModelPresentation {

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame instanceof DSLStackFrameAdapter) {
			changeCurrentStackFrame(frame);
			if (editorPart instanceof DialectEditor) {
				EObject instruction = ((DSLStackFrameAdapter) frame)
						.getCurrentInstruction();
				if (instruction instanceof LogicalStep) {
					for (Event event : LogicalStepHelper
							.getTickedEvents((LogicalStep) instruction)) {
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

}
