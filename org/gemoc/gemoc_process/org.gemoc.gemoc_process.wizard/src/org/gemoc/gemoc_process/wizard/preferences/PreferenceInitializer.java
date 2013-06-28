package org.gemoc.gemoc_process.wizard.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.gemoc.gemoc_process.wizard.Activator;


/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		store.setDefault(PreferenceConstants.P_NEW_KMT_TEMPLATE_STRING, 
				"using kermeta::standard::*\n"+
				"using kermeta::io::StdIO => stdio\n\n"+
				"package "+"${package.name}"+"{\n"+
		        "\tclass "+"${class.name}"+
		        "\n\t{\n"+
		        "\n\t\t@main \"\" // declares that operation as a possible entry point of the program\n"+
		        "\t\toperation "+"${operation.name}"+"() : Void is do \n"+
		        "\t\t\t// TODO: implement '"+"${operation.name}"+ "' operation\n"+
		        "\t\t\tstdio.writeln(\"Hello from "+"${operation.name}"+ "\")\n"+
		        "\t\tend"+
		        "\n\t}"+
		        "\n}");
		store.setDefault(PreferenceConstants.P_NEW_KP_TEMPLATE_STRING, 
				"resource library_standard =\"platform:/plugin/org.kermeta.language.library.standard\" alternative \"mvn:org.kermeta.language/org.kermeta.language.library.standard/2.0.99-SNAPSHOT\"\n"+
				"importProject library_standard\n" +

				"project ${project.name} {\n"+ 
				"\tmainClass \"${project.name}^${package.name}::${class.name}\"\n"+ 
				"\tmainOperation \"${operation.name}\"\n\n"+
					
				"\timport \"${project.baseUri}/src/main/kmt/${class.name}.kmt\"\n"+ 
				"}\n"

				);
		
	}

}
