package fr.obeo.dsl.sirius.animation.uml.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.junit.Before;
import org.junit.Test;

import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.uml.AnimateUMLStateMachine;

public class UMLStateMachineTest {

	Model model;

	ResourceSet set = new ResourceSetImpl();

	private AnimateUMLStateMachine animator;

	@Before
	public void setUp() throws Exception {
		UMLUtil.init(set);
		set.getPackageRegistry()
				.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		Resource res = loadFromClassLoader("model.uml");
		model = (Model) res.getContents().get(0);
		animator = new AnimateUMLStateMachine();
	}

	@Test
	public void test() {
		AnimationTarget animation = animator.start(set);
		animator.stepOver(animation.getThreads().get(0).getTopStackFrame());
		fail("Not yet implemented");
	}

	/**
	 * Tries and locate a model in the current class' classpath.
	 * 
	 * @param string
	 *            Relative path to the model we seek (relative to this class).
	 * @return The loaded resource.
	 * @throws IOException
	 *             Thrown if we could not access either this class' resource, or
	 *             the file towards which <code>string</code> points.
	 */
	protected Resource loadFromClassLoader(String string) throws IOException {
		final URL fileURL = getClass().getResource(string);
		final InputStream str = fileURL.openStream();
		final URI uri = URI.createURI(fileURL.toString());

		Resource.Factory resourceFactory = set
				.getResourceFactoryRegistry().getFactory(uri);
		if (resourceFactory == null) {
			// Most likely a standalone run. Try with a plain XMI resource
			set.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put("uml", new UMLResourceFactoryImpl());
		}

		Resource res = set.createResource(uri);
		res.load(str, Collections.emptyMap());
		str.close();
		return res;
	}

}
