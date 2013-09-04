package fr.inria.aoste.timesquare.backend.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractEmfExecutionConfigurationJavaValidator extends AbstractDeclarativeValidator {

    
    @Override
	protected List<EPackage> getEPackages() {
        List<EPackage> result = new ArrayList<EPackage>();
        result.add(fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage.eINSTANCE);
        return result;
    }

}
