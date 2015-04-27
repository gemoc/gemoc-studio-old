package org.gemoc.gemoc_language_workbench.ui.builder;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.osgi.framework.BundleException;

import fr.inria.diverse.commons.eclipse.pde.java.JavaNameHelper;
import fr.inria.diverse.commons.eclipse.pde.manifest.ManifestChanger;
import fr.inria.diverse.commons.eclipse.resources.IFileUtils;
import fr.inria.diverse.commons.eclipse.resources.IFolderUtils;

public class MelangeGenerator {

	public static final String MELANGE_GEN_FOLDER = "gemoc-gen";
	
	protected IProject project;
	protected LanguageDefinition languageDefinition;
	
	public MelangeGenerator(IProject project, LanguageDefinition ld){
		this.project = project;
		this.languageDefinition = ld;
	}
	
	/**
	 * generate or update a melange file according to the configuration
	 * @param project
	 * @param ld
	 * @param manifestChanger
	 * @throws BundleException
	 * @throws IOException
	 * @throws CoreException
	 */
	public void updateGeneratedMelange( ManifestChanger manifestChanger) throws BundleException, IOException, CoreException {
		IFile melangeIFile = getMelangeIFile();
		// this can be done only if we have a domain model and a dsa
		if(languageDefinition.getDomainModelProject() != null && languageDefinition.getDomainModelProject().getGenmodeluri() != null){
			// create the buffer of the expected melange
			String fileContent = BuilderTemplates.MELANGE_TEMPLATE;
			fileContent = fileContent.replaceAll(
					Pattern.quote("${package.name}"), getMelangePackageName());
			
			GenModel genModel = (GenModel)languageDefinition.getDomainModelProject().getGenmodel();
			
			// we can create a melange that contains the model type for the domain model
			StringBuilder sb = new StringBuilder();
			// grab the original language name from the ecore
//			sb.append("metamodel "+ languageDefinition.getName()+"_base {\n");
//			
//			// just in case
//			//EcoreUtil.resolveAll(genModel.eResource().getResourceSet());
//			for(GenPackage genpackage : genModel.getGenPackages()){
//				//genpackage.getEcoreModelElement().eIsProxy();
//				//genpackage.getEcorePackage().eResource().getURI().toString();
//				sb.append("   ecore \""+genpackage.getEcorePackage().eResource().getURI().toString()+"\"\n");
//				break; // currently melange doesn't support multiple ecore file as metmaodel definition
//				// so just grab the first one
//			}
//			sb.append("   withGenmodel \""+languageDefinition.getDomainModelProject().getGenmodeluri()+"\"\n");
//			sb.append("   exactType "+ languageDefinition.getName()+"_base_MT\n");
//			sb.append("}\n");
			
			fileContent = fileContent.replaceAll(
					Pattern.quote("${base.language.metamodel.section}"), sb.toString());
			
			// let's create the modeltype for our executable language
			sb = new StringBuilder();
			// grab the original language name from the ecore
			sb.append("metamodel "+ languageDefinition.getName()+" {\n");
			for(GenPackage genpackage : genModel.getGenPackages()){
				//genpackage.getEcoreModelElement().eIsProxy();
				//genpackage.getEcorePackage().eResource().getURI().toString();
				sb.append("   ecore \""+genpackage.getEcorePackage().eResource().getURI().toString()+"\"\n");
				break; // currently melange doesn't support multiple ecore file as metmaodel definition
				// so just grab the first one
			}
			sb.append("   withGenmodel \""+languageDefinition.getDomainModelProject().getGenmodeluri()+"\"\n");
			sb.append("   exactType "+ languageDefinition.getName()+"_MT\n");
			
			if(languageDefinition.getDsaProject() != null && languageDefinition.getDsaProject().getProjectName() != null && 
					!languageDefinition.getDsaProject().getProjectName().isEmpty()){
				// aspects from dsa				
				IProject k3DSAIProject = ResourcesPlugin.getWorkspace().getRoot().getProject(languageDefinition.getDsaProject().getProjectName());
				Set<String> aspectClasses = getAspectClassesList(k3DSAIProject);
				for(String aspectClass : aspectClasses){
					sb.append("   with "+aspectClass+"\n");
				}
			}
			sb.append("}\n");
			fileContent = fileContent.replaceAll(
					Pattern.quote("${executable.language.metamodel.section}"), sb.toString());
			// deal with the import section, currently nothing
			fileContent = fileContent.replaceAll(
					Pattern.quote("${import.section}"), "");
			
			// if file doesn't exist, create it with this content
			// else if buffer is different from existing, replace it
			if(!melangeIFile.getParent().exists())	IFolderUtils.create((IFolder) melangeIFile.getParent(), true, true, null);
			IFileUtils.writeInFileIfDifferent(melangeIFile, fileContent, null);
			
		} else {
			// if it exists, it isn't valid anymore, remove it
			if(melangeIFile.exists()){
				melangeIFile.delete(true, null);
			}
		}
	}
	
	/** find the mapping properties file in the project and retrieves the aspectClasses
	 * 
	 * @param k3IProject
	 * @return
	 */
	private Set<String> getAspectClassesList(IProject k3IProject){
		HashSet<String> aspectClasses = new HashSet<String>();
		FileFinderVisitor projectVisitor = new FileFinderVisitor("properties");
		try {
			//ResourcesPlugin.getWorkspace().getRoot().getProject(languageDefinition.getDsaProject().getProjectName());
			k3IProject.accept(projectVisitor);
			List<IFile> possibleAspectMappingPropertiesFiles = projectVisitor.getFiles();
			for(IFile aspectMappingPropertiesFile : possibleAspectMappingPropertiesFiles){
				if(aspectMappingPropertiesFile.getName().endsWith("k3_aspect_mapping.properties")){
					Properties properties = new Properties();
					if(aspectMappingPropertiesFile.exists()){
						try {
							properties.load(aspectMappingPropertiesFile.getContents());
							for(Object commaSeparatedPropvalues:properties.values()){
								for(String propVal :((String)commaSeparatedPropvalues).split(",")){
									aspectClasses.add(propVal);
								}
							}
						} catch (IOException e) {
							// ...
						} catch (CoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
		return aspectClasses;
	}
	
	public String getMelangePackageName(){
		return JavaNameHelper.getFormattedPackageName(project.getName());
	}
	
	public IFile getMelangeIFile(){
		String melangeFileName = MELANGE_GEN_FOLDER+"/"+getMelangePackageName().replaceAll("\\.", "/")+"/"+languageDefinition.getName()+".melange";
		return project.getFile(melangeFileName);
	}
}
