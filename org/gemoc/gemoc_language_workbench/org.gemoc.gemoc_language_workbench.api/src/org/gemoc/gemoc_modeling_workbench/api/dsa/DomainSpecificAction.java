/**
 * 
 */
package org.gemoc.gemoc_modeling_workbench.api.dsa;

/**
 * DomainSpecificAction is what a DomainSpecificEvent references. Its
 * implementation should contain information so as to call a real method (like
 * EMF bytecode). A DomainSpecificAction is executed by an Executor.
 * 
 * @author flatombe
 * 
 */
public interface DomainSpecificAction {
    public String getMethodQualifiedName();

    public String getTargetQualifiedName();
}
