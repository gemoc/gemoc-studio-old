/*****************************************************************************
 * Copyright (c) 2013 AOSTE I3S/UNS/INRIA.
 * 
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Julien DeAntoni julien.deantoni@polytech.unice.fr (AOSTE
 * I3S/UNS/INRIA) initial API and implementation
 * 
 *****************************************************************************/

package org.gemoc.execution.engine.emfexecution.persistentoptions;

import java.util.ArrayList;

import fr.inria.aoste.timesquare.backend.manager.visible.ClockEntity;
import fr.inria.aoste.timesquare.backend.manager.visible.PersistentOptions;
import fr.inria.aoste.timesquare.trace.util.ReferenceNameBuilder;
import fr.inria.aoste.trace.ModelElementReference;

public class EmfExecutionPersistentOptions implements PersistentOptions {

    /**
	 * 
	 */
    private static final long serialVersionUID = -6900990210439069137L;

    protected String _methodName = null;

    protected String _objectQNane = null;
    protected String _jarFilePath = null;
    protected ArrayList<String> clocksQualifiedNameToForce = null;

    public EmfExecutionPersistentOptions() {
        super();
    }

    public EmfExecutionPersistentOptions(String methodName, String objectQualifiedName,
            ArrayList<ClockEntity> clocksToForce, String jarFilePath) {
        this._methodName = methodName;
        this._objectQNane = objectQualifiedName;
        this._jarFilePath = jarFilePath;

        this.clocksQualifiedNameToForce = new ArrayList<String>();

        String separator = "::";
        for (ClockEntity ce : clocksToForce) {
            ModelElementReference mer = ce.getModelElementReference();
            String qualifiedName = ReferenceNameBuilder.buildQualifiedName(mer, separator);
            this.clocksQualifiedNameToForce.add(qualifiedName);
        }

    }

    public ArrayList<String> getClocksQualifiedNameToForce() {
        return this.clocksQualifiedNameToForce;
    }

    @Override
    public String getDescription() {
        return "TODO";
    }

    public String getJarFilePath() {
        return this._jarFilePath;
    }

    public String getMethodName() {
        return this._methodName;
    }

    public String getObjectQualifiedName() {
        return this._objectQNane;
    }

}
