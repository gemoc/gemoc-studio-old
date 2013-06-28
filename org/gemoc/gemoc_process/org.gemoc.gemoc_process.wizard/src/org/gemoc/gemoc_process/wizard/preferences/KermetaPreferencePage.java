package org.gemoc.gemoc_process.wizard.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.gemoc.gemoc_process.wizard.Activator;
import org.kermeta.utils.helpers.eclipse.jface.preference.HelpfulTextFieldEditor;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class KermetaPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public KermetaPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Kermeta templates preferences");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		HelpfulTextFieldEditor kpTemplateField = new HelpfulTextFieldEditor(
				PreferenceConstants.P_NEW_KP_TEMPLATE_STRING, 
				"New KP file template", 
				getFieldEditorParent());
		addField(kpTemplateField);

		HelpfulTextFieldEditor kmtTemplateField = new HelpfulTextFieldEditor(
				PreferenceConstants.P_NEW_KMT_TEMPLATE_STRING, 
				"New KMT file template", 
				getFieldEditorParent());
		addField(kmtTemplateField);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		
		//IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		
		return result;
	}
	
	
	
	
	
}