package org.gemoc.sample.tfsm.k3dsa.aspect

import org.gemoc.sample.tfsm.TimedSystem
import org.gemoc.sample.tfsm.TFSM

import static extension org.gemoc.sample.tfsm.k3dsa.aspect.TFSMAspect.*

class Main  {

	
	def public void main(TimedSystem system)
	{
		val tfsm = system.tfsms.get(0)
		
		val redState = tfsm.ownedStates.get(1)
		val greenState = tfsm.ownedStates.get(2)

		for (var i = 0 ; i < 2; i++)
		{
			tfsm.changeCurrentState(greenState)
			Thread.sleep(3000)
			tfsm.changeCurrentState(redState)
			Thread.sleep(3000)
		}		

		return
	}

}
