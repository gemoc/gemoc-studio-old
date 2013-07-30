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
package fr.obeo.dsl.sirius.animation.ide.debug;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.TargetState;
import fr.obeo.dsl.sirius.animation.Thread;
import fr.obeo.dsl.sirius.animation.util.AnimationAdapterFactory;

public abstract class DebugModelToEclipseDebugAdapterFactory extends
		AnimationAdapterFactory {

	private ILaunch launch;

	private Collection<Object> supportedTypes = Lists.newArrayList();

	protected TransactionalEditingDomain domain;

	public DebugModelToEclipseDebugAdapterFactory(ILaunch launch,
			TransactionalEditingDomain domain) {
		this.launch = launch;
		supportedTypes.add(IThread.class);
		supportedTypes.add(IDebugTarget.class);
		supportedTypes.add(IStackFrame.class);
		supportedTypes.add(IVariable.class);
		supportedTypes.add(IValue.class);
		this.domain = domain;
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	@Override
	protected Object resolve(Object object, Object type) {
		if (object instanceof EObjectVariableWrapper) {
			Adapter result = createEObjectVariableAdapter();
			return result;
		} else {
			return createObjectValueAdapter(object);
		}
	}

	@Override
	public Adapter adapt(Notifier target, Object type) {
		if (target instanceof SettingWrapper) {
			Adapter adapter = createSettingTargetAdapter();
			associate(adapter, target);
			return adapter;
		} else if (target != null) {
			return super.adapt(target, type);
		}
		return null;
	}

	private Adapter createEObjectVariableAdapter() {
		return new IVariableEObjectAnimationAdapter(this.launch, this);
	}

	private Adapter createSettingTargetAdapter() {
		return new IVariableEStructurealFeatureSettingAnimationAdapter(
				this.launch, this);
	}

	private Adapter createObjectValueAdapter(Object object) {
		return new IValueEListAdapter(this.launch, this, object);
	}

	@Override
	public Adapter createAnimationTargetAdapter() {
		return new IDebugTargetAnimationAdapter(this.launch, this);
	}

	@Override
	public Adapter createThreadAdapter() {
		return new IThreadAnimationAdapter(this.launch, this);
	}

	@Override
	public Adapter createStackFrameAdapter() {
		return new IStackFrameAnimationAdapter(this.launch, this);
	}

	@Override
	public Adapter createVariableAdapter() {
		return new IVariableAnimationAdapter(this.launch, this);
	}

	@Override
	public Adapter createEObjectAdapter() {
		return new IValueEObjectAnimationAdapter(this.launch, this);
	}

	public IValue createNullValue() {
		return new NullValue(this.launch, this);
	}

	public IVariable adaptToEObjectVariableWrapper(EObject child) {
		Iterator<EObjectVariableWrapper> it = Iterators.filter(child
				.eAdapters().iterator(), EObjectVariableWrapper.class);
		if (it.hasNext()) {
			return it.next();
		}
		EObjectVariableWrapper adapter = new EObjectVariableWrapper(
				this.launch, this);
		child.eAdapters().add(adapter);
		return adapter;
	}

	public void stepIntoViaCommand(final StackFrame host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Step Into") {

					@Override
					protected void doExecute() {
						stepInto(host);
					}

				});
	}

	public abstract AnimationTarget start();

	public abstract void stepInto(StackFrame host);

	public abstract void stepOver(StackFrame host);

	public abstract void stepReturn(StackFrame host);

	public abstract void terminate(StackFrame host);

	public abstract void stepInto(Thread host);

	public abstract void stepOver(Thread host);

	public abstract void stepReturn(Thread host);

	public void stepOverViaCommand(final StackFrame host) {
		ChangeObjectsVariableUpdater recorder = new ChangeObjectsVariableUpdater(
				host);
		domain.addResourceSetListener(recorder);
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Step Over") {

					@Override
					protected void doExecute() {
						host.setIsStepping(true);
						stepOver(host);
						host.setIsStepping(false);
					}

				});
		domain.removeResourceSetListener(recorder);
	}

	public void stepReturnViaCommand(final StackFrame host) {
		ChangeObjectsVariableUpdater recorder = new ChangeObjectsVariableUpdater(
				host);
		domain.addResourceSetListener(recorder);
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Step Return") {

					@Override
					protected void doExecute() {
						host.setIsStepping(true);
						stepReturn(host);
						host.setIsStepping(false);
					}

				});
		domain.removeResourceSetListener(recorder);

	}

	public void stepReturnViaCommand(final Thread host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Step Return") {

					@Override
					protected void doExecute() {
						stepReturn(host);
					}

				});
	}

	public void stepOverViaCommand(final Thread host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Step Over") {

					@Override
					protected void doExecute() {
						stepOver(host);
					}

				});
	}

	public void stepIntoViaCommand(final Thread host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Step Return") {

					@Override
					protected void doExecute() {
						stepInto(host);
					}

				});

	}

	public void terminateViaCommand(final StackFrame host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Terminate") {

					@Override
					protected void doExecute() {
						terminate(host);
						host.getParent().getStackFrames().remove(host);
					}

				});
	}

	public void terminateViaCommand(final Thread host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Terminate") {

					@Override
					protected void doExecute() {
						host.getStackFrames().clear();
						if (host.getParent() != null)
							host.getParent().setState(TargetState.TERMINATED);
					}

				});
	}

	public void resumeViaCommands(final Thread host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Resume") {

					@Override
					protected void doExecute() {
						if (host.getParent() != null)
							host.getParent().setState(TargetState.RUNNING);
					}

				});

	}

	public void suspendViaCommands(final Thread host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Suspend") {

					@Override
					protected void doExecute() {
						if (host.getParent() != null)
							host.getParent().setState(TargetState.SUSPENDED);
					}

				});

	}

	public void terminateViaCommand(final AnimationTarget host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Terminate") {

					@Override
					protected void doExecute() {
						host.setState(TargetState.TERMINATED);
						host.getThreads().clear();
					}

				});

	}

	public void resumeViaCommand(final AnimationTarget host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Resume") {

					@Override
					protected void doExecute() {
						host.setState(TargetState.RUNNING);
					}

				});

	}

	public void suspendViaCommand(final AnimationTarget host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Suspend") {

					@Override
					protected void doExecute() {
						host.setState(TargetState.SUSPENDED);
					}

				});

	}

	public void disconnectViaCommand(final AnimationTarget host) {
		domain.getCommandStack().execute(
				new RecordingCommand(domain, "Disconnect") {

					@Override
					protected void doExecute() {
						host.setState(TargetState.DISCONNECTED);
						host.getThreads().clear();
					}

				});

	}

}
