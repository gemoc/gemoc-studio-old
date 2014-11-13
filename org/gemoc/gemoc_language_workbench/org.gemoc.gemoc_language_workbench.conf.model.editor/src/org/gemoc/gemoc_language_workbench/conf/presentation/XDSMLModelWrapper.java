package org.gemoc.gemoc_language_workbench.conf.presentation;

import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject;
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
		if (languageDefinition != null && languageDefinition.getName() != null) {
			return languageDefinition.getName();
		} else
			return "";
	}

	public void setLanguageName(String languageName) {
		firePropertyChange("languageName", getLanguageName(), languageName);
		languageDefinition.setName(languageName);
	}

	public String getDomainModelProjectName() {
		if (languageDefinition != null && languageDefinition.getDomainModelProject() != null && languageDefinition.getDomainModelProject().getProjectName()!= null) {
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
			if (languageDefinition.getDomainModelProject() != null && languageDefinition.getDomainModelProject().getGenmodeluri() != null) {
				return languageDefinition.getDomainModelProject().getGenmodeluri();				
			}
		}
		return "";
	}

	public void setRootContainerModelElement(String root) {
		String oldName = getRootContainerModelElement();
		firePropertyChange("rootContainerModelElement", oldName, root);
		(XDSMLModelHelper.getOrCreateDomainModelProject(languageDefinition)).setDefaultRootEObjectQualifiedName(root);
	}

	public String getRootContainerModelElement() {
		if (languageDefinition != null) {
			if (languageDefinition.getDomainModelProject() != null) {
				DomainModelProject ecoreProject = (DomainModelProject) languageDefinition
						.getDomainModelProject();
				return ecoreProject.getDefaultRootEObjectQualifiedName() != null ? ecoreProject.getDefaultRootEObjectQualifiedName() : "";
			}
		}
		return "";
	}

	public void setGenmodelLocationURI(String genmodel) {
		String oldName = getGenmodelLocationURI();
		firePropertyChange("genmodelLocationURI", oldName, genmodel);
		XDSMLModelHelper.getOrCreateDomainModelProject(languageDefinition)
				.setGenmodeluri(genmodel);
	}

	public String getSupportedFileExtension(){
		StringBuilder sb = new StringBuilder();
		sb.append("Supported file extensions: ");
		int i = 0;
		for(String s : languageDefinition.getFileExtensions()){

			if(i > 0) {sb.append(", ");}
			sb.append(s);
			i++;
		}
		return sb.toString();
	}
	public void setSupportedFileExtension(String supportedFileExtensions){
		
	}
	
	public String getXTextEditorProjectName() {
		if (languageDefinition != null) {
			for (EditorProject editor : languageDefinition.getEditorProjects()) {
				if (editor instanceof XTextEditorProject && editor.getProjectName() != null) {
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
				if (editor instanceof SiriusEditorProject && editor.getProjectName() != null) {
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
		if (languageDefinition != null && languageDefinition.getDsaProject() != null && languageDefinition.getDsaProject().getProjectName()!= null) {
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

	public String getCodeExecutorClass() {
		if (languageDefinition != null) {
			if (languageDefinition.getDsaProject() != null && languageDefinition.getDsaProject().getCodeExecutorClass() != null) {
				return languageDefinition.getDsaProject().getCodeExecutorClass();				
			}
		}
		return "";
	}
	public void setCodeExecutorClass(String codeExecutorClass) {
		String oldName = getCodeExecutorClass();
		firePropertyChange("codeExecutorClass", oldName, codeExecutorClass);
		XDSMLModelHelper.getOrCreateDSAProject(languageDefinition)
				.setCodeExecutorClass(codeExecutorClass);
	}
	
	public String getDSEProjectName() {
		if (languageDefinition != null && languageDefinition.getDSEProject() != null && languageDefinition.getDSEProject().getProjectName() != null) {
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

	public String getQvtoURI() {
		if (languageDefinition != null) {
			if (languageDefinition.getDSEProject() != null && languageDefinition.getDSEProject().getQvtoURI() != null) {
				return languageDefinition.getDSEProject().getQvtoURI();				
			}
		}
		return "";
	}
	public void setQvtoURI(String qvtoURI) {
		String oldName = getQvtoURI();
		firePropertyChange("qvtoURI", oldName, qvtoURI);
		XDSMLModelHelper.getOrCreateDSEProject(languageDefinition)
				.setQvtoURI(qvtoURI);
	}
	
	public String getMoCCProjectName() {
		if (languageDefinition != null && languageDefinition.getMoCModelProject() != null && languageDefinition.getMoCModelProject().getProjectName() != null) {
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
