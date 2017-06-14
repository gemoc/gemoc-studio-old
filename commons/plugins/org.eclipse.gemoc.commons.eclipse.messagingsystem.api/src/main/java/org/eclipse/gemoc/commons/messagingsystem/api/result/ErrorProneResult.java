/* $Id:$ 
 * Creation : 1 dec. 2010
 * Licence  : EPL 
 * Copyright: IRISA/INRIA
 * Authors  : 
 *            Didier Vojtisek <didier.vojtisek@inria.fr>
 */
package org.eclipse.gemoc.commons.messagingsystem.api.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gemoc.commons.messagingsystem.api.result.ResultProblemMessage.Severity;


/**
 * Result that can report errors or warning
 * Usually in case of error, the other data fields might be empty or incomplete
 * This class is intended to be subclassed to specify the data fields
 */
public class ErrorProneResult<G> {
	
	protected G result;
	
	public ErrorProneResult() {
	}
	public ErrorProneResult(G result) {
		super();
		this.result = result;
	}

	/**
	 * List of the problems returned by a process
	 */
	protected List<ResultProblemMessage> problems = new ArrayList<ResultProblemMessage>();

	public List<ResultProblemMessage> getProblems() {
		return problems;
	}
	
	/**
	 * indicates if there are some problems with a severity ERROR or FATAL
	 * @return
	 */
	public boolean hasSevereProblems() {
		boolean hasProblems = false;
		Iterator<ResultProblemMessage> it = problems.iterator();
		while(it.hasNext() && !hasProblems){
			ResultProblemMessage pm = it.next();
			if(pm.getSeverity().equals(Severity.ERROR) || pm.getSeverity().equals(Severity.FATAL)){
				hasProblems = true;
			}
		}
		return hasProblems;
	}

	public G getResult() {
		return result;
	}

	public void setResult(G result) {
		this.result = result;
	}
	
	
}
