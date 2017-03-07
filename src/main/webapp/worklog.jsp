<HTML>
<%@ page import="java.util.Date" %>
<HEAD><TITLE></TITLE>

<link href="default1.css" rel="stylesheet" type="text/css" />
</HEAD>
<%@ include file="../Common.jsp" %>
<script>
 function checkval(){
         if(document.inetform.dc.value==""){
                  //alert("ENTER DATE");
                    document.inetform.dc.focus();
                return false;
            }           
            if(document.inetform.task.value==""){
                  //alert("ENTER CONTENT");
                    document.inetform.task.focus();
                return false;
            }           
              if(document.inetform.time.value==""){
                  //alert("ENTER TIME");
                    document.inetform.time.focus();
                return false;
            }           
            
               return true;
    }

</script>
<BODY >
<form name="inetform" action="./storeworklog">
<%Date d=new Date();
                                  int da1=d.getDate(); 
       int m=d.getMonth();
       int y=d.getYear();
       String da=da1+"";
       //String m=m1+"";
       //String y=y1+"";
       String ldate=da+"-"+(m+1)+"-"+(y+1900);
       %>

<table align="center" Bordercolor="pink">
<tr><td colspan=2 align=center>
<p ><H3 align="center"> <font color=pink>Enter Your&nbspWorklog</H3><br>
</td></tr>
<tr><td >
<font color=pink>Date:</td><td><input type="text" name="dc" value=" <%=ldate%>"><font color=pink>
</td>
</tr>
<tr><td><font color=pink>Time:</td><td><input type="text" name="time"></td>
</tr>
<tr><td><font color=pink>Task:</td><td><textarea rows="5" cols="16" name="task" id="task"></textarea></td></tr>
<br><br>
<tr><td></td><td><input type="submit" id="inputsubmit1" name="submit" value="submit" onclick="return checkval()"><input type="reset" id="inputsubmit1" name="clear" value="clear"><input type="Button" id="inputsubmit1" value="Back" align="middle" onClick="window.history.back()"></td>
</tr>
</table>
</form>
<iframe width=199 height=178 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="js/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>

    
</BODY>
</HTML>

