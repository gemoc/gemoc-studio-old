package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.util.XDSMLModelHelper;

/**
 * Wrapped version of the XDSML model dedicated to the GemoXDSMLForm view
 * 
 *
 */
public class XDSMLModelWrapper extends ViewModelWrapper {

	public LanguageDefinition languageDefinition;

	
	public XDSMLModelWrapper() {

	}

	public String getLanguageName() {
		if (languageDefinition != null) {
			return languageDefinition.getName();
		} else
			return "";
	}

	public void setLanguageName(String languageName) {
		firePropertyChange("languageName", languageDefinition.getName(),
				languageName);
		languageDefinition.setName(languageName);
	}

	public String getDomainModelProjectName() {
		if (languageDefinition != null) {
			return languageDefinition.getDomainModelProject().getProjectName();
		} else
			return "";
	}

	public void setDomainModelProjectName(String domainModelProjectName) {
		String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition
				.getDomainModelProject().getProjectName() : null;
		firePropertyChange("domainModelProjectName", oldName,
				domainModelProjectName);
		XDSMLModelHelper.getOrCreateDomainModelProject(languageDefinition)
				.setProjectName(domainModelProjectName);
	}

	public String getXTextEditorProjectName() {
		if (languageDefinition != null) {
			for (EditorProject editor : languageDefinition.getEditorProjects()) {
				if (editor instanceof XTextEditorProject) {
					return editor.getProjectName();
				}
			}
		}
		return "";
	}

	public void setXTextEditorProjectName(String name) {
		String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition
				.getDomainModelProject().getProjectName() : null;
		firePropertyChange("xTextEditorProjectName", oldName, name);
		XDSMLModelHelper.getOrCreateXTextEditorProject(languageDefinition)
				.setProjectName(name);

	}

	public String getSiriusEditorProjectName() {
		if (languageDefinition != null) {
			for (EditorProject editor : languageDefinition.getEditorProjects()) {
				if (editor instanceof ODProject) {
					return editor.getProjectName();
				}
			}
		}
		return "";
	}

	public void setSiriusEditorProjectName(String name) {
		String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition
				.getDomainModelProject().getProjectName() : null;
		firePropertyChange("xSiriusEditorProjectName", oldName, name);
		XDSMLModelHelper.getOrCreateSiriusEditorProject(languageDefinition)
				.setProjectName(name);
	}
	
	public String getSiriusAnimatorProjectName() {
		if (languageDefinition != null) {
			for (AnimatorProject editor : languageDefinition.getAnimatorProjects()) {
				//if (editor instanceof ODProject) {
					return editor.getProjectName();
				//}
			}
		}
		return "";
	}

	public void setSiriusAnimatorProjectName(String name) {
		String oldName = languageDefinition.getDomainModelProject() != null ? languageDefinition
				.getDomainModelProject().getProjectName() : null;
		firePropertyChange("xSiriusAnimatorProjectName", oldName, name);
		XDSMLModelHelper.getOrCreateSiriusAnimatorProject(languageDefinition)
				.setProjectName(name);
	}
}
