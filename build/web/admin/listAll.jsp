<%-- 
    Document   : listAll
    Created on : Jul 26, 2019, 9:12:48 AM
    Author     : admin
--%>

<%@page import="java.util.List"%>
<%@page import="Model.UserModel"%>
<%@page import="Dao.ShopDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List all user</title>
        <style>
            table, tr, th, td{
                border : 1px solid black;
                border-collapse: collapse;
            }
            td,td{
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <h1>List all user</h1>
        <div>
            <%
                if(session.getAttribute("usernameAdmin") == null){
                    response.sendRedirect("../login.jsp");
                }
            %>
            <p>User: <%= session.getAttribute("usernameAdmin") %> <a href="../LogoutServlet">Logout</a></p>
        </div>
        <table>
            <tr>
                <th>ID</th>
                <th>Họ và tên</th>
                <th>Địa chỉ</th>
                <th>Tên đăng nhập</th>
                <th>Mật khẩu</th>
                <th colspan="2">Thay đổi</th>
            </tr>
            <%
                int i = 0;
                ShopDao dao = new ShopDao();
                List<UserModel> list = dao.findAll();
                if(list != null)
                    for(UserModel user : list){
                        
                        i++;
            %>
            <tr>
                <td><%= i%></td>
                <td><%=user.getFullname()%></td>
                <td><%=user.getAddress()%></td>
                <td><%=user.getUsername()%></td>
                <td><%=user.getPassword()%></td>
                <td><a href="editUser.jsp?username=<%= user.getUsername() %>">Edit</a></td>
                <td><a href="../DeleteServlet?username=<%= user.getUsername() %>">Delete</a></td>
                
            </tr>
            <%}else{%>
            <tr>
                <td colspan="5">No data</td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
