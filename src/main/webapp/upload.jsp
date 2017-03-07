<html>
<head>
<title>Time Tracker</title>

<link href="default1.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor=burlywood>
<%@ include file="../Common.jsp" %>
<form method="post" action="./UplSrv" name="upload" enctype="multipart/form-data">
<br><br>
      <table align="center" >
        <tr><td>
         <b><font face=monospace color=pink size=3>Select File To Upload:: </b></td><td><input type="file"  name="uploadfile1"><br></td></tr>    
        <tr align="justify"><td></td><td><input type="Submit" id="inputsubmit1" value="Upload"><input type="reset" id="inputsubmit1" value="cancel"></td></tr>
        </table>
</form>
</body>
</html>