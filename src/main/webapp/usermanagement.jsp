<html>

<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ include file="../Common.jsp" %>
<%
      String group=(String)session.getAttribute("group");
       if(group.equals("admin")){

%>
<body bgcolor="burlywood">
   <br><br>
<br>
<p ><b><div align="center"><font size=4 face=arial  color=pink>USER MANAGEMENT</font></p>
<table width="50%" border="1"  BORDERCOLOR="pink" align=center>
         <tr> <td>
         <font color="pink">
		<div align="center">
             <a href=./adduser.jsp >Create&nbspUser</a>
         </td></tr><tr><td>
		<div align="center">

             <a href=./updateuser.jsp>Update&nbspUser</a>
       </td></tr><tr><td>

		<div align="center">

             <a href=./Deluser.jsp>Delete&nbspUser</a>
        </td></tr>
</table>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</body>
</html>