<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="burlywood">

<form method="POST">

   <br><br>
<p ><H3 align="center"><font color=pink face=arial>INBOX</H3>

<table width="50%" align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center">
          <font color=pink>   SenderId
         </td>  <td><div align="center">
             <font color=pink> Date(dd-mm-yyyy)
         <td>  <div align="center">
  <font color=pink>Subject
         <td>  <div align="center">
            <font color=pink> Open
         </td>  
         <td>  <div align="center">
          <font color=pink> Delete
         </td>  </tr><%
	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
                                 st=c.createStatement();
                                String user=(String)session.getAttribute("user");
                              
                                rs=st.executeQuery("select * from messages where receiverid='"+user+"'");
while(rs.next()){
	
%>
<%! int date;%>
<%! int month;%>
<%! int year;%>
<%! String str;%>
<%! String ldate;%>
  <tr> <td>
		<div align="center">
            <%=rs.getString(1) %>
          
         </td>  <td><div align="center">
         <%
                  Date d1=rs.getDate(3);
                    date=d1.getDate();
					month=d1.getMonth();
                    year=d1.getYear();
					str=""+date;
                   ldate=date+"-"+(month+1)+"-"+(year+1900);
           %>
               <%=ldate %>
         <td>  <div align="center">
   <%=rs.getString(4) %>

<%System.out.println("idiot:"+rs.getString(5));%>
   
         <td>  <div align="center">
             <a href= "./OpenContent?receiver=<%=session.getAttribute("user") %>&date=<%=rs.getDate(3)%>&mid=<%=rs.getString(4) %>" >Open</a>
         </td>  
         <td>  <div align="center">
         <a href= "./deletemessage?receiver=<%=session.getAttribute("user") %>&date=<%=rs.getDate(3) %>&mid=<%=rs.getString(4) %>" >Delete</a>
            <%}%>
         </td>  </tr>
		
</table>
</form>
</body>
</html>