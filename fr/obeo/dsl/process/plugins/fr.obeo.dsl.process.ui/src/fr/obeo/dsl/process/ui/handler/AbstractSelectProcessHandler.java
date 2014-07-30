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
package fr.obeo.dsl.process.ui.handler;

import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.provider.CustomProcessItemProviderAdapterFactory;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Select a {@link Process} instance.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractSelectProcessHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CustomProcessItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		final Shell shell = HandlerUtil.getActiveShell(event);
		List<IProcessRunner> processRunners = getProcessRunners(event);

		final ListDialog dialog = new ListDialog(shell);
		dialog.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			@Override
			public Object[] getElements(Object object) {
				if (object instanceof List) {
					return ((List<?>)object).toArray();
				} else {
					return super.getElements(object);
				}
			}
		});
		dialog.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {
				IProcessRunner runner = (IProcessRunner)element;
				return runner.getContext().getName();
			}

		});
		dialog.setMessage("Select a process:");
		dialog.setInput(processRunners);
		IProcessRunner currentProcessRunner = getCurrentProcessRunner(event);
		if (currentProcessRunner != null)
			dialog.setInitialSelections(new IProcessRunner[] {currentProcessRunner });

		// final ListDialog dialog = new ListDialog(shell, processRunners, new AdapterFactoryContentProvider(
		// adapterFactory) {
		// @Override
		// public Object[] getElements(Object object) {
		// if (object instanceof List) {
		// return ((List<?>)object).toArray();
		// } else {
		// return super.getElements(object);
		// }
		// }
		// },
		// /* new AdapterFactoryLabelProvider(adapterFactory) */
		// new LabelProvider() {
		// public String getText(Object element) {
		// IProcessRunner runner = (IProcessRunner)element;
		// return runner.getContext().getName();
		// }
		//
		// }, "Select a process:");
		dialog.setTitle("Process");
		dialog.open();
		final Object[] selection = dialog.getResult();
		if (selection != null && selection.length == 1 && selection[0] instanceof IProcessRunner) {
			setProcessRunner(event, (IProcessRunner)selection[0]);
		}
		adapterFactory.dispose();
		return null;
	}

	/**
	 * Gets the {@link List} of {@link ProcessContext} according to the given {@link ExecutionEvent}.
	 * 
	 * @param event
	 *            the {@link ExecutionEvent}
	 * @return the {@link List} of {@link ProcessContext} according to the given {@link ExecutionEvent}
	 */
	protected abstract List<IProcessRunner> getProcessRunners(ExecutionEvent event);

	protected abstract IProcessRunner getCurrentProcessRunner(ExecutionEvent event);

	/**
	 * Sets the given {@link ProcessContext} according to the given {@link ExecutionEvent}.
	 * 
	 * @param event
	 *            the {@link ExecutionEvent}
	 * @param processContext
	 *            the {@link ProcessContext}
	 */
	protected abstract void setProcessRunner(ExecutionEvent event, IProcessRunner processRunner);

}
