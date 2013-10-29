package org.gemoc.gemoc_language_workbench.api.dsa;

import java.lang.reflect.Method;

/**
 * Entity responsible for locating the method in the bytecode from the
 * corresponding DomainSpecificAction.
 * 
 * @author flatombe
 * 
 */
public interface BytecodeSentinel {
	/**
	 * Returns the Java Method corresponding to the DomainSpecificAction. This
	 * is specific to the technology used to write/compile the Domain Specific
	 * Actions and Dynamic Attributes.
	 * 
	 * @param dsa
	 * @return
	 */
	public Method getMethodFromAction(ModelSpecificAction msa)
			throws MethodNotFoundException;
}
