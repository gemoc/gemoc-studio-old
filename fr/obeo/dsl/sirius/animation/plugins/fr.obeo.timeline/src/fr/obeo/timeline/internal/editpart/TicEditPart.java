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
import fr.obeo.timeline.internal.model.Tic;
import fr.obeo.timeline.layout.LineLayout;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

/**
 * An {@link AbstractGraphicalEditPart} for {@link Tic}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TicEditPart extends AbstractGraphicalEditPart {

	/**
	 * A padding figure for alignment.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private static final class PaddingFigure extends Ellipse {

		/**
		 * Constructor.
		 */
		public PaddingFigure() {
			super();
			setBackgroundColor(ColorConstants.listBackground);
			setForegroundColor(ColorConstants.listBackground);
			setSize(ChoiceEditPart.SIZE, ChoiceEditPart.SIZE);
		}

	}

	/**
	 * The size of the circle.
	 */
	public static final int SPACING = 15;

	/**
	 * The tic label.
	 */
	private Label label;

	@Override
	protected IFigure createFigure() {
		final LineLayout layout = new LineLayout();
		layout.setHorizontal(false);
		layout.setMajorAlignment(FlowLayout.ALIGN_TOPLEFT);
		layout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		layout.setMinorSpacing(SPACING);

		FreeformLayer res = new FreeformLayer();
		res.setLayoutManager(layout);
		label = new Label();
		res.add(label);
		return res;
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		if (getModel().hasSelected()) {
			align();
		}
		label.setText(String.valueOf(getModel().getIndex()));
	}

	/**
	 * Aligns the selected {@link ChoiceEditPart}.
	 */
	private void align() {
		final IFigure figure = getFigure();
		int existing = 0;
		while (figure.getChildren().size() - existing - 2 >= 0
				&& figure.getChildren().get(figure.getChildren().size() - existing - 2) instanceof PaddingFigure) {
			++existing;
		}
		final int offset = ((TimelineWindowEditPart)getParent()).getModel().getMaxSelectedIndex()
				- getModel().getConnectedIndex();

		if (existing < offset) {
			for (int i = 0; i < offset - existing; ++i) {
				figure.add(new PaddingFigure(), figure.getChildren().size() - 1);
			}
		} else if (existing > offset) {
			for (int i = 1; i <= existing - offset; ++i) {
				if (figure.getChildren().size() - 2 >= 0) {
					final IFigure toRemoveFigure = (IFigure)figure.getChildren().get(
							figure.getChildren().size() - 2);
					if (toRemoveFigure instanceof PaddingFigure) {
						figure.remove(toRemoveFigure);
					}
				}
			}
		}
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	public List<Choice> getModelChildren() {
		final List<Choice> res = new ArrayList<Choice>();

		final List<Choice> choices = getModel().getChoices();
		for (int i = choices.size() - 1; i >= 0; --i) {
			res.add(choices.get(i));
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModel()
	 */
	@Override
	public Tic getModel() {
		return (Tic)super.getModel();
	}

}
