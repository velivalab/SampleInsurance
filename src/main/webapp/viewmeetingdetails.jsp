<html>

<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="burlywood">
<form>
   <br><br>
<p ><H2 align="center"> <font face=monospace color=pink>MEETING&nbspDETAILS </H2>
<table width="85%" align=center border="1" Bordercolor='pink'>
         <tr> <td>
		<div align="center">
             <b>  <font color=pink>Date(dd-mm-yyyy)
         </td>  <td><div align="center">
            <b><font color=pink> TIme
         <td>  <div align="center">
<b> <font color=pink>Purpose
         <td>  <div align="center">
        <b>  <font color=pink>Agenda
         </td>  
         <td>  <div align="center">
      <b> <font color=pink> Conclusion
         </td>  </tr>
<%! int date;%>
<%! int month;%>
<%! int year;%>
<%! String str;%>
<%! String ldate;%>
<%
	Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();                            
                                 st=c.createStatement();                                   
                                String user=(String)session.getAttribute("user");                                   
                                rs=st.executeQuery("select * from meetings");
while(rs.next()){
					Date d1=rs.getDate(1);
                    date=d1.getDate();
					month=d1.getMonth();
                    year=d1.getYear();
					str=""+date;
                   ldate=date+"-"+(month+1)+"-"+(year+1900);
           %>
  <tr> <td>
		<div align="center">
             <%=ldate%>
          
         </td>  <td><div align="center">
        
              <%=rs.getString(2) %>
         <td>  <div align="center">
   <%=rs.getString(3) %>
   
         <td width="50%" >  <div align="center">
         <textarea   name="tarea" id="tarea" readonly="readonly">
              <%=rs.getString(4) %>
              </textarea>
         </td>  
         <td>  <div align="center">
        <%=rs.getString(5) %>
            <%}%>
         </td>  </tr>	
</table>
</form><br><br>
 <center><input id="inputsubmit1" type=Button value=Back onClick="window.history.back()"></center>
</body>
</html>