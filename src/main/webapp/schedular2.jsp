<html>
<head><title>this is for date and time</title>
<link href="default1.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="green">



<form action="./storeschedule">
<table>
<tr>
<td>
<input type="text"  name="date" readonly="readonly" value="<%= request.getParameter("dc") %>" >
<input type="text " name="schedule">
</td>
</tr>
<tr>
<td>
<a href="./schemdular.jsp">Add</a>
</td>
</tr>
<tr><input type="submit" name="submit" value="store"></tr>
</table>
</body>
</html>
