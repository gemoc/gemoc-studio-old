package org.gemoc.sample.tfsm.plaink3.xtfsm.trace.tracemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.executionframework.engine.core.CommandExecution;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.Step;
import fr.inria.diverse.trace.gemoc.api.ITraceExplorer;
import fr.inria.diverse.trace.gemoc.api.ITraceListener;

public class Tfsm_plaink3TraceExplorer implements ITraceExplorer {
	private tfsm_plaink3Trace.SpecificTrace traceRoot;
	private Resource modelResource;
	private final Map<EObject, EObject> tracedToExe;

	private int lastJumpIndex = -1;
	private tfsm_plaink3Trace.States.State currentState = null;
	final private List<Step> callStack = new ArrayList<>();

	final private List<List<? extends tfsm_plaink3Trace.States.Value>> valueTraces = new ArrayList<>();

	private List<tfsm_plaink3Trace.States.State> statesTrace;

	private tfsm_plaink3Trace.Steps.SpecificStep stepIntoResult;
	private tfsm_plaink3Trace.Steps.SpecificStep stepOverResult;
	private tfsm_plaink3Trace.Steps.SpecificStep stepReturnResult;

	private tfsm_plaink3Trace.Steps.SpecificStep stepBackIntoResult;
	private tfsm_plaink3Trace.Steps.SpecificStep stepBackOverResult;
	private tfsm_plaink3Trace.Steps.SpecificStep stepBackOutResult;

	final private Map<tfsm_plaink3Trace.Steps.SpecificStep, Integer> stepToStartingIndex = new HashMap<>();
	final private Map<tfsm_plaink3Trace.Steps.SpecificStep, Integer> stepToEndingIndex = new HashMap<>();

	private final HashMap<Integer, Boolean> canBackValueCache = new HashMap<>();

	final private List<ITraceListener> listeners = new ArrayList<>();

	public Tfsm_plaink3TraceExplorer(Map<EObject, EObject> tracedToExe) {
		this.tracedToExe = tracedToExe;
	}

	public Tfsm_plaink3TraceExplorer() {
		this.tracedToExe = null;
	}

	private List<List<? extends tfsm_plaink3Trace.States.Value>> getAllValueTraces() {
		final List<List<? extends tfsm_plaink3Trace.States.Value>> result = new ArrayList<>();
		for (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock tracedObject : traceRoot
				.getTfsm_plaink3_tracedFSMClocks()) {
			result.add(tracedObject.getNumberOfTicksSequence());
		}
		for (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent tracedObject : traceRoot
				.getTfsm_plaink3_tracedFSMEvents()) {
			result.add(tracedObject.getIsTriggeredSequence());
		}
		for (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM tracedObject : traceRoot.getTfsm_plaink3_tracedTFSMs()) {
			result.add(tracedObject.getCurrentStateSequence());
			result.add(tracedObject.getLastStateChangeStepNumberSequence());
			result.add(tracedObject.getStepNumberSequence());
		}
		return result;
	}

	private tfsm_plaink3Trace.States.Value getActiveValue(List<? extends tfsm_plaink3Trace.States.Value> valueTrace,
			tfsm_plaink3Trace.States.State state) {
		tfsm_plaink3Trace.States.Value result = null;
		for (tfsm_plaink3Trace.States.Value value : valueTrace) {
			if (value.getStatesNoOpposite().contains(state)) {
				result = value;
				break;
			}
		}
		return result;
	}

	private int getPreviousValueIndex(final List<? extends tfsm_plaink3Trace.States.Value> valueTrace) {
		tfsm_plaink3Trace.States.Value value = getActiveValue(valueTrace, currentState);
		if (value != null) {
			return valueTrace.indexOf(value) - 1;
		} else {
			int i = getCurrentStateIndex() - 1;
			while (i > -1 && value == null) {
				value = getActiveValue(valueTrace, statesTrace.get(i));
				i--;
			}
			if (value == null) {
				return -1;
			} else {
				return valueTrace.indexOf(value) - 1;
			}
		}
	}

	private int getNextValueIndex(List<? extends tfsm_plaink3Trace.States.Value> valueTrace) {
		tfsm_plaink3Trace.States.Value value = getActiveValue(valueTrace, currentState);
		if (value != null) {
			final int idx = valueTrace.indexOf(value) + 1;
			if (idx < valueTrace.size()) {
				return idx;
			}
			return -1;
		} else {
			int i = getCurrentStateIndex() + 1;
			final int traceLength = valueTrace.size();
			while (i < traceLength && value == null) {
				value = getActiveValue(valueTrace, statesTrace.get(i));
				i++;
			}
			if (value == null) {
				return -1;
			} else {
				final int idx = valueTrace.indexOf(value) + 1;
				if (idx < valueTrace.size()) {
					return idx;
				}
				return -1;
			}
		}
	}

	private int getStartingIndex(tfsm_plaink3Trace.Steps.SpecificStep step) {
		return stepToStartingIndex.computeIfAbsent(step, s -> {
			return statesTrace.indexOf(s.getStartingState());
		});
	}

	private int getEndingIndex(tfsm_plaink3Trace.Steps.SpecificStep step) {
		if (step.getEndingState() != null) {
			return stepToEndingIndex.computeIfAbsent(step, s -> {
				return statesTrace.indexOf(s.getEndingState());
			});
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	private tfsm_plaink3Trace.Steps.SpecificStep findNextStep(final List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath,
			final tfsm_plaink3Trace.Steps.SpecificStep previousStep, final int start) {
		final List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps = traceRoot.getRootStep().getSubSteps();
		tfsm_plaink3Trace.Steps.SpecificStep result = null;
		int i = start;
		int depth = stepPath.size();
		tfsm_plaink3Trace.Steps.SpecificStep previous = previousStep;
		while (result == null && i < depth) {
			final tfsm_plaink3Trace.Steps.SpecificStep currentStep = stepPath.get(depth - i - 1);
			final List<tfsm_plaink3Trace.Steps.SpecificStep> currentSubSteps = new ArrayList<>();
			if (currentStep instanceof SequentialStep<?>) {
				currentSubSteps
						.addAll(((SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) currentStep).getSubSteps());
			}
			if (currentSubSteps.isEmpty()) {
				// No substep to step into, we thus have to explore the substeps
				// of the parent step
				previous = currentStep;
			} else {
				if (previous == null) {
					// First time we step into
					result = currentSubSteps.get(0);
				} else {
					final int idx = currentSubSteps.indexOf(previous) + 1;
					if (idx < currentSubSteps.size()) {
						// We step into the next step
						result = currentSubSteps.get(idx);
					} else {
						previous = currentStep;
					}
				}
			}
			i++;
		}
		if (result == null) {
			final int idx = rootSteps.indexOf(previous) + 1;
			if (idx < rootSteps.size()) {
				result = rootSteps.get(idx);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private tfsm_plaink3Trace.Steps.SpecificStep computeBackInto(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath) {
		final List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps = traceRoot.getRootStep().getSubSteps();
		final int depth = stepPath.size();
		tfsm_plaink3Trace.Steps.SpecificStep result = null;
		if (depth > 1) {
			final tfsm_plaink3Trace.Steps.SpecificStep currentStep = stepPath.get(depth - 1);
			final tfsm_plaink3Trace.Steps.SpecificStep parentStep = stepPath.get(depth - 2);
			final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> parentStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) parentStep;
			final List<? extends tfsm_plaink3Trace.Steps.SpecificStep> parentSubSteps = parentStep_cast.getSubSteps();
			final int idx = parentSubSteps.indexOf(currentStep);
			if (idx == 0) {
				// If the current step is the first in its parents substeps,
				// return parent step
				result = parentStep;
			} else if (idx > 0) {
				// Otherwise, return the deepest substep in the previous sibling
				// step
				final tfsm_plaink3Trace.Steps.SpecificStep previousSiblingStep = parentSubSteps.get(idx - 1);
				tfsm_plaink3Trace.Steps.SpecificStep tmpStep = previousSiblingStep;
				final List<tfsm_plaink3Trace.Steps.SpecificStep> tmpSubSteps = new ArrayList<>();
				tmpSubSteps.clear();
				if (tmpStep instanceof SequentialStep<?>) {
					SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> tmpStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) tmpStep;
					tmpSubSteps.addAll(tmpStep_cast.getSubSteps());
				}
				while (!tmpSubSteps.isEmpty()) {
					tmpStep = tmpSubSteps.get(tmpSubSteps.size() - 1);
					tmpSubSteps.clear();
					if (tmpStep instanceof SequentialStep<?>) {
						SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> tmpStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) tmpStep;
						tmpSubSteps.addAll(tmpStep_cast.getSubSteps());
					}
				}
				result = tmpStep;
			}
		} else if (depth == 1) {
			final tfsm_plaink3Trace.Steps.SpecificStep currentStep = stepPath.get(0);
			final int idx = rootSteps.indexOf(currentStep);
			if (idx > 0) {
				tfsm_plaink3Trace.Steps.SpecificStep tmpStep = rootSteps.get(idx - 1);
				final List<tfsm_plaink3Trace.Steps.SpecificStep> tmpSubSteps = new ArrayList<>();
				tmpSubSteps.clear();
				if (tmpStep instanceof SequentialStep<?>) {
					SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> tmpStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) tmpStep;
					tmpSubSteps.addAll(tmpStep_cast.getSubSteps());
				}
				while (!tmpSubSteps.isEmpty()) {
					tmpStep = tmpSubSteps.get(tmpSubSteps.size() - 1);
					tmpSubSteps.clear();
					if (tmpStep instanceof SequentialStep<?>) {
						SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> tmpStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) tmpStep;
						tmpSubSteps.addAll(tmpStep_cast.getSubSteps());
					}
				}
				result = tmpStep;
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private tfsm_plaink3Trace.Steps.SpecificStep computeBackOver(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath) {
		final List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps = traceRoot.getRootStep().getSubSteps();
		final int depth = stepPath.size();
		tfsm_plaink3Trace.Steps.SpecificStep result = null;
		if (depth > 1) {
			final tfsm_plaink3Trace.Steps.SpecificStep currentStep = stepPath.get(depth - 1);
			final tfsm_plaink3Trace.Steps.SpecificStep parentStep = stepPath.get(depth - 2);
			final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> parentStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) parentStep;
			final List<tfsm_plaink3Trace.Steps.SpecificStep> parentSubSteps = parentStep_cast.getSubSteps();
			final int idx = parentSubSteps.indexOf(currentStep);
			if (idx == 0) {
				// If the current step is the first in its parents substeps,
				// return parent step
				result = parentStep;
			} else {
				// Otherwise, return the previous sibling step
				result = parentSubSteps.get(idx - 1);
			}
		} else if (depth == 1) {
			final tfsm_plaink3Trace.Steps.SpecificStep currentStep = stepPath.get(0);
			final int idx = rootSteps.indexOf(currentStep);
			if (idx > 0) {
				result = rootSteps.get(idx - 1);
			}
		}
		return result;
	}

	private tfsm_plaink3Trace.Steps.SpecificStep computeBackOut(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath) {
		if (stepPath.size() > 1) {
			return stepPath.get(stepPath.size() - 2);
		}
		return null;
	}

	private tfsm_plaink3Trace.Steps.SpecificStep computeStepInto(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath,
			List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps) {
		return findNextStep(stepPath, null, 0);
	}

	private tfsm_plaink3Trace.Steps.SpecificStep computeStepOver(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath,
			List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps) {
		if (!stepPath.isEmpty()) {
			return findNextStep(stepPath, stepPath.get(stepPath.size() - 1), 1);
		}
		return null;
	}

	private tfsm_plaink3Trace.Steps.SpecificStep computeStepReturn(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath,
			List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps) {
		if (stepPath.size() > 1) {
			return findNextStep(stepPath, stepPath.get(stepPath.size() - 2), 2);
		}
		return null;
	}

	private void computeExplorerState(List<tfsm_plaink3Trace.Steps.SpecificStep> stepPath) {
		final List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps = getStepsForStates(0, statesTrace.size());

		final List<tfsm_plaink3Trace.Steps.SpecificStep> stepPathUnmodifiable = Collections.unmodifiableList(stepPath);

		stepIntoResult = computeStepInto(stepPathUnmodifiable, rootSteps);
		stepOverResult = computeStepOver(stepPathUnmodifiable, rootSteps);
		stepReturnResult = computeStepReturn(stepPathUnmodifiable, rootSteps);

		stepBackIntoResult = computeBackInto(stepPathUnmodifiable);
		stepBackOverResult = computeBackOver(stepPathUnmodifiable);
		stepBackOutResult = computeBackOut(stepPathUnmodifiable);

		callStack.clear();
		callStack.addAll(stepPathUnmodifiable.stream().map(s -> (Step) s).collect(Collectors.toList()));
	}

	private void goTo(EObject eObject) {
		if (eObject instanceof tfsm_plaink3Trace.States.State) {
			tfsm_plaink3Trace.States.State stateToGo = (tfsm_plaink3Trace.States.State) eObject;
			for (tfsm_plaink3Trace.States.TFSM_currentState_Value value : stateToGo.getTFSM_currentState_Values()) {
				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) value
							.getParent();
					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State toset = (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) getTracedToExe(
							value.getCurrentState());
					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State current = ((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) parent_cast
							.getOriginalObject()).getCurrentState();
					if (current != toset) {
						((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) parent_cast.getOriginalObject())
								.setCurrentState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) toset);
					}
				}
			}
			for (tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value value : stateToGo
					.getFSMEvent_isTriggered_Values()) {
				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) value
							.getParent();
					boolean toset = value.isIsTriggered();
					boolean current = ((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) parent_cast
							.getOriginalObject()).isIsTriggered();
					if (current != toset) {
						((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) parent_cast
								.getOriginalObject()).setIsTriggered((boolean) toset);
					}
				}
			}
			for (tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value value : stateToGo
					.getTFSM_lastStateChangeStepNumber_Values()) {
				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) value
							.getParent();
					int toset = value.getLastStateChangeStepNumber();
					int current = ((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) parent_cast
							.getOriginalObject()).getLastStateChangeStepNumber();
					if (current != toset) {
						((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) parent_cast.getOriginalObject())
								.setLastStateChangeStepNumber((int) toset);
					}
				}
			}
			for (tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value value : stateToGo
					.getFSMClock_numberOfTicks_Values()) {
				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) value
							.getParent();
					java.lang.Integer toset = value.getNumberOfTicks();
					java.lang.Integer current = ((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) parent_cast
							.getOriginalObject()).getNumberOfTicks();
					if (current != toset) {
						((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) parent_cast
								.getOriginalObject()).setNumberOfTicks((java.lang.Integer) toset);
					}
				}
			}
			for (tfsm_plaink3Trace.States.TFSM_stepNumber_Value value : stateToGo.getTFSM_stepNumber_Values()) {
				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) value
							.getParent();
					int toset = value.getStepNumber();
					int current = ((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) parent_cast
							.getOriginalObject()).getStepNumber();
					if (current != toset) {
						((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) parent_cast.getOriginalObject())
								.setStepNumber((int) toset);
					}
				}
			}
		} else if (eObject instanceof tfsm_plaink3Trace.States.Value) {
			goTo(((tfsm_plaink3Trace.States.Value) eObject).getStatesNoOpposite().get(0));
		}
	}

	private void goTo(int stateNumber) {
		if (modelResource != null) {
			try {
				final TransactionalEditingDomain ed = TransactionUtil.getEditingDomain(modelResource);
				if (ed != null) {
					final RecordingCommand command = new RecordingCommand(ed, "") {
						protected void doExecute() {
							goTo(statesTrace.get(stateNumber));
						}
					};
					CommandExecution.execute(ed, command);
				}
			} catch (Exception e) {
				throw e;
			}
		}
	}

	private Collection<? extends EObject> getTracedToExe(Collection<? extends EObject> tracedObjects) {
		Collection<EObject> result = new ArrayList<EObject>();
		for (EObject tracedObject : tracedObjects) {
			result.add(getTracedToExe(tracedObject));
		}
		return result;
	}

	private EObject getTracedToExe(EObject tracedObject) {
		return tracedToExe.get(tracedObject);
	}

	private void jumpBeforeStep(tfsm_plaink3Trace.Steps.SpecificStep step) {
		if (step != null) {
			final int i = getStartingIndex(step);
			if (i == statesTrace.size() - 1) {
				lastJumpIndex = -1;
				currentState = statesTrace.get(statesTrace.size() - 1);
			} else {
				lastJumpIndex = i;
				currentState = statesTrace.get(i);
			}
			if (tracedToExe != null) {
				goTo(i);
			}
			updateCallStack(step);
		}
	}

	public void loadTrace(tfsm_plaink3Trace.SpecificTrace root) {
		traceRoot = root;
		statesTrace = traceRoot.getStatesTrace();
		if (!statesTrace.isEmpty()) {
			currentState = statesTrace.get(0);
		}
		valueTraces.addAll(getAllValueTraces());
	}

	public void loadTrace(Resource modelResource, tfsm_plaink3Trace.SpecificTrace root) {
		loadTrace(root);
		this.modelResource = modelResource;
	}

	@Override
	public boolean canBackValue(int traceIndex) {
		if (traceIndex > -1 && traceIndex < valueTraces.size()) {
			return canBackValueCache.computeIfAbsent(traceIndex, i -> {
				final List<? extends tfsm_plaink3Trace.States.Value> valueTrace = valueTraces.get(traceIndex);
				final int previousValueIndex = getPreviousValueIndex(valueTrace);
				return previousValueIndex > -1;
			});
		}
		return false;
	}

	@Override
	public boolean canStepValue(int traceIndex) {
		return true;
	}

	@Override
	public void backValue(int traceIndex) {
		if (traceIndex > -1 && traceIndex < valueTraces.size()) {
			final List<? extends tfsm_plaink3Trace.States.Value> valueTrace = valueTraces.get(traceIndex);
			final int previousValueIndex = getPreviousValueIndex(valueTrace);
			if (previousValueIndex > -1) {
				jump(valueTrace.get(previousValueIndex));
			}
		}
	}

	@Override
	public void stepValue(int traceIndex) {
		if (traceIndex > -1 && traceIndex < valueTraces.size()) {
			final List<? extends tfsm_plaink3Trace.States.Value> valueTrace = valueTraces.get(traceIndex);
			final int nextValueIndex = getNextValueIndex(valueTrace);
			if (nextValueIndex > -1) {
				jump(valueTrace.get(nextValueIndex));
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void jump(int i) {
		final List<tfsm_plaink3Trace.States.State> states = statesTrace;
		if (i < states.size()) {
			final List<tfsm_plaink3Trace.Steps.SpecificStep> rootSteps = getStepsForStates(i, i);
			final List<tfsm_plaink3Trace.Steps.SpecificStep> searchPath = new ArrayList<>();
			tfsm_plaink3Trace.Steps.SpecificStep firstStepOfState = null;
			if (!rootSteps.isEmpty()) {
				final Predicate<tfsm_plaink3Trace.Steps.SpecificStep> p = s -> {
					final int stepStartingState = getStartingIndex(s);
					final int stepEndingState = getEndingIndex(s);
					return (stepEndingState == -1 || stepEndingState >= i) && stepStartingState <= i;
				};
				tfsm_plaink3Trace.Steps.SpecificStep currentStep = rootSteps.get(0);
				final List<tfsm_plaink3Trace.Steps.SpecificStep> siblingSteps = new ArrayList<>(rootSteps);
				final List<tfsm_plaink3Trace.Steps.SpecificStep> currentSubSteps = new ArrayList<>();
				if (currentStep instanceof SequentialStep<?>) {
					final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> currentStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) currentStep;
					currentSubSteps
							.addAll(currentStep_cast.getSubSteps().stream().filter(p).collect(Collectors.toList()));
				}
				while (firstStepOfState == null) {
					final int startingIndex = getStartingIndex(currentStep);
					final int endingIndex = getEndingIndex(currentStep);
					if (startingIndex < i && (endingIndex > i || endingIndex == -1)) {
						if (currentSubSteps.isEmpty()) {
							throw new IllegalStateException("Unreachable state");
						} else {
							searchPath.add(0, currentStep);
							siblingSteps.clear();
							siblingSteps.addAll(currentSubSteps);
							currentStep = siblingSteps.get(0);
							currentSubSteps.clear();
							if (currentStep instanceof SequentialStep<?>) {
								final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> currentStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) currentStep;
								currentSubSteps.addAll(
										currentStep_cast.getSubSteps().stream().filter(p).collect(Collectors.toList()));
							}
						}
					} else if (endingIndex == i && startingIndex != i) {
						if (currentSubSteps.isEmpty()) {
							// We need to explore the next sibling step
							tfsm_plaink3Trace.Steps.SpecificStep tmp = currentStep;
							currentStep = null;
							while (currentStep == null) {
								final int idx = siblingSteps.indexOf(tmp) + 1;
								if (idx < siblingSteps.size()) {
									currentStep = siblingSteps.get(idx);
									if (currentStep instanceof SequentialStep<?>) {
										final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> currentStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) currentStep;
										currentSubSteps.addAll(currentStep_cast.getSubSteps().stream().filter(p)
												.collect(Collectors.toList()));
									}
								} else {
									if (searchPath.isEmpty()) {
										throw new IllegalStateException("Unreachable state");
									} else {
										tmp = searchPath.remove(0);
										siblingSteps.clear();
										if (searchPath.isEmpty()) {
											siblingSteps.addAll(rootSteps);
										} else {
											final tfsm_plaink3Trace.Steps.SpecificStep s = searchPath.get(0);
											if (s instanceof SequentialStep<?>) {
												final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> s_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) s;
												siblingSteps.addAll((s_cast).getSubSteps().stream().filter(p)
														.collect(Collectors.toList()));
											}
										}
									}
								}
							}
						} else {
							// We need to explore the substeps in case one of them starts on i
							searchPath.add(0, currentStep);
							siblingSteps.clear();
							siblingSteps.addAll(currentSubSteps);
							currentStep = siblingSteps.get(0);
							currentSubSteps.clear();
							if (currentStep instanceof SequentialStep<?>) {
								final SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> currentStep_cast = (SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) currentStep;
								currentSubSteps.addAll(
										currentStep_cast.getSubSteps().stream().filter(p).collect(Collectors.toList()));
							}
						}
					} else if (startingIndex == i) {
						firstStepOfState = currentStep;
					}
				}
			}
			jumpBeforeStep(firstStepOfState);
		}
	}

	@Override
	public boolean canStepBackInto() {
		return stepBackIntoResult != null;
	}

	@Override
	public boolean canStepBackOver() {
		return stepBackOverResult != null;
	}

	@Override
	public boolean canStepBackOut() {
		return stepBackOutResult != null;
	}

	@Override
	public int getCurrentStateIndex() {
		if (lastJumpIndex != -1) {
			return lastJumpIndex;
		}
		return statesTrace.size() - 1;
	}

	@Override
	public List<Step> getCallStack() {
		return callStack;
	}

	private List<tfsm_plaink3Trace.Steps.SpecificStep> getStepsForStates(int startingState, int endingState) {
		Predicate<tfsm_plaink3Trace.Steps.SpecificStep> predicate = s -> {
			final int stepStartingState = getStartingIndex(s);
			final int stepEndingState = getEndingIndex(s);
			return (stepEndingState == -1 || stepEndingState >= startingState) && stepStartingState <= endingState;
		};
		return traceRoot.getRootStep().getSubSteps().stream().filter(predicate).collect(Collectors.toList());
	}

	@Override
	public void notifyListeners() {
		for (ITraceListener listener : listeners) {
			listener.update();
		}
	}

	@Override
	public void addListener(ITraceListener listener) {
		if (listener != null) {
			listeners.add(listener);
		}
	}

	@Override
	public void removeListener(ITraceListener listener) {
		if (listener != null) {
			listeners.remove(listener);
		}
	}

	@Override
	public void update() {
		valueTraces.clear();
		valueTraces.addAll(getAllValueTraces());
		canBackValueCache.clear();
		notifyListeners();
	}

	@Override
	public Step getCurrentForwardStep() {
		if (!callStack.isEmpty()) {
			return callStack.get(callStack.size() - 1);
		}
		return null;
	}

	@Override
	public Step getCurrentBackwardStep() {
		return stepBackOverResult;
	}

	@Override
	public Step getCurrentBigStep() {
		return stepBackOutResult;
	}

	@Override
	public void jump(EObject o) {
		int idx = -1;
		if (o instanceof tfsm_plaink3Trace.States.State) {
			idx = statesTrace.indexOf(o);
		} else if (o instanceof tfsm_plaink3Trace.States.Value) {
			final tfsm_plaink3Trace.States.State state = ((tfsm_plaink3Trace.States.Value) o).getStatesNoOpposite()
					.get(0);
			idx = statesTrace.indexOf(state);
		}
		if (idx != -1) {
			jump(idx);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadLastState() {
		final int idx = statesTrace.size() - 1;
		final List<tfsm_plaink3Trace.Steps.SpecificStep> steps = getStepsForStates(idx, idx);
		tfsm_plaink3Trace.Steps.SpecificStep lastStep = null;
		while (!steps.isEmpty()) {
			lastStep = steps.get(steps.size() - 1);
			steps.clear();
			if (lastStep instanceof SequentialStep<?>) {
				steps.addAll(((SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) lastStep).getSubSteps());
			}
		}
		final int endingIndex = getEndingIndex(lastStep);
		if (endingIndex == -1 || endingIndex == idx) {
			jumpBeforeStep(lastStep);
		}
	}

	@Override
	public boolean stepInto() {
		if (stepIntoResult != null) {
			jumpBeforeStep(stepIntoResult);
			return true;
		}
		return false;
	}

	@Override
	public boolean stepOver() {
		if (stepOverResult != null) {
			jumpBeforeStep(stepOverResult);
			return true;
		}
		return false;
	}

	@Override
	public boolean stepReturn() {
		if (stepReturnResult != null) {
			jumpBeforeStep(stepReturnResult);
			return true;
		}
		return false;
	}

	@Override
	public boolean stepBackInto() {
		if (stepBackIntoResult != null) {
			jumpBeforeStep(stepBackIntoResult);
			return true;
		}
		return false;
	}

	@Override
	public boolean stepBackOver() {
		if (stepBackOverResult != null) {
			jumpBeforeStep(stepBackOverResult);
			return true;
		}
		return false;
	}

	@Override
	public boolean stepBackOut() {
		if (stepBackOutResult != null) {
			jumpBeforeStep(stepBackOutResult);
			return true;
		}
		return false;
	}

	@Override
	public boolean isInReplayMode() {
		return stepIntoResult != null;
	}

	@Override
	public void updateCallStack(Step step) {
		if (step instanceof tfsm_plaink3Trace.Steps.SpecificStep) {
			tfsm_plaink3Trace.Steps.SpecificStep step_cast = (tfsm_plaink3Trace.Steps.SpecificStep) step;
			final List<tfsm_plaink3Trace.Steps.SpecificStep> newPath = new ArrayList<>();
			newPath.add(step_cast);
			EObject container = step.eContainer();
			while (container != null && container instanceof tfsm_plaink3Trace.Steps.SpecificStep) {
				newPath.add(0, (tfsm_plaink3Trace.Steps.SpecificStep) container);
				container = container.eContainer();
			}
			computeExplorerState(newPath);
			update();
		} else {
			throw new IllegalArgumentException(
					"Tfsm_plaink3TraceExplorer expects specific steps and cannot handle this: " + step);
		}
	}
}
