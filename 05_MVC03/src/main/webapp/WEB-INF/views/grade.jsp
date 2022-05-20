<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
</head>
<body>
	<div align="center">
		<hr width="30%" color="orange">
			<h3>성적 입력 페이지</h3>
		<hr width="30%" color="orange"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/inputOk">
			<table border="1" cellspacing="0" width="250">
				<tr>
					<th>이름</th>
					<td><input name="name"></td>
				</tr>
				<tr>
					<th>국어</th>
					<td><input name="kor"></td>
				</tr>
				<tr>
					<th>영어</th>
					<td><input name="eng"></td>
				</tr>
				<tr>
					<th>수학</th>
					<td><input name="math"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="전송">&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>