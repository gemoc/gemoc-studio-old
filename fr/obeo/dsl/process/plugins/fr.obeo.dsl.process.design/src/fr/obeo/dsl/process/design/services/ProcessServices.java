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
package fr.obeo.dsl.process.design.services;

import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;

/**
 * Services class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ProcessServices {

	/**
	 * Tells if the given {@link ComposedTask} has a {@link DDiagram} representing it.
	 * 
	 * @param composedTask
	 *            the {@link ComposedTask}
	 * @return <code>true</code> if the given {@link ComposedTask} has a {@link DDiagram} representing it,
	 *         <code>false</code> otherwise
	 */
	public boolean hasDiagram(ComposedTask composedTask) {
		boolean res = false;

		final Session session = SessionManager.INSTANCE.getSession(composedTask);
		final ECrossReferenceAdapter crossReferencer = session.getSemanticCrossReferencer();
		final Collection<Setting> settings = crossReferencer.getInverseReferences(composedTask);
		for (Setting setting : settings) {
			if (setting.getEStructuralFeature() == ViewpointPackage.eINSTANCE.getDSemanticDecorator_Target()
					&& setting.getEObject() instanceof DDiagram) {
				res = true;
				break;
			}
		}

		return res;
	}

	/**
	 * Tells if the given {@link ComposedTask} has no {@link DDiagram} representing it.
	 * 
	 * @param composedTask
	 *            the {@link ComposedTask}
	 * @return <code>true</code> if the given {@link ComposedTask} has no {@link DDiagram} representing it,
	 *         <code>false</code> otherwise
	 */
	public boolean hasNoDiagram(ComposedTask composedTask) {
		return !hasDiagram(composedTask);
	}

	/**
	 * Tells if the given {@link Task tasks} are at the same level.
	 * 
	 * @param task1
	 *            the first {@link Task}
	 * @param task2
	 *            the second {@link Task}
	 * @return <code>true</code> if the given {@link Task tasks} are at the same level, <code>false</code>
	 *         otherwise
	 */
	public boolean atSameLevel(Task task1, Task task2) {
		return ProcessUtils.atSameLevel(task1, task2);
	}

	/**
	 * Tells if the following edge is mandatory.
	 * 
	 * @param source
	 *            the source {@link Task}
	 * @param target
	 *            the target {@link Task}
	 * @return <code>true</code> if the following edge is mandatory, <code>false</code> otherwise
	 */
	public boolean followingEdgeIsMandatory(Task source, Task target) {
		return ProcessUtils.isMandatoryInPrecondition(source, target);
	}

	/**
	 * Tells if the initial edge is mandatory.
	 * 
	 * @param target
	 *            the target {@link ComposedTask}
	 * @return <code>true</code> if the initial edge is mandatory, <code>false</code> otherwise
	 */
	public boolean initialEdgeIsMandatory(Task target) {
		return target.getPrecondition() == null
				|| ProcessUtils.getMantadoryTasks(target.getPrecondition()).size() != 0;
	}

	/**
	 * Tells if the final edge is mandatory.
	 * 
	 * @param target
	 *            the target {@link ComposedTask}
	 * @param source
	 *            the source {@link Task}
	 * @return <code>true</code> if the final edge is mandatory, <code>false</code> otherwise
	 */
	public boolean finalEdgeIsMandatory(ComposedTask target, Task source) {
		return ProcessUtils.isMandatoryInDoneExpression(source, target);
	}

	/**
	 * Tells if the given {@link DSemanticDecorator decorators} only {@link DSemanticDecorator#getTarget()
	 * target} one {@link Task}.
	 * 
	 * @param self
	 *            Not used <a href=
	 *            "http://www.eclipse.org/sirius/doc/specifier/general/Writing_Queries.html#service_methods"
	 *            >workaround</a>
	 * @param decorators
	 *            {@link DSemanticDecorator decorators}
	 * @return <code>true</code> if the given {@link DSemanticDecorator decorators} only
	 *         {@link DSemanticDecorator#getTarget() target} one {@link Task}, <code>false</code> otherwise
	 */
	public boolean isTask(EObject self, List<DSemanticDecorator> decorators) {
		return decorators.size() == 1 && decorators.get(0).getTarget() instanceof Task;
	}

	/**
	 * Tells if the given {@link DSemanticDecorator decorators} only {@link DSemanticDecorator#getTarget()
	 * target} one {@link ComposedTask}.
	 * 
	 * @param self
	 *            Not used <a href=
	 *            "http://www.eclipse.org/sirius/doc/specifier/general/Writing_Queries.html#service_methods"
	 *            >workaround</a>
	 * @param decorators
	 *            {@link DSemanticDecorator decorators}
	 * @return <code>true</code> if the given {@link DSemanticDecorator decorators} only
	 *         {@link DSemanticDecorator#getTarget() target} one {@link ComposedTask}, <code>false</code>
	 *         otherwise
	 */
	public boolean isComposedTask(EObject self, List<DSemanticDecorator> decorators) {
		return decorators.size() == 1 && decorators.get(0).getTarget() instanceof ComposedTask;
	}

}
