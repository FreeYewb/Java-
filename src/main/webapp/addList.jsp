<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/data/list" method="post">
		用户1编号：<input type = "text" name="users[0].id"><br>
		用户1名称：<input type="text" name="users[0].name"><br>
		用户2编号：<input type = "text" name="users[1].id"><br>
		用户2名称：<input type="text" name="users[1].name"><br>
		用户3编号：<input type = "text" name="users[2].id"><br>
		用户3名称：<input type="text" name="users[2].name"><br>
		<input type="submit" value="提交"> 
	</form>
</body>
</html>