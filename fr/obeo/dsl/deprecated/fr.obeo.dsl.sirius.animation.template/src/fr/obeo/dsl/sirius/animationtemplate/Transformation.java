package fr.obeo.dsl.sirius.animationtemplate;

import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

import fr.obeo.dsl.viewpoint.description.DescriptionFactory;
import fr.obeo.dsl.viewpoint.description.DiagramDescription;
import fr.obeo.dsl.viewpoint.tree.description.TreeDescription;

public class Transformation {
	
	public static Function<FreeDiagramTemplate, DiagramDescription> toDiag = new EFunction<FreeDiagramTemplate, DiagramDescription>() {

		public DiagramDescription transform(FreeDiagramTemplate tpl) {
			Iterator<DiagramDescription> it = Iterators.filter(tpl.getOwnedRepresentations()
					.iterator(), DiagramDescription.class);
			DiagramDescription result = null;
			if (it.hasNext()) {
				result = it.next();
			} else {
				result = DescriptionFactory.eINSTANCE
						.createDiagramDescription();				
				tpl.getOwnedRepresentations().add(result);
			}
			/*
			 * update result's content.
			 */
			result.setName(tpl.getName());
			if (tpl.getDomainClass() != null) {
				result.setDomainClass(tpl.getDomainClass().getName());
			}
			return result;
		}

	
	};
	
	public static Function<FreeDiagramTemplate, TreeDescription> toTree = new EFunction<FreeDiagramTemplate, TreeDescription>() {

		public TreeDescription transform(FreeDiagramTemplate tpl) {
			Iterator<TreeDescription> it = Iterators.filter(tpl.getOwnedRepresentations()
					.iterator(), TreeDescription.class);
			TreeDescription result = null;
			if (it.hasNext()) {
				result = it.next();
			} else {
				result = fr.obeo.dsl.viewpoint.tree.description.DescriptionFactory.eINSTANCE
						.createTreeDescription();				
				tpl.getOwnedRepresentations().add(result);
			}
			/*
			 * update result's content.
			 */
			result.setName(tpl.getName() +  " tree");
			if (tpl.getDomainClass() != null) {
				result.setDomainClass(tpl.getDomainClass().getName());
				result.getSubItemMappings().clear();
				new TreeDescriptionBuilderFromEClass(result, tpl.getDomainClass(),tpl.eResource().getResourceSet()).fillContent();
			}
			return result;
		}

	
	};
	
	public static Function<AnimationTemplate, DiagramDescription> animationTemplateToDiag = new EFunction<AnimationTemplate, DiagramDescription>() {

		public DiagramDescription transform(AnimationTemplate tpl) {
			Iterator<DiagramDescription> it = Iterators.filter(tpl.getOwnedRepresentations()
					.iterator(), DiagramDescription.class);
			DiagramDescription result = null;
			if (it.hasNext()) {
				result = it.next();
			} else {
				result = DescriptionFactory.eINSTANCE
						.createDiagramDescription();				
				tpl.getOwnedRepresentations().add(result);
			}
			/*
			 * update result's content.
			 */
			result.setName(tpl.getName());
			return result;
		}

	
	};
}
