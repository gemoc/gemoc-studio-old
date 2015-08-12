## actions to do on executionframework before distribution

* org.gemoc.execution.engine.trace.model
  * remove dependencies to ecl/feedback model
  * add our own MSE concept so we do not depend on timesquare for this
  * move out concepts related to concurrency and place them into a child ecore in concurrent execution engine
  * rename into org.gemoc.executionframework.executioncontext.trace.model
