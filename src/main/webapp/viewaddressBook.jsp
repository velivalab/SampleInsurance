<html>

<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="burlywood">

<form >

   <br><br>


<font color="pink"><h3>Address book of</h3></font>
<table width="70%" align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center">
          <b><font color=pink> Fname
         </td>  <td><div align="center">
          <b><font color=pink>  Lname
         </td><td><div align="center">
              <b><font color=pink> Open
         </td>
         <td><div align="center">
             <b><font color=pink> Delete
         </td>
         </tr>
<%! int date;%>
<%! int month;%>
<%! int year;%>
<%! String str;%>
<%! String ldate;%>
<%
	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
                                 st=c.createStatement();
                                String user=(String)session.getAttribute("user");
                            
                                rs=st.executeQuery("select * from addressbook where loginid='"+user+"'");
while(rs.next()){        
           %>
  <tr> <font color="pink"><td>
		<div align="center">
             <%=rs.getString(3)%>
                     
         </td>  <td><div align="center">
        
              <%=rs.getString(4) %>
         <td>  <div align="center">
  <a href="./openaddressbook?userid=<%=session.getAttribute("user")%>&mailid=<%=rs.getString("userid")%>">Open</a>
         
        </div> </td>
				 <td>  <div align="center">
  <a href="./deleteaddress?userid=<%=session.getAttribute("user")%>&mailid=<%=rs.getString("userid")%>">Delete</a>
         
         </div></td>
         
            <%}%>
          </tr>
          <%=session.getAttribute("user")%>
</table><br>
<center><input type="Button" id="inputsubmit1" value="Back" align="middle" onClick="window.history.back()"></center>
</form>
</body>
</html>