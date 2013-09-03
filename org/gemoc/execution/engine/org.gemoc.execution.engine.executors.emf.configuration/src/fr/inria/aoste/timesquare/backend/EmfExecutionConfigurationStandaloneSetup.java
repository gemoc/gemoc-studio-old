package fr.inria.aoste.timesquare.backend;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class EmfExecutionConfigurationStandaloneSetup extends EmfExecutionConfigurationStandaloneSetupGenerated {

    public static void doSetup() {
        new EmfExecutionConfigurationStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
