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
		<tr>
			<td colspan="2">&nbsp;&nbsp; <a href="/">목록보기</a>
				&nbsp;&nbsp; <a href="modify_view?bid=${board.bid}">수정</a>
				&nbsp;&nbsp; <a href="delete?bid=${board.bid}">삭제</a> 
				&nbsp;&nbsp; <a href="reply_view?bid=${board.bid}">답변</a>
			</td>
		</tr>
	</table>


</body>
</html>