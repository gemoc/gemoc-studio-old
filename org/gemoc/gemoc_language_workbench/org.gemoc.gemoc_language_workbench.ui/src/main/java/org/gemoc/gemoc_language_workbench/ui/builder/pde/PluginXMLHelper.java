package org.gemoc.gemoc_language_workbench.ui.builder.pde;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.ContentFilter;
import org.jdom2.filter.ElementFilter;
import org.jdom2.filter.Filter;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class PluginXMLHelper {

	public static final String PLUGIN_FILENAME = "plugin.xml";

	public static final String PLUGIN_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<?eclipse version=\"3.4\"?>\n" + "<plugin>\n" + "</plugin>";

	public static void createEmptyTemplateFile(IFile pluginXmlFile,
			boolean overrideIfExist) {
		if (overrideIfExist && pluginXmlFile.exists()) {
			try {
				pluginXmlFile.delete(true, null);
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		if (!pluginXmlFile.exists()) {
			try {
				InputStream stream = new ByteArrayInputStream(
						PLUGIN_TEMPLATE.getBytes());
				if (pluginXmlFile.exists()) {
					pluginXmlFile.setContents(stream, true, true, null);
				} else {
					pluginXmlFile.create(stream, true, null);
				}
				stream.close();
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
	}

	protected Document document;
	protected Element root;

	public void loadDocument(IFile pluginXmlFile) {
		SAXBuilder sxb = new SAXBuilder();
		try {
			document = sxb.build(pluginXmlFile.getContents());

			root = document.getRootElement();
		} catch (Exception e) {
			Activator.error(e.getMessage(), e);
		}
	}

	public void saveDocument(IFile pluginXmlFile) {
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

			ByteArrayOutputStream stream = new ByteArrayOutputStream();

			sortie.output(document, stream);
			InputStream inputStream = new ByteArrayInputStream(
					stream.toByteArray());
			pluginXmlFile.setContents(inputStream, IResource.FORCE, null);
		} catch (IOException e) {
			Activator.error(e.getMessage(), e);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
	
	public Element updateXDSMLDefinitionInExtensionPoint(Element extensionPoint, String xDSMLName){
		Element result;
		List<Element> elements = extensionPoint.getContent(new ElementFilter(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF));
		if(elements.size() == 0){
			// create extension point
			result = new Element(Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF);
			extensionPoint.addContent(result);
		}
		else{
			result = elements.get(0);
		}
		result.setAttribute("name", xDSMLName);
		return result;
	}
	
	public Element getOrCreateExtensionPoint(String extensionPointName){
		Element result;
		List<Element> elements = root.getContent(new ExtensionFilter(extensionPointName));
		if(elements.size() == 0){
			// create extension point
			result = new Element("extension");
			result.setAttribute("point", extensionPointName);
			root.addContent(result);
		}
		else{
			result = elements.get(0);
		}
		return result;
	}

	public class ExtensionFilter extends ElementFilter{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1941823619643486082L;
		protected String extensionPointName;
		
		public ExtensionFilter(String extensionPointName){
			super("extension");
			this.extensionPointName = extensionPointName;
		}
			
		@Override
		public Element filter(Object content) {
			Element result = super.filter(content);
			if(result == null) return null;
			Attribute att = result.getAttribute("point");
			if(att == null) return null;
			if(att.getValue().equals(extensionPointName)) return result;
			else return null;
		}
		
	}
	

	
}
