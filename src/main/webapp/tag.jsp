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
<<<<<<< HEAD
		<form:password path="name"/>
		
		check<form:checkbox path="flag" value="flag"/><br>
		checks<form:checkbox path="hobby" value="s宿舍s"/>${student.hobby[0]}<br>
		<form:checkbox path="hobby" value="sii"/>${student.hobby[1]}<br>
		<form:checkbox path="hobby" value="s"/>${student.hobby[2]}<br>
		<form:checkbox path="" value="ss"/>${student.hobby[3]}<br>
		<form:radiobuttons path="selectGrade" items="${student.gradeMap}"/>
	<input type="submit" value="提交">
	</form:form>
	<form:form modelAttribute="student2">
		学生ID:<form:input path="id"/>
		学生姓名:<form:input path="name"/>
		学生年龄:<form:input path="age"/></br>
		爱好<form:checkboxes path="hobby" items="${student2.selectHobby}"/></br>
		radiobutton<form:radiobutton path="radioId" value="1"/>radiobutton</br>
=======
	<input type="submit" value="提交">
	</form:form>
	<form:form modelAttribute="student2">
		学生ID:<form:input path="id"/>
		学生姓名:<form:input path="name"/>
		学生年龄:<form:input path="age"/>
>>>>>>> branch 'master' of https://github.com/FreeYewb/Java-.git
	<input type="submit" value="提交">
	</form:form>
</body>
</html>