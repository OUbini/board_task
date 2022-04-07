<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
</head>

<body>

	<table width="700" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>글번호</td>
			<td>${board.bid}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.bhit}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.bname}</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td>${board.btitle}</td>
		</tr>
		<tr>
			<td>글내용</td>
			<td>${board.bcontent}</td>
		</tr>
	</table>

<br>

	<form:form action="reply" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<input type="hidden" name="bgroup" value="${board.bgroup}">
			<input type="hidden" name="bstep" value="${board.bstep}">
			<input type="hidden" name="bindent" value="${board.bindent}">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea name="bcontent" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">
					&nbsp;&nbsp; <a href="/">목록보기</a></td>
			</tr>

		</table>
	</form:form>



</body>
</html>