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
	<form:form action="modify" method="post">
		<table width="700" cellpadding="0" cellspacing="0" border="1">
			<input type="hidden" name="bid" value="${board.bid}">
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
				<td><input type="text" name="bname" value="${board.bname}"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="btitle" value="${board.btitle}"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><textarea rows="10" name="bcontent">${board.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">
					&nbsp;&nbsp; <a href="/">목록보기</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>