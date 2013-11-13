package org.gemoc.execution.engine.commons.dsa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public abstract class BasicEventExecutor implements EventExecutor {
	protected Resource modelResource = null;
	

	public BasicEventExecutor() {
		
	}

	@Override
	public abstract FeedbackData execute(ModelSpecificAction msa);

	/**
	 * A list of Actions is execute sequentially.
	 * 
	 * @param actions
	 * @return
	 */
	protected List<FeedbackData> execute(List<ModelSpecificAction> actions) {
		List<FeedbackData> res = new ArrayList<FeedbackData>();
		for (ModelSpecificAction action : actions) {
			res.add(this.execute(action));
		}
		return res;
	}

	@Override
	public abstract List<FeedbackData> execute(ModelSpecificEvent dse);

	@Override
	public void setModel(Resource modelResource) {
		this.modelResource = modelResource;
	}

	@Override
	public Collection<BytecodeSentinel> getSentinels() {
		return null;
	}

	@Override
	public void addSentinel(BytecodeSentinel sentinel) {
		
	}

}
