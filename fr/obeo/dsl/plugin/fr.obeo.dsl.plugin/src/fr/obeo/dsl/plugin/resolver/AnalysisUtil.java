/*******************************************************************************
 * Copyright 2005-2006, CHISEL Group, University of Victoria, Victoria, BC, Canada.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The Chisel Group, University of Victoria
 *     IBM CAS, IBM Toronto Lab
 *******************************************************************************/
package fr.obeo.dsl.plugin.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;

/**
 * 
 * @author Ian Bull
 *
 */
public class AnalysisUtil {
	
	public static BundleDescription[] getPath(BundleDescription root, BundleDescription bundle ) {
		LinkedList q = new LinkedList();
		Set orderedSet = new HashSet();
		LinkedList orderedList = new LinkedList();
		q.add(root);
		while(!q.isEmpty()) {
			BundleDescription head = (BundleDescription) q.remove(0);
			if ( !orderedSet.contains(head)) {
				orderedSet.add(head);
				orderedList.add(head);
				buildQueue(head, q);
			}
		}
		BundleDescription[] path = modifiedDijkstra(orderedList, root, bundle);
		return path;
	}
	
	private static void buildQueue(BundleDescription root, LinkedList q) {
		BundleDescription[] descriptions = getDependencies(root);
		if ( descriptions == null || descriptions.length == 0 ) return;
		for (int i = 0; i < descriptions.length; i++) {
			q.add(descriptions[i]);
		}
	}
	
	
	public static BundleDescription[] modifiedDijkstra(LinkedList q, BundleDescription s, BundleDescription t) {
		HashMap previous = new HashMap();
		HashMap dValues = new HashMap();
		for( Iterator iter = q.iterator(); iter.hasNext(); ) {
			dValues.put(iter.next(), new Integer(Integer.MAX_VALUE/ 10));
		}
		dValues.put(s, new Integer(0));
		
		while ( !q.isEmpty() ) {
			BundleDescription head = (BundleDescription) q.remove(0);
			BundleDescription[] outgoing = getDependencies(head);
			for (int i = 0; i < outgoing.length; i++) {
				BundleDescription v = outgoing[i];
				if ( ((Integer)dValues.get(head)).intValue() + 1 < ((Integer)dValues.get(v)).intValue()) {
					previous.put(v, head);
					dValues.put(v, new Integer(((Integer)dValues.get(head)).intValue() + 1));
				}
			}
		}
		LinkedList path = new LinkedList();
		BundleDescription currentNode = t;
		while ( previous.containsKey(currentNode) ) {
			path.add(currentNode);
			currentNode = (BundleDescription) previous.get(currentNode);
		}
		path.add(currentNode);
		return (BundleDescription[]) path.toArray(new BundleDescription[path.size()]);
	}
	
	public static BundleDescription[] getCallers(BundleDescription bundle, BundleDescription[] bundles) {
		HashSet callers = new HashSet();
		for (int i = 0; i < bundles.length; i++) {
			HashSet hashSet = new HashSet();
			hashSet.addAll(Arrays.asList(getDependencies(bundles[i])));
			if ( hashSet.contains(bundle)) {
				callers.add(bundles[i]);
			}
		}
		return (BundleDescription[]) callers.toArray(new BundleDescription[callers.size()]);
	}
	
	/**
	 * Finds all the callers for bundle within bunldes[]
	 * @return
	 */
	public static BundleDescription[] getAllCallers(BundleDescription bundle, BundleDescription[] bundles) {
		HashSet callers = new HashSet();
		for (int i = 0; i < bundles.length; i++) {
			HashSet hashSet = new HashSet();
			hashSet.addAll(Arrays.asList(getPrerequisites(new BundleDescription[]{bundles[i]})));
			if ( hashSet.contains(bundle)) {
				callers.add(bundles[i]);
			}
		}
		return (BundleDescription[]) callers.toArray(new BundleDescription[callers.size()]);
	}
	
	public static BundleDescription[] getPrerequisites(BundleDescription[] bundles) {
		if (bundles == null || bundles.length == 0)
			return new BundleDescription[0];
		Set reachable = new HashSet(bundles.length);
		for (int i = 0; i < bundles.length; i++)
			addPrerequisites(bundles[i], reachable);
		return (BundleDescription[]) reachable.toArray(new BundleDescription[reachable.size()]);
	}
	
	private static Collection getExportedDescription( BundleDescription element, ExportPackageDescription[] exportedPackages ) {
		Set descriptionList = new HashSet();
		for ( int i = 0; i < exportedPackages.length; i++ ) {
			ExportPackageDescription exportedPackage = exportedPackages[i];
			if ( !element.getLocation().equals(exportedPackage.getExporter().getLocation()))
				descriptionList.add(exportedPackage.getExporter());
		}
		return descriptionList;
	}

	
	public static BundleDescription[] getDependencies(BundleDescription bundle) {
		if ( bundle == null ) return null;
		
			
		Collection c = AnalysisUtil.getDescription(bundle.getRequiredBundles());
		c.addAll(getExportedDescription(bundle, bundle.getResolvedImports()));
		/*
		Iterator iterator = c.iterator();
		while (iterator.hasNext() ) {
			if ( iterator.next() == null ) iterator.remove();
		}
		*/

		return (BundleDescription[]) c.toArray(new BundleDescription[c.size()]);
	}

	private static void addPrerequisites(BundleDescription bundle, Set reachable) {
		if (reachable.contains(bundle))
			return;
		reachable.add(bundle);
		
		BundleDescription[] dependencies =getDependencies(bundle);
		for (int i = 0; i < dependencies.length; i++) {

			addPrerequisites(dependencies[i], reachable);
		}
	}
	
	public static Collection getDescription( BundleSpecification[] specifications ) {
		ArrayList descriptionList = new ArrayList();
		for ( int i = 0; i < specifications.length; i++ ) {
			BundleSpecification specification = specifications[i];
			descriptionList.add(specification.getSupplier());
		}
		return descriptionList;
	}
	
}
