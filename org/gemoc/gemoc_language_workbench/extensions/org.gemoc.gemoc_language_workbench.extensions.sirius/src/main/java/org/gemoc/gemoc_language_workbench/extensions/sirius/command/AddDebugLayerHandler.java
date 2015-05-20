package org.gemoc.gemoc_language_workbench.extensions.sirius.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.diagram.description.AdditionalLayer;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.DiagramExtensionDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.MappingBasedDecoration;
import org.eclipse.sirius.diagram.description.tool.ToolSection;
import org.eclipse.sirius.viewpoint.description.Customization;
import org.eclipse.sirius.viewpoint.description.DecorationDescriptionsSet;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.EReferenceCustomization;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.JavaExtension;
import org.eclipse.sirius.viewpoint.description.Position;
import org.eclipse.sirius.viewpoint.description.UserColor;
import org.eclipse.sirius.viewpoint.description.UserColorsPalette;
import org.eclipse.sirius.viewpoint.description.UserFixedColor;
import org.eclipse.sirius.viewpoint.description.VSMElementCustomization;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.description.tool.ExternalJavaAction;
import org.eclipse.sirius.viewpoint.description.tool.InitialOperation;
import org.eclipse.sirius.viewpoint.description.tool.OperationAction;
import org.eclipse.sirius.viewpoint.description.tool.PopupMenu;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddDebugLayerHandler extends AbstractHandler {

	private static final String DEBUG_SERVICE_TEMPLATE_PATH = "org/gemoc/gemoc_language_workbench/extensions/sirius/command/debug_services_template.txt";

	private static final String PACKAGE_TAG = "PACKAGE";

	private static final String CLASS_NAME_TAG = "CLASS_NAME";

	private static final String LANGUAGE_NAME_TAG = "LANGUAGE_NAME";

	private static final String LAYER_NAME_TAG = "LAYER_NAME";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IProgressMonitor monitor = new NullProgressMonitor();
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage().getSelection();
		try {
			if (selection != null & selection instanceof IStructuredSelection) {
				final String layerName = "Debug";
				final DiagramDescription diagramDescription = (DiagramDescription) ((IStructuredSelection) selection)
						.getFirstElement();
				final IEditorInput input = HandlerUtil
						.getActiveEditorInputChecked(event);
				final IFile descriptionFile = (IFile) input
						.getAdapter(IFile.class);
				final IProject project = descriptionFile.getProject();
				final String projectName = project.getName();
				final IFolder serviceFolder = project.getFolder(new Path("src/"
						+ projectName.replaceAll("\\.", "/").toLowerCase() + "/services"));
				final String languageName = diagramDescription.getName();
				final String qualifiedServiceClassName = getOrCreateServiceClass(
						serviceFolder, projectName, languageName, layerName,
						monitor);

				EditingDomain editingDomain = ((IEditingDomainProvider) diagramDescription
						.eResource().getResourceSet()).getEditingDomain();
				editingDomain.getCommandStack().execute(
						new ChangeCommand(diagramDescription.eResource()) {

							@Override
							protected void doExecute() {
								emfModifications(monitor, layerName,
										diagramDescription, languageName,
										qualifiedServiceClassName);
							}
						});
			}
		} catch (IOException e) {
			throw new ExecutionException(
					"Error while creating the debug layer", e);
		} catch (CoreException e) {
			throw new ExecutionException(
					"Error while creating the debug layer", e);
		}
		return null;
	}

	public static void emfModifications(final IProgressMonitor monitor,
			final String layerName, final DiagramDescription description,
			final String languageName, final String qualifiedServiceClassName) {
		getOrCreateImport(description,
				qualifiedServiceClassName, monitor);
		final UserColorsPalette palette = getOrCreateColotPalette(description,
				languageName, monitor);
		final UserColor instructionColor = getOrCtreateInstructionColor(
				palette, monitor);
		getOrCreateDebugLayer(description,
				instructionColor, layerName, monitor);
	}

	public static void emfModifications(final IProgressMonitor monitor,
			final String layerName, final DiagramExtensionDescription descriptionExtension,
			final String languageName, final String qualifiedServiceClassName) {
		getOrCreateImport(descriptionExtension,
				qualifiedServiceClassName, monitor);
		final UserColorsPalette palette = getOrCreateColotPalette(descriptionExtension,
				languageName, monitor);
		final UserColor instructionColor = getOrCtreateInstructionColor(
				palette, monitor);
		getOrCreateDebugLayer(descriptionExtension,
				instructionColor, layerName, monitor);
	}

	/**
	 * Creates the given {@link IFolder} and its parents.
	 * 
	 * @param folder
	 *            the {@link IFolder} to create
	 * @param monitor
	 *            the {@link IProgressMonitor}
	 * @throws CoreException
	 *             if the folder creation fails
	 */
	public static void createFolder(IFolder folder, IProgressMonitor monitor)
			throws CoreException {
		if (!folder.getParent().exists()) {
			createFolder((IFolder) folder.getParent(), monitor);
		}
		folder.create(true, true, monitor);
	}

	public static Layer getOrCreateDebugLayer(
			DiagramDescription description, UserColor instructionColor,
			String layerName, IProgressMonitor monitor) {
		final Layer res;

		Layer existingLayer = null;
		for (Layer layer : description.getAdditionalLayers()) {
			if ("Debug".equals(layer.getName())) {
				existingLayer = layer;
				break;
			}
		}

		if (existingLayer != null) {
			res = existingLayer;
		} else {
			res = createLayer(description, instructionColor, layerName, monitor);
		}

		return res;
	}

	public static Layer getOrCreateDebugLayer(
			DiagramExtensionDescription descriptionExtension, UserColor instructionColor,
			String layerName, IProgressMonitor monitor) {
		final Layer res;

		Layer existingLayer = null;
		for (Layer layer : descriptionExtension.getLayers()) {
			if ("Debug".equals(layer.getName())) {
				existingLayer = layer;
				break;
			}
		}

		if (existingLayer != null) {
			res = existingLayer;
		} else {
			res = createLayer(descriptionExtension, instructionColor, layerName, monitor);
		}

		return res;
	}

	public static Layer createLayer(DiagramDescription description,
			UserColor instructionColor, String layerName,
			IProgressMonitor monitor) {
		final AdditionalLayer res = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createAdditionalLayer();
		res.setName("Debug");
		res.setActiveByDefault(true);

		ToolSection toolSection = org.eclipse.sirius.diagram.description.tool.ToolPackage.eINSTANCE
				.getToolFactory().createToolSection();
		toolSection.setName("Debug");
		res.getToolSections().add(toolSection);
		PopupMenu popupMenu = ToolPackage.eINSTANCE.getToolFactory()
				.createPopupMenu();
		popupMenu.setName("Gemoc");
		toolSection.getOwnedTools().add(popupMenu);
		// Debug action
		OperationAction debugAction = ToolPackage.eINSTANCE.getToolFactory()
				.createOperationAction();
		debugAction.setName("Debug");
		debugAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/debug_exc.gif");
		popupMenu.getMenuItemDescription().add(debugAction);
		ExternalJavaAction debugJavaAction = ToolPackage.eINSTANCE
				.getToolFactory().createExternalJavaAction();
		debugJavaAction.setName("Debug");
		debugJavaAction
				.setId("org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action.gemocDebugAs");
		debugJavaAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/debug_exc.gif");
		InitialOperation initialOperation = ToolPackage.eINSTANCE
				.getToolFactory().createInitialOperation();
		initialOperation.setFirstModelOperations(debugJavaAction);
		debugAction.setInitialOperation(initialOperation);
		// Toggle breakpoint action
		OperationAction toogleBreakpointAction = ToolPackage.eINSTANCE
				.getToolFactory().createOperationAction();
		toogleBreakpointAction.setName("Toggle breakpoint");
		toogleBreakpointAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/debug_exc.gif");
		popupMenu.getMenuItemDescription().add(toogleBreakpointAction);
		ExternalJavaAction toogleBreakpointJavaAction = ToolPackage.eINSTANCE
				.getToolFactory().createExternalJavaAction();
		toogleBreakpointJavaAction.setName("Toggle Gemoc breakpoint");
		toogleBreakpointJavaAction
				.setId("org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action.gemocToggleBreakpoint");
		toogleBreakpointJavaAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/breakpoint.gif");
		initialOperation = ToolPackage.eINSTANCE.getToolFactory()
				.createInitialOperation();
		initialOperation.setFirstModelOperations(toogleBreakpointJavaAction);
		toogleBreakpointAction.setInitialOperation(initialOperation);

		DecorationDescriptionsSet decorationSet = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createDecorationDescriptionsSet();
		res.setDecorationDescriptionsSet(decorationSet);

		List<DiagramElementMapping> mappings = getAllMapping(description);
		// enabled breakpoint decorator
		MappingBasedDecoration enabledBreakpoint = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createMappingBasedDecoration();
		enabledBreakpoint.setName("Enabled breakpoint");
		enabledBreakpoint.setPosition(Position.WEST_LITERAL);
		enabledBreakpoint
				.setDecoratorPath("/org.gemoc.gemoc_modeling_workbench.ui/icons/breakpoint_enabled.gif");
		enabledBreakpoint
				.setPreconditionExpression("service:self.hasEnabledBreakpoint");
		enabledBreakpoint.getMappings().addAll(mappings);
		decorationSet.getDecorationDescriptions().add(enabledBreakpoint);
		// enabled breakpoint decorator
		MappingBasedDecoration disabledBreakpoint = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createMappingBasedDecoration();
		disabledBreakpoint.setName("Disabled breakpoint");
		disabledBreakpoint.setPosition(Position.WEST_LITERAL);
		disabledBreakpoint
				.setDecoratorPath("/org.gemoc.gemoc_modeling_workbench.ui/icons/breakpoint_disabled.gif");
		disabledBreakpoint
				.setPreconditionExpression("service:self.hasDisabledBreakpoint");
		disabledBreakpoint.getMappings().addAll(mappings);
		decorationSet.getDecorationDescriptions().add(disabledBreakpoint);

		Customization customization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createCustomization();
		res.setCustomization(customization);
		VSMElementCustomization elementCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createVSMElementCustomization();
		elementCustomization
				.setPredicateExpression("service:self.isCurrentInstruction");
		customization.getVsmElementCustomizations().add(elementCustomization);
		EReferenceCustomization borderColorCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createEReferenceCustomization();
		borderColorCustomization.setApplyOnAll(true);
		borderColorCustomization.setReferenceName("borderColor");
		borderColorCustomization.setValue(instructionColor);
		elementCustomization.getFeatureCustomizations().add(
				borderColorCustomization);

		EReferenceCustomization strokeColorCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createEReferenceCustomization();
		strokeColorCustomization.setApplyOnAll(true);
		strokeColorCustomization.setReferenceName("strokeColor");
		strokeColorCustomization.setValue(instructionColor);
		elementCustomization.getFeatureCustomizations().add(
				strokeColorCustomization);

		EReferenceCustomization labelColorCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createEReferenceCustomization();
		labelColorCustomization.setApplyOnAll(true);
		labelColorCustomization.setReferenceName("labelColor");
		labelColorCustomization.setValue(instructionColor);
		elementCustomization.getFeatureCustomizations().add(
				labelColorCustomization);

		description.getAdditionalLayers().add(res);

		return res;
	}

	public static Layer createLayer(DiagramExtensionDescription descriptionExtension,
			UserColor instructionColor, String layerName,
			IProgressMonitor monitor) {
		final AdditionalLayer res = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createAdditionalLayer();
		res.setName("Debug");
		res.setActiveByDefault(true);

		ToolSection toolSection = org.eclipse.sirius.diagram.description.tool.ToolPackage.eINSTANCE
				.getToolFactory().createToolSection();
		toolSection.setName("Debug");
		res.getToolSections().add(toolSection);
		PopupMenu popupMenu = ToolPackage.eINSTANCE.getToolFactory()
				.createPopupMenu();
		popupMenu.setName("Gemoc");
		toolSection.getOwnedTools().add(popupMenu);
		// Debug action
		OperationAction debugAction = ToolPackage.eINSTANCE.getToolFactory()
				.createOperationAction();
		debugAction.setName("Debug");
		debugAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/debug_exc.gif");
		popupMenu.getMenuItemDescription().add(debugAction);
		ExternalJavaAction debugJavaAction = ToolPackage.eINSTANCE
				.getToolFactory().createExternalJavaAction();
		debugJavaAction.setName("Debug");
		debugJavaAction
				.setId("org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action.gemocDebugAs");
		debugJavaAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/debug_exc.gif");
		InitialOperation initialOperation = ToolPackage.eINSTANCE
				.getToolFactory().createInitialOperation();
		initialOperation.setFirstModelOperations(debugJavaAction);
		debugAction.setInitialOperation(initialOperation);
		// Toggle breakpoint action
		OperationAction toogleBreakpointAction = ToolPackage.eINSTANCE
				.getToolFactory().createOperationAction();
		toogleBreakpointAction.setName("Toggle breakpoint");
		toogleBreakpointAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/debug_exc.gif");
		popupMenu.getMenuItemDescription().add(toogleBreakpointAction);
		ExternalJavaAction toogleBreakpointJavaAction = ToolPackage.eINSTANCE
				.getToolFactory().createExternalJavaAction();
		toogleBreakpointJavaAction.setName("Toggle Gemoc breakpoint");
		toogleBreakpointJavaAction
				.setId("org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action.gemocToggleBreakpoint");
		toogleBreakpointJavaAction
				.setIcon("/org.gemoc.gemoc_modeling_workbench.ui/icons/breakpoint.gif");
		initialOperation = ToolPackage.eINSTANCE.getToolFactory()
				.createInitialOperation();
		initialOperation.setFirstModelOperations(toogleBreakpointJavaAction);
		toogleBreakpointAction.setInitialOperation(initialOperation);

		DecorationDescriptionsSet decorationSet = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createDecorationDescriptionsSet();
		res.setDecorationDescriptionsSet(decorationSet);

		List<DiagramElementMapping> mappings = getAllMapping(descriptionExtension);
		// enabled breakpoint decorator
		MappingBasedDecoration enabledBreakpoint = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createMappingBasedDecoration();
		enabledBreakpoint.setName("Enabled breakpoint");
		enabledBreakpoint.setPosition(Position.WEST_LITERAL);
		enabledBreakpoint
				.setDecoratorPath("/org.gemoc.gemoc_modeling_workbench.ui/icons/breakpoint_enabled.gif");
		enabledBreakpoint
				.setPreconditionExpression("service:self.hasEnabledBreakpoint");
		enabledBreakpoint.getMappings().addAll(mappings);
		decorationSet.getDecorationDescriptions().add(enabledBreakpoint);
		// enabled breakpoint decorator
		MappingBasedDecoration disabledBreakpoint = org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createMappingBasedDecoration();
		disabledBreakpoint.setName("Disabled breakpoint");
		disabledBreakpoint.setPosition(Position.WEST_LITERAL);
		disabledBreakpoint
				.setDecoratorPath("/org.gemoc.gemoc_modeling_workbench.ui/icons/breakpoint_disabled.gif");
		disabledBreakpoint
				.setPreconditionExpression("service:self.hasDisabledBreakpoint");
		disabledBreakpoint.getMappings().addAll(mappings);
		decorationSet.getDecorationDescriptions().add(disabledBreakpoint);

		Customization customization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createCustomization();
		res.setCustomization(customization);
		VSMElementCustomization elementCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createVSMElementCustomization();
		elementCustomization
				.setPredicateExpression("service:self.isCurrentInstruction");
		customization.getVsmElementCustomizations().add(elementCustomization);
		EReferenceCustomization borderColorCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createEReferenceCustomization();
		borderColorCustomization.setApplyOnAll(true);
		borderColorCustomization.setReferenceName("borderColor");
		borderColorCustomization.setValue(instructionColor);
		elementCustomization.getFeatureCustomizations().add(
				borderColorCustomization);

		EReferenceCustomization strokeColorCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createEReferenceCustomization();
		strokeColorCustomization.setApplyOnAll(true);
		strokeColorCustomization.setReferenceName("strokeColor");
		strokeColorCustomization.setValue(instructionColor);
		elementCustomization.getFeatureCustomizations().add(
				strokeColorCustomization);

		EReferenceCustomization labelColorCustomization = DescriptionPackage.eINSTANCE
				.getDescriptionFactory().createEReferenceCustomization();
		labelColorCustomization.setApplyOnAll(true);
		labelColorCustomization.setReferenceName("labelColor");
		labelColorCustomization.setValue(instructionColor);
		elementCustomization.getFeatureCustomizations().add(
				labelColorCustomization);

		descriptionExtension.getLayers().add(res);

		return res;
	}

	/**
	 * Gets all {@link DiagramElementMapping} contained in the given
	 * {@link DiagramDescription}.
	 * 
	 * @param description
	 *            the {@link DiagramDescription}
	 * @return all {@link DiagramElementMapping} contained in the given
	 *         {@link DiagramDescription}
	 */
	public static List<DiagramElementMapping> getAllMapping(
			DiagramDescription description) {
		final List<DiagramElementMapping> res = new ArrayList<DiagramElementMapping>();

		TreeIterator<EObject> it = description.eAllContents();
		while (it.hasNext()) {
			EObject eObj = it.next();
			if (eObj instanceof DiagramElementMapping) {
				res.add((DiagramElementMapping) eObj);
			}
		}

		return res;
	}

	/**
	 * Gets all {@link DiagramElementMapping} contained in the given
	 * {@link DiagramDescription}.
	 * 
	 * @param descriptionExtension
	 *            the {@link DiagramExtensionDescription}
	 * @return all {@link DiagramElementMapping} contained in the given
	 *         {@link DiagramExtensionDescription}
	 */
	public static List<DiagramElementMapping> getAllMapping(
			DiagramExtensionDescription descriptionExtension) {
		final List<DiagramElementMapping> res = new ArrayList<DiagramElementMapping>();

		TreeIterator<EObject> it = descriptionExtension.eAllContents();
		while (it.hasNext()) {
			EObject eObj = it.next();
			if (eObj instanceof DiagramElementMapping) {
				res.add((DiagramElementMapping) eObj);
			}
		}

		return res;
	}

	public static UserColor getOrCtreateInstructionColor(UserColorsPalette palette,
			IProgressMonitor monitor) {
		final UserColor res;

		UserColor existingColor = null;

		for (UserColor color : palette.getEntries()) {
			if ("current instruction".equals(color.getName())) {
				existingColor = color;
				break;
			}
		}

		if (existingColor != null) {
			res = existingColor;
		} else {
			UserFixedColor fixedColor = DescriptionPackage.eINSTANCE
					.getDescriptionFactory().createUserFixedColor();
			fixedColor.setName("current instruction");
			fixedColor.setRed(255);
			fixedColor.setGreen(255);
			fixedColor.setBlue(0);
			palette.getEntries().add(fixedColor);
			res = fixedColor;
		}

		return res;
	}

	public static UserColorsPalette getOrCreateColotPalette(
			DiagramDescription description, String languageName,
			IProgressMonitor monitor) {
		final UserColorsPalette res;
		final String paletteName = languageName + " Palette";

		final Group group = (Group) description.eContainer().eContainer();
		UserColorsPalette existingPalette = null;
		for (UserColorsPalette palette : group.getUserColorsPalettes()) {
			if (paletteName.equals(palette.getName())) {
				existingPalette = palette;
				break;
			}
		}

		if (existingPalette != null) {
			res = existingPalette;
		} else {
			res = DescriptionPackage.eINSTANCE.getDescriptionFactory()
					.createUserColorsPalette();

			res.setName(paletteName);
			group.getUserColorsPalettes().add(res);
		}

		return res;
	}


	public static UserColorsPalette getOrCreateColotPalette(
			DiagramExtensionDescription descriptionExtension, String languageName,
			IProgressMonitor monitor) {
		final UserColorsPalette res;
		final String paletteName = languageName + " Palette";

		final Group group = (Group) descriptionExtension.eContainer().eContainer();
		UserColorsPalette existingPalette = null;
		for (UserColorsPalette palette : group.getUserColorsPalettes()) {
			if (paletteName.equals(palette.getName())) {
				existingPalette = palette;
				break;
			}
		}

		if (existingPalette != null) {
			res = existingPalette;
		} else {
			res = DescriptionPackage.eINSTANCE.getDescriptionFactory()
					.createUserColorsPalette();

			res.setName(paletteName);
			group.getUserColorsPalettes().add(res);
		}

		return res;
	}

	/**
	 * Gets or creates a {@link JavaExtension} for the given qualified class
	 * name in the given {@link DiagramDescription}.
	 * 
	 * @param description
	 *            the {@link DiagramDescription}
	 * @param qualifiedClassName
	 *            the qualified class name
	 * @param monitor
	 *            the {@link IProgressMonitor}
	 * @return the {@link JavaExtension}
	 */
	public static JavaExtension getOrCreateImport(DiagramDescription description,
			String qualifiedClassName, IProgressMonitor monitor) {
		final JavaExtension res;

		final Viewpoint viewPoint = (Viewpoint) description.eContainer();
		JavaExtension existingExtension = null;
		for (JavaExtension javaExt : viewPoint.getOwnedJavaExtensions()) {
			if (qualifiedClassName.equals(javaExt.getQualifiedClassName())) {
				existingExtension = javaExt;
				break;
			}
		}

		if (existingExtension != null) {
			res = existingExtension;
		} else {
			res = DescriptionPackage.eINSTANCE.getDescriptionFactory()
					.createJavaExtension();

			res.setQualifiedClassName(qualifiedClassName);
			viewPoint.getOwnedJavaExtensions().add(res);
		}

		return res;
	}

	/**
	 * Gets or creates a {@link JavaExtension} for the given qualified class
	 * name in the given {@link DiagramDescription}.
	 * 
	 * @param description
	 *            the {@link DiagramDescription}
	 * @param qualifiedClassName
	 *            the qualified class name
	 * @param monitor
	 *            the {@link IProgressMonitor}
	 * @return the {@link JavaExtension}
	 */
	public static JavaExtension getOrCreateImport(DiagramExtensionDescription descriptionExtension,
			String qualifiedClassName, IProgressMonitor monitor) {
		final JavaExtension res;

		final Viewpoint viewPoint = (Viewpoint) descriptionExtension.eContainer();
		JavaExtension existingExtension = null;
		for (JavaExtension javaExt : viewPoint.getOwnedJavaExtensions()) {
			if (qualifiedClassName.equals(javaExt.getQualifiedClassName())) {
				existingExtension = javaExt;
				break;
			}
		}

		if (existingExtension != null) {
			res = existingExtension;
		} else {
			res = DescriptionPackage.eINSTANCE.getDescriptionFactory()
					.createJavaExtension();

			res.setQualifiedClassName(qualifiedClassName);
			viewPoint.getOwnedJavaExtensions().add(res);
		}

		return res;
	}

	/**
	 * Gets or creates the debug service class.
	 * 
	 * @param serviceFolder
	 *            the containing {@link IFolder}
	 * @param projectName
	 *            the project name
	 * @param languageName
	 *            the language name
	 * @param layerName
	 *            the debug layer name
	 * @param monitor
	 *            the {@link IProgressMonitor}
	 * @return the debug service class qualified name
	 * @throws IOException
	 * @throws CoreException
	 */
	public static String getOrCreateServiceClass(IFolder serviceFolder,
			String projectName, String languageName, String layerName,
			IProgressMonitor monitor) throws IOException, CoreException {
		final String className = toCamelCase(languageName) + "DebugServices";
		final IFile classFile = serviceFolder.getFile(new Path(className
				+ ".java"));
		final String packageName = projectName + ".services";
		final String res = packageName + "." + className;

		if (!classFile.exists()) {
			if (!serviceFolder.exists()) {
				AddDebugLayerHandler.createFolder(serviceFolder,
						monitor);
			}
			createServiceClass(classFile, packageName, className, languageName,
					layerName, monitor);
		} else {
			addStringCoupleIfNeeded(classFile, languageName, layerName, monitor);
		}

		return res;
	}

	public static void addStringCoupleIfNeeded(IFile classFile, String languageName,
			String layerName, IProgressMonitor monitor) throws IOException,
			CoreException {
		String content = getContent(classFile.getContents(), "UTF8");
		final String statement = "res.add(new StringCouple(\"" + languageName
				+ "\", \"" + layerName + "\"));";
		if (!content.contains(statement)) {
			int index = content.lastIndexOf("res.add(new StringCouple(");
			if (index >= 0) {
				index = index + "res.add(new StringCouple(".length();
				while (content.charAt(index) != ';') {
					++index;
				}
				String newContent = content.substring(0, index) + "\n\t\t"
						+ statement + "\n"
						+ content.substring(index, content.length());
				setContent(classFile.getFullPath().toFile(), "UTF8", newContent);
				classFile.refreshLocal(1, monitor);
			} else {
				// TODO notify : add statement manually
			}
		}
	}

	public static void createServiceClass(IFile classFile, String packageName,
			String className, String languageName, String layerName,
			IProgressMonitor monitor) throws IOException, CoreException {

		String content = getContent(AddDebugLayerHandler.class.getClassLoader()
				.getResourceAsStream(DEBUG_SERVICE_TEMPLATE_PATH), "UTF8");

		content = content.replaceFirst(PACKAGE_TAG, packageName);
		content = content.replaceFirst(CLASS_NAME_TAG, className);
		content = content.replaceFirst(LANGUAGE_NAME_TAG, languageName);
		content = content.replaceFirst(LAYER_NAME_TAG, layerName);

		classFile.create(
				new ByteArrayInputStream(content.getBytes(Charset
						.forName("UTF8"))), true, monitor);
	}

	public static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			camelCaseString = camelCaseString
					+ part.substring(0, 1).toUpperCase()
					+ part.substring(1).toLowerCase();
		}
		return camelCaseString;
	}

	/**
	 * Gets the content of the given {@link InputStream}.
	 * 
	 * @param inputStream
	 *            the {@link InputStream}
	 * @param charsetName
	 *            The name of a supported {@link java.nio.charset.Charset
	 *            </code>charset<code>}
	 * @return a {@link String} of the content of the given {@link InputStream}
	 */
	public static String getContent(InputStream inputStream, String charsetName)
			throws IOException {
		int len = 1024;
		StringBuilder res = new StringBuilder(len);
		if (len != 0) {
			InputStreamReader input = new InputStreamReader(
					new BufferedInputStream(inputStream), charsetName);
			char[] buffer = new char[len];
			int length = input.read(buffer);
			while (length != -1) {
				res.append(buffer, 0, length);
				length = input.read(buffer);
			}
			input.close();
		}
		return res.toString();
	}

	/**
	 * Write the given content to the given {@link File}.
	 * 
	 * @param file
	 *            the {@link File} to write
	 * @param charsetName
	 *            The name of a supported {@link java.nio.charset.Charset
	 *            </code>charset<code>}
	 * @param content
	 *            the content to write
	 * @throws IOException
	 *             if the {@link File} can't be written
	 */
	public static void setContent(File file, String charsetName, String content)
			throws IOException {
		if (!file.exists()) {
			throw new IOException(file.getAbsolutePath() + " doesn't exists.");
		} else if (file.isDirectory()) {
			throw new IOException(file.getAbsolutePath() + " is a directory.");
		} else if (!file.canWrite()) {
			throw new IOException(file.getAbsolutePath() + " is not writable.");
		}

		OutputStreamWriter output = new OutputStreamWriter(
				new BufferedOutputStream(new FileOutputStream(file)),
				charsetName);
		output.write(content.toString());
		output.close();
	}

}
