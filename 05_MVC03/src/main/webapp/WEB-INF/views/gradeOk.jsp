<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 결과</title>
</head>
<body>
	<div align="center">
		<hr width="30%" color="green">
			<h3>성적 결과</h3>
		<hr width="30%" color="green"> <br>
		
		<table border="1" cellspacing="0" width="250">
			<tr>
				<th>이름</th>
				<td>${name }</td>
			</tr>
			<tr>
				<th>국어</th>
				<td>${kor }</td>
			</tr>
			<tr>
				<th>영어</th>
				<td>${eng }</td>
			</tr>
			<tr>
				<th>수학</th>
				<td>${math }</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="재입력" onclick="location.href='<%=request.getContextPath() %>/input'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>