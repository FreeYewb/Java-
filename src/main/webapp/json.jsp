<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var user = {
				"id":1,
				"name":"张三"
				
		};
		$.ajax({
			url:"/data/json",
			data:JSON.stringify(user),
			type:"POST",
			contentType:"application/json;charset=UTF-8",
			dataType:"JSON",
			success:function(data){
				alert(data.id+"--"+data.name);
			}
		})
	});
</script>
</head>
<body>

</body>
</html>