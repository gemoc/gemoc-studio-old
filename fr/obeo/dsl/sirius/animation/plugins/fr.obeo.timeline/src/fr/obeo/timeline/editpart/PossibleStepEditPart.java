/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.timeline.editpart;

import fr.obeo.timeline.model.PossibleStep;
import fr.obeo.timeline.model.Connection;
import fr.obeo.timeline.model.Choice;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.jface.resource.JFaceResources;

/**
 * An {@link AbstractGraphicalEditPart} for {@link PossibleStep}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class PossibleStepEditPart extends AbstractGraphicalEditPart {

	/**
	 * The size of the circle.
	 */
	public static final int SIZE = 20;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		final Ellipse res = new Ellipse();
		res.setSize(SIZE, SIZE);
		res.setForegroundColor(ColorConstants.listBackground);
		Label toolTip = new Label();
		toolTip.setBackgroundColor(ColorConstants.tooltipBackground);
		toolTip.setForegroundColor(ColorConstants.tooltipForeground);
		res.setToolTip(toolTip);

		res.addMouseListener(new MouseListener.Stub() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.draw2d.MouseListener.Stub#mouseReleased(org.eclipse.draw2d.MouseEvent)
			 */
			@Override
			public void mousePressed(MouseEvent me) {
				if (me.button == 1) {
					final EditPartViewer viewer = getViewer();
					viewer.getSelectionManager().deselectAll();
					viewer.getSelectionManager().appendSelection(PossibleStepEditPart.this);
				}
			}

		});

		return res;
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		final IFigure figure = getFigure();
		if (!getModel().getChoice().hasSelected()) {
			figure.setBackgroundColor(ColorConstants.orange);
		} else {
			if (getModel().isSelected()) {
				figure.setBackgroundColor(ColorConstants.lightBlue);
			} else {
				figure.setBackgroundColor(ColorConstants.lightGreen);
			}
		}
		final Label toolTip = (Label)figure.getToolTip();
		toolTip.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
		toolTip.setText(getModel().getName());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
			 */
			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		});
	}

	@Override
	protected List<Connection> getModelSourceConnections() {
		return getModel().getFollowing();
	}

	@Override
	protected List<Connection> getModelTargetConnections() {
		return getModel().getPreceding();
	}

	@Override
	public PossibleStep getModel() {
		return (PossibleStep)super.getModel();
	}

	/**
	 * Gets the {@link PossibleStepEditPart} on the left.
	 * 
	 * @return the {@link PossibleStepEditPart} on the left if any, <code>null</code> otherwise
	 */
	public PossibleStepEditPart getLeftPossibleStepEditPart() {
		final PossibleStepEditPart res;

		final Choice previousChoice = getModel().getChoice().getPreviousChoice();
		if (previousChoice != null) {
			int previousConnectionIndex = previousChoice.getConnectedIndex();
			if (previousConnectionIndex < 0) {
				previousConnectionIndex = 0;
			}
			int connectionIndex = getModel().getChoice().getConnectedIndex();
			if (connectionIndex < 0) {
				connectionIndex = 0;
			}
			int offset = previousConnectionIndex - connectionIndex;
			if (previousChoice.getPossibleSteps().size() > getModel().getPossibleStepIndex() + offset
					&& getModel().getPossibleStepIndex() + offset > -1) {
				res = (PossibleStepEditPart)getViewer().getEditPartRegistry().get(
						previousChoice.getPossibleSteps().get(getModel().getPossibleStepIndex() + offset));
			} else {
				res = null;
			}
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the {@link PossibleStepEditPart} on the right.
	 * 
	 * @return the {@link PossibleStepEditPart} on the right if any, <code>null</code> otherwise
	 */
	public PossibleStepEditPart getRightPossibleStepEditPart() {
		final PossibleStepEditPart res;

		final Choice nextChoice = getModel().getChoice().getNextChoice();
		if (nextChoice != null) {
			int nextConnectionIndex = nextChoice.getConnectedIndex();
			if (nextConnectionIndex < 0) {
				nextConnectionIndex = 0;
			}
			int connectionIndex = getModel().getChoice().getConnectedIndex();
			if (connectionIndex < 0) {
				connectionIndex = 0;
			}
			int offset = nextConnectionIndex - connectionIndex;
			if (nextChoice.getPossibleSteps().size() > getModel().getPossibleStepIndex() + offset
					&& getModel().getPossibleStepIndex() + offset > -1) {
				res = (PossibleStepEditPart)getViewer().getEditPartRegistry().get(
						nextChoice.getPossibleSteps().get(getModel().getPossibleStepIndex() + offset));
			} else {
				res = null;
			}
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the {@link PossibleStepEditPart} above.
	 * 
	 * @return the {@link PossibleStepEditPart} above if any, <code>null</code> otherwise
	 */
	public PossibleStepEditPart getAbovePossibleStepEditPart() {
		return (PossibleStepEditPart)getViewer().getEditPartRegistry().get(getModel().getNextPossibleStep());
	}

	/**
	 * Gets the {@link PossibleStepEditPart} beneath.
	 * 
	 * @return the {@link PossibleStepEditPart} beneath if any, <code>null</code> otherwise
	 */
	public PossibleStepEditPart getBeneathPossibleStepEditPart() {
		return (PossibleStepEditPart)getViewer().getEditPartRegistry().get(getModel().getPreviousPossibleStep());
	}

}
