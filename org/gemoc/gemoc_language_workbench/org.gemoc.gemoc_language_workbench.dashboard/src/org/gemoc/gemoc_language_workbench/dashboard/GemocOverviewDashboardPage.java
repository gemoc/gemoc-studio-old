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
package org.gemoc.gemoc_language_workbench.dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.gemoc.commons.eclipse.ui.OpenEditor;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.ProjectResource;
import org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.provider.confItemProviderAdapterFactory;
import org.gemoc.gemoc_language_workbench.dashboard.action.DescriptionAction;
import org.gemoc.gemoc_language_workbench.dashboard.action.FilterTreeAction;
import org.gemoc.gemoc_language_workbench.dashboard.form.FormHelper;
import org.gemoc.gemoc_language_workbench.dashboard.form.FormHelper.LayoutType;
import org.gemoc.gemoc_language_workbench.dashboard.form.MDSashForm;
import org.gemoc.gemoc_language_workbench.dashboard.utils.Couple;
import org.gemoc.gemoc_language_workbench.dashboard.utils.IImageKeys;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectDSAIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectDSEIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectEMFIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectMoCCIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectODesignIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectPluginIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectXtextIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateAnimatorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateAnimatorProjectWizardContextAction.CreateAnimatorProjectAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSEWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSEWizardContextAction.CreateDSEAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction.CreateEditorProjectAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateMOCCWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateMOCCWizardContextAction.CreateMOCCAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.contextDSA.CreateDSAWizardContextActionDSAK3;

public class GemocOverviewDashboardPage extends FormPage {
	private FormToolkit toolkit;

	private IManagedForm mForm;

	private ScrolledForm form;

	/**
	 * Diagrams Viewer weight (used by the sash).
	 */
	private static final int DIAGRAMS_VIEWER_WEIGHT = 40;

	/**
	 * Section weight (used by the sash).
	 */
	private static final int SECTION_WEIGHT = 60;

	private enum Overview {
		CREATE_LANGUAGE, MAKE_LANGUAGE_EXECUTABLE, DEFINE_RUNTIME_ENV
	}

	private String currentOverview = Overview.CREATE_LANGUAGE.name();

	/**
	 * Container that hosts all sections.
	 */
	private Composite sectionContainer;

	/**
	 * Viewer that displays diagrams.
	 */
	private TreeViewer viewer;

	/**
	 * Container that hosts the viewer.
	 */
	private Composite viewerContainer;

	/**
	 * Sash that layouts activities in one column and diagrams in another one.
	 */
	private MDSashForm sashForm;

	private Composite overviewSectionContainer;

	private IResourceChangeListener resourceChangeListener;

	private LanguageDefinition languageDefinition;

	public GemocOverviewDashboardPage(FormEditor formEditor) {
		super(
				formEditor,
				"org.gemoc_language_workbench.dashboard.page", Messages.GemocDashboardPage_Dashboard_Tab_Title); //$NON-NLS-1$
		resourceChangeListener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				IResourceDelta delta = event.getDelta();
				if (delta.findMember(new Path("/" //$NON-NLS-1$
						+ ((GemocDashboardEditorInput)getEditorInput()).getFile().getProject().getName())) != null) {
					ResourceSet resSet = new ResourceSetImpl();
					Resource resource = resSet.getResource(URI.createPlatformResourceURI(
							((GemocDashboardEditorInput)getEditorInput()).getFile().getFullPath()
									.toOSString(), false), true);
					languageDefinition = (LanguageDefinition)resource.getContents().get(0);
					refreshForm(currentOverview);
				}
			}
		};
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener,
				IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		mForm = managedForm;
		toolkit = managedForm.getToolkit();
		// Set the header title.
		form = managedForm.getForm();
		form.setText(Messages.GemocDashboardPage_Dashboard_Form_Title);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginTop = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.marginBottom = 0;
		Composite body = form.getBody();
		body.setLayout(layout);
		toolkit.decorateFormHeading(form.getForm());

		// Create Overview section.
		createOverviewSection(body, currentOverview);
		createSashForm(body, currentOverview);

	}

	private void createSashForm(Composite body, String overview) {
		sashForm = new MDSashForm(body, SWT.NULL);
		sashForm.setData("form", mForm); //$NON-NLS-1$
		toolkit.adapt(sashForm, false, false);
		sashForm.setMenu(form.getBody().getMenu());
		// Install a default layout based on two columns.
		sashForm.setLayout(new GridLayout(2, false));
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
		// The left one contains sections.
		sectionContainer = createSectionContainer(sashForm);
		// The right one, contains a tree viewer that displays diagrams for related page.
		viewerContainer = createViewerContainer(sashForm);
		viewerContainer.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Create tree viewer
		Couple<TreeViewer, Section> createdViewer = createViewer(viewerContainer, mForm);
		viewer = createdViewer.getKey();
		// Create sections.
		createSections(sectionContainer, mForm, overview);

		sashForm.setWeights(new int[] {SECTION_WEIGHT, DIAGRAMS_VIEWER_WEIGHT });
	}

	/**
	 * Create the overview section.
	 * 
	 * @param parent
	 *            Parent
	 * @param overview
	 *            Selected overview step
	 */
	protected void createOverviewSection(Composite parent, String overview) {
		overviewSectionContainer = createOverviewSectionContainer(parent);
		String imgKeyCreateLanguage;
		String imgKeyCreateLanguageHover;
		if (Overview.CREATE_LANGUAGE.name().equals(overview)) {
			imgKeyCreateLanguage = IImageKeys.IMG_CREATE_LANGUAGE_ACTIVATED;
			imgKeyCreateLanguageHover = IImageKeys.IMG_CREATE_LANGUAGE_ACTIVATED_HOVER;
		} else {
			imgKeyCreateLanguage = IImageKeys.IMG_CREATE_LANGUAGE;
			imgKeyCreateLanguageHover = IImageKeys.IMG_CREATE_LANGUAGE_HOVER;
		}

		String imgKeyMakeLanguageExecutable;
		String imgKeyMakeLanguageExecutableHover;
		if (Overview.MAKE_LANGUAGE_EXECUTABLE.name().equals(overview)) {
			imgKeyMakeLanguageExecutable = IImageKeys.IMG_MAKE_LANGUAGE_EXECUTABLE_ACTIVATED;
			imgKeyMakeLanguageExecutableHover = IImageKeys.IMG_MAKE_LANGUAGE_EXECUTABLE_ACTIVATED_HOVER;
		} else {
			imgKeyMakeLanguageExecutable = IImageKeys.IMG_MAKE_LANGUAGE_EXECUTABLE;
			imgKeyMakeLanguageExecutableHover = IImageKeys.IMG_MAKE_LANGUAGE_EXECUTABLE_HOVER;
		}

		String imgKeyDefineRuntimeEnv;
		String imgKeyDefineRuntimeEnvHover;
		if (Overview.DEFINE_RUNTIME_ENV.name().equals(overview)) {
			imgKeyDefineRuntimeEnv = IImageKeys.IMG_DEFINE_RUNTIME_ENV_ACTIVATED;
			imgKeyDefineRuntimeEnvHover = IImageKeys.IMG_DEFINE_RUNTIME_ENV_ACTIVATED_HOVER;
		} else {
			imgKeyDefineRuntimeEnv = IImageKeys.IMG_DEFINE_RUNTIME_ENV;
			imgKeyDefineRuntimeEnvHover = IImageKeys.IMG_DEFINE_RUNTIME_ENV_HOVER;
		}

		ImageHyperlink createLanguageLink = createImageHyperlink(overviewSectionContainer,
				imgKeyCreateLanguage, imgKeyCreateLanguageHover,
				Messages.GemocDashboardPage_Create_Language_Tooltip);
		createLanguageLink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				refreshForm(Overview.CREATE_LANGUAGE.name());
			}
		});

		ImageHyperlink makeLanguageExecLink = createImageHyperlink(overviewSectionContainer,
				imgKeyMakeLanguageExecutable, imgKeyMakeLanguageExecutableHover,
				Messages.GemocDashboardPage_Make_Language_Executable_Tooltip);
		makeLanguageExecLink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				refreshForm(Overview.MAKE_LANGUAGE_EXECUTABLE.name());
			}
		});

		ImageHyperlink defineRuntimeEnvLink = createImageHyperlink(overviewSectionContainer,
				imgKeyDefineRuntimeEnv, imgKeyDefineRuntimeEnvHover,
				Messages.GemocDashboardPage_Define_Runtime_Environement_Tooltip);
		defineRuntimeEnvLink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				refreshForm(Overview.DEFINE_RUNTIME_ENV.name());
			}
		});
	}

	private ImageHyperlink createImageHyperlink(Composite parent, String imagePath, String hoverImagePath,
			String toolTipText) {
		ImageHyperlink imageLink = toolkit.createImageHyperlink(parent, SWT.WRAP);
		Image image = getImage(imagePath);
		imageLink.setImage(image);
		Image hoverImage = getImage(hoverImagePath);
		imageLink.setHoverImage(hoverImage);
		imageLink.setToolTipText(toolTipText);
		return imageLink;
	}

	private Image getImage(String imagekey) {
		return GemocDashboardActivator.getDefault().getImage(imagekey);
	}

	/**
	 * Create section displayed in this page.<br>
	 * Default implementation return <code>null</code>.
	 * 
	 * @param sectionContainer_p
	 * @param overview
	 * @return First created section. This one is used to enable UI alignment with Diagram viewer section.
	 */
	protected void createSections(final Composite sectionContainer_p, IManagedForm managedForm_p,
			String overview) {
		if (Overview.CREATE_LANGUAGE.name().equals(overview)) {
			createCreateLanguageSection(sectionContainer_p);
		} else if (Overview.MAKE_LANGUAGE_EXECUTABLE.name().equals(overview)) {
			createMakeLanguageExecutableSection(sectionContainer_p);
		} else if (Overview.DEFINE_RUNTIME_ENV.name().equals(overview)) {
			createDefineDebuggerSection(sectionContainer_p);
		}
	}

	private void createCreateLanguageSection(final Composite sectionContainer) {
		createDomainModelSection(sectionContainer);
		createModelEditorSection(sectionContainer);
	}

	private void createMakeLanguageExecutableSection(final Composite sectionContainer) {
		createConcurrentExecutionSemanticsSection(sectionContainer);
		createSequentialExecutionSemanticsSection(sectionContainer);
	}

	private void createDefineDebuggerSection(final Composite sectionContainer) {
		createModelDebuggerSection(sectionContainer);
		createModelDynamicRepresentationSection(sectionContainer);
	}

	private void createModelDebuggerSection(final Composite sectionContainer_p) {
		List<IAction> toolbarActions = new ArrayList<IAction>();
		toolbarActions.add(new DescriptionAction("description/ModelDebuggerDescription.xml", sectionContainer //$NON-NLS-1$
				.getShell()));
		toolbarActions.add(new FilterTreeAction(viewer, languageDefinition, sectionContainer.getShell()));

		// Create the section.
		Couple<Section, Composite> section = FormHelper.createTwistieSectionWithToolbar(sectionContainer_p,
				mForm, Messages.GemocDashboardPage_Model_Debugger_Section_Title, null, true, toolbarActions);

		// Get the section composite.
		Composite sectionComposite = section.getValue();
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_SELECT_BREAKPOINT),
				Messages.GemocDashboardPage_Select_Breakpoint_Section_Title, null,
				Messages.GemocDashboardPage_Select_Breakpoint_Description_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						// TODO Connect expected action
						System.out.println("TODO Select your breakpointable elements"); //$NON-NLS-1$
					}
				});
	}

	private void createModelDynamicRepresentationSection(final Composite sectionContainer_p) {
		List<IAction> toolbarActions = new ArrayList<IAction>();
		toolbarActions.add(new DescriptionAction("description/ModelDynamicRepresentationDescription.xml", //$NON-NLS-1$
				sectionContainer.getShell()));
		toolbarActions.add(new FilterTreeAction(viewer, languageDefinition.getAnimatorProjects(),
				sectionContainer.getShell()));

		// Create the section.
		Couple<Section, Composite> section = FormHelper.createTwistieSectionWithToolbar(sectionContainer_p,
				mForm, Messages.GemocDashboardPage_Model_Dynamic_Section_Title, null, true, toolbarActions);

		// Get the section composite.
		Composite sectionComposite = section.getValue();
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_GRAPHICAL_ANIMATOR),
				Messages.GemocDashboardPage_Create_Graphical_Representation_Link_Title, null,
				Messages.GemocDashboardPage_Create_Graphical_Representation_Link_Tooltip,
				new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateAnimatorProjectWizardContextAction action = new CreateAnimatorProjectWizardContextAction(
								languageDefinition);
						action.actionToExecute = CreateAnimatorProjectAction.CREATE_NEW_SIRIUS_PROJECT;
						action.execute();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_GRAPHICAL_ANIMATOR),
				Messages.GemocDashboardPage_Select_Graphical_Representation_Link_Title, null,
				Messages.GemocDashboardPage_Select_Graphical_Representation_Link_Tooltip,
				new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectODesignIProjectDialog dialog = new SelectODesignIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_PLUG_ADD_ONS), Messages.GemocDashboardPage_Plug_Add_Ons_Link_Title,
				null, Messages.GemocDashboardPage_Plug_Add_Ons_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						// TODO Connect expected action
						System.out.println("TODO Plug your own add ons"); //$NON-NLS-1$
					}
				});
	}

	private void createDomainModelSection(final Composite sectionContainer) {
		List<IAction> toolbarActions = new ArrayList<IAction>();
		toolbarActions.add(new DescriptionAction("description/DomainModelDescription.xml", sectionContainer //$NON-NLS-1$
				.getShell()));
		DomainModelProject domainModelProject = languageDefinition.getDomainModelProject();
		toolbarActions.add(new FilterTreeAction(viewer, Collections.singletonList(domainModelProject),
				sectionContainer.getShell()));

		// Create the section.
		Couple<Section, Composite> section = FormHelper.createTwistieSectionWithToolbar(sectionContainer,
				mForm, Messages.GemocDashboardPage_Domain_Model_Section_Title, null, true, toolbarActions);

		// Get the section composite.
		Composite sectionComposite = section.getValue();
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_ABSTRACT_SYNTAX),
				Messages.GemocDashboardPage_Create_Abstract_Syntax_Link_Title, null,
				Messages.GemocDashboardPage_Create_Abstract_Syntax_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						// open the wizard to propose to create the project
						TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
								.createEditingDomain();
						editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
							public void doExecute() {
								CreateDomainModelWizardContextAction action = new CreateDomainModelWizardContextAction(
										languageDefinition);
								action.execute();
							}
						});
					}

				});
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_ABSTRACT_SYNTAX),
				Messages.GemocDashboardPage_Select_Abstract_Syntax_Link_Title, null,
				Messages.GemocDashboardPage_Select_Abstract_Syntax_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectEMFIProjectDialog dialog = new SelectEMFIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
	}

	private void createModelEditorSection(final Composite sectionContainer_p) {
		List<IAction> toolbarActions = new ArrayList<IAction>();
		toolbarActions.add(new DescriptionAction("description/ModelEditorDescription.xml", sectionContainer //$NON-NLS-1$
				.getShell()));
		toolbarActions.add(new FilterTreeAction(viewer, languageDefinition.getEditorProjects(),
				sectionContainer.getShell()));

		// Create the section.
		Couple<Section, Composite> section = FormHelper.createTwistieSectionWithToolbar(sectionContainer_p,
				mForm, Messages.GemocDashboardPage_Model_Editor_Section_Title, null, true, toolbarActions);

		// Get the section composite.
		Composite sectionComposite = section.getValue();
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_GRAPHICAL_EDITOR),
				Messages.GemocDashboardPage_Create_Graphical_Editor_Link_Title, null,
				Messages.GemocDashboardPage_Create_Graphical_Editor_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(
								languageDefinition);
						action.actionToExecute = CreateEditorProjectWizardContextAction.CreateEditorProjectAction.CREATE_NEW_SIRIUS_PROJECT;
						action.execute();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_GRAPHICAL_EDITOR),
				Messages.GemocDashboardPage_Select_Graphical_Editor_Link_Title, null,
				Messages.GemocDashboardPage_Select_Graphical_Editor_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectODesignIProjectDialog dialog = new SelectODesignIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_TEXTUAL_EDITOR),
				Messages.GemocDashboardPage_Create_Textual_Editor_Link_Title, null,
				Messages.GemocDashboardPage_Create_Textual_Editor_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(
								languageDefinition);
						action.actionToExecute = CreateEditorProjectAction.CREATE_NEW_XTEXT_PROJECT;
						action.execute();
					}
				});

		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_TEXTUAL_EDITOR),
				Messages.GemocDashboardPage_Select_Textual_Editor_Link_Title, null,
				Messages.GemocDashboardPage_Select_Textual_Editor_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectXtextIProjectDialog dialog = new SelectXtextIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
	}

	private void createSequentialExecutionSemanticsSection(final Composite sectionContainer) {
		List<IAction> toolbarActions = new ArrayList<IAction>();
		toolbarActions.add(new DescriptionAction("description/SequentialExecutionSemanticsDescription.xml", //$NON-NLS-1$
				sectionContainer.getShell()));
		toolbarActions.add(new FilterTreeAction(viewer, Collections.singletonList(languageDefinition
				.getDsaProject()), sectionContainer.getShell()));

		// Create the section.
		Couple<Section, Composite> section = FormHelper.createTwistieSectionWithToolbar(sectionContainer,
				mForm, Messages.GemocDashboardPage_Sequential_Execution_Section_Title, null, true,
				toolbarActions);

		// Get the section composite.
		Composite sectionComposite = section.getValue();
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_EXECUTION_SEMANTIC),
				Messages.GemocDashboardPage_Create_Execution_Semantics_Link_Title, null,
				Messages.GemocDashboardPage_Create_Execution_Semantics_Link_Tooltip,
				new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateDSAWizardContextActionDSAK3 action = new CreateDSAWizardContextActionDSAK3(
								((GemocDashboardEditorInput)getEditorInput()).getFile().getProject(),
								languageDefinition);
						action.createNewDSAProject();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_EXECUTION_SEMANTIC),
				Messages.GemocDashboardPage_Select_Execution_Semantics_Link_Title, null,
				Messages.GemocDashboardPage_Select_Execution_Semantics_Link_Tooltip,
				new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectDSAIProjectDialog dialog = new SelectDSAIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
	}

	private void createConcurrentExecutionSemanticsSection(final Composite sectionContainer_p) {
		List<IAction> toolbarActions = new ArrayList<IAction>();
		toolbarActions.add(new DescriptionAction("description/ConcurrentExecutionSemanticsDescription.xml", //$NON-NLS-1$
				sectionContainer.getShell()));
		List<ProjectResource> projects = new ArrayList<ProjectResource>();
		projects.add(languageDefinition.getDsaProject());
		projects.add(languageDefinition.getDSEProject());
		projects.add(languageDefinition.getMoCCProject());
		toolbarActions.add(new FilterTreeAction(viewer, projects, sectionContainer.getShell()));

		// Create the section.
		Couple<Section, Composite> section = FormHelper.createTwistieSectionWithToolbar(sectionContainer_p,
				mForm, Messages.GemocDashboardPage_Concurrent_Execution_Section_Title, null, true,
				toolbarActions);

		// Get the section composite.
		Composite sectionComposite = section.getValue();
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_DSA), Messages.GemocDashboardPage_Create_DSA_Link_Title, null,
				Messages.GemocDashboardPage_Create_DSA_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateDSAWizardContextActionDSAK3 action = new CreateDSAWizardContextActionDSAK3(
								((GemocDashboardEditorInput)getEditorInput()).getFile().getProject(),
								languageDefinition);
						action.createNewDSAProject();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_DSA), Messages.GemocDashboardPage_Select_DSA_Link_Title, null,
				Messages.GemocDashboardPage_Select_DSA_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectDSAIProjectDialog dialog = new SelectDSAIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_DSE), Messages.GemocDashboardPage_Create_DSE_Link_Title, null,
				Messages.GemocDashboardPage_Create_DSE_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateDSEWizardContextAction action = new CreateDSEWizardContextAction(
								((GemocDashboardEditorInput)getEditorInput()).getFile().getProject(),
								languageDefinition);
						action.actionToExecute = CreateDSEAction.CREATE_NEW_DSE_PROJECT;
						action.execute();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_DSE), Messages.GemocDashboardPage_Select_DSE_Link_Title, null,
				Messages.GemocDashboardPage_Select_DSE_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectPluginIProjectDialog dialog = new SelectDSEIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_MOCC), Messages.GemocDashboardPage_Create_MOCC_Link_Title, null,
				Messages.GemocDashboardPage_Create_MOCC_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						CreateMOCCWizardContextAction action = new CreateMOCCWizardContextAction(
								((GemocDashboardEditorInput)getEditorInput()).getFile().getProject(),
								languageDefinition);
						action.actionToExecute = CreateMOCCAction.CREATE_NEW_MOCC_PROJECT;
						action.execute();
					}
				});
		// Create link
		FormHelper.createLinkWithDescription(toolkit, sectionComposite, GemocDashboardActivator.getDefault()
				.getImage(IImageKeys.IMG_MOCC), Messages.GemocDashboardPage_Select_MOCC_Link_Title, null,
				Messages.GemocDashboardPage_Select_MOCC_Link_Tooltip, new IHyperlinkListener() {
					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}

					public void linkActivated(HyperlinkEvent e) {
						SelectPluginIProjectDialog dialog = new SelectMoCCIProjectDialog(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow().getShell());
						int res = dialog.open();
					}
				});
	}

	/**
	 * Create the container that hosts sections.<br>
	 * This one layouts its content using a {@link TableWrapLayout} to allow sections to have wrapped hyper
	 * controls.
	 * 
	 * @param parent_p
	 * @param form2
	 */
	protected Composite createSectionContainer(Composite parent_p) {
		Composite container = FormHelper.createCompositeWithLayoutType(toolkit, parent_p,
				LayoutType.TABLEWRAP_LAYOUT, 1, true);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		return container;
	}

	protected Composite createOverviewSectionContainer(Composite parent_p) {
		Composite container = FormHelper.createCompositeWithLayoutType(toolkit, parent_p,
				LayoutType.TABLEWRAP_LAYOUT, 3, true);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		return container;
	}

	/**
	 * Create viewer container that hosts the viewer.<br>
	 * This one layouts its content using a {@link GridLayout}.
	 * 
	 * @param parent_p
	 * @param managedForm_p
	 * @return
	 */
	protected Composite createViewerContainer(Composite parent_p) {
		return FormHelper.createCompositeWithLayoutType(toolkit, parent_p, LayoutType.GRID_LAYOUT, 1, true);
	}

	@Override
	public void setFocus() {
		form.setFocus();
	}

	@Override
	public void dispose() {
		toolkit.dispose();
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		super.dispose();
	}

	/**
	 * Create the viewer that displays diagrams.
	 * 
	 * @param viewerContainer_p
	 * @param managedForm_p
	 */
	protected Couple<TreeViewer, Section> createViewer(Composite viewerContainer_p, IManagedForm managedForm_p) {
		// Create the section.
		Couple<Section, Composite> section = FormHelper.createSectionWithDescription(managedForm_p
				.getToolkit(), viewerContainer_p, getEditorInput().getName()
				+ Messages.GemocDashboardPage_Project_Treeviewer_Title, null);
		FormHelper.createSectionToolbar(section.getKey(), new ArrayList<IAction>());
		section.getKey().setLayoutData(new GridData(GridData.FILL_BOTH));

		// Get the tree viewer.
		final TreeViewer treeViewer = new TreeViewer(section.getValue());

		// Add double click listener to open double-clicked diagrams.
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			/**
			 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
			 */
			public void doubleClick(DoubleClickEvent event_p) {
				IStructuredSelection selection = (IStructuredSelection)event_p.getSelection();

				ProjectResource projectResource = (ProjectResource)selection.getFirstElement();

				// open the relevant files of the project
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
						projectResource.getProjectName());
				if (project.exists()) {
					// open the editor on one of the files
					String fileExtension = project.getFileExtension();

					if (projectResource instanceof DomainModelProject) {
						fileExtension = "ecore"; //$NON-NLS-1$
					} else if (projectResource instanceof XTextEditorProject) {
						fileExtension = "xtext"; //$NON-NLS-1$
					} else if (projectResource instanceof SiriusEditorProject) {
						fileExtension = "odesign"; //$NON-NLS-1$
					} else if (projectResource instanceof SiriusEditorProject
							|| projectResource instanceof SiriusAnimatorProject) {
						fileExtension = "odesign"; //$NON-NLS-1$
					} else if (projectResource instanceof DSAProject) {
						fileExtension = "xtend"; //$NON-NLS-1$
					} else if (projectResource instanceof DSEProject) {
						fileExtension = "ecl"; //$NON-NLS-1$
					} else if (projectResource instanceof MoCCProject) {
						fileExtension = "ccslLib"; //$NON-NLS-1$
					}

					OpenEditor.openPossibleFileWithExtensionInProject(project, fileExtension);
					return;
				}
			}
		});

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new confItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		// Set content provider.
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			private Object input;

			@Override
			public Object[] getElements(Object object) {
				if (object instanceof List) {
					List elements = (List)object;
					return elements.toArray();
				}
				return super.getElements(object);
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				this.input = newInput;
				super.inputChanged(viewer, oldInput, newInput);
			}

			@Override
			public Object[] getChildren(Object object) {
				return super.getChildren(object);
			}
		});
		// Set label provider.
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		// Set the initial input. Also make sure to refresh the viewer if underlying
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createPlatformResourceURI(
				((GemocDashboardEditorInput)getEditorInput()).getFile().getFullPath().toOSString(), false),
				true);
		languageDefinition = (LanguageDefinition)resource.getContents().get(0);
		treeViewer.setInput(languageDefinition);

		// Forward selection changes to the editor site selection provider to notify the platform (e.g
		// property view).
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			/**
			 * {@inheritDoc}
			 */
			public void selectionChanged(SelectionChangedEvent event_p) {
				getSite().getSelectionProvider().setSelection(event_p.getSelection());
			}
		});
		// Make a context menu for the tree viewer.
		return new Couple<TreeViewer, Section>(treeViewer, section.getKey());
	}

	private void refreshForm(final String overview) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				currentOverview = overview;
				overviewSectionContainer.dispose();
				sashForm.dispose();
				createOverviewSection(form.getBody(), overview);
				createSashForm(form.getBody(), overview);
				form.getParent().update();
			}
		});

	}
}
