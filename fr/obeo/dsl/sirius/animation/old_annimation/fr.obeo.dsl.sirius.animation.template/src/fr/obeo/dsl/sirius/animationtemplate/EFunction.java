package fr.obeo.dsl.sirius.animationtemplate;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;

public abstract class EFunction<F extends TTransformer, T extends EObject> implements Function<F, T> {

	public abstract T transform(F from);

	public T apply(F input) {
		T result = transform(input);
		if (!input.getOutputs().contains(result)) {
			input.getOutputs().add(result);
		}
		return result;
	}

}
