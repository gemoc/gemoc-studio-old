/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import fr.obeo.dsl.plugin.Link;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import fr.obeo.dsl.plugin.PluginPackage;
import fr.obeo.dsl.plugin.Port;
import fr.obeo.dsl.plugin.PortKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PortImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PortImpl#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PortImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PortImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortImpl extends CDOObjectImpl implements Port {
    /**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
    protected static final PortKind KIND_EDEFAULT = PortKind.REQUIRED;

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
    protected PortImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return PluginPackage.Literals.PORT;
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
    public PortKind getKind() {
		return (PortKind)eDynamicGet(PluginPackage.PORT__KIND, PluginPackage.Literals.PORT__KIND, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setKind(PortKind newKind) {
		eDynamicSet(PluginPackage.PORT__KIND, PluginPackage.Literals.PORT__KIND, newKind);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
		return (String)eDynamicGet(PluginPackage.PORT__NAME, PluginPackage.Literals.PORT__NAME, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setName(String newName) {
		eDynamicSet(PluginPackage.PORT__NAME, PluginPackage.Literals.PORT__NAME, newName);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Port> getDelegation() {
		return (EList<Port>)eDynamicGet(PluginPackage.PORT__DELEGATION, PluginPackage.Literals.PORT__DELEGATION, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDescription() {
		return (String)eDynamicGet(PluginPackage.PORT__DESCRIPTION, PluginPackage.Literals.PORT__DESCRIPTION, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDescription(String newDescription) {
		eDynamicSet(PluginPackage.PORT__DESCRIPTION, PluginPackage.Literals.PORT__DESCRIPTION, newDescription);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Link> getLinks() {
		return (EList<Link>)eDynamicGet(PluginPackage.PORT__LINKS, PluginPackage.Literals.PORT__LINKS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PluginPackage.PORT__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
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
			case PluginPackage.PORT__KIND:
				return getKind();
			case PluginPackage.PORT__NAME:
				return getName();
			case PluginPackage.PORT__DELEGATION:
				return getDelegation();
			case PluginPackage.PORT__DESCRIPTION:
				return getDescription();
			case PluginPackage.PORT__LINKS:
				return getLinks();
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
			case PluginPackage.PORT__KIND:
				setKind((PortKind)newValue);
				return;
			case PluginPackage.PORT__NAME:
				setName((String)newValue);
				return;
			case PluginPackage.PORT__DELEGATION:
				getDelegation().clear();
				getDelegation().addAll((Collection<? extends Port>)newValue);
				return;
			case PluginPackage.PORT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case PluginPackage.PORT__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
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
			case PluginPackage.PORT__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case PluginPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PluginPackage.PORT__DELEGATION:
				getDelegation().clear();
				return;
			case PluginPackage.PORT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case PluginPackage.PORT__LINKS:
				getLinks().clear();
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
			case PluginPackage.PORT__KIND:
				return getKind() != KIND_EDEFAULT;
			case PluginPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case PluginPackage.PORT__DELEGATION:
				return !getDelegation().isEmpty();
			case PluginPackage.PORT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case PluginPackage.PORT__LINKS:
				return !getLinks().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PortImpl
