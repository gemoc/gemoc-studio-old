package fr.obeo.dsl.sirius.animation;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.sirius.animation.impl.StackFrameImpl;

public class StackFrameCustomImpl extends StackFrameImpl {

	@Override
	public StackFrame newFrame(EObject executionEnvironment) {
		StackFrame newOne = AnimationFactory.eINSTANCE.createStackFrame();
		newOne.setExecutionEnvironment(executionEnvironment);
		newOne.setCurrentInstruction(executionEnvironment);
		newOne.setParentStack(this);
		if (getParent() != null) {
			getParent().getStackFrames().add(0, newOne);
			getParent().setTopStackFrame(newOne);
		}
		return newOne;
	}

	@Override
	public StackFrame popFrame() {
		if (getParent() != null) {
			getParent().setTopStackFrame(getParentStack());
//			getParent().getStackFrames().remove(this);
		}
		return getParentStack();
	}

	public Variable getOrCreateVariable(String name) {
		Variable found = null;
		Iterator<Variable> it = getVariables().iterator();
		while (found == null && it.hasNext()) {
			Variable cur = it.next();
			if (name.equals(cur.getName()))
				found = cur;
		}
		if (found == null) {
			found = AnimationFactory.eINSTANCE.createVariable();
			found.setName(name);
			getVariables().add(found);
		}
		return found;
	}

	public boolean is(TargetState suspended) {
		if (getParent() != null && getParent().getParent() != null)
			return suspended == getParent().getParent().getState();
		return suspended == TargetState.TERMINATED;
	}

}
