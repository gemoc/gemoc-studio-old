package org.gemoc.gemoc_language_workbench.extensions.sirius.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.gemoc.execution.engine.core.CommandExecution;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public abstract class AbstractGemocAnimatorServices {

	/**
	 * A couple of {@link String}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class StringCouple {

		/**
		 * The first string of the couple.
		 */
		private final String first;

		/**
		 * The second string of the couple.
		 */
		private final String second;

		/**
		 * Constructor.
		 * 
		 * @param first
		 *            the first string of the couple
		 * @param second
		 *            the second string of the couple
		 */
		public StringCouple(String first, String second) {
			this.first = first;
			this.second = second;
		}

		/**
		 * Gets the first string of the couple.
		 * 
		 * @return the first string of the couple
		 */
		public String getFirst() {
			return first;
		}

		/**
		 * Gets the second string of the couple.
		 * 
		 * @return the second string of the couple
		 */
		public String getSecond() {
			return second;
		}
	}

	public final static class GemocModelAnimator implements IModelAnimator {

		/**
		 * Any layer {@link Set}, means always refresh the given
		 * {@link DRepresentation} no matter what its layer are. It should be
		 * used for trees and tables since they don't have layers.
		 */
		private static final Set<String> ANY_LAYER = new HashSet<String>();

		/**
		 * Mapping of the {@link RepresentationDescription#getName()
		 * representation identifier} to a {@link Layer#getName() layer
		 * identifier} or {@link BreakpointListener#ANY_LAYER any layer}.
		 */
		private final Map<String, Set<String>> representationToRefresh = new HashMap<String, Set<String>>();

		/**
		 * {@link IModelAnimator#activate(LogicalStep) Activated} instructions.
		 */
		private final Map<Object, Set<URI>> activatedInstructions = new HashMap<Object, Set<URI>>();

		/**
		 * Notifies Sirius about a change in the given {@link DSLBreakpoint}.
		 * 
		 * @param instructionUri
		 *            the {@link URI} of the instruction to refresh.
		 */
		public void notifySirius(Set<URI> instructionUris) {
			final Map<String, Set<String>> toRefresh = representationToRefresh;
			for (IEditingSession session : SessionUIManager.INSTANCE
					.getUISessions()) {
				final TransactionalEditingDomain transactionalEditingDomain = session
						.getSession().getTransactionalEditingDomain();
				final ResourceSet resourceSet = transactionalEditingDomain
						.getResourceSet();
				final boolean instructionPresent = isOneInstructionPresent(
						instructionUris, resourceSet);
				if (instructionPresent) {
					final List<DRepresentation> representations = getRepresentationsToRefresh(
							toRefresh, session);
					refreshRepresentations(transactionalEditingDomain,
							representations);
				}
			}
		}

		/**Refreshes given {@link DRepresentation} in the given {@link TransactionalEditingDomain}.
		 * @param transactionalEditingDomain the {@link TransactionalEditingDomain}
		 * @param representations the {@link List} of {@link DRepresentation} to refresh
		 */
		public void refreshRepresentations(
				final TransactionalEditingDomain transactionalEditingDomain,
				final List<DRepresentation> representations) {
			// TODO prevent the editors from getting dirty
			if (representations.size() != 0) {
				final RefreshRepresentationsCommand refresh = new RefreshRepresentationsCommand(
						transactionalEditingDomain,
						new NullProgressMonitor(),
						representations);
				CommandExecution.execute(transactionalEditingDomain, refresh);
			}
		}

		/**Gets the {@link List} of {@link DRepresentation} to refresh in the given {@link IEditingSession}.
		 * @param toRefresh the representation names and layers to refresh
		 * @param session the {@link IEditingSession}
		 * @return the {@link List} of {@link DRepresentation} to refresh in the given {@link IEditingSession}
		 */
		private List<DRepresentation> getRepresentationsToRefresh(
				final Map<String, Set<String>> toRefresh,
				IEditingSession session) {
			final List<DRepresentation> representations = new ArrayList<DRepresentation>();
			for (DialectEditor editor : session.getEditors()) {
				final DRepresentation representation = editor
						.getRepresentation();
				final RepresentationDescription description = DialectManager.INSTANCE
						.getDescription(representation);
				final String representationId = description.getName();
				final Set<String> layerIDs = toRefresh
						.get(representationId);
				if (layerIDs == ANY_LAYER) {
					representations.add(representation);
				} else if (layerIDs != null
						&& representation instanceof DDiagram
						&& isActiveLayer((DDiagram) representation,
								layerIDs)) {
					representations.add(representation);
				}
			}
			return representations;
		}

		/**Tells if at least one of the given instruction {@link URI} is present in the given {@link ResourceSet}.
		 * @param instructionUris the {@link Set} of instructions {@link URI}
		 * @param resourceSet the {@link ResourceSet}
		 * @return <code>true</code> if at least one of the given instruction {@link URI} is present in the given {@link ResourceSet}, <code>false</code> otherwise
		 */
		private boolean isOneInstructionPresent(Set<URI> instructionUris,
				final ResourceSet resourceSet) {
			boolean instructionPresent = false;
			for (URI instructionUri : instructionUris) {
				if (resourceSet.getEObject(instructionUri, false) != null) {
					instructionPresent = true;
					break;
				}
			}
			return instructionPresent;
		}

		/**
		 * Tells if any of the given {@link Layer#getName() layer identifier} is
		 * active for the given {@link DDiagram}.
		 * 
		 * @param diagram
		 *            the {@link DDiagram}
		 * @param layerIDs
		 *            the {@link Set} of {@link Layer#getName() layer
		 *            identifiers}
		 * @return <code>true</code> if any of the given {@link Layer#getName()
		 *         layer identifier} is active for the given {@link DDiagram},
		 *         <code>false</code> otherwise
		 */
		private boolean isActiveLayer(DDiagram diagram, Set<String> layerIDs) {
			boolean res = false;

			for (Layer layer : diagram.getActivatedLayers()) {
				if (layerIDs.contains(layer.getName())) {
					res = true;
					break;
				}
			}

			return res;
		}

		/**
		 * Add the given {@link RepresentationDescription#getName()
		 * representation identifier} for {@link DRepresentation} refresh.
		 * 
		 * @param representationID
		 *            the {@link RepresentationDescription#getName()
		 *            representation identifier}
		 */
		public void addRepresentationToRefresh(String representationID) {
			representationToRefresh.put(representationID, ANY_LAYER);
		}

		/**
		 * Add the given {@link RepresentationDescription#getName()
		 * representation identifier} and {@link Layer#getName() layer
		 * identifier} for {@link DRepresentation} refresh.
		 * 
		 * @param representationID
		 *            the {@link RepresentationDescription#getName()
		 *            representation identifier}
		 * @param layerID
		 *            the {@link Layer#getName() layer identifier}
		 */
		public void addRepresentationToRefresh(String representationID,
				String layerID) {
			Set<String> layerIDs = representationToRefresh
					.get(representationID);
			if (layerIDs != ANY_LAYER) {
				if (layerIDs == null) {
					layerIDs = new HashSet<String>();
					representationToRefresh.put(representationID, layerIDs);
				}
				layerIDs.add(layerID);
			}
		}

		@Override
		public void activate(Object context, LogicalStep step) {
			final Set<URI> instructionURIs = new HashSet<URI>();
			for (MSEOccurrence mseOccurrence : step.getMseOccurrences())
			{
				instructionURIs.add(EcoreUtil.getURI(mseOccurrence.getMse().getSolverEvent()));
				if (mseOccurrence.getMse().getCaller() != null)
				{
					instructionURIs.add(EcoreUtil.getURI(mseOccurrence.getMse().getCaller()));
				}
			}
			clear(context);
			Set<URI> oldInstructions = activatedInstructions.get(context);
			if (oldInstructions == null) {
				oldInstructions = new HashSet<URI>();
				activatedInstructions.put(context, oldInstructions);
			}
			oldInstructions.addAll(instructionURIs);
			notifySirius(instructionURIs);
		}

		@Override
		public void clear(Object context) {
			final Set<URI> oldInstructions = activatedInstructions
					.remove(context);
			if (oldInstructions != null && oldInstructions.size() != 0) {
				final Set<URI> tmpInstructions = new HashSet<URI>(
						oldInstructions);
				notifySirius(tmpInstructions);
			}
		}

		@Override
		public void engineAboutToStart(IExecutionEngine engine) {
			// TODO Auto-generated method stub

		}

		@Override
		public void engineStarted(IExecutionEngine executionEngine) {
			// TODO Auto-generated method stub

		}

		@Override
		public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine,
				LogicalStep logicalStepToApply) {
			activate(executionEngine, logicalStepToApply);
		}

		@Override
		public void aboutToExecuteMSEOccurrence(IExecutionEngine executionEngine,
				MSEOccurrence mseOccurrence) {
			// TODO Auto-generated method stub

		}

		@Override
		public void engineAboutToStop(IExecutionEngine engine) {
			// TODO Auto-generated method stub

		}

		@Override
		public void engineStopped(IExecutionEngine engine) {
			clear(engine);
			if (engine.getExecutionContext().getRunConfiguration()
					.getAnimatorURI() != null) {
				Session session = SessionManager.INSTANCE.getSession(engine
						.getExecutionContext().getRunConfiguration()
						.getAnimatorURI(), new NullProgressMonitor());
				session.close(new NullProgressMonitor());
				SessionManager.INSTANCE.remove(session);
			}
		}

		@Override
		public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) 
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void logicalStepSelected(IExecutionEngine engine,
				LogicalStep selectedLogicalStep) {
			// TODO Auto-generated method stub

		}

		@Override
		public void logicalStepExecuted(IExecutionEngine engine,
				LogicalStep logicalStepExecuted) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) {
			// TODO Auto-generated method stub

		}

		@Override
		public void engineStatusChanged(IExecutionEngine engine,
				RunStatus newStatus) {
			// TODO Auto-generated method stub

		}

		/**
		 * Tells if the given layer id and representation id should be
		 * refreshed.
		 * 
		 * @param representationId
		 *            the representation id
		 * @param layerID
		 *            the layer id, it can be <code>null</code>
		 * @return <code>true</code> if the given layer id and representation id
		 *         should be refreshed while debugging the given debug model id,
		 *         <code>false</code> otherwise
		 */
		public boolean isRepresentationToRefresh(String representationId,
				String layerID) {
			final boolean res;

			final Set<String> layerIDs = representationToRefresh
					.get(representationId);
			res = layerIDs == ANY_LAYER
					|| (layerIDs != null && layerIDs.contains(layerID));

			return res;
		}

		@Override
		public void proposedLogicalStepsChanged(IExecutionEngine engine,
				Collection<LogicalStep> logicalSteps) {
			// TODO Auto-generated method stub
			
		}

	}

	/**
	 * The {@link GemocModelAnimator} instance.
	 */
	public final static GemocModelAnimator ANIMATOR = new GemocModelAnimator();

	/**
	 * Constructor.
	 */
	public AbstractGemocAnimatorServices() {
		for (StringCouple couple : getRepresentationRefreshList()) {
			if (couple.getSecond() != null) {
				ANIMATOR.addRepresentationToRefresh(couple.getFirst(),
						couple.getSecond());
			} else {
				ANIMATOR.addRepresentationToRefresh(couple.getFirst());
			}
		}
	}

	/**
	 * Gets the {@link IModelAnimator}.
	 * 
	 * @return the {@link IModelAnimator}
	 */
	public static IModelAnimator getAnimator() {
		return ANIMATOR;
	}

	/**
	 * Gets the {@link List} of {@link StringCouple} representing the
	 * {@link RepresentationDescription#getName() representation identifier} and
	 * the {@link Layer#getName() layer identifier} or <code>null</code> where
	 * services from this class are used.
	 * 
	 * @return the {@link List} of {@link StringCouple} representing the
	 *         {@link RepresentationDescription#getName() representation
	 *         identifier} and the {@link Layer#getName() layer identifier} or
	 *         <code>null</code> where services from this class are used
	 */
	protected abstract List<StringCouple> getRepresentationRefreshList();

	/**
	 * Tells if the given {@link EObject instruction} is a currently
	 * {@link IModelAnimator#activate(LogicalStep) activated}.
	 * 
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @return <code>true</code> if the given {@link EObject instruction} is a
	 *         currently {@link IModelAnimator#activate(LogicalStep) activated},
	 *         <code>false</code> otherwise
	 */
	public boolean hasBeenActivated(EObject instruction) {
		boolean res = false;

		final URI uri = EcoreUtil.getURI(instruction);
		for (Set<URI> instructions : ANIMATOR.activatedInstructions.values()) {
			if (instructions.contains(uri)) {
				res = true;
				break;
			}
		}

		return res;
	}

}
