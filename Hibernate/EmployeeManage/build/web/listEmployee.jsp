<%@page import="com.javaweb.bean.Employee"%>
<%@page import="com.javaweb.StringUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <!-- jQuery library -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <meta charset="ISO-8859-1">
        <title>Employee Servlet: List</title>
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
        <div class=container>
            <!--  alert for 'employee saved'-->
            <%
                String alert = (String) request.getAttribute("alert");
                if (!StringUtil.isNull(alert)) {
            %>
            <script type="text/javascript">
                alert("<%= alert%>");
                window.location.href = "EmployeeServlet";
            </script>
            <% } %>
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
                    <input class="btn btn-primary float-right" type="button"
                           value="Employee List" onclick="window.location.href = 'EmployeeServlet'">
                </div>
            </div>
            <div class="row float-right mr-auto p-2">
                <div class=clearfix>
                    <input class="btn btn-primary float-right" type="button"
                           value="Department List" onclick="window.location.href = 'DepartmentServlet'">
                </div>
            </div>
            <div class="row float-right mr-auto p-2">
                <div class=clearfix>
                    <input class="btn btn-warning float-right" type="button"
                           value="Add Employee (randomly)" onclick="addEmployee()">
                </div>
            </div>
            <form class=p-2 action="/EmployeeManage/EmployeeServlet">
                <div>
                    <h2>Query employee</h2>
                </div>
                <div class="p-2 row">
                    <div class=col-md-4>
                        <label class=mx-1 for="name_in">Name</label> <input
                            class="form-control" id="name_in" name="name" type="text">
                        <small id="nameHelp" class="form-text text-muted">You can
                            input part of the name of the employee.</small>
                    </div>
                    <div class=col-md-4>
                        <label class=mx-1 for="sex_in">Sex</label> <select
                            class="form-control" id=sex_in name="sex">
                            <option selected value>---Select---</option>
                            <option value="M">M</option>
                            <option value="F">F</option>
                        </select>
                    </div>
                    <div class=col-md-4>
                        <div class="form-group">
                            <label class=mx-1 for="age_in">Age</label>
                            <div class="form-row">
                                <div class="col-md-3">
                                    <select class=form-control name=ageOperate>
                                        <option>></option>
                                        <option><</option>
                                        <option>=</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <select class="form-control" id=age_in name="age"></select>
                                    <script>
                                        $(function () {
                                            var $select = $("#age_in");
                                            $select.append($('<option selected value></option').val('').html('---Select---'))
                                            for (i = 18; i <= 65; i++) {
                                                $select.append($('<option></option>').val(i).html(i))
                                            }
                                        });
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="p-2 row">
                    <div class=col-md-4>
                        <label class=mx-1 for=birthday_in>Birthday</label> <input
                            class=form-control name=birthday id=birthday_in type="date">
                    </div>
                    <!-- Time is Not Finished -->
                    <div class=col-md-4>
                        <label class=mx-1 for=time_in>Time</label> <input
                            class=form-control name=time id=time_in type="time">
                    </div>
                    <div class=col-md-4>
                        <label class=mx-1 for=salary_in>Salary</label>
                        <div class=form-row>
                            <div class=col-md-3>
                                <select class="form-control" name=salaryOperate>
                                    <option>></option>
                                    <option><</option>
                                    <option>=</option>
                                </select> 
                            </div>
                            <div class=col>
                                <input name=salary class="form-control" id=salary_in type="text">
                            </div>
                        </div>
                    </div>
                </div>
                <div class=text-center>
                    <input class="row text-center btn btn-primary mb-2" type="submit" value="query">
                </div>
            </form>
            <div class="p-2 mx-auto">
                <table class="table table-striped table-hover">
                    <tr>
                        <!-- id -->
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
                        <!-- name -->
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
                        <!-- sex -->
                        <%
                            if ("sex".equals(request.getAttribute("sort"))) {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=sex&order=${ order=='asc'?'desc':'asc' }">Sex</a>
                        </th>
                        <%
                        } else {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=sex&order=asc">Sex</a></th>
                            <%
                                }
                            %>
                        <!-- Age -->
                        <%
                            if ("age".equals(request.getAttribute("sort"))) {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=age&order=${ order=='asc'?'desc':'asc' }">Age</a>
                        </th>
                        <%
                        } else {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=age&order=asc">Age</a></th>
                            <%
                                }
                            %>
                        <!-- birthday -->
                        <%
                            if ("birthday".equals(request.getAttribute("sort"))) {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=birthday&order=${ order=='asc'?'desc':'asc' }">Birthday</a>
                        </th>
                        <%
                        } else {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=birthday&order=asc">Birthday</a></th>
                            <%
                                }
                            %>
                        <!-- salary -->
                        <%
                            if ("salary".equals(request.getAttribute("sort"))) {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=salary&order=${ order=='asc'?'desc':'asc' }">Salary</a>
                        </th>
                        <%
                        } else {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=salary&order=asc">Salary</a></th>
                            <%
                                }
                            %>
                        <!-- start -->
                        <%
                            if ("startTime".equals(request.getAttribute("sort"))) {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=startTime&order=${ order=='asc'?'desc':'asc' }">Start Time</a></th>
                            <%
                            } else {
                            %>
                        <th class="sortable"><a href="${ url }action=list&sort=startTime&order=asc">Start Time</a></th>
                            <%
                                }
                            %>
                        <!-- end -->
                        <%
                            if ("endTime".equals(request.getAttribute("sort"))) {
                        %>
                        <th class="sortable"><a href="${ url }action=list&sort=endTime&order=${ order=='asc'?'desc':'asc' }">End Time</a></th>
                            <%
                            } else {
                            %>
                        <th class="sortable"><a href="${ url }action=list&sort=endTime&order=asc">End Time</a></th>
                            <%
                                }
                            %>
                        <!-- operation -->
                        <%-- <%
                                             if ("disabled".equals(request.getAttribute("sort"))) {
                                     %>
                                     <th class="sortable"><a
                                             href="${ url }action=list&sort=disabled&order=${ order=='asc'?'desc':'asc' }">Operation</a>
                                     </th>
                                     <%
                                             } else {
                                     %>
                                     <th class="sortable"><a
                                             href="${ url }action=list&sort=disabled&order=asc">Operation</a></th>
                                     <%
                                             }
                                     %> --%>
                        <th>Operation</th>
                    </tr>
                    <%
                        List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
                        System.out.println("Size web list: " + employeeList.size());
                        NumberFormat salary = new DecimalFormat("0.00");
                        for (int i = 0; employeeList != null && i < employeeList.size(); i++) {
                            Employee e = employeeList.get(i);
                            System.out.println("element: " + e.getName() + e.getId());
                            out.println("<tr>");
                            out.println("  <td>" + e.getId() + "</td>");
                            out.println("  <td>" + e.getName() + "</td>");
                            out.println("  <td>" + e.getSex() + "</td>");
                            out.println("  <td>" + e.getAge() + "</td>");
                            out.println("  <td>" + e.getBirthday() + "</td>");
                            out.println("  <td>$" + e.getSalary() + "</td>");
//                            out.println("  <td>$" + salary.format(e.getSalary()) + "</td>");
                            out.println("  <td>" + e.getStartTime() + "</td>");
                            out.println("  <td>" + e.getEndTime() + "</td>");

                            // out.println("  <td>" + (e.isDisabled() ? "Stopped" : "Normal") + "</td>");
                            out.println("  <td><a class='btn btn-outline-info btn-sm' href=EmployeeServlet?action=edit&id=" + e.getId() + ">Modify</a>");
                            out.println("  <a class='btn btn-outline-danger btn-sm' onclick=\"return confirm('sure to delete employee " + e.getName() + "?')\" href=EmployeeServlet?action=delete&id=" + e.getId() + ">delete</a></td>");
                            out.println("</tr>");
                        }
                    %>
                </table>
            </div>
        </div>
    </body>
</html>