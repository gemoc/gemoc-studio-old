package org.gemoc.gemoc_language_workbench.utils.resourcevisitors;


/**
 * ResourceVisitor that look and gathers ecore files
 * @author dvojtise
 *
 */
public class EcoreFileFinderResourceVisitor extends FileFinderVisitor{
	public EcoreFileFinderResourceVisitor() {
		super("ecore");
	}
}