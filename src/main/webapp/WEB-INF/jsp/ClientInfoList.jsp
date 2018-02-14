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
    <title>List of current clients</title>

    <link rel="stylesheet" type="text/css" href="static/css/alternative.css">
    <link rel="stylesheet" type="text/css" href="static/css/displaytag.css">
    <link rel="stylesheet" type="text/css" href="static/css/maven-base.css">
    <link rel="stylesheet" type="text/css" href="static/css/maven-theme.css">
    <link rel="stylesheet" type="text/css" href="static/css/print.css">
    <link rel="stylesheet" type="text/css" href="static/css/screen.css">
    <link rel="stylesheet" type="text/css" href="static/css/site.css">
    <link rel="stylesheet" type="text/css" href="static/css/teststyles.css">
    <script type="text/javascript">
        function submitForm()
        {
            document.forms[0].action = "/clientActInfo.do?method=addAccount"
            document.forms[0].submit();
        }
    </script>
</head>

<body>

<display:table name="dynaClientListForm.clientList" id="client" requestURI="/clientInfo.do" pagesize="15" class="Mars">
    <display:column property="name" title="Name" sortable="true"   />
    <display:column property="surname" title="Surname" sortable="true"  />
    <display:column property="email" title="Email" sortable="true"  />
    <display:column property="age" title="Age" sortable="true" />
    <display:column property="sex" title="Sex" sortable="true"/>

    <display:column property="acc_qty" title="Account quantity" sortable="true"  />
    <display:column property="total_balance" title="Total" sortable="true"  />
    <display:column title="Action">
        <html:form action="/clientActInfo.do">
            <html:hidden property="id" value="${client.id}" />
            <html:submit value="add account" onclick="submitForm()" />
            <html:submit value="delete" property="method" />
        </html:form>
        <%--<html:form action="clientInfo.do?action=delete">--%>
            <%--<html:submit value="delete" />--%>
        <%--</html:form>--%>
    </display:column>
</display:table>


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
