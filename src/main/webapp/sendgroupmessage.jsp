<html>
<link href="default1.css" rel="stylesheet" type="text/css" />

<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<script language="javascript">
function checkval(){
       if(document.form1.subject.value==""){
                  //alert("ENTER  SUBJECT");
                    document.form1.subject.focus();
                return false;
            } 
            if(document.form1.content.value==""){
                  //alert("ENTER CONTENT");
                    document.form1.content.focus();
                return false;
            }           
            
               return true;
    }
    </script>
<body bgcolor=burlywood>
<form name="form1" action="./storegroupmessage">


 <p ><H3 align="center"><font color=pink face=monospace> SEND&nbsp MESSAGES&nbspTO&nbspGROUP</H3>

<table width="50%" align=center>
         <tr> <td>
		<div align="center">
           <b> <font color=pink face=arial size=2> SenderId
         </td> <td>
		<div align="left">
             <input type=text name='sender' readonly="readonly" value='<%=session.getAttribute("user")%>'>
         </td> </tr>  <tr> <td>
		<div align="center">
            <b><font color=pink face=arial size=2> GroupId
         </td> <td>
		<div align="left"><%
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
                                rs=st.executeQuery("select * from groups");
						%>
             <select name="groupid">
             <%while(rs.next()){%>
                 <option value="<%=rs.getString(2)%>"><%=rs.getString(2)%></option >
<%}%>
              </select>
         </td> </tr><tr><td>


		</td> </tr>  <tr> <td>
		<div align="center"><b><font color=pink face=arial size=2>Date
         </td> <td>
		<div align="left">
             <input type=text name='date' value=" <%=ldate%>">
         </td> </tr><tr><td>
	</td> </tr>  <tr> <td>
		<div align="center"><b><font color=pink face=arial size=2>Subject
         </td> <td>
		<div align="left">
             <input type=text name='subject' value=''>
         </td> </tr> <tr> <td>
		<div align="center"><b><font color=pink face=arial size=2>Content
         </td> <td>
		<div align="left">
		

           <TEXTAREA  rows="15" cols="50" id='content' name='content'></TEXTAREA>
         </td> </tr><tr><td >
		<div align="left">
         
         	</td><td><br>
         	<div align="center">
         	  <input id="inputsubmit1" type="submit" name="inputsubmit1" value="Submit"  onclick="return checkval()">
            <input id="inputsubmit1" type="reset" name="inputsubmit1" value="Reset">
           <input id="inputsubmit1" type=Button value=Back onClick="window.history.back()">
         </td></tr>
</table>
</form>
</body>
</html>