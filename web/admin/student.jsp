<%-- 
    Document   : addcourse
    Created on : Dec 10, 2018, 1:13:49 PM
    Author     : Siron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <div id="page-wrapper" style="visibility: visible;">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Student Management</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
                <!-- add course information form-->
                <div class="row">
                                <div class="col-lg-9">
                                    <div> Form submitted: ${success}</div>
                                    <form role="form" action="<c:url value="/admin/student/add"/>" method="post">
                                         <!--adding new student or updating student using this form-->
                                         <c:if test="${edit.equals('true')}">
                                             <div class="form-group">
                                                 <label>Updating user information </label>
                                             </div>
                                             <div class="form-group">
                                              <label>Id</label>
                                            <input class="form-control" name="sid" type="text" value="${student.id}" readonly>
                                            <p class="help-block">id cannot be modified</p>
                                       
                                        </div>
                                         </c:if>
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input class="form-control" name="sname" type="text" placeholder="Enter name here"
                                                   <c:if test="${edit.equals('true')}"> value="${student.name}" </c:if> required>
                                            <p class="help-block">Enter full name.</p>
                                       
                                        </div>
                
                                        <div class="form-group">
                                            <label>Gender</label>
                                            <div class="form-control">
                                            <input  type="radio" name="sgender" value="Male"<c:if test="${student.gender.equals('Male')}"> checked</c:if>> &nbsp;Male &nbsp;&nbsp;
                                            <input  type="radio" name="sgender" value="Female" <c:if test="${student.gender.equals('Female')}"> checked</c:if>> &nbsp; Female
                                        </div>
                                        </div>
                                         <div class="form-group">
                                            <label>Hobbies</label>
                                            <div class="form-control">
                                            <input  type="checkbox" name="shobbies" value="Coding"<c:if test="${student.hobbies.contains('Coding')}"> checked</c:if>> &nbsp; Coding &nbsp;&nbsp;
                                            <input  type="checkbox" name="shobbies" value="Dancing"<c:if test="${student.hobbies.contains('Dancing')}"> checked</c:if>>&nbsp; Dancing &nbsp;&nbsp;
                                             <input  type="checkbox" name="shobbies" value="Swimming" <c:if test="${student.hobbies.contains('Swimmimg')}"> checked</c:if>>&nbsp; Swimmimg &nbsp;&nbsp;
                                        </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Country</label>
                                            <select class="form-control" name="scountry">
                                                <option value="NEPAL" <c:if test="${student.country.equals('NEPAL')}"> checked</c:if> >Nepal</option>
                                                <option value="INDIA" <c:if test="${student.country.equals('INDIA')}"> checked </c:if>>India</option>
                                                <option value="CHINA" <c:if test="${student.country.equals('CHINA')}"> checked </c:if>>China</option>
                                                <option value="BHUTAN" <c:if test="${student.country.equals('BHUTAN')}"> checked </c:if>>Bhutan</option>
                                                <option value="BANGLADESH" <c:if test="${student.country.equals('BANGLADESH')}"> checked </c:if>>Bangladesh</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label> Course Enrolled in: </label>
                                            <select class="form-control" name="scourse">
                                                <c:forEach items="${courselist}" var="course">
                                                    <option value="${course.id}" <c:if test="${student.course.equals('course.id')}"> </c:if>> ${course.title}</option>
                                                </c:forEach>
                                               
                                            </select>
                                        </div>
                                        
                                      
                       
                                        
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
            </div>
                                        
                  
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Display student information </h1>
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
                                        <th>Name</th>
                                        <th>Gender</th>
                                        <th>Hobbies</th>
                                        <th>Course Info</th>
                                        <th>Country</th>
                                         <th>Edit</th>
                                         <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${studentlist}" var="s">
                                    <tr>
                                        <td> ${s.id}</td>
                                        <td>${s.name}</td>
                                         <td>${s.gender}</td>
                                         <td>${s.hobbies}</td>
                                          <td><a href="${pageContext.request.contextPath}/admin/course/detail?id=${s.course}">View detail</td>
                                           <td>${s.country}</td>
                                         <td><a href="${pageContext.request.contextPath}/admin/student/edit?id=${s.id}">Edit </a></td>
                                          <td><a href="${pageContext.request.contextPath}/admin/student/delete?id=${s.id}">Delete </a></td>
                                        
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

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/dist/js/sb-admin-2.js"></script>
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

