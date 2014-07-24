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

import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.IProcessContextProvider;
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
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
	private ProcessContext processContext;

	private TreeViewer previousTasksTreeViewer;

	private TreeViewer followingTasksTreeViewer;

	private Label descriptionLabel;

	private Button doUndoButton;

	private Label nameLabel;

	private TreeViewer childrenTasksTreeViewer;

	private Composite detailComposite;

	@Override
	public void createPartControl(Composite parent) {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ContextProcessItemProviderAdapterFactory(this));
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		final Composite contextComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		contextComposite.setLayout(gridLayout);

		final Composite filterComposite = new Composite(contextComposite, SWT.NONE);
		filterComposite.setLayout(new RowLayout());
		final Button greenButton = new Button(filterComposite, SWT.TOGGLE);
		greenButton.setSelection(true);
		final Button yellowButton = new Button(filterComposite, SWT.TOGGLE);
		yellowButton.setSelection(true);
		final Button greyButton = new Button(filterComposite, SWT.TOGGLE);
		greyButton.setSelection(true);

		FilteredTree tree = new FilteredTree(contextComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FLAT, new PatternFilter(), true);
		tree.getViewer().setContentProvider(getContentProvider());
		tree.getViewer().setLabelProvider(getLabelProvider());
		if (processContext != null) {
			tree.getViewer().setInput(processContext);
		}
		contextViewer = tree.getViewer();

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

		detailComposite = new Composite(parent, SWT.NONE);
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		detailComposite.setLayout(gridLayout);

		final Composite nameComposite = new Composite(detailComposite, SWT.NONE);
		nameComposite.setLayout(new RowLayout());
		nameLabel = new Label(nameComposite, SWT.NONE);
		doUndoButton = new Button(nameComposite, SWT.NONE);

		descriptionLabel = new Label(detailComposite, SWT.NONE);

		final Composite detailTasksComposite = new Composite(parent, SWT.NONE);
		previousTasksTreeViewer = new TreeViewer(detailTasksComposite);
		childrenTasksTreeViewer = new TreeViewer(detailTasksComposite);
		followingTasksTreeViewer = new TreeViewer(detailTasksComposite);
	}

	/**
	 * Sets the current {@link Task}.
	 * 
	 * @param task
	 *            the {@link Task}
	 */
	protected void setCurrentTask(Task task) {
		if (task != null) {
			final boolean isComposedTask = task instanceof ComposedTask;
			nameLabel.setText(task.getName());
			doUndoButton.setVisible(!isComposedTask
					&& ProcessUtils.evaluatePrecondition(getProcessContext(), task));
			// TODO add a listener on the context to change the label of the button and visibility
			if (!ProcessUtils.isDone(getProcessContext(), task)) {
				doUndoButton.setText("Do");
			} else {
				doUndoButton.setText("Undo");
			}
			descriptionLabel.setText(task.getDescription());
			childrenTasksTreeViewer.getControl().setVisible(isComposedTask);
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
	 * @param processContext
	 *            the {@link ProcessContext}
	 */
	public void setProcessContext(ProcessContext processContext) {
		this.processContext = processContext;
		if (contextViewer != null) {
			contextViewer.setInput(processContext);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessContextProvider#getProcessContext()
	 */
	public ProcessContext getProcessContext() {
		return processContext;
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
				contextViewer.refresh(object);
			}
		});
	}
}
