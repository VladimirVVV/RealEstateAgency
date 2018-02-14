<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display-el"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Adding/Editing account for current clients</title>

    <link rel="stylesheet" type="text/css" href="static/css/alternative.css">
    <link rel="stylesheet" type="text/css" href="static/css/displaytag.css">
    <link rel="stylesheet" type="text/css" href="static/css/maven-base.css">
    <link rel="stylesheet" type="text/css" href="static/css/maven-theme.css">
    <link rel="stylesheet" type="text/css" href="static/css/print.css">
    <link rel="stylesheet" type="text/css" href="static/css/screen.css">
    <link rel="stylesheet" type="text/css" href="static/css/site.css">
    <link rel="stylesheet" type="text/css" href="static/css/teststyles.css">

</head>

<body>

<html:form action="/saveAccount.do">
    <html:hidden property="id" value="${id}" />
    <html:submit value="save" />
</html:form>


<%--<table>--%>
<%--<logic:iterate id="customer" name="dynaClientListForm" property="clientList">--%>
<%--<tr>--%>
<%--<td><bean:write name="customer" property="name"/></td>--%>
<%--<td><bean:write name="customer" property="surname"/></td>--%>
<%--</tr>--%>
<%--</logic:iterate>--%>
<%--</table>--%>


</body>
</html>
