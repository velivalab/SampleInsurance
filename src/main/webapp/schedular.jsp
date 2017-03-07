<html>
<head><title>this is for date and time</title>
<link href="default1.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.*" %>


<body>

<form   name="userform2" action='./schedular.jsp' method='POST'>


<%
String user=(String)session.getAttribute("user");
String type=(String)session.getAttribute("check");
String status="in progress";
System.out.println("fdasdfdsa"+user+type);
         Connection con=null;
       DBConnection dbcon=new DBGeneralImpl();
       con= dbcon.getConnection();
       Statement st=con.createStatement();
       ResultSet rs=null;
       if(type.equals("admin")){
        rs=st.executeQuery("select * from schedular where userid='"+user+"' ");
       }else{
    	   rs=st.executeQuery("select * from schedular where userid='"+user+"'");

       }
       PreparedStatement ps=con.prepareStatement("select userid from login where groupid='user'");
       ResultSet rst=ps.executeQuery();
%>
<script>
      function show(){
        var a=document.userform2.date2.value;
         
      }
</script>
          <p><b ><h2 align="center" ><font face="arial" color=pink>Schedule For&nbsp;&nbsp;<%= (String)session.getAttribute("user")%></font></h2></b></p>
     <table align="center">
         <% while(rs.next()){
        	 java.util.Calendar dd=java.util.Calendar.getInstance();
             int date=dd.get(Calendar.DAY_OF_MONTH);
             
             int month=dd.get(Calendar.MONTH)+1;
             int year=dd.get(Calendar.YEAR);
             int min=dd.get(Calendar.MINUTE);
             String tot=rs.getString(2);
             System.out.println(tot);
             int dat=Integer.parseInt(tot.substring(0,2));
             System.out.println(dat);
             
             int mon=Integer.parseInt(tot.substring(3,5));
             System.out.println(mon);
             
             int yea=Integer.parseInt(tot.substring(6,10));
             System.out.println(yea);
             
             int hou=Integer.parseInt(tot.substring(11,13));
             System.out.println(hou);
             
             int mi=Integer.parseInt(tot.substring(14,16));
             System.out.println(mi);
   
             String am=tot.substring(16,18);
             System.out.println(am);
             if((mon<month)&&(yea<year)&&(dat<date)){
            	 System.out.println("inside compariosin");
            	 status="completed";
             }
             
         %>
                      <tr><td><br>
                       <font color="pink">  Loginid:</font> <input type="text"  name="date" readonly="readonly" value="<%= rs.getString(1) %>" >           </td></tr>
                       <tr><td align="center">
                        Date: <input type="text"  name="date1" readonly="readonly" value="<%= rs.getString(2) %>" >
                          </td></tr>
                          <tr><td>
                         Task:<input type="text area" rows="10" cols="20" name="date2" onfocus="return show()" readonly="readonly"  value="<%= rs.getString(3) %>" >
						</td></tr>				 
<%}%>
<%
String deluser=(String)session.getAttribute("user");
String checker=(String)session.getAttribute("check");
    if(checker.equals("admin")){%>
    <tr><td><br>
  <input id="inputsubmit1" type="submit" name="inputsubmit1" value="AddTask">
  </td></tr>
<%}%>   
</table>
</form>
<form   name="demoform"  action="#">
<% if(request.getMethod().equals("POST")){%>
<br><table ><tr><td><font color=pink> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;select userid :</td>
<td>
 <select name="select1" id="select1">
                                  <%
while(rst.next()){
		System.out.println(rst.getString(1));
		System.out.println("HAIIIIIII");
	%>
  <option value=<%= rst.getString(1)%>><%= rst.getString(1)%></option>
              <% }%>
          </select></td></tr>
          </table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date: <input class="plain" name="dc" id="dc" size="18"><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fPopCalendar(document.demoform.dc);return false;" HIDEFOCUS>ClickhereforDate</a>
<script  language="javascript">
         function adddate(){
            var a=document.getElementById("dc").value;     
             var b=document.getElementById("schedule").value;
              var c=document.getElementById("select1").value;
             window.navigate("./storeschedule?name="+a+"&schedule="+b+"&sel="+c); 
      }
</script><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task:&nbsp;<input type="text " name="schedule" id="schedule"><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  name="click" id="inputsubmit1" value="click" onclick="adddate()">
<iframe width=188 height=166 name="gToday:datetime:agenda.js:gfPop:plugins_12.js" id="gToday:datetime:agenda.js:gfPop:plugins_12.js" src="ipopeng.htm" scrolling="no" frameborder="2" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;">
</iframe>
<%}%>
</form>
</body>
</html>