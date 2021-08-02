<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
	<body>
		<form method="post" action="/book"/>
			제목 : <input type="text" name="title" /><br/>
			저자 : <input type="text" name="author"/><br/>
			가격 : <input type="text" name="price"/><br/>
			<input type="submit" value="제출"/>
		</form>
	</body>
</html>