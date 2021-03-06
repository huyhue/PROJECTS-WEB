<%@page import="com.javaweb.bean.Employee"%>
<%@page import="com.javaweb.bean.Department"%>
<%@page import="com.javaweb.StringUtil"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <!-- jQuery library -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <meta charset="ISO-8859-1">
        <title>Department Servlet: List</title>
        <script type="text/javascript">
            function addEmployee() {
                var url = window.location.href;
                url = url.replace(/\?[^\?]*$/, "");
                url += "?action=add";
                window.location.href = url;
            }
            $(document).ready(function () {
                $('#msg').click(function () {
                    $('#msg').fadeOut("slow");
                });
                setTimeout(function () {
                    $('#msg').fadeOut("slow");
                }, 3000);
            })
        </script>
    </head>
    <body>
        <div class="container">
            <!-- alert for un-deleteable department having foreign key-->
            <%
                String alert = (String) request.getAttribute("alert");
                if (!StringUtil.isNull(alert)) {
            %>
            <script type="text/javascript">
                alert('<%= alert%>');
                window.location.href = "DepartmentServlet";
            </script>
            <% } %>
            <!-- msg alert-top -->
            <%
                String message = (String) request.getAttribute("message");
                if (!StringUtil.isNull(message)) {
            %>
            <div id='msg' class='alert text-center alert-success'>
                <%= message%>
            </div>
            <% } %>
            <div class="row float-right mr-auto p-2">
                <div class=clearfix>
                    <input class="btn btn-primary float-right" type="button" value="Employee List" onclick="window.location.href = 'EmployeeServlet'">
                </div>
            </div>
            <div class="row float-right mr-auto p-2">
                <div class=clearfix>
                    <input class="btn btn-primary float-right" type="button" value="Department List" onclick="window.location.href = 'DepartmentServlet'">
                </div>
            </div>
            <div class="row float-right mr-auto p-2">
                <div class=clearfix>
                    <input class="btn btn-primary float-right" type="button" value="addDepartment" onclick="window.location.href = 'addDepartment.jsp'">
                </div>
            </div>
            <!-- form for the query -->
            <form class=p-2 action="/EmployeeManage/DepartmentServlet">
                <div>
                    <h2>Query department</h2>
                </div>
                <div class="p-2 row">
                    <div class=col-md-4>
                        <label class=mx-1 for="name_in">name</label> 
                        <input class="form-control" id="name_in" name="departmentName" type="text">
                        <small id="nameHelp" class="form-text text-muted">You can input part of the name of the department.</small>
                    </div>
                    <div class=col-md-4>
                        <label class=mx-1 for=managerName_in>manager name</label> 
                        <input class=form-control name=managerName id=managerName_in type="text">
                    </div>
                    <div class=col-md-4>
                        <div class="form-group">
                            <label class=mx-1 for="employeesSize_in">employees</label>
                            <div class="form-row">
                                <div class="col-md-3">
                                    <select class=form-control name=employeesOperator>
                                        <option>></option>
                                        <option><</option>
                                        <option>=</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <select class="form-control" id=employeesSize_in
                                            name="employeesSize"></select>
                                    <script>
                                        $(function () {
                                            var $select = $("#employeesSize_in");
                                            $select.append($('<option selected value></option').val('').html('---select---'))
                                            for (i = 1; i <= 100; i++) {
                                                $select.append($('<option></option>').val(i).html(i))
                                            }
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=text-center>
                    <input class="row text-center btn btn-primary mb-2" type="submit" value="query">
                </div>
            </form>
            <!-- table -->
            <table class="table table-striped">
                <tr>
                    <%
                        if ("id".equals(request.getAttribute("sort"))) {
                    %>
                    <th class="sortable"><a href="${ url }action=list&sort=id&order=${ order=='asc'?'desc':'asc' }">Number</a>
                    </th>
                    <%
                    } else {
                    %>
                    <th class="sortable"><a href="${ url }action=list&sort=id&order=asc">Number</a></th>
                        <%
                            }
                        %>
                        <%
                            if ("name".equals(request.getAttribute("sort"))) {
                        %>
                    <th class="sortable"><a href="${ url }action=list&sort=name&order=${ order=='asc'?'desc':'asc' }">Name</a>
                    </th>
                    <%
                    } else {
                    %>
                    <th class="sortable"><a href="${ url }action=list&sort=name&order=asc">Name</a></th>
                        <%
                            }
                        %>
                        <% if ("lineManager".equals(request.getAttribute("sort"))) {
                        %>
                    <th class="sortable"><a href="${ url }action=list&sort=lineManager&order=${ order=='asc'?'desc':'asc' }">Manager</a>
                    </th>
                    <%
                    } else {
                    %>
                    <th class="sortable"><a href="${ url }action=list&sort=lineManager&order=asc">Manager</a></th>
                        <%
                            }
                        %>
                    <!-- employeesSize -->
                    <%
                        if ("employeesSize".equals(request.getAttribute("sort"))) {
                    %>
                    <th class="sortable"><a href="${ url }action=list&sort=employeesSize&order=${ order=='asc'?'desc':'asc' }">EmloyeesSize</a>
                    </th>
                    <%
                    } else {
                    %>
                    <th class="sortable"><a href="${ url }action=list&sort=employeesSize&order=asc">EmployeesSize</a></th>
                        <%
                            }
                        %>
                    <th>Operation</th>
                </tr>
                <%
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
                                out.println(ee.getName() + ", ");
                            }
                            out.println(")");
                        }
                        out.println("</td>");
                        out.println("  <td><a class='btn btn-outline-info btn-sm' href=DepartmentServlet?action=edit&id=" + d.getId() + ">Modify</a>");
                        out.println("  <a class='btn btn-outline-danger btn-sm' onclick=\"return confirm('sure to delete department &QUOT;" + d.getName() + "&QUOT;?')\" href=DepartmentServlet?action=delete&id="
                                + d.getId() + ">Delete</a></td>");
                        out.println("</tr>");
                    }
                %>
            </table>
        </div>
    </body>
</html>