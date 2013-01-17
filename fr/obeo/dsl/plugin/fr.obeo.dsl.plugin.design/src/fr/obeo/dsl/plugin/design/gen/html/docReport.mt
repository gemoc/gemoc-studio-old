<%
metamodel /fr.obeo.dsl.plugin/model/plugin.ecore
%>

<%script type="plugin.Component" name="docReport" file="<%name%>.txt"%>

<html>
<body>
<h2><%name%> details</h2>
<%for (subComponents){%>
<h3><%name%></h3>
<p>
<%description%>
</p>
<ul>
<%for (ports){%>
 <li>
    <p><b><%name%></b> (<%kindName%>)  : <%description%></p>
   </li> 
<%}%>
</ul>
<%}%>
</body>
</html>

<%script type="Port" name="kindName" post="trim"%>
<%kind%>
