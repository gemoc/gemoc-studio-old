package org.gemoc.gee.gee_configuration.action.ui.popup.actions;

import gee_configuration.DSAModel;
import gee_configuration.DomainSpecificMetamodel;
import gee_configuration.GemocConfiguration;
import gee_configuration.impl.Gee_configurationFactoryImpl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.presentation.EcoreModelWizard;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.gee.gee_configuration.action.ui.Activator;

public class CreateKermetaDSAModelAction implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;
	
	/**
	 * Constructor for Action1.
	 */
	public CreateKermetaDSAModelAction() {
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
				    
				   
				    
				    
					
					
					try {
						resource.save(null);
					} catch (IOException e) {
						Activator.error(e.getMessage(), e);
					}
					
					MessageDialog.openInformation(
							shell,
							"Generic Execution Engine action Ui",
							"Create DSA Model : TODO force aspect project on top of the domain metamodel (ecore file).");
					IWizardDescriptor descriptor = PlatformUI
							.getWorkbench()
							.getNewWizardRegistry()
							.findWizard(
									"org.kermeta.kp.wizard.eclipse.wizards.KermetaProjectNewWizard");
					try {
						// Then if we have a wizard, open it.
						if (descriptor != null) {
							IWizard wizard = descriptor.createWizard();
							//((KermetaProjectNewWizard)wizard).init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
							WizardDialog wd = new WizardDialog(shell, wizard);
							wd.create();
							wd.setTitle(wizard.getWindowTitle());
							int res = wd.open();
							if(res == WizardDialog.OK){
								DSAModel dsaModel = Gee_configurationFactoryImpl.eINSTANCE
										.createDSAModel();
								//dsMetamodel.setLocation(((EcoreModelWizard)wizard).getModelFile().getLocationURI().toString()); // cannot get info that way dialog already disposed
								// get the new current selection								
								/*IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
							      IWorkbenchPage page = workbenchWindow.getActivePage();
							      
							      
							    		          if (page != null) {
							    		              IEditorPart editor = page.getActiveEditor();
							    		              if (editor != null) {
							    		                  IEditorInput input = editor.getEditorInput();
							    		                  if (input instanceof IFileEditorInput) {
							    		                	  dsaModel.setLocation("platform:/resource"+(((IFileEditorInput)input).getFile().getFullPath().toString()));
							    		                  }
							    		              }
							    		          }*/
							      //final IWorkbenchPart activePart = page.getActivePart(); //org.eclipse.emf.ecore.presentation.EcoreEditor
							     /* ISelection currentsel = page.getSelection();
							      if (currentsel instanceof IStructuredSelection) {
							          IStructuredSelection ssel = (IStructuredSelection) currentsel;
							          Object obj = ssel.getFirstElement(); 
							          IFile createdfile = (IFile) Platform.getAdapterManager().getAdapter(obj, IFile.class);
							          if (createdfile == null) {
							              if (obj instanceof IAdaptable) {
							            	  createdfile = (IFile) ((IAdaptable) obj).getAdapter(IFile.class);
							              }
							          }
							          if (createdfile != null) {
							        	  dsMetamodel.setLocation(createdfile.getLocationURI().toString());
							          }
							          
							      }*/
								MessageDialog.openInformation(
										shell,
										"Generic Execution Engine action Ui",
										"Create DSA Model : TODO find a way to retreive the created kermeta project and update the configuration.");
								
								myConf.getDsaModels().add(dsaModel);
								resource.save(null);
								file.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
							}
						}
					} catch (CoreException e) {
						Activator.error(e.getMessage(), e);
					} catch (IOException e) {
						Activator.error(e.getMessage(), e);
					/*} catch (InterruptedException e) {
						Activator.error(e.getMessage(), e);*/
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
