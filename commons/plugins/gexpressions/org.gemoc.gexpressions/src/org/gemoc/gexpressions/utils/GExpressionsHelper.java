package org.gemoc.gexpressions.utils;

import org.eclipse.emf.ecore.EClass;

public class GExpressionsHelper {

	/**
	 * Returns whether or not eClass is a supertype of otherEClass. Check based
	 * on names...
	 * 
	 * @param eClass
	 * @param otherEClass
	 * @return
	 */
	public static Boolean eClassIsSuperTypeOf(EClass eClass, EClass otherEClass) {
		Boolean res = classEquals(eClass, otherEClass);
		for (EClass clazz : otherEClass.getEAllSuperTypes()) {
			res = res || classEquals(clazz, eClass);
		}
		return res;
	}

	private static Boolean classEquals(EClass eClass, EClass otherEClass) {
		return eClass.equals(otherEClass)
				|| (eClass.getName().equals(otherEClass.getName()) && eClass
						.getEPackage().getName()
						.equals(otherEClass.getEPackage().getName()));
	}
}
