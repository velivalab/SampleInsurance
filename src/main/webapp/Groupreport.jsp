<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="burlywood">
<%
      String group=(String)session.getAttribute("group");
       if(group.equals("admin")){

%>
<form >

   <br><br>
<br>
<br>
<br>

<h3 align="center"><b><font color=pink>GROUP REPORT</b></h3><BR>
<table width="60%"  align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center">
             <b><font color=pink>GroupName</b>
         </td>  <td><div align="center">
            <b><font color=pink>Users</b>
         </td>  </tr>
<%

	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();                            
                                 st=c.createStatement();                                   
                                String user=(String)session.getAttribute("user");                                   
    rs=st.executeQuery("select * from groupusers order by groupid");
                              
while(rs.next()){              
           %>
  <tr> <td width="30%">
		<div align="center">
            <%=rs.getString(1) %>
          
         </td>  <td width="30%"><div align="center">
        
              <%=rs.getString(2) %>
         </td>  
            <%}%>
         </tr>
		
</table>
<center><input type=Button value=Back id="inputsubmit1" onClick="window.history.back()"></center>
</form>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</body>
</html>