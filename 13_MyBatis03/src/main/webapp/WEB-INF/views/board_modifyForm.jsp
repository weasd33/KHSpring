<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<div align="center">
		<c:set var="dto" value="${Modify }" />
		<hr width="50%" color="orange">
			<h3>BOARD ${dto.board_writer }님 글 수정</h3>
		<hr width="50%" color="orange"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/board_modify_ok.do">
			<input type="hidden" name="board_no" value="${dto.board_no }" />
			<input type="hidden" name="db_pwd" value="${dto.board_pwd }" />
			<input type="hidden" name="page" value="${Page }" />
			<table border="1" cellspacing="0" width="450">
				<tr>
					<th>작성자</th>
					<td><input name="board_writer" value="${dto.board_writer }" readonly></td>
				</tr>
				<tr>
					<th>제 목</th>
					<td><input name="board_title" value="${dto.board_title }" required></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td>
						<textarea rows="7" cols="25" name="board_cont" required>${dto.board_cont }</textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="board_pwd" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기"/>&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="history.back()"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>