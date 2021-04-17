package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addDepartment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <!-- jQuery library -->\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <meta charset=\"ISO-8859-1\">\r\n");
      out.write("        <title>Department Add/Modify</title>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            function toLeft() {\r\n");
      out.write("                var lineManagerList = document.getElementsByName('lineManagerList')[0];\r\n");
      out.write("                var lineManagerId = document.getElementsByName('lineManagerId')[0];\r\n");
      out.write("                if (lineManagerId.selectedIndex < 0) {\r\n");
      out.write("                    alert('Please select one option from the left');\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                lineManagerId.options.remove(lineManagerId.options.selectedIndex);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function toRight() {\r\n");
      out.write("                var lineManagerList = document.getElementsByName('lineManagerList')[0];\r\n");
      out.write("                var lineManagerId = document.getElementsByName('lineManagerId')[0];\r\n");
      out.write("                if (lineManagerList.selectedIndex < 0) {\r\n");
      out.write("                    alert('Please select one Employee from the left');\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                var value = lineManagerList.options[lineManagerList.selectedIndex].value;\r\n");
      out.write("                var text = lineManagerList.options[lineManagerList.selectedIndex].text;\r\n");
      out.write("                if (value == \"\" || value == \"0\") {\r\n");
      out.write("                    alert('Please select one Employee from the left');\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                // go through the Left part to find the Manager; if exists, we highlight the manager and return\r\n");
      out.write("                for (var i = 0; i < lineManagerId.options.length; i++) {\r\n");
      out.write("                    var option = lineManagerId.options[i];\r\n");
      out.write("                    if (option.value == value) {\r\n");
      out.write("                        lineManagerId.selectedIndex = i;\r\n");
      out.write("                        return;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                lineManagerId.options.length = 0; // else, we clear the Left: only one Manager for the dpmt\r\n");
      out.write("                var option = new Option(text, value); // add a new Option to the left\r\n");
      out.write("                lineManagerId.options.add(option);\r\n");
      out.write("                lineManagerId.selectedIndex = lineManagerId.options.length - 1; // highlight the selected to the Left\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function whetherEnter() {\r\n");
      out.write("                try {\r\n");
      out.write("                    if (event.keyCode == 13) {\r\n");
      out.write("                        query();\r\n");
      out.write("                        return false;\r\n");
      out.write("                    }\r\n");
      out.write("                } catch (error) {\r\n");
      out.write("                    alert('error:' + error + '. Please click to know more.');\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("                return true;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function query() {\r\n");
      out.write("                var key = $('#key')[0].value;\r\n");
      out.write("                var lineManagerList = $('select[name=lineManagerList]')[0];\r\n");
      out.write("                $.post(\"DepartmentServlet\", {\r\n");
      out.write("                    action: \"query\",\r\n");
      out.write("                    key: key\r\n");
      out.write("                }, function (data, textStatus) {\r\n");
      out.write("                    if (textStatus != 'success') {\r\n");
      out.write("                        alert('Error occurred:' + textStatus + ', data:' + data);\r\n");
      out.write("                        return;\r\n");
      out.write("                    }\r\n");
      out.write("                    lineManagerList.options.length = 0;\r\n");
      out.write("                    for (var i in data) {\r\n");
      out.write("                        lineManagerList.options.add(new Option(data[i], i));\r\n");
      out.write("                    }\r\n");
      out.write("                }, \"json\");\r\n");
      out.write("                /*\r\n");
      out.write("                 $.ajax({\r\n");
      out.write("                 type : 'post',\r\n");
      out.write("                 url : 'DepartmentServlet',\r\n");
      out.write("                 data : {\r\n");
      out.write("                 action : \"query\",\r\n");
      out.write("                 key : key\r\n");
      out.write("                 },\r\n");
      out.write("                 async : false,\r\n");
      out.write("                 dataType : \"json\",\r\n");
      out.write("                 success : function(data) {\r\n");
      out.write("                 lineManagerList.options.length = 0;\r\n");
      out.write("                 for ( var i in data) {\r\n");
      out.write("                 lineManagerList.options.add(new Option(data[i], i));\r\n");
      out.write("                 }\r\n");
      out.write("                 },\r\n");
      out.write("                 error : function(XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("                 alert(\"error\");\r\n");
      out.write("                 }\r\n");
      out.write("                 });\r\n");
      out.write("                 */\r\n");
      out.write("            }\r\n");
      out.write("            // .click() is deprecated in JQuery3\r\n");
      out.write("            // Solution: Instead of .click(fn) use .on(\"click\", fn). Instead of .click() use .trigger(\"click\").\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("                $(\"button[name='btnQuery']\").on(\"click\", function () {\r\n");
      out.write("                    query();\r\n");
      out.write("                });\r\n");
      out.write("                $(\"input[name=key]\").keypress(function () {\r\n");
      out.write("                    return whetherEnter();\r\n");
      out.write("                });\r\n");
      out.write("                $('button[name=btnToRight]').click(function () {\r\n");
      out.write("                    toRight();\r\n");
      out.write("                });\r\n");
      out.write("                $('button[name=btnToLeft]').click(function () {\r\n");
      out.write("                    toLeft();\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                // not working\r\n");
      out.write("                $('select[name=lineManagerList]').on(\"dbclick\", function () {\r\n");
      out.write("                    toRight()\r\n");
      out.write("                });\r\n");
      out.write("                $('select[name=lineManagerId]').on(\"dbclick\", function () {\r\n");
      out.write("                    toLeft()\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"p-2 row\">\r\n");
      out.write("                <div class=\"col-sm-2\">\r\n");
      out.write("                    <button class=\"btn btn-light\" onclick=\"history.back()\">back</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-auto\">\r\n");
      out.write("                    <h2>Add department</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <form class=p-2 action=\"DepartmentServlet\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"add\"> \r\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                <div class=\"form-group p-2 row\">\r\n");
      out.write("                    <label class=\"col-sm-2 col-form-label\" for=name_id>Name</label> \r\n");
      out.write("                    <input class=\"col-sm-4 form-control\" id=name_id name=name type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ department.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group p-2 row\">\r\n");
      out.write("                    <label class=\"col-sm-2 col-form-label\" for=key>Manager</label>\r\n");
      out.write("                    <div class=\"col-sm-4 input-group\" style=\"margin: 0px; padding: 0px;\">\r\n");
      out.write("                        <input class=\"form-control\" id=\"key\" name=\"key\" type=\"text\" placeholder=\"input name to query\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ department.lineManager.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \r\n");
      out.write("                        <span class=\"input-group-btn\" style=\"margin-left: 20px;\">\r\n");
      out.write("                            <button class=\"btn btn-outline-primary\" name=\"btnQuery\" id=\"btnQuery\" type=\"button\">Search</button>\r\n");
      out.write("                        </span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group row offset-sm-2\" style=\"padding-left: 0px;\">\r\n");
      out.write("                    <div class=\"col-sm-2\" style=\"margin-left: 0px; padding-left: 0px;\">\r\n");
      out.write("                        <select multiple class=form-control name=\"lineManagerList\"></select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"text-center col-sm-1\">\r\n");
      out.write("                        <button class=\"btn btn-light\" type=button name=btnToRight>&gt;&gt;</button>\r\n");
      out.write("                        <br> <br>\r\n");
      out.write("                        <button class=\"btn btn-light\" type=button name=btnToLeft>&lt;&lt;</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-2\">\r\n");
      out.write("                        <select multiple class=form-control name=\"lineManagerId\"></select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group p-2 row\">\r\n");
      out.write("                    <label class=\"col-sm-2 col-form-label\" for=employees_id>Employees</label> \r\n");
      out.write("                    <button class=\"btn btn-outline-primary col-auto\" type=\"button\" id=employees_id onclick=\"window.location.href = 'EmployeeServlet';\">Employee List</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group p-2 row mt-4\">\r\n");
      out.write("                    <label class=\"col-sm-2 col-form-label\" for=description_id>Description</label>\r\n");
      out.write("                    <textarea class=\"col-sm-4 form-control\" name=description id=description_id rows=4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ department.description }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group p-2 row offset-sm-3\">\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
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
