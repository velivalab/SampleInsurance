<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<script>
 function checkval(){
 
       if(document.form1.bcode.value==""){
                  //alert("ENTER  BRANCHCODE");
                    document.form1.bcode.focus();
                return false;
            } 
            if(document.form1.bname.value==""){
                  //alert("ENTER BRANCH NAME");
                    document.form1.bname.focus();
                return false;
            }           
           
               return true;
    }

</script>
<body bgcolor="burlywood">
<%
      String group=(String)session.getAttribute("group");
       if(group.equals("admin")){

%>
<form name="form1" action="./branchdetails " method="post">
   <br><br>

<table width="50%" align=center>

                                
         <tr> <td><b><font color=pink>Add&nbspNew Branch:</b></td></tr></table>
<table width="50%" align=center>
         <tr> <td>
		<div align="center">
 <b><font color=pink>Branch&nbspCode:
         </td> <td>
		<div align="left">
             <input type="text" name="bcode" >
         </td> </tr>  <tr> <td>
		<div align="center">
          <b><font color=pink> Branch&nbspName:
         </td> <td>
		<div align="left">
              <input type="text" name="bname">
         </td> </tr> <tr><td>
         	<div align="center">
         	  <input type="submit" id="inputsubmit1" name="add" value="send" onclick="return checkval()">
           <input type="reset" id="inputsubmit1" name="clear" value="clear">
           </td><td>
           <input type=Button id="inputsubmit1" value=Back onClick="window.history.back()">
         </td></tr>
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