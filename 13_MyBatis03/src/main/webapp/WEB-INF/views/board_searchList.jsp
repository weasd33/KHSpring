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
		<hr width="50%" color="marmoon">
			<h3>BOARD SEARCH LIST</h3>
		<hr width="50%" color="marmoon"> <br>
		
		<table border="1" cellspacing="0" width="500">
			<tr>
				<th>No.</th> <th>제 목</th>  
				<th>작성자</th> <th>조회수</th> <th>작성일</th>  
			</tr>
			
			<c:set var="list" value="${searchPageList }" />
			<c:set var="paging" value="${Paging }" />
			
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getBoard_no() }</td>
						<td>${dto.getBoard_title() }</td>
						<td>${dto.getBoard_writer() }</td>
						<td>${dto.getBoard_hit() }</td>
						<td>${dto.getBoard_date().substring(0, 10) }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">
						<h3>검색된 게시글이 없습니다..</h3>
					</td>
				</tr>
			</c:if>
		</table>
		<hr>
		
		<%-- 검색 페이지 처리 --%>
		<c:if test="${paging.getPage() > paging.getBlock() }">
			<a href="board_search.do?page=1&field=${paging.field }&keyword=${paging.keyword }">[처음]</a>
			<a href="board_search.do?page=${paging.startBlock - 1 }&field=${paging.field }&keyword=${paging.keyword }">◀</a>
		</c:if>
		
		<c:forEach begin="${paging.startBlock }" end=${paging.endBlock } var="i">
			<c:if test="${i eq paging.page }">
				<b><a href="board_search.do?page=${i }&field=${paging.field }&keyword=${paging.keyword }">[${i }]</a></b>
			</c:if>
			<c:if test="${i ne paging.page }">
				<a href="board_search.do?page=${i }&field=${paging.field }&keyword=${paging.keyword }">[${i }]</a>
			</c:if>
		</c:forEach>
		
		<c:if test="${paging.getEndBlock() < paging.getAllPage() }">
			<a href="board_search.do?page=${paging.endBlock + 1 }&field=${paging.field }&keyword=${paging.keyword }">▶</a>
			<a href="board_search.do?page=${paging.allPage }&field=${paging.field }&keyword=${paging.keyword }">[끝]</a>
		</c:if>
	</div>
</body>
</html>