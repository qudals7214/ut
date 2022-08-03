<%--
  Created by IntelliJ IDEA.
  User: qudal
  Date: 2022-07-29
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name ="google-signin-client_id" content="248941071597-9eft791smjp1gk2v101oaibhj3qvacdc.apps.googleusercontent.com">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Price</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
<c:url var="index" value="/index"/>
<c:url var="login" value="/login"/>
<c:url var="chart" value="/chart"/>
<c:url var="table" value="/table"/>
<c:url var="utilitiesCard"  value="/utilitiesCard"/>
<c:url var="utilitiesChart" value="/utilitiesChart"/>
<c:url var="utilitiesLike"  value="/utilitiesLike"/>
<c:url var="utilitiesTable" value="/utilitiesTable"/>
<c:url var="logout" value="/v1/logout"/>

<!-- Page Wrapper -->
<%--<div id="wrapper">--%>

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">My Price</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="${index}">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Main</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="${chart}">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="${table}">
                <i class="fas fa-fw fa-table"></i>
                <span>Tables</span></a>
        </li>











        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>Components</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom Components:</h6>
                    <a class="collapse-item" href="${utilitiesCard}">Card</a>
                    <a class="collapse-item" href="${utilitiesChart}">Chart</a>
                    <a class="collapse-item" href="${utilitiesLike}">Like</a>
                    <a class="collapse-item" href="${utilitiesTable}">Table</a>
                </div>
            </div>
        </li>
<%----%>
<%--        <!-- Nav Item - Utilities Collapse Menu -->--%>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"--%>
<%--               aria-expanded="true" aria-controls="collapseUtilities">--%>
<%--                <i class="fas fa-fw fa-wrench"></i>--%>
<%--                <span>Utilities</span>--%>
<%--            </a>--%>
<%--            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"--%>
<%--                 data-parent="#accordionSidebar">--%>
<%--                <div class="bg-white py-2 collapse-inner rounded">--%>
<%--                    <h6 class="collapse-header">Custom Utilities:</h6>--%>
<%--                    <a class="collapse-item" href="utilities-color.html">Colors</a>--%>
<%--                    <a class="collapse-item" href="utilities-border.html">Borders</a>--%>
<%--                    <a class="collapse-item" href="utilities-animation.html">Animations</a>--%>
<%--                    <a class="collapse-item" href="utilities-other.html">Other</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </li>--%>
<%----%>
<%--        <!-- Divider -->--%>
<%--        <hr class="sidebar-divider">--%>
<%----%>
<%--        <!-- Heading -->--%>
<%--        <div class="sidebar-heading">--%>
<%--            Addons--%>
<%--        </div>--%>

<%--        <!-- Nav Item - Pages Collapse Menu -->--%>
<%--        <li class="nav-item">--%>
<%--            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"--%>
<%--               aria-expanded="true" aria-controls="collapsePages">--%>
<%--                <i class="fas fa-fw fa-folder"></i>--%>
<%--                <span>Pages</span>--%>
<%--            </a>--%>
<%--            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">--%>
<%--                <div class="bg-white py-2 collapse-inner rounded">--%>
<%--                    <h6 class="collapse-header">Login Screens:</h6>--%>
<%--                    <a class="collapse-item" href="${login}">Login</a>--%>
<%--                    <a class="collapse-item" href="register.html">Register</a>--%>
<%--                    <a class="collapse-item" href="forgot-password.html">Forgot Password</a>--%>
<%--                    <div class="collapse-divider"></div>--%>
<%--                    <h6 class="collapse-header">Other Pages:</h6>--%>
<%--                    <a class="collapse-item" href="404.html">404 Page</a>--%>
<%--                    <a class="collapse-item" href="blank.html">Blank Page</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </li>--%>



        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

<%--        <!-- Sidebar Message -->--%>
<%--        <div class="sidebar-card d-none d-lg-flex">--%>
<%--            <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="...">--%>
<%--            <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>--%>
<%--            <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>--%>
<%--        </div>--%>

    </ul>
    <!-- End of Sidebar -->



<%--</div>--%>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>




</body>

</html>