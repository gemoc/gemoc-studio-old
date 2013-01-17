package fr.obeo.dsl.plugin.gen.query;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Services {

	public String getDoc(EModelElement element) {
		String doc = EcoreUtil.getDocumentation(element);
		if (doc == null)
			return "";
		return doc;
	}

}
