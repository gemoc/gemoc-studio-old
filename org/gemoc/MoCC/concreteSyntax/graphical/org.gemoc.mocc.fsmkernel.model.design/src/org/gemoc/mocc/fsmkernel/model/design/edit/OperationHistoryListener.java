package org.gemoc.mocc.fsmkernel.model.design.edit;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.ui.texteditor.IUpdate;

/**
 * useless until..
 * @author Stfun
 */
public class OperationHistoryListener implements IOperationHistoryListener {
	private final IUndoContext context;
	private final IUpdate update;

	/**
	 * @param context 
	 * @param update 
	 *
	 */
	public OperationHistoryListener(IUndoContext context, IUpdate update) {
		this.context = context;
		this.update = update;
	}

	public void historyNotification(OperationHistoryEvent event) {
		final int type= event.getEventType();
		switch (type) {
			case OperationHistoryEvent.UNDONE:
			case OperationHistoryEvent.REDONE:
			case OperationHistoryEvent.OPERATION_NOT_OK:
			// if this is one of our operations
			if (event.getOperation().hasContext(context)) {
				update.update();
			}		
		}	
	}
}