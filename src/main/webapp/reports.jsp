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

<h3 align="center">Reports</h3><br>

<table width="50%" border="1"  BORDERCOLOR="pink" align=center>
         <tr> <td>
		<div align="center">
             <a href=./workreport.jsp >WorkReport</a>
         </td></tr><tr><td>
		<div align="center">
             <a href=./employeeReport.jsp>Employee&nbspReport</a>
        </td></tr><tr><td>
		<div align="center">
             <a href=./Groupreport.jsp>Groups</a>
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