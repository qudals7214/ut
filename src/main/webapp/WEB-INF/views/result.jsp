<%@ page import="com.solo.solo.domain.DataVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: qudal
  Date: 2022-07-29
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>



<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

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
<div id="wrapper">
    <%-- side bar--%>
    <c:import url="import-sidebar.jsp"/>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Top bar -->
        <c:import url="import-topbar.jsp"/>


        <!-- Main Content     [Start]-->
        <div id="content">

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <div class="row" style="width: 100%">
                    <%

                        //                        List<DataVO> result = request.getParameter("result");
                        String name = request.getParameter("name");
                        String id = request.getParameter("id");


                        String search = (String) request.getParameter("search");
//                        Object getSearch = session.getAttribute("search");
//                        String search = (String) getSearch;
//                        String search = request.getParameter("search");

                        request.setCharacterEncoding("UTF-8");

                        List<DataVO> result = (List<DataVO>) request.getAttribute("result");
//                        List<DataVO> result = (List<DataVO>) session.getAttribute("result");
                        ArrayList<String> item = new ArrayList<>();
                        ArrayList<Integer> price = new ArrayList<>();
                        ArrayList<String> date = new ArrayList<>();


                        System.out.println("result 페이지 ====================================================");
                        System.out.println(search);
                        System.out.println(result);

                        System.out.println("result 페이지 ====================================================");

                        if (result != null) {
                            System.out.println("검색 결과 받아옴 result.jsp");
                            for (int i = 0; i < result.size(); i++) {
                                item.add(result.get(i).getItem());
                                System.out.println(result.get(i).getItem());
                                price.add(result.get(i).getPrice());
                                System.out.println(result.get(i).getPrice());
                                date.add(result.get(i).getResultDate2());
                                System.out.println(result.get(i).getResultDate2());
                            }


                    %>
<%--                    <input type="hidden" value="<%=item%>" name="itemList2">--%>
<%--                    <input type="hidden" value="<%=date%>" name="dateList2">--%>
<%--                    <input type="hidden" value="<%=price%>" name="priceList2">--%>

                    <%--                    <c:set var="price" value="<%=price%>"/>--%>
                    <%--                    <h1><c:out value="${price}"/></h1>--%>

                    <%--                    <h1>re</h1>--%>
                    <%--                    <c:set var="price" value="<%=price%>"/>--%>
                    <%--                    <c:forEach items="${price}" var="i">--%>
                    <%--                        <script>--%>
                    <%--                            priceList2.push(${i})--%>
                    <%--                            console.log(priceList2)--%>
                    <%--                            console.log("??")--%>
                    <%--                        </script>--%>
                    <%--                    </c:forEach>--%>

                    <%--                                            <input type="hidden" name="item" value="<%=item%>">--%>
                    <%--                                            <input type="hidden" name="price" value="${price}">--%>
                    <%--                                            <input type="hidden" name="date" value="<%=date%>">--%>
                    <%--                                            <input type="hidden" name="test" value="<%=1%>">--%>
                    <%--                                            <c:set var="price1" value="<%=price%>"/>--%>
                    <%--                                            <c:set var="item1" value="<%=item%>"/>--%>
                    <%--                                            <c:set var="date1" value="<%=date%>"/>--%>
                    <%--                                            <c:set var="test1" value="<%=1%>"/>--%>
                    <%--                                            <h1><c:out value="${price.get(0)}"/></h1>--%>
                    <%

                        }
                    %>

                    <!-- Area Chart -->
                    <div class="col-xl-8 col-lg-7" style="width: 100%">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Dropdown -->
                            <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                <h6 class="m-0 font-weight-bold text-primary"><%=search%>
                                </h6>
                                <div class="dropdown no-arrow">
                                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                         aria-labelledby="dropdownMenuLink">
                                        <div class="dropdown-header">Dropdown Header:</div>
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                    </div>
                                </div>
                            </div>
                            <!-- Card Body -->
                            <div class="card-body">
                                <div class="chart-area">
                                    <canvas id="myAreaChart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- /.container-fluid -->
                <%-- End Page Content --%>

            </div>
            <%-- End Page Content --%>


        </div>
        <%--  End  Main  Content  --%>

        <c:import url="import-footer.jsp"/>
    </div>
    <!-- End of Content Wrapper -->

</div>

<%-- End  Wrapper  --%>


<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<%--<!-- Logout Modal-->--%>
<%--<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
<%--     aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>--%>
<%--                <button class="close" type="button" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">×</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>--%>
<%--                <a class="btn btn-primary" href="login.html">Logout</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<script>
    let dateList2= new Array();
    let itemList2= new Array();
    let priceList2= new Array();
    <%for ( String d : date ){%>
    dateList2.push('<%=d%>')
    <%}%>
    <%for ( String i : item ){%>
    itemList2.push('<%=i%>')
    <%}%>
    <%for ( int p : price ){%>
    priceList2.push('<%=p%>')
    <%}%>
</script>

<!-- Bootstrap core JavaScript-->
<script src="${CONTEXT}/vendor/jquery/jquery.min.js"></script>
<script src="${CONTEXT}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${CONTEXT}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${CONTEXT}/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${CONTEXT}/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${CONTEXT}/js/demo/chart-area-demo.js"></script>
<script src="${CONTEXT}/js/demo/chart-pie-demo.js"></script>

</body>
</html>