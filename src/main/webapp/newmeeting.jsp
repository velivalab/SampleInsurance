<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<script language="javascript">
 function checkval(){
        //alert("i am in function");
           if(document.form1.mdate.value==""){
                  //alert("ENTER  MEETING DATE");
                    document.form1.mdate.focus();
                return false;
            } 
            
              if(document.form1.time.value==""){
                  //alert("ENTER  TIME ");
                    document.form1.time.focus();
                return false;
            } 
              if(document.form1.purpose.value==""){
                  //alert("ENTER  PURPOSE OF THE MEETING ");
                    document.form1.purpose.focus();
                return false;
            } 
            
       if(document.form1.conclusion.value==""){
                  //alert("ENTER  CONCLUSIONS OF THE MEETING");
                    document.form1.conclusion.focus();
                return false;
            } 
            if(document.form1.issue.value==""){
                  //alert("ENTER DISCUSSED ISSUES");
                    document.form1.issue.focus();
                return false;
            }           
            
               return true;
    }

</script>

<body bgcolor="burlywood">

<form name="form1" action="./StoreMeeting">
 
<center><font color="pink"><h2>New Meeting</h2></font></center>
<table width="50%" align=center>
         <tr> <td>
		<div align="center">
         <font color=pink> MeetingDate
         </td> <td>
		<div align="left">
             <input type=text name='mdate' value=''> <font color=pink>dd-mm-yyyy
         </td> </tr><tr><td>
		<div align="center">
           <font color=pink>Time
         </td> <td>
		<div align="left">
             <input type=text name='time' value=''>
         </td></tr>  <tr> <td>
		<div align="center">
           <font color=pink>  Purpose
         </td> <td>
		<div align="left">
              <input type=text name='purpose' value=''>
                      </td> </tr><tr><td>
		
		<div align="center">
         </td> </tr>
	  <tr> <td>
		<div align="center"> <font color=pink>IssuesDiscussed
         </td> <td>
		<div align="left"> <TEXTAREA  rows="15"  cols="50" id='issue' name='issue'></TEXTAREA>
         </td> </tr>
         <tr> <td>
		<div align="center"> <font color=pink>Conclusions
         </td> <td>
		<div align="left">
             <input type=text name='conclusion' value=''>
         </td> </tr><tr> 
		    <td><br>
         	<div align="center">
         	  <input id="inputsubmit1" type="submit" name="inputsubmit1" value="Submit" onclick="return checkval()">
            <input id="inputsubmit1" type="reset" name="inputsubmit1" value="Reset">
           <input id="inputsubmit1" type=Button value=Back onClick="window.history.back()">
       </div>  </td></tr>
</table>
</form>
</body>
</html>