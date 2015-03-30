package org.gemoc.gemoc_modeling_workbench.ui.breakpoint;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.DSLBreakpoint;

public class GemocBreakpoint extends DSLBreakpoint {

	/**
	 * The marker type ID.
	 */
	public static final String MARKER_ID = "org.gemoc.gemoc_modeling_workbench.ui.breakpoint.breakpointMarker";

	/**
	 * The break on logical step attribute.
	 */
	public static final String BREAK_ON_LOGICAL_STEP = "org.gemoc.gemoc_modeling_workbench.ui.breakpoint.breakOnLogicalStep";

	/**
	 * The break on MSE.
	 */
	public static final String BREAK_ON_MSE_OCCURRENCE = "org.gemoc.gemoc_modeling_workbench.ui.breakpoint.breakOnMSE";

	/**
	 * Should we break on {@link LogicalStep}.
	 */
	private boolean breakOnLogicalStep;

	/**
	 * Should we break on MSE.
	 */
	private boolean breakOnMSE;

	/**
	 * Constructor.
	 */
	public GemocBreakpoint() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param identifier
	 *            the debug model identifier
	 * @param instruction
	 *            the {@link EObject} representing the instruction
	 * @param persistent
	 *            should be persisted
	 * @throws CoreException
	 *             if marker can't be installed
	 */
	public GemocBreakpoint(String identifier, EObject instruction,
			boolean persistent) throws CoreException {
		super(identifier, instruction, persistent);
		setInstructionDefaultBreaks(instruction);
	}

	/**
	 * Tells if we should break on {@link LogicalStep}.
	 * 
	 * @return <code>true</code> if we should break on {@link LogicalStep},
	 *         <code>false</code> otherwise
	 */
	public boolean getBreakOnLogicalStep() {
		return breakOnLogicalStep;
	}

	/**
	 * Tells if we should break on MSE.
	 * 
	 * @return <code>true</code> if we should break on MSE, <code>false</code>
	 *         otherwise
	 */
	public boolean getBreakOnMSE() {
		return breakOnMSE;
	}

	/**
	 * Sets if we should break on {@link LogicalStep}.
	 * 
	 * @param value the
	 *            new value
	 */
	public void setBreakOnLogicalStep(boolean value) {
		breakOnLogicalStep = value;
		try {
			getMarker().setAttribute(GemocBreakpoint.BREAK_ON_LOGICAL_STEP, String.valueOf(breakOnLogicalStep));
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	/**
	 * Sets if we should break on MSE.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setBreakOnMSE(boolean value) {
		breakOnMSE = value;
		try {
			getMarker().setAttribute(GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE, String.valueOf(breakOnMSE)
					);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	/**
	 * Gets the marker ID.
	 * 
	 * @return the marker ID
	 */
	protected String getMarkerID() {
		return MARKER_ID;
	}

	@Override
	protected void setMarkerAttibutes(IMarker marker, IFile resource,
			EObject instruction, boolean persistent) throws CoreException {
		super.setMarkerAttibutes(marker, resource, instruction, persistent);
		setInstructionDefaultBreaks(instruction);
		marker.setAttribute(GemocBreakpoint.BREAK_ON_LOGICAL_STEP, String.valueOf(breakOnLogicalStep));
		marker.setAttribute(GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE, String.valueOf(breakOnMSE));
	}

	private void setInstructionDefaultBreaks(EObject instruction) {
		if (instruction instanceof LogicalStep) {
			breakOnLogicalStep = true;
			breakOnMSE = false;
		} else {
			breakOnLogicalStep = false;
			breakOnMSE = true;
		}
	}
	
	@Override
	public void setMarker(IMarker marker) throws CoreException {
		super.setMarker(marker);
		breakOnLogicalStep =Boolean.valueOf((String) marker.getAttribute(GemocBreakpoint.BREAK_ON_LOGICAL_STEP));
		breakOnMSE = Boolean.valueOf((String)marker.getAttribute(GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE));
	}
}
