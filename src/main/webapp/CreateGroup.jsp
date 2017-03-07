<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="burlywood">
<form action="./CreateGroup " method="post">



<%
                                   Date d=new Date();
                                  int da1=d.getDate(); 
       int m=d.getMonth();
       int y=d.getYear();
       String da=da1+"";
       //String m=m1+"";
       //String y=y1+"";
       String ldate=da+"-"+(m+1)+"-"+(y+1900);

								Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
								  st=c.createStatement();
                                rs=st.executeQuery("select  groupname from groups");
%>
                                
     <center><b ><font color=pink face=arial align="center">Create a Group:</b></center>
<br>
<table width="50%" align=center>
<tr><td>

		<div align="center">
<font color=pink face=arial size=2>GroupName
         </td> <td>
		<div align="left">
              <select name="gname">
             <%while(rs.next()){%>
                 <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option >
<%}%>
              </select>
         </td> </tr>  <tr> <td>
		<div align="center">
            <font color=pink face=arial size=2>UserId
         </td> <td>
		<div align="left"><%
                                  
                                 st=c.createStatement();
                                rs=st.executeQuery("select  * from login");
						%>
             <select name="user">
             <%while(rs.next()){%>
                 <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option >
<%}%>
              </select>
         </td> </tr><tr><td>


		</td> </tr>  <tr><td></td><td>
             	<input id="inputsubmit1" type="submit" name="add" value="Submit"  onclick="return checkval()">
            <input id="inputsubmit1" type="reset" name="inputsubmit1" value="Reset">
           <input id="inputsubmit1" type=Button value=Back onClick="window.history.back()">
         </td></tr>
</table>
</form>
</body>
</html>