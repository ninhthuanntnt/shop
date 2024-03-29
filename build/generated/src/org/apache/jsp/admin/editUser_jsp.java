package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.UserModel;
import Dao.ShopDao;

public final class editUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Edit User!</h1>\n");
      out.write("        ");

            String username = request.getParameter("username");
            ShopDao dao = new ShopDao();
            UserModel user = dao.findByUsername(username);
            pageContext.setAttribute("user", user);
        
      out.write("\n");
      out.write("        <form action=\"../EditServlet\" method=\"post\">\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"fullName\">Họ và tên:</label>\n");
      out.write("                <input type=\"text\" name=\"fullname\" id=\"fullName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"address\">Địa chỉ</label>\n");
      out.write("                <input type=\"text\" name=\"address\" id=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"username\">Tên đăng nhập:</label>\n");
      out.write("                <input type=\"text\" name=\"username\" id=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" disabled>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"password\">Mật khẩu:</label>\n");
      out.write("                <input type=\"password\" name=\"password\" id=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"re_spassword\">Nhập lại mật khẩu:</label>\n");
      out.write("                <input type=\"password\" name=\"re_password\" id=\"re_password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("            ");
 if(request.getAttribute("errorMsgRes")!= null){
      out.write("\n");
      out.write("        \n");
      out.write("                <label>");
      out.print( request.getAttribute("errorMsgRes"));
      out.write("</label>\n");
      out.write("                \n");
      out.write("            ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <input type=\"submit\" value=\"Đăng ký\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
