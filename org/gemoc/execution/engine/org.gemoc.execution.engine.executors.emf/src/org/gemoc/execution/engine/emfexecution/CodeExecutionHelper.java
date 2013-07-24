package org.gemoc.execution.engine.emfexecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.gemoc.execution.engine.emfexecution.manager.ProjectClassLoader;

import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;
import fr.inria.aoste.timesquare.launcher.core.inter.ISolverForBackend;
public class CodeExecutionHelper {

	private ISolverForBackend _solver=null;
	
	public final void setConfigurationHelper(ConfigurationHelper ch,ISolverForBackend solver) {
		this.configurationHelper = ch;
		this._solver = solver;
	}

	public ConfigurationHelper getConfigurationHelper(){
		return configurationHelper;
	}
	
	public ISolverForBackend getSolver(){
		return _solver;
	}
	
	ConfigurationHelper configurationHelper = null;
	
	ProjectClassLoader pcl = new ProjectClassLoader();

	HashMap<String, Object> data = new HashMap<String, Object>();

	public HashMap<String, Object> getData() {
		return data;
	}

	public Object getData(String s) {
		return data.get(s);
	}

	public Object putData(String s, Object o) {
		return data.put(s, o);
	}

	public CodeExecutionHelper(ConfigurationHelper _ch) {
		super();
		configurationHelper = _ch;
	}

	public final ProjectClassLoader getPcl() {
		return pcl;
	}

	public void print(String s) {
		if (configurationHelper != null) {
			configurationHelper.print(s);
		}
	}

	public void println(String s) {
		if (configurationHelper != null) {
			configurationHelper.println(s);
		}
	}

	public String read() {
		String res="";
		if (configurationHelper != null) {
			InputStreamReader isr = new InputStreamReader(configurationHelper.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			try {
				res =br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	public void printlnError(String s) {
		if (configurationHelper != null) {
			configurationHelper.printlnError(s);
		}
	}

	public void printlnError(String s, Throwable e) {
		if (configurationHelper != null) {
			configurationHelper.printlnError(s, e);
		}
	}

	public void clear() {
		configurationHelper = null;
		pcl.clearCaches();
		pcl = null;
		data = null;
	}

}
