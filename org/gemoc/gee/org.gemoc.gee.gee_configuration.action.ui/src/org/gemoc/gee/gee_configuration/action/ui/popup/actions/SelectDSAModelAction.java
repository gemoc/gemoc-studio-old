package org.gemoc.gee.gee_configuration.action.ui.popup.actions;

import gee_configuration.DSAModel;
import gee_configuration.GemocConfiguration;
import gee_configuration.impl.Gee_configurationFactoryImpl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.gemoc.gee.gee_configuration.action.ui.Activator;

public class SelectDSAModelAction implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;
	
	/**
	 * Constructor for Action1.
	 */
	public SelectDSAModelAction() {
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
		if (selection instanceof IStructuredSelection) {
			for (Object o : ((IStructuredSelection) selection).toList()) {
				if (o instanceof IFile) {
					IFile file = (IFile) o;
					Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
				    Map<String, Object> m = reg.getExtensionToFactoryMap();
				    m.put("gee_configuration", new XMIResourceFactoryImpl());

				    // Obtain a new resource set
				    ResourceSet resSet = new ResourceSetImpl();

				    // Get the resource
				    Resource resource = resSet.getResource(URI.createURI((file).getLocationURI().toString()), true);
				    // Get the first model element and cast it to the right type, 
				    GemocConfiguration myConf = (GemocConfiguration) resource.getContents().get(0);
				    
				    
				    // TODO launch the appropriate wizard
				    
				    DSAModel dsaModel = Gee_configurationFactoryImpl.eINSTANCE.createDSAModel();
				    // TODO set the location according to the wizard result
				    MessageDialog.openInformation(
							shell,
							"Generic Execution Engine action Ui",
							"Create DSA Model : todo launch the appropriate wizard and set the location according to the wizard result.");
				    
					myConf.getDsaModels().add(dsaModel);
					try {
						resource.save(null);
					} catch (IOException e) {
						Activator.error(e.getMessage(), e);
					}
				}
			}
		}
		
		
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
