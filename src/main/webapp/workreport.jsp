<HTML>
<HEAD><TITLE></TITLE>
<link href="default1.css" rel="stylesheet" type="text/css" />
</HEAD>
<BODY bgcolor=burlywood>

<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>

<%
      String group=(String)session.getAttribute("group");
       if(group.equals("admin")){

%>

<%
    	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
                                 st=c.createStatement();
                                rs=st.executeQuery("select userid from login");
%>

<script>
       function send(){
         if(document.inetform.dc.value==""){
                  //alert("ENTER FROMDATE");
                    document.inetform.dc.focus();
                return false;
            }           
       if(document.inetform1.dc1.value==""){
                  //alert("ENTER  TO DATE");
                    document.inetform1.dc1.focus();
                return false;
            } 
          
       var a=document.inetform.dc.value;
        var b=document.inetform1.dc1.value; 
     
        var c=document.inetform.laks.options[document.inetform.laks.selectedIndex].value;
        alert(c);
       window.location.href="./storeworkreport?from="+a+"&to="+b+"&use="+c 
      return true;
              }  
              
              function asdf(){
   
              document.inetform.dc.value="";
                document.inetform1.dc1.value="";
              }
</script >
<center><FORM name="inetform" >
  <p ><b><div align="center"><font size=4 face=arial  color=pink>WORK REPORT</font></p>
<table align="center"><tr><td><font color=pink>select username</td>
<td>
 <select name="laks">
                                  <%
while(rs.next()){
	%>

  <option value=<%= rs.getString(1)%>><%= rs.getString(1)%></option>
		 
          
             <% }%>
          </select></td></tr>
<tr><td ><font color=pink>
From:</td><td><input name="dc" value="" size="20"><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.inetform.dc);return false;" HIDEFOCUS>SelectDate</a></td>
</tr>
</table>
 </FORM> 
<FORM name="inetform1" >
<table>
<tr><td ><font color=pink>
TO    :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input name="dc1" value="" size="20"><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.inetform1.dc1);return false;" HIDEFOCUS>SelectDate</a></td>
</tr></table>
</FORM><br>
<iframe width=199 height=178 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="js/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>
<input type="button" id="inputsubmit1" name="send" value="send" onclick="return send()">
<input type="button" id="inputsubmit1" name="cancel" value="cancel" onclick="return asdf()">
 <%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</center>
</BODY>
</HTML>

