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
		<hr width="50%" color="blue">
			<h3>FILE UPLOAD PAGE</h3>
		<hr width="50%" color="blue"> <br>
		
		<form enctype="multipart/form-data" method="post" action="<%=request.getContextPath() %>/upload_ok.do">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>첨부파일_1</th>
					<td><input type="file" name="file1"></td>
				</tr>
				<tr>
					<th>첨부파일_2</th>
					<td><input type="file" name="file2"></td>
				</tr>
				<tr>
					<th>첨부파일_3</th>
					<td><input type="file" name="file3"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="파일전송">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>