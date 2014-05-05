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
package fr.obeo.dsl.process.design.edit;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

/**
 * Scans a given keyword.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class KeywordRule implements IPredicateRule {

	/**
	 * The keyword to scan.
	 */
	private final String keyword;

	/**
	 * The {@link IToken} is success.
	 */
	private final IToken token;

	/**
	 * Constructor.
	 * 
	 * @param keyword
	 *            the keyword to scan
	 * @param token
	 *            the successful {@link IToken}
	 */
	public KeywordRule(String keyword, IToken token) {
		this.keyword = keyword;
		this.token = token;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.rules.IRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner)
	 */
	public IToken evaluate(ICharacterScanner scanner) {
		return evaluate(scanner, false);
	}

	public IToken getSuccessToken() {
		return token;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.rules.IPredicateRule#evaluate(org.eclipse.jface.text.rules.ICharacterScanner,
	 *      boolean)
	 */
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		final IToken res;

		int i;
		for (i = 0; i < keyword.length(); ++i) {
			final char c = (char)scanner.read();
			if (keyword.charAt(i) != c) {
				break;
			}
		}

		if (i == keyword.length()) {
			res = getSuccessToken();
		} else {
			do {
				scanner.unread();
				--i;
			} while (i >= 0);
			res = Token.UNDEFINED;
		}

		return res;
	}

}
