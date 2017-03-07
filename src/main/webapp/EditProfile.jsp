<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<jsp:useBean id="updateuser" scope="session" class="org.cdsdemo.insurancemanagement.bo.UpdateUser" />
<body >
 

<form name="f1" action="./restoreuser.jsp">
<%
     
         
        String uuser=(String)session.getAttribute("user");
        System.out.println("----------"+uuser);
System.out.println("objecthashcode"+updateuser);
     updateuser.getuser(uuser);

%>

<p ><H3 align="center"><font face=arial color=pink>Edit your&nbspProfile </H3>
<br>
<table align="center" border="0">
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>Uname::</b>
      </td>  <td>        
<input type="text" name="uname" value=<jsp:getProperty  name="updateuser"  property='uname'  />></td></tr> 
<input type="hidden" name="passwd" value=<jsp:getProperty  name="updateuser"  property='passwd'  />>
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>Fname::</b>
      </td>  <td>          
<input type="text" name="fname" value=<jsp:getProperty  name="updateuser"  property='fname'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>Lname::</b>
      </td>  <td>          
<input type="text" name="lname" value=<jsp:getProperty  name="updateuser"  property='lname'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>Address::</b>
      </td>  <td>          
<textarea name="address" id="address"><jsp:getProperty  name="updateuser"  property='address'  /></textarea>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>Phone::</b>
      </td>  <td>          
<input type="text" name="phone" value=<jsp:getProperty  name="updateuser"  property='phone'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>MailId::</b>
      </td>  <td>          
<input type="text" name="mailid" value=<jsp:getProperty  name="updateuser"  property='mailid'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font face=arial color=pink>GroupId::</b>
      </td>  <td>          
<input type="text" name="groupid" value=<jsp:getProperty  name="updateuser"  property='groupid'  />>
</td></tr><tr> <td>   <b><font face=arial color=pink>Branch::</b>      </td><td> 
<input type="text" name="branch" value=<jsp:getProperty  name="updateuser"  property='branch'  />>
</td></tr><tr><td>
<input type="submit" id="inputsubmit1" name="submit" value="submit">
<input type="Button" id="inputsubmit1" value="Back" align="middle" onClick="window.history.back()">
</td></tr></table>
</form>

</body>
</html>