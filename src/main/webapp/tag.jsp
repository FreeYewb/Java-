<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>信息</h1>
	<form:form modelAttribute="student">
		学生ID:<form:input path="id"/>
		学生姓名:<form:input path="name"/>
		学生年龄:<form:input path="age"/>
	<input type="submit" value="提交">
	</form:form>
	<form:form modelAttribute="student2">
		学生ID:<form:input path="id"/>
		学生姓名:<form:input path="name"/>
		学生年龄:<form:input path="age"/>
	<input type="submit" value="提交">
	</form:form>
</body>
</html>