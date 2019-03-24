<%-- 
    Document   : addteacher
    Created on : Jan 4, 2019, 6:37:32 PM
    Author     : Siron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>

    <%@include file="title.jsp" %>
    <!--this is static or compile time include -->
    
    <jsp:include page="title.jsp"/>
    <!--dynamic include includes this file by translating everytime the response is being created-->

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/admin/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/admin/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
       <%@include file="header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Add new teacher information</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row">
                <!-- add course information form-->
                <div class="row">
                                <div class="col-lg-9">
                                    <form role="form" action="${pageContext.request.contextPath}/admin/teacher/add" method="post">
                                        <div class="form-group">
                                            <label>Subject</label>
                                            <input class="form-control" name="tsubject" type="text" placeholder="Enter subject here" required>
                                            <p class="help-block">Enter subject in block letters.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input class="form-control" type="text" name="tname" placeholder="Enter name here" required>
                                        </div>
                                         <div class="form-group">
                                            <label>Salary</label>
                                            <input class="form-control" type="text" name="tsalary" placeholder="Enter salaray  here" required>
                                        </div>
                                        
                                      
                       
                                        
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
            </div>
            
           
           
                    
                   
                        <!-- /.panel-body -->
                       
                        <!-- /.panel-footer -->
              
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    <%@include file="footer.jsp" %>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/admin/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/dist/js/sb-admin-2.js"></script>

</body>

</html>


