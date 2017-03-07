<html>
<link href="default1.css" rel="stylesheet" type="text/css" />

<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../log.jsp" %>
<hr noshade="noshade" size="3"></hr>
<table width="100%" height="60%" align="center">
<tr><td>
<body >
<table width="100%" height="60%" align="center">
<tr><td>
        <%

session.invalidate();
%>
<p align="center">
<h3 align="center"><b><font face="monospace"  color="pink">You are Successfully Logged out</font></b></h3>
<br><br><br>  
 <p><h3 align="center"><font face="monospace"  color="pink">Thank You</font></h3>
  <p><h3 align="center"><font face="monospace"  color="pink">for using </font><font face="ARIAL"  color="pink"><i><b>Insurance Management Portal</b></i></font></h3>  
  <br> <br>     
   <P><h3 align="center"><a  href="./login.htm"><font face="monospace" >
   Re-Login</font></a></h3>
   <br>  <br>  <br>  <br>  
<hr noshade="noshade" size="3"></hr>
<p align="center" ><h4>&copy;IMP - 2017</h4>
</td></tr></body></td></tr></table>
</html>