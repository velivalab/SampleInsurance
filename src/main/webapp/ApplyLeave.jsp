<HTML>
<HEAD><TITLE>Week Picker Demo</TITLE>
<link href="default1.css" rel="stylesheet" type="text/css" />
</HEAD>
<script>
 function checkval(){
       if(document.inetform.purpose.value==""){
                  //alert("ENTER  LEAVE PURPOSE" );
                    document.inetform.purpose.focus();
                return false;
            } 
                      
               return true;
    }
              
</script >
<BODY bgcolor=burlywood>
<%@ include file="../Common.jsp" %>
<%! int i=0,j=0;%>

<FORM name="inetform"  action="./LeaveDetails">

<table align="center" >
<tr><td div align="center"><b><font color=brown>UserId:</td><td div align="left" >
<input type=text name="user" readonly="readonly"  value="<%= session.getAttribute("user")%>">

</td></tr><tr>
<td div align="center"><b><font color=brown>Purpose:</td><td div align="left" >
<input type=text name="purpose" value="">

</td></tr><tr>

<td div align="center" >
<b><font color=brown>From(mm/dd/yyyy):</td><td div align="left">  <table>    <tr>  <td>                                           
                                                                <select name="month">
                                                                                <option value="00" selected="selected">****</option>
                                                                               <%for( i=0;i<10;i++){%>
                                                                               <option value=<%=j%><%=i%>><%=i%></option>							 
																			    <%}%>
																			    <%for( i=10;i<13;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>											 
																			    <%}%>
															  </select>															                                              
                                                                <select name="day">
                                                                <option value="00" selected="selected">****</option>
                                                                                <%for( i=0;i<10;i++){%>
                                                                               <option value=<%=j%><%=i%>><%=i%></option>							 
																			    <%}%>
                                                                               <%for( i=10;i<32;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>												 
																			    <%}%>
															  </select>
															   <select name="year">
															   <option value="00" selected="selected">********</option>
                                                                               <%for( i=1980;i<2010;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>												 
																			    <%}%>
															  </select>
															  </td></tr>
															  </table></td>
</tr><tr><td div align="center" >
<b><font color=brown>TO(mm/dd/yyyy):</td><td div align="left">  <table>    <tr>  <td>                                           
                                                                <select name="tomonth">
                                                                <option value="00" selected="selected">****</option>
                                                                 <%for( i=0;i<10;i++){%>
                                                                               <option value=<%=j%><%=i%>><%=i%></option>							 
																			    <%}%>
                                                                               <%for( i=10;i<13;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>												 
																			    <%}%>
															  </select>  
                                                                <select name="today">
                                                                <option value="00" selected="selected">****</option>
                                                                 <%for( i=0;i<10;i++){%>
                                                                               <option value=<%=j%><%=i%>><%=i%></option>							 
																			    <%}%>
                                                                               <%for( i=10;i<32;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>												 
																			    <%}%>
															  </select>
															   <select name="toyear">
															   <option value="00" selected="selected">********</option>
                                                                               <%for( i=1980;i<2010;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>
																			 
																			    <%}%>
															  </select>
															  </td></tr>
															  </table></td></tr><tr><td align="right">
															  <input type="submit" name="send" value="send" onclick="return checkval()">
                                                              <input type="reset" name="clear" value="clear"> 
</td></tr></table>
</FORM>

</BODY>
</HTML>

