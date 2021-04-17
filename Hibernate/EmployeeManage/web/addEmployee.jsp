<%@page import="com.javaweb.bean.Department"%>
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
        <title>Employee Add/Modify</title>
    </head>
    <body>
        <div class="container">
            <div class="p-2 row">
                <div class="col-sm-2">
                    <button class="btn btn-light" onclick="history.back()">back</button>
                </div>
                <div class="col-auto">
                    <h2>Employee Info</h2>
                </div>
            </div>
            <form class="p-2" action="EmployeeServlet" method="post">
                <input type="hidden" name="action" value="${ action }">
                <input type="hidden" name="id" value="${ employee.id }">
                <!-- department -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=department_id>Department</label> 
                    <select class="col-sm-4 form-control" name="departmentId" id=department_id>
                        <option value="">Please select department</option>
                        <%
                            List<Department> list = (List<Department>) request.getAttribute("departmentList");
                            for (int i = 0; list != null && i < list.size(); i++) {
                                Department d = list.get(i);
                                out.println("<option value=" + d.getId() + ">");
                                out.println("   " + d.getName() + " </option>");
                            }
                        %>
                    </select>
                </div>
                <script>
                    document.getElementsByName("departmentId")[0].value = '${ employee.department.id }';
                </script>
                <!-- name -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=name_id>Name</label> 
                    <input class="col-sm-4 form-control" name="name" id=name_id value="${ employee.name }">
                </div>

                <!-- sex -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=sex_id>Sex</label> 
                    <div class="radio col-sm-2">
                        <label>
                            <input type="radio" name="sex" id=sex_id ${ 'F'!=(employee.sex)?'checked':'' } value="M">Male
                        </label>
                    </div>
                    <div class="radio col-sm-2">
                        <label>
                            <input type="radio" name="sex" ${ 'F'==(employee.sex)?'checked':''} value="F">Female
                        </label>
                    </div>
                </div>

                <!-- Age -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=age_id>Age</label> 
                    <input class="col-sm-4 form-control" name="age" id=age_id value="${ employee.age }">
                </div>
                <!-- birthday -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=birthday_id>Birthday</label> 
                    <input class="col-sm-4 form-control" name="birthday" id=birthday_id value="${ employee.birthday }">
                </div>
                <!-- salary -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=salary_id>Salary</label> 
                    <input class="col-sm-4 form-control" name="salary" id=salary_id value="${ employee.salary }">
                </div>
                <!-- start -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=startTime_id>Start Time</label> 
                    <input class="col-sm-4 form-control" name="startTime" id=startTime_id value="${ employee.startTime }">
                </div>
                <!-- end -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=endTime_id>End Time</label> 
                    <input class="col-sm-4 form-control" name="endTime" id=endTime_id value="${ employee.endTime }">
                </div>
                <!-- salary -->	
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=description_id>Description</label> 
                    <textarea class="col-sm-4 form-control" name="description" id=description_id >${ employee.description }</textarea>
                </div>
                <div class="form-group p-2 row">
                    <div class="col-sm-3"></div>
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </form>
        </div>

    </body>
</html>