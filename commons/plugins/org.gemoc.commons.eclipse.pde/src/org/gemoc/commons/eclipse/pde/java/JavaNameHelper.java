package org.gemoc.commons.eclipse.pde.java;

import java.util.Locale;

public class JavaNameHelper {

	/**
	 * create a string that is a valid java package name based on the input string
	 * @param id
	 * @return
	 */
	public static String getFormattedPackageName(String id) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);
			if (buffer.length() == 0) {
				if (Character.isJavaIdentifierStart(ch))
					buffer.append(Character.toLowerCase(ch));
			} else {
				if (Character.isJavaIdentifierPart(ch) || ch == '.')
					buffer.append(ch);
			}
		}
		return buffer.toString().toLowerCase(Locale.ENGLISH);
	}
}
