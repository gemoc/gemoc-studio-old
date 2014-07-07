package org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services;

import java.util.ArrayList;
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
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.gemoc.execution.engine.core.IGemocModelAnimator;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices.BreakpointListener;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.DSLBreakpoint;

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

	private final static class GemocModelAnimator implements
			IGemocModelAnimator {

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
		 * {@link IGemocModelAnimator#activate(LogicalStep) Activated}
		 * instructions.
		 */
		private final Map<Object, Set<URI>> activatedInstructions = new HashMap<Object, Set<URI>>();

		/**
		 * Notifies Sirius about a change in the given {@link DSLBreakpoint}.
		 * 
		 * @param instructionUri
		 *            the {@link URI} of the instruction to refresh.
		 */
		public void notifySirius(Set<URI> instructionUris) {
			for (IEditingSession session : SessionUIManager.INSTANCE
					.getUISessions()) {
				final TransactionalEditingDomain transactionalEditingDomain = session
						.getSession().getTransactionalEditingDomain();
				final ResourceSet resourceSet = transactionalEditingDomain
						.getResourceSet();
				for (DialectEditor editor : session.getEditors()) {
					boolean instructionPresent = false;
					for (URI instructionUri : instructionUris) {
						if (resourceSet.getEObject(instructionUri, false) != null) {
							instructionPresent = true;
							break;
						}
					}
					if (instructionPresent) {
						final DRepresentation representation = editor
								.getRepresentation();
						final List<DRepresentation> representations = new ArrayList<DRepresentation>();
						final RepresentationDescription description = DialectManager.INSTANCE
								.getDescription(representation);
						final String representationId = description.getName();
						final Set<String> layerIDs = representationToRefresh
								.get(representationId);
						if (layerIDs == ANY_LAYER) {
							representations.add(representation);
						} else if (layerIDs != null
								&& representation instanceof DDiagram
								&& isActiveLayer((DDiagram) representation,
										layerIDs)) {
							representations.add(representation);
						}
						// TODO prevent the editors from getting dirty
						if (representations.size() != 0) {
							final RefreshRepresentationsCommand refresh = new RefreshRepresentationsCommand(
									transactionalEditingDomain,
									new NullProgressMonitor(), representations);
							transactionalEditingDomain.getCommandStack()
									.execute(refresh);
						}
					}
				}
			}
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
			for (Event event : LogicalStepHelper.getTickedEvents(step)) {
				if (event.getReferencedObjectRefs().size() != 0) {
					instructionURIs.add(EcoreUtil.getURI(event
							.getReferencedObjectRefs().get(0)));
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
			final Set<URI> oldInstructions = activatedInstructions.remove(context);
			if (oldInstructions != null && oldInstructions.size() != 0) {
				final Set<URI> tmpInstructions = new HashSet<URI>(
						oldInstructions);
				notifySirius(tmpInstructions);
			}
		}

	}

	/**
	 * The {@link GemocModelAnimator} instance.
	 */
	private final static GemocModelAnimator ANIMATOR = new GemocModelAnimator();

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
	 * Gets the {@link IGemocModelAnimator}.
	 * 
	 * @return the {@link IGemocModelAnimator}
	 */
	public static IGemocModelAnimator getAnimator() {
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
	 * {@link IGemocModelAnimator#activate(LogicalStep) activated}.
	 * 
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @return <code>true</code> if the given {@link EObject instruction} is a
	 *         currently {@link IGemocModelAnimator#activate(LogicalStep)
	 *         activated}, <code>false</code> otherwise
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
