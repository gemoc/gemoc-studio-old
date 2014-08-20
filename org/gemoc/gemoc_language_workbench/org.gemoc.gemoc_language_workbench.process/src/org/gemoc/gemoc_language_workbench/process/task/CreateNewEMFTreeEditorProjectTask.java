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
package org.gemoc.gemoc_language_workbench.process.task;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ContextVariable;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.process.specific.AbstractActionProcessor2;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction.CreateEditorProjectAction;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewEMFTreeEditorProjectTask extends AbstractActionProcessor2 {

	protected String undoneReason = "";

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewEMFTreeEditorProjectTask(ActionTask task) {
		super(task, true);
	}

	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		boolean result = false;
		// it exists an EMF Tree editor project that is referenced by the xdsml
		// else setUndone
		EditorProject treeEditorProjet = findTreeEditorInXDSML(context.getXdsmlModel());
		if (treeEditorProjet != null) {
			String projectName = treeEditorProjet.getProjectName();
			if (EclipseResource.existProject(projectName)) {
				result = true;
			} else {
				undoneReason = "Project " + projectName + " doesn't exist, check your xdsml file.";
			}
			result = true;
		} else {
			undoneReason = "No Tree editor project referenced in your xdsml file.";
		}
		return result;
	}

	@Override
	protected Object internalUpdateContextWhenDone(GemocLanguageProcessContext context) {
		EditorProject treeEditorProjet = findTreeEditorInXDSML(context.getXdsmlModel());
		return treeEditorProjet;
	}

	private EditorProject findTreeEditorInXDSML(GemocLanguageWorkbenchConfiguration xdsmlModel) {
		EList<EditorProject> editorsProjects = xdsmlModel.getLanguageDefinition().getEditorProjects();
		for (EditorProject editorProject : editorsProjects) {
			if (editorProject instanceof TreeEditorProject) {
				return editorProject;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(
				updatedGemocLanguageProject);
		action.actionToExecute = CreateEditorProjectAction.CREATE_NEW_EMFTREE_PROJECT;
		action.execute();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	@Override
	protected void internalUndoAction(GemocLanguageProcessContext context) {
		// nothing to do here
	}

	@Override
	protected String internalUpdateContextWhenUndone(GemocLanguageProcessContext context) {
		return undoneReason;
	}

	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		// if the changed resource is an IProject referenced by the xdsml as TreeEditor
		if (resource instanceof IProject) {
			EList<EditorProject> editorsProjects = context.getXdsmlModel().getLanguageDefinition()
					.getEditorProjects();
			for (EditorProject editorProject : editorsProjects) {
				if (editorProject instanceof TreeEditorProject) {
					if (resource.getName().equals(editorProject.getProjectName())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		boolean result = false;
		// if xdsml of the process has changed
		final URI uri = EclipseResource.getUri(resource);
		if (uri.equals(context.getXdsmlURI())) {
			result = true;
		} else

		// or if the changed resource is an IProject referenced by the xdsml as TreeEditor
		if (resource instanceof IProject) {
			EList<EditorProject> editorsProjects = context.getXdsmlModel().getLanguageDefinition()
					.getEditorProjects();
			for (EditorProject editorProject : editorsProjects) {
				if (editorProject instanceof TreeEditorProject) {
					if (resource.getName().equals(editorProject.getProjectName())) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}

}
