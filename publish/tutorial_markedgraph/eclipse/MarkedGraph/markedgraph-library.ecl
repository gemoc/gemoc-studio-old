import 'platform:/resource/org.gemoc.sample.markedgraph.model/model/markedgraph.ecore'

ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/kernel.ccslLib"
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/CCSL.ccslLib"
ECLimport "platform:/resource/org.gemoc.sample.markedgraph.mocc/mocc/markedgraph.moccml"

package markedgraph

	context MarkedGraph
		def: initIt: Event = self.initialize()

	context Transition
		def: fireIt: Event = self.fire()

	context Place
		inv placeReadAndWrite:
			let delay: Integer = self.tokenCount in
				Relation placeReadWrite(self.output.fireIt, self.input.fireIt, delay)

	context MarkedGraph
        inv initFirst:
                let firstInit : Event = Expression OneTickAndNoMore(self.initIt) in
                let allFire : Event = Expression Union(self.transitions.fireIt) in
                let firstOfAllFire : Event = Expression OneTickAndNoMore(allFire) in
                Relation Precedes(firstInit, firstOfAllFire)

        inv onlyOneInit:
                let firstInit2 : Event = Expression OneTickAndNoMore(self.initIt) in
                Relation Coincides(self.initIt, firstInit2)

endpackage
