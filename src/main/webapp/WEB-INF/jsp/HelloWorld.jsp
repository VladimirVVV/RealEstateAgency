<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
</head>
<body>
<%--<h1><bean:write name="helloWorldForm" property="message" />--%>
</h1>

<h1>
CountryJSON ::
<%=request.getAttribute("CountryJson") %>

</h1>
</body>
</html>