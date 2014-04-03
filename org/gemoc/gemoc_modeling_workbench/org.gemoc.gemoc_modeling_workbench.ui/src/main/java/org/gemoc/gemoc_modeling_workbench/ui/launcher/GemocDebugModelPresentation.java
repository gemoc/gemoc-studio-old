package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.marker.TraceabilityMarkerNavigationProvider;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.core.LogicalStepHelper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.sirius.ui.DSLDebugModelPresentation;
import fr.obeo.dsl.debug.ide.sirius.ui.DebugSiriusIdeUiPlugin;

public class GemocDebugModelPresentation extends DSLDebugModelPresentation {

	@Override
	public boolean addAnnotations(IEditorPart editorPart, IStackFrame frame) {
		if (frame instanceof DSLStackFrameAdapter) {
			if (editorPart instanceof DialectEditor) {
				final TraceabilityMarkerNavigationProvider navigationProvider = new TraceabilityMarkerNavigationProvider(
						(DialectEditor) editorPart);
				EObject instruction = ((DSLStackFrameAdapter) frame)
						.getCurrentInstruction();
				if (instruction instanceof LogicalStep) {
					instruction = getFirstTarget((LogicalStep) instruction);
				}
				final URI resourceURI = instruction.eResource().getURI();
				if (resourceURI.isPlatformResource()) {
					changeCurrentStackFrame(frame);
					final String resourcePath = resourceURI
							.toPlatformString(true);
					final IResource resource = ResourcesPlugin.getWorkspace()
							.getRoot().getFile(new Path(resourcePath));
					try {
						final IMarker marker = resource
								.createMarker(EValidator.MARKER);
						navigationProvider.gotoMarker(marker);
						marker.delete();
					} catch (CoreException e) {
						DebugSiriusIdeUiPlugin.INSTANCE.log(e);
					}
				}
			} else {
				super.addAnnotations(editorPart, frame);
			}
		}

		return true;
	}

	private EObject getFirstTarget(LogicalStep step) {
		EObject res = null;

		for (Event event : LogicalStepHelper
				.getTickedEvents((LogicalStep) step)) {
			if (event.getReferencedObjectRefs().size() != 0) {
				res = event.getReferencedObjectRefs().get(0);
				break;
			}
		}

		return res;
	}

}
