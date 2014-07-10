package fr.obeo.timeline.view;

import fr.obeo.timeline.internal.editpart.ChoiceEditPart;
import fr.obeo.timeline.internal.editpart.TimelineEditPartFactory;
import fr.obeo.timeline.internal.editpart.TimelineWindowEditPart;
import fr.obeo.timeline.internal.model.ITimelineWindowListener;
import fr.obeo.timeline.internal.model.TimelineWindow;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomListener;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

/**
 * A graphical timeline view with an overview and a detail viewer.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TimelineView extends ViewPart {

	/**
	 * {@link KeyListener} for the timeline viewer.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class TimelineKeyListener implements KeyListener {

		@Override
		public void keyReleased(KeyEvent e) {
			// nothing to do here
		}

		@Override
		public void keyPressed(KeyEvent e) {
			final ChoiceEditPart toSelect;
			final List<?> selected = timelineViewer.getSelectedEditParts();
			if (selected.size() == 1 && selected.get(0) instanceof ChoiceEditPart) {
				final ChoiceEditPart part = (ChoiceEditPart)selected.get(0);
				switch (e.keyCode) {
					case SWT.ARROW_LEFT:
						// shift the TimelineWindow if needed
						if (timelineWindow.getStart() > part.getModel().getTic().getIndex() - 1
								&& part.getModel().getTic().getIndex() - 1 >= 0) {
							timelineWindow.setStart(timelineWindow.getStart() - 1);
						}
						toSelect = part.getLeftChoiceEditPart();
						break;

					case SWT.ARROW_RIGHT:
						// shift the TimelineWindow if needed
						if (timelineWindow.getEnd() <= part.getModel().getTic().getIndex() + 1
								&& part.getModel().getTic().getIndex() + 1 <= provider.getNumberOfTicks()) {
							timelineWindow.setStart(timelineWindow.getStart() + 1);
						}
						toSelect = part.getRightChoiceEditPart();
						break;

					case SWT.ARROW_UP:
						toSelect = part.getAboveChoiceEditPart();
						break;

					case SWT.ARROW_DOWN:
						toSelect = part.getBeneathChoiceEditPart();
						break;

					default:
						toSelect = null;
						break;
				}

				if (toSelect != null) {
					timelineViewer.getSelectionManager().deselectAll();
					timelineViewer.getSelectionManager().appendSelection(toSelect);
				}
			}
		}
	}

	/**
	 * Mouse listener handling the scroll.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class TimelineMouseListener implements MouseListener, MouseMoveListener {

		/**
		 * The position on the mouse down event.
		 */
		private Point originMousePosition;

		/**
		 * The offset of the scroll bars on the mouse down event.
		 */
		private Point offset = new Point();

		/**
		 * The shift applied to the timeline window so far.
		 */
		private int doneShift;

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// nothing to do here
		}

		@Override
		public void mouseDown(MouseEvent e) {
			originMousePosition = new Point(e.x, e.y);
			final Canvas canevas = (Canvas)timelineViewer.getControl();
			doneShift = 0;
			if (canevas.getVerticalBar() != null) {
				offset.y = canevas.getVerticalBar().getSelection();
			} else {
				offset.y = 0;
			}
		}

		@Override
		public void mouseUp(MouseEvent e) {
			originMousePosition = null;
		}

		@Override
		public void mouseMove(MouseEvent e) {
			if (originMousePosition != null) {
				final FigureCanvas canvas = (FigureCanvas)timelineViewer.getControl();
				canvas.scrollTo(offset.x, offset.y - e.y + originMousePosition.y);
				final int shift = (int)((-e.x + originMousePosition.x)
						/ (ChoiceEditPart.SIZE + TimelineWindowEditPart.SPACING) / rootEditPart
						.getZoomManager().getZoom())
						- doneShift;
				final int multiplier;
				if ((e.stateMask & SWT.MOD1) != 0) {
					multiplier = timelineWindow.getLength();
				} else {
					multiplier = 1;
				}
				if (timelineWindow.getStart() + shift * multiplier < 0) {
					timelineWindow.setStart(0);
				} else if (provider != null
						&& timelineWindow.getStart() + timelineWindow.getLength() + shift * multiplier > provider
								.getNumberOfTicks()) {
					timelineWindow.setStart(Math.max(
							provider.getNumberOfTicks() - timelineWindow.getLength(), 0));
				} else if (shift != 0) {
					doneShift += shift;
					timelineWindow.setStart(timelineWindow.getStart() + shift * multiplier);
				}
			}
		}
	}

	/**
	 * Lister to the {@link TimelineWindow} and update the slide bar.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private class TimelineWindowListener extends ITimelineWindowListener.Stub {
		@Override
		public void numberOfticksChanged(final int numberOfticks) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					if (!timelineSlider.isDisposed()) {
						timelineSlider.setMaximum(numberOfticks);
						timelineSlider.setVisible(timelineWindow.getLength() < numberOfticks);
					}
				}
			});
		}

		@Override
		public void startChanged(final int start) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					if (!timelineSlider.isDisposed()) {
						timelineSlider.setSelection(start);
					}
					timelineWindow.setLength(getWindowLength());
				}
			});
		}

		@Override
		public void lengthChanged(final int length) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					if (!timelineSlider.isDisposed()) {
						timelineSlider.setPageIncrement(length);
						timelineSlider.setThumb(length);
						if (provider != null) {
							timelineSlider.setVisible(timelineWindow.getLength() < provider
									.getNumberOfTicks());
						} else {
							timelineSlider.setVisible(false);
						}
					}
				}
			});
		}
	}

	/**
	 * The ID of this {@link ViewPart}.
	 */
	public static final String ID = "fr.obeo.timeline.view";

	/**
	 * The detail view ratio.
	 */
	private static final int DETAIL_RATIO = 10;

	/**
	 * The timeline view ratio.
	 */
	private static final int TIMELINE_RATIO = 90;

	/**
	 * The detail {@link TreeViewer}.
	 */
	private TreeViewer detailViewer;

	/**
	 * The timeline {@link ScrollingGraphicalViewer}.
	 */
	private ScrollingGraphicalViewer timelineViewer;

	/**
	 * The {@link ScalableFreeformRootEditPart}.
	 */
	private ScalableFreeformRootEditPart rootEditPart;

	/**
	 * Timeline {@link Slider}.
	 */
	private Slider timelineSlider;

	/**
	 * The {@link TimelineWindow}.
	 */
	private TimelineWindow timelineWindow;

	/**
	 * The {@link ITimelineProvider}.
	 */
	private ITimelineProvider provider;

	/**
	 * The timeline window listener.
	 */
	private ITimelineWindowListener timelineWindowListener;

	@Override
	public void createPartControl(Composite parent) {
		final SashForm mainSashForm = new SashForm(parent, SWT.HORIZONTAL);
		detailViewer = createDetailViewer(mainSashForm);
		timelineViewer = new ScrollingGraphicalViewer();
		getSite().setSelectionProvider(timelineViewer);
		Composite timelineComposite = new Composite(mainSashForm, SWT.NONE);
		timelineComposite.setLayout(new FillLayout(SWT.HORIZONTAL | SWT.VERTICAL));
		mainSashForm.setWeights(new int[] {DETAIL_RATIO, TIMELINE_RATIO, });
		GridLayout layout = new GridLayout(1, false);
		timelineComposite.setLayout(layout);
		timelineViewer.createControl(timelineComposite);

		timelineSlider = new Slider(timelineComposite, SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		timelineSlider.setLayoutData(gridData);
		gridData.grabExcessHorizontalSpace = true;

		rootEditPart = new ScalableFreeformRootEditPart();
		rootEditPart.setViewer(timelineViewer);
		timelineViewer.setRootEditPart(rootEditPart);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
		timelineViewer.getControl().setLayoutData(gridData);
		timelineViewer.setEditPartFactory(new TimelineEditPartFactory());
		timelineWindow = new TimelineWindow(provider);
		timelineViewer.setContents(timelineWindow);
		timelineSlider.setPageIncrement(timelineWindow.getLength());
		timelineSlider.setThumb(timelineWindow.getLength());
		timelineSlider.setSelection(timelineWindow.getStart());
		if (provider != null) {
			timelineSlider.setMaximum(provider.getNumberOfTicks());
			timelineSlider.setVisible(timelineWindow.getLength() < provider.getNumberOfTicks());
		} else {
			timelineSlider.setVisible(false);
		}
		timelineSlider.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				timelineWindow.setStart(timelineSlider.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				timelineWindow.setStart(timelineSlider.getSelection());
			}
		});
		timelineWindowListener = new TimelineWindowListener();
		timelineWindow.addTimelineWindowListener(timelineWindowListener);
		if (provider != null) {
			provider.addTimelineListener(timelineWindowListener);
		}
		timelineViewer.getControl().setBackground(ColorConstants.listBackground);
		timelineViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				final ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					final Object firstElement = ((IStructuredSelection)selection).getFirstElement();
					if (firstElement instanceof ChoiceEditPart) {
						final ChoiceEditPart choiceEditPart = (ChoiceEditPart)firstElement;
						detailViewer.setInput(choiceEditPart.getModel().getLogicalStep());
					}
				}
			}
		});
		timelineViewer.getControl().addKeyListener(new TimelineKeyListener());
		final TimelineMouseListener listener = new TimelineMouseListener();
		timelineViewer.getControl().addMouseListener(listener);
		timelineViewer.getControl().addMouseMoveListener(listener);
		timelineViewer.getControl().addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseScrolled(MouseEvent e) {
				if (e.count > 0) {
					rootEditPart.getZoomManager().zoomIn();
				} else {
					rootEditPart.getZoomManager().zoomOut();
					final int length = getWindowLength();
					if (provider != null && timelineWindow.getStart() + length > provider.getNumberOfTicks()
							&& provider.getNumberOfTicks() - length >= 0) {
						timelineWindow.setStart(provider.getNumberOfTicks() - length);
					}
				}
			}
		});
		rootEditPart.getZoomManager().addZoomListener(new ZoomListener() {

			@Override
			public void zoomChanged(double zoom) {
				timelineWindow.setLength(getWindowLength());
			}

		});
		timelineViewer.getControl().addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {
				timelineWindow.setLength(getWindowLength());
				final Canvas canevas = (Canvas)timelineViewer.getControl();
				canevas.getHorizontalBar().setVisible(false);
			}

			@Override
			public void controlMoved(ControlEvent e) {
				// nothing to do here
			}
		});

	}

	/**
	 * Gets the timeline viewer.
	 * 
	 * @return the timeline viewer
	 */
	public ScrollingGraphicalViewer getTimelineViewer() {
		return timelineViewer;
	}

	/**
	 * Sets the {@link ITimelineProvider}.
	 * 
	 * @param provider
	 *            the {@link ITimelineProvider}
	 */
	public void setTimelineProvider(ITimelineProvider provider) {
		timelineWindow.setProvider(provider);
		if (this.provider != null) {
			this.provider.removeTimelineListener(timelineWindowListener);
		}
		this.provider = provider;
		this.provider.addTimelineListener(timelineWindowListener);
		timelineWindow.setLength(getWindowLength());
	}

	/**
	 * Gets the length of the {@link TimelineWindow}.
	 * 
	 * @return the length of the {@link TimelineWindow}
	 */
	@SuppressWarnings("unchecked")
	private int getWindowLength() {
		double averageWidth = 0;
		if (timelineViewer.getContents().getChildren().size() != 0) {
			for (GraphicalEditPart editPart : (List<GraphicalEditPart>)timelineViewer.getContents()
					.getChildren()) {
				averageWidth += editPart.getFigure().getPreferredSize().width;
			}
			averageWidth /= timelineViewer.getContents().getChildren().size();
		} else {
			averageWidth = ChoiceEditPart.SIZE;
		}
		int length = (int)Math
				.floor((timelineViewer.getControl().getBounds().width - 2 * TimelineWindowEditPart.MARGIN)
						/ ((averageWidth + TimelineWindowEditPart.SPACING) * rootEditPart.getZoomManager()
								.getZoom()));
		return length;
	}

	/**
	 * Creates the detail {@link TreeViewer}.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 * @return the created detail {@link TreeViewer}
	 */
	protected TreeViewer createDetailViewer(Composite parent) {
		final FilteredTree treeViewer = new FilteredTree(parent, SWT.None, createDetailPatternFilter(), false);
		return treeViewer.getViewer();
	}

	/**
	 * Sets the detail view content provider.
	 * 
	 * @param detailContentProvider
	 *            the {@link IContentProvider}
	 */
	public void setDetailViewerContentProvider(IContentProvider detailContentProvider) {
		detailViewer.setContentProvider(detailContentProvider);
	}

	/**
	 * Sets the detail view label provider.
	 * 
	 * @param detailLabelProvider
	 *            the {@link ILabelProvider}
	 */
	public void setDetailViewerLabelProvider(ILabelProvider detailLabelProvider) {
		detailViewer.setLabelProvider(detailLabelProvider);
	}

	/**
	 * Creates a {@link PatternFilter} for the detail view.
	 * 
	 * @return the created {@link PatternFilter} for the detail view
	 */
	protected PatternFilter createDetailPatternFilter() {
		PatternFilter res = new PatternFilter();
		return res;
	}

	/**
	 * Gets the detail {@link Viewer}.
	 * 
	 * @return the detail {@link Viewer}
	 */
	public Viewer getDetailViewer() {
		return detailViewer;
	}

	@Override
	public void setFocus() {
		if (timelineViewer != null) {
			timelineViewer.getControl().setFocus();
		}
	}

	@Override
	public void dispose() {
		timelineWindow.removeTimelineWindowListener(timelineWindowListener);
		super.dispose();
	}

}
