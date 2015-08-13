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
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.merge.BatchMerger;
import org.eclipse.emf.compare.merge.IBatchMerger;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gemoc.mocc.fsmkernel.model.design.editor.GraphicalPartHelper;

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
	
	private Comparison comparison;

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
	public XtextResource createVirtualXtextResource(Resource originalR, GraphicalPartHelper partHelper)
			throws IOException {
		this.originalResource = originalR;
 
		IResourceFactory resourceFactory = xtextInjector
				.getInstance(IResourceFactory.class);
		XtextResourceSet rs = xtextInjector.getInstance(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		
		URI xtextUri = URI.createURI(originalR.getURI().toString());

		// Create virtual resource
		xtextVirtualResource = (XtextResource) resourceFactory
				.createResource(xtextUri);

		rs.getResources().add(xtextVirtualResource);
		
		// Clone root EObject
		if (originalResource instanceof XMIResource) {
			EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
			xtextVirtualResource.getContents().add(semanticElement);
		}else {
			// Populate virtual resource with the given semantic element to edit (keeping textual formating)
			String semanticModelText = ((LazyLinkingResource) originalR)
					.getSerializer().serialize(originalR.getContents().get(0));
			//String semanticModelText = ((LazyLinkingResource)originalR).getParseResult().getRootNode().getText();
			xtextVirtualResource.reparse(semanticModelText);
			xtextVirtualResource.validateConcreteSyntax();
		}	
		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		try {
			
			xtextVirtualResource.save(out, Collections.emptyMap());
			xtextVirtualResource.reparse(new String(out.toByteArray()));
		} finally {
			out.close();
		}
		return xtextVirtualResource;
	}	

	/**
	 * Update XText resource
	 * @param newText : new modified text
	 * @throws IOException
	 * @throws BadLocationException
	 */
	public void updateXtextResource(final String allText)
			throws IOException, BadLocationException {
		xtextVirtualResource.reparse(allText);
		EcoreUtil.resolveAll(xtextVirtualResource);
		final IParseResult parseResult = xtextVirtualResource.getParseResult();
		
		if (!parseResult.hasSyntaxErrors() && !hasDanglingRefs(xtextVirtualResource)) {
			reconcileResourcesWhetherNecessary();
		} else {
			for (INode iNode : parseResult.getSyntaxErrors()) {
				System.err.println(iNode.getSyntaxErrorMessage());
			}
		}
	}

	private boolean hasDanglingRefs(XtextResource xtextResource2) {
		return EcoreUtil.UnresolvedProxyCrossReferencer.find(xtextResource2).size() > 0;
	}
	
	private void reconcileResourcesWhetherNecessary() {
		final List<Diff> changes = checkAndGetChangesBetweenResourcesIfAny();
		
		IMerger.Registry mergerRegistry = EMFCompareRCPPlugin.getDefault()
				.getMergerRegistry();
		final IBatchMerger merger = new BatchMerger(mergerRegistry);

		final TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(originalResource);
		
		if (!changes.isEmpty()) {
			editingDomain.getCommandStack().execute(
					new RecordingCommand(editingDomain,
							"update resource after direct text edit") {

						@Override
						protected void doExecute() {
							merger.copyAllRightToLeft(
									changes,
									new BasicMonitor());
						}
					});
		} else {
			/*if (originalResource instanceof LazyLinkingResource) {
				if (((LazyLinkingResource) originalResource)
						.getParseResult()
						.getRootNode()
						.getText()
						.compareTo(
								xtextVirtualResource.getParseResult()
										.getRootNode().getText()) != 0) {// check for formating modifications					
					
					editingDomain.getCommandStack().execute(
							new RecordingCommand(editingDomain,
									"update resource after direct text formating") {

								@Override
								protected void doExecute() {
									for (Iterator<EObject> iterator = originalResource.getContents().get(0).eAllContents(); iterator.hasNext();) {
										EObject originalObject = iterator.next();
										ICompositeNode originalNode = NodeModelUtils.getNode(originalObject);
										EObject virtualObject = comparison.getMatch(originalObject).getRight();
										ICompositeNode virtualNode = NodeModelUtils.getNode(virtualObject);
										
										if(originalNode.getText().compareTo(virtualNode.getText())!=0)
											System.out.println("TODO");
									}
									System.out.println("end");
									((LazyLinkingResource) originalResource)
									.reparse(xtextVirtualResource.getParseResult()
											.getRootNode().getText());
									//xtextVirtualResource.update(offset, replacedTextLength, newText);
									
									EcoreUtil.resolveAll(originalResource);
								}
							});
				}
			}*/
		}		
	}
	
	
	
	/**
	 * Get changes between the resources
	 * @return a list of differences between the original sirius resource
	 * and the embedded xtext editor one
	 */
	private EList<Diff> checkAndGetChangesBetweenResourcesIfAny(){
		IComparisonScope scope = new DefaultComparisonScope(
				originalResource, xtextVirtualResource, null);
		comparison = EMFCompare.builder().build()
				.compare(scope);
		return comparison.getDifferences();
	}


}
