<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>사이즈</th>
			<th>가격</th>
		</tr>

		<c:choose>
			<c:when test="${empty requestScope.list || fn:length(list) == 0 }">
				<tr>
					<td colspan="5">등록된 메뉴 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.list}" var="teas"
					varStatus="status">
					<tr>
						<td>${teas.id}</td>
						<td>${teas.name}</td>
						<td>${teas.size}</td>
						<td>${teas.price}</td>

					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
</body>
</html>
