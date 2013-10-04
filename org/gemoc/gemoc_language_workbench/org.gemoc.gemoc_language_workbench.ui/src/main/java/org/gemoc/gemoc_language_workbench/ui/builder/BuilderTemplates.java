package org.gemoc.gemoc_language_workbench.ui.builder;

public class BuilderTemplates {

	public static final String MODEL_LOADER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually */\n" +
"package ${package.name};\n"+
"import java.util.Map;\n"+
"import org.eclipse.emf.common.util.URI;\n"+	
"import org.eclipse.emf.ecore.resource.Resource;\n"+
"import org.eclipse.emf.ecore.resource.ResourceSet;\n"+
"import org.gemoc.gemoc_language_workbench.ui.api.IXDSMLModelLoader;\n"+
"public class ${language.name.toupperfirst}ModelLoader implements IXDSMLModelLoader {\n"+
"	@Override\n"+
"	public Resource loadModel(String modelFileUri) {\n"+
"		Resource result = null;\n"+
"		${loadModel.content}\n"+
"		return result;\n"+
"	}\n"+
"}";
	
	public static final String INITIALIZER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually */\n" +
"package ${package.name};\n"+
"import org.gemoc.gemoc_language_workbench.ui.api.IXDSMLInitializer;\n"+
"public class ${language.name.toupperfirst}Initializer implements IXDSMLInitializer {\n"+
"	@Override\n"+
"	public void initialize() {\n"+
"	${initializer.content}\n"+
"	}\n"+
"}";
	
	
	public static final String EXECUTOR_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually */\n" +
"package ${package.name};\n"+
"import org.gemoc.gemoc_language_workbench.api.dsa.impl.ChainedDSAExecutor;\n"+
"public class ${language.name.toupperfirst}DSAExecutor extends ChainedDSAExecutor {\n"+
"	public ${language.name.toupperfirst}DSAExecutor(){\n"+
"	    ${constructor.content}\n"+
"	}\n"+
"}";
	
}
