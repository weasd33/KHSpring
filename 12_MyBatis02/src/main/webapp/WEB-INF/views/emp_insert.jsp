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
		<hr width="50%" color="gray">
			<h3>EMP INSERT PAGE</h3>
		<hr width="50%" color="gray"> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/emp_insert_ok.do">
			<c:set var="jList" value="${JobList }" />
			<c:set var="mList" value="${MgrList }" />
			<c:set var="dList" value="${DeptList }" />
			
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>No.</th>
					<td><input name="empno"></td>
				</tr>
				<tr>
					<th>사원 이름</th>
					<td><input name="ename"></td>
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
									<option value="${str }">${str }</option>
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
									<option value="${mdto.empno }">${mdto.ename }[${mdto.empno }]</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>급 여</th>
					<td><input name="sal" /></td>
				</tr>
				<tr>
					<th>보너스</th>
					<td><input name="comm" /></td>
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
									<option value="${ddto.deptno }">${ddto.dname }[${ddto.deptno }]</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="사원등록" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>