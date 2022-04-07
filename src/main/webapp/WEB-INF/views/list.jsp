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

<c:url var="onlyLogin" value="${pageContext.request.contextPath}/board/test"/>
<a href="${onlyLogin}">로그인한 유저만 들어갈 수 있도록</a>


	<table width="850" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>작성날짜</td>
			<td>조회수</td>
		</tr>

		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bid}</td>
				<td>${board.bname}</td>
				<td><c:forEach begin="1" end="${board.bindent}"> [Re] </c:forEach>
					<a href="content_view?bid=${board.bid}">${board.btitle}</a></td>
				<td>${board.bdate}</td>
				<td>${board.bhit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>

	</table>

	<c:if test="${pageMaker.pre}"><a href="/${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a></c:if>
	
	<c:forEach var="idx" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
		<a href="/${pageMaker.makeQuery(idx)}">${idx}</a>
	</c:forEach>
	
	<c:if test="${pageMaker.next && pageMaker.endPage > 0}"><a href="/${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a></c:if>
	<br>

</body>
</html>