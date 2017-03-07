<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<jsp:useBean id="updateuser" scope="session" class="org.cdsdemo.insurancemanagement.bo.UpdateUser" />
<body bgcolor="burlywood">
<%
      String group=(String)session.getAttribute("group");
       if(group.equals("admin")){

%>
<form  action="./updateuser.jsp" method="POST">

   <br><br>
<br>

<%! int date;%>
<%! int month;%>
<%! int year;%>
<%! String str;%>
<%! String ldate;%>

<table width="60%" align=center Bordercolor='pink'>
         <tr> <td>
		<b><font color=pink>Select Username To Update:</b>
        <%
	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
                                 st=c.createStatement();
                                String user=(String)session.getAttribute("user");
                                
                               System.out.println("the user is ,.,.,.,.,.,.,.,.,.,.,.,.,.,.,.,.,"+user);
                                rs=st.executeQuery("select userid from login where groupid='user'");%>
                                  <select name="uuser">
                                  <%
while(rs.next()){
	%>

  <option name=<%= rs.getString(1)%>><%= rs.getString(1)%></option>
		 
          
             <% }%>
          </select>
           <input type="submit" id="inputsubmit1" name="submit" value="submit">
		<input type=Button id="inputsubmit1" value=Back onClick="window.history.back()"></td></tr>
</table>
</form>
<form name="f1" action="./restoreuser.jsp">
<%
      if(request.getMethod().equals("POST")){

        String uuser=(String)request.getParameter("uuser");
        System.out.println("----------"+uuser);
System.out.println("objecthashcode"+updateuser);
     updateuser.getuser(uuser);

%>
<table align="center" border="0">
<tr><td>
      <div align="center">
                   <b><font color=pink>Uname::</b>
      </td>  <td>        
<input type="text" name="uname" readonly="readonly" value=<jsp:getProperty  name="updateuser"  property='uname'  />></td></tr> 
<input type="hidden" name="passwd" value=<jsp:getProperty  name="updateuser"  property='passwd'  />>
<tr><td>
      <div align="center">
                   <b><font color=pink>Fname::</b>
      </td>  <td>          
<input type="text" name="fname" value=<jsp:getProperty  name="updateuser"  property='fname'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font color=pink>Lname::</b>
      </td>  <td>          
<input type="text" name="lname" value=<jsp:getProperty  name="updateuser"  property='lname'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font color=pink>Address::</b>
      </td>  <td>          
<textarea name="address" id="address"><jsp:getProperty  name="updateuser"  property='address'  /></textarea>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font color=pink>Phone::</b>
      </td>  <td>          
<input type="text" name="phone" value=<jsp:getProperty  name="updateuser"  property='phone'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font color=pink>MailId::</b>
      </td>  <td>          
<input type="text" name="mailid" value=<jsp:getProperty  name="updateuser"  property='mailid'  />>
</td></tr> 
<tr><td>
      <div align="center">
                   <b><font color=pink>GroupId::</b>
      </td>  <td>          
<input type="text" name="groupid" value=<jsp:getProperty  name="updateuser"  property='groupid'  />>
</td></tr> <tr> <td>
      <div align="center">
                   <b><font color=pink>Branch::</b>
      </td>  <td>          
<input type="text" name="branch" value=<jsp:getProperty  name="updateuser"  property='branch'  />>
</td></tr> <tr><td>
<input type="submit" id="inputsubmit1" name="submit" value="submit">
  <input type=Button id="inputsubmit1" value=Back onClick="window.history.back()">
</td></tr></table>
</form>

<%}%>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>

</body>
</html>