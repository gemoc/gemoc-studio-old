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
package org.gemoc.mocc.cometaccsl.model.design.editor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.gemoc.mocc.cometaccsl.model.design.Activator;

import com.google.inject.Injector;


/**
 * Inspired by the example from obeo
 *
 * @see org.obeonetwork.dsl.viewpoint.xtext.support
 */
public class ResourceHelper {
	
	private final Injector xtextInjector;
	
	private XtextResource xtextVirtualResource;
	
	private Resource originalResource;
	
	
	public ResourceHelper(Injector xtextInjector) {
		this.xtextInjector = xtextInjector;
	}
	
	public XtextResource createVirtualXtextResource(EObject semanticElement) throws IOException {
		IResourceFactory resourceFactory = xtextInjector.getInstance(IResourceFactory.class);
		XtextResourceSet rs = xtextInjector.getInstance(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		URI uri = createURI();
		// Create virtual resource
		xtextVirtualResource = (XtextResource) resourceFactory.createResource(uri);
		rs.getResources().add(xtextVirtualResource);

		// Populate virtual resource with the given semantic element to edit
		xtextVirtualResource.getContents().add(semanticElement);
		//save to create file
		//TODO remove crappy hack
		xtextVirtualResource.save(Collections.emptyMap());
		
		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		xtextVirtualResource.save(out, Collections.emptyMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));				
		
		return xtextVirtualResource;
	}
	
	private URI createURI() {
		// FIXME remove crappy code and use in memory resource
		// URI uri = URI.createURI("XtextResource.ram");
		final String TEMPORARY_PROJECT_NAME = "tempProject";
		final IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(TEMPORARY_PROJECT_NAME);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(TEMPORARY_PROJECT_NAME);
		try {
			if (!project.exists()){
				project.create(projectDescription, new NullProgressMonitor());
				project.open(new NullProgressMonitor());
			}
		} catch (final CoreException e) {
			// Propagate as runtime exception
			throw new RuntimeException(e);
		}
		URI uri = URI.createPlatformResourceURI("/" + TEMPORARY_PROJECT_NAME + "/temp.dmodel", false);
		return uri;
	}
	
	protected void updateXtextResource(final int offset, final int replacedTextLength, final String newText,Resource fromResource) throws IOException, BadLocationException {
		ICompositeNode oldRootNode = xtextVirtualResource.getParseResult().getRootNode();
		//INode oldRootNode = getXtextSubsetRootNode(rootNode);
		//if (oldRootNode==null) {
		//	oldRootNode = rootNode;
		//}
		// final IParseResult parseResult =
		// xtextResource.getParser().reparse(oldRootNode, offset,
		// Reparse the entire document
		String originalRegion = oldRootNode.getText();//NodeModelUtils.getTokenText(oldRootNode);
		
		int changeOffset = offset - oldRootNode.getTotalOffset(); //bug!!!!!!!!!!!TODO
		StringBuffer reparseRegion = new StringBuffer();
		reparseRegion.append(originalRegion.substring(0, changeOffset));
		reparseRegion.append(newText);
		if (changeOffset + replacedTextLength < originalRegion.length())
			reparseRegion.append(originalRegion.substring(changeOffset + replacedTextLength));
		String allText = reparseRegion.toString();
		
		originalResource = fromResource;
		
		xtextVirtualResource.reparse(allText);
		final IParseResult parseResult = xtextVirtualResource.getParseResult();
		if (!parseResult.hasSyntaxErrors()) {
			applyChanges(originalResource.getContents().get(0), parseResult.getRootASTElement());
		}else {
			for (INode iNode : parseResult.getSyntaxErrors()) {
				iNode.getSyntaxErrorMessage();
			}
			//parseResult			parseResult.getSyntaxErrors().toString()
		}
	}
	
	private List<DiffElement> getChanges(EObject oldRootObject, EObject newRootObject) throws InterruptedException {
		// use EMF compare in order to find changes
		// between oldRootObject tree and newRootObject tree
		Map<String, Object> options = new HashMap<String, Object>();
		MatchModel matchModel = MatchService.doMatch(newRootObject, oldRootObject, options);
		DiffModel diffModel = DiffService.doDiff(matchModel);
		List<DiffElement> changes = collectChanges(diffModel);
		return changes;
	}

	private List<DiffElement> collectChanges(DiffModel diffModel) {
		ArrayList<DiffElement> changes = new ArrayList<DiffElement>();
		for (DiffElement diffElement : diffModel.getOwnedElements()) {
			collectChanges(changes, diffElement);
		}
		return changes;
	}

	private void collectChanges(List<DiffElement> changes, DiffElement diffElement) {
		if (diffElement.getSubDiffElements().size() == 0 && !(diffElement instanceof DiffGroup)) {
			changes.add(diffElement);
		} else {
			for (DiffElement elem : diffElement.getSubDiffElements()) {
				collectChanges(changes, elem);
			}
		}
	}

	private void applyChanges(EObject oldRootObject, EObject newRootObject) {
		try {
			final List<DiffElement> changes = getChanges(oldRootObject, newRootObject);
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(originalResource);
			AbstractTransactionalCommand gmfCommand = new AbstractTransactionalCommand(editingDomain, "update resource after direct text edit", null) {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					try {
						for (DiffElement change : changes) {
							System.out.println("## change: " + change);
							
							MergeService.merge(change, true);
						}
						return CommandResult.newOKCommandResult();
					} catch (Exception exc) {
						return CommandResult.newErrorCommandResult(exc);
					}
				}
			};
			gmfCommand.execute(new NullProgressMonitor(), null);
		} catch (Exception e) {
			Activator.logError(e);
		}

	}
	
}
