<html>
<link href="default1.css" rel="stylesheet" type="text/css" />

<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
  <%
      String group=(String)session.getAttribute("group");
       if(group.equals("admin")){

%>
<script language="javascript">
 function checkval(){
       if(document.form1.userid.value==""){
                  ////alert("ENTER  USERID");
                    document.form1.userid.focus();
                return false;
            } 
            if(document.form1.password.value==""){
                  ////alert("ENTER PASSWORD");
                    document.form1.password.focus();
                return false;
            }   
              if(document.form1.repassword.value==""){
                  ////alert("RE-ENTER PASSWORD");
                    document.form1.repassword.focus();
                return false;
            }  
             if(!(document.form1.password.value==document.form1.repassword.value)){
                    //alert("ENTER CORRECT PASSWORD");
                        document.form1.password.select();
                          return false;
                  }
             if(document.form1.fname.value==""){
                  //alert("ENTER FIRST NAME OF THE USER");
                    document.form1.fname.focus();
                return false;
            }    
             if(document.form1.lname.value==""){
                  //alert("ENTER LAST NAME OF THE USER");
                    document.form1.lname.focus();
                return false;
            }      
               if(document.form1.address.value==""){
                  //alert("ENTER ADDRESS OF THE USER");
                    document.form1.address.focus();
                return false;
            }    
              if(document.form1.mailid.value==""){
                  //alert("ENTER MAILID OF THE USER");
                    document.form1.mailid.focus();
                return false;
            }                                                                                                                            
            
               return true;
    }

</script>

<body bgcolor="burlywood">
<form name="form1" action="./adduser">
   <br>
<table width="50%" border="0" bordercolor="pink" align="center">
         <tr> <td>
		<div align="center"><font color=pink>
UserId:</font></div>
         </td> <td>
		<div align="left"></div>
             <input type=text name='userid' value='<%
     String max=null;
    String uid;
	Connection con1=null;
	Statement st1=null;
    ResultSet rs1=null;
    DBConnection dbcon=new DBGeneralImpl();
     con1=dbcon.getConnection();
     st1=con1.createStatement(); 
	 rs1=st1.executeQuery("select max(userid) from login");
	 rs1.next();
	 max=rs1.getString(1);
	 String max1=max.substring(2);
	 System.out.println(max1);
	 int i=Integer.parseInt(max1);
	 i=i+1;
	 uid=max.substring(0,2)+String.valueOf(i);
	 System.out.println("uid="+uid);
	 uid.trim();
	 session.setAttribute("userid",uid);
	  %><%=uid %>'disabled />
         </td> </tr>  
<tr> <td>
		<div align="center">
          <font color=pink> Password
         </td> <td>
		<div align="left"><%
        Date d=new Date();
        int da1=d.getDate(); 
       int m=d.getMonth();
       int y=d.getYear();
       String da=da1+"";
       //String m=m1+"";
       //String y=y1+"";
       String ldate=da+"-"+(m+1)+"-"+(y+1900);

								Connection c=null;
								Statement st=null;
                                ResultSet rs=null;
                                Connection con=null;
								Statement stmt=null;
                                ResultSet rset=null;
                                DBConnection dbcon1=new DBGeneralImpl();
                                c=dbcon1.getConnection();
                                 con=dbcon1.getConnection();
                                 st=c.createStatement();
                                stmt=con.createStatement();
                                rs=st.executeQuery("select * from login");
                                 rset=stmt.executeQuery("select branch_name from branch");
						%>
             

                 <input type="password" name='password' value=''>
         </td> </tr>
         <tr> <td>
		<div align="center">
          <font color=pink> Re-EnterPassword
         </td> <td>
		<div align="left">
                   <input type="password" name='repassword' value=''>
		</td> </tr>  <tr> <td>
		<div align="center"><font color=pink>Fname
         </td> <td>
		<div align="left">
             <input type=text name='fname' value="">
         </td> </tr><tr><td>
	</td> </tr>  <tr> <td>
		<div align="center"><font color=pink>Lname
         </td> <td>
		<div align="left">
             <input type=text name='lname' value=''>
         </td> </tr> <tr> <td>
		<div align="center"><font color=pink>Address
         </td> <td>
		<div align="left">
		

           <TEXTAREA id='address' name='address' ></TEXTAREA>
         </td> </tr><tr><td >
		<div align="left">
         
         	</td></tr><tr> <td>
		<div align="center"><font color=pink>Phone
         </td> <td>
		<div align="left">
           <input type="text"  name='phone'>
         </td> </tr><tr> <td>
		<div align="center"><font color=pink>MailId
         </td> <td>
		<div align="left">
             <input type=text name='mailid' value="">
         </td> </tr><tr><td>
		<div align="center"><font color=pink>Groupid
         </td> <td>
		<div align="left">
             <select name='groupid'>
                   <option value='user' selected>User</option>
                    <option value='admin'>Agent</option>

            </select>
         </td> 

           </tr>
                     <tr><td>
		<div align="center"><font color=pink>Branch::
         </td> <td>
		<div align="left">
		      
             <select name='branch'>
                    <%while(rset.next()){%>
                   <option value=<%= rset.getString(1)%>><%= rset.getString(1)%></option>
                   <%}%>
            </select>
         </td> 

           </tr>
           
          <tr> <td>
         	<div align="right">
         	  <input type="submit" id="inputsubmit1" name="send" value="send" onclick="return checkval()">
        
           <input type="reset" id="inputsubmit1" name="clear" value="clear">
      
           <input type=Button id="inputsubmit1" value=Back onClick="window.history.back()">
         </td></tr>
</table>
</form>
<%
}
else{
       out.println("u are not a valid user to view this page");    
}
%>
</body>
</html>