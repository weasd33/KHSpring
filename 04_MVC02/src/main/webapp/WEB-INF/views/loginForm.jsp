<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="30%" color="gray">
			<h3>로그인 입력 폼 페이지</h3>
		<hr width="30%" color="gray"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/loginOk">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>아이디</th>
					<td><input name="userId"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="userPwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
						<input type="button" value="취소" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>