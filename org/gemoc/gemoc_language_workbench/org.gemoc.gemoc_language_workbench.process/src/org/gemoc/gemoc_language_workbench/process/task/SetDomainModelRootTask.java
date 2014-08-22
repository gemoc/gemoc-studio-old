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

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.process.specific.AbstractActionProcessor2;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.process.utils.EMFResource;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseUI;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.commands.ENamedElementQualifiedNameLabelProvider;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyConcreteEClassDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyEObjectDialog;

/**
 * Set domain model root.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SetDomainModelRootTask extends AbstractActionProcessor2 {

	protected String lastEClassName = "";

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public SetDomainModelRootTask(ActionTask task) {
		super(task, false);
	}

	@Override
	protected Object internalUpdateContextWhenDone(GemocLanguageProcessContext context) {
		return lastEClassName;
	}

	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		boolean result = false;
		EMFEcoreProject eep = context.getEcoreProject();
		if (eep != null) {
			if (eep.getEmfGenmodel() == null 
				|| eep.getEmfGenmodel().getLocationURI() == null
				|| eep.getEmfGenmodel().getLocationURI().length() == 0) {
				undoneReason = "no valid genmodel referenced in xdsml";
				result = false;
			} else {
				final String eClsName = eep.getDefaultRootEObjectQualifiedName();
				String genModelPath = eep.getEmfGenmodel().getLocationURI();
				Object firstContent = EMFResource.getFirstContent(URI.createPlatformResourceURI("/" + genModelPath, true));
				if (firstContent instanceof GenModel
					&& hasClassifier((GenModel)firstContent, eClsName)) {
					lastEClassName = eClsName;
					result = true;
				} else {
					result = false;
					undoneReason = "Root EObject " + eClsName + " doesn't exists in " + genModelPath;
				}			
			}
		} else {
			undoneReason = "no EMF project referenced in xdsml";
		}
		return result;
	}

	/**
	 * Tells if a {@link org.eclipse.emf.ecore.EClassifier EClassifier} with the given name exists in the
	 * given {@link GenModel}.
	 * 
	 * @param genModel
	 *            the {@link GenModel}
	 * @param eClsName
	 *            the {@link org.eclipse.emf.ecore.EClassifier EClassifier} name
	 * @return <code>true</code> if a {@link org.eclipse.emf.ecore.EClassifier EClassifier} with the given
	 *         name exists in the given {@link GenModel}, <code>false</code> otherwise
	 */
	private boolean hasClassifier(GenModel genModel, String eClsName) {
		boolean res = false;
		for (GenPackage genPkg : genModel.getAllGenPackagesWithClassifiers()) {
			final EPackage ePkg = genPkg.getEcorePackage();
			if (ePkg != null) {
				if (ePkg.getEClassifier(eClsName) != null) {
					res = true;
					break;
				}
			}
		}
		return res;
	}

	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		IFile ecoreFile = activeFileEcore.getActiveFile();
		if (ecoreFile != null) {
			LabelProvider labelProvider = new ENamedElementQualifiedNameLabelProvider();
			Resource resource = EMFResource.getResource(ecoreFile);	
			SelectAnyEObjectDialog dialog = new SelectAnyConcreteEClassDialog(
													EclipseUI.getActiveWorkbenchShell(), 
													resource, 
													labelProvider);
			int res = dialog.open();
			if (res == WizardDialog.OK) {
				// update the project model
				setRootEObjectInConf(
							updatedGemocLanguageProject, 
							labelProvider.getText(dialog.getFirstResult()));
			}
		}
	}

	@Override
	protected void internalUndoAction(GemocLanguageProcessContext context) {
		EMFEcoreProject eep = context.getEcoreProject();
		if (eep != null) {
			eep.setDefaultRootEObjectQualifiedName(null);
			try {
				context.getXdsmlModel().eResource().save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void setRootEObjectInConf(IProject gemocLanguageIProject, String rootEObjectName) {
		IFile configFile = gemocLanguageIProject
				.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE));
		if (configFile.exists()) {
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());
			
			GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = (GemocLanguageWorkbenchConfiguration)EMFResource.getFirstContent(configFile);
			
			// consider only one language :-/
			LanguageDefinition language = gemocLanguageWorkbenchConfiguration.getLanguageDefinition();

			if (language.getDomainModelProject() instanceof EMFEcoreProject) {
				((EMFEcoreProject)language.getDomainModelProject())
						.setDefaultRootEObjectQualifiedName(rootEObjectName);
			}

			try {
				gemocLanguageWorkbenchConfiguration.eResource().save(null);
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		try {
			configFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		return acceptChangedResource(context, resource);
	}

	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return acceptChangedResource(context, resource);
	}

	public boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		return acceptChangedResource(context, resource);
	}

	protected boolean acceptChangedResource(GemocLanguageProcessContext context, IResource resource) {
		return 
			EclipseResource.isFile(resource, getGenModelURIFromXDSML(context))
			|| EclipseResource.checkFile(resource, context.getXdsmlURI());
	}

	/**
	 * retrieve the genmodel URI defined in the XDSML in the context variable
	 * 
	 * @return the URI of the genmodel or null if it cannot be retrieved in the context
	 */
	protected String getGenModelURIFromXDSML(GemocLanguageProcessContext context) {
		if (context.getXdsmlModel() != null 
			&& context.getXdsmlModel().getLanguageDefinition() != null) {
			EMFEcoreProject eep = context.getEcoreProject();
			if (eep != null
				&& eep.getEmfGenmodel() != null) {
				return "/" + eep.getEmfGenmodel().getLocationURI();
			}
		}
		return null;
	}

	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}
}
