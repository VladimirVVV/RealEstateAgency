<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<title>Real estate agency</title>

<body>
<c:if test="${error != null}">
    ERROR: ${error}
</c:if>

<table border="1">
    <caption>Список объектов недвижимости</caption>
    <tr>
        <th>id</th>
        <th>Имя владельца</th>
        <th>Адрес объекта</th>
    </tr>
    <c:forEach items="${realEstates}" var="estate">
        <tr>

            <td>
                <a href="/real_estate?id=${estate.id}&user_id=${estate.user.id}">
                        ${estate.id}
                </a>
            </td>

            <td>
                <a href="/real_estate?id=${estate.id}&user_id=${estate.user.id}">
                        ${estate.user.name}
                </a>
            </td>
            <td>
                <a href="/real_estate?id=${estate.id}&user_id=${estate.user.id}">
                        ${estate.address}
                </a>
            </td>

        </tr>

    </c:forEach>
</table>
</body>
</html>