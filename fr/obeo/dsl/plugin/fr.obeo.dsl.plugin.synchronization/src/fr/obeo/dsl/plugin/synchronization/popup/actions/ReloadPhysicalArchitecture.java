package fr.obeo.dsl.plugin.synchronization.popup.actions;

import java.util.Iterator;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareUI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.domain.impl.EMFCompareEditingDomain;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonEditorInput;
import org.eclipse.emf.compare.ide.ui.internal.editor.ComparisonScopeEditorInput;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.resolver.PluginsResourceFactory;

public class ReloadPhysicalArchitecture implements IObjectActionDelegate {

	private Shell shell;

	private PhysicalArchitecture selected;

	/**
	 * Constructor for Action1.
	 */
	public ReloadPhysicalArchitecture() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (selected != null) {
			PhysicalArchitecture newVersion = PluginsResourceFactory
					.createTargetPlatform();

			Resource fakeResource = new ResourceImpl(selected.eResource().getURI());
			ResourceSet set = new ResourceSetImpl();
			set.getResources().add(fakeResource);
			fakeResource.getContents().add(newVersion);

			EMFCompare comparator = EMFCompare.builder().build();
			IComparisonScope scope = EMFCompare.createDefaultScope(selected,
					newVersion);
			
			Comparison comparison = comparator.compare(scope);

			ICompareEditingDomain editingDomain = EMFCompareEditingDomain
					.create(selected, newVersion, null);
			org.eclipse.emf.common.notify.AdapterFactory adapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		    CompareEditorInput input = new ComparisonEditorInput(new CompareConfiguration(), comparison, editingDomain, adapterFactory);

			CompareUI.openCompareDialog(input); // or
												// CompareUI.openCompareEditor(input);
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (!selection.isEmpty() && selection instanceof StructuredSelection) {
			selected = null;
			Iterator<Object> it = ((StructuredSelection) selection).iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				if (obj instanceof PhysicalArchitecture) {
					selected = (PhysicalArchitecture) obj;
				}

			}
		}
	}
}
