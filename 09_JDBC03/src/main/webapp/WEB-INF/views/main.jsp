<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div align="center">
		<hr width="45%" color="marmoon">
			<h3>BOARD MAIN</h3>
		<hr width="45%" color="marmoon"> <br>
		
		<a href="<%=request.getContextPath() %>/board_list.do">[게시글 전체 목록]</a>
	</div>
</body>
</html>
