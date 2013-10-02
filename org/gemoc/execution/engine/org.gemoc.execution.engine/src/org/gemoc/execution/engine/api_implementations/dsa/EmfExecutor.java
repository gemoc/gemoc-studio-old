package org.gemoc.execution.engine.api_implementations.dsa;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.api_implementations.feedback.ObjectFeedbackData;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class EmfExecutor implements Executor {

	@Override
	public FeedbackData execute(DomainSpecificAction dsa) {
		return new ObjectFeedbackData((Object) true);
	}

	@Override
	public FeedbackData execute(DomainSpecificEvent dse) {
		return this.execute(dse.getAction());
	}

	@Override
	public void setModel(Resource modelResource) {
		// TODO Auto-generated method stub

	}

}
