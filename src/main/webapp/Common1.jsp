<html>
<link href="default1.css" rel="stylesheet" type="text/css" />
<body bgcolor="#33CCCC">
     <table width="100%" border=1 BORDERCOLOR="#aqua"  name=t1 >
         <tr align="center">
           <td > <div align="center">

       <p align="center"><b> <font face="monospace, Times, serif" size="15" ><f2>Time And Work Management System</f2><f3  ></f3></font></b> </p>
     	</td>
         </tr><tr align="center" >
        <td > <div align="left">


        <p ><h4 align="center">welcome&nbsp
         <%
                   String s=(String)session.getAttribute("user");
                   out.println(s);
       %>
       </h4>
</td>
       </tr>
	</table>
</body>
</html>