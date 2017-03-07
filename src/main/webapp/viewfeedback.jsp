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


<h2 align="center" ><font face="arial" size="5" color=pink>Feedback From Users</font></h2>
<table  align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center"><font color=pink>
             <b><font color=pink>UserId</b></td>
         <td><div align="center">
            <b><font color=pink>Comments</b></td>
         <td>  <div align="center">
             <b><font color=pink>Date</b></td>
        </tr>
<%

	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();                            
                                 st=c.createStatement();                                   
                                String user=(String)session.getAttribute("user");                                   
                                rs=st.executeQuery("select userid,comments,to_char(w_date,'dd/mm/yyyy') from feedback");
                              
while(rs.next()){              
           %>
  <tr> <td>
		<div align="center">
            <%=rs.getString(1) %>
          
         </td>  <td><div align="center">
        
              <%=rs.getString(2) %>
         <td>  <div align="center">
                  <%=rs.getString(3) %>
   </td>
        
         
     
            <%}%>
         </tr>
		
</table>
</form>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</body>
</html>