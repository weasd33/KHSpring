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
		<hr width="45%" color="red">
			<h3>BOARD 전체 목록</h3>
		<hr width="45%" color="red"> <br>
		
		<table border="1" cellspacing="0" width="500">
			<tr>
				<th>No.</th> <th>제 목</th> <th>조회수</th> <th>작성일</th>
			</tr>
			
			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getBoard_no() }</td>
						<td>
							<a href="<%=request.getContextPath() %>/board_content.do?no=${dto.getBoard_no() }">${dto.getBoard_title() }</a>
						</td>
						<td>${dto.getBoard_hit() }</td>
						<td>${dto.getBoard_date().substring(0, 10) }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h3>게시물이 없습니다...</h3>
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="글작성" onclick="location.href='board_write.do'">
				</td>
			</tr>
		</table>
		<br>
		<form method="post" action="<%=request.getContextPath() %>/board_search.do">
			<select name="field">
				<option value="title">제목</option>
				<option value="cont">내용</option>
				<option value="writer">작성자</option>
			</select>
			
			<input name="keyword">
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>