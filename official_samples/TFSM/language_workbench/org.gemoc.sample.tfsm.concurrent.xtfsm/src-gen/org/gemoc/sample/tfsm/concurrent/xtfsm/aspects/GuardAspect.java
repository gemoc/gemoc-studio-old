package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Guard;

@Aspect(className = Guard.class)
@SuppressWarnings("all")
public abstract class GuardAspect extends NamedElementAspect {
}
