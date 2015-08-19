package org.gemoc.gemoc_language_workbench.ui.builder;

public class BuilderTemplates {

	public static final String MODEL_LOADER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import java.util.Map;\n"+
"import org.eclipse.emf.common.util.URI;\n"+	
"import org.eclipse.emf.ecore.resource.Resource;\n"+
"import org.eclipse.emf.ecore.resource.ResourceSet;\n"+
"import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;\n"+
"import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;\n"+
"public class ${language.name.toupperfirst}ModelLoader implements ModelLoader {\n"+
"	@Override\n"+
"	public Resource loadModel(String modelFileUri) {\n"+
"		Resource result = null;\n"+
"		${loadModel.content}\n"+
"		return result;\n"+
"	}\n"+
"}";
	
	public static final String INITIALIZER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;\n"+
"public class ${language.name.toupperfirst}Initializer implements LanguageInitializer {\n"+
"	@Override\n"+
"	public void initialize() {\n"+
"	${initializer.content}\n"+
"	}\n"+
"}";
	
	
	public static final String CODEEXECUTOR_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import org.gemoc.executionengine.ccsljava.engine.dsa.executors.CodeExecutorDispatcher;\n"+
"public class ${language.name.toupperfirst}CodeExecutor extends CodeExecutorDispatcher ${implements.content} {\n"+
"	public ${language.name.toupperfirst}CodeExecutor(){\n"+
"	    ${constructor.content}\n"+
"	}\n"+
"	public String getDSAProjectName(){\n"+
"		//TODO please implement\n"+
"		return \"\";\n"+
"	}\n"+
"   ${additional.operations}\n"+
"}";
	
	public static final String SOLVER_CLASS_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the generation in the BuildOptions of the project.xdsml */\n" +
"package ${package.name};\n"+
"import org.gemoc.execution.engine.commons.solvers.ccsl.CcslSolver;\n"+
"public class ${language.name.toupperfirst}Solver extends CcslSolver {\n"+
"	public ${language.name.toupperfirst}Solver(){\n"+
"	    ${constructor.content}\n"+
"	}\n"+
"}";
	
	
	public static final String MELANGE_TEMPLATE =
"/* GENERATED FILE, do not modify manually                                                    *\n" +
" * If you need to modify it, disable the needMelangeSynchronization flag in the project.xdsml */\n" +
"package ${package.name}\n"+
"${import.section}\n"+
"${base.language.metamodel.section}\n"+
"${executable.language.metamodel.section}";
	
}
