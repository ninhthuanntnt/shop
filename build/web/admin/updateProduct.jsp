<%-- 
    Document   : updateProduct
    Created on : Aug 16, 2019, 6:13:49 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/login.css"/>
        <title>Update product</title>
    </head>
    <body>
        <h1>Thêm sản phẩm</h1>
        <form action="../UploadProductServlet" method="post" enctype="multipart/form-data">
            <div class="line">
                <label for="image">Tải lên hình sản phẩm:</label>
                <input type="file" name="image-product" id="image" required>
            </div>
            <div class="line">
                <label for="info">Thông tin sản phẩm</label>
                <input type="text" name="info-product" id="info" required>
            </div>
            <div class="line">
                <input type="submit" value="Đăng ký">
            </div>
        </form>
    </body>
</html>
