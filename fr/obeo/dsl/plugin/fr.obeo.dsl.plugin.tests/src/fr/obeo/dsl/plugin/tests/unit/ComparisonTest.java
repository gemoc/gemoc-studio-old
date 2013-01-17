package fr.obeo.dsl.plugin.tests.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.junit.Before;
import org.junit.Test;

import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.resolver.PluginsResourceFactory;

public class ComparisonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		PhysicalArchitecture v1 = PluginsResourceFactory.createTargetPlatform();
		PhysicalArchitecture v2 = PluginsResourceFactory.createTargetPlatform();

		EMFCompare comparator = EMFCompare.builder().build();
		IComparisonScope scope = EMFCompare.createDefaultScope(v1, v2);

		Comparison comparison = comparator.compare(scope);

		assertEquals(0, comparison.getDifferences().size());

	}

}
