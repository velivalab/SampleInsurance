<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String dt=new java.util.Date().toString();
String day=dt.substring(8,10);
String mon=dt.substring(4,7);
String tim=dt.substring(10,16);
%>
<%=day %>
<%=mon %>
<%=tim %>
</body>
</html>