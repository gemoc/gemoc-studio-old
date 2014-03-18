/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.fsmkernel.model.design.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.gemoc.mocc.fsmkernel.model.design.Activator;

import com.google.inject.Injector;

/**
 * Inspired by the example from obeo
 * @see org.obeonetwork.dsl.viewpoint.xtext.support
 * 
 * @author creffst
 * <br><i>- updated to kepler (resolving emf compare issues)</i> 
 * <br><i>- updated to preserve xtext source format</i>
 *
 */
public class ResourceHelper {

	/**
	 * Dependency tracker service
	 */
	private final Injector xtextInjector;

	/**
	 * xtext pop up editor working resource
	 */
	private XtextResource xtextVirtualResource;

	/**
	 * host resource
	 */
	private Resource originalResource;

	/**
	 * Create new ResourceHelper for direct xtext edition
	 * @param xtextInjector : the dependency tracker xtext injector
	 */
	public ResourceHelper(Injector xtextInjector) {
		this.xtextInjector = xtextInjector;
	}

	/**
	 * Create new Xtext resource from an original one (from the host editor)
	 * @param originalR : original resource
	 * @return new xtext resource with a dummy uri in a temporary ResourceSet
	 * @throws IOException whenever occurs!
	 */
	public XtextResource createVirtualXtextResource(Resource originalR)
			throws IOException {
		this.originalResource = originalR;

		IResourceFactory resourceFactory = xtextInjector
				.getInstance(IResourceFactory.class);
		XtextResourceSet rs = xtextInjector.getInstance(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		URI uri = createURI();
		// Create virtual resource
		xtextVirtualResource = (XtextResource) resourceFactory
				.createResource(uri);

		rs.getResources().add(xtextVirtualResource);
		
		// Clone root EObject
		//EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
		//xtextVirtualResource.getContents().add(semanticElement);

		// Populate virtual resource with the given semantic element to edit
		String semanticModelText = ((LazyLinkingResource) originalR)
				.getSerializer().serialize(originalR.getContents().get(0));
		//String semanticModelText = ((LazyLinkingResource)originalR).getParseResult().getRootNode().getText();
		xtextVirtualResource.reparse(semanticModelText);
		
		xtextVirtualResource.validateConcreteSyntax();
		
		//Diagnostician.INSTANCE.validate
		
		EcoreUtil2.resolveLazyCrossReferences(xtextVirtualResource,
				CancelIndicator.NullImpl);
		
		

		// save to create file
		// TODO remove crappy hack
		xtextVirtualResource.save(Collections.emptyMap());

		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		xtextVirtualResource.save(out, Collections.emptyMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));

		EcoreUtil2.resolveLazyCrossReferences(xtextVirtualResource,
				CancelIndicator.NullImpl);

		return xtextVirtualResource;
	}

	/**
	 * @return a temp dummy "uri /tempProject/temp.dmodel"
	 */
	private URI createURI() {
		// FIXME remove crappy code and use in memory resource
		// URI uri = URI.createURI("XtextResource.ram");
		final String TEMPORARY_PROJECT_NAME = "tempProject";
		final IProjectDescription projectDescription = ResourcesPlugin
				.getWorkspace().newProjectDescription(TEMPORARY_PROJECT_NAME);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(TEMPORARY_PROJECT_NAME);
		try {
			if (!project.exists()) {
				project.create(projectDescription, new NullProgressMonitor());
				project.open(new NullProgressMonitor());
			}
		} catch (final CoreException e) {
			// Propagate as runtime exception
			throw new RuntimeException(e);
		}
		URI uri = URI.createPlatformResourceURI("/" + TEMPORARY_PROJECT_NAME
				+ "/temp.dmodel", false);
		return uri;
	}

	/**
	 * Update XText resource
	 * @param offset : starting modification edition region
	 * @param replacedTextLength : new text length
	 * @param newText : new modified text
	 * @throws IOException
	 * @throws BadLocationException
	 */
	public void updateXtextResource(final int offset,
			final int replacedTextLength, final String newText)
			throws IOException, BadLocationException {
		ICompositeNode oldRootNode = xtextVirtualResource.getParseResult()
				.getRootNode();
		String originalRegion = oldRootNode.getText();

		int changeOffset = offset - oldRootNode.getTotalOffset();
		StringBuffer reparseRegion = new StringBuffer();
		reparseRegion.append(originalRegion.substring(0, changeOffset));
		reparseRegion.append(newText);
		if (changeOffset + replacedTextLength < originalRegion.length())
			reparseRegion.append(originalRegion.substring(changeOffset
					+ replacedTextLength));
		String allText = reparseRegion.toString();

		xtextVirtualResource.reparse(allText);
		
		xtextVirtualResource.validateConcreteSyntax();
		
		EcoreUtil2.resolveLazyCrossReferences(xtextVirtualResource,
				CancelIndicator.NullImpl);

		final IParseResult parseResult = xtextVirtualResource.getParseResult();
		if (!parseResult.hasSyntaxErrors()) {
			applyChanges(originalResource.getContents().get(0),
					parseResult.getRootASTElement());
		} else {
			for (INode iNode : parseResult.getSyntaxErrors()) {
				iNode.getSyntaxErrorMessage();
			}
		}
	}

	/**
	 * Get changes between old and new semantic root object
	 * @param oldRootObject : root object from the host resource
	 * @param newRootObject : root object from the xtext pop up resource
	 * @return a list of differences
	 * @throws InterruptedException
	 */
	private List<Diff> getChanges(EObject oldRootObject, EObject newRootObject)
			throws InterruptedException {
		// use EMF compare in order to find changes
		// between oldRootObject tree and newRootObject tree

		// kepler version

		//useless customization
		/* IEObjectMatcher matcher =
		 DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.ONLY);
		 IComparisonFactory comparisonFactory = new
		 DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		 IMatchEngine matchEngine = new DefaultMatchEngine(matcher,
		 comparisonFactory);*/
		
		IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin
												.getDefault().getMatchEngineFactoryRegistry();

		IPostProcessor.Descriptor.Registry<String> postProcessorRegistry = EMFCompareRCPPlugin
												.getDefault().getPostProcessorRegistry();
		EMFCompare comparator = EMFCompare.builder()
												.setMatchEngineFactoryRegistry(matchEngineRegistry)
												.setPostProcessorRegistry(postProcessorRegistry).build();

		IComparisonScope scope = EMFCompare.createDefaultScope(newRootObject, oldRootObject);

		return comparator.compare(scope).getDifferences();

		// old version
		/*
		 * Map<String, Object> options = new HashMap<String, Object>();
		 * MatchModel matchModel = MatchService.doMatch(newRootObject,
		 * oldRootObject, options); DiffModel diffModel =
		 * DiffService.doDiff(matchModel); List<DiffElement> changes =
		 * collectChanges(diffModel);
		 */
		// return changes;
	}

	/**
	 * Apply changes detecting between old and new root semantic object (update old resource)
	 * @param oldRootObject : root object from the host resource
	 * @param newRootObject : root object from the xtext pop up resource
	 */
	private void applyChanges(EObject oldRootObject, EObject newRootObject) {
		try {
			final List<Diff> changes = getChanges(oldRootObject, newRootObject);

			final TransactionalEditingDomain editingDomain = TransactionUtil
					.getEditingDomain(originalResource);
			AbstractTransactionalCommand semanticCommand = new AbstractTransactionalCommand(
					editingDomain, "update resource after direct text edit",
					null) {
				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					try {
						IMerger.Registry registry = IMerger.RegistryImpl
								.createStandaloneInstance();
						// IBatchMerger batchMerger = new BatchMerger(registry);
						// batchMerger.copyAllLeftToRight(changes, monitor);
						for (Diff change : changes) {
							System.out.println("## change: " + change);
							if (change.getState() != DifferenceState.MERGED) {
								final IMerger merger = registry
										.getHighestRankingMerger(change);
								merger.copyLeftToRight(change,
										BasicMonitor.toMonitor(monitor));

							}

							// MergeService.merge(change, true);
						}
						return CommandResult.newOKCommandResult();
					} catch (Exception exc) {
						return CommandResult.newErrorCommandResult(exc);
					}
				}
			};
			AbstractTransactionalCommand formatingCommand = new AbstractTransactionalCommand(
					editingDomain,
					"update resource after direct text formating", null) {
				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					try {

						((LazyLinkingResource) originalResource)
								.reparse(xtextVirtualResource.getParseResult()
										.getRootNode().getText());
						originalResource.setModified(true);
						originalResource.getContents().get(0).notify();
						synchronized (originalResource) {
							originalResource.notifyAll();
						}

						return CommandResult.newOKCommandResult();
					} catch (Exception exc) {
						return CommandResult.newErrorCommandResult(exc);
					}
				}
			};
			if (!changes.isEmpty()) {
				semanticCommand.execute(new NullProgressMonitor(), null);
			} else {
				if (((LazyLinkingResource) oldRootObject.eResource())
						.getParseResult()
						.getRootNode()
						.getText()
						.compareTo(
								((LazyLinkingResource) newRootObject
										.eResource()).getParseResult()
										.getRootNode().getText()) != 0) {
					// check for formating modifications
					formatingCommand.execute(new NullProgressMonitor(), null);
				}
			}

		} catch (Exception e) {
			Activator.logError(e);
		}

	}

}
