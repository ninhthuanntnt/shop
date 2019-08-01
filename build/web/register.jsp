<%-- 
    Document   : register
    Created on : Jul 25, 2019, 11:05:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/validateInput.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ĐĂNG KÝ</h1>
        <%
            pageContext.setAttribute("fullname", request.getParameter("fullname"));
            pageContext.setAttribute("address", request.getParameter("address"));
            pageContext.setAttribute("username", request.getParameter("username"));
        %>
        <form action="RegisterServlet" method="post">
            <div class="line">
                <label for="fullName">Họ và tên:</label>
                <input type="text" name="fullname" id="fullName" value="${fullname}" required>
            </div>
            <div class="line">
                <label for="address">Địa chỉ</label>
                <input type="text" name="address" id="address" value="${address}" required>
            </div>
            <div class="line">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" name="username" id="username" value="${username}" required>
            </div>
            <div class="line">
                <label for="password">Mật khẩu:</label>
                <input type="password" name="password" id="password" required>
            </div>
            <div class="line">
                <label for="re_spassword">Nhập lại mật khẩu:</label>
                <input type="password" name="re_password" id="re_password" required>
            </div>
            <div class="line">
                <% if(request.getAttribute("errorMsgRes")!= null){%>
                
                <label><%= request.getAttribute("errorMsgRes")%></label>
                
                <%}%>
            </div>
            <div class="line">
                <input type="submit" value="Đăng ký">
            </div>
        </form>
    </body>
</html>
