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
package fr.obeo.dsl.process;

import fr.obeo.dsl.process.util.ProcessSwitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * {@link Expression} parser.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ExpressionParser {

	/**
	 * Converts an {@link Expression} to a {@link String} that can be parsed by an {@link ExpressionParser}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private static final class ToStringSwitch extends ProcessSwitch<StringBuilder> {

		@Override
		public StringBuilder caseTask(Task task) {
			final StringBuilder res = new StringBuilder();

			res.append('"');
			res.append(StringEscapeUtils.escapeJava(task.getName()));
			res.append('"');

			return res;
		}

		@Override
		public StringBuilder caseAllDone(AllDone allDone) {
			final StringBuilder res = new StringBuilder();

			res.append(allDone.eClass().getName());
			res.append('(');
			for (Task task : allDone.getTasks()) {
				res.append(doSwitch(task));
				res.append(',');
			}
			res.deleteCharAt(res.length() - 1);
			res.append(')');

			return res;
		}

		@Override
		public StringBuilder caseAnyDone(AnyDone anyDone) {
			final StringBuilder res = new StringBuilder();

			res.append(anyDone.eClass().getName());
			res.append('(');
			for (Task task : anyDone.getTasks()) {
				res.append(doSwitch(task));
				res.append(',');
			}
			res.deleteCharAt(res.length() - 1);
			res.append(')');

			return res;
		}

		@Override
		public StringBuilder caseOneDone(OneDone oneDone) {
			final StringBuilder res = new StringBuilder();

			res.append(oneDone.eClass().getName());
			res.append('(');
			for (Task task : oneDone.getTasks()) {
				res.append(doSwitch(task));
				res.append(',');
			}
			res.deleteCharAt(res.length() - 1);
			res.append(')');

			return res;
		}

		@Override
		public StringBuilder caseNot(Not not) {
			final StringBuilder res = new StringBuilder();

			res.append(not.eClass().getName());
			res.append('(');
			if (not.getExpression() != null) {
				res.append(doSwitch(not.getExpression()));
			}
			res.append(')');

			return res;
		}

		@Override
		public StringBuilder caseAnd(And and) {
			final StringBuilder res = new StringBuilder();

			res.append(and.eClass().getName());
			res.append('(');
			for (Expression exp : and.getExpressions()) {
				res.append(doSwitch(exp));
				res.append(',');
			}
			res.deleteCharAt(res.length() - 1);
			res.append(')');

			return res;
		}

		@Override
		public StringBuilder caseOr(Or or) {
			final StringBuilder res = new StringBuilder();

			res.append(or.eClass().getName());
			res.append('(');
			for (Expression exp : or.getExpressions()) {
				res.append(doSwitch(exp));
				res.append(',');
			}
			res.deleteCharAt(res.length() - 1);
			res.append(')');

			return res;
		}

	}

	/**
	 * {@link Expression} to {@link String}.
	 */
	private static final ToStringSwitch SWITCH = new ToStringSwitch();

	/**
	 * {@link Task}'s {@link Task#getName() name} to {@link Task} mapping.
	 */
	private Map<String, Task> possibleTasks;

	/**
	 * The currently parsed {@link EReference} if any, <code>null</code> otherwise.
	 */
	private EReference currentReference;

	/**
	 * The parsed {@link String}.
	 */
	private String text;

	/**
	 * The current offset.
	 */
	private int offset;

	/**
	 * The last position the parser tried to parse an {@link ExpressionParser} or a {@link Task#getName() task
	 * reference}.
	 */
	private int lastStart;

	/**
	 * Sets the text to parse.
	 * 
	 * @param t
	 *            the {@link String} to parse
	 */
	public void setText(final String t) {
		text = t;
		offset = 0;
		lastStart = 0;
		currentReference = null;
	}

	/**
	 * Sets the possible referenced {@link Task tasks}.
	 * 
	 * @param tasks
	 *            the possible referenced {@link Task}
	 */
	public void setPossibleTasks(Collection<Task> tasks) {
		possibleTasks = initPossibleTasks(tasks);
	}

	/**
	 * Initializes the possible {@link Task} mapping with the given {@link Collection}.
	 * 
	 * @param tasks
	 *            the {@link Collection} of {@link Task tasks}
	 * @return the possible {@link Task} mapping
	 */
	private Map<String, Task> initPossibleTasks(Collection<Task> tasks) {
		final Map<String, Task> res = new LinkedHashMap<String, Task>();

		for (Task task : tasks) {
			res.put(task.getName(), task);
		}

		return res;
	}

	/**
	 * Reads an {@link Expression}.
	 * 
	 * @return the recognized {@link Expression} if any, <code>null</code> otherwise
	 */
	public Expression readExpression() {
		Expression res;

		lastStart = offset;
		res = readTasksExpression();
		if (res == null) {
			res = readLogicalExpression();
		}

		if (res == null) {
			error("Error can't read Expression");
		}

		return res;
	}

	/**
	 * Reads a {@link TasksExpression}.
	 * 
	 * @return the recognized {@link TasksExpression} if any, <code>null</code> otherwise
	 */
	public TasksExpression readTasksExpression() {
		TasksExpression res;

		res = readTasksExpression(ProcessPackage.eINSTANCE.getAllDone());
		if (res == null) {
			res = readTasksExpression(ProcessPackage.eINSTANCE.getAnyDone());
			if (res == null) {
				res = readTasksExpression(ProcessPackage.eINSTANCE.getOneDone());
			}
		}

		return res;
	}

	/**
	 * Reads a {@link TasksExpression} for the given {@link EClass operator}.
	 * 
	 * @param operator
	 *            the {@link EClass} sub-classing {@link TasksExpression}
	 * @return the recognized {@link TasksExpression} if any, <code>null</code> otherwise
	 */
	public TasksExpression readTasksExpression(EClass operator) {
		TasksExpression res = null;
		int savedOffset = offset;
		if (offset < text.length()
				&& text.regionMatches(offset, operator.getName(), 0, operator.getName().length())) {
			offset += operator.getName().length();
			final List<Task> operands = new ArrayList<Task>();
			skipWhiteSpaces();
			if (offset < text.length() && text.charAt(offset) == '(') {
				currentReference = ProcessPackage.eINSTANCE.getTasksExpression_Tasks();
				do {
					++offset;
					skipWhiteSpaces();
					Task task = readTaskReference();
					if (task != null) {
						operands.add(task);
					}
					skipWhiteSpaces();
				} while (offset < text.length() && text.charAt(offset) == ',');
			}
			if (offset < text.length() && text.charAt(offset) == ')') {
				++offset;
				res = (TasksExpression)EcoreUtil.create(operator);
				res.getTasks().addAll(operands);
			} else {
				error("Error can't read " + operator.getName());
			}
		}

		if (res == null) {
			offset = savedOffset;
		}

		return res;
	}

	/**
	 * Reads a {@link Task} {@link Task#getName() reference}.
	 * 
	 * @return the referenced {@link Task} if any, <code>null</code> otherwise
	 */
	public Task readTaskReference() {
		Task res = null;
		final int savedOffset = offset;
		lastStart = offset;
		if (offset < text.length() && text.charAt(offset) == '"') {
			++offset;
			while (offset < text.length() && text.charAt(offset) != '"') {
				if (text.charAt(offset) == '\\') {
					++offset;
				}
				++offset;
			}
			if (offset < text.length() && text.charAt(offset) == '"') {
				++offset;
				final String taskName = StringEscapeUtils.unescapeJava(text.substring(savedOffset + 1,
						offset - 1));
				res = possibleTasks.get(taskName);
				if (res == null) {
					offset = savedOffset;
					error("Error can't reference task with name : " + taskName);
				}
			}
		}
		if (res == null) {
			error("Error can't read task reference");
		}
		return res;
	}

	/**
	 * Reads a {@link fr.obeo.dsl.process.Not Not}, {@link fr.obeo.dsl.process.And And}, or
	 * {@link fr.obeo.dsl.process.Or Or}.
	 * 
	 * @return the recognized logical {@link Expression} if any, <code>null</code> otherwise
	 */
	public Expression readLogicalExpression() {
		Expression res;

		res = readLogicalExpression(ProcessPackage.eINSTANCE.getNot(), 1);
		if (res == null) {
			res = readLogicalExpression(ProcessPackage.eINSTANCE.getAnd(), -1);
			if (res == null) {
				res = readLogicalExpression(ProcessPackage.eINSTANCE.getOr(), -1);
			}
		}

		return res;
	}

	/**
	 * Reads a logical {@link Expression} for the given {@link EClass operator}.
	 * 
	 * @param operator
	 *            the {@link EClass}
	 * @param operandLimit
	 *            the maximum number of operand
	 * @return the recognized logical {@link Expression} if any, <code>null</code> otherwise
	 */
	private Expression readLogicalExpression(EClass operator, int operandLimit) {
		Expression res = null;
		int savedOffset = offset;
		if (offset < text.length()
				&& text.regionMatches(offset, operator.getName(), 0, operator.getName().length())) {
			offset += operator.getName().length();
			skipWhiteSpaces();
			final List<Expression> operands = new ArrayList<Expression>();
			if (offset < text.length() && text.charAt(offset) == '(') {
				do {
					++offset;
					skipWhiteSpaces();
					currentReference = getCurrentLogicalReference(operator);
					Expression exp = readExpression();
					currentReference = getCurrentLogicalReference(operator);
					if (exp != null) {
						operands.add(exp);
					}
					skipWhiteSpaces();
				} while ((offset < text.length() && text.charAt(offset) == ',')
						&& operands.size() != operandLimit);
			}
			if (offset < text.length() && text.charAt(offset) == ')') {
				++offset;
				res = createLogicalOperator(operator, operands);
			} else {
				error("Error can't read " + operator.getName());
			}
		}

		if (res == null) {
			offset = savedOffset;
		}

		return res;
	}

	/**
	 * Gets the {@link ExpressionParser#currentReference} for the given operator.
	 * 
	 * @param operator
	 *            the {@link EClass operator}
	 * @return the {@link ExpressionParser#currentReference} for the given operator
	 */
	private EReference getCurrentLogicalReference(EClass operator) {
		final EReference res;

		if (operator == ProcessPackage.eINSTANCE.getNot()) {
			res = ProcessPackage.eINSTANCE.getNot_Expression();
		} else if (operator == ProcessPackage.eINSTANCE.getAnd()) {
			res = ProcessPackage.eINSTANCE.getAnd_Expressions();
		} else if (operator == ProcessPackage.eINSTANCE.getOr()) {
			res = ProcessPackage.eINSTANCE.getOr_Expressions();
		} else {
			throw new IllegalStateException("don't know what to do with " + operator.getName());
		}

		return res;
	}

	/**
	 * Creates the logical operator for the given {@link EClass} and {@link Expression operands}.
	 * 
	 * @param operator
	 *            the {@link EClass} operator
	 * @param operands
	 *            {@link Expression operands}
	 * @return the created logical operator
	 */
	private Expression createLogicalOperator(EClass operator, final List<Expression> operands) {
		final Expression res = (Expression)EcoreUtil.create(operator);
		if (res instanceof Not) {
			((Not)res).setExpression(operands.get(0));
		} else if (res instanceof And) {
			((And)res).getExpressions().addAll(operands);
		} else if (res instanceof Or) {
			((Or)res).getExpressions().addAll(operands);
		}
		return res;
	}

	/**
	 * Skips white spaces.
	 */
	public void skipWhiteSpaces() {
		while (offset < text.length() && Character.isWhitespace(text.charAt(offset))) {
			++offset;
		}
	}

	/**
	 * Throws {@link IllegalStateException} with the given message.
	 * 
	 * @param message
	 *            the error message
	 */
	private void error(String message) {
		throw new IllegalStateException("at " + getOffset() + " - " + message);
	}

	/**
	 * Gets the parsed {@link String}.
	 * 
	 * @return the parsed {@link String}
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the {@link EReference} being parsed when the parser stopped.
	 * 
	 * @return the {@link EReference} being parsed when the parser stopped if any, <code>null</code> otherwise
	 */
	public EReference getEReference() {
		return currentReference;
	}

	/**
	 * Gets the offset being parsed when the parser stopped.
	 * 
	 * @return the offset being parsed when the parser stopped
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * Gets possible {@link Task tasks} that can be referenced.
	 * 
	 * @return possible {@link Task tasks} that can be referenced
	 */
	public List<Task> getPossibleTasks() {
		return new ArrayList<Task>(possibleTasks.values());
	}

	/**
	 * Converts the given {@link Expression} to a {@link String} that can be parsed with an
	 * {@link ExpressionParser}.
	 * 
	 * @param expression
	 *            the {@link Expression} to convert to a {@link String}
	 * @return a {@link String} representing the given {@link Expression} that can be parsed with an
	 *         {@link ExpressionParser}
	 */
	public static String toString(Expression expression) {
		return SWITCH.doSwitch(expression).toString();
	}

	/**
	 * Gets the last position the parser tried to parse an {@link ExpressionParser} or a
	 * {@link Task#getName() task reference}.
	 * 
	 * @return the last position the parser tried to parse an {@link ExpressionParser} or a
	 *         {@link Task#getName() task reference}
	 */
	public int getLastStart() {
		return lastStart;
	}
}
