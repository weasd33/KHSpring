<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP TABLE</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
			<h3>EMP SEARCH LIST</h3>
		<hr width="50%" color="red"> <br>
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>No.</th> <th>이 름</th> 
				<th>담당업무</th> <th>입사일</th> 
			</tr>
			<c:set var="list" value="${searchList }" />
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.getEmpno() }</td>
					<td>
						<a href="<%=request.getContextPath() %>/emp_content.do?no=${dto.getEmpno() }">${dto.ename }</a>
					</td>
					<td>${dto.job }</td>
					<td>${dto.hiredate.substring(0, 10) }</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="사원등록" onclick="location.href='emp_insert.do'" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>