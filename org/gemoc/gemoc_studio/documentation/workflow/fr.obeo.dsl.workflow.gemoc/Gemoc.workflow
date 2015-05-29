<?xml version="1.0" encoding="UTF-8"?>
<workflow:Workflow
    xmi:version="2.0"
    xmlns:xmi="http://www.omg.org/XMI"
    xmlns:workflow="http://www.example.org/workflow"
    name="Gemoc language workbench workflow">
  <categories
      name="Language workbench project">
    <steps name="xDSML definition"
        description="TODO"
        next="//@categories.0/@steps.1">
      <commands
          name="New GEMOC Language project"
          description="TODO">
        <artifacts
            name="Language workbench project"
            description="TODO"/>
        <artifacts
            name="xdsml file"
            description="TODO"/>
      </commands>
    </steps>
    <steps name="Domain Model definition (AS)"
        description="TODO"
        next="//@categories.0/@steps.2 //@categories.0/@steps.4 //@categories.0/@steps.3">
      <commands
          name="Create EMF Project"
          description="TODO">
        <artifacts
            name="EMF project"
            description="TODO"/>
        <artifacts
            name="ecore"
            description="TODO"/>
        <artifacts
            name="genmodel"
            description="TODO"/>
        <artifacts
            name="xdsml"
            description="TODO"
            type="update"/>
      </commands>
      <commands
          name="Select existing EMF project">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
    </steps>
    <steps name="Modelers definition (CS)"
        description="TODO"
        next="//@categories.0/@steps.6">
      <commands
          name="Select existing Tree editor">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
      <commands
          name="New Tree editor"
          description="TODO">
        <artifacts
            name="Edit project"
            description="TODO"/>
        <artifacts
            name="Editor project"
            description="TODO"/>
        <artifacts
            name="xdsml"
            description="TODO"
            type="update"/>
      </commands>
      <commands
          name="New Xtext editor"
          description="TODO">
        <artifacts
            name="Xtext project"
            description="TODO"/>
        <artifacts
            name="Xtext.ui project"
            description="TODO"/>
        <artifacts
            name="xdsml"
            description="TODO"
            type="update"/>
      </commands>
      <commands
          name="Select existing Xtext editor">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
      <commands
          name="Select existing Sirius editor">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
      <commands
          name="New Sirius editor"
          description="TODO">
        <artifacts
            name="Sirius specification project"
            description="TODO"/>
        <artifacts
            name="xdsml"
            description="TODO"
            type="update"/>
      </commands>
    </steps>
    <steps name="Execution Function and Data definition (DSA)"
        description="TODO"
        next="//@categories.0/@steps.5">
      <commands
          name="New Kermeta 3 project"
          description="TODO">
        <artifacts
            name="K3 project"
            description="TODO"/>
        <artifacts
            name="xdsml"
            description="TODO"
            type="update"/>
      </commands>
      <commands
          name="Select existing Kermeta 3 project">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
    </steps>
    <steps name="Concurrency Model definition (MoCC)"
        description="TODO"
        next="//@categories.0/@steps.5">
      <commands
          name="New MoCCML project">
        <artifacts
            name="moccml/ccslLib file"/>
        <artifacts
            name="xdsml"
            type="update"/>
        <artifacts
            name="eclipse plugin project"/>
      </commands>
      <commands
          name="Select existing MoCCML project">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
    </steps>
    <steps name="Behavioral observation definition (DSE)"
        description="TODO"
        next="//@categories.0/@steps.6">
      <commands
          name="New ECL file"
          description="TODO">
        <artifacts
            name="ecl file"
            description="TODO"/>
        <artifacts
            name="xdsml"
            description="TODO"
            type="update"/>
      </commands>
      <commands
          name="New Modelh'x project"
          description="TODO"/>
      <commands
          name="Select existing ECL project">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
    </steps>
    <steps name="Animators definition"
        description="TODO">
      <commands
          name="New Animation Viewpoint project">
        <artifacts
            name="xdsml"
            type="update"/>
        <artifacts
            name="Sirius specification project"
            description="TODO"/>
        <artifacts
            name="CS Sirius specificaiton project"
            type="update"/>
      </commands>
      <commands
          name="Select existing Animation Viewpoint project">
        <artifacts
            name="xdsml"
            type="update"/>
      </commands>
    </steps>
  </categories>
</workflow:Workflow>
