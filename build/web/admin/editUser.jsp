<%-- 
    Document   : editUser
    Created on : Jul 30, 2019, 2:25:51 PM
    Author     : admin
--%>

<%@page import="Model.UserModel"%>
<%@page import="Dao.ShopDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit User!</h1>
        <%

            String username;

            username = request.getParameter("username");
            ShopDao dao = new ShopDao();
            UserModel user = dao.findByUsername(username);
            pageContext.setAttribute("user", user);
        %>
        <form action="../EditServlet?username=${user.username}" method="post">
            <div class="line">
                <label for="fullName">Họ và tên:</label>
                <input type="text" name="fullname" id="fullName" value="${user.fullname}" required>
            </div>
            <div class="line">
                <label for="address">Địa chỉ</label>
                <input type="text" name="address" id="address" value="${user.address}" required>
            </div>
            <div class="line">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" name="username" id="username" value="${user.username}" disabled>
            </div>
            <div class="line">
                <label for="password">Mật khẩu:</label>
                <input type="password" name="password" id="password" value="${user.password}" required>
            </div>
            <div class="line">
                <label for="re_spassword">Nhập lại mật khẩu:</label>
                <input type="password" name="re_password" id="re_password" value="${user.password}" required>
            </div>
            <div class="line">
            <% if(request.getAttribute("errorMsgRes")!= null){%>
        
                <label><%= request.getAttribute("errorMsgRes")%></label>
                
            <%}%>
            </div>
            <div class="line">
                <input type="submit" value="Chỉnh sửa">
            </div>
        </form>
    </body>
</html>
