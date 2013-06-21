package org.gemoc.gemoc_process.wizard.wizards;

import org.gemoc.gemoc_process.wizard.ContextDynamic.ClassDefinition;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class GemocProjectNewWizardAttributeDynManager extends WizardPage {
	
	private ContextWizardNewProject	context;
	private List<ClassDefinition> listClassDefinition;
	
	private Composite 	container;
	private Table		tableMetaClasses;
	private Label		lblAttributeName;
	private Text		txtAttributeName;
	private Label		lblReturnType;
	private Combo		comboReturnType;
	private Button		btnAddAttribute;
	private Table		tableAttributes;
	private Button		btnRemoveAttribute;
	
	public GemocProjectNewWizardAttributeDynManager (ContextWizardNewProject context){
		super("wizardPage");
		setTitle("New DSML");
		setDescription("This wizard allows to generate a new DSML");
		this.context = context;
		this.listClassDefinition = new ArrayList<ClassDefinition>();
	}
	
	/**
	 * Constructor for KermetaNewWizardDashboard.
	 * @param pageName
	 */
	public GemocProjectNewWizardAttributeDynManager(ISelection selection) {
		super("wizardPage");
		setTitle("New DSML");
		setDescription("This wizard allows to generate a new DSML");
		this.listClassDefinition = new ArrayList<ClassDefinition>();
	}
	
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		
		container.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				initializeMetaClasses();
			}
		});
		
		//-----------------------------------------------
		
		tableMetaClasses = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableMetaClasses.setBounds(10, 10, 649, 128);
		tableMetaClasses.setLinesVisible(true);
		
		lblAttributeName = new Label(container, SWT.NONE);
		lblAttributeName.setBounds(10, 179, 88, 15);
		lblAttributeName.setText("Attribute Name");
		
		txtAttributeName = new Text(container, SWT.BORDER);
		txtAttributeName.setBounds(10, 200, 147, 21);
		
		lblReturnType = new Label(container, SWT.NONE);
		lblReturnType.setBounds(199, 179, 67, 15);
		lblReturnType.setText("Return type");
		
		comboReturnType = new Combo(container, SWT.NONE);
		comboReturnType.setBounds(199, 200, 172, 23);
		
		btnAddAttribute = new Button(container, SWT.NONE);
		btnAddAttribute.setBounds(410, 200, 75, 25);
		btnAddAttribute.setText("Add");
		
		tableAttributes = new Table(container, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tableAttributes.setBounds(10, 252, 649, 181);
		tableAttributes.setLinesVisible(true);
		
		btnRemoveAttribute = new Button(container, SWT.NONE);
		btnRemoveAttribute.setBounds(10, 439, 75, 25);
		btnRemoveAttribute.setText("Remove");
		
		//-----------------------------------------------
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);
	}
	
	private void initializeMetaClasses () {
		if(this.context.listMetaClass.isNotEmpty()) {
			for (int i = 0; i < this.context.listMetaClass.size(); i++) {
				new TableItem(tableMetaClasses, SWT.LEFT).setText(this.context.listMetaClass.at(i));
			}
		}
	}
}
