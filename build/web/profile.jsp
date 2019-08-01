<%-- 
    Document   : profile
    Created on : Jul 30, 2019, 10:13:03 AM
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
        <%
            ShopDao dao = new ShopDao();
            String username = (String) session.getAttribute("username");
            UserModel user = dao.findByUsername(username);
            pageContext.setAttribute("user", user);
        %>
        <h1>Xin chào</h1>
        <hr>
        <h2>Thông tin của bạn:</h2>
        <table>
            <tr>
                <th>Họ và tên:</th>
                <td>${user.fullname}</td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>${user.address}</td>
            </tr>
            <tr>
                <th>Tên đăng nhập</th>
                <td>${user.username}</td>
            </tr>
            <tr>
                <th>Mật khẩu</th>
                <td>
                    <details>
                        <summary>Thay đổi mật khẩu</summary>
                        <form action="ChangePasswordServlet" method="post">
                            <input type="text" name="oldPassword">
                            <input type="text" name="newPassword">
                            <input type="text" name="reNewPassword">
                            <input type="submit" value="Thay đổi">
                        </form>
                    </details>
                    <%
                        if(request.getAttribute("msgForChangePass") != null){
                    %>  
                    <p><%=request.getAttribute("msgForChangePass") %></p>
                    <%}%>
                </td>
            </tr>
        </table>
    </body>
</html>
