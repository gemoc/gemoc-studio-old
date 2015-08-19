package org.gemoc.gemoc_language_workbench.extensions.k3;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.gemoc.execution.engine.core.AbstractDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.kermeta.utils.provisionner4eclipse.Provisionner;
import org.osgi.framework.Bundle;

import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand;
import fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry;

public class PlainK3ExecutionEngine extends AbstractDeterministicExecutionEngine implements IStepManager {

	private Runnable _entryPoint;

	class DefaultSearchRequestor extends SearchRequestor {

		public IType _binaryType;

		@Override
		public void acceptSearchMatch(SearchMatch match) throws CoreException {
			_binaryType = (IType) match.getElement();
			System.out.println(match.getElement());
		}

	}

	/**
	 * Constructs a PlainK3 execution engine using an entry point (~ a main
	 * operation) The entrypoint will register itself as a StepManager into the
	 * K3 step manager registry, and unregister itself at the end. As a
	 * StepManager, the PlainK3ExecutionEngine will receive callbacks through
	 * its "executeStep" operation.
	 */
	@Override
	public void initialize(final IExecutionContext executionContext) {

		PlainK3ExecutionEngine.super.initialize(executionContext);

		String className = executionContext.getRunConfiguration().getExecutionEntryPoint();

		// If nothing is declared in the launch configuration,
		// we use the value given in the xDSML
		if (className == null || className.equals("")) {
			className = getLanguageDefinition(executionContext.getLanguageDefinitionExtension().getXDSMLFilePath()).getDsaProject()
					.getEntryPoint();
		}

		SearchPattern pattern = SearchPattern.createPattern(className, IJavaSearchConstants.CLASS,
				IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH);
		IJavaSearchScope scope = SearchEngine.createWorkspaceScope();

		DefaultSearchRequestor requestor = new DefaultSearchRequestor();
		SearchEngine engine = new SearchEngine();

		try {
			engine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, scope,
					requestor, null);
		} catch (CoreException e1) {
			throw new RuntimeException("Error while searching the bundle: " + e1.getMessage());
			// return new Status(IStatus.ERROR, Activator.PLUGIN_ID, );
		}

		IPackageFragmentRoot packageFragmentRoot = (IPackageFragmentRoot) requestor._binaryType.getPackageFragment()
				.getParent();

		final ArrayList<Object> parameters = new ArrayList<>();
		parameters.add(executionContext.getResourceModel().getContents().get(0));
		String bundleName = null;

		bundleName = packageFragmentRoot.getPath().removeLastSegments(1).lastSegment().toString();

		Class<?> c;

		// First we try to look into an already loaded bundle
		Bundle bundle = Platform.getBundle(bundleName);

		// If this doesn't work, we use the provisioner to load
		// the corresponding project
		if (bundle == null) {

			String projectName = requestor._binaryType.getJavaProject().getElementName();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project != null && project.exists()
					&& !project.getFullPath().equals(executionContext.getWorkspace().getProjectPath())) {
				Provisionner p = new Provisionner();
				IStatus status = p.provisionFromProject(project, null);
				if (!status.isOK()) {
					// return status;
					throw new RuntimeException("Coudln't provision project.");
				}
			}
			bundleName = project.getName();
			bundle = Platform.getBundle(bundleName);

			// If is still doesn't work, it's nowhere to be
			// found, and we have an error
			if (bundle == null)
				throw new RuntimeException("Could not find bundle " + bundleName);
		}

		try {
			c = bundle.loadClass(executionContext.getRunConfiguration().getExecutionEntryPoint());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not find class "
					+ executionContext.getRunConfiguration().getExecutionEntryPoint() + " in bundle " + bundleName
					+ ".");
		}
		final Method method;
		try {
			method = c.getMethod("main", parameters.get(0).getClass().getInterfaces()[0]);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not find method main with correct parameters.");

		}
		final Object caller;
		try {
			caller = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not instanciate class "
					+ executionContext.getRunConfiguration().getExecutionEntryPoint() + ".");
		}

		_entryPoint = new Runnable() {
			@Override
			public void run() {
				StepManagerRegistry.getInstance().registerManager(PlainK3ExecutionEngine.this);
				try {
					method.invoke(caller, parameters.get(0));
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					StepManagerRegistry.getInstance().unregisterManager(PlainK3ExecutionEngine.this);
				}
			}
		};
	}

	@Override
	public Runnable getEntryPoint() {
		return _entryPoint;
	}

	@Override
	/*
	 * This is the operation called from K3 code. We use this callback to pass
	 * the command to the generic executeOperation operation. (non-Javadoc)
	 * 
	 * @see fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager#
	 * executeStep(java.lang.Object,
	 * fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand,
	 * java.lang.String)
	 */
	public void executeStep(Object caller, final StepCommand command, String methodName) {
		executeOperation(caller, methodName, new Runnable() {
			@Override
			public void run() {
				command.execute();
			}
		});
	}

	@Override
	/*
	 * This is the operation used to act as a StepManager in K3. We return true
	 * if we have the same editing domain as the object. (non-Javadoc)
	 * 
	 * @see
	 * fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager#canHandle
	 * (java.lang.Object)
	 */
	public boolean canHandle(Object caller) {
		if (caller instanceof EObject) {
			EObject caller_cast = (EObject) caller;
			org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = getEditingDomain(caller_cast);
			return editingDomain == this.editingDomain;

		}
		return false;
	}

	private static TransactionalEditingDomain getEditingDomain(EObject o) {
		return getEditingDomain(o.eResource().getResourceSet());
	}

	private static InternalTransactionalEditingDomain getEditingDomain(ResourceSet rs) {
		TransactionalEditingDomain edomain = org.eclipse.emf.transaction.TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(rs);
		if (edomain instanceof InternalTransactionalEditingDomain)
			return (InternalTransactionalEditingDomain) edomain;
		else
			return null;
	}
	
	protected LanguageDefinition getLanguageDefinition(String xDSMLFilePath) {
	

		// Loading languagedef model
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createPlatformPluginURI(xDSMLFilePath, true);
		Resource res = rs.createResource(uri);
		try {
			res.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EcoreUtil.resolveAll(rs);// IMPORTANT

		if (res != null) {
			EObject first = res.getContents().get(0);

			// Follow-up in other operation...
			if (first instanceof LanguageDefinition) {
				return (LanguageDefinition) first;
			}
		}
		return null;
	}

	@Override
	public String engineKindName() {
		return "GEMOC Sequential Engine";
	}
}
