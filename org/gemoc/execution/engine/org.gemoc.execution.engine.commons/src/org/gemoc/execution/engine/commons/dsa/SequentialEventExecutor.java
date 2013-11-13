package org.gemoc.execution.engine.commons.dsa;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.dsa.executors.JavaEventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodNotFoundException;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * Composes several executors, personal sentinels and a default executor.
 * 
 * @author dvojtise
 * @author flatombe
 * 
 */
public class SequentialEventExecutor extends BasicEventExecutor {

	private Resource modelResource = null;
	protected List<EventExecutor> executors = new ArrayList<EventExecutor>();
	private Collection<BytecodeSentinel> personalSentinels = new ArrayList<BytecodeSentinel>();
	private EventExecutor defaultExecutor = new JavaEventExecutor();

	public SequentialEventExecutor() {
	}

	public SequentialEventExecutor(EventExecutor defaultExecutor) {
		this.defaultExecutor = defaultExecutor;
	}

	public void addExecutor(EventExecutor newexecutor) {
		this.executors.add(newexecutor);
	}

	/**
	 * First, checks if one of the owned executors has a sentinel that can find
	 * a method corresponding to the DSA in the bytecode. If that is the case,
	 * then the owning executor of the sentinel is responsible for executing the
	 * DSA. If that is not the case, then we search through the personal
	 * sentinels of this executor for one sentinel able to find a method
	 * corresponding to the DSA. If one is found, then the sentinel is added to
	 * the defaultExecutor which is promoted responsible for executing the
	 * bytecode. Else returns null.
	 */
	public FeedbackData execute(ModelSpecificAction msa) {
		Method method = null;
		EventExecutor associatedExecutor = null;

		for (EventExecutor executor : executors) {
			for (BytecodeSentinel sentinel : executor.getSentinels()) {
				try {
					method = sentinel.getMethodFromAction(msa);
				} catch (MethodNotFoundException e) {
					Activator.getMessagingSystem().warn(
							this.getClass().getName()
									+ " could not find method of the action "
									+ msa.toString(), Activator.PLUGIN_ID);
				}
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
				try {
					method = sentinel.getMethodFromAction(msa);
				} catch (MethodNotFoundException e) {
					Activator.getMessagingSystem().warn(
							this.getClass().getName()
									+ " could not find method of the action "
									+ msa.toString(), Activator.PLUGIN_ID);
				}
				if (method != null) {
					spottingSentinel = sentinel;
					break;
				}
			}
			this.defaultExecutor.addSentinel(spottingSentinel);
			associatedExecutor = this.defaultExecutor;
		}

		if (method != null & associatedExecutor != null) {
			return associatedExecutor.execute(msa);
		} else {
			return null;
		}
	}

	@Override
	public List<FeedbackData> execute(ModelSpecificEvent dse) {
		return this.execute(dse.getActions());
	}

	@Override
	public Collection<BytecodeSentinel> getSentinels() {
		Collection<BytecodeSentinel> res = new ArrayList<BytecodeSentinel>();
		for (EventExecutor executor : this.executors) {
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
