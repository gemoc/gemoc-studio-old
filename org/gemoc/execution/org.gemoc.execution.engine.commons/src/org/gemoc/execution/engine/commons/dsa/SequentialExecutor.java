package org.gemoc.execution.engine.commons.dsa;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.dsa.executors.JavaExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * Composes several executors, personal sentinels and a default executor.
 * 
 * @author dvojtise
 * 
 */
public class SequentialExecutor implements Executor {

	private Resource modelResource = null;
	protected List<Executor> executors = new ArrayList<Executor>();
	private Collection<BytecodeSentinel> personalSentinels = new ArrayList<BytecodeSentinel>();
	private Executor defaultExecutor = new JavaExecutor();

	public SequentialExecutor() {
	}

	public SequentialExecutor(Executor defaultExecutor) {
		this.defaultExecutor = defaultExecutor;
	}

	public void addExecutor(Executor newexecutor) {
		this.executors.add(newexecutor);
	}

	/**
	 * First, checks if one of the owned executors has a sentinel that can find
	 * a method corresponding to the DSA in the bytecode. If that is the case,
	 * then the owning executor of the sentinel is responsbible for executing
	 * the DSA. If that is not the case, then we search through the personal
	 * sentinels of this executor for one sentinel able to find a method
	 * corresponding to the DSA. If one is found, then the sentinel is added to
	 * the defaultExecutor which is promoted responsible for executing the
	 * bytecode. Else returns null.
	 */
	@Override
	public FeedbackData execute(DomainSpecificAction dsa) {
		Method method = null;
		Executor associatedExecutor = null;

		for (Executor executor : executors) {
			for (BytecodeSentinel sentinel : executor.getSentinels()) {
				method = sentinel.getMethodFromAction(dsa);
				if (method != null) {
					break;
				}
			}
			if (method != null) {
				associatedExecutor = executor;
				break;
			}
		}

		if (method == null | associatedExecutor == null) {
			BytecodeSentinel spottingSentinel = null;
			for (BytecodeSentinel sentinel : this.personalSentinels) {
				method = sentinel.getMethodFromAction(dsa);
				if (method != null) {
					spottingSentinel = sentinel;
					break;
				}
			}
			this.defaultExecutor.addSentinel(spottingSentinel);
			associatedExecutor = this.defaultExecutor;
		}

		if (method != null & associatedExecutor != null) {
			return associatedExecutor.execute(dsa);
		} else {
			return null;
		}
	}

	@Override
	public FeedbackData execute(DomainSpecificEvent dse) {
		return this.execute(dse.getAction());
	}

	@Override
	public void setModel(Resource modelResource) {
		this.modelResource = modelResource;
	}

	@Override
	public Collection<BytecodeSentinel> getSentinels() {
		Collection<BytecodeSentinel> res = new ArrayList<BytecodeSentinel>();
		for (Executor executor : this.executors) {
			res.addAll(executor.getSentinels());
		}
		res.addAll(this.personalSentinels);
		return res;
	}

	@Override
	public void addSentinel(BytecodeSentinel sentinel) {
		this.personalSentinels.add(sentinel);
	}
}
