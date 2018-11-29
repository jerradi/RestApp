<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
ccc
<%-- <link type="text/css" href="<c:url value="/rcss/css/restApp.css" /> "  rel="stylesheet" />  --%>
<link href='<c:url value="/rcss/css/restApp.css" />' rel="stylesheet">
<meta charset="UTF-8">
<title>Home </title>
</head>
<body>
<h1>INDEX</h1>
</body> 
c:url is equivalent to response.encodeURL() 
<script type="text/javascript"     src="<c:url value="/rcss/js/restApp.js" />"    ></script>
</html>