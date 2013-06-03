package org.gemoc.gemoc_process.wizard.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import k2.standard.RichKermetaOrderedSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.mapping.ecore2ecore.presentation.Ecore2EcoreEditorPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_process.wizard.Activator;

public class GemocProjectNewWizardPage extends WizardPage {
	
	private ContextWizardNewProject		context;
	private static final List<String> FILE_EXTENSIONS = Arrays.asList(new String [] { "ecore" });
	private boolean enableNext;
	
	private Composite 	container;
	private Group 		grpListingMetaClasses;
	private Group 		grpEcoreSelection;
	private Text		txtSelectionEcore;
	private Button 		btnBrowse;
	private Button		btnSelectDeselectAll;
	private Button 		btnNext;
	private Table		tableListingMetaClasses;
	
	
	public GemocProjectNewWizardPage (ContextWizardNewProject context){
		super("wizardPage");
		setTitle("New DSML");
		setDescription("This wizard allows to generate a new DSML");
		this.context = context;
		this.enableNext = true;
	}
	
	/**
	 * Constructor for KermetaNewWizardDashboard.
	 * @param pageName
	 */
	public GemocProjectNewWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("New DSML");
		setDescription("This wizard allows to generate a new DSML");
		this.enableNext = true;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		
		//-----------------------------------------------
		grpEcoreSelection = new Group(container, SWT.NONE);
		grpEcoreSelection.setText("Ecore Selection");
		grpEcoreSelection.setBounds(10, 10, 635, 60);
		
		txtSelectionEcore = new Text(grpEcoreSelection, SWT.BORDER | SWT.READ_ONLY);
		txtSelectionEcore.setBounds(10, 23, 534, 21);

		btnBrowse = new Button(grpEcoreSelection, SWT.NONE);
		btnBrowse.setBounds(550, 21, 75, 25);
		btnBrowse.setText("Browse...");
		
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (workspaceDialog() || !txtSelectionEcore.getText().isEmpty()) {
					tableListingMetaClasses.removeAll();
					initializeListingMetaClasses();
					btnSelectDeselectAll.setSelection(false);
					//setPageComplete(true);
				}
			}
		});
		
		grpListingMetaClasses = new Group(container, SWT.NONE);
		grpListingMetaClasses.setText("Listing of MetaClasses");
		grpListingMetaClasses.setBounds(10, 76, 635, 445);

		btnSelectDeselectAll = new Button(grpListingMetaClasses, SWT.CHECK);
		btnSelectDeselectAll.setBounds(10, 48, 121, 16);
		btnSelectDeselectAll.setText("Select/ Deselect All");
		btnSelectDeselectAll.setEnabled(false);
		
		btnSelectDeselectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i = 0; i < tableListingMetaClasses.getItemCount(); i++)
				{
					if (btnSelectDeselectAll.getSelection()) {
						tableListingMetaClasses.getItems()[i].setChecked(true);
					} else {
						tableListingMetaClasses.getItems()[i].setChecked(false);						
					}
				}
			}
		});
		
		tableListingMetaClasses = new Table(grpListingMetaClasses, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tableListingMetaClasses.setBounds(10, 84, 615, 351);
		tableListingMetaClasses.setLinesVisible(true);
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);
	}
	
	private boolean workspaceDialog() {
		boolean bResult = false;
		
		final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Object selection = ((IStructuredSelection)workbenchWindow.getSelectionService().getSelection()).getFirstElement();
		final IFile selectedEcoreFile = 
				selection instanceof IFile && FILE_EXTENSIONS.contains(((IFile)selection).getFileExtension()) ? (IFile)selection : null;
		
		ViewerFilter viewerFilter = new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof IFile) {
					IFile file = (IFile)element;
					return FILE_EXTENSIONS.contains	(file.getFileExtension()) &&
													(selectedEcoreFile == null ||
													!selectedEcoreFile.getFullPath().equals(file.getFullPath()));
				}
				return true;
			}
		};
		
		final IFile[] files = WorkspaceResourceDialog.openFileSelection	(workbenchWindow.getShell(), 
																		null, 
																		Ecore2EcoreEditorPlugin.INSTANCE.getString("_UI_SelectOutputEcoreModels_label"), 
																		true, 
																		null, 
																		Collections.singletonList(viewerFilter));
		if (files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				this.context.ecoreIFile = files[i];				
				txtSelectionEcore.setText(files[i].getFullPath().toOSString());
				this.context.ecoreProjectPath = files[i].getProject().getFullPath().toOSString();
			}
			bResult = true;
		}
		return bResult;
	}
	
	private void initializeListingMetaClasses () {
		org.gemoc.gemoc_process.executable_metamodel_creator.KM2KMTexecutable_metamodel_creator creator = Activator.getKM2KMTexecutable_metamodel_creator();
		k2.standard.KermetaOrderedSet<String> listMetaClass = new RichKermetaOrderedSet<String>(new ArrayList<String>());
		
		if (creator != null) {
			listMetaClass = creator.listMetaClassesScala(this.context.ecoreIFile.getProject().getName() + "/" + this.context.ecoreIFile.getProjectRelativePath().toString());
		}
		
		for (int i = 0; i < listMetaClass.size(); i++) {
			new TableItem(tableListingMetaClasses, SWT.LEFT).setText(listMetaClass.at(i));
		}
		
		if (listMetaClass.isNotEmpty()) {
			btnSelectDeselectAll.setEnabled(true);
		} else {
			btnSelectDeselectAll.setEnabled(false);
		}
	}
	
	private void getSelectedMetaClasses (){
		for(int i = 0; i < this.tableListingMetaClasses.getSelectionIndices().length; i++) {
			this.context.listMetaClass.add(this.tableListingMetaClasses.getSelection()[i].toString());
		}
	}
	
	@Override
	public boolean canFlipToNextPage() {
	return enableNext;
	}
	
	@Override
	public IWizardPage getNextPage() {		
		for (int i = 0; i < tableListingMetaClasses.getItemCount(); i++)
		{
			if (tableListingMetaClasses.getItems()[i].getChecked()) {
				this.context.listMetaClass.add(tableListingMetaClasses.getItems()[i].getText());
			} 
		}
		return  super.getNextPage();
	}	
}
