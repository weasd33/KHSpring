<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="red">
			<h3>BOARD ALL LIST</h3>
		<hr width="50%" color="red"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/board_search.do">
			<select name="field">
				<option value="title">제목</option>
				<option value="cont">내용</option>
				<option value="title_cont">제목+내용</option>
				<option value="writer">작성자</option>
			</select>
			
			<input name="keyword" />
			<input type="submit" value="검색" />
		</form>
		
		<table border="1" cellspacing="0" width="500">
			<tr>
				<th>No.</th> <th>제 목</th>
				<th>작성자</th> <th>조회수</th> <th>작성일</th>
			</tr>
			
			<c:set var="list" value="${List }" />
			<c:set var="paging" value="${Paging }" />
			
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="i">
					<tr>
						<td>${i.board_no }</td>
						<td>
							<a href="<%=request.getContextPath() %>/board_content.do?no=${i.board_no }&page=${paging.getPage() }">${i.board_title }</a>
						</td>
						<td>${i.board_writer }</td>
						<td>${i.board_hit }</td>
						<td>${i.board_date.substring(0, 10) }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">
						<h3>게시글이 비었습니다..</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="5" align="center">
					<input type="button" value="글쓰기" onclick="location.href='board_write.do'">
				</td>	
			</tr>
		</table>
		<br>
		
		<%-- 페이징 처리 부분 --%>
		<c:if test="${paging.getPage() > paging.getBlock() }">
			<a href="board_list.do?page=1">[처음]</a>
			<a href="board_list.do?page=${paging.getStartBlock() - 1 }">◀</a>
		</c:if>		
		
		<c:forEach begin="${paging.getStartBlock() }" end="${paging.getEndBlock() }" var="i">
			<c:if test="${i == paging.getPage() }">
				<b><a href="board_list.do?page=${i }">[${i }]</a></b>
			</c:if>
			<c:if test="${i != paging.getPage() }">
				<a href="board_list.do?page=${i }">[${i }]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${paging.getEndBlock() < paging.getAllPage() }">
			<a href="board_list.do?page=${paging.getEndBlock() + 1 }">▶</a>
			<a href="board_list.do?page=${paging.getAllPage() }">[끝]</a>
		</c:if>		
	</div>
</body>
</html>