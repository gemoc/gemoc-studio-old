package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardAspect extends GuardAspect {
}
