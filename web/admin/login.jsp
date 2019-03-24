<%-- 
    Document   : login
    Created on : Jan 2, 2019, 6:18:41 PM
    Author     : Siron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <%@include file="title.jsp" %>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- absolute path is made
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
            <!--header.jsp-->

            <div id="page-wrapper">

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Login</h1>
                    </div>
                </div>

                <div clss="row">
                    <!--add login information form-->
                      <div class="col-lg-9"><!--//col-lg=large-6=half quarter-->
                    <form role="form" 
                          action="${pageContext.request.contextPath}/login" 
                          method="post">
                                        <div class="form-group"><!-- form input element are put in a group-->
                                            <label>Username</label>
                                            <input class="form-control" name="luser" type="text" placeholder="Enter username here.." required>
                                            <p class="help-block">Enter registered username</p>
                                        </div>
                        
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" type="password" name="lpassword" placeholder="Enter password here" required>
                                        </div>
                        
                                        <div class="form-group">
                                            <label>Authority</label>
                                            <div class="form-control">
                                                <input type="radio" name="lauthority" value="admin"/>&nbsp;Admin&nbsp;&nbsp;
                                                <input type="radio" name="lauthority" value="user"/>&nbsp;User
                                            </div>
                                        </div>
                                       
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                </div>
                    
                </div>
                
            </div>
            <!-- /#page-wrapper -->
            
                       
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
