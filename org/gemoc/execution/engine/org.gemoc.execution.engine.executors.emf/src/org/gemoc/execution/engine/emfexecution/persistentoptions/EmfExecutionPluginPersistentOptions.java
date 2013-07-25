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

import fr.inria.aoste.timesquare.backend.manager.visible.PersistentOptions;

public class EmfExecutionPluginPersistentOptions implements PersistentOptions {
    private static final long serialVersionUID = -9002690199800237614L;
    private String _airdFilePath = null;

    public EmfExecutionPluginPersistentOptions(String s) {
        this._airdFilePath = s;
    }

    public String get_di2FilePath() {
        return this._airdFilePath;
    }

    @Override
    public String getDescription() {
        return "the only relevant action is the name of the aird file and a way to retrieve the clock";
    }
}
