<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="marmoon">
			<h3>EMP MAIN PAGE</h3>
		<hr width="50%" color="marmoon"> <br>
		
		<a href="<%=request.getContextPath() %>/emp_list.do">[전체 사원 목록]</a>
	</div>
</body>
</html>
