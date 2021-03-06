<%@page import="com.javaweb.bean.Employee"%>
<%@page import="com.javaweb.bean.Department"%>
<%@page import="com.javaweb.bean.HibernateUtil"%>
<%@page import="com.javaweb.StringUtil"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <!-- jQuery library -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <%
            String hql = request.getParameter("hql");
            String message = "";
            String table = "";
            Session hibernateSession = null;

            if (!StringUtil.isNull(hql)) {
                try {
                    hibernateSession = HibernateUtil.getSessionFactory().openSession();
                    List list = hibernateSession.createQuery(hql).list();

                    table = "<table class='table table-striped'>";
                    table += "<tr'>";
                    table += "<th>Department Name</th>";
                    table += "<th>Employee Name</th>";
                    table += "</tr>";

                    for (int i = 0; i < list.size(); i++) {
                        Object obj = list.get(i);
                        Department department = (Department) ((Object[]) obj)[0];
                        Employee employee = (Employee) ((Object[]) obj)[1];

                        String departmentName = department == null ? "null" : department.getName();
                        String employeeName = employee == null ? "null" : employee.getName();
                        table += "<tr>";
                        table += "<td>" + departmentName + "</td>";
                        table += "<td>" + employeeName + "</td>";
                        table += "</tr>";
                    }
                    table += "</table>";
                } catch (Exception e) {
                    message = "Error occurred:" + e.getMessage();
                } finally {
                    if (hibernateSession != null) {
                        hibernateSession.close();
                    }
                }
            }
        %>
        <meta charset="ISO-8859-1">
        <title>HQL JOIN</title>
    </head>
    <body>
        <div class=" container list">
            <div align="float-right">
                <input type="button" class="btn btn-primary button" value=" inner join " onclick="location = '${ pageContext.request.requestURI }?hql=select d,e from Department d inner join d.employees e'">
                <input type="button" class="btn btn-primary button" value=" left join " onclick="location = '${ pageContext.request.requestURI }?hql=select d,e from Department d left join d.employees e'">
                <input type="button" class="btn btn-primary button" value=" right join " onclick="location = '${ pageContext.request.requestURI }?hql=select d,e from Department d right join d.employees e'">
            </div>
            <%
                if (!StringUtil.isNull(message)) {
                    out.println("<div class='alert message'>" + message + "</div>");
                }
            %>
            <form class="p-2" action="${ pageContext.request.requestURI }" method="get">
                <div class="p-2">
                    <h2>Please input HQL</h2>
                </div>
                <textarea class="p-2 form-control" name="hql">${ param.hql }</textarea>
                <div class="" align="center">
                    <input type="submit" class="button btn btn-success" value="Query">
                </div>
            </form>
            <%= table%>
        </div>

    </body>
</html>