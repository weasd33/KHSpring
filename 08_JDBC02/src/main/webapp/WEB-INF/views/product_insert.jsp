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
			<h3>PRODUCT 등록</h3>
		<hr width="50%" color="red"><br>
		
		<form method="post" action="<%=request.getContextPath() %>/product_insert_ok.do">
			<table border="1" cellspacing="0" width="260">
				<tr>
					<td colspan="2">
						<select name="cno">
							<option value="none">:::카테고리:::</option>
							<option value="1">프로그래밍</option>
							<option value="2">요리</option>
							<option value="3">경제</option>
							<option value="4">건강</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td><input name="pname"></td>
				</tr>
				<tr>
					<th>재고량</th>
					<td><input name="stock"></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><input name="price"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input name="company"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록하기">&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>		
	</div>
</body>
</html>