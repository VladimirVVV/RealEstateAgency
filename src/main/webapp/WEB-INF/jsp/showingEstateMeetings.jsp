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
<br>
Список клиентов зарегистрированных для осмотра объекта
<br>
<br>
<c:forEach items="${estateShowList}" var="estateShow">
    <br/>
    ${estateShow.meetingTime}
    ${estateShow.clientSurname}
    ${estateShow.realEstate.id}
</c:forEach>


</body>
</html>