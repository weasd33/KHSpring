<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
			<h3>MEMBER SEARCH LIST</h3>
		<hr width="50%" color="red"> <br>
		
		<table border="1" cellspacing="0" width="450">
			<tr>
				<th>No.</th> <th>이 름</th>
				<th>직 업</th> <th>가입일</th>
			</tr>
			<c:set var="list" value="${search }" />
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.getNum() }</td>
					<td>
						<a href="<%=request.getContextPath() %>/member_content.do?num=${dto.getNum() }">${dto.getMemname() }</a>
					</td>
					<td>${dto.getJob() }</td>
					<td>${dto.getRegdate().substring(0, 10) }</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="회원목록" onclick="location.href='member_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>