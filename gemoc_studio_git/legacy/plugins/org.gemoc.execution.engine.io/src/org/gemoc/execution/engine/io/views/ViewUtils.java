package org.gemoc.execution.engine.io.views;

import org.eclipse.xtext.util.SimpleAttributeResolver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class ViewUtils {

	public static String eventToString(ModelSpecificEvent mse) {
		StringBuilder builder = new StringBuilder();
		if (mse.getCaller() != null)
		{
			builder.append(mse.getCaller().eClass().getName());
			builder.append("->");
			builder.append(SimpleAttributeResolver.NAME_RESOLVER.apply(mse.getCaller()));
			
		}
		if (mse.getAction() != null)
		{
			builder.append(".");
			builder.append(mse.getAction().getName());			
			builder.append("()");
		}
		return builder.toString();
	}
	
}
