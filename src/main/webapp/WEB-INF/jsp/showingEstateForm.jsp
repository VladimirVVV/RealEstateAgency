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
Форма регистрации для осмотра объекта
<br>
<br>
Адрес объекта: ${realEstate.address}

<form name="test" method="get" action="registrate_meeting">
    <table>
        <tr>
            <td><b>Фамилия:</b></td>
            <td><input type="text" name="clientSurname" value=""></td>
        </tr>
        <tr>
            <td><b>Имя:</b></td>
            <td><input type="text" name="clientName" value=""></td>
        </tr>
        <tr>
            <td><b>Отчество:</b></td>
            <td><input type="text" name="clientPatronymic" value=""></td>
        </tr>
        <tr>
            <td><b>Телефон:</b></td>
            <td><input type="text" name="clientPhone" value=""></td>
        </tr>
        <tr>
            <td><b>Дата(dd.mm.yyyy):</b></td>
            <td><input type="date" name="clientDate" value=""></td>
        </tr>
        <tr>
            <td><b>Время(hh:mm:ss):</b></td>
            <td><input type="time" name="clientTime" value=""></td>
        </tr>
    </table>
    <br/>
    <input type="text" name="realEstateId" value="${realEstate.id}" hidden="true">
    <p><input type="submit" value="Зарегестрироваться"></p>
</form>

</body>
</html>