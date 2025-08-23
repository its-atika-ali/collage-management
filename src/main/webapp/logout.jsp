<%-- 
    Document   : logout
    Created on : Aug 20, 2025, 1:23:00 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>

