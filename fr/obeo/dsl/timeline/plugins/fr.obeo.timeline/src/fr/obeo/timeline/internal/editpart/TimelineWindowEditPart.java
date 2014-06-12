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
import fr.obeo.timeline.internal.model.ITimelineWindowListener;
import fr.obeo.timeline.internal.model.Tic;
import fr.obeo.timeline.internal.model.TimelineWindow;
import fr.obeo.timeline.layout.LineLayout;
import fr.obeo.timeline.view.ITimelineProvider;

import java.util.List;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

/**
 * An {@link AbstractGraphicalEditPart} for {@link TimelineWindow}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TimelineWindowEditPart extends AbstractGraphicalEditPart implements ITimelineWindowListener {

	/**
	 * The spacing between {@link TicEditPart}.
	 */
	public static final int SPACING = 20;

	/**
	 * The margin.
	 */
	public static final int MARGIN = 10;

	@Override
	protected IFigure createFigure() {
		final LineLayout layout = new LineLayout();
		layout.setHorizontal(true);
		layout.setMajorAlignment(FlowLayout.ALIGN_TOPLEFT);
		layout.setMinorAlignment(FlowLayout.ALIGN_BOTTOMRIGHT);
		layout.setMinorSpacing(SPACING);
		layout.setMargin(MARGIN);

		FreeformLayer res = new FreeformLayer();
		res.setLayoutManager(layout);
		return res;
	}

	@Override
	public void setModel(Object model) {
		super.setModel(model);
		getModel().addTimelineWindowListener(this);
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
	public List<Tic> getModelChildren() {
		return getModel().getTics();
	}

	@Override
	public TimelineWindow getModel() {
		return (TimelineWindow)super.getModel();
	}

	@Override
	public void numberOfticksChanged(int numberOfticks) {
		// nothing to do here
	}

	@Override
	public void numberOfchoicesAtChanged(int index, int numberOfChoice) {
		final EditPart editPart = (EditPart)getViewer().getEditPartRegistry().get(new Tic(getModel(), index));
		editPart.refresh();
	}

	@Override
	public void textAtChanged(int index, String text) {
		final EditPart editPart = (EditPart)getViewer().getEditPartRegistry().get(new Tic(getModel(), index));
		editPart.refresh();
	}

	@Override
	public void atChanged(int index, int choice, Object object) {
		final EditPart editPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index, choice));
		if (editPart.equals(getViewer().getSelectedEditParts())) {
			getViewer().getSelectionManager().deselect(editPart);
			getViewer().getSelectionManager().appendSelection(editPart);
		}
	}

	@Override
	public void isSelectedChanged(int index, int choice, boolean selected) {
		final EditPart editPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index, choice));
		editPart.refresh();
	}

	@Override
	public void textAtChanged(int index, int choice, String text) {
		final EditPart editPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index, choice));
		editPart.refresh();
	}

	@Override
	public void followingChanged(int index, int choice, int following) {
		final EditPart sourceEditPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index, choice));
		sourceEditPart.refresh();
		final EditPart targetEditPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index + 1, choice));
		targetEditPart.refresh();
	}

	@Override
	public void precedingChanged(int index, int choice, int preceding) {
		final EditPart sourceEditPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index - 1, choice));
		sourceEditPart.refresh();
		final EditPart targetEditPart = (EditPart)getViewer().getEditPartRegistry().get(
				new Choice(getModel(), index, choice));
		targetEditPart.refresh();
	}

	@Override
	public synchronized void startChanged(int start) {
		deepRefresh();
	}

	@Override
	public synchronized void lengthChanged(int length) {
		deepRefresh();
	}

	@Override
	public void providerChanged(ITimelineProvider provider) {
		deepRefresh();
	}

	/**
	 * Refresh {@link EditPart} in depth.
	 */
	@SuppressWarnings("unchecked")
	private void deepRefresh() {
		try {
			refresh();
			for (EditPart child : (List<EditPart>)getChildren()) {
				if (child instanceof TicEditPart) {
					child.refresh();
					for (EditPart grandchild : (List<EditPart>)child.getChildren()) {
						if (grandchild instanceof ChoiceEditPart
								&& ((ChoiceEditPart)grandchild).getModel().isSelected()) {
							grandchild.refresh();
						}
					}
				}
			}
		} catch (IllegalArgumentException e) {
			// for some reason during a refresh an EditPart can be removed from its containing EditPart then
			// refreshed... causing an IllegalArgumentException
		}
	}

}
