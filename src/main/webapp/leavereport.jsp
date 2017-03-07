<html>
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

<font face="Times New Roman " size="5" ><b ><font color=brown>EMPLOYEE  LEAVE REPORT</b></font>
<table  width="100%" align=center border="1" Bordercolor='#aqua'>
         <tr> <td>
		<div align="center">
             <b><font color=brown>UserId</b>
         </td>  <td><div align="center">
            <b><font color=brown>Purpose</b>
         <td>  <div align="center">
             <b><font color=brown>From_date</b>
         <td>  <div align="center">
           <b><font color=brown>To_date</b>
         </td>
         <td>  <div align="center">
           <b><font color=brown>No.Of Days</b>
         </td></tr>
<%

	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();                            
                                 st=c.createStatement();                                   
                                String user=(String)session.getAttribute("user");                                   
                                rs=st.executeQuery("select userid,purpose,to_char(from_date,'dd/mm/yyyy'),to_char(to_date,'dd/mm/yyyy'),no_of_days from leaves order by userid,from_date");
                              
while(rs.next()){              
           %>
  <tr> <td width="25%">
		<div align="center">
            <%=rs.getString(1) %>
          
         </td>  <td width="35%"><div align="center">
        
              <%=rs.getString(2) %>
         <td width="20%"> <div align="center">
                  <%=rs.getString(3) %>
   
         <td width="20%">  <div align="center">
        
              <%=rs.getString(4) %>
              
         </td>  
          <td width="15%"> <div align="center">
        
              <%=rs.getString(5) %>
              
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