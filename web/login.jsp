<%-- 
    Document   : login
    Created on : Jul 25, 2019, 10:42:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css"/>
        <script src="js/validateInput.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ĐĂNG NHẬP</h1>
        <form action="LoginServlet" method="post">
            <%
                pageContext.setAttribute("username", session.getAttribute("username"));
                pageContext.setAttribute("password", session.getAttribute("password"));
            %>
            <div class="line">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" name="username" id="username" value="${username}" required>
            </div>
            <div class="line">
                <label for="password">Mật khẩu:</label>
                <input type="password" name="password" id="password" value="${password}" required>
            </div>
            <div class="line">
                <% if(session.getAttribute("errorMsg")!= null){%>
                
                <label><%= session.getAttribute("errorMsg")%></label>
                
                <%}%>
            </div>
            <div class="line">
                <input type="submit" value="Đăng nhập" required>
                <p>Nếu chưa có tài khoản hãy <a href="register.jsp">Đăng ký</a></p>
            </div>
        </form>
    </body>
</html>
