package fr.obeo.dsl.process.edit.tests.provider;

import fr.obeo.dsl.process.provider.CustomActionTaskItemProvider;
import fr.obeo.dsl.process.provider.CustomAllDoneItemProvider;
import fr.obeo.dsl.process.provider.CustomAnyDoneItemProvider;
import fr.obeo.dsl.process.provider.CustomComposedTaskItemProvider;
import fr.obeo.dsl.process.provider.CustomOneDoneItemProvider;
import fr.obeo.dsl.process.provider.CustomProcessItemProviderAdapterFactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests {@link CustomProcessItemProviderAdapterFactory}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CustomProcessItemProviderAdapterFactoryTests {

	/**
	 * The {@link CustomProcessItemProviderAdapterFactory} to test.
	 */
	private final CustomProcessItemProviderAdapterFactory factory = new CustomProcessItemProviderAdapterFactory();

	/**
	 * Tests {@link CustomProcessItemProviderAdapterFactory#createActionTaskAdapter()}.
	 */
	@Test
	public void createActionTaskAdapter() {
		assertTrue(factory.createActionTaskAdapter() instanceof CustomActionTaskItemProvider);
	}

	/**
	 * Tests {@link CustomProcessItemProviderAdapterFactory#createAllDoneAdapter()}.
	 */
	@Test
	public void createAllDoneAdapter() {
		assertTrue(factory.createAllDoneAdapter() instanceof CustomAllDoneItemProvider);
	}

	/**
	 * Tests {@link CustomProcessItemProviderAdapterFactory#createAnyDoneAdapter()}.
	 */
	@Test
	public void createAnyDoneAdapter() {
		assertTrue(factory.createAnyDoneAdapter() instanceof CustomAnyDoneItemProvider);
	}

	/**
	 * Tests {@link CustomProcessItemProviderAdapterFactory#createComposedTaskAdapter()}.
	 */
	@Test
	public void createComposedTaskAdapter() {
		assertTrue(factory.createComposedTaskAdapter() instanceof CustomComposedTaskItemProvider);
	}

	/**
	 * Tests {@link CustomProcessItemProviderAdapterFactory#createOneDoneAdapter()}.
	 */
	@Test
	public void createOneDoneAdapter() {
		assertTrue(factory.createOneDoneAdapter() instanceof CustomOneDoneItemProvider);
	}

}
