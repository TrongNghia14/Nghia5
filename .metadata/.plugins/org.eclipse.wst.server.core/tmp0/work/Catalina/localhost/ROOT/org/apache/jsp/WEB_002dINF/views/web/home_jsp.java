/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-01-21 13:09:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Home Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- Page Content -->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Heading Row -->\r\n");
      out.write("\t\t<div class=\"row align-items-center my-5\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-7\">\r\n");
      out.write("\t\t\t\t<img class=\"img-fluid rounded mb-4 mb-lg-0\"\r\n");
      out.write("\t\t\t\t\tsrc=\"http://placehold.it/900x400\" alt=\"\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.col-lg-8 -->\r\n");
      out.write("\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("\t\t\t\t<h1 class=\"font-weight-light\">Business Name or Tagline</h1>\r\n");
      out.write("\t\t\t\t<p>This is a template that is great for small businesses. It\r\n");
      out.write("\t\t\t\t\tdoesn't have too much fancy flare to it, but it makes a great use\r\n");
      out.write("\t\t\t\t\tof the standard Bootstrap core components. Feel free to use this\r\n");
      out.write("\t\t\t\t\ttemplate for any project you want!</p>\r\n");
      out.write("\t\t\t\t<a class=\"btn btn-primary\" href=\"#\">Call to Action!</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.col-md-4 -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Call to Action Well -->\r\n");
      out.write("\t\t<div class=\"card text-white bg-secondary my-5 py-4 text-center\">\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<p class=\"text-white m-0\">This call to action card is a great\r\n");
      out.write("\t\t\t\t\tplace to showcase some important information or display a clever\r\n");
      out.write("\t\t\t\t\ttagline!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Content Row -->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-md-4 mb-5\">\r\n");
      out.write("\t\t\t\t<div class=\"card h-100\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<h2 class=\"card-title\">Card One</h2>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("\t\t\t\t\t\t\tadipisicing elit. Rem magni quas ex numquam, maxime minus quam\r\n");
      out.write("\t\t\t\t\t\t\tmolestias corporis quod, ea minima accusamus.</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-footer\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-primary btn-sm\">More Info</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.col-md-4 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-4 mb-5\">\r\n");
      out.write("\t\t\t\t<div class=\"card h-100\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<h2 class=\"card-title\">Card Two</h2>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("\t\t\t\t\t\t\tadipisicing elit. Quod tenetur ex natus at dolorem enim! Nesciunt\r\n");
      out.write("\t\t\t\t\t\t\tpariatur voluptatem sunt quam eaque, vel, non in id dolore\r\n");
      out.write("\t\t\t\t\t\t\tvoluptates quos eligendi labore.</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-footer\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-primary btn-sm\">More Info</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.col-md-4 -->\r\n");
      out.write("\t\t\t<div class=\"col-md-4 mb-5\">\r\n");
      out.write("\t\t\t\t<div class=\"card h-100\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<h2 class=\"card-title\">Card Three</h2>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur\r\n");
      out.write("\t\t\t\t\t\t\tadipisicing elit. Rem magni quas ex numquam, maxime minus quam\r\n");
      out.write("\t\t\t\t\t\t\tmolestias corporis quod, ea minima accusamus.</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-footer\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"btn btn-primary btn-sm\">More Info</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.col-md-4 -->\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- /.container -->\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}