/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.debug.ide.tests;

import fr.obeo.dsl.debug.DebugPackage;
import fr.obeo.dsl.debug.Variable;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEvent;
import fr.obeo.dsl.debug.ide.event.debugger.TerminatedReply;
import fr.obeo.dsl.debug.ide.event.model.DisconnectRequest;
import fr.obeo.dsl.debug.ide.event.model.ResumeRequest;
import fr.obeo.dsl.debug.ide.event.model.SetVariableValueRequest;
import fr.obeo.dsl.debug.ide.event.model.StartRequest;
import fr.obeo.dsl.debug.ide.event.model.StepIntoRequest;
import fr.obeo.dsl.debug.ide.event.model.StepOverRequest;
import fr.obeo.dsl.debug.ide.event.model.StepReturnRequest;
import fr.obeo.dsl.debug.ide.event.model.SuspendRequest;
import fr.obeo.dsl.debug.ide.event.model.TerminateRequest;
import fr.obeo.dsl.debug.ide.event.model.ValidateVariableValueRequest;
import fr.obeo.dsl.debug.ide.tests.event.TestEventProcessor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link fr.obeo.dsl.debug.ide.AbstractDSLDebugger AbstractDSLDebugger} class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLDebuggerTests {

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventStartRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.handleEvent(new StartRequest());

		assertTrue(debugger.hasStartCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventTerminateRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.handleEvent(new TerminateRequest());

		assertTrue(debugger.hasTerminateCall());
		assertTrue(debugger.isTerminated());
		assertEquals(1, target.getEvents().size());
		IDSLDebugEvent event = target.getEvents().get(0);
		assertTrue(event instanceof TerminatedReply);
		assertEquals(null, ((TerminatedReply)event).getThreadName());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventTerminateThreadRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.spawnRunningThread("thread", DebugPackage.eINSTANCE.getDebugFactory().createVariable());
		debugger.handleEvent(new TerminateRequest("thread"));

		assertTrue(debugger.hasTerminateThreadCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventSuspendRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.handleEvent(new SuspendRequest());

		assertTrue(debugger.hasSuspendCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventSuspendThreadRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.spawnRunningThread("thread", DebugPackage.eINSTANCE.getDebugFactory().createVariable());
		debugger.handleEvent(new SuspendRequest("thread"));

		assertTrue(debugger.hasSuspendThreadCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventResume() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.handleEvent(new ResumeRequest());

		assertTrue(debugger.hasResumeCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventResumeThreadRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		debugger.spawnRunningThread("thread", DebugPackage.eINSTANCE.getDebugFactory().createVariable());
		debugger.handleEvent(new ResumeRequest("thread"));

		assertTrue(debugger.hasResumeThreadCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventStepIntoRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		final Variable instruction = DebugPackage.eINSTANCE.getDebugFactory().createVariable();
		debugger.spawnRunningThread("thread", instruction);
		debugger.pushStackFrame("thread", "frame", instruction, instruction);
		debugger.handleEvent(new StepIntoRequest("thread", instruction));

		assertTrue(debugger.hasStepIntoCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventStepOverRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		final Variable instruction = DebugPackage.eINSTANCE.getDebugFactory().createVariable();
		debugger.spawnRunningThread("thread", instruction);
		debugger.pushStackFrame("thread", "frame", instruction, instruction);
		debugger.handleEvent(new StepOverRequest("thread", instruction));

		assertTrue(debugger.hasStepOverCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventStepReturnRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		final Variable instruction = DebugPackage.eINSTANCE.getDebugFactory().createVariable();
		debugger.spawnRunningThread("thread", instruction);
		debugger.pushStackFrame("thread", "frame", instruction, instruction);
		debugger.handleEvent(new StepReturnRequest("thread", instruction));

		assertTrue(debugger.hasStepReturnCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventDisconnectRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		final Variable instruction = DebugPackage.eINSTANCE.getDebugFactory().createVariable();
		debugger.spawnRunningThread("thread", instruction);
		debugger.pushStackFrame("thread", "frame", instruction, instruction);
		debugger.handleEvent(new DisconnectRequest());

		assertTrue(debugger.hasDisconnectCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventSetVariableValueRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		final Variable instruction = DebugPackage.eINSTANCE.getDebugFactory().createVariable();
		debugger.spawnRunningThread("thread", instruction);
		debugger.pushStackFrame("thread", "frame", instruction, instruction);
		debugger.variable("thread", "frame", "int", "variable", "value", false);
		debugger.handleEvent(new SetVariableValueRequest("thread", "frame", "variable", "value2"));

		assertTrue(debugger.hasSetVariableValueCall());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.debug.ide.IDSLDebugger#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)}.
	 */
	@Test
	public void handleEventValidateVariableValueRequest() {
		final TestEventProcessor target = new TestEventProcessor();
		final TestDSLDebugger debugger = new TestDSLDebugger(target);

		final Variable instruction = DebugPackage.eINSTANCE.getDebugFactory().createVariable();
		debugger.spawnRunningThread("thread", instruction);
		debugger.pushStackFrame("thread", "frame", instruction, instruction);
		debugger.variable("thread", "frame", "int", "variable", "value", false);
		debugger.handleEvent(new ValidateVariableValueRequest("thread", "frame", "variable", "value2"));

		assertTrue(debugger.hasValidateVariableValueCall());
	}

}
