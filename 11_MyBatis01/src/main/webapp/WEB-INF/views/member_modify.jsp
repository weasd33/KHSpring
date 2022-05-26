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
		<c:set var="dto" value="${modify }" />
		<hr width="50%" color="marmoon">
			<h3>MEMBER ${dto.getMemname() }님 정보 수정</h3>
		<hr width="50%" color="marmoon"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/member_modify_ok.do">
			<input type="hidden" name="num" value="${dto.getNum() }" />
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>아이디</th>
					<td><input name="memid" value="${dto.getMemid() }" readonly></td>
				</tr>
				<tr>
					<th>이 름</th>
					<td><input name="memname" value="${dto.getMemname() }" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" value="${dto.getPwd() }" readonly></td>
				</tr>
				<tr>
					<th>나 이</th>
					<td><input name="age" value="${dto.getAge() }" required></td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td><input name="mileage" value="${dto.getMileage() }" required></td>
				</tr>
				<tr>
					<th>직 업</th>
					<td><input name="job" value="${dto.getJob() }" required></td>
				</tr>
				<tr>
					<th>주 소</th>
					<td><input name="addr" value="${dto.getAddr() }" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원수정" />&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>