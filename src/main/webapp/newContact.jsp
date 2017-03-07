<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<%@ page import="org.cdsdemo.insurancemanagement.connection.*,java.sql.*,java.util.Date" %>
<%@ include file="../Common.jsp" %>
<script language="javascript">
 function checkval(){
       if(document.form1.fname.value==""){
                  //alert("ENTER  FIRSTNAME");
                    document.form1.fname.focus();
                return false;
            } 
            if(document.form1.lname.value==""){
                  //alert("ENTER LASTNAME");
                    document.form1.lname.focus();
                return false;
            }        
              if(document.form1.mailid.value==""){
                  //alert("ENTER MAILID ");
                    document.form1.mailid.focus();
                return false;
            }              
            
               return true;
    }

</script>
<body >
<form name="form1" action="./StoreContact">
<p ><b><div align="center"><font size=4 face=arial  color=pink>NEW CONTACT</font></p>
<table width="50%" border="0" bordercolor="pink" align="center">
         <tr> <td>
		<div align="center">
       <b><font color=pink>Fname
         </td> <td>
		<div align="left">
             <input type=text name='fname' value=''>
         </td> </tr>  <tr> <td>
		<div align="center">
                 <b><font color=pink> Lname
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
                                DBConnection dbcon=new DBGeneralImpl();
                                c=dbcon.getConnection();
                                 st=c.createStatement();
                                rs=st.executeQuery("select * from login");
						%>
             

                 <input type=text name='lname' value=''>
         </td> </tr><tr><td>


		</td> </tr>  <tr> <td>
		<div align="center">       <b><font color=pink>Phone
         </td> <td>
		<div align="left">
             <input type=text name='phone' value="">
         </td> </tr><tr><td>
	</td> </tr>  <tr> <td>
		<div align="center">       <b><font color=pink>Mailid
         </td> <td>
		<div align="left">
             <input type=text name='mailid' value=''>
         </td> </tr> <tr> <td>
		<div align="center">       <b><font color=pink>Address
         </td> <td>
		<div align="left">
		

           <TEXTAREA id='address' name='address' ></TEXTAREA>
         </td> </tr><tr><td >
		<div align="left">
         
         	</td></tr><tr> <td colspan=3>
		       <b><font color=pink>WorkInfo::</b>
       </td> </tr><tr> <td>
		<div align="center">       <b><font color=pink>OfficeAddress
         </td> <td>
		<div align="left">
		

           <TEXTAREA id='address' name='oaddress'></TEXTAREA>
         </td> </tr><tr> <td>
		<div align="center">       <b><font color=pink>OfficePhone
         </td> <td>
		<div align="left">
             <input type=text name='ophone' value="">
         </td> </tr><tr><td colspan=3>
         	<div align="center" >
         	  <input type="submit" id="inputsubmit1" name="send" value="send" onclick="return checkval()">
         
           <input type="reset" id="inputsubmit1"  name="clear" value="clear">
      
           <input type=Button id="inputsubmit1" value=Back onClick="window.history.back()">
         </td></tr>
</table>
</form>
</body>
</html>