package fr.obeo.dsl.sirius.animationtemplate;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import fr.obeo.dsl.viewpoint.description.tool.ChangeContext;
import fr.obeo.dsl.viewpoint.description.tool.ContainerViewVariable;
import fr.obeo.dsl.viewpoint.description.tool.CreateInstance;
import fr.obeo.dsl.viewpoint.description.tool.EditMaskVariables;
import fr.obeo.dsl.viewpoint.description.tool.ElementDropVariable;
import fr.obeo.dsl.viewpoint.description.tool.InitialOperation;
import fr.obeo.dsl.viewpoint.description.tool.MenuItemDescriptionReference;
import fr.obeo.dsl.viewpoint.description.tool.OperationAction;
import fr.obeo.dsl.viewpoint.description.tool.SetValue;
import fr.obeo.dsl.viewpoint.description.tool.ToolFactory;
import fr.obeo.dsl.viewpoint.tree.description.DescriptionFactory;
import fr.obeo.dsl.viewpoint.tree.description.TreeDescription;
import fr.obeo.dsl.viewpoint.tree.description.TreeItemEditionTool;
import fr.obeo.dsl.viewpoint.tree.description.TreeItemMapping;
import fr.obeo.dsl.viewpoint.tree.description.TreeItemMappingContainer;
import fr.obeo.dsl.viewpoint.tree.description.TreeItemStyleDescription;
import fr.obeo.dsl.viewpoint.tree.description.TreePopupMenu;

class TreeDescriptionBuilderFromEClass {

	private Multimap<EClass, TreeItemMapping> doneClasses;

	private Multimap<EClass, OperationAction> doneItems;

	private EClass rootEClass;

	private TreeDescription treeDesc;

	private EClassHierarchy hiearchy;

	public TreeDescriptionBuilderFromEClass(TreeDescription treeDesc,
			EClass eClassToStartFrom,ResourceSet set) {
		this.rootEClass = eClassToStartFrom;
		this.treeDesc = treeDesc;
		/*
		 * handling subclassing
		 */

		hiearchy = new EClassHierarchy(set);
	}

	public void fillContent() {
		doneClasses = HashMultimap.create();
		doneItems = HashMultimap.create();
		buildMappingRecursively(treeDesc, rootEClass, "<%self%>");
	}

	private TreeItemMapping buildMappingRecursively(
			TreeItemMappingContainer container, EClass eClassToStartFrom,
			String semanticCandidateExpression2) {

		TreeItemMapping map = DescriptionFactory.eINSTANCE
				.createTreeItemMapping();
		map.setDomainClass(qualifiedName(eClassToStartFrom));
		map.setName(eClassToStartFrom.getName());
		map.setSemanticCandidatesExpression(semanticCandidateExpression2);
		map.setSemanticElements("<%self%>");
		TreeItemStyleDescription style = DescriptionFactory.eINSTANCE
				.createTreeItemStyleDescription();
		map.setDefaultStyle(style);
		if (lookForEditableName(eClassToStartFrom).isPresent()) {
			style.setLabelExpression("<%name%>");
		} else {
			style.setLabelExpression("<%eClass.name%>");
		}
		style.setLabelSize(10);

		Optional<EAttribute> editableName = lookForEditableName(eClassToStartFrom);
		if (editableName.isPresent()) {
			EAttribute editableFeature = editableName.get();
			TreeItemEditionTool editTool = DescriptionFactory.eINSTANCE
					.createTreeItemEditionTool();
			editTool.setName(editableFeature.getName());
			EditMaskVariables maskVar = ToolFactory.eINSTANCE
					.createEditMaskVariables();
			maskVar.setMask("{0}");
			editTool.setMask(maskVar);

			SetValue setVal = ToolFactory.eINSTANCE.createSetValue();
			setVal.setFeatureName(editableFeature.getName());
			setVal.setValueExpression("<%$0%>");

			ElementDropVariable elementVar = ToolFactory.eINSTANCE
					.createElementDropVariable();
			elementVar.setName("element");
			editTool.setElement(elementVar);

			ElementDropVariable rootVar = ToolFactory.eINSTANCE
					.createElementDropVariable();
			elementVar.setName("root");
			editTool.setRoot(rootVar);
			editTool.setFirstModelOperation(setVal);
			map.setDirectEdit(editTool);
		}

		doneClasses.put(eClassToStartFrom, map);
		container.getSubItemMappings().add(map);
		/*
		 * Popup menu for childs.
		 */
		TreePopupMenu menu = DescriptionFactory.eINSTANCE.createTreePopupMenu();
		menu.setName("New...");

		for (EReference ownedReferences : Iterables.filter(
				eClassToStartFrom.getEAllReferences(),
				new Predicate<EReference>() {

					public boolean apply(EReference input) {
						return input.isContainment()
								&& input.getEType() instanceof EClass;
					}
				})) {
			EClass targetClass = (EClass) ownedReferences.getEType();

			Collection<EClass> concreteSubclasses = Lists.newArrayList(hiearchy
					.getConcreteSubclassesLeafs(targetClass));

			if (concreteSubclasses.size() > 0) {
				map.getPopupMenus().add(menu);
			}
			for (EClass leaf : concreteSubclasses) {
				String semanticCandidateExpression = "<%"
						+ ownedReferences.getName() + "%>";
				TreeItemMapping childMap = getAlreadyExistingMapping(leaf,
						semanticCandidateExpression);
				if (childMap == null) {
					childMap = buildMappingRecursively(map, leaf,
							semanticCandidateExpression);
				} else {
					map.getReusedTreeItemMappings().add(childMap);
				}

				Optional<OperationAction> createChild = getAlreadyExistingMenuItem(
						leaf, ownedReferences.getName());
				if (createChild.isPresent()) {
					MenuItemDescriptionReference ref = ToolFactory.eINSTANCE
							.createMenuItemDescriptionReference();
					ref.setItem(createChild.get());
					menu.getMenuItemDescriptions().add(ref);
				} else {
					OperationAction newMenuItem = ToolFactory.eINSTANCE
							.createOperationAction();
					newMenuItem.setName(leaf.getName());

					ContainerViewVariable var = ToolFactory.eINSTANCE
							.createContainerViewVariable();
					var.setName("view");
					newMenuItem.setView(var);

					ChangeContext goToElement = ToolFactory.eINSTANCE
							.createChangeContext();
					goToElement.setBrowseExpression("<%self.target%>");

					CreateInstance newChild = ToolFactory.eINSTANCE
							.createCreateInstance();
					newChild.setReferenceName(ownedReferences.getName());
					newChild.setTypeName(qualifiedName(leaf));
					goToElement.getSubModelOperations().add(newChild);

					InitialOperation op = ToolFactory.eINSTANCE
							.createInitialOperation();
					op.setFirstModelOperations(goToElement);

					newMenuItem.setInitialOperation(op);
					newMenuItem.setForceRefresh(true);

					doneItems.put(leaf, newMenuItem);
					menu.getMenuItemDescriptions().add(newMenuItem);
				}

			}

		}
		return map;
	}

	private String qualifiedName(EClass eClassToStartFrom) {
		return eClassToStartFrom.getEPackage().getName() + "."
				+ eClassToStartFrom.getName();
	}

	private TreeItemMapping getAlreadyExistingMapping(EClass leaf,
			String semanticCandidateExpression) {
		TreeItemMapping found = null;
		Iterator<TreeItemMapping> it = doneClasses.get(leaf).iterator();
		while (it.hasNext() && found == null) {
			TreeItemMapping cur = it.next();
			if (semanticCandidateExpression.equals(cur
					.getSemanticCandidatesExpression())) {
				found = cur;
			}
		}
		return found;
	}

	private Optional<OperationAction> getAlreadyExistingMenuItem(EClass leaf,
			String referenceName) {
		OperationAction found = null;
		Iterator<OperationAction> it = doneItems.get(leaf).iterator();
		while (it.hasNext() && found == null) {
			OperationAction cur = it.next();
			Iterator<CreateInstance> itNewInstance = Iterators.filter(
					cur.eAllContents(), CreateInstance.class);
			while (itNewInstance.hasNext()) {
				CreateInstance newInstance = itNewInstance.next();
				if ((referenceName).equals(newInstance.getReferenceName())) {
					found = cur;
				}
			}
		}
		return Optional.fromNullable(found);
	}

	private Optional<EAttribute> lookForEditableName(EClass eClassToStartFrom) {
		Iterator<EAttribute> it = Iterators.filter(eClassToStartFrom
				.getEAllAttributes().iterator(), new Predicate<EAttribute>() {

			public boolean apply(EAttribute input) {
				return "name".equals(input.getName())
						&& "EString".equals(input.getEType().getName());
			}
		});
		if (it.hasNext()) {
			return Optional.fromNullable(it.next());
		} else {
			return Optional.absent();
		}
	}

}

class EClassHierarchy {

	private Multimap<EClass, EClass> mostSpecific = HashMultimap.create();

	public EClassHierarchy(ResourceSet resourceSet) {

		Set<EClass> allClasses = Sets.newLinkedHashSet(Lists
				.newArrayList(Iterators.filter(resourceSet.getAllContents(),
						EClass.class)));

		Set<EClass> somebodyIsExtendingMe = Sets.newLinkedHashSet();
		for (EClass eClass : allClasses) {
			// TODO open a popup to allow selection of types to browse..
			if (!"DiagramImportDescription".equals(eClass.getName())) {
				somebodyIsExtendingMe.addAll(eClass.getEAllSuperTypes());
			}
		}
		Collection<? extends EClass> leaves = Sets.difference(allClasses,
				somebodyIsExtendingMe);
		for (EClass leaf : leaves) {
			mostSpecific.put(leaf, leaf);
			Iterator<EClass> it = leaf.getEAllSuperTypes().iterator();
			while (it.hasNext()) {
				EClass next = it.next();
				mostSpecific.put(next, leaf);
			}
		}
	}

	public Iterable<EClass> getConcreteSubclassesLeafs(EClass targetClass) {
		return Iterables.filter(mostSpecific.get(targetClass),
				new Predicate<EClass>() {

					public boolean apply(EClass input) {
						return !input.isAbstract();
					}
				});
	}

}
