package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\"/>\n");
      out.write("        <script src=\"js/validateInput.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>ĐĂNG NHẬP</h1>\n");
      out.write("        <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("            ");

                pageContext.setAttribute("username", session.getAttribute("username"));
                pageContext.setAttribute("password", session.getAttribute("password"));
            
      out.write("\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"username\">Tên đăng nhập:</label>\n");
      out.write("                <input type=\"text\" name=\"username\" id=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <label for=\"password\">Mật khẩu:</label>\n");
      out.write("                <input type=\"password\" name=\"password\" id=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                ");
 if(session.getAttribute("errorMsg")!= null){
      out.write("\n");
      out.write("                \n");
      out.write("                <label>");
      out.print( session.getAttribute("errorMsg"));
      out.write("</label>\n");
      out.write("                \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"line\">\n");
      out.write("                <input type=\"submit\" value=\"Đăng nhập\" required>\n");
      out.write("                <p>Nếu chưa có tài khoản hãy <a href=\"register.jsp\">Đăng ký</a></p>\n");
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
