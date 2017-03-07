<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.*" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="lightgreen">
<form >
<%! int date;%>
<%! int month;%>
<%! int year;%>
<%! String str;%>
<%! String ldate;%>
<%! String passdate;%>
<%! int sno;%>
<%! boolean flag=false;%>
<table width="100%" hieght="60%" align="center" Bordercolor='#aabbcc'>
<% String user=(String)session.getAttribute("user"); 
           String gname=(String)session.getAttribute("group");
           
              
  %>
<tr><td colspan=5 align=center><b><font face=arial size=6 >Welcome&nbsp&nbsp&nbsp<%= user%></font></b>
</td></tr> 
<tr><td colspan=5>

<%
	                           Connection c=null;                         
                                 Statement st=null;                              
                                ResultSet rs=null;                                 
                            java.util.Calendar dd=java.util.Calendar.getInstance();
                         date=dd.get(Calendar.DAY_OF_MONTH);
                         month=dd.get(Calendar.MONTH)+1;
                        year=dd.get(Calendar.YEAR);
                              passdate=""+date+"/"+month+"/"+year;                               
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
                                      
                             
                             
                                 st=c.createStatement();
                                           System.out.println("the user is ,.,.,.,.,.,.,.,.,.,.,.,.,.,.,.,.,"+user);
                                            String str="(\"select max(sno) from news_twm\")";
                                            String sqlstatement="select * from news_twm where to_char(m_date,'dd/mon/yyyy')=to_date('"+passdate+"','dd/mm/yyyy')";
                                            System.out.println(sqlstatement);
                                rs=st.executeQuery(sqlstatement);
                                    while(rs.next()){
                            
                                   flag=true;  
                                %>
                                <p><h2 align="center"><font face="Courier New" size="3" color="black">
                                  <%=rs.getString(2)%>
                                  </font></h2>
         </td></tr>
		 <tr> <td  colspan=5 align=center>                     
                      
                        <%}

                               if(!flag){%>
                                            <b ><%
                                                   out.println("no news");
                                                  %></b>
                                     <%}
                          %>
                                              
                  </td></tr>	 
                                
</table>
</form>
 