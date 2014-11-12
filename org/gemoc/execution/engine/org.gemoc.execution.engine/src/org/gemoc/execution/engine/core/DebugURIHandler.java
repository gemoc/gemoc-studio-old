package org.gemoc.execution.engine.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

/**
 * Creates {@link InputStream} from the worskpace and {@link OutputStream} to
 * nowhere. This prevent saving files.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public final class DebugURIHandler extends URIHandlerImpl implements URIHandler {

	@Override
	public boolean canHandle(URI uri) {
		return !uri.fileExtension().equals("trace");
	}

	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		final OutputStream res = new OutputStream() {

			@Override
			public void write(int b) throws IOException {
				// noting to do here
			}
		};
		return res;
	}

}