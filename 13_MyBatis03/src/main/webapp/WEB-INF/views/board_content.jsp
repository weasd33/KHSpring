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
		<c:set var="dto" value="${Cont }" />
		<hr width="50%" color="red">	
			<h3>${dto.board_writer }님 글 내용</h3>
		<hr width="50%" color="red"> <br>
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>작성자</th>
				<td>${dto.board_writer }</td>
			</tr>
			<tr>
				<th>제 목</th>
				<td>${dto.board_title }</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td>
					<textarea rows="7" cols="25" readonly>${dto.board_cont }</textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<c:forEach begin="1" end="${dto.board_pwd.length() }">
						＊
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.board_hit }</td>
			</tr>
			<tr>
				<c:if test="${empty dto.board_update }">
					<th>작성일</th>
					<td>${dto.board_date }</td>
				</c:if>
				<c:if test="${!empty dto.board_update }">
					<th>수정일</th>
					<td>${dto.board_update }</td>
				</c:if>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="location.href='board_modify.do?no=${dto.board_no }&page=${Page }'">
					<input type="button" value="삭제하기" onclick="if(confirm('정말로 삭제하시겠습니까??')) {
						location.href='board_delete.do?no=${dto.board_no }&page=${Page }'} else { return; }">
					<input type="button" value="뒤로가기" onclick="location.href='board_list.do?page=${Page }'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>