<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div align="center">
		<hr width="35%" color="gray">
			<h3>PRODUCT 테이블 메인</h3>
		<hr width="35%" color="gray"> <br>
		
		<a href="<%=request.getContextPath() %>/product_list.do">[상품 전체 목록]</a>
	</div>
</body>
</html>
