<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<script>
 function checkval(){
 alert(document.form1.cpwd.value);
       if(document.form1.cpwd.value==""){
                  //alert("ENTER  PASSWORD");
                    document.form1.cpwd.focus();
                return false;
            } 
            if(document.form1.rpwd.value==""){
                  //alert("ENTER CONFIRMPASSWORD");
                    document.form1.rpwd.focus();
                return false;
            }           
            if(!(document.form1.cpwd.value==document.form1.rpwd.value)){
                    //alert("NEW AND CONFIRM PASSWORD SHOULD BE SAME");
                        document.form1.cpwd.select();
                          return false;
                  }
               return true;
    }

</script>
<body bgcolor="burlywood">
<form name="form1" action="./Change " method="post">
  

<table width="50%" align=center>

                                
         <tr> <td><b ><font color=pink>Change &nbspPassword:</b></td></tr></table>
<table width="50%" align=center>
         <tr> <td>
		<div align="center">
<font color=pink>NewPassword
         </td> <td>
		<div align="left">
             <input type="password" name="cpwd" >
         </td> </tr>  <tr> <td>
		<div align="center">
           <font color=pink>ConfirmPassword
         </td> <td>
		<div align="left">
              <input type="password" name="rpwd">
         </td> </tr> <tr><td><br>
         	<div align="center">
         	  <input id="inputsubmit1" type="submit" name="add" value="send" onclick="return checkval()">
           <input type="reset" id="inputsubmit1"  name="clear" value="clear">
        
           <input type=Button value=Back id="inputsubmit1" onClick="window.history.back()">
         </td></tr>
</table>
</form>
</body>
</html>