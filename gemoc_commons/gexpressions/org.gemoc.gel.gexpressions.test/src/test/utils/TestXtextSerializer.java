package test.utils;

import org.eclipse.xtext.serializer.impl.Serializer;
import org.gemoc.gel.gexpressions.GAdditionExpression;
import org.gemoc.gel.gexpressions.GIntegerExpression;
import org.gemoc.gel.gexpressions.GStringExpression;
import org.gemoc.gel.gexpressions.GexpressionsFactory;
import org.gemoc.gel.gexpressions.xtext.GExpressionsStandaloneSetup;

import com.google.inject.Injector;

public class TestXtextSerializer {

	public static void main(String[] args) {
		// Getting the serializer
		GExpressionsStandaloneSetup setup = new GExpressionsStandaloneSetup();
		Injector injector = setup.createInjectorAndDoEMFRegistration();
		Serializer serializer = injector.getInstance(Serializer.class);

		// Creating a model
		GexpressionsFactory factory = GexpressionsFactory.eINSTANCE;
		GAdditionExpression exp = factory.createGAdditionExpression();
		GIntegerExpression un = factory.createGIntegerExpression();
		un.setValue(1);
		GStringExpression deux = factory.createGStringExpression();
		deux.setValue("deux");
		exp.setLeftOperand(un);
		exp.setRightOperand(deux);

		// Serializing
		String s = serializer.serialize(exp);
		System.out.println(s);
	}
}
