package org.gemoc.execution.engine.emfexecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.gemoc.execution.engine.emfexecution.manager.ProjectClassLoader;

import fr.inria.aoste.timesquare.backend.manager.visible.ConfigurationHelper;
import fr.inria.aoste.timesquare.launcher.core.inter.ISolverForBackend;

public class CodeExecutionHelper {

    private ISolverForBackend _solver = null;

    ConfigurationHelper configurationHelper = null;

    ProjectClassLoader pcl = new ProjectClassLoader();

    HashMap<String, Object> data = new HashMap<String, Object>();

    public CodeExecutionHelper(ConfigurationHelper _ch) {
        super();
        this.configurationHelper = _ch;
    }

    public void clear() {
        this.configurationHelper = null;
        this.pcl.clearCaches();
        this.pcl = null;
        this.data = null;
    }

    public ConfigurationHelper getConfigurationHelper() {
        return this.configurationHelper;
    }

    public HashMap<String, Object> getData() {
        return this.data;
    }

    public Object getData(String s) {
        return this.data.get(s);
    }

    public final ProjectClassLoader getPcl() {
        return this.pcl;
    }

    public ISolverForBackend getSolver() {
        return this._solver;
    }

    public void print(String s) {
        if (this.configurationHelper != null) {
            this.configurationHelper.print(s);
        }
    }

    public void println(String s) {
        if (this.configurationHelper != null) {
            this.configurationHelper.println(s);
        }
    }

    public void printlnError(String s) {
        if (this.configurationHelper != null) {
            this.configurationHelper.printlnError(s);
        }
    }

    public void printlnError(String s, Throwable e) {
        if (this.configurationHelper != null) {
            this.configurationHelper.printlnError(s, e);
        }
    }

    public Object putData(String s, Object o) {
        return this.data.put(s, o);
    }

    public String read() {
        String res = "";
        if (this.configurationHelper != null) {
            InputStreamReader isr = new InputStreamReader(this.configurationHelper.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            try {
                res = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public final void setConfigurationHelper(ConfigurationHelper ch, ISolverForBackend solver) {
        this.configurationHelper = ch;
        this._solver = solver;
    }

}
