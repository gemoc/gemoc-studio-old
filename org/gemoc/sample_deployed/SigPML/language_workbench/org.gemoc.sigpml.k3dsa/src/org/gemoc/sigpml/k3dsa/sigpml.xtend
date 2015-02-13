package org.gemoc.sigpml.k3dsa

import cnrs.luchogie.up.InteractiveSwingPlotter
import cnrs.luchogie.up.SwingPlotter
import cnrs.luchogie.up.data.Figure

import com.google.common.collect.LinkedListMultimap

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import groovy.lang.Binding
import groovy.lang.GroovyShell

import java.util.ArrayList
import java.util.Map

import javax.swing.JFrame

import sigpmlextended.Agent
import sigpmlextended.HWComputationalResource
import sigpmlextended.InputPort
import sigpmlextended.NamedElement
import sigpmlextended.OutputPort
import sigpmlextended.Place
import sigpmlextended.Port
import sigpmlextended.System

import static extension org.gemoc.sigpml.k3dsa.InputPortAspect.*
import static extension org.gemoc.sigpml.k3dsa.OutputPortAspect.*
import static extension org.gemoc.sigpml.k3dsa.SystemAspect.*

@Aspect(className = HWComputationalResource)
class HWComputationalResourceAspect {
	public int currentExecCycle = 0

	def public void incCycle() {
		_self.currentExecCycle = _self.currentExecCycle + 1
		println("time in CPU " + _self.name + " = " + _self.currentExecCycle)
	}
}

@Aspect(className = Agent) 
class AgentAspect extends NamedElementAspect {
	private SwingPlotter plotter = new InteractiveSwingPlotter
	private JFrame frame = new JFrame
	private Figure figure = new Figure
	public int currentExecCycle = 0

	def public void isExecuting() {
		println(_self.name+'\n      isExecuting ('+_self.currentExecCycle+')')
		_self.currentExecCycle = _self.currentExecCycle + 1
	}

	def public void execute() {
		println(_self.name + "\n      execute (" + _self.currentExecCycle + ")")
		println("@ : " + _self.currentExecCycle + " sharedMemory:" + _self.system.sharedMemory)

		val outputPortNames = newArrayList
		_self.frame.setContentPane(_self.plotter)
		_self.frame.setSize(400, 400)

		val binding = new Binding
		binding.setVariable("plotter", _self.plotter)
		binding.setVariable("frame", _self.frame)

		val localTime = _self.currentExecCycle
		binding.setVariable("localTime", localTime)
		binding.setVariable("figure", _self.figure)

		for(Port p : _self.ownedPorts) { 
			if (p instanceof InputPort) {
				val params = newArrayList

				for (i : 0 ..<  p.rate) {
					println("start for rate params sharedMemory: " + _self.system.sharedMemory)

					val tmp = _self.system.sharedMemory.get(p.name).get(0)
					params.add(tmp)
					_self.system.sharedMemory.remove(p.name, tmp)

					println("end for rate params sharedMemory: " + _self.system.sharedMemory)
				}

				println("   in params: " + params)
				binding.setVariable(p.name, params)
			}
			else {
				outputPortNames.add(p.name)
			}
		}	

		/* reset sizeToRead */
		for (Port p : _self.ownedPorts) {
			if (p instanceof InputPort) {
				p.sizeToread = 0
			}
		}

		//val b = Platform.getBundle("org.gemoc.sigpml.k3dsa")
		//val ucl = b.adapt(BundleWiring).getClassLoader()
		val ucl = _self.class.classLoader
		val shell = new GroovyShell(ucl,binding)

		val res = shell.evaluate(_self.code) as Map<String, Object>

		if (res.containsValue("figure")) {
			_self.figure.addFigure(res.get("figure") as Figure)
		}

		for (String portName : outputPortNames) {
			_self.system.sharedMemory.put(portName, res.get(portName))
		}

		println("sharedMemory: " + _self.system.sharedMemory)
	}
}

@Aspect(className = InputPort)
class InputPortAspect extends NamedElementAspect {
	public int sizeToread = 0

	def int read() {
		_self.sizeToread = _self.sizeToread + 1
		return _self.sizeToread
	}
	
	def void logSizeToReadWhenZero()
	{
		println("*** sizeToRead is equal to 0 ***")
	}

	def void logSizeToReadWhenNotZero()
	{
		println("sizeToRead = " + _self.sizeToread)
	}

}

@Aspect(className = OutputPort)
class OutputPortAspect extends NamedElementAspect {
	public int sizeWritten = 0

	def public void write() {
		_self.sizeWritten = _self.sizeWritten + 1
	}
}

@Aspect(className = Place)
class PlaceAspect extends NamedElementAspect {
	public ArrayList<Object> fifo
	public boolean isInitialized = false
	public int currentSize = 0

	def private void initialize() {
		println("place " + _self.name + "is initializing")
		_self.fifo = newArrayList
		for(i:0 ..< _self.delay) {
			var Object initialObject = null
			_self.fifo.add(initialObject)
		}

		_self.currentSize = _self.fifo.size
	}

	def public void push() {
		if (!_self.isInitialized) {
			_self.initialize()
			_self.isInitialized = true
		}

		_self.itsOutputPort.sizeWritten = _self.itsOutputPort.sizeWritten - 1 

		println(_self.name + "push")
		println("sharedMemory: " + _self.system.sharedMemory)

		var fifo_view = _self.fifo
		val objTowrite = _self.system.sharedMemory.get(_self.itsOutputPort.name).get(0)

		_self.system.sharedMemory.remove(_self.itsOutputPort.name, objTowrite)
		_self.fifo.add(objTowrite)
		_self.currentSize = _self.fifo.size
		fifo_view = _self.fifo

		println(fifo_view)
		println("sharedMemory: " + _self.system.sharedMemory)
	}

	def public void pop() {
		if(! _self.isInitialized) {
			_self.initialize()
			_self.isInitialized = true
		}

		println(_self.name + "pop")
		println("sharedMemory: " + _self.system.sharedMemory)
		println(_self.fifo)

		val readedObject = _self.fifo.get(0)
		_self.fifo.remove(0)
		_self.currentSize = _self.fifo.size
		_self.system.sharedMemory.put(_self.itsInputPort.name, readedObject)

		println("sharedMemory: " + _self.system.sharedMemory)
	}
}

@Aspect(className=System)
class SystemAspect {
	public LinkedListMultimap sharedMemory
}

@Aspect(className=NamedElement)
abstract class NamedElementAspect {
	def System getSystem() {
		var contents = _self.eResource.contents
		val system = contents.findFirst[x | x instanceof org.gemoc.sigpml.System] as sigpmlextended.System
		
		if (system != null && system.sharedMemory == null)
			system.sharedMemory = LinkedListMultimap.create
			
		return system
	}
}
