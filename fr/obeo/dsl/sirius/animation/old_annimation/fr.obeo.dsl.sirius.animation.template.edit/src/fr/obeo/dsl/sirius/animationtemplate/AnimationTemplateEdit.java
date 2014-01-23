package fr.obeo.dsl.sirius.animationtemplate;


import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.command.CommandParameter;


import fr.obeo.dsl.viewpoint.description.DescriptionPackage;
import fr.obeo.dsl.viewpoint.description.RepresentationTemplate;
import fr.obeo.dsl.viewpoint.ui.business.api.template.RepresentationTemplateEdit;

public class AnimationTemplateEdit extends AbstractAnimationTemplateEdit implements RepresentationTemplateEdit {

	@Override
	public Object getNewChildDescriptor() {
		return new CommandParameter(null,
				DescriptionPackage.Literals.VIEWPOINT__OWNED_TEMPLATES,
				AnimationtemplateFactory.eINSTANCE.createAnimationTemplate());
	}

	
	@Override
	public void update(RepresentationTemplate tpl) {
		if (tpl instanceof AnimationTemplate) {
			AnimationTemplate template = (AnimationTemplate) tpl;
			Transformation.animationTemplateToDiag.apply(template);
		}

	}

}
