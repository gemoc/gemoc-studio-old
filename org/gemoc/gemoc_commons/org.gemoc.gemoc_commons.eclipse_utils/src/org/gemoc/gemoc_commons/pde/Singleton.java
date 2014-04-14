package org.gemoc.gemoc_commons.pde;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.eclipse.core.runtime.CoreException;
import org.osgi.framework.BundleException;

class Singleton {

	private ManifestChanger _connection;
	
	public Singleton(ManifestChanger connection) {
		_connection = connection;
	}
	
	private Manifest getManifest() throws IOException, CoreException {
		return _connection.getManifest();
	}
	
	public void apply() throws BundleException, IOException, CoreException {
		final String bundleSymbolicNameHeader = "Bundle-SymbolicName";
		Attributes mainAttrs = getManifest().getMainAttributes();
		String value = null;
		for (Object entryName : mainAttrs.keySet()) {
			String header;

			// Get the values safely
			if (entryName instanceof String) {
				header = (String) entryName;
				value = mainAttrs.getValue(header);
			} else if (entryName instanceof Attributes.Name) {
				header = (String) ((Attributes.Name) entryName).toString();
				value = mainAttrs.getValue((Attributes.Name) entryName);
			} else {
				throw new BundleException("Unknown Main Attribute Key type: "
						+ entryName.getClass() + " (" + entryName + ")");
			}

			// loop to the next header if we don't find ours
			if (bundleSymbolicNameHeader.equals(header)){
				break;
			}
		}
		if(value != null && !value.endsWith( ";singleton:=true")){
			// doesn't exist or already have it, so do not try to add the singleton ...
			getManifest().getMainAttributes().putValue(bundleSymbolicNameHeader,
					value + ";singleton:=true");
		}
	}
	
}
