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
    <form action="http://192.168.45.241:8080/routeTest/tea/order" method="post">
        <table>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>사이즈</th>
                <th>가격</th>
                <th>선택</th>
            </tr>

            <c:choose>
                <c:when test = "${empty requestScope.list || fn:length(list) == 0 }">
                    <tr>
                        <td colspan="5"> 등록된 메뉴 정보가 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${requestScope.list}" var="teas" varStatus="status">
                        <tr>
                            <td>${teas.id}</td>
                            <td>${teas.name}<input type="hidden" name="teaName_${status.index}" value="${teas.name}"></td>
                            <td>${teas.size}<input type="hidden" name="teaSize_${status.index}" value="${teas.size}"></td>
                            <td>${teas.price}<input type="hidden" name="teaPrice_${status.index}" value="${teas.price}"></td>
                            <td><input type="radio" name="selectedMenu" value="${status.index}"></td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>

        </table>
        <input type="submit" value="주문">
    </form>

</body>
</html>
