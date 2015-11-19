package markedgraph.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import markedgraph.MarkedGraph
import markedgraph.Place
import markedgraph.Transition

import static extension markedgraph.aspects.PlaceAspect.*

@Aspect(className=MarkedGraph)
class MarkedGraphAspect {
	def public void initialize() {
		println("Graph " + _self.name + " initialized.")
		_self.places.forEach [ pl | pl.initialize ]
	}
}

@Aspect(className=Place)
class PlaceAspect {
	public int runtimeTokenCount
	
	// @Helper
	def public void initialize() {
		println("Place " + _self.name + ": initialized.")
		_self.runtimeTokenCount = _self.tokenCount
	}
}

@Aspect(className=Transition)
class TransitionAspect {
	def public void fire() {
		println("Transition " + _self.name + ": fired.")
		_self.inputs.forEach[ runtimeTokenCount = runtimeTokenCount - 1 ]
		_self.outputs.forEach[ runtimeTokenCount = runtimeTokenCount + 1 ]
	}
}
