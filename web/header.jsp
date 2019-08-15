
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/home.css"/>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/account.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <%
            pageContext.setAttribute("username", session.getAttribute("username"));
        %>
        <div class="control-login">
            <p>Shop Bánh</p>
            <core:if test="${username != null}">
                <a href="#"> ${username}</a>
                <a href="LogoutServlet">Đăng xuất</a>
                <a href="profile.jsp">Thông tin</a>
            </core:if>
            <core:if test="${username == null}">
                <a href="login.jsp">Đăng nhập</a>
                <a href="register.jsp">Đăng ký</a>
            </core:if>
        </div>