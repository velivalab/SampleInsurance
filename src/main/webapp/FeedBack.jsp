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
            if(document.form1.comment.value==""){
                  //alert("ENTER CONTENT");
                    document.form1.comment.focus();
                return false;
            }           
            
               return true;
    }

</script>
<body >
<form name="form1" action="./SendFeedback">
   <br><br>



<table width="50%" align=center bordercolor=pink>
         <tr> <td>
		<div align="center">
             <font color=pink>UserId
         </td> <td>
		<div align="left">
             <input type=text name='user' readonly="readonly" value='<%=session.getAttribute("user")%>'>
         </td> </tr>  <tr> <td>
         <% Date d=new Date();
                                  int da1=d.getDate(); 
       int m=d.getMonth();
       int y=d.getYear();
       String da=da1+"";
       //String m=m1+"";
       //String y=y1+"";
       String ldate=da+"-"+(m+1)+"-"+(y+1900);%>
		<div align="center">
          <font color=brown> Date:
         </td> <td><input type=text name='fdate' value='<%=ldate%>'>
        
		<div align="left">              
         </td> </tr> <tr> <td>
		<div align="center"><font color=pink>Time
         </td> <td>
		<div align="left">
             <input type=text name='time' value=" ">
         </td> </tr><tr><td>
	</td> </tr>  <tr> <td>
		<div align="center"><font color=pink>Subject
         </td> <td>
		<div align="left">
             <input type=text name='subject' value=''>
         </td> </tr> <tr> <td>
		<div align="center"><font color=>Comments
         </td> <td>
		<div align="left">
		

           <TEXTAREA   rows="10" cols="35"     id='comment' name='comment'></TEXTAREA>
         </td> </tr><tr><td >
		<div align="left">
         
         	</td><td>
         	<div align="center">
         	  <input type="submit" name="send" value="send" onclick="return checkval()">
           <input type="reset" name="clear" value="clear">
           <input type=Button value=Back onClick="window.history.back()">
         </td></tr>
</table>
</form>
</body>
</html>