package org.gemoc.execution.engine.emfexecution.manager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.gemoc.execution.engine.emfexecution.Activator;
import org.osgi.framework.Bundle;


/**
 * @author Benoit Ferrero
 * 
 */
public class ProjectClassLoader {

	public ProjectClassLoader() {
		super();

	}

	private static final class PrivilegedExceptionActionClassLoader implements
			PrivilegedExceptionAction<URLClassLoader> {

		public PrivilegedExceptionActionClassLoader(URL[] _urlPaths, Bundle _b[]) {
			super();
			this.urlPaths = _urlPaths;
			this.b = _b;
			this.parent = null;
		}

		public PrivilegedExceptionActionClassLoader(URL[] _urlPaths, Bundle _b[], ClassLoader parent) {
			super();
			this.urlPaths = _urlPaths;
			this.b = _b;
			this.parent = parent;
		}

		private URL urlPaths[];
		private Bundle b[];
		private ClassLoader parent = null;

		/*
		 * Builds and returns a (non-Javadoc)
		 * 
		 * @see java.security.PrivilegedExceptionAction#run()
		 */
		public URLClassLoader run() throws Exception {

			return new MyUrlClassLoader(b, urlPaths, (parent != null ? parent : Thread
					.currentThread().getContextClassLoader()));
		}
	}

	/**
	 * A class loader object that uses a list of Bundles to ask to each of them
	 * to load a class, before forwarding the request to its parent in the
	 * inheritance hierarchy (URLClassLoader)
	 * 
	 * @see URLClassLoader#loadClass(String)
	 * @author Benoit Ferrero
	 */
	private static final class MyUrlClassLoader extends URLClassLoader {
		private Bundle tb[];

		public MyUrlClassLoader(Bundle b[], URL[] urls, ClassLoader parent) {
			super(urls, parent);
			tb = b;
		}

		@Override
		protected synchronized Class<?> loadClass(String name, boolean resolve)
				throws ClassNotFoundException {
			// First ask to each bundle to load itself the class. If it
			// succeeds, returns this class.
			for (Bundle b : tb) {
				try {
					// System.out.println("search " +name +" in " +
					// b.getSymbolicName());
					Class<?> c = b.loadClass(name);
					if (c != null) {
						return c;
					}
				} catch (Throwable e) {
				}
			}
			// Finally, try to search in the URLs array given at construction
			// time.
			return super.loadClass(name, resolve);
		}

		@Override
		protected void finalize() throws Throwable {
			super.finalize();
		}

	}

	public URLClassLoader getProjectClassLoader(IJavaElement javaElement) {
		IJavaProject javaProject = (javaElement != null ? javaElement.getJavaProject() : null);
		return getProjectClassLoader(javaProject);
	}

	private HashMap<IJavaProject, URLClassLoader> projectClassLoaderCache = new HashMap<IJavaProject, URLClassLoader>();

	/**
	 * Builds and returns a ClassLoader object that search for classes in the
	 * classpath of the project argument, plus the classpaths of the required
	 * projects. This class maintains a map between projects and class loaders,
	 * so that class loaders are not recreated.
	 * 
	 * @param project
	 *            a JDT project object.
	 * @return a ClassLoader object. The search paths of this loader are built
	 *         from the classpath of the projet, plus all the classpath of the
	 *         required projects of the project, and recursively down to the
	 *         bottom of the requirement hierarchy.
	 */
	public URLClassLoader getProjectClassLoader(IJavaProject project) {
		try {
			if (project != null) {
				// cache lookup, if an entry already exists then return it
				URLClassLoader uRLClassLoader = projectClassLoaderCache.get(project);
				if (uRLClassLoader != null)
					return uRLClassLoader;
				// compute the search path of the classloader.
				ArrayList<URL> pathElements = getProjectClassPathURLs(project);
				List<Bundle> pluginreq = getProjectRequiredPlugins(project);
				// Build arrays from the lists : the classloader object to be
				// built uses arrays.
				URL urlPaths[] = pathElements.toArray(new URL[pathElements.size()]);
				Bundle b[] = pluginreq.toArray(new Bundle[] {});
				// Build the classloader object.
				uRLClassLoader = AccessController
						.doPrivileged(new PrivilegedExceptionActionClassLoader(urlPaths, b /*,
								getClass().getClassLoader() */));

				projectClassLoaderCache.put(project, uRLClassLoader);
				return uRLClassLoader;
			}
			else {
				URL urlPaths[] = new URL[0];
				//ArrayList<Bundle> bundles = new ArrayList<Bundle>();
				Bundle b[] = new Bundle[1];
				b[0] = Activator.getDefault().getBundle();
				
				URLClassLoader uRLClassLoader = AccessController
						.doPrivileged(new PrivilegedExceptionActionClassLoader(urlPaths, b,
								getClass().getClassLoader()));
				return uRLClassLoader;
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Throwable e) {

			throw new RuntimeException(e);
		}
	}

	private static URL getRawLocationURL(IPath simplePath) throws MalformedURLException {
		File file = getRawLocationFile(simplePath);
		return file.toURI().toURL();
	}

	private static File getRawLocationFile(IPath simplePath) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(simplePath);
		File file = null;
		if (resource != null) {
			file = ResourcesPlugin.getWorkspace().getRoot().findMember(simplePath).getRawLocation()
					.toFile();
		} else {
			file = simplePath.toFile();
		}
		return file;
	}

	/**
	 * Returns the list of all the required bundles of the project, as described
	 * by the Require-bundle: clause in the manifest of the project.
	 * 
	 * @param project
	 * @return a list of {@link Bundle}. The list may be empty.
	 */
	private List<Bundle> getProjectRequiredPlugins(IJavaProject project) {
		List<Bundle> bundles = new ArrayList<Bundle>();
		try {
			IPluginModelBase model = PluginRegistry.findModel(project.getProject());
			if (model == null) {
				// the project is either not a plugin project, or has a
				// malformed MANIFEST
				return bundles;
			}
			BundleDescription desc = model.getBundleDescription();
			if (desc == null) {
				// the plugin project is not an OSGI plugin. Should not happen
				// nowadays...
				return bundles;
			}
			BundleSpecification[] requiredBundles = desc.getRequiredBundles();
			for (BundleSpecification required : requiredBundles) {
				try {
					String s = required.getName();
					Bundle b = Platform.getBundle(s);
					if (b != null) {
						bundles.add(b);
					}
				} catch (Throwable e) {

				}
			}

		} catch (Throwable t) {

		}
		return bundles;
	}

	/**
	 * Map between project objects and all the URL that are in the classpath of
	 * the project. Used as a cache to avoid recomputing all these URLs.
	 */
	private HashMap<IJavaProject, ArrayList<URL>> projectClasspathCache = new HashMap<IJavaProject, ArrayList<URL>>();

	/**
	 * @param project
	 * @return
	 */
	private ArrayList<URL> getProjectClassPathURLs(IJavaProject project) {

		ArrayList<URL> pathElements = null;
		// do a cache lookup and return what is found, if any...
		pathElements = projectClasspathCache.get(project);
		if (pathElements != null)
			return pathElements;
		// build the list and store it in the cache.
		pathElements = new ArrayList<URL>();
		projectClasspathCache.put(project, pathElements);
		try {
			IClasspathEntry[] paths = project.getResolvedClasspath(true);
			Set<IPath> outputPaths = new HashSet<IPath>();
			if (paths != null) {
				for (int i = 0; i < paths.length; i++) {
					IClasspathEntry path = paths[i];
					if (path.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
						URL url = getRawLocationURL(path.getPath());
						pathElements.add(url);
					} else if (path.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						IPath output = path.getOutputLocation();
						if (path.getOutputLocation() != null) {
							outputPaths.add(output);
						}
					}
				}
			}
			IPath location = getProjectLocation(project.getProject());
			IPath outputPath = location.append(project.getOutputLocation().removeFirstSegments(1));
			pathElements.add(0, outputPath.toFile().toURI().toURL());

			for (IPath path : outputPaths) {
				outputPath = location.append(path.removeFirstSegments(1));
				pathElements.add(0, outputPath.toFile().toURI().toURL());
			}

			// Also add classpath of required projects.
			String[] names = project.getRequiredProjectNames();
			for (int i = 0; i < names.length; i++) {
				String projectName = names[i];
				IProject reqProject = project.getProject().getWorkspace().getRoot()
						.getProject(projectName);
				if (reqProject != null) {
					IJavaProject reqJavaProject = JavaCore.create(reqProject);
					pathElements.addAll(getProjectClassPathURLs(reqJavaProject));
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return pathElements;
	}

	private IPath getProjectLocation(IProject project) {
		if (project.getRawLocation() == null) {
			return project.getLocation();
		} else {
			return project.getRawLocation();
		}
	}

	public void clearCaches() {
		projectClassLoaderCache.clear();
		projectClasspathCache.clear();
	}
}
