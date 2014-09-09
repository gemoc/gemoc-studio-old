/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.guideline.process.specific;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.Activator;
import fr.obeo.dsl.process.IllegalVariableAccessException;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.impl.ProcessContextImpl;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.MoCProject;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.guideline.process.utils.EMFResource;
import org.gemoc.gemoc_language_workbench.guideline.process.utils.EclipseResource;

public class GemocLanguageProcessContext extends ProcessContextImpl {

	// convenient data that are maintained by some of the task in order to ease the search from other tasks
	// this
	// private GemocLanguageWorkbenchConfiguration _xdsmlModel;

	// private URI _xdsmlURI = null;

	/** String used to retreive an GemocLanguageWorkbenchConfiguration model element */
	public static final String XDSML_MODEL_VAR = "XDSML_MODEL";

	/** String used to retreive the URI of the xsdml */
	public static final String XDSML_FILE_URI_VAR = "XDSML_FILE_URI";

	public GemocLanguageProcessContext() {
		super();
	}

	public void initialize(URI newUri) {
		if (newUri != null) {
			setName("Gemoc process: " + newUri.toPlatformString(true));
			// CHECKSTYLE:OFF
			try {
				setXdsmlConfigURI(newUri, null);
			} catch (IllegalVariableAccessException e) {
				Activator.getDefault().error(e);
				// CHECKSTYLE:OFF
			} catch (Exception e) {
				// load of the xdsml model may fail if the file is ill-formed
				Activator.getDefault().error(e);
			}
			// CHECKSTYLE:ON
		}
	}

	public void setXdsmlConfigURI(URI newUri, ActionTask writterTask) throws IllegalVariableAccessException {
		if (newUri != null) {
			if (!newUri.equals(getVariableValue(XDSML_FILE_URI_VAR))) {
				this.setVariableValue(XDSML_FILE_URI_VAR, newUri, writterTask);
				loadXdsmlConfigURI(writterTask);
			}
		}
	}

	private Object getVariableValue(String varName) throws IllegalVariableAccessException {
		ProcessVariable processVar = getProcessVariable(varName);
		if (processVar == null) {
			throw new IllegalVariableAccessException("No ProcessVariable " + varName
					+ " in current ProcessContext");
		}
		return getVariableValue(processVar);
	}

	public void loadXdsmlConfigURI(ActionTask writterTask) throws IllegalVariableAccessException {
		URI xdsmlURI = (URI)getVariableValue(XDSML_FILE_URI_VAR);
		if (xdsmlURI != null) {
			this.setVariableValue(XDSML_MODEL_VAR, EMFResource.getFirstContent(xdsmlURI), writterTask);
		} else {
			this.setVariableValue(XDSML_MODEL_VAR, null, writterTask);
		}
	}

	// getter and setters
	// ------------------

	public GemocLanguageWorkbenchConfiguration getXdsmlModel() {
		try {
			return (GemocLanguageWorkbenchConfiguration)this.getVariableValue(XDSML_MODEL_VAR);
		} catch (IllegalVariableAccessException e) {
			Activator.getDefault().error(e);
		}
		return null;
	}

	public URI getXdsmlURI() {
		try {
			return (URI)getVariableValue(XDSML_FILE_URI_VAR);
		} catch (IllegalVariableAccessException e) {

			Activator.getDefault().error(e);
		}
		return null;
	}

	public IFile getXdsmlFile() {
		IFile file = null;
		URI xdsmlURI;
		try {
			xdsmlURI = (URI)getVariableValue(XDSML_FILE_URI_VAR);
			if (xdsmlURI != null) {
				file = EclipseResource.getFile(xdsmlURI);
			}
		} catch (IllegalVariableAccessException e) {
			Activator.getDefault().error(e);
		}
		return file;
	}

	private void setVariableValue(String varName, Object variableValue, ActionTask writterTask)
			throws IllegalVariableAccessException {
		ProcessVariable processVar = getProcessVariable(varName);
		if (processVar == null) {
			throw new IllegalVariableAccessException("No ProcessVariable " + varName
					+ " in current ProcessContext");
		}
		setVariableValue(processVar, variableValue, writterTask);
	}

	public EMFEcoreProject getEcoreProject() {
		EMFEcoreProject project = null;
		Object o = getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		if (o instanceof EMFEcoreProject) {
			project = (EMFEcoreProject)o;
		}
		return project;
	}

	public DSAProject getDSAProject() {
		DSAProject project = null;
		Object o = getXdsmlModel().getLanguageDefinition().getDsaProject();
		if (o instanceof DSAProject) {
			project = (DSAProject)o;
		}
		return project;
	}

	public DSEProject getDSEProject() {
		DSEProject project = null;
		Object o = getXdsmlModel().getLanguageDefinition().getDSEProject();
		if (o instanceof DSEProject) {
			project = (DSEProject)o;
		}
		return project;
	}
	public MoCProject getMOCProject() {
		MoCProject project = null;
		Object o = getXdsmlModel().getLanguageDefinition().getMoCModelProject();
		if (o instanceof MoCProject) {
			project = (MoCProject)o;
		}
		return project;
	}

	public ODProject getGraphicalEditor() {
		ODProject project = null;
		List<EditorProject> editors = getXdsmlModel().getLanguageDefinition().getEditorProjects();
		for (EditorProject editor : editors) {
			if (editor instanceof ODProject) {
				project = (ODProject)editor;
			}
		}
		return project;
	}

	public XTextEditorProject getTextualEditor() {
		XTextEditorProject project = null;
		List<EditorProject> editors = getXdsmlModel().getLanguageDefinition().getEditorProjects();
		for (EditorProject editor : editors) {
			if (editor instanceof XTextEditorProject) {
				project = (XTextEditorProject)editor;
			}
		}
		return project;
	}

	public TreeEditorProject getTreeEditor() {
		TreeEditorProject project = null;
		List<EditorProject> editors = getXdsmlModel().getLanguageDefinition().getEditorProjects();
		for (EditorProject editor : editors) {
			if (editor instanceof TreeEditorProject) {
				project = (TreeEditorProject)editor;
			}
		}
		return project;
	}

	public AnimatorProject getAnimatorEditor() {
		AnimatorProject project = null;
		List<AnimatorProject> animators = getXdsmlModel().getLanguageDefinition().getAnimatorProjects();
		if (animators.size() > 0) {
			project = animators.get(0);
		}
		return project;
	}

}
