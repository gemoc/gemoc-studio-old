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
package fr.obeo.timeline.internal.editpart;

import fr.obeo.timeline.internal.model.Choice;
import fr.obeo.timeline.internal.model.Connection;
import fr.obeo.timeline.internal.model.Tic;

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

/**
 * An {@link AbstractGraphicalEditPart} for {@link Choice}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ChoiceEditPart extends AbstractGraphicalEditPart {

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
		if (getModel().isSelected()) {
			res.setBackgroundColor(ColorConstants.lightBlue);
		} else {
			res.setBackgroundColor(ColorConstants.lightGreen);
		}
		res.setSize(SIZE, SIZE);
		res.setForegroundColor(ColorConstants.listBackground);
		Label toolTip = new Label(getModel().getName());
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
					viewer.getSelectionManager().appendSelection(ChoiceEditPart.this);
				}
			}

		});

		return res;
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
	public Choice getModel() {
		return (Choice)super.getModel();
	}

	/**
	 * Gets the {@link ChoiceEditPart} on the left.
	 * 
	 * @return the {@link ChoiceEditPart} on the left if any, <code>null</code> otherwise
	 */
	public ChoiceEditPart getLeftChoiceEditPart() {
		final ChoiceEditPart res;

		final Tic previousTic = getModel().getTic().getPreviousTic();
		if (previousTic != null) {
			int previousConnectionIndex = previousTic.getConnectedIndex();
			if (previousConnectionIndex < 0) {
				previousConnectionIndex = 0;
			}
			int connectionIndex = getModel().getTic().getConnectedIndex();
			if (connectionIndex < 0) {
				connectionIndex = 0;
			}
			int offset = previousConnectionIndex - connectionIndex;
			if (previousTic.getChoices().size() > getModel().getIndex() + offset
					&& getModel().getIndex() + offset > -1) {
				res = (ChoiceEditPart)getViewer().getEditPartRegistry().get(
						previousTic.getChoices().get(getModel().getIndex() + offset));
			} else {
				res = null;
			}
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the {@link ChoiceEditPart} on the right.
	 * 
	 * @return the {@link ChoiceEditPart} on the right if any, <code>null</code> otherwise
	 */
	public ChoiceEditPart getRightChoiceEditPart() {
		final ChoiceEditPart res;

		final Tic nextTic = getModel().getTic().getNextTic();
		if (nextTic != null) {
			int nextConnectionIndex = nextTic.getConnectedIndex();
			if (nextConnectionIndex < 0) {
				nextConnectionIndex = 0;
			}
			int connectionIndex = getModel().getTic().getConnectedIndex();
			if (connectionIndex < 0) {
				connectionIndex = 0;
			}
			int offset = nextConnectionIndex - connectionIndex;
			if (nextTic.getChoices().size() > getModel().getIndex() + offset
					&& getModel().getIndex() + offset > -1) {
				res = (ChoiceEditPart)getViewer().getEditPartRegistry().get(
						nextTic.getChoices().get(getModel().getIndex() + offset));
			} else {
				res = null;
			}
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the {@link ChoiceEditPart} above.
	 * 
	 * @return the {@link ChoiceEditPart} above if any, <code>null</code> otherwise
	 */
	public ChoiceEditPart getAboveChoiceEditPart() {
		return (ChoiceEditPart)getViewer().getEditPartRegistry().get(getModel().getNextChoice());
	}

	/**
	 * Gets the {@link ChoiceEditPart} beneath.
	 * 
	 * @return the {@link ChoiceEditPart} beneath if any, <code>null</code> otherwise
	 */
	public ChoiceEditPart getBeneathChoiceEditPart() {
		return (ChoiceEditPart)getViewer().getEditPartRegistry().get(getModel().getPreviousChoice());
	}

}
