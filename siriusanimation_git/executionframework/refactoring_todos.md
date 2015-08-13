## actions to do on executionframework before distribution

* org.gemoc.execution.engine.trace.model
  * remove dependencies to ecl/feedback model
  * add our own MSE concept so we do not depend on timesquare for this
  * move out concepts related to concurrency and place them into a child ecore in concurrent execution engine
  * rename into org.gemoc.executionframework.executioncontext.trace.model
  
* org.gemoc.gemoc_language_workbench.api
  * move out concurrent related concepts such as :
    * api.moc.ISolver
    * INonDeterministicExecutionEngine
    * api.extension.deciders
    * ILogicalStepDecider
  * move out engine specific concepts suc as
    * IDeterministicExecutionEngine
  * clean IEngineAddon from concurrent concepts, move them to concurrent execution engine
* org.gemoc.execution.engine
  * rename into ??
  * move out ExecutionEngine concrete implementation (which is actually the ccsl-java concurrent version)