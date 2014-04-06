<%@ page language="java" contentType="text/html;" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/login.do">
		<input type="text" name="name"/><br>
		<input type="text" name="pass"/><br>
		<input type="submit"/>
	</form>
</body>
</html>