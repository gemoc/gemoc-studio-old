package org.gemoc.gemoc_language_workbench.conf.util;

import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.confFactory;

public class XDSMLModelHelper {
	public static DomainModelProject getOrCreateDomainModelProject(
			LanguageDefinition languageDefinition) {
		if (languageDefinition.getDomainModelProject() == null) {
			DomainModelProject domainModelProject = confFactory.eINSTANCE
					.createDomainModelProject();
			languageDefinition.setDomainModelProject(domainModelProject);
		}
		return languageDefinition.getDomainModelProject();
	}

	public static EditorProject getOrCreateXTextEditorProject(
			LanguageDefinition languageDefinition) {

		EditorProject xTextEditor = null;
		for (EditorProject editor : languageDefinition.getEditorProjects()) {
			if (editor instanceof XTextEditorProject) {
				xTextEditor = editor;
				break;
			}
		}

		if (xTextEditor == null) {
			xTextEditor = confFactory.eINSTANCE.createXTextEditorProject();
			languageDefinition.getEditorProjects().add(xTextEditor);
		}
		return xTextEditor;
	}

	public static EditorProject getOrCreateSiriusEditorProject(
			LanguageDefinition languageDefinition) {

		EditorProject siriusEditor = null;
		for (EditorProject editor : languageDefinition.getEditorProjects()) {
			if (editor instanceof SiriusEditorProject) {
				siriusEditor = editor;
				break;
			}
		}

		if (siriusEditor == null) {
			siriusEditor = confFactory.eINSTANCE.createSiriusEditorProject();
			languageDefinition.getEditorProjects().add(siriusEditor);
		}
		return siriusEditor;
	}

	public static AnimatorProject getOrCreateSiriusAnimatorProject(
			LanguageDefinition languageDefinition) {
		AnimatorProject siriusEditor = null;
		for (AnimatorProject editor : languageDefinition.getAnimatorProjects()) {
			if (editor instanceof SiriusAnimatorProject) {
				siriusEditor = editor;
				break;
			}
		}

		if (siriusEditor == null) {
			siriusEditor = confFactory.eINSTANCE.createSiriusAnimatorProject();
			languageDefinition.getAnimatorProjects().add(siriusEditor);
		}
		return siriusEditor;
	}

	/*public static FileResource getOrCreateEmfGenmodel(
			LanguageDefinition languageDefinition) {
		DomainModelProject ecoreProject = (DomainModelProject) getOrCreateDomainModelProject(languageDefinition);
		if (ecoreProject.getEmfGenmodel() == null) {
			ecoreProject.setEmfGenmodel(confFactory.eINSTANCE
					.createEMFGenmodel());
		}
		return ecoreProject.getEmfGenmodel();
	}*/

	public static DSAProject getOrCreateDSAProject(
			LanguageDefinition languageDefinition) {
		if (languageDefinition.getDsaProject() == null) {
			languageDefinition.setDsaProject(confFactory.eINSTANCE
					.createDSAProject());
		}
		return languageDefinition.getDsaProject();
	}

	public static DSEProject getOrCreateDSEProject(
			LanguageDefinition languageDefinition) {
		if (languageDefinition.getDSEProject() == null) {
			languageDefinition.setDSEProject(confFactory.eINSTANCE
					.createDSEProject());
		}
		return languageDefinition.getDSEProject();
	}

	public static MoCCProject getOrCreateMoCCProject(
			LanguageDefinition languageDefinition) {
		if (languageDefinition.getMoCModelProject() == null) {
			languageDefinition.setMoCModelProject(confFactory.eINSTANCE
					.createMoCCProject());
		}
		return languageDefinition.getMoCModelProject();
	}
}
