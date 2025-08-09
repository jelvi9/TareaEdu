<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <jsp:include page="/templates/head.jsp" />
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-2 bg-light vh-100 p-0">
            <jsp:include page="/templates/menu.jsp" />
        </div>
        <div class="col-10 p-4">
            <jsp:include page="${vista}" />
        </div>
    </div>
</div>
<jsp:include page="/templates/footer.jsp" />
</body>
</html>