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
package fr.obeo.dsl.debug.ide;

import fr.obeo.dsl.debug.DebugTarget;
import fr.obeo.dsl.debug.StackFrame;
import fr.obeo.dsl.debug.Thread;
import fr.obeo.dsl.debug.Variable;
import fr.obeo.dsl.debug.ide.adapter.DSLDebugTargetAdapter;
import fr.obeo.dsl.debug.ide.adapter.DSLStackFrameAdapter;
import fr.obeo.dsl.debug.ide.adapter.DSLThreadAdapter;
import fr.obeo.dsl.debug.ide.adapter.DSLVariableAdapter;
import fr.obeo.dsl.debug.ide.adapter.value.DSLArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLBooleanArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLByteArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLCharArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLDoubleArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLEObjectValueAdapter;
import fr.obeo.dsl.debug.ide.adapter.value.DSLFloatArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLIntArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLLongArrayValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLNullValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLObjectValue;
import fr.obeo.dsl.debug.ide.adapter.value.DSLShortArrayValue;
import fr.obeo.dsl.debug.ide.adapter.variable.DSLObjectVariable;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;
import fr.obeo.dsl.debug.provider.DebugItemProviderAdapterFactory;
import fr.obeo.dsl.debug.util.DebugAdapterFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

/**
 * A {@link DebugAdapterFactory} providing {@link org.eclipse.debug.core.model.IDebugElement IDebugElement}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLEclipseDebugIntegration extends DebugAdapterFactory {

	/**
	 * {@link Set} of {@link org.eclipse.emf.common.notify.AdapterFactory#isFactoryForType(Object) supported
	 * types}.
	 */
	private static final Set<Object> SUPPORTED_TYPES = initSupportedTypes();

	/**
	 * The launching debug session.
	 */
	private final ILaunch launch;

	/**
	 * A generic {@link org.eclipse.emf.edit.provider.IItemLabelProvider IItemLabelProvider} factory.
	 */
	private final ComposedAdapterFactory genericLabelFactory;

	/**
	 * The {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 * communication or the {@link fr.obeo.dsl.debug.ide.IDSLDebugger debugger} for synchronous communication.
	 */
	private final IDSLDebugEventProcessor debugger;

	/**
	 * The {@link DSLDebugTargetAdapter} to work with.
	 */
	private final DSLDebugTargetAdapter debugTarget;

	/**
	 * The {@link IModelUpdater} responsible for EMF debug model updates.
	 */
	private final IModelUpdater modelUpdater;

	/**
	 * Constructor.
	 * 
	 * @param launch
	 *            the launching debug session
	 * @param debugTarget
	 *            the {@link DebugTarget}
	 * @param modelUpdater
	 *            the {@link IModelUpdater}
	 * @param debugger
	 *            the {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 *            communication or the {@link fr.obeo.dsl.debug.ide.IDSLDebugger debugger} for synchronous
	 *            communication
	 */
	public DSLEclipseDebugIntegration(ILaunch launch, DebugTarget debugTarget, IModelUpdater modelUpdater,
			IDSLDebugEventProcessor debugger) {
		this.launch = launch;
		this.debugger = debugger;

		this.debugTarget = getDebugTarget(debugTarget);
		this.modelUpdater = modelUpdater;

		genericLabelFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		genericLabelFactory.addAdapterFactory(new DebugItemProviderAdapterFactory());
		genericLabelFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		genericLabelFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * Initializes {@link DSLEclipseDebugIntegration#SUPPORTED_TYPES}.
	 * 
	 * @return the {@link Set} of
	 *         {@link org.eclipse.emf.common.notify.AdapterFactory#isFactoryForType(Object) supported types}.
	 */
	private static Set<Object> initSupportedTypes() {
		final Set<Object> res = new HashSet<Object>();

		res.add(IThread.class);
		res.add(IDebugTarget.class);
		res.add(IStackFrame.class);
		res.add(IVariable.class);
		res.add(IBreakpoint.class);

		return res;
	}

	@Override
	public boolean isFactoryForType(Object object) {
		return SUPPORTED_TYPES.contains(object) || super.isFactoryForType(object);
	}

	@Override
	public Adapter createDebugTargetAdapter() {
		return new DSLDebugTargetAdapter(this);
	}

	@Override
	public Adapter createThreadAdapter() {
		return new DSLThreadAdapter(this);
	}

	@Override
	public Adapter createStackFrameAdapter() {
		return new DSLStackFrameAdapter(this);
	}

	@Override
	public Adapter createVariableAdapter() {
		return new DSLVariableAdapter(this);
	}

	/**
	 * Gets the launching debug session.
	 * 
	 * @return the launching debug session
	 */
	public ILaunch getLaunch() {
		return launch;
	}

	/**
	 * Gets the {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 * communication or the {@link fr.obeo.dsl.debug.ide.IDSLDebugger debugger} for synchronous communication.
	 * 
	 * @return the {@link fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher dispatcher} for asynchronous
	 *         communication or the {@link fr.obeo.dsl.debug.ide.IDSLDebugger debugger} for synchronous
	 *         communication
	 */
	public IDSLDebugEventProcessor getDebugger() {
		return debugger;
	}

	/**
	 * Gets a generic {@link org.eclipse.emf.edit.provider.IItemLabelProvider IItemLabelProvider} factory.
	 * 
	 * @return a generic {@link org.eclipse.emf.edit.provider.IItemLabelProvider IItemLabelProvider} factory
	 */
	public AdapterFactory getLabelFactory() {
		return genericLabelFactory;
	}

	/**
	 * Gets the {@link DSLDebugTargetAdapter} to work with.
	 * 
	 * @return the {@link DSLDebugTargetAdapter} to work with
	 */
	public DSLDebugTargetAdapter getDebugTarget() {
		return debugTarget;
	}

	/**
	 * Gets an {@link IDebugTarget} form a {@link DebugTarget}.
	 * 
	 * @param target
	 *            the {@link DebugTarget}
	 * @return the {@link IDebugTarget}
	 */
	public DSLDebugTargetAdapter getDebugTarget(DebugTarget target) {
		final DSLDebugTargetAdapter res = (DSLDebugTargetAdapter)adapt(target, IDebugTarget.class);
		if (res == null) {
			throw new IllegalStateException("can't addapt DebugTarget to IDebugTarget.");
		}
		return res;
	}

	/**
	 * Gets an {@link IThread} form a {@link Thread}.
	 * 
	 * @param thread
	 *            the {@link Thread}
	 * @return the {@link IThread}
	 */
	public DSLThreadAdapter getThread(Thread thread) {
		final DSLThreadAdapter res = (DSLThreadAdapter)adapt(thread, IThread.class);
		if (res == null) {
			throw new IllegalStateException("can't addapt Thread to IThread.");
		}
		return res;
	}

	/**
	 * Gets an {@link IStackFrame} form a {@link StackFrame}.
	 * 
	 * @param frame
	 *            the {@link StackFrame}
	 * @return the {@link IStackFrame}
	 */
	public DSLStackFrameAdapter getStackFrame(StackFrame frame) {
		final DSLStackFrameAdapter res = (DSLStackFrameAdapter)adapt(frame, IStackFrame.class);
		if (res == null) {
			throw new IllegalStateException("can't addapt StackFrame to IStackFrame.");
		}
		return res;
	}

	/**
	 * Gets an {@link IVariable} form a {@link Variable}.
	 * 
	 * @param frame
	 *            the {@link Variable}
	 * @return the {@link IVariable}
	 */
	public DSLVariableAdapter getVariable(Variable frame) {
		final DSLVariableAdapter res = (DSLVariableAdapter)adapt(frame, IVariable.class);
		if (res == null) {
			throw new IllegalStateException("can't addapt Variable to IVariable.");
		}
		return res;
	}

	/**
	 * Gets the {@link IValue} for the given {@link Object}.
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the {@link Object value}
	 * @return the corresponding {@link IValue}
	 */
	public IValue getValue(String referenceTypeName, Object value) {
		final IValue res;

		if (value instanceof EObject) {
			res = createEObjectValue(referenceTypeName, (EObject)value);
		} else if (value instanceof Collection<?>) {
			res = new DSLArrayValue(this, referenceTypeName, ((Collection<?>)value).toArray());
		} else if (value instanceof Object[]) {
			res = new DSLArrayValue(this, referenceTypeName, (Object[])value);
		} else if (value instanceof byte[]) {
			res = createByteArrayValue(referenceTypeName, (byte[])value);
		} else if (value instanceof short[]) {
			res = createShortArrayValue(referenceTypeName, (short[])value);
		} else if (value instanceof int[]) {
			res = createIntegerArrayValue(referenceTypeName, (int[])value);
		} else if (value instanceof long[]) {
			res = createLongArrayValue(referenceTypeName, (long[])value);
		} else if (value instanceof float[]) {
			res = createFloatArrayValue(referenceTypeName, (float[])value);
		} else if (value instanceof double[]) {
			res = createDoubleArrayValue(referenceTypeName, (double[])value);
		} else if (value instanceof char[]) {
			res = createCharacterArrayValue(referenceTypeName, (char[])value);
		} else if (value instanceof boolean[]) {
			res = createBooleanArrayValue(referenceTypeName, (boolean[])value);
		} else if (value == null) {
			res = new DSLNullValue(this, referenceTypeName);
		} else {
			res = new DSLObjectValue(this, referenceTypeName, value);
		}

		return res;
	}

	/**
	 * Creates an {@link IValue} for the given {@link EObject}.
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the {@link EObject}
	 * @return the created {@link IValue}
	 */
	private IValue createEObjectValue(String referenceTypeName, EObject value) {
		final IValue res;
		DSLEObjectValueAdapter valueAdapter = null;
		for (Adapter adapter : value.eAdapters()) {
			if (adapter.isAdapterForType(IValue.class)) {
				valueAdapter = (DSLEObjectValueAdapter)adapter;
				break;
			}
		}
		if (valueAdapter == null) {
			valueAdapter = new DSLEObjectValueAdapter(this, referenceTypeName, value);
			value.eAdapters().add(valueAdapter);
		}
		res = valueAdapter;
		return res;
	}

	/**
	 * Creates an {@link IValue} for a byte[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the byte[]
	 * @return the created {@link IValue}
	 */
	private IValue createByteArrayValue(String referenceTypeName, byte[] value) {
		final IValue res;
		Byte[] array = new Byte[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Byte.valueOf(value[i]);
		}
		res = new DSLByteArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a short[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the short[]
	 * @return the created {@link IValue}
	 */
	private IValue createShortArrayValue(String referenceTypeName, short[] value) {
		final IValue res;
		Short[] array = new Short[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Short.valueOf(value[i]);
		}
		res = new DSLShortArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a int[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the int[]
	 * @return the created {@link IValue}
	 */
	private IValue createIntegerArrayValue(String referenceTypeName, int[] value) {
		final IValue res;
		Integer[] array = new Integer[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Integer.valueOf(value[i]);
		}
		res = new DSLIntArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a long[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the long[]
	 * @return the created {@link IValue}
	 */
	private IValue createLongArrayValue(String referenceTypeName, long[] value) {
		final IValue res;
		Long[] array = new Long[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Long.valueOf(value[i]);
		}
		res = new DSLLongArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a float[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the float[]
	 * @return the created {@link IValue}
	 */
	private IValue createFloatArrayValue(String referenceTypeName, float[] value) {
		final IValue res;
		Float[] array = new Float[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Float.valueOf(value[i]);
		}
		res = new DSLFloatArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a double[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the double[]
	 * @return the created {@link IValue}
	 */
	private IValue createDoubleArrayValue(String referenceTypeName, double[] value) {
		final IValue res;
		Double[] array = new Double[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Double.valueOf(value[i]);
		}
		res = new DSLDoubleArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a char[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the char[]
	 * @return the created {@link IValue}
	 */
	private IValue createCharacterArrayValue(String referenceTypeName, char[] value) {
		final IValue res;
		Character[] array = new Character[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Character.valueOf(value[i]);
		}
		res = new DSLCharArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Creates an {@link IValue} for a boolean[].
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param value
	 *            the boolean[]
	 * @return the created {@link IValue}
	 */
	private IValue createBooleanArrayValue(String referenceTypeName, boolean[] value) {
		final IValue res;
		Boolean[] array = new Boolean[value.length];
		for (int i = 0; i < value.length; ++i) {
			array[i] = Boolean.valueOf(value[i]);
		}
		res = new DSLBooleanArrayValue(this, referenceTypeName, array);
		return res;
	}

	/**
	 * Gets a {@link IVariable} for the given {@link Object}.
	 * 
	 * @param referenceTypeName
	 *            the reference type name
	 * @param variableName
	 *            the variable name
	 * @param value
	 *            the value
	 * @return the {@link IVariable}
	 */
	public IVariable getVariable(String referenceTypeName, String variableName, Object value) {
		return new DSLObjectVariable(this, referenceTypeName, variableName, value);
	}

	/**
	 * Gets the {@link IModelUpdater} responsible for EMF debug model updates.
	 * 
	 * @return the {@link IModelUpdater} responsible for EMF debug model updates
	 */
	public IModelUpdater getModelUpdater() {
		return modelUpdater;
	}

}
