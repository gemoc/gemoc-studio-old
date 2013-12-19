package fr.obeo.dsl.sirius.animationtemplate;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

import com.google.common.collect.Iterators;

import fr.obeo.dsl.viewpoint.description.RepresentationTemplate;
import fr.obeo.dsl.viewpoint.ui.business.api.template.RepresentationTemplateEdit;

public abstract class AbstractAnimationTemplateEdit implements RepresentationTemplateEdit{

	public AbstractAnimationTemplateEdit() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getSourceElement(EObject vsmObject) {
		Iterator<RepresentationTemplate> it = Iterators.filter(
				EIterators.ancestors(vsmObject), RepresentationTemplate.class);
		if (it.hasNext()) {
			RepresentationTemplate template = it.next();
			ECrossReferenceAdapter crosser = getOrCreateCrossReferencer(template);
			for (Setting setting : crosser.getInverseReferences(vsmObject)) {
				if (setting.getEStructuralFeature() == AnimationtemplatePackage.eINSTANCE
						.getTTransformer_Outputs()) {
					return setting.getEObject();
				}
			}
		}
		return null;
	}

	ECrossReferenceAdapter getOrCreateCrossReferencer(
			RepresentationTemplate template) {
		ECrossReferenceAdapter crosser = ECrossReferenceAdapter
				.getCrossReferenceAdapter(template);
		if (crosser == null) {
			crosser = new ECrossReferenceAdapter();
			template.eAdapters().add(crosser);
		}
		return crosser;
	}

	@Override
	public boolean isGenerated(EObject vsmObject) {
		return getSourceElement(vsmObject) != null;
	}

	@Override
	public boolean isOverriden(EObject eObj, EStructuralFeature feature) {
		return getSourceElement(eObj) != null;
	}

}