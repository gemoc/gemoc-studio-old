package sigpml.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import sigpml.Application
import sigpml.Block
import sigpml.Connector


@Aspect(className=Application)
class ApplicationAspect {
	
}
  
@Aspect(className=Block)
class BlockAspect {
	public int currentExecCycle = 0

	def public void execute() {
		if ( _self.currentExecCycle < _self.cycles )
			_self.currentExecCycle = _self.currentExecCycle + 1
		else 
			_self.currentExecCycle = 0
		println(_self.name + "\n      execute (" + _self.currentExecCycle + ")" )				
	}
}

@Aspect(className=Connector)
class ConnectorAspect {

}