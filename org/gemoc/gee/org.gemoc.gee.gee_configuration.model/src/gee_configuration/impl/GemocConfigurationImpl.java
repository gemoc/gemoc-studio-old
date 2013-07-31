/**
 */
package gee_configuration.impl;

import gee_configuration.DSAModel;
import gee_configuration.DSEModel;
import gee_configuration.DomainSpecificEditor;
import gee_configuration.DomainSpecificMetamodel;
import gee_configuration.Gee_configurationPackage;
import gee_configuration.GemocConfiguration;
import gee_configuration.MoccModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gemoc Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gee_configuration.impl.GemocConfigurationImpl#getDsaModels <em>Dsa Models</em>}</li>
 *   <li>{@link gee_configuration.impl.GemocConfigurationImpl#getMoccModels <em>Mocc Models</em>}</li>
 *   <li>{@link gee_configuration.impl.GemocConfigurationImpl#getDseModels <em>Dse Models</em>}</li>
 *   <li>{@link gee_configuration.impl.GemocConfigurationImpl#getDomainSpecificMetamodels <em>Domain Specific Metamodels</em>}</li>
 *   <li>{@link gee_configuration.impl.GemocConfigurationImpl#getEditors <em>Editors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GemocConfigurationImpl extends EObjectImpl implements GemocConfiguration {
	/**
	 * The cached value of the '{@link #getDsaModels() <em>Dsa Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDsaModels()
	 * @generated
	 * @ordered
	 */
	protected EList<DSAModel> dsaModels;

	/**
	 * The cached value of the '{@link #getMoccModels() <em>Mocc Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoccModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MoccModel> moccModels;

	/**
	 * The cached value of the '{@link #getDseModels() <em>Dse Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDseModels()
	 * @generated
	 * @ordered
	 */
	protected EList<DSEModel> dseModels;

	/**
	 * The cached value of the '{@link #getDomainSpecificMetamodels() <em>Domain Specific Metamodels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecificMetamodels()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainSpecificMetamodel> domainSpecificMetamodels;

	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainSpecificEditor> editors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GemocConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gee_configurationPackage.Literals.GEMOC_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DSAModel> getDsaModels() {
		if (dsaModels == null) {
			dsaModels = new EObjectContainmentEList<DSAModel>(DSAModel.class, this, Gee_configurationPackage.GEMOC_CONFIGURATION__DSA_MODELS);
		}
		return dsaModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoccModel> getMoccModels() {
		if (moccModels == null) {
			moccModels = new EObjectContainmentEList<MoccModel>(MoccModel.class, this, Gee_configurationPackage.GEMOC_CONFIGURATION__MOCC_MODELS);
		}
		return moccModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DSEModel> getDseModels() {
		if (dseModels == null) {
			dseModels = new EObjectContainmentEList<DSEModel>(DSEModel.class, this, Gee_configurationPackage.GEMOC_CONFIGURATION__DSE_MODELS);
		}
		return dseModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainSpecificMetamodel> getDomainSpecificMetamodels() {
		if (domainSpecificMetamodels == null) {
			domainSpecificMetamodels = new EObjectContainmentEList<DomainSpecificMetamodel>(DomainSpecificMetamodel.class, this, Gee_configurationPackage.GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS);
		}
		return domainSpecificMetamodels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainSpecificEditor> getEditors() {
		if (editors == null) {
			editors = new EObjectContainmentEList<DomainSpecificEditor>(DomainSpecificEditor.class, this, Gee_configurationPackage.GEMOC_CONFIGURATION__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSA_MODELS:
				return ((InternalEList<?>)getDsaModels()).basicRemove(otherEnd, msgs);
			case Gee_configurationPackage.GEMOC_CONFIGURATION__MOCC_MODELS:
				return ((InternalEList<?>)getMoccModels()).basicRemove(otherEnd, msgs);
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSE_MODELS:
				return ((InternalEList<?>)getDseModels()).basicRemove(otherEnd, msgs);
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS:
				return ((InternalEList<?>)getDomainSpecificMetamodels()).basicRemove(otherEnd, msgs);
			case Gee_configurationPackage.GEMOC_CONFIGURATION__EDITORS:
				return ((InternalEList<?>)getEditors()).basicRemove(otherEnd, msgs);
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
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSA_MODELS:
				return getDsaModels();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__MOCC_MODELS:
				return getMoccModels();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSE_MODELS:
				return getDseModels();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS:
				return getDomainSpecificMetamodels();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__EDITORS:
				return getEditors();
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
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSA_MODELS:
				getDsaModels().clear();
				getDsaModels().addAll((Collection<? extends DSAModel>)newValue);
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__MOCC_MODELS:
				getMoccModels().clear();
				getMoccModels().addAll((Collection<? extends MoccModel>)newValue);
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSE_MODELS:
				getDseModels().clear();
				getDseModels().addAll((Collection<? extends DSEModel>)newValue);
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS:
				getDomainSpecificMetamodels().clear();
				getDomainSpecificMetamodels().addAll((Collection<? extends DomainSpecificMetamodel>)newValue);
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends DomainSpecificEditor>)newValue);
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
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSA_MODELS:
				getDsaModels().clear();
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__MOCC_MODELS:
				getMoccModels().clear();
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSE_MODELS:
				getDseModels().clear();
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS:
				getDomainSpecificMetamodels().clear();
				return;
			case Gee_configurationPackage.GEMOC_CONFIGURATION__EDITORS:
				getEditors().clear();
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
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSA_MODELS:
				return dsaModels != null && !dsaModels.isEmpty();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__MOCC_MODELS:
				return moccModels != null && !moccModels.isEmpty();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DSE_MODELS:
				return dseModels != null && !dseModels.isEmpty();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS:
				return domainSpecificMetamodels != null && !domainSpecificMetamodels.isEmpty();
			case Gee_configurationPackage.GEMOC_CONFIGURATION__EDITORS:
				return editors != null && !editors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GemocConfigurationImpl
