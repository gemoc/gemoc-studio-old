package fr.obeo.dsl.plugin.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import fr.obeo.dsl.plugin.Bundle;
import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.LogicalArchitecture;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;

public class PluginsServices {

	public List<EObject> allEPackages(EObject ctx) {
		List<EObject> result = new ArrayList<EObject>();
		Session sess = SessionManager.INSTANCE.getSession(ctx);
		if (sess != null) {
			for (Resource res : sess.getSemanticResources()) {
				Iterator<EObject> it = res.getAllContents();
				while (it.hasNext()) {
					EObject cur = it.next();
					if (cur instanceof EPackage) {
						result.add(cur);
					}
				}
			}
		}

		return result;
	}
	
	public List<EObject> allLogicalArchitectures(EObject ctx) {
		List<EObject> result = new ArrayList<EObject>();
		Session sess = SessionManager.INSTANCE.getSession(ctx);
		if (sess != null) {
			for (Resource res : sess.getSemanticResources()) {
				Iterator<EObject> it = res.getAllContents();
				while (it.hasNext()) {
					EObject cur = it.next();
					if (cur instanceof LogicalArchitecture) {
						result.add(cur);
					}
				}
			}
		}

		return result;
	}
	
	public List<EObject> allEClasses(EObject ctx) {
		List<EObject> result = new ArrayList<EObject>();
		Session sess = SessionManager.INSTANCE.getSession(ctx);
		if (sess != null) {
			for (Resource res : sess.getSemanticResources()) {
				Iterator<EObject> it = res.getAllContents();
				while (it.hasNext()) {
					EObject cur = it.next();
					if (cur instanceof EClass) {
						result.add(cur);
					}
				}
			}
		}

		return result;
	}
	
	public List<EObject> allPlugins(EObject ctx) {
		List<EObject> result = new ArrayList<EObject>();
		Session sess = SessionManager.INSTANCE.getSession(ctx);
		if (sess != null) {
			for (Resource res : sess.getSemanticResources()) {
				Iterator<EObject> it = res.getAllContents();
				while (it.hasNext()) {
					EObject cur = it.next();
					if (cur instanceof Bundle) {
						result.add(cur);
					}
				}
			}
		}

		return result;
	}
	
	public List<EObject> allComponents(EObject ctx) {
		List<EObject> result = new ArrayList<EObject>();
		Session sess = SessionManager.INSTANCE.getSession(ctx);
		if (sess != null) {
			for (Resource res : sess.getSemanticResources()) {
				Iterator<EObject> it = res.getAllContents();
				while (it.hasNext()) {
					EObject cur = it.next();
					if (cur instanceof Component) {
						result.add(cur);
					}
				}
			}
		}

		return result;
	}

}
