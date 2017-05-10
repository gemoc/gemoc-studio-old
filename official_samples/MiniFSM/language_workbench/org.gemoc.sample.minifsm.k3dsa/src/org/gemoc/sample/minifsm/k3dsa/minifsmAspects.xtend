package org.gemoc.sample.minifsm.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.gemoc.sample.minifsm.MiniStateMachine
import org.gemoc.sample.minifsm.Transition
import org.gemoc.sample.minifsm.State

import static extension org.gemoc.sample.minifsm.k3dsa.MiniStateMachineAspect.*
import static extension org.gemoc.sample.minifsm.k3dsa.TransitionAspect.*
import static extension org.gemoc.sample.minifsm.k3dsa.StateAspect.*

@Aspect(className=MiniStateMachine)
class MiniStateMachineAspect {

}

@Aspect(className=Transition)
class TransitionAspect {

}

@Aspect(className=State)
class StateAspect {

}



