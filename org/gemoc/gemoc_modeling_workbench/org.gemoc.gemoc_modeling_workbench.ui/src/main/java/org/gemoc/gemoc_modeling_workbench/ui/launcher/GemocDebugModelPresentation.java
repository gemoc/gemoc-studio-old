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
import org.gemoc.execution.engine.io.IEvenPresenter;
import org.gemoc.execution.engine.trace.LogicalStepHelper;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.sirius.ui.DSLDebugModelPresentation;
import fr.obeo.dsl.debug.ide.sirius.ui.SiriusEditorUtils;

public class GemocDebugModelPresentation extends DSLDebugModelPresentation {

	@Override
	public IEditorInput getEditorInput(Object element) {
		final IEditorInput res;

		if (element instanceof ModelSpecificEvent
				&& ((ModelSpecificEvent) element).getCaller() != null) {
			res = super.getEditorInput(((ModelSpecificEvent) element).getCaller());
		} else {
			res = super.getEditorInput(element);
		}

		return res;
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		final String res;

		if (element instanceof ModelSpecificEvent
				&& ((ModelSpecificEvent) element).getCaller() != null) {
			res = super.getEditorId(input, ((ModelSpecificEvent) element).getCaller());
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
					final List<ModelSpecificEvent> tickedEvents = LogicalStepHelper.getMSEs((LogicalStep) instruction);
					showEvents(tickedEvents);
					for (ModelSpecificEvent event : tickedEvents) {
						if (event.getCaller() != null) {
							SiriusEditorUtils.showInstruction(editorPart, event.getCaller());
						}
					}
				} else {
					SiriusEditorUtils.showInstruction(editorPart, instruction);
				}
			} else {
				super.addAnnotations(editorPart, frame);
			}
		}

		return true;
	}

	private void showEvents(List<ModelSpecificEvent> events) {
		final List<URI> uris = new ArrayList<URI>();
		for (ModelSpecificEvent event : events) {
			uris.add(EcoreUtil.getURI(event));
		}
		for (IEvenPresenter presenter : org.gemoc.execution.engine.io.Activator
				.getDefault().getEventPresenters()) {
			presenter.present(uris);
		}
	}

}
