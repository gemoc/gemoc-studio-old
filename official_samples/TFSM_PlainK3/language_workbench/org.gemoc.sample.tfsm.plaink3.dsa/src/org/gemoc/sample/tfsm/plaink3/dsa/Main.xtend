package org.gemoc.sample.tfsm.plaink3.dsa

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.impl.EcorePackageImpl
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.transaction.TransactionalEditingDomain

import static extension org.gemoc.sample.tfsm.plaink3.dsa.FSMEventAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TFSMVisitorAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TFSMAspect.*
import org.gemoc.sample.tfsm.TimedSystem
import org.gemoc.sample.tfsm.impl.TfsmPackageImpl

class Main
{

	static def public void main(String[] args)
	{
		val system = loadModel
		main(system)
	}

	static def public void main(TimedSystem system)
	{
		val tfsm = system.tfsms.get(0)
		tfsm.init
		var i = 0
		while (i != 20)
		{

			if (i == 10)
			{
				tfsm.localEvents.forEach [ e |
					e.trigger
				]
			}

			tfsm.visit

			if (i == 10)
			{
				tfsm.localEvents.forEach[e|e.unTrigger]
			}

			i++
		}
	}

	static def private TimedSystem loadModel()
	{
		ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap().put("tfsm", new XMIResourceFactoryImpl());
		EcorePackageImpl.init();
		TfsmPackageImpl.init();

		val resourceSet = new ResourceSetImpl
		TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		val modelURI = createModelURI
		val resource = resourceSet.createResource(modelURI)
		resource.load(null)
		val system = resource.contents.get(0) as TimedSystem
		return system
	}

	static def private URI createModelURI()
	{
		val directory = System.getProperty("user.dir").replace("\\", "/");
		val modelURIAsString = directory + "/../../modeling_workbench" +
			"/org.gemoc.tfsm.plaink3.single_traffic_light_sample/single_traffic_light.tfsm"
		val modelURI = URI.createFileURI(modelURIAsString)
		return modelURI
	}

}
