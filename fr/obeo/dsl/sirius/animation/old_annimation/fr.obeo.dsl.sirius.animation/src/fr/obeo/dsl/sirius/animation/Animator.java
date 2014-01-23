package fr.obeo.dsl.sirius.animation;

import org.eclipse.emf.ecore.resource.ResourceSet;

public interface Animator {

	AnimationTarget start(ResourceSet set);

	void stepInto(StackFrame host);

	void stepOver(StackFrame host);

	void stepReturn(StackFrame host);

	void stepInto(Thread host);

	void stepOver(Thread host);

	void stepReturn(Thread host);
	
	void terminate(StackFrame host);

}
