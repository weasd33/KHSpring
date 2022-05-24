<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:set var="dto" value="${Modify }" />
		<hr width="30%" color="red">
			<h3>${dto.getPname() } 정보</h3>
		<hr width="30%" color="red"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/product_modify_ok.do">
		<table border="1" cellspacing="0" width="450">
			<tr>
				<th>No.</th>
				<td><input name="pno" value="${dto.getPno() } " readonly></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input name="pname" value="${dto.getPname() }" required></td>
			</tr>
			<tr>
				<th>재고량</th>
				<td><input name="stock" value="${dto.getStock() }" required></td>
			</tr>
			<tr>
				<th>가 격</th>
				<td><input name="price" value="${dto.getPrice() }" required></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input name="company" value="${dto.getCompany() }" required></td>
			</tr>
			<tr>
				<th>분 류</th>
				<td><input name="pname" value="${dto.getCname() }" readonly></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">&nbsp;&nbsp;&nbsp;
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>