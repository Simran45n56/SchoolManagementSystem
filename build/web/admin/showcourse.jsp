<%-- 
    Document   : addcourse
    Created on : Dec 10, 2018, 1:13:49 PM
    Author     : Siron
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     <!-- DataTables CSS -->
    <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

  

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
       <%@include file="header.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Display course information </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row">
                <!-- add course information form-->
               
                    <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="course_table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Title</th>
                                        <th>Duration</th>
                                        <th>Price</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${courselist}" var="c">
                                    <tr>
                                        <td> ${c.id}</td>
                                        <td>${c.title}</td>
                                         <td>${c.duration}</td>
                                         <td>${c.price}</td>
                                         <td><a href="${pageContext.request.contextPath}/admin/course/edit?id=${c.id}">Edit </a></td>
                                          <td><a href="${pageContext.request.contextPath}/admin/course/delete?id=${c.id}">Delete </a></td>
                                        
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                          
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
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
    
      <!-- DataTables Responsive CSS -->
    <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
     <script src="${pageContext.request.contextPath}/admin/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/dist/js/sb-admin-2.js"></script>
      <script>
    $(document).ready(function() {
        $('#course_table').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>

