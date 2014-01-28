package fr.obeo.dsl.fuml.ui.launch;

import java.util.Iterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;

import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;
import fr.obeo.dsl.debug.ide.ui.launch.AbstractDSLLaunchConfigurationDelegateUI;
import fr.obeo.dsl.fuml.FUMLDebugger;
import fr.obeo.dsl.fuml.FUMLExecutionEngineForDSL;
import fr.obeo.dsl.fuml.ui.Activator;

public class FUMLDelegate extends AbstractDSLLaunchConfigurationDelegateUI {

	public static final String MODEL_ID = "fr.obeo.dsl.fuml.ui.debugModel";

	public static final String TYPE_ID = "fr.obeo.dsl.fuml.ui.launchConfiguration";

	private Behavior getBehavior(URI uri) {
		Behavior res = null;

		ResourceSet resourceSet = getResourceSet();
		Resource resource = resourceSet.getResource(uri, true);

		found: for (EObject root : resource.getContents()) {
			if (isLaunchBehavior(root)) {
				res = (Behavior) root;
				break found;
			} else {
				Iterator<EObject> it = root.eAllContents();
				while (it.hasNext()) {
					EObject current = it.next();
					if (isLaunchBehavior(current)) {
						res = (Behavior) current;
						break found;
					}
				}
			}

		}

		return res;
	}

	public static boolean isLaunchBehavior(EObject eObj) {
		return eObj instanceof Activity
				&& ((Activity) eObj).getName().startsWith("Launch");
	}

	@Override
	protected String getLaunchConfigurationTypeID() {
		return TYPE_ID;
	}

	@Override
	protected EObject getFirstInstruction(ISelection selection) {
		final IResource resource = getLaunchableResource(selection);
		return getBehavior(URI.createPlatformResourceURI(resource.getFullPath()
				.toString(), true));
	}

	@Override
	protected EObject getFirstInstruction(IEditorPart editor) {
		final EObject res;
		
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (selection instanceof IStructuredSelection
				&& ((IStructuredSelection) selection).getFirstElement() instanceof EObject
				&& isLaunchBehavior(((EObject) ((IStructuredSelection) selection)
						.getFirstElement()))) {
			res = ((EObject) ((IStructuredSelection) selection)
					.getFirstElement());
		} else {
			final IResource resource = getLaunchableResource(editor);
			res = getBehavior(URI.createPlatformResourceURI(resource
					.getFullPath().toString(), true));
		}

		return res;
	}

	@Override
	protected IDSLDebugger getDebugger(ILaunchConfiguration configuration,
			DSLDebugEventDispatcher dispatcher, EObject firstInstruction,
			IProgressMonitor monitor) {
		FUMLExecutionEngineForDSL engine = new FUMLExecutionEngineForDSL();
		engine.init(firstInstruction, new String[] {});
		FUMLDebugger res = new FUMLDebugger(dispatcher, engine);
		engine.setDebugger(res);
		return res;
	}

	@Override
	protected String getDebugTargetName(ILaunchConfiguration configuration,
			EObject firstInstruction) {
		return "fUML debugger " + ((Behavior) firstInstruction).getName();
	}

	@Override
	protected String getDebugJobName(ILaunchConfiguration configuration,
			EObject firstInstruction) {
		return "fUML debugger " + ((Behavior) firstInstruction).getName();
	}

	@Override
	protected String getPluginID() {
		return Activator.PLUGIN_ID;
	}

	@Override
	protected String getModelIdentifier() {
		return MODEL_ID;
	}

}
