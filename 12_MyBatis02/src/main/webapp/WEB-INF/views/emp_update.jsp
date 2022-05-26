<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP TABLE</title>
</head>
<body>
	<div align="center">
		<c:set var="dto" value="${modify }" />
		<hr width="50%" color="gray">
			<h3>${dto.ename }님 정보 수정</h3>
		<hr width="50%" color="gray"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/emp_modify_ok.do">
			<c:set var="jList" value="${JobList }" />
			<c:set var="mList" value="${MgrList }" />
			<c:set var="dList" value="${DeptList }" />
			
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>사원 No.</th>
					<td><input name="empno" value="${dto.empno }" readonly></td>
				</tr>
				<tr>
					<th>사원명</th>
					<td><input name="ename" value="${dto.ename }" readonly></td>
				</tr>
				<tr>
					<th>담당업무</th>
					<td>
						<select name="job">
							<c:if test="${empty jList }">
								<option value="">:::담당업무:::</option>
							</c:if>
							<c:if test="${!empty jList }">
								<c:forEach items="${jList }" var="str">
									<c:if test="${dto.job eq str }">
										<option value="${str }" selected>${str }</option>
									</c:if>
									<c:if test="${dto.job ne str }">
										<option value="${str }">${str }</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>관리자 No.</th>
					<td>
						<select name="mgr">
							<c:if test="${empty mList }">
								<option value="">:::관리자:::</option>
							</c:if>
							<c:if test="${!empty mList }">
								<c:forEach items="${mList }" var="mdto">
									<c:if test="${dto.mgr eq mdto.empno }">
										<option value="${mdto.empno }" selected>${mdto.ename }[${mdto.empno }]</option>
									</c:if>
									<c:if test="${dto.mgr ne mdto.empno }">
										<option value="${mdto.empno }">${mdto.ename }[${mdto.empno }]</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>급 여</th>
					<td><input name="sal" value="${dto.sal }"></td>
				</tr>
				<tr>
					<th>보너스</th>
					<td><input name="comm" value="${dto.comm }"></td>
				</tr>
				<tr>
					<th>부서 No.</th>
					<td>
						<select name="deptno">
							<c:if test="${empty dList }">
								<option value="">:::부서번호:::</option>
							</c:if>
							<c:if test="${!empty dList }">
								<c:forEach items="${dList }" var="ddto">
									<c:if test="${dto.deptno eq ddto.deptno }">
										<option value="${ddto.deptno }" selected>${ddto.dname }[${ddto.deptno }]</option>
									</c:if>
									<c:if test="${dto.deptno ne ddto.deptno }">
										<option value="${ddto.deptno }">${ddto.dname }[${ddto.deptno }]</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기" />
						<input type="button" value="취소" onclick="history.back()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>