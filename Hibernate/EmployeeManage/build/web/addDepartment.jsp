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
        <title>Department Add/Modify</title>
        <script type="text/javascript">
            function toLeft() {
                var lineManagerList = document.getElementsByName('lineManagerList')[0];
                var lineManagerId = document.getElementsByName('lineManagerId')[0];
                if (lineManagerId.selectedIndex < 0) {
                    alert('Please select one option from the left');
                    return;
                }
                lineManagerId.options.remove(lineManagerId.options.selectedIndex);
            }

            function toRight() {
                var lineManagerList = document.getElementsByName('lineManagerList')[0];
                var lineManagerId = document.getElementsByName('lineManagerId')[0];
                if (lineManagerList.selectedIndex < 0) {
                    alert('Please select one Employee from the left');
                    return;
                }
                var value = lineManagerList.options[lineManagerList.selectedIndex].value;
                var text = lineManagerList.options[lineManagerList.selectedIndex].text;
                if (value == "" || value == "0") {
                    alert('Please select one Employee from the left');
                    return;
                }
                // go through the Left part to find the Manager; if exists, we highlight the manager and return
                for (var i = 0; i < lineManagerId.options.length; i++) {
                    var option = lineManagerId.options[i];
                    if (option.value == value) {
                        lineManagerId.selectedIndex = i;
                        return;
                    }
                }
                lineManagerId.options.length = 0; // else, we clear the Left: only one Manager for the dpmt
                var option = new Option(text, value); // add a new Option to the left
                lineManagerId.options.add(option);
                lineManagerId.selectedIndex = lineManagerId.options.length - 1; // highlight the selected to the Left
            }

            function whetherEnter() {
                try {
                    if (event.keyCode == 13) {
                        query();
                        return false;
                    }
                } catch (error) {
                    alert('error:' + error + '. Please click to know more.');
                    return false;
                }
                return true;
            }

            function query() {
                var key = $('#key')[0].value;
                var lineManagerList = $('select[name=lineManagerList]')[0];
                $.post("DepartmentServlet", {
                    action: "query",
                    key: key
                }, function (data, textStatus) {
                    if (textStatus != 'success') {
                        alert('Error occurred:' + textStatus + ', data:' + data);
                        return;
                    }
                    lineManagerList.options.length = 0;
                    for (var i in data) {
                        lineManagerList.options.add(new Option(data[i], i));
                    }
                }, "json");
                /*
                 $.ajax({
                 type : 'post',
                 url : 'DepartmentServlet',
                 data : {
                 action : "query",
                 key : key
                 },
                 async : false,
                 dataType : "json",
                 success : function(data) {
                 lineManagerList.options.length = 0;
                 for ( var i in data) {
                 lineManagerList.options.add(new Option(data[i], i));
                 }
                 },
                 error : function(XMLHttpRequest, textStatus, errorThrown) {
                 alert("error");
                 }
                 });
                 */
            }
            // .click() is deprecated in JQuery3
            // Solution: Instead of .click(fn) use .on("click", fn). Instead of .click() use .trigger("click").
            $(document).ready(function () {
                $("button[name='btnQuery']").on("click", function () {
                    query();
                });
                $("input[name=key]").keypress(function () {
                    return whetherEnter();
                });
                $('button[name=btnToRight]').click(function () {
                    toRight();
                });
                $('button[name=btnToLeft]').click(function () {
                    toLeft();
                });

                // not working
                $('select[name=lineManagerList]').on("dbclick", function () {
                    toRight()
                });
                $('select[name=lineManagerId]').on("dbclick", function () {
                    toLeft()
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="p-2 row">
                <div class="col-sm-2">
                    <button class="btn btn-light" onclick="history.back()">back</button>
                </div>
                <div class="col-auto">
                    <h2>Add department</h2>
                </div>
            </div>
            <form class=p-2 action="DepartmentServlet" method="post">
                <input type="hidden" name="action" value="add"> 
                <input type="hidden" name="id" value="${ id }">
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=name_id>Name</label> 
                    <input class="col-sm-4 form-control" id=name_id name=name type="text" value="${ department.name }">
                </div>
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=key>Manager</label>
                    <div class="col-sm-4 input-group" style="margin: 0px; padding: 0px;">
                        <input class="form-control" id="key" name="key" type="text" placeholder="input name to query" value="${ department.lineManager.name }"> 
                        <span class="input-group-btn" style="margin-left: 20px;">
                            <button class="btn btn-outline-primary" name="btnQuery" id="btnQuery" type="button">Search</button>
                        </span>
                    </div>
                </div>
                <div class="form-group row offset-sm-2" style="padding-left: 0px;">
                    <div class="col-sm-2" style="margin-left: 0px; padding-left: 0px;">
                        <select multiple class=form-control name="lineManagerList"></select>
                    </div>
                    <div class="text-center col-sm-1">
                        <button class="btn btn-light" type=button name=btnToRight>&gt;&gt;</button>
                        <br> <br>
                        <button class="btn btn-light" type=button name=btnToLeft>&lt;&lt;</button>
                    </div>
                    <div class="col-sm-2">
                        <select multiple class=form-control name="lineManagerId"></select>
                    </div>
                </div>
                <div class="form-group p-2 row">
                    <label class="col-sm-2 col-form-label" for=employees_id>Employees</label> 
                    <button class="btn btn-outline-primary col-auto" type="button" id=employees_id onclick="window.location.href = 'EmployeeServlet';">Employee List</button>
                </div>
                <div class="form-group p-2 row mt-4">
                    <label class="col-sm-2 col-form-label" for=description_id>Description</label>
                    <textarea class="col-sm-4 form-control" name=description id=description_id rows=4>${ department.description }</textarea>
                </div>
                <div class="form-group p-2 row offset-sm-3">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </body>
</html>