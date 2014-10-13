package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
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
		firePropertyChange("languageName", getLanguageName(), languageName);
		languageDefinition.setName(languageName);
	}

	public String getDomainModelProjectName() {
		if (languageDefinition != null && languageDefinition.getDomainModelProject() != null) {
			return languageDefinition.getDomainModelProject().getProjectName();
		} else
			return "";
	}

	public void setDomainModelProjectName(String domainModelProjectName) {
		String oldName = getDomainModelProjectName();
		firePropertyChange("domainModelProjectName", oldName, domainModelProjectName);
		XDSMLModelHelper.getOrCreateDomainModelProject(languageDefinition)
				.setProjectName(domainModelProjectName);
	}

	public String getGenmodelLocationURI() {
		if (languageDefinition != null) {
			if (languageDefinition.getDomainModelProject() instanceof EMFEcoreProject) {
				EMFEcoreProject ecoreProject = (EMFEcoreProject) languageDefinition
						.getDomainModelProject();
				if (ecoreProject.getEmfGenmodel() != null) {
					return ecoreProject.getEmfGenmodel().getLocationURI();
				}
			}
		}
		return "";
	}

	public void setRootContainerModelElement(String root) {
		String oldName = getRootContainerModelElement();
		firePropertyChange("rootContainerModelElement", oldName, root);
		((EMFEcoreProject)XDSMLModelHelper.getOrCreateDomainModelProject(languageDefinition)).setDefaultRootEObjectQualifiedName(root);
	}

	public String getRootContainerModelElement() {
		if (languageDefinition != null) {
			if (languageDefinition.getDomainModelProject() instanceof EMFEcoreProject) {
				EMFEcoreProject ecoreProject = (EMFEcoreProject) languageDefinition
						.getDomainModelProject();
				return ecoreProject.getDefaultRootEObjectQualifiedName() != null ? ecoreProject.getDefaultRootEObjectQualifiedName() : "";
			}
		}
		return "";
	}

	public void setGenmodelLocationURI(String genmodel) {
		String oldName = getGenmodelLocationURI();
		firePropertyChange("genmodelLocationURI", oldName, genmodel);
		XDSMLModelHelper.getOrCreateEmfGenmodel(languageDefinition)
				.setLocationURI(genmodel);
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
		String oldName = getXTextEditorProjectName();
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
		String oldName = getSiriusEditorProjectName();
		firePropertyChange("xSiriusEditorProjectName", oldName, name);
		XDSMLModelHelper.getOrCreateSiriusEditorProject(languageDefinition)
				.setProjectName(name);
	}

	public String getSiriusAnimatorProjectName() {
		if (languageDefinition != null) {
			for (AnimatorProject editor : languageDefinition
					.getAnimatorProjects()) {
				return editor.getProjectName();
			}
		}
		return "";
	}

	public void setSiriusAnimatorProjectName(String name) {
		String oldName = getSiriusAnimatorProjectName();
		firePropertyChange("xSiriusAnimatorProjectName", oldName, name);
		XDSMLModelHelper.getOrCreateSiriusAnimatorProject(languageDefinition)
				.setProjectName(name);
	}

	public String getDSAProjectName() {
		if (languageDefinition != null && languageDefinition.getDsaProject() != null) {
			return languageDefinition.getDsaProject().getProjectName();
		} else
			return "";
	}

	public void setDSAProjectName(String projectName) {
		String oldName = getDSAProjectName();
		firePropertyChange("dSAProjectName", oldName, projectName);
		XDSMLModelHelper.getOrCreateDSAProject(languageDefinition)
				.setProjectName(projectName);
	}

	public String getDSEProjectName() {
		if (languageDefinition != null && languageDefinition.getDSEProject() != null) {
			return languageDefinition.getDSEProject().getProjectName();
		} else
			return "";
	}

	public void setDSEProjectName(String projectName) {
		String oldName = getDSEProjectName();
		firePropertyChange("dSEProjectName", oldName, projectName);
		XDSMLModelHelper.getOrCreateDSEProject(languageDefinition)
				.setProjectName(projectName);
	}

	public String getMoCCProjectName() {
		if (languageDefinition != null && languageDefinition.getMoCModelProject() != null) {
			return languageDefinition.getMoCModelProject().getProjectName();
		} else
			return "";
	}

	public void setMoCCProjectName(String projectName) {
		String oldName = getMoCCProjectName();
		firePropertyChange("moCCProjectName", oldName, projectName);
		XDSMLModelHelper.getOrCreateMoCCProject(languageDefinition)
				.setProjectName(projectName);
	}
}
