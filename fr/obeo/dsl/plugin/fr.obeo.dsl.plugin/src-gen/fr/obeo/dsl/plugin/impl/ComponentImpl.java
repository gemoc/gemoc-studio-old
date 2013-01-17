/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import fr.obeo.dsl.plugin.Bundle;
import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.MetaClassRef;
import fr.obeo.dsl.plugin.PluginPackage;
import fr.obeo.dsl.plugin.Port;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getSubComponents <em>Sub Components</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getReferencedComponents <em>Referenced Components</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getBundles <em>Bundles</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getExpectedDependencies <em>Expected Dependencies</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getExpectedExtensions <em>Expected Extensions</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ComponentImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends CDOObjectImpl implements Component {
    /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
    protected static final String NAME_EDEFAULT = null;

    /**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ComponentImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return PluginPackage.Literals.COMPONENT;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
		return (String)eDynamicGet(PluginPackage.COMPONENT__NAME, PluginPackage.Literals.COMPONENT__NAME, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setName(String newName) {
		eDynamicSet(PluginPackage.COMPONENT__NAME, PluginPackage.Literals.COMPONENT__NAME, newName);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Component> getSubComponents() {
		return (EList<Component>)eDynamicGet(PluginPackage.COMPONENT__SUB_COMPONENTS, PluginPackage.Literals.COMPONENT__SUB_COMPONENTS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Component> getReferencedComponents() {
		return (EList<Component>)eDynamicGet(PluginPackage.COMPONENT__REFERENCED_COMPONENTS, PluginPackage.Literals.COMPONENT__REFERENCED_COMPONENTS, true, true);
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Bundle> getBundles() {
		return (EList<Bundle>)eDynamicGet(PluginPackage.COMPONENT__BUNDLES, PluginPackage.Literals.COMPONENT__BUNDLES, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Component> getExpectedDependencies() {
		return (EList<Component>)eDynamicGet(PluginPackage.COMPONENT__EXPECTED_DEPENDENCIES, PluginPackage.Literals.COMPONENT__EXPECTED_DEPENDENCIES, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Component> getExpectedExtensions() {
		return (EList<Component>)eDynamicGet(PluginPackage.COMPONENT__EXPECTED_EXTENSIONS, PluginPackage.Literals.COMPONENT__EXPECTED_EXTENSIONS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Port> getPorts() {
		return (EList<Port>)eDynamicGet(PluginPackage.COMPONENT__PORTS, PluginPackage.Literals.COMPONENT__PORTS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<EClassifier> getClassifiers() {
		return (EList<EClassifier>)eDynamicGet(PluginPackage.COMPONENT__CLASSIFIERS, PluginPackage.Literals.COMPONENT__CLASSIFIERS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDescription() {
		return (String)eDynamicGet(PluginPackage.COMPONENT__DESCRIPTION, PluginPackage.Literals.COMPONENT__DESCRIPTION, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDescription(String newDescription) {
		eDynamicSet(PluginPackage.COMPONENT__DESCRIPTION, PluginPackage.Literals.COMPONENT__DESCRIPTION, newDescription);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PluginPackage.COMPONENT__SUB_COMPONENTS:
				return ((InternalEList<?>)getSubComponents()).basicRemove(otherEnd, msgs);
			case PluginPackage.COMPONENT__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
			case PluginPackage.COMPONENT__CLASSIFIERS:
				return ((InternalEList<?>)getClassifiers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PluginPackage.COMPONENT__NAME:
				return getName();
			case PluginPackage.COMPONENT__SUB_COMPONENTS:
				return getSubComponents();
			case PluginPackage.COMPONENT__REFERENCED_COMPONENTS:
				return getReferencedComponents();
			case PluginPackage.COMPONENT__BUNDLES:
				return getBundles();
			case PluginPackage.COMPONENT__EXPECTED_DEPENDENCIES:
				return getExpectedDependencies();
			case PluginPackage.COMPONENT__EXPECTED_EXTENSIONS:
				return getExpectedExtensions();
			case PluginPackage.COMPONENT__PORTS:
				return getPorts();
			case PluginPackage.COMPONENT__CLASSIFIERS:
				return getClassifiers();
			case PluginPackage.COMPONENT__DESCRIPTION:
				return getDescription();
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
			case PluginPackage.COMPONENT__NAME:
				setName((String)newValue);
				return;
			case PluginPackage.COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				getSubComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case PluginPackage.COMPONENT__REFERENCED_COMPONENTS:
				getReferencedComponents().clear();
				getReferencedComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case PluginPackage.COMPONENT__BUNDLES:
				getBundles().clear();
				getBundles().addAll((Collection<? extends Bundle>)newValue);
				return;
			case PluginPackage.COMPONENT__EXPECTED_DEPENDENCIES:
				getExpectedDependencies().clear();
				getExpectedDependencies().addAll((Collection<? extends Component>)newValue);
				return;
			case PluginPackage.COMPONENT__EXPECTED_EXTENSIONS:
				getExpectedExtensions().clear();
				getExpectedExtensions().addAll((Collection<? extends Component>)newValue);
				return;
			case PluginPackage.COMPONENT__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case PluginPackage.COMPONENT__CLASSIFIERS:
				getClassifiers().clear();
				getClassifiers().addAll((Collection<? extends EClassifier>)newValue);
				return;
			case PluginPackage.COMPONENT__DESCRIPTION:
				setDescription((String)newValue);
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
			case PluginPackage.COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PluginPackage.COMPONENT__SUB_COMPONENTS:
				getSubComponents().clear();
				return;
			case PluginPackage.COMPONENT__REFERENCED_COMPONENTS:
				getReferencedComponents().clear();
				return;
			case PluginPackage.COMPONENT__BUNDLES:
				getBundles().clear();
				return;
			case PluginPackage.COMPONENT__EXPECTED_DEPENDENCIES:
				getExpectedDependencies().clear();
				return;
			case PluginPackage.COMPONENT__EXPECTED_EXTENSIONS:
				getExpectedExtensions().clear();
				return;
			case PluginPackage.COMPONENT__PORTS:
				getPorts().clear();
				return;
			case PluginPackage.COMPONENT__CLASSIFIERS:
				getClassifiers().clear();
				return;
			case PluginPackage.COMPONENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case PluginPackage.COMPONENT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case PluginPackage.COMPONENT__SUB_COMPONENTS:
				return !getSubComponents().isEmpty();
			case PluginPackage.COMPONENT__REFERENCED_COMPONENTS:
				return !getReferencedComponents().isEmpty();
			case PluginPackage.COMPONENT__BUNDLES:
				return !getBundles().isEmpty();
			case PluginPackage.COMPONENT__EXPECTED_DEPENDENCIES:
				return !getExpectedDependencies().isEmpty();
			case PluginPackage.COMPONENT__EXPECTED_EXTENSIONS:
				return !getExpectedExtensions().isEmpty();
			case PluginPackage.COMPONENT__PORTS:
				return !getPorts().isEmpty();
			case PluginPackage.COMPONENT__CLASSIFIERS:
				return !getClassifiers().isEmpty();
			case PluginPackage.COMPONENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
		}
		return super.eIsSet(featureID);
	}

} //ComponentImpl
