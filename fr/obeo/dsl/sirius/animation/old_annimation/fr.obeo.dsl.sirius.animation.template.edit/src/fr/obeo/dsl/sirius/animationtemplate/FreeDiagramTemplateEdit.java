package fr.obeo.dsl.sirius.animationtemplate;

import org.eclipse.emf.edit.command.CommandParameter;

import fr.obeo.dsl.viewpoint.description.DescriptionPackage;
import fr.obeo.dsl.viewpoint.description.RepresentationTemplate;

public class FreeDiagramTemplateEdit extends AbstractAnimationTemplateEdit {

	@Override
	public Object getNewChildDescriptor() {
		return new CommandParameter(null,
				DescriptionPackage.Literals.VIEWPOINT__OWNED_TEMPLATES,
				AnimationtemplateFactory.eINSTANCE.createFreeDiagramTemplate());
	}

	@Override
	public void update(RepresentationTemplate tpl) {
		if (tpl instanceof FreeDiagramTemplate) {
			FreeDiagramTemplate template = (FreeDiagramTemplate) tpl;
			Transformation.toTree.apply(template);
			Transformation.toDiag.apply(template);
		}

	}

}
