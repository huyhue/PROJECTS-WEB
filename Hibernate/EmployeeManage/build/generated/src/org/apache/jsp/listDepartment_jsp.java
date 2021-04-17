package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.javaweb.bean.Employee;
import com.javaweb.bean.Department;
import com.javaweb.StringUtil;
import java.util.List;

public final class listDepartment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <!-- jQuery library -->\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <meta charset=\"ISO-8859-1\">\r\n");
      out.write("        <title>Department Servlet: List</title>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function addEmployee() {\r\n");
      out.write("                var url = window.location.href;\r\n");
      out.write("                url = url.replace(/\\?[^\\?]*$/, \"\");\r\n");
      out.write("                url += \"?action=add\";\r\n");
      out.write("                window.location.href = url;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $('#msg').click(function () {\r\n");
      out.write("                    $('#msg').fadeOut(\"slow\");\r\n");
      out.write("                });\r\n");
      out.write("                setTimeout(function () {\r\n");
      out.write("                    $('#msg').fadeOut(\"slow\");\r\n");
      out.write("                }, 3000);\r\n");
      out.write("\r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <!-- alert for un-deleteable department having foreign key-->\r\n");
      out.write("            ");

                String alert = (String) request.getAttribute("alert");
                if (!StringUtil.isNull(alert)) {
            
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("                alert('");
      out.print( alert);
      out.write("');\r\n");
      out.write("                window.location.href = \"DepartmentServlet\";\r\n");
      out.write("            </script>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            <!-- msg alert-top -->\r\n");
      out.write("            ");

                String message = (String) request.getAttribute("message");
                if (!StringUtil.isNull(message)) {
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div id='msg' class='alert text-center alert-success'>\r\n");
      out.write("                ");
      out.print( message);
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            <div class=\"row float-right mr-auto p-2\">\r\n");
      out.write("                <div class=clearfix>\r\n");
      out.write("                    <input class=\"btn btn-primary float-right\" type=\"button\"\r\n");
      out.write("                           value=\"Employee List\" onclick=\"window.location.href = 'EmployeeServlet'\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row float-right mr-auto p-2\">\r\n");
      out.write("                <div class=clearfix>\r\n");
      out.write("                    <input class=\"btn btn-primary float-right\" type=\"button\"\r\n");
      out.write("                           value=\"Department List\" onclick=\"window.location.href = 'DepartmentServlet'\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row float-right mr-auto p-2\">\r\n");
      out.write("                <div class=clearfix>\r\n");
      out.write("                    <input class=\"btn btn-primary float-right\" type=\"button\"\r\n");
      out.write("                           value=\"addDepartment\" onclick=\"window.location.href = 'addDepartment.jsp'\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- form for the query -->\r\n");
      out.write("            <form class=p-2 action=\"/HibernetServlet/DepartmentServlet\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <h2>Query department</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"p-2 row\">\r\n");
      out.write("                    <div class=col-md-4>\r\n");
      out.write("                        <label class=mx-1 for=\"name_in\">name</label> \r\n");
      out.write("                        <input class=\"form-control\" id=\"name_in\" name=\"departmentName\" type=\"text\">\r\n");
      out.write("                        <small id=\"nameHelp\" class=\"form-text text-muted\">You can\r\n");
      out.write("                            input part of the name of the department.</small>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=col-md-4>\r\n");
      out.write("                        <label class=mx-1 for=managerName_in>manager name</label> \r\n");
      out.write("                        <input class=form-control name=managerName id=managerName_in type=\"text\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=col-md-4>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=mx-1 for=\"employeesSize_in\">employees</label>\r\n");
      out.write("                            <div class=\"form-row\">\r\n");
      out.write("                                <div class=\"col-md-3\">\r\n");
      out.write("                                    <select class=form-control name=employeesOperator>\r\n");
      out.write("                                        <option>></option>\r\n");
      out.write("                                        <option><</option>\r\n");
      out.write("                                        <option>=</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col\">\r\n");
      out.write("                                    <select class=\"form-control\" id=employeesSize_in\r\n");
      out.write("                                            name=\"employeesSize\"></select>\r\n");
      out.write("                                    <script>\r\n");
      out.write("                                        $(function () {\r\n");
      out.write("                                            var $select = $(\"#employeesSize_in\");\r\n");
      out.write("                                            $select\r\n");
      out.write("                                                    .append($(\r\n");
      out.write("                                                            '<option selected value></option')\r\n");
      out.write("                                                            .val('').html(\r\n");
      out.write("                                                            '---select---'))\r\n");
      out.write("                                            for (i = 1; i <= 100; i++) {\r\n");
      out.write("                                                $select.append($(\r\n");
      out.write("                                                        '<option></option>').val(i)\r\n");
      out.write("                                                        .html(i))\r\n");
      out.write("                                            }\r\n");
      out.write("                                        });\r\n");
      out.write("                                    </script>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=text-center>\r\n");
      out.write("                    <input class=\"row text-center btn btn-primary mb-2\" type=\"submit\"\r\n");
      out.write("                           value=\"query\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("            <!-- table -->\r\n");
      out.write("            <table class=\"table table-striped\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    ");

                        if ("id".equals(request.getAttribute("sort"))) {
                    
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=id&order=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ order=='asc'?'desc':'asc' }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Number</a>\r\n");
      out.write("                    </th>\r\n");
      out.write("                    ");

                    } else {
                    
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=id&order=asc\">Number</a></th>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                        ");

                            if ("name".equals(request.getAttribute("sort"))) {
                        
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=name&order=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ order=='asc'?'desc':'asc' }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Name</a>\r\n");
      out.write("                    </th>\r\n");
      out.write("                    ");

                    } else {
                    
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=name&order=asc\">Name</a></th>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                        ");

                            if ("lineManager".equals(request.getAttribute("sort"))) {
                        
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=lineManager&order=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ order=='asc'?'desc':'asc' }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Manager</a>\r\n");
      out.write("                    </th>\r\n");
      out.write("                    ");

                    } else {
                    
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=lineManager&order=asc\">Manager</a></th>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    <!-- employeesSize -->\r\n");
      out.write("                    ");

                        if ("employeesSize".equals(request.getAttribute("sort"))) {
                    
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=employeesSize&order=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ order=='asc'?'desc':'asc' }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">EmloyeesSize</a>\r\n");
      out.write("                    </th>\r\n");
      out.write("                    ");

                    } else {
                    
      out.write("\r\n");
      out.write("                    <th class=\"sortable\"><a\r\n");
      out.write("                            href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ url }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("action=list&sort=employeesSize&order=asc\">EmployeesSize</a></th>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    <th>Operation</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                    List<Department> departmentList = (List<Department>) request.getAttribute("departmentList");

                    for (int i = 0; departmentList != null && i < departmentList.size(); i++) {
                        Department d = departmentList.get(i);
                        Employee lineManager = d.getLineManager();
                        out.println("<tr>");
                        out.println("  <td>" + d.getId() + "</td>");
                        out.println("  <td>" + d.getName() + "</td>");
                        out.println("  <td>" + (lineManager == null ? "" : lineManager.getName()) + "</td>");
                        out.println("  <td>" + d.getEmployees().size());
                        if (d.getEmployees().size() > 0) {
                            out.println("( ");
                            for (Employee ee : d.getEmployees()) {
                                out.println(ee.getName() + " ");
                            }
                            out.println(")");
                        }
                        out.println("</td>");
                        out.println("  <td><a class='btn btn-outline-info btn-sm' href=DepartmentServlet?action=edit&id=" + d.getId() + ">Modify</a>");
                        out.println("  <a class='btn btn-outline-danger btn-sm' onclick=\"return confirm('sure to delete department &QUOT;" + d.getName() + "&QUOT;?')\" href=DepartmentServlet?action=delete&id="
                                + d.getId() + ">delete</a></td>");
                        out.println("</tr>");
                    }
                
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
