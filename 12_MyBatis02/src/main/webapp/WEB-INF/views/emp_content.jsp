<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP TABLE</title>
</head>
<body>
	<div align="center">
		<c:set var="dto" value="${Cont }" />
		<c:set var="dList" value="${DeptList }"/>
		<hr width="50%" color="red">
			<h3>${dto.ename }님 정보</h3>
		<hr width="50%" color="red"> <br>
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>사원 No.</th>
				<td>${dto.empno }</td>
			</tr>
			<tr>
				<th>사원명</th>
				<td>${dto.ename }</td>
			</tr>
			<tr>
				<th>담당업무</th>
				<td>${dto.job }</td>
			</tr>
			<tr>
				<th>관리자 No.</th>
				<td>${dto.mgr }</td>
			</tr>
			<tr>
				<th>급 여</th>
				<td><fmt:formatNumber value="${dto.sal }" />만원</td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><fmt:formatNumber value="${dto.comm }" />만원</td>
			</tr>
			<tr>
				<th>부서 No.</th>
				<c:forEach items="${dList }" var="ddto">
					<c:if test="${dto.deptno eq ddto.deptno }">
						<td>${dto.deptno }[${ddto.dname }]</td>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<th>입사일</th>
				<td>${dto.hiredate }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="사원수정" onclick="location.href='emp_update.do?no=${dto.empno }'">
					<input type="button" value="사원삭제" onclick="if(confirm('정말로 삭제하시겠습니까??')) {
						location.href='emp_delete.do?no=${dto.empno }' } else { return; }">
					<input type="button" value="사원목록" onclick="location.href='emp_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>