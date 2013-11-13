package org.gemoc.execution.engine.commons.dsa.executors;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.dsa.BasicEventExecutor;
import org.gemoc.execution.engine.commons.dsa.DataConverter;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class Kermeta3EventExecutor extends BasicEventExecutor {

	private IDSAExecutor dsaExecutor;

	public Kermeta3EventExecutor(ClassLoader classLoader, String bundleSymbolicName, IDSAExecutor dsaExecutor) {
		this.dsaExecutor = dsaExecutor;
	}

	@Override
	public FeedbackData execute(ModelSpecificAction msa) {
		List<Object> parameters = new ArrayList<Object>();
		//parameters.add((Object) msa.getTarget());
		parameters.addAll(msa.getParameters());

		try {
			Activator.getMessagingSystem().debug(msa.getTarget().toString(), Activator.PLUGIN_ID);
			Activator.getMessagingSystem().debug(msa.getOperation().getName().toString(), Activator.PLUGIN_ID);
			Activator.getMessagingSystem().debug(parameters.toString(), Activator.PLUGIN_ID);
			Object res = this.dsaExecutor.execute((Object) msa.getTarget(), msa
					.getOperation().getName(), (ArrayList<Object>) parameters);
			Activator.getMessagingSystem().debug(res.toString(),
					Activator.PLUGIN_ID);
			return DataConverter.convertToFeedbackData(res, msa);
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Kermeta3 method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

	@Override
	public List<FeedbackData> execute(ModelSpecificEvent dse) {
		return this.execute(dse.getActions());
	}

}
