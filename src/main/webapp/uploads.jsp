<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/file/uploads" method="post" enctype="multipart/form-data">
		file1:<input type="file" name="imgs"><br>
		file2:<input type="file" name="imgs"><br>
		file3:<input type="file" name="imgs"><br>
		<input type="submit" value="上传">
	</form>
	<c:forEach items="${files}" var="file">
		<img  src="${file}" width="300px">
	</c:forEach>
</body>
</html>