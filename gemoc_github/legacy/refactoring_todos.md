## actions to do on executionengine.ccsljava before distribution

* org.gemoc.execution.engine.io
  * rename as org.gemoc.executionengine.ccsljava.ui
  * move out the code for plainK3 to the equivalent plugin in executionengine.java
  * remove dependency to fr.obeo.timeline.view which is supposed to be in concurrentviews and accessible via addon
  * define concurrent addon specification