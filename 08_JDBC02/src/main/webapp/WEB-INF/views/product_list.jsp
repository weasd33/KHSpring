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
		<hr width="50%" color="red">
			<h3>PRODUCT 전체 리스트</h3>
		<hr width="50%" color="red"><br>

		<table border="1" cellspacing="0" width="700">
			<tr>
				<th>PNo.</th>
				<th>상품명</th>
				<th>재고량</th>
				<th>가 격</th>
				<th>출판사</th>
				<th>CNo.</th>
				<th>카테고리명</th>
			</tr>
			<c:set var="list" value="${list }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getPno() }</td>
						<td><a
							href="<%=request.getContextPath() %>/product_content.do?num=${dto.getPno() }">${dto.getPname() }</a>
						</td>
						<td>${dto.getStock() }</td>
						<td><fmt:formatNumber value="${dto.getPrice() }" />원</td>
						<td>${dto.getCompany() }</td>
						<td>${dto.getCno() }</td>
						<td>${dto.getCname() }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="7" align="center">
						<h3>현재 상품이 없습니다..</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="7" align="right">
					<input type="button" value="제품등록" onclick="location.href='product_insert.do'">
				</td>
			</tr>
		</table>
		<br>
	</div>
</body>
</html>