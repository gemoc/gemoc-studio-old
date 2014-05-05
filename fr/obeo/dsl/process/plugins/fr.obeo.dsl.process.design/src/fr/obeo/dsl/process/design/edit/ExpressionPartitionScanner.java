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

import fr.obeo.dsl.process.ProcessPackage;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.Color;

/**
 * {@link fr.obeo.dsl.process.Expression Expression}
 * {@link org.eclipse.jface.text.rules.IPartitionTokenScanner IPartitionTokenScanner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ExpressionPartitionScanner extends RuleBasedPartitionScanner {

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.Task Task} {@link fr.obeo.dsl.process.Task#getName()
	 * reference}.
	 */
	private final IToken taskRefToken;

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.AllDone AllDone}.
	 */
	private final IToken allDoneToken;

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.AnyDone AnyDone}.
	 */
	private final IToken anyDoneToken;

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.OneDone OneDone}.
	 */
	private final IToken oneDoneToken;

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.Not Not}.
	 */
	private final IToken notToken;

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.And And}.
	 */
	private final IToken andToken;

	/**
	 * The {@link IToken} for {@link fr.obeo.dsl.process.Or Or}.
	 */
	private final IToken orToken;

	/**
	 * The {@link IToken} for <code>','</code>.
	 */
	private final IToken commaToken;

	/**
	 * The {@link IToken} for <code>'('</code>.
	 */
	private final IToken openingParentethisToken;

	/**
	 * The {@link IToken} for <code>')'</code>.
	 */
	private final IToken closingParentethisToken;

	/**
	 * Constructor.
	 * 
	 * @param taskRefColor
	 *            the {@link Color} for {@link fr.obeo.dsl.process.Task Task}
	 *            {@link fr.obeo.dsl.process.Task#getName() reference}
	 * @param expressionColor
	 *            the {@link Color} for {@link fr.obeo.dsl.process.Expression Expression} keyword
	 * @param ponctuationColor
	 *            the {@link Color} for punctuation
	 */
	public ExpressionPartitionScanner(Color taskRefColor, Color expressionColor, Color ponctuationColor) {
		taskRefToken = new Token(new TextAttribute(taskRefColor));
		allDoneToken = new Token(new TextAttribute(expressionColor));
		anyDoneToken = new Token(new TextAttribute(expressionColor));
		oneDoneToken = new Token(new TextAttribute(expressionColor));
		notToken = new Token(new TextAttribute(expressionColor));
		andToken = new Token(new TextAttribute(expressionColor));
		orToken = new Token(new TextAttribute(expressionColor));
		commaToken = new Token(new TextAttribute(ponctuationColor));
		openingParentethisToken = new Token(new TextAttribute(ponctuationColor));
		closingParentethisToken = new Token(new TextAttribute(ponctuationColor));

		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();
		addTastRefRule(rules);
		addKeywordRules(rules);
		addParenthesisRule(rules);
		addCommaRule(rules);
		addWhiteSpaceRule(rules);
		setPredicateRules(rules.toArray(new IPredicateRule[rules.size()]));
	}

	/**
	 * Add {@link IPredicateRule} for {@link fr.obeo.dsl.process.Expression Expression} keyword.
	 * 
	 * @param rules
	 *            the {@link List} of {@link IPredicateRule}
	 */
	private void addKeywordRules(List<IPredicateRule> rules) {
		rules.add(new KeywordRule(ProcessPackage.eINSTANCE.getAllDone().getName(), allDoneToken));
		rules.add(new KeywordRule(ProcessPackage.eINSTANCE.getAnyDone().getName(), anyDoneToken));
		rules.add(new KeywordRule(ProcessPackage.eINSTANCE.getOneDone().getName(), oneDoneToken));
		rules.add(new KeywordRule(ProcessPackage.eINSTANCE.getNot().getName(), notToken));
		rules.add(new KeywordRule(ProcessPackage.eINSTANCE.getAnd().getName(), andToken));
		rules.add(new KeywordRule(ProcessPackage.eINSTANCE.getOr().getName(), orToken));
	}

	/**
	 * Add {@link IPredicateRule} for {@link fr.obeo.dsl.process.Task Task}
	 * {@link fr.obeo.dsl.process.Task#getName() reference}.
	 * 
	 * @param rules
	 *            the {@link List} of {@link IPredicateRule}
	 */
	private void addTastRefRule(List<IPredicateRule> rules) {
		final PatternRule taskRef = new PatternRule("\"", "\"", taskRefToken, '\\', true);
		rules.add(taskRef);
	}

	/**
	 * Add {@link IPredicateRule} for comma.
	 * 
	 * @param rules
	 *            the {@link List} of {@link IPredicateRule}
	 */
	private void addCommaRule(List<IPredicateRule> rules) {
		final IPredicateRule comma = new IPredicateRule() {

			public IToken evaluate(ICharacterScanner scanner) {
				return evaluate(scanner, false);
			}

			public IToken getSuccessToken() {
				return commaToken;
			}

			public IToken evaluate(ICharacterScanner scanner, boolean resume) {
				final IToken res;

				if (scanner.read() == ',') {
					res = getSuccessToken();
				} else {
					scanner.unread();
					res = Token.UNDEFINED;
				}

				return res;
			}
		};
		rules.add(comma);
	}

	/**
	 * Add {@link IPredicateRule} for parenthesis.
	 * 
	 * @param rules
	 *            the {@link List} of {@link IPredicateRule}
	 */
	private void addParenthesisRule(List<IPredicateRule> rules) {
		final IPredicateRule openingParentethis = new IPredicateRule() {

			public IToken evaluate(ICharacterScanner scanner) {
				return evaluate(scanner, false);
			}

			public IToken getSuccessToken() {
				return openingParentethisToken;
			}

			public IToken evaluate(ICharacterScanner scanner, boolean resume) {
				final IToken res;

				if (scanner.read() == '(') {
					res = getSuccessToken();
				} else {
					scanner.unread();
					res = Token.UNDEFINED;
				}

				return res;
			}
		};
		rules.add(openingParentethis);
		final IPredicateRule closingParentethis = new IPredicateRule() {

			public IToken evaluate(ICharacterScanner scanner) {
				return evaluate(scanner, false);
			}

			public IToken getSuccessToken() {
				return closingParentethisToken;
			}

			public IToken evaluate(ICharacterScanner scanner, boolean resume) {
				final IToken res;

				if (scanner.read() == ')') {
					res = getSuccessToken();
				} else {
					scanner.unread();
					res = Token.UNDEFINED;
				}

				return res;
			}
		};
		rules.add(closingParentethis);
	}

	/**
	 * Add {@link IPredicateRule} for white space.
	 * 
	 * @param rules
	 *            the {@link List} of {@link IPredicateRule}
	 */
	private void addWhiteSpaceRule(List<IPredicateRule> rules) {
		IPredicateRule whitespaceRule = new IPredicateRule() {

			public IToken evaluate(ICharacterScanner scanner) {
				return evaluate(scanner, false);
			}

			public IToken getSuccessToken() {
				return Token.WHITESPACE;
			}

			public IToken evaluate(ICharacterScanner scanner, boolean resume) {
				final IToken res;

				if (Character.isWhitespace(scanner.read())) {
					res = getSuccessToken();
				} else {
					res = Token.UNDEFINED;
				}

				return res;
			}
		};
		rules.add(whitespaceRule);
	}
}
