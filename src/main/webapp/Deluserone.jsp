<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor=burlywood><center><form>
<jsp:useBean id="resuser" scope="session" class="org.cdsdemo.insurancemanagement.bo.RestoreUser" />  
<b>
<font face="monospace" size="5" color="brown">
<% String username=request.getParameter("uuser");
String str =resuser.deluser(username);
out.println(str);
%>
</font>
</b>
<br><a href="./usermanagement.jsp" ><font color=brown size=4>Back</a>
</form></center></body>