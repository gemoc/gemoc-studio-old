/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardAspect extends GuardAspect {
}
