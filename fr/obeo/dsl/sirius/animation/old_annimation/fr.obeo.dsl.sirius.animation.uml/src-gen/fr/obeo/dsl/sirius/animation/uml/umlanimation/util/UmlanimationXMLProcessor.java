/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation.util;

import fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlanimationXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlanimationXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		UmlanimationPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the UmlanimationResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new UmlanimationResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new UmlanimationResourceFactoryImpl());
		}
		return registrations;
	}

} //UmlanimationXMLProcessor
