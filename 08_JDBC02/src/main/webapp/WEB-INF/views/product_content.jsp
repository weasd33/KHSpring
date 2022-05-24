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
		<c:set var="dto" value="${Cont }" />
		<hr width="30%" color="red">
			<h3>${dto.getPname() } 정보</h3>
		<hr width="30%" color="red"> <br>
		
		<table border="1" cellspacing="0" width="450">
			<tr>
				<th>No.</th>
				<td>${dto.getPno() }</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>${dto.getPname() }</td>
			</tr>
			<tr>
				<th>재고량</th>
				<td>${dto.getStock() }</td>
			</tr>
			<tr>
				<th>가 격</th>
				<td><fmt:formatNumber value="${dto.getPrice() }" />원</td>
			</tr>
			<tr>
				<th>출판사</th>
				<td>${dto.getCompany() }</td>
			</tr>
			<tr>
				<th>CNo.</th>
				<td>${dto.getCno() }</td>
			</tr>
			<tr>
				<th>분 류</th>
				<td>${dto.getCname() }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="상품수정" onclick="location.href='product_modify.do?num=${dto.getPno() }'">
					<input type="button" value="상품삭제" onclick="if(confirm('정말로 삭제하시겠습니까?')) {
						location.href='product_delete.do?num=${dto.getPno() }&cno=${dto.getCno() }' } else { return; }"> 
					<input type="button" value="상품목록" onclick="location.href='product_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>