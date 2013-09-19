/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.uml.ide.debug.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.Animator;
import fr.obeo.dsl.sirius.animation.ide.debug.AnimationResource;
import fr.obeo.dsl.sirius.animation.ide.debug.AnimatorEclipseDebugIntegration;
import fr.obeo.dsl.sirius.animation.ide.debug.IDebugTargetAnimationAdapter;
import fr.obeo.dsl.sirius.animation.ide.debug.ProtocolParser;
import fr.obeo.dsl.sirius.animation.uml.AnimateUMLStateMachine;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;

public class AnimationLaunchConfiguration implements
		ILaunchConfigurationDelegate {

	public void launch(ILaunchConfiguration configuration, String mode,
			final ILaunch launch, IProgressMonitor monitor)
			throws CoreException {

		if (mode.equals(ILaunchManager.DEBUG_MODE)) {

			for (final Session sess : SessionManager.INSTANCE.getSessions()) {
				TransactionalEditingDomain transactionalEditingDomain = sess
						.getTransactionalEditingDomain();
				transactionalEditingDomain.getCommandStack().execute(
						new RecordingCommand(transactionalEditingDomain) {

							@Override
							protected void doExecute() {
								AnimationResource res = (AnimationResource) new ProtocolParser()
										.getOrCreateDebugResource(sess
												.getTransactionalEditingDomain()
												.getResourceSet());
								Animator animator = new AnimateUMLStateMachine();
								AnimatorEclipseDebugIntegration simulator = new AnimatorEclipseDebugIntegration(
										launch,
										sess.getTransactionalEditingDomain(),
										animator);
								AnimationTarget animModel = animator.start(sess
										.getTransactionalEditingDomain()
										.getResourceSet());
								res.getRootObject().getTargets().add(animModel);
								sess.addSemanticResource(res, false);
								IDebugTargetAnimationAdapter animationDebugTarget = (IDebugTargetAnimationAdapter) simulator
										.adapt(animModel,
												IDebugTargetAnimationAdapter.class);
								launch.addDebugTarget(animationDebugTarget);
							}
						});
			}
		}
		// IProcess process = new AnimationProcess(launch);
		/*
		 * TODO retrieve the model from a simulation or from a trace. the
		 * adapter factory should probably come from the same source as it will
		 * update the data model.
		 */
	}

}
