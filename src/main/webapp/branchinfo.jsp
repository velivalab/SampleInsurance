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


<h3 align="center"><b><font color=pink>Branch Details</b></h3>
<table width="60%"  align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center">
             <b><font color=pink>BranchCode</b>
         </td>  <td><div align="center">
            <b><font color=pink>BranchName</b>
         </td>  </tr>
<%

	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();                            
                                 st=c.createStatement();                                   
                                String user=(String)session.getAttribute("user");                                   
    rs=st.executeQuery("select * from branch order by branch_code");
                              
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
	   
</table><br>
<center><input type=Button id="inputsubmit1" value=Back onClick="window.history.back()"></center>
</form>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</body>
</html>