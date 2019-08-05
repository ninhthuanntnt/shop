<%-- 
    Document   : index
    Created on : Jul 26, 2019, 2:32:45 PM
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to shop</h1>
        <%
            pageContext.setAttribute("username", session.getAttribute("username"));
        %>
        <div>
            <core:if test="${username != null}">
                <a href="#"> ${username}</a>
                <a href="LogoutServlet">|Đăng xuất|</a>
                <a href="profile.jsp">|Thông tin|</a>
            </core:if>
            <core:if test="${username == null}">
                <a href="login.jsp">|Đăng nhập|</a>
                <a href="register.jsp">|Đăng ký|</a>
            </core:if>
        </div>
    </body>
</html>
