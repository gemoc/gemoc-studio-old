package fr.obeo.dsl.sirius.animationtemplate;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.AbstractIterator;

public class EIterators {

	public static Iterator<EObject> ancestors(final EObject from) {
		return new AbstractIterator<EObject>() {
			private EObject current = from;

			@Override
			protected EObject computeNext() {
				if (this.current.eContainer() != null) {
					this.current = this.current.eContainer();
					return this.current;
				}
				return this.endOfData();
			}
		};
	}

}
