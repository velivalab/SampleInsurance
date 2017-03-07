<html>
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor=burlywood>
<jsp:useBean id="resuser" scope="session" class="org.cdsdemo.insurancemanagement.bo.RestoreUser" />
<form  action="./Deluserone.jsp">

   <br><br>
<br>
<table width="60%" align=center Bordercolor='#aabbcc'>
         <tr> <td>
		<b><font color=pink>Select Username To Delete:</b>
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
          <input type=Button id="inputsubmit1" value=Back onClick="window.history.back()">           
           </td> </tr>
		
</table>
</form>

</body>
</html>