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
package fr.obeo.dsl.process.ui.view;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.IProcessContextProvider;
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.provider.context.ContextProcessItemProviderAdapterFactory;
import fr.obeo.dsl.process.ui.provider.FlatProcessContextContentProvider;

import java.util.Arrays;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

/**
 * The {@link Process} view.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractProcessView extends ViewPart implements IProcessContextProvider {

	/**
	 * Ratio for the context composite.
	 */
	private static final double CONTEXT_COMPOSITE_RATIO = 0.20;

	/**
	 * Ratio for the context composite.
	 */
	private static final double DETAIL_TASKS_RATIO = 0.30;

	/**
	 * The {@link ComposedAdapterFactory}.
	 */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * The {@link ProcessContext} {@link TreeViewer}.
	 */
	private TreeViewer contextViewer;

	/**
	 * The current {@link ProcessContext}.
	 */

	private IProcessRunner processRunner;

	/**
	 * {@link TreeViewer} for {@link ProcessUtils#getPrecedingTasks(Task) preceding tasks}.
	 */
	private TreeViewer precedingTasksTreeViewer;

	/**
	 * {@link TreeViewer} for {@link ProcessUtils#getFollowingTasks(Task) following tasks}.
	 */
	private TreeViewer followingTasksTreeViewer;

	/**
	 * {@link ProcessContext#getUndoneReason(ActionTask) undone reason} label.
	 */
	private Label undoneReasonLabel;

	/**
	 * {@link Task#getDescription() Description} label.
	 */
	private Label descriptionLabel;

	/**
	 * {@link fr.obeo.dsl.process.IProcessRunner#doAction(ProcessContext, fr.obeo.dsl.process.ActionTask) Do}
	 * or
	 * {@link fr.obeo.dsl.process.IProcessRunner#undoAction(ProcessContext, fr.obeo.dsl.process.ActionTask)
	 * Undo} button.
	 */
	private Button doUndoButton;

	/**
	 * {@link Task#getName() Name} label.
	 */
	private Label nameLabel;

	/**
	 * {@link TreeViewer} for {@link ComposedTask#getTasks() Children tasks}.
	 */
	private TreeViewer childrenTasksTreeViewer;

	/**
	 * Details {@link Composite}.
	 */
	private Composite detailComposite;

	/**
	 * The green task image.
	 */
	private final Image greenTaskImage = new Image(Display.getDefault(), AbstractProcessView.class
			.getClassLoader().getResourceAsStream("icons/full/obj16/greenTaskButton.gif"));

	/**
	 * The grey task image.
	 */
	private final Image greyTaskImage = new Image(Display.getDefault(), AbstractProcessView.class
			.getClassLoader().getResourceAsStream("icons/full/obj16/greyTaskButton.gif"));

	/**
	 * The yellow task image.
	 */
	private final Image yellowTaskImage = new Image(Display.getDefault(), AbstractProcessView.class
			.getClassLoader().getResourceAsStream("icons/full/obj16/yellowTaskButton.gif"));

	@Override
	public void createPartControl(final Composite parent) {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ContextProcessItemProviderAdapterFactory(this));
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		parent.setLayout(new GridLayout(2, false));
		final GridData contextCompositeData = new GridData(SWT.FILL, SWT.FILL, true, true);
		final GridData detailCompositeData = new GridData(SWT.FILL, SWT.FILL, true, true);

		final Composite contextComposite = createContextComposite(parent);
		contextComposite.setLayoutData(contextCompositeData);

		detailComposite = createDetailComposite(parent);
		detailComposite.setLayoutData(detailCompositeData);
		parent.addListener(SWT.Resize, new Listener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
			 */
			public void handleEvent(Event event) {
				Point size = parent.getSize();

				contextCompositeData.widthHint = (int)(size.x * CONTEXT_COMPOSITE_RATIO);
				detailCompositeData.widthHint = size.x - contextCompositeData.widthHint;
			}
		});

		IDoubleClickListener doubleClickListener = createDoubleClickListener();

		contextViewer.addDoubleClickListener(doubleClickListener);
		precedingTasksTreeViewer.addDoubleClickListener(doubleClickListener);
		childrenTasksTreeViewer.addDoubleClickListener(doubleClickListener);
		followingTasksTreeViewer.addDoubleClickListener(doubleClickListener);

		if (getProcessContext() != null) {
			setPartName(getProcessContext().getName());
		}
	}

	/**
	 * The context composite on the left.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 * @return the context {@link Composite}
	 */
	protected Composite createContextComposite(Composite parent) {
		final Composite contextComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		contextComposite.setLayout(gridLayout);

		final Composite filterComposite = new Composite(contextComposite, SWT.NONE);
		filterComposite.setLayout(new RowLayout());
		final Button greenButton = new Button(filterComposite, SWT.TOGGLE);
		greenButton.setSelection(true);
		greenButton.setImage(greenTaskImage);
		final Button yellowButton = new Button(filterComposite, SWT.TOGGLE);
		yellowButton.setSelection(true);
		yellowButton.setImage(yellowTaskImage);
		final Button greyButton = new Button(filterComposite, SWT.TOGGLE);
		greyButton.setSelection(true);
		greyButton.setImage(greyTaskImage);

		FilteredTree tree = new FilteredTree(contextComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FLAT, new PatternFilter(), true);
		tree.getViewer().setContentProvider(getContentProvider());
		tree.getViewer().setLabelProvider(getLabelProvider());
		if (processRunner != null) {
			tree.getViewer().setInput(processRunner.getContext());
		}
		contextViewer = tree.getViewer();
		contextViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof TreeSelection) {
					TreeSelection selection = (TreeSelection)event.getSelection();
					if (selection.getPaths().length > 0) {
						if (selection.getPaths()[0].getLastSegment() instanceof Task) {
							Task task = (Task)selection.getPaths()[0].getLastSegment();
							updateDetailsTask(task);
						}
					}
				}
				// fireEngineSelectionChanged();

			}
		});

		final ViewerFilter taskStateFilter = new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				final boolean res;

				if (element instanceof Task) {
					final Task task = (Task)element;
					if (ProcessUtils.evaluatePrecondition(getProcessContext(), task)) {
						if (ProcessUtils.isDone(getProcessContext(), task)) {
							res = greenButton.getSelection();
						} else {
							res = yellowButton.getSelection();
						}
					} else {
						res = greyButton.getSelection();
					}
				} else {
					res = true;
				}

				return res;
			}
		};

		final ViewerFilter[] newFilters = Arrays.copyOf(contextViewer.getFilters(), contextViewer
				.getFilters().length + 1);
		newFilters[newFilters.length - 1] = taskStateFilter;
		contextViewer.setFilters(newFilters);

		contextViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				final Task task = getTaskFromSelection(event.getSelection());
				if (task != null) {
					updateDetailsTask(task);
				}
			}
		});

		final SelectionListener listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				contextViewer.refresh();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				contextViewer.refresh();
			}
		};
		greenButton.addSelectionListener(listener);
		yellowButton.addSelectionListener(listener);
		greyButton.addSelectionListener(listener);

		return contextComposite;
	}

	/**
	 * The detail composite on the right.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 * @return the detail {@link Composite}
	 */
	protected Composite createDetailComposite(final Composite parent) {
		Composite res = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		res.setLayout(gridLayout);
		res.setVisible(false);

		final Composite topComposite = new Composite(res, SWT.NONE);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		topComposite.setLayout(gridLayout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		topComposite.setLayoutData(gridData);
		final Composite nameComposite = new Composite(topComposite, SWT.NONE);
		gridLayout = new GridLayout(2, false);
		nameComposite.setLayout(gridLayout);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		nameComposite.setLayoutData(gridData);
		doUndoButton = new Button(nameComposite, SWT.NONE);
		doUndoButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
					case SWT.Selection:
						ActionTask actionTask = getSelectedActionTask();
						if (!ProcessUtils.isDone(getProcessContext(), actionTask)) {
							processRunner.doAction(actionTask);
						} else {
							processRunner.undoAction(actionTask);
						}
						// getProcessContext().getSelectedTask();
						System.out.println("Button pressed");
						break;
					default:
						break;
				}
			}
		});
		gridData = new GridData(SWT.FILL, SWT.FILL, false, true);
		doUndoButton.setLayoutData(gridData);
		nameLabel = new Label(nameComposite, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, false, true);
		nameLabel.setLayoutData(gridData);

		undoneReasonLabel = new Label(topComposite, SWT.WRAP);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		undoneReasonLabel.setLayoutData(gridData);

		descriptionLabel = new Label(topComposite, SWT.WRAP);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		descriptionLabel.setLayoutData(gridData);

		final Composite detailTasksComposite = createDetailTasksComposite(res);
		final GridData detailTasksCompositeData = new GridData();
		detailTasksCompositeData.verticalAlignment = GridData.FILL;
		detailTasksCompositeData.horizontalAlignment = GridData.FILL;
		detailTasksCompositeData.grabExcessVerticalSpace = true;
		detailTasksCompositeData.grabExcessHorizontalSpace = true;
		detailTasksComposite.setLayoutData(detailTasksCompositeData);

		return res;
	}

	/**
	 * The task detail composite bottom right.
	 * 
	 * @param parent
	 *            the parent {@link Composite}
	 * @return the task detail composite bottom right
	 */
	protected Composite createDetailTasksComposite(Composite parent) {
		GridLayout gridLayout;
		final Composite detailTasksComposite = new Composite(parent, SWT.NONE);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		detailTasksComposite.setLayout(gridLayout);
		precedingTasksTreeViewer = new TreeViewer(detailTasksComposite);
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		precedingTasksTreeViewer.getTree().setLayoutData(gridData);
		precedingTasksTreeViewer.setContentProvider(getContentProvider());
		precedingTasksTreeViewer.setLabelProvider(getLabelProvider());
		childrenTasksTreeViewer = new TreeViewer(detailTasksComposite);
		gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		childrenTasksTreeViewer.getTree().setLayoutData(gridData);
		childrenTasksTreeViewer.setContentProvider(getContentProvider());
		childrenTasksTreeViewer.setLabelProvider(getLabelProvider());
		followingTasksTreeViewer = new TreeViewer(detailTasksComposite);
		gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		followingTasksTreeViewer.getTree().setLayoutData(gridData);
		followingTasksTreeViewer.setContentProvider(getContentProvider());
		followingTasksTreeViewer.setLabelProvider(getLabelProvider());

		return detailTasksComposite;
	}

	/**
	 * Creates the {@link IDoubleClickListener} setting the current {@link Task}.
	 * 
	 * @return created the {@link IDoubleClickListener} setting the current {@link Task}s
	 */
	protected IDoubleClickListener createDoubleClickListener() {
		IDoubleClickListener doubleClickListener = new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				final Task task = getTaskFromSelection(event.getSelection());
				if (task != null) {
					if (getTaskFromSelection(contextViewer.getSelection()) != task) {
						contextViewer.setSelection(new StructuredSelection(task), true);
					}
					updateDetailsTask(task);
				}
			}
		};
		return doubleClickListener;
	}

	/**
	 * Gets the first {@link Task} from the given {@link ISelection}.
	 * 
	 * @param selection
	 *            the {@link ISelection}
	 * @return the first {@link Task} from the given {@link ISelection} if any, <code>null</code> otherwise
	 */
	private Task getTaskFromSelection(ISelection selection) {
		final Task res;

		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection)selection).getFirstElement();
			if (firstElement instanceof Task) {
				res = (Task)firstElement;
			} else {
				res = null;
			}
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Updates the details with the given {@link Task}.
	 * 
	 * @param task
	 *            the {@link Task}
	 */
	protected void updateDetailsTask(Task task) {
		if (task != null) {
			final boolean isComposedTask = task instanceof ComposedTask;
			nameLabel.setText(task.getName());
			if (!ProcessUtils.isDone(getProcessContext(), task)) {
				doUndoButton.setText("Do");
				doUndoButton.pack(true);
			} else {
				doUndoButton.setText("Undo");
				doUndoButton.pack(true);
			}
			doUndoButton.setVisible(!isComposedTask
					&& ProcessUtils.evaluatePrecondition(getProcessContext(), task));
			String undoneReason = "";
			if (!ProcessUtils.isDone(getProcessContext(), task)) {
				String undoneReasonRaw = ProcessUtils.getUndoneReason(getProcessContext(), task);
				if (undoneReasonRaw == null) {
					undoneReasonRaw = "Not evaluated because preconditions Tasks aren't Done. ";
				}
				undoneReason = "\nNot done due to: " + undoneReasonRaw;
				undoneReasonLabel.setText(undoneReason);
				undoneReasonLabel.setVisible(true);
				undoneReasonLabel.pack(true);
			} else {
				undoneReasonLabel.setVisible(false);
			}
			if (task.getDescription() != null) {
				descriptionLabel.setText(task.getDescription());
				descriptionLabel.pack(true);
			}
			precedingTasksTreeViewer.setInput(ProcessUtils.getPrecedingTasks(task));
			if (isComposedTask) {
				childrenTasksTreeViewer.setInput(((ComposedTask)task).getTasks());
				childrenTasksTreeViewer.getTree().setVisible(true);
			} else {
				childrenTasksTreeViewer.setInput(null);
			}
			followingTasksTreeViewer.setInput(ProcessUtils.getFollowingTasks(task));
			detailComposite.redraw();
			detailComposite.setVisible(true);
		} else {
			detailComposite.setVisible(false);
		}
	}

	@Override
	public void setFocus() {
		if (contextViewer != null) {
			contextViewer.getControl().setFocus();
		}
	}

	/**
	 * Sets the {@link ProcessContext}.
	 * 
	 * @param processRunner
	 *            the {@link ProcessContext}
	 */
	public void setProcessRunner(IProcessRunner processRunner) {
		this.processRunner = processRunner;
		setPartName(processRunner.getContext().getName());
		if (contextViewer != null) {
			contextViewer.setInput(processRunner.getContext());
		}
	}

	public IProcessRunner getProcessRunner() {
		return processRunner;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessContextProvider#getProcessContext()
	 */
	public ProcessContext getProcessContext() {
		final ProcessContext res;

		if (processRunner != null) {
			res = processRunner.getContext();
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the selected {@link ActionTask} from the {@link AbstractProcessView#contextViewer context viewer}.
	 * 
	 * @return the selected {@link ActionTask} from the {@link AbstractProcessView#contextViewer context
	 *         viewer} if any, <code>null</code> otherwise
	 */
	public ActionTask getSelectedActionTask() {
		final ActionTask res;
		final Task task = getTaskFromSelection(contextViewer.getSelection());

		if (task instanceof ActionTask) {
			res = (ActionTask)task;
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Gets the {@link IContentProvider} to use in the view.
	 * 
	 * @return the {@link IContentProvider} to use in the view
	 */
	protected IContentProvider getContentProvider() {
		return new FlatProcessContextContentProvider();
	}

	/**
	 * Gets the {@link ILabelProvider} to use in the view.
	 * 
	 * @return the {@link ILabelProvider} to use in the view
	 */
	protected ILabelProvider getLabelProvider() {
		return new AdapterFactoryLabelProvider(adapterFactory);
	}

	@Override
	public void dispose() {
		adapterFactory.dispose();
		greenTaskImage.dispose();
		greyTaskImage.dispose();
		yellowTaskImage.dispose();
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessContextProvider#refresh(java.lang.Object)
	 */
	public void refresh(final Object object) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				if (!contextViewer.getControl().isDisposed()) {
					contextViewer.refresh(object);
					final Task selectedTask = getTaskFromSelection(contextViewer.getSelection());
					if (selectedTask == object) {
						updateDetailsTask(selectedTask);
					}
				}
			}
		});
	}

}
