<?xml version="1.0" encoding="UTF-8"?>
<workflow:Workflow xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:workflow="http://www.example.org/workflow" name="Gemoc language workbench workflow">
  <categories name="Language workbench project">
    <steps name="Create language workbench definition" description="TODO" next="//@categories.0/@steps.1">
      <commands name="Create language workbench" description="TODO">
        <artifacts name="Language workbench project" description="TODO"/>
        <artifacts name="xdsml file" description="TODO"/>
      </commands>
    </steps>
    <steps name="Define language" description="TODO" next="//@categories.0/@steps.2">
      <commands name="Create EMF Project" description="TODO">
        <artifacts name="EMF project" description="TODO"/>
        <artifacts name="ecore" description="TODO"/>
        <artifacts name="genmodel" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
    </steps>
    <steps name="Define editors" description="TODO" next="//@categories.0/@steps.3">
      <commands name="Create tree editor" description="TODO">
        <artifacts name="Edit project" description="TODO"/>
        <artifacts name="Editor project" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
      <commands name="Create Xtext editor" description="TODO">
        <artifacts name="Xtext project" description="TODO"/>
        <artifacts name="Xtext.ui project" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
      <commands name="Create Sirius editor" description="TODO">
        <artifacts name="Sirius specification project" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
    </steps>
    <steps name="Define DSA" description="TODO" next="//@categories.0/@steps.4">
      <commands name="K2" description="TODO">
        <artifacts name="K2 project" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
      <commands name="K3" description="TODO">
        <artifacts name="K3 project" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
    </steps>
    <steps name="Define MOC" description="TODO" next="//@categories.0/@steps.5">
      <commands name="Moc project" description="TODO"/>
    </steps>
    <steps name="DSE project" description="TODO" next="//@categories.0/@steps.6">
      <commands name="ECL" description="TODO">
        <artifacts name="ecl file" description="TODO"/>
        <artifacts name="xdsml" description="TODO" type="update"/>
      </commands>
      <commands name="Modelhex" description="TODO"/>
    </steps>
    <steps name="Animator" description="TODO"/>
  </categories>
</workflow:Workflow>
