package org.gemoc.execution.engine.core;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionCheckpoint;

public final class CommandExecution {

	private CommandExecution() {
	}

	public static Object execute(TransactionalEditingDomain editingDomain, RecordingCommand command) {
		final CommandStack commandStack = editingDomain.getCommandStack();
		IExecutionCheckpoint checkpoint = IExecutionCheckpoint.CHECKPOINTS.get(editingDomain.getResourceSet());
		Object result = null;
		try {
			if (checkpoint != null) {
				checkpoint.allow(true);
			}
			commandStack.execute(command);
			if (command.getResult() != null && command.getResult().size() == 1) {
				result = command.getResult().iterator().next();
			}
		} finally {
			if (checkpoint != null) {
				checkpoint.allow(false);
			}
		}
		return result;
	}


}
