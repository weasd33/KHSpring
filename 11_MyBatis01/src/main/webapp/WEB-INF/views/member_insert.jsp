<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="gray">
			<h3>MEMBER10 TABLE INSERT</h3>
		<hr width="50%" color="gray"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/member_insert_ok.do">
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>아이디</th>
					<td><input name="memid"></td>
				</tr>
				<tr>
					<th>이 름</th>
					<td><input name="memname"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>나 이</th>
					<td><input name="age"></td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td><input name="mileage"></td>
				</tr>
				<tr>
					<th>직 업</th>
					<td><input name="job"></td>
				</tr>
				<tr>
					<th>주 소</th>
					<td><input name="addr"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원등록">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="초기화">&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>