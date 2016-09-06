package org.gemoc.sample.tfsm.plaink3.xtfsm.trace.tracemanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.internal.spec.MatchSpec;
import org.eclipse.emf.compare.postprocessor.BasicPostProcessorDescriptorImpl;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.postprocessor.IPostProcessor.Descriptor.Registry;
import org.eclipse.emf.compare.postprocessor.PostProcessorDescriptorRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import fr.inria.diverse.trace.commons.model.trace.LaunchConfiguration;
import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.Step;
import fr.inria.diverse.trace.gemoc.api.ITraceExtractor;

public class Tfsm_plaink3TraceExtractor implements ITraceExtractor {

	private tfsm_plaink3Trace.SpecificTrace traceRoot;

	final private List<List<? extends tfsm_plaink3Trace.States.Value>> valueTraces = Collections
			.synchronizedList(new ArrayList<>());

	private List<tfsm_plaink3Trace.States.State> statesTrace;

	final private Map<tfsm_plaink3Trace.Steps.SpecificStep, Integer> stepToStartingIndex = new HashMap<>();
	final private Map<tfsm_plaink3Trace.Steps.SpecificStep, Integer> stepToEndingIndex = new HashMap<>();

	final private DefaultDeclarativeQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();

	final private Map<Integer, Boolean> ignoredValueTraces = new HashMap<>();

	public Tfsm_plaink3TraceExtractor() {
		configureDiffEngine();
	}

	private IDiffEngine diffEngine = null;

	private void configureDiffEngine() {
		IDiffProcessor diffProcessor = new DiffBuilder();
		diffEngine = new DefaultDiffEngine(diffProcessor) {
			@Override
			protected FeatureFilter createFeatureFilter() {
				return new FeatureFilter() {
					@Override
					protected boolean isIgnoredReference(Match match, EReference reference) {
						final String name = reference.getName();
						return name.equals("parent") || name.equals("states") || name.equals("statesNoOpposite");
					}
				};
			}
		};
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

	private ValueWrapper getValueWrapper(tfsm_plaink3Trace.States.Value value, int valueIndex) {
		List<tfsm_plaink3Trace.States.State> states = value.getStatesNoOpposite();
		tfsm_plaink3Trace.States.State firstState = states.get(0);
		final int firstStateIndex = statesTrace.indexOf(firstState);
		final int lastStateIndex = (int) (firstStateIndex + states.stream().distinct().count() - 1);
		return new ValueWrapper(value, firstStateIndex, lastStateIndex, valueIndex);
	}

	private tfsm_plaink3Trace.States.Value getValueAt(int traceIndex, int stateIndex) {
		tfsm_plaink3Trace.States.Value result = null;
		if (traceIndex >= 0 && traceIndex < valueTraces.size()) {
			final List<? extends tfsm_plaink3Trace.States.Value> valueTrace = valueTraces.get(traceIndex);
			final tfsm_plaink3Trace.States.State state = statesTrace.get(stateIndex);
			for (tfsm_plaink3Trace.States.Value value : valueTrace) {
				if (value.getStatesNoOpposite().contains(state)) {
					result = value;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public ValueWrapper getValueWrapper(int traceIndex, int stateIndex) {
		tfsm_plaink3Trace.States.Value value = getValueAt(traceIndex, stateIndex);
		if (value == null) {
			return null;
		}
		List<tfsm_plaink3Trace.States.State> states = value.getStatesNoOpposite();
		tfsm_plaink3Trace.States.State firstState = states.get(0);
		final int firstStateIndex = statesTrace.indexOf(firstState);
		final int lastStateIndex = (int) (firstStateIndex + states.stream().distinct().count() - 1);
		return new ValueWrapper(value, firstStateIndex, lastStateIndex, traceIndex);
	}

	private final IPostProcessor customPostProcessor = new IPostProcessor() {

		private final Function<EObject, String> getIdFunction = e -> e.eClass().getName();

		@Override
		public void postMatch(Comparison comparison, Monitor monitor) {
			final List<Match> matches = new ArrayList<>(comparison.getMatches());
			final List<Match> treatedMatches = new ArrayList<>();
			matches.forEach(m1 -> {
				matches.forEach(m2 -> {
					if (m1 != m2 && !treatedMatches.contains(m2)) {
						final EObject left;
						final EObject right;
						if (m1.getLeft() != null && m1.getRight() == null && m2.getLeft() == null
								&& m2.getRight() != null) {
							left = m1.getLeft();
							right = m2.getRight();
						} else if (m2.getLeft() != null && m2.getRight() == null && m1.getLeft() == null
								&& m1.getRight() != null) {
							left = m2.getLeft();
							right = m1.getRight();
						} else {
							return;
						}
						final String leftId = getIdFunction.apply(left);
						final String rightId = getIdFunction.apply(right);
						if (leftId.equals(rightId)) {
							comparison.getMatches().remove(m1);
							comparison.getMatches().remove(m2);
							final Match match = new MatchSpec();
							match.setLeft(left);
							match.setRight(right);
							comparison.getMatches().add(match);
						}
					}
				});
				treatedMatches.add(m1);
			});
		}

		@Override
		public void postDiff(Comparison comparison, Monitor monitor) {
		}

		@Override
		public void postRequirements(Comparison comparison, Monitor monitor) {
		}

		@Override
		public void postEquivalences(Comparison comparison, Monitor monitor) {
		}

		@Override
		public void postConflicts(Comparison comparison, Monitor monitor) {
		}

		@Override
		public void postComparison(Comparison comparison, Monitor monitor) {
		}
	};

	private List<Diff> compareEObjects(EObject e1, EObject e2) {

		if (e1 == e2) {
			return Collections.emptyList();
		}

		IPostProcessor.Descriptor descriptor = new BasicPostProcessorDescriptorImpl(customPostProcessor,
				Pattern.compile(".*"), null);

		Registry registry = new PostProcessorDescriptorRegistryImpl();
		registry.put(customPostProcessor.getClass().getName(), descriptor);

		final EMFCompare compare;

		compare = EMFCompare.builder().setPostProcessorRegistry(registry).setDiffEngine(diffEngine).build();

		final IComparisonScope scope = new DefaultComparisonScope(e1, e2, null);
		final Comparison comparison = compare.compare(scope);
		return comparison.getDifferences();
	}

	private void computeStateComparisonValue(final tfsm_plaink3Trace.States.State state,
			final List<tfsm_plaink3Trace.States.Value> values,
			final Map<tfsm_plaink3Trace.States.State, Integer> stateToComparisonValue,
			final List<tfsm_plaink3Trace.States.Value> observedValues, final int statesNb) {
		Integer stateComparisonValue = stateToComparisonValue.get(state);
		for (int i = 0; i < values.size(); i++) {
			final tfsm_plaink3Trace.States.Value value = values.get(i);
			int idx = -1;
			for (int j = 0; j < observedValues.size(); j++) {
				final tfsm_plaink3Trace.States.Value v1 = observedValues.get(j);
				final tfsm_plaink3Trace.States.Value v2 = value;
				if (v1.eClass() == v2.eClass() && compareEObjects(v1, v2).isEmpty()) {
					idx = j;
					break;
				}
			}
			final int pow = (int) Math.pow(statesNb, i);
			if (idx != -1) {
				if (stateComparisonValue == null) {
					stateComparisonValue = (idx + 1) * pow;
				} else {
					stateComparisonValue = stateComparisonValue + (idx + 1) * pow;
				}
			} else {
				observedValues.add(value);
				idx = observedValues.size();
				if (stateComparisonValue == null) {
					stateComparisonValue = idx * pow;
				} else {
					stateComparisonValue = stateComparisonValue + idx * pow;
				}
			}
			stateToComparisonValue.put(state, stateComparisonValue);
		}
	}

	@Override
	public Collection<List<EObject>> computeStateEquivalenceClasses() {
		return computeStateEquivalenceClasses(statesTrace);
	}

	@Override
	public Collection<List<EObject>> computeStateEquivalenceClasses(List<? extends EObject> states) {
		final Map<Integer, List<tfsm_plaink3Trace.States.State>> statesMap = new HashMap<>();
		final Map<tfsm_plaink3Trace.States.State, List<tfsm_plaink3Trace.States.Value>> stateToValues = new HashMap<>();
		// First we build the map of states, grouped by their number of dimensions
		// and we associate to each state the list of its values
		states.stream().distinct().map(e -> (tfsm_plaink3Trace.States.State) e).forEach(s -> {
			final List<tfsm_plaink3Trace.States.Value> values = getAllStateValues(s);
			stateToValues.put(s, values);
			final int size = values.size();
			List<tfsm_plaink3Trace.States.State> tmp = statesMap.get(size);
			if (tmp == null) {
				tmp = new ArrayList<>();
				statesMap.put(size, tmp);
			}
			tmp.add(s);
		});
		final int statesNb = stateToValues.keySet().size();

		final List<tfsm_plaink3Trace.States.Value> observedValues = new ArrayList<>();
		final Map<tfsm_plaink3Trace.States.State, Integer> stateToComparisonValue = new HashMap<>();

		for (Entry<Integer, List<tfsm_plaink3Trace.States.State>> entry : statesMap.entrySet()) {
			for (tfsm_plaink3Trace.States.State state : entry.getValue()) {
				final List<tfsm_plaink3Trace.States.Value> values = stateToValues.get(state);
				// Filling stateTocomparisonValue by side-effect
				computeStateComparisonValue(state, values, stateToComparisonValue, observedValues, statesNb);
			}
		}

		final Map<Integer, List<EObject>> accumulator = new HashMap<>();

		stateToComparisonValue.entrySet().stream().forEach(e -> {
			final tfsm_plaink3Trace.States.State state = e.getKey();
			final Integer n = e.getValue();
			if (n != null) {
				List<EObject> equivalentStates = accumulator.get(n);
				if (equivalentStates == null) {
					equivalentStates = new ArrayList<>();
					accumulator.put(n, equivalentStates);
				}
				equivalentStates.add(state);
			}
		});
		return accumulator.values();
	}

	@Override
	public boolean compareStates(EObject eObject1, EObject eObject2, boolean respectIgnored) {
		final tfsm_plaink3Trace.States.State state1;
		final tfsm_plaink3Trace.States.State state2;

		if (eObject1 instanceof tfsm_plaink3Trace.States.State) {
			state1 = (tfsm_plaink3Trace.States.State) eObject1;
		} else {
			return false;
		}

		if (eObject2 instanceof tfsm_plaink3Trace.States.State) {
			state2 = (tfsm_plaink3Trace.States.State) eObject2;
		} else {
			return false;
		}

		final List<tfsm_plaink3Trace.States.Value> values1 = getAllStateValues(state1);
		final List<tfsm_plaink3Trace.States.Value> values2 = getAllStateValues(state2);

		if (values1.size() != values2.size()) {
			return false;
		}

		final List<List<Diff>> result = new ArrayList<>();
		for (int i = 0; i < values1.size(); i++) {
			if (!respectIgnored || !isValueTraceIgnored(i)) {
				final tfsm_plaink3Trace.States.Value value1 = values1.get(i);
				final tfsm_plaink3Trace.States.Value value2 = values2.get(i);
				if (value1 != value2) {
					final List<Diff> diffs = compareEObjects(value1, value2);
					if (!diffs.isEmpty()) {
						result.add(diffs);
					}
				}
			}
		}

		return result.isEmpty();
	}

	public boolean compareSteps(EObject eObject1, EObject eObject2) {
		final tfsm_plaink3Trace.Steps.SpecificStep step1;
		final tfsm_plaink3Trace.Steps.SpecificStep step2;

		if (eObject1 instanceof tfsm_plaink3Trace.Steps.SpecificStep) {
			step1 = (tfsm_plaink3Trace.Steps.SpecificStep) eObject1;
		} else {
			return false;
		}

		if (eObject2 instanceof tfsm_plaink3Trace.Steps.SpecificStep) {
			step2 = (tfsm_plaink3Trace.Steps.SpecificStep) eObject2;
		} else {
			return false;
		}

		if (step1.eClass() == step2.eClass()) {
			return true;
		}

		return false;
	}

	public boolean compareStatesWithSteps(EObject eObject1, EObject eObject2, boolean respectIgnored) {
		final tfsm_plaink3Trace.States.State state1;
		final tfsm_plaink3Trace.States.State state2;

		if (eObject1 instanceof tfsm_plaink3Trace.States.State) {
			state1 = (tfsm_plaink3Trace.States.State) eObject1;
		} else {
			return false;
		}

		if (eObject2 instanceof tfsm_plaink3Trace.States.State) {
			state2 = (tfsm_plaink3Trace.States.State) eObject2;
		} else {
			return false;
		}

		if (compareStates(state1, state2, respectIgnored)) {
			final List<tfsm_plaink3Trace.Steps.SpecificStep> endedSteps1 = state1.getEndedSteps();
			final List<tfsm_plaink3Trace.Steps.SpecificStep> startedSteps1 = state1.getStartedSteps();
			final List<tfsm_plaink3Trace.Steps.SpecificStep> endedSteps2 = state2.getEndedSteps();
			final List<tfsm_plaink3Trace.Steps.SpecificStep> startedSteps2 = state2.getStartedSteps();
			if (endedSteps1.size() == endedSteps2.size() && startedSteps1.size() == startedSteps2.size()) {
				boolean result = true;
				for (int i = 0; i < endedSteps1.size(); i++) {
					final tfsm_plaink3Trace.Steps.SpecificStep endedStep1 = endedSteps1.get(i);
					final tfsm_plaink3Trace.Steps.SpecificStep endedStep2 = endedSteps2.get(i);
					if (!compareSteps(endedStep1, endedStep2)) {
						result = false;
						break;
					}
				}
				if (!result) {
					return false;
				}
				for (int i = 0; i < startedSteps1.size(); i++) {
					final tfsm_plaink3Trace.Steps.SpecificStep startedStep1 = startedSteps1.get(i);
					final tfsm_plaink3Trace.Steps.SpecificStep startedStep2 = startedSteps2.get(i);
					if (!compareSteps(startedStep1, startedStep2)) {
						result = false;
						break;
					}
				}
				return result;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean compareTraces(EObject eObject1, EObject eObject2, boolean respectIgnored) {
		final tfsm_plaink3Trace.SpecificTrace trace1;
		final tfsm_plaink3Trace.SpecificTrace trace2;

		if (eObject1 instanceof tfsm_plaink3Trace.SpecificTrace) {
			trace1 = (tfsm_plaink3Trace.SpecificTrace) eObject1;
		} else {
			return false;
		}

		if (eObject2 instanceof tfsm_plaink3Trace.SpecificTrace) {
			trace2 = (tfsm_plaink3Trace.SpecificTrace) eObject2;
		} else {
			return false;
		}

		final List<tfsm_plaink3Trace.States.State> states1 = trace1.getStatesTrace();
		final List<tfsm_plaink3Trace.States.State> states2 = trace2.getStatesTrace();

		if (states1.size() != states2.size()) {
			return false;
		}

		boolean result = true;

		for (int i = 0; i < states1.size(); i++) {
			final tfsm_plaink3Trace.States.State state1 = states1.get(i);
			final tfsm_plaink3Trace.States.State state2 = states2.get(i);
			if (!compareStatesWithSteps(state1, state2, respectIgnored)) {
				result = false;
				break;
			}
		}

		return result;
	}

	private List<tfsm_plaink3Trace.States.Value> getAllStateValues(tfsm_plaink3Trace.States.State state) {
		final List<List<? extends tfsm_plaink3Trace.States.Value>> traces = new ArrayList<>();
		final List<tfsm_plaink3Trace.States.Value> result = new ArrayList<>();
		for (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock tracedObject : ((tfsm_plaink3Trace.SpecificTrace) state
				.eContainer()).getTfsm_plaink3_tracedFSMClocks()) {
			traces.add(tracedObject.getNumberOfTicksSequence());
		}
		for (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent tracedObject : ((tfsm_plaink3Trace.SpecificTrace) state
				.eContainer()).getTfsm_plaink3_tracedFSMEvents()) {
			traces.add(tracedObject.getIsTriggeredSequence());
		}
		for (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM tracedObject : ((tfsm_plaink3Trace.SpecificTrace) state
				.eContainer()).getTfsm_plaink3_tracedTFSMs()) {
			traces.add(tracedObject.getCurrentStateSequence());
			traces.add(tracedObject.getLastStateChangeStepNumberSequence());
			traces.add(tracedObject.getStepNumberSequence());
		}
		for (int i = 0; i < traces.size(); i++) {
			if (!isValueTraceIgnored(i)) {
				final List<? extends tfsm_plaink3Trace.States.Value> trace = traces.get(i);
				for (tfsm_plaink3Trace.States.Value value : trace) {
					if (value.getStatesNoOpposite().contains(state)) {
						result.add(value);
						break;
					}
				}
			}
		}
		return result;
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

	public void loadTrace(tfsm_plaink3Trace.SpecificTrace root) {
		traceRoot = root;
		statesTrace = traceRoot.getStatesTrace();
		valueTraces.addAll(getAllValueTraces());
	}

	@Override
	public List<StepWrapper> getStepWrappers(int startingState, int endingState) {
		Predicate<tfsm_plaink3Trace.Steps.SpecificStep> predicate = s -> {
			final int stepStartingState = getStartingIndex(s);
			final int stepEndingState = getEndingIndex(s);
			return (stepEndingState == -1 || stepEndingState >= startingState) && stepStartingState <= endingState;
		};
		return traceRoot.getRootStep().getSubSteps().stream().filter(predicate).map(s -> getStepWrapper(s))
				.collect(Collectors.toList());
	}

	private boolean isStateBreakable(tfsm_plaink3Trace.States.State state) {
		final boolean b = state.getStartedSteps().size() == 1;
		if (b) {
			tfsm_plaink3Trace.Steps.SpecificStep s = state.getStartedSteps().get(0);
			return !(s instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_ImplicitStep
					|| s instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_ImplicitStep);
		}
		return true;
	}

	@Override
	public StateWrapper getStateWrapper(int stateIndex) {
		if (stateIndex > -1 && stateIndex < statesTrace.size()) {
			final tfsm_plaink3Trace.States.State state = statesTrace.get(stateIndex);
			return new StateWrapper(state, stateIndex, isStateBreakable(state));
		}
		return null;
	}

	@Override
	public List<StateWrapper> getStateWrappers(int start, int end) {
		final List<StateWrapper> result = new ArrayList<>();
		final int startStateIndex = Math.max(0, start);
		final int endStateIndex = Math.min(statesTrace.size() - 1, end);

		for (int i = startStateIndex; i < endStateIndex + 1; i++) {
			final tfsm_plaink3Trace.States.State state = statesTrace.get(i);
			result.add(new StateWrapper(state, i, isStateBreakable(state)));
		}

		return result;
	}

	@Override
	public List<ValueWrapper> getValueWrappers(int valueTraceIndex, int start, int end) {
		final List<ValueWrapper> result = new ArrayList<>();

		if (valueTraceIndex < valueTraces.size()) {
			final List<? extends tfsm_plaink3Trace.States.Value> valueTrace = valueTraces.get(valueTraceIndex);
			for (tfsm_plaink3Trace.States.Value value : valueTrace) {
				final int currentValueIndex = valueTrace.indexOf(value);
				ValueWrapper wrapper = getValueWrapper(value, currentValueIndex);
				if (wrapper.firstStateIndex < end && wrapper.lastStateIndex > start) {
					result.add(wrapper);
				}
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StepWrapper getStepWrapper(Step step) {
		if (step instanceof tfsm_plaink3Trace.Steps.SpecificStep) {
			final tfsm_plaink3Trace.Steps.SpecificStep step_cast = (tfsm_plaink3Trace.Steps.SpecificStep) step;
			final int startingIndex = getStartingIndex(step_cast);
			final int endingIndex = getEndingIndex(step_cast);
			final List<Step> subSteps = new ArrayList<>();
			if (step_cast instanceof SequentialStep<?>) {
				subSteps.addAll(((SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) step_cast).getSubSteps());
			}
			return new StepWrapper(step, startingIndex, endingIndex, subSteps);
		}
		return null;
	}

	@Override
	public int getNumberOfTraces() {
		return valueTraces.size();
	}

	@Override
	public int getStatesTraceLength() {
		return statesTrace.size();
	}

	@Override
	public int getValuesTraceLength(int traceIndex) {
		if (traceIndex > -1 && traceIndex < valueTraces.size()) {
			List<? extends tfsm_plaink3Trace.States.Value> trace = valueTraces.get(traceIndex);
			return trace.size();
		}
		return -1;
	}

	@Override
	public String getValueLabel(int traceIndex) {
		String attributeName = "";
		if (traceIndex > -1 && traceIndex < valueTraces.size()) {
			final List<? extends tfsm_plaink3Trace.States.Value> valueTrace = valueTraces.get(traceIndex);
			if (valueTrace.isEmpty()) {
				return "";
			}
			final tfsm_plaink3Trace.States.Value value = valueTrace.get(0);
			final EObject container = value.eContainer();
			final List<String> attributes = container.eClass().getEAllReferences().stream()
					.filter(r -> r.getName().endsWith("Sequence"))
					.map(r -> r.getName().substring(0, r.getName().length() - 8)).collect(Collectors.toList());
			if (!attributes.isEmpty()) {
				attributes.removeIf(s -> !value.getClass().getName().contains("_" + s + "_"));
				attributeName = attributes.get(0);
			}
			final Optional<EReference> originalObject = container.eClass().getEAllReferences().stream()
					.filter(r -> r.getName().equals("originalObject")).findFirst();
			if (originalObject.isPresent()) {
				final Object o = container.eGet(originalObject.get());
				if (o instanceof EObject) {
					final EObject eObject = (EObject) o;
					final QualifiedName qname = nameProvider.getFullyQualifiedName(eObject);
					if (qname == null) {
						return attributeName + " (" + eObject.toString() + ")";
					} else {
						return attributeName + " (" + qname.toString() + " :" + eObject.eClass().getName() + ")";
					}
				}
			}
		}
		return attributeName;
	}

	@Override
	public String getStateDescription(int stateIndex) {
		String result = "";
		for (int i = 0; i < valueTraces.size(); i++) {
			if (!isValueTraceIgnored(i)) {
				result += (i == 0 ? "" : "\n") + getValueDescription(i, stateIndex);
			}
		}
		return result;
	}

	@Override
	public String getValueDescription(int traceIndex, int stateIndex) {
		final EObject value = getValueAt(traceIndex, stateIndex);
		if (value == null) {
			return null;
		}
		final String description = getValueLabel(traceIndex) + " : " + value;
		return description;
	}

	@Override
	public LaunchConfiguration getLaunchConfiguration() {
		return traceRoot.getLaunchconfiguration();
	}

	@Override
	public void ignoreValueTrace(int trace, boolean ignore) {
		ignoredValueTraces.put(trace, ignore);
	}

	@Override
	public boolean isValueTraceIgnored(int trace) {
		Boolean result = ignoredValueTraces.get(trace);
		return result != null && result;
	}

	@Override
	public void update() {
		valueTraces.clear();
		valueTraces.addAll(getAllValueTraces());
	}
}
