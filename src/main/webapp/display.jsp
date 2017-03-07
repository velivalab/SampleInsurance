<html>
<link href="default1.css" rel="stylesheet" type="text/css" />

<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.*" %>
<%@ include file="../Common.jsp" %>
<body bgcolor="burlywood">
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
  <%
  Connection c1=null;                         
  Statement st1=null;                              
 ResultSet rs1=null;
 DBConnection dbcon=new DBGeneralImpl();
 c1=dbcon.getConnection();
 st1=c1.createStatement();
 PreparedStatement ps=c1.prepareStatement("select fname from login where userid=?");
 ps.setString(1,user);
 rs1=ps.executeQuery();
 rs1.next();
 System.out.println("see this"+rs1.getString(1));
  %>
<tr><td colspan=5 align=center><b><font face=arial color=pink size=6 >Welcome&nbsp&nbsp&nbsp<%= rs1.getString(1)%></font></b>
</td></tr> <br><br>
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

                                c=dbcon.getConnection();
                                
                                st=c.createStatement();
                                
                                
                                System.out.println("the user is ,.,.,.,.,.,.,.,.,.,.,.,.,.,.,.,.,"+user);
                                String str="(\"select max(sno) from news\")";
                                String sqlstatement="select * from news";
                                System.out.println(sqlstatement);
                                rs=st.executeQuery(sqlstatement);
                                    while(rs.next()){                          
                                   flag=true;  
                                %>
                              <br><br>  <p><h2 align="center"><font face="Courier New" size="3" color="pink">
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
</form></body></html>
 