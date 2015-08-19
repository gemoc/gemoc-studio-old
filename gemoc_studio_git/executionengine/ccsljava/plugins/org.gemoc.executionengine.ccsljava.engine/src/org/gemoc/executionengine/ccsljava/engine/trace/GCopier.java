package org.gemoc.executionengine.ccsljava.engine.trace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import com.google.common.collect.LinkedListMultimap;

/**
 * Extend the original copier from EMF for the trace management.
 * The problem with the original copier is that it is not copying attributes correctly.
 * For example collections are not copied.   
 * @author ftanguy
 *
 */
class GCopier extends Copier {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1436841508070681383L;

	@Override
	protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eAttribute)) {
			if (FeatureMapUtil.isFeatureMap(eAttribute)) {
				FeatureMap featureMap = (FeatureMap) eObject.eGet(eAttribute);
				for (int i = 0, size = featureMap.size(); i < size; ++i) {
					EStructuralFeature feature = featureMap.getEStructuralFeature(i);
					if (feature instanceof EReference && ((EReference) feature).isContainment()) {
						Object value = featureMap.getValue(i);
						if (value != null) {
							copy((EObject) value);
						}
					}
				}
			} else if (eAttribute.isMany()) {
				List<?> source = (List<?>) eObject.eGet(eAttribute);
				@SuppressWarnings("unchecked")
				List<Object> target = (List<Object>) copyEObject.eGet(getTarget(eAttribute));
				if (source.isEmpty()) {
					target.clear();
				} else {
					target.addAll(source);
				}
			} else {
				Object value = eObject.eGet(eAttribute);
				Object newValue = value;
				// [FT] todo add more specific cases.
				if (value instanceof LinkedListMultimap) 
				{
					LinkedListMultimap tempValue = LinkedListMultimap.create((LinkedListMultimap)value);
					newValue = tempValue;
				}
				else if (value instanceof ArrayList<?>) 
				{
					ArrayList tempValue = new ArrayList((ArrayList)value);
					newValue = tempValue;
				}
				copyEObject.eSet(getTarget(eAttribute), newValue);
			}
		}
	}

}
