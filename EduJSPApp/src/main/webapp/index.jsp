<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%
    request.setAttribute("vista", "/views/bienvenida.jsp");
    request.getRequestDispatcher("plantilla.jsp").forward(request, response);
%>