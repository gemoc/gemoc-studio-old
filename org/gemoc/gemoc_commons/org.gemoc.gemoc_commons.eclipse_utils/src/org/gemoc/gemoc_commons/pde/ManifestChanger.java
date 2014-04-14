package org.gemoc.gemoc_commons.pde;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map.Entry;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.BundleException;

public class ManifestChanger {

	private IFile _manifestFile;
	
	public ManifestChanger(IFile manifestFile) {
		_manifestFile = manifestFile;
	}
	public ManifestChanger(IProject project) {
		this(project.getFile(new Path("META-INF/MANIFEST.MF")));
	}

	private Manifest _manifest;
	private void loadManifest(InputStream in) throws IOException {
		try {
			_manifest =  new Manifest(in);			
		} finally {
			in.close();
		}
	}
	
	public Manifest getManifest() throws IOException, CoreException {
		if (_manifest == null) {
			_manifest = new Manifest();
			loadManifest(_manifestFile.getContents());
		}
		return _manifest;
	}
	
	public void commit() throws IOException, CoreException {
		writeManifest(_manifestFile);
	}
	
	private void writeManifest(OutputStream out) throws IOException {
		// [FT] bypass the writing of the Manifest class because at this date 14/04/2014 there is a bug
		// that inserts new lines that invalidates the file.
		//manifest.write(out);
		StringBuilder builder = new StringBuilder();
		for (Entry<Object, Object> pairs : _manifest.getMainAttributes().entrySet()) {
			builder.append(pairs.getKey());
			builder.append(": ");
			builder.append(pairs.getValue());
			builder.append(System.getProperty("line.separator"));
		}
		out.write(builder.toString().getBytes());			
	}
	
	private void writeManifest(IFile outputFile) throws IOException, CoreException {
		if (_manifest != null) { // manifest null means that no update needed.
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			writeManifest(out);
			ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray());
			outputFile.setContents(is, 1, new NullProgressMonitor());			
		}
	}
	public void addPluginDependency(String plugin) throws BundleException, IOException, CoreException {
		PluginDependency dependency = new PluginDependency(this);
		dependency.add(plugin);
	}
	public void addPluginDependency(String plugin, String version, boolean reexport, boolean overwrite) throws BundleException, IOException, CoreException {
		PluginDependency dependency = new PluginDependency(this);
		dependency.add(plugin, version, reexport, overwrite);
	}
	public void addSingleton() throws BundleException, IOException, CoreException {
		Singleton singleton = new Singleton(this);
		singleton.apply();		
	}
	public void addAttributes(String attributeName, String value){
		_manifest.getMainAttributes().putValue(attributeName, value);
	}
}
