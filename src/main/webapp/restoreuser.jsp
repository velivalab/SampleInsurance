<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<%! String groupids; 
%>
<body bgcolor=burlywood>
<jsp:useBean id="resuser" scope="session" class="org.cdsdemo.insurancemanagement.bo.RestoreUser" />
<jsp:setProperty name="resuser" property="uname" param="uname" />
<jsp:setProperty name="resuser" property="passwd" param="passwd" />
<jsp:setProperty name="resuser" property="fname" param="fname" />
<jsp:setProperty name="resuser" property="lname" param="lname" />
<jsp:setProperty name="resuser" property="address" param="address" />
<jsp:setProperty name="resuser" property="phone" param="phone" />
<jsp:setProperty name="resuser" property="mailid" param="mailid" />
<jsp:setProperty name="resuser" property="groupid" param="groupid" />
<jsp:setProperty name="resuser" property="branch" param="branch" />
<%! boolean flag=false;%>
<%
     String bname=resuser.getBranch();
      String groupname=resuser.getGroupid();
    Connection con=null;
       DBConnection dbcon=new DBGeneralImpl();
       con= dbcon.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select a.groupid,b.branch_name  from login a,branch b where a.groupid='"+groupname+"' and b.branch_name='"+bname+"'");  


       if(rs.next()){ 
int i=resuser.storeuser();
out.println("<br><br><b><center><font color=brown size=5>User Updated</b></center>");
 flag=true;
  }
      else{
         out.println("choose existing branch and groupid");
        out.println(" <input type=Button value=Back onClick='window.history.back()'>");

   }
%>
  
<b>
<font face="TimesNewRoman" size="6" color="brown">
<%
if(flag){
groupids=resuser.getGroupid();
if(groupids.equals("admin")){%>
<a href="./usermanagement.jsp" ><font face="monospace" size="4" color="brown">Back</a>
<%}
else{%>
   <a href="./display.jsp" ><font face="monospace" size="4" color="brown">Back</a>    

<%}
   }
%>
</body>
</html>

