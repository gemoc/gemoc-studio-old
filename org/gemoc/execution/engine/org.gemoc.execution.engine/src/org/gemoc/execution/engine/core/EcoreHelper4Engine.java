package org.gemoc.execution.engine.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;

import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.NamedReference;
import fr.inria.aoste.trace.Reference;

public class EcoreHelper4Engine {

	/**
	 * Hack to retrieve an EObject from its qualified name...
	 * 
	 * @param modelResource
	 * @param qualifiedName
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static EObject getEObjectFromQualifiedName(Resource modelResource,
			String qualifiedName) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {

		Iterator<EObject> iterator = modelResource.getAllContents();// this.modelResource.getContents().get(0).eAllContents();
		EObject res = null;
		while (iterator.hasNext() & res == null) {
			EObject modelElement = iterator.next();
			if (getQualifiedName(modelElement).equals(qualifiedName)) {
				res = modelElement;
			}
		}
		return res;
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param reference
	 * @return
	 */
	public static EObject getEObjectFromReference(Resource modelResource, Reference reference) {

		EList<EObject> elements = ((ModelElementReference) reference)
				.getElementRef();
		if (reference instanceof ModelElementReference) {
			// Returns EObject thanks to the list of EObjects
			return elements.get(elements.size() - 1);
		} else if (reference instanceof NamedReference) {
			// Returns EObject thanks to its qualified name
			try {
				EObject res = getEObjectFromQualifiedName(modelResource,
						(((NamedReference) reference).getValue()));
				Activator.getMessagingSystem().debug("Returning :" + res,
						Activator.PLUGIN_ID);
				return res;
			} catch (SecurityException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (IllegalArgumentException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (NoSuchMethodException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (IllegalAccessException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (InvocationTargetException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to retrieve an EObject from the model from a NamedReference";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			}

			// Iterator<EObject> modelIterator =
			// this.modelResource.getContents().get(0).eAllContents();
			// while (modelIterator.hasNext()) {
			// EObject eo = modelIterator.next();
			// if (this.getNameOfEObject(eo).equals(elements.get(elements.size()
			// - 1))) {
			// return eo;
			// }
			// }
		} else {
			throw new RuntimeException(
					"Context reference is neither a ModelElementReference nor a NamedElementReference");
		}
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param eo
	 * @return
	 */
	public static String getQualifiedName(EObject eo) {
		String res = getSimpleName(eo);
		EObject tmp = eo.eContainer();
		while (tmp != null) {
			res = getSimpleName(tmp) + "::" + res;
			tmp = tmp.eContainer();
		}
		return res;
	}

	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param eo
	 * @return
	 */
	public static String getSimpleName(EObject eo) {
		return invokeGetNameOnEObject(eo);
	}
	
	/**
	 * Part of the hack to get an EObject from its qualified name.
	 * 
	 * @param eObjectMethod
	 * @return
	 */
	public static String invokeGetNameOnEObject(EObject eObjectMethod) {
		Method method;
		try {
			method = eObjectMethod.getClass().getMethod("getName");
			Object res = method.invoke(eObjectMethod);
			if (res instanceof String) {
				return (String) res;
			} else {
				return null;
			}
		} catch (SecurityException e) {
			String errorMessage = "SecurityException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalArgumentException e) {
			String errorMessage = "IllegalArgumentException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = "NoSuchMethodException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = "IllegalAccessException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = "InvocationTargetException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}
	
	/**
	 * Returns the value of the attribute whose name is attributeName of eobject
	 * eo. The type of the attribute must be String. Basically if a String
	 * attribute is a good enough unique identifier for your EObjects then use
	 * this method to retrieve the value of the attribute without making
	 * assumption about the EObject. Otherwise, better use .toString().
	 * 
	 * @param eo
	 * @param attributeName
	 * @return
	 */
	public static String getValueOfStringAttribute(EObject eo, String attributeName) {
		// String representation of the EObject :
		// "Klass@abc123 (att1: v1) (att2: v2)"
		String targetString = eo.toString();
		// We get the list of attribute without ending and
		// starting parentheses : "att1: v1) (att2: v2"
		String stringOfAttributesList = targetString.substring(
				targetString.indexOf("(") + 1, targetString.length() - 1);
		// We split it to get ["att1: v1", "att2: v2"]
		List<String> listOfAttributes = Arrays.asList(stringOfAttributesList
				.split("\\) \\("));
		// We look for "attributeName: xxx" in the array.
		String attributeStringRepresentation = "";
		for (String s : listOfAttributes) {
			if (s.startsWith(attributeName + ": ")) {
				attributeStringRepresentation = s;
			}
		}
		String res = "";
		if (attributeStringRepresentation != "") {
			// Either we found "name: xxx" in which case we have
			// 'xxx'
			res = attributeStringRepresentation.substring(
					attributeStringRepresentation.indexOf(attributeName + ": ")
							+ (attributeName + ": ").length(),
					attributeStringRepresentation.length());
			return res;
		} else {
			// Or we throw exception (what to do?)
			throw new UnsupportedOperationException("You need a(n) '"
					+ attributeName + "' attribute on the EObject "
					+ eo.toString() + " for this method to work.");
		}
	}
}
