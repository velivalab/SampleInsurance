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

 <p ><H3 align="center"><font color=pink>EMPLOYEE REPORT</H3><BR>
 
<table  align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center">
             <b><font color=pink>UserId</b>
         </td>  <td><div align="center">
            <b><font color=pink>Fname</b>
         <td>  <div align="center">
             <b><font color=pink>Role</b>
         <td>  <div align="center">
           <b><font color=pink>Branch</b>
         </td><td>  <div align="center">
           <b><font color=pink>GroupName</b>
         </td></tr>
<%

	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();                            
                                 st=c.createStatement();                                   
                                String user=(String)session.getAttribute("user");                                   
                                rs=st.executeQuery("select a.userid,a.fname,a.groupid,a.bname,b.groupid from login a, groupusers b where a.userid=b.userid order by a.bname");
                              
while(rs.next()){              
           %>
  <tr> <td>
		<div align="center">
            <%=rs.getString(1) %>
          
         </td>  <td><div align="center">
        
              <%=rs.getString(2) %>
         <td>  <div align="center">
                  <%=rs.getString(3) %>
   
         <td >  <div align="center">
        
              <%=rs.getString(4) %>
              
         </td>  <td >  <div align="center">
        
              <%=rs.getString(5) %>
              
         </td>  
         
     
            <%}%>
         </tr></table>
	  <center> <input type=Button id="inputsubmit1" value=Back onClick="window.history.back()"></center>

</form>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</body>
</html>