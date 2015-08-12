/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.debug.ide;

import fr.obeo.dsl.debug.provider.CustomDebugItemProviderAdapterFactory;
import fr.obeo.dsl.debug.provider.DebugEditPlugin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.model.Breakpoint;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.Base64;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

/**
 * A breakpoint for DSL models.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLBreakpoint extends Breakpoint {

	/**
	 * The marker type ID.
	 */
	public static final String MARKER_ID = "fr.obeo.dsl.debug.ide.breakpointMarker";

	/**
	 * The image attribute. It's the image {@link Object} from EMF item provider.
	 */
	public static final String IMAGE_ATTRIBUTE = "image";

	/**
	 * {@link URL} marker for image attribute.
	 */
	public static final String URL_MARKER = "url";

	/**
	 * {@link URI} marker for image attribute.
	 */
	public static final String URI_MARKER = "uri";

	/**
	 * The image attribute. It should be a comma separated list of image uri.
	 */
	public static final String TEXT_ATTRIBUTE = "text";

	/**
	 * The default breakpoint image.
	 */
	private static final String FULL_OBJ16_BREAKPOINT = "full/obj16/Breakpoint";

	/**
	 * The {@link String} encoding.
	 */
	private static final String UTF8 = "UTF8";

	/**
	 * The delimiter used to encode and decode the {@link DSLBreakpoint#IMAGE_ATTRIBUTE}.
	 */
	private static final String DELIMITER = ",";

	/**
	 * Creates a {@link IMarker} for {@link DSLBreakpoint}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public final class CreateMarker implements IWorkspaceRunnable {
		/**
		 * Should be persisted.
		 */
		private final boolean persistent;

		/**
		 * The {@link EObject} representing the instruction.
		 */
		private final EObject instruction;

		/**
		 * The {@link IFile} containing the model.
		 */
		private final IFile resource;

		/**
		 * Constructor.
		 * 
		 * @param resource
		 *            the {@link IFile} containing the mode
		 * @param instruction
		 *            the {@link EObject} representing the instruction
		 * @param persistent
		 *            should be persisted
		 */
		public CreateMarker(IFile resource, EObject instruction, boolean persistent) {
			this.persistent = persistent;
			this.instruction = instruction;
			this.resource = resource;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.core.resources.IWorkspaceRunnable#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		public void run(IProgressMonitor monitor) throws CoreException {
			final IMarker marker = resource.createMarker(getMarkerID());
			setMarkerAttibutes(marker, resource, instruction, persistent);
			setMarker(marker);
		}
	}

	/**
	 * The {@link ComposedAdapterFactory} used to provide image and text for markers.
	 */
	private static final ComposedAdapterFactory ADAPTER_FACTORY = initLabelProvider();

	/**
	 * The debug model identifier.
	 */
	private String identifier;

	/**
	 * The instruction {@link URI}.
	 */
	private URI instructionUri;

	/**
	 * Constructor.
	 */
	public DSLBreakpoint() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param identifier
	 *            the debug model identifier
	 * @param instruction
	 *            the {@link EObject} representing the instruction
	 * @param persistent
	 *            should be persisted
	 * @throws CoreException
	 *             if marker can't be installed
	 */
	public DSLBreakpoint(String identifier, EObject instruction, boolean persistent) throws CoreException {
		super();
		this.identifier = identifier;
		this.instructionUri = EcoreUtil.getURI(instruction);
		final URI resourceURI = ((EObject)instruction).eResource().getURI();
		final String pathString = resourceURI.toPlatformString(true);
		final IFile resource = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(pathString));

		if (resource != null) {
			IWorkspaceRunnable runnable = new CreateMarker(resource, instruction, persistent);
			run(getMarkerRule(resource), runnable);
		}
	}

	@Override
	public void setMarker(IMarker marker) throws CoreException {
		super.setMarker(marker);
		try {
			identifier = (String)getMarker().getAttribute(IBreakpoint.ID);
			String attribute = (String)getMarker().getAttribute(EValidator.URI_ATTRIBUTE);
			if (attribute != null) {
				instructionUri = URI.createURI(attribute, true);
			}
		} catch (CoreException e) {
			Activator.getDefault().error(e);
		}

	}

	/**
	 * Initializes the {@link ComposedAdapterFactory} used for markers.
	 * 
	 * @return the {@link ComposedAdapterFactory} used for markers
	 */
	private static ComposedAdapterFactory initLabelProvider() {
		final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		CustomDebugItemProviderAdapterFactory debugFactory = new CustomDebugItemProviderAdapterFactory();
		adapterFactory.addAdapterFactory(debugFactory);
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		return adapterFactory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return identifier;
	}

	/**
	 * Gets the {@link URI} representing the instruction.
	 * 
	 * @return the {@link URI} representing the instruction
	 */
	public URI getURI() {
		return instructionUri;
	}

	/**
	 * Gets the image {@link Object} from EMF item provider.
	 * 
	 * @return the image {@link Object} from EMF item provider
	 */
	public Object getImage() {
		Object res = null;
		try {
			final String attribute = (String)getMarker().getAttribute(IMAGE_ATTRIBUTE);
			if (attribute != null && attribute.length() > 0) {
				res = fromAttribute(attribute);
			}
		} catch (CoreException e) {
			res = DebugEditPlugin.INSTANCE.getImage(FULL_OBJ16_BREAKPOINT);
			Activator.getDefault().error(e);
		}
		return res;
	}

	/**
	 * Decodes the {@link DSLBreakpoint#IMAGE_ATTRIBUTE}.
	 * 
	 * @param attribute
	 *            the attribute {@link String}
	 * @return the image Object
	 */
	private static Object fromAttribute(String attribute) {
		Object res;
		try {
			final String[] urls = attribute.split(DELIMITER);
			if (urls.length > 1) {
				final List<Object> images = new ArrayList<Object>(urls.length);
				for (String url : urls) {
					final String decoded = new String(Base64.decode(url), UTF8);
					images.add(fromString(decoded));
				}
				res = new ComposedImage(images);
			} else if (urls.length > 0) {
				final String decoded = new String(Base64.decode(urls[0]), UTF8);
				res = fromString(decoded);
			} else {
				res = DebugEditPlugin.INSTANCE.getImage(FULL_OBJ16_BREAKPOINT);
			}
		} catch (IOException e) {
			res = DebugEditPlugin.INSTANCE.getImage(FULL_OBJ16_BREAKPOINT);
			Activator.getDefault().error(e);
		}
		return res;
	}

	/**
	 * Converts the the given decoded attribute into an URI or an URL.
	 * 
	 * @param decoded
	 *            the fragment of decoded string from the attribute
	 * @return an URI or an URL
	 * @throws MalformedURLException
	 *             if URL can't be deserialized
	 */
	private static Object fromString(final String decoded) throws MalformedURLException {
		final Object res;
		if (decoded.startsWith(URL_MARKER)) {
			res = new URL(decoded.substring(URL_MARKER.length()));
		} else if (decoded.startsWith(URI_MARKER)) {
			res = URI.createURI(decoded.substring(URI_MARKER.length()));
		} else {
			res = DebugEditPlugin.INSTANCE.getImage(FULL_OBJ16_BREAKPOINT);
		}
		return res;
	}

	/**
	 * Encodes the {@link DSLBreakpoint#IMAGE_ATTRIBUTE}.
	 * 
	 * @param image
	 *            the {@link Object} image
	 * @return the attribute {@link String}
	 * @throws IOException
	 *             if encoding fails
	 */
	private static String toAttribute(Object image) throws IOException {
		final String res;

		StringBuffer buffer = new StringBuffer();
		if (image instanceof ComposedImage) {
			toAttribute(buffer, (ComposedImage)image);
			if (buffer.length() != 0) {
				res = buffer.substring(0, buffer.length() - 1);
			} else {
				res = buffer.toString();
			}
		} else if (image instanceof URL) {
			buffer.append(Base64.encode((URL_MARKER + (URL)image).toString().getBytes(UTF8)));
			res = buffer.toString();
		} else if (image instanceof URI) {
			buffer.append(Base64.encode(((URI_MARKER + (URI)image).toString()).getBytes(UTF8)));
			res = buffer.toString();
		} else {
			res = toAttribute(DebugEditPlugin.INSTANCE.getImage(FULL_OBJ16_BREAKPOINT));
		}

		return res;
	}

	/**
	 * Encodes the given {@link ComposedImage}.
	 * 
	 * @param buffer
	 *            the result {@link StringBuffer}
	 * @param image
	 *            the {@link ComposedImage}
	 * @throws IOException
	 *             if encoding fails
	 */
	private static void toAttribute(StringBuffer buffer, ComposedImage image) throws IOException {
		for (Object object : image.getImages()) {
			if (object instanceof ComposedImage) {
				toAttribute(buffer, (ComposedImage)image);
			} else if (object instanceof URL) {
				buffer.append(Base64.encode(((URL)object).toString().getBytes(UTF8)));
			}
			buffer.append(DELIMITER);
		}
	}

	/**
	 * Gets the text {@link String} from EMF item provider.
	 * 
	 * @return the text {@link String} from EMF item provider
	 */
	public String getText() {
		String res = null;
		try {
			res = (String)getMarker().getAttribute(TEXT_ATTRIBUTE);
		} catch (CoreException e) {
			Activator.getDefault().error(e);
		}
		return res;
	}

	/**
	 * Gets the marker ID.
	 * 
	 * @return the marker ID
	 */
	protected String getMarkerID() {
		return MARKER_ID;
	}

	/**
	 * Sets attributes for the given {@link IMarker}.
	 * 
	 * @param marker
	 *            the {@link IMarker}
	 * @param resource
	 *            the {@link IFile} containing the mode
	 * @param instruction
	 *            the {@link EObject} representing the instruction
	 * @param persistent
	 *            should be persisted
	 * @throws CoreException
	 *             if attributes can't be set
	 */
	protected void setMarkerAttibutes(final IMarker marker, IFile resource, EObject instruction,
			boolean persistent) throws CoreException {
		final IItemLabelProvider provider = (IItemLabelProvider)ADAPTER_FACTORY.adapt(instruction,
				IItemLabelProvider.class);
		marker.setAttribute(IBreakpoint.ENABLED, true);
		marker.setAttribute(IBreakpoint.PERSISTED, persistent);
		marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
		marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(instruction).toString());
		final String instructionText = provider.getText(instruction);
		marker.setAttribute(IMarker.MESSAGE, "DSL Breakpoint: " + resource.getFullPath() + " ["
				+ instructionText + "]");
		try {
			marker.setAttribute(IMAGE_ATTRIBUTE, toAttribute(provider.getImage(instruction)));
		} catch (IOException e) {
			Activator.getDefault().error(e);
		}
		marker.setAttribute(TEXT_ATTRIBUTE, instructionText);
	}

}
