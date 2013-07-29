package fr.obeo.dsl.sirius.animation;

import java.util.Iterator;

public class StackFrameSpec {

	private StackFrame frame;

	public StackFrameSpec(StackFrame fr) {
		this.frame = fr;
	}

	public Variable getOrCreateVariable(String name) {
		Variable found = null;
		Iterator<Variable> it = frame.getVariables().iterator();
		while (found == null && it.hasNext()) {
			Variable cur = it.next();
			if (name.equals(cur.getName()))
				found = cur;
		}
		if (found == null) {
			found = AnimationFactory.eINSTANCE.createVariable();
			found.setName(name);
			frame.getVariables().add(found);
		}
		return found;
	}

	public StackFrame self() {
		return this.frame;
	}

	public boolean isState(TargetState suspended) {
		if (frame.getParent() != null && frame.getParent().getParent() != null)
			return suspended == frame.getParent().getParent().getState();
		return suspended == TargetState.TERMINATED;
	}

}
