<HTML>
<HEAD><TITLE>Week Picker Demo</TITLE>
</HEAD>
<BODY bgcolor=burlywood>
<%@ page import="java.util.*"%>
<%@ include file="../Common.jsp" %>
<%! int i=0,j=0;%>

<FORM name="inetform"  action="./timeout">
<br><br><br><br><br><br><br>
<table align="center" >
<tr><td div align="center"><b><font size=2 face=arial color=brown>UserId: </b></td><td div align="left" >
<input type=text name="user"  readonly="readonly" value="<%= session.getAttribute("user")%>">
</td></tr><tr>
<td div align="center" >
<% java.util.Calendar dd=java.util.Calendar.getInstance();
                        int date=dd.get(Calendar.DAY_OF_MONTH);
                        int month=dd.get(Calendar.MONTH)+1;
                        int year=dd.get(Calendar.YEAR);
                       String dates=""+date+"/"+month+"/"+year;
%>
<b><font size=2 face=arial color=brown>EnterLogOutTime: </b></td><td div align="left">  <table>    <tr>  <td>    
<input type=hidden name="dateone"  value="<%= dates%>" >                                       
                                                                		                                              
                                                                <select name="hour">
                                                                <option value="00" selected="selected">00</option>
                                                                                <%for( i=0;i<10;i++){%>
                                                                               <option value=<%=j%><%=i%>><%=i%></option>							 
																			    <%}%>
                                                                               <%for( i=10;i<13;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>												 
																			    <%}%>
															  </select>
															    <select name="min">
                                                                <option value="00" selected="selected">00</option>
                                                                                <%for( i=0;i<10;i++){%>
                                                                               <option value=<%=j%><%=i%>><%=i%></option>							 
																			    <%}%>
                                                                               <%for( i=10;i<60;i++){%>
                                                                               <option value=<%=i%>><%=i%></option>												 
																			    <%}%>
															  </select>
															  </td></tr>
															
															  <input type="submit" name="send" value="send" >
                                                              <input type="reset" name="clear" value="clear"> 
<input type="Button" value="Back" align="middle" onClick="window.history.back()">
</table>


</BODY>
</HTML>

