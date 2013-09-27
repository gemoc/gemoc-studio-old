/**
 */
package fr.obeo.dsl.sirius.animationtemplate.impl;

import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage;
import fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate;

import fr.obeo.dsl.sirius.animationtemplate.TTransformer;
import fr.obeo.dsl.viewpoint.description.impl.RepresentationTemplateImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Free Diagram Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animationtemplate.impl.FreeDiagramTemplateImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animationtemplate.impl.FreeDiagramTemplateImpl#getDomainClass <em>Domain Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FreeDiagramTemplateImpl extends RepresentationTemplateImpl implements FreeDiagramTemplate {
	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> outputs;
	/**
	 * The cached value of the '{@link #getDomainClass() <em>Domain Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainClass()
	 * @generated
	 * @ordered
	 */
	protected EClass domainClass;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FreeDiagramTemplateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnimationtemplatePackage.Literals.FREE_DIAGRAM_TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<EObject>(EObject.class, this, AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainClass() {
		if (domainClass != null && domainClass.eIsProxy()) {
			InternalEObject oldDomainClass = (InternalEObject)domainClass;
			domainClass = (EClass)eResolveProxy(oldDomainClass);
			if (domainClass != oldDomainClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS, oldDomainClass, domainClass));
			}
		}
		return domainClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetDomainClass() {
		return domainClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainClass(EClass newDomainClass) {
		EClass oldDomainClass = domainClass;
		domainClass = newDomainClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS, oldDomainClass, domainClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS:
				return getOutputs();
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS:
				if (resolve) return getDomainClass();
				return basicGetDomainClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends EObject>)newValue);
				return;
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS:
				setDomainClass((EClass)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS:
				getOutputs().clear();
				return;
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS:
				setDomainClass((EClass)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS:
				return domainClass != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TTransformer.class) {
			switch (derivedFeatureID) {
				case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS: return AnimationtemplatePackage.TTRANSFORMER__OUTPUTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TTransformer.class) {
			switch (baseFeatureID) {
				case AnimationtemplatePackage.TTRANSFORMER__OUTPUTS: return AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE__OUTPUTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FreeDiagramTemplateImpl
