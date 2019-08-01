package org.apache.jsp.WEB_002dINF.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Model.UserModel;
import Dao.ShopDao;

public final class listAll_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>List all user</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>List all user</h1>\n");
      out.write("        <div>\n");
      out.write("            ");

                if(session.getAttribute("usernameAdmin") == null){
                    response.sendRedirect("../login.jsp");
                }
            
      out.write("\n");
      out.write("            <p>User: ");
      out.print( session.getAttribute("usernameAdmin") );
      out.write(" <a href=\"LogoutServlet\">Logout</a></p>\n");
      out.write("        </div>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Họ và tên</th>\n");
      out.write("                <th>Địa chỉ</th>\n");
      out.write("                <th>Tên đăng nhập</th>\n");
      out.write("                <th>Mật khẩu</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ShopDao dao = new ShopDao();
                List<UserModel> list = dao.findAll();
                if(list != null)
                    for(UserModel user : list){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(user.getId());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(user.getFullname());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(user.getAddress());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(user.getUsername());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(user.getPassword());
      out.write("</td>\n");
      out.write("                <td><a href=\"\">Edit</a></td>\n");
      out.write("                <td><a href=\"\">Delete</a></td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"5\">No data</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>\n");
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
