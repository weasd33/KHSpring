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
		<hr width="45%" color="gray">
			<h3>BOARD 글쓰기</h3>
		<hr width="45%" color="gray"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/board_write_ok.do">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>작성자</th>
					<td><input name="board_writer"></td>
				</tr>
				<tr>
					<th>제 목</th>
					<td><input name="board_title"></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td>
						<textarea rows="7" cols="25" name="board_cont"></textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="board_pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="작성하기">&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>