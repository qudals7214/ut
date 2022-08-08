<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.solo.solo.domain.DataVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Title</title>
</head>
<body id="page-top">



<%
    ArrayList<DataVO> getResult = (ArrayList<DataVO>) session.getAttribute("result");

    if(getResult!=null){
%>
<script>
    let dateList2= new Array();
    let itemList2= new Array();
    let priceList2= new Array();
<%
for (int i =0; i<getResult.size(); i++){
%>
    dateList2.push(<%=getResult.get(i).getResultDate()%>);
    itemList2.push(<%=getResult.get(i).getItem()%>);
    priceList2.push(<%=getResult.get(i).getPrice()%>);

    console.log(<%=getResult.get(i).getPrice()%>);
    <%
}
%>
    // window.onload = search(search){
    function searchResult(search) {
        // search1=search;
        console.log("ee");

        // let search = $("[name=searchKeyword]").val();
        // console.log(search);
        $.ajax({
            type: "GET",
            url: "/v1/search",
            data : search,
            contentType : 'application/json; charset=UTF-8',
            dataType : 'json',
            success : function (result){
                result.forEach(e => {
                    dateList2.push(e.getDate());
                    itemList2.push(e.getItem());
                    priceList2.push(e.getPrice());
                })

                // window.onload = function () {
                //     console.log(search);
                //         console.log(dateList2[0].val());
                //
                //     }

            }
        })
    }

    <%--$('input[name="fruit"]:checked').each(function(i){//체크된 리스트 저장--%>
    <%--    fruitArray.push($(this).val());--%>
    <%--});--%>



    <%--function getSearchResult(){--%>

    <%--    &lt;%&ndash;let getResult = <%=getResult%>;&ndash;%&gt;--%>

    <%--    $.ajax({--%>
    <%--        url:"${search}",--%>
    <%--        type:"get",--%>
    <%--        data:<%=getResult%>,--%>
    <%--        datatype:"json",--%>
    <%--        success:function(result){--%>
    <%--            result.forEach(e =>{--%>
    <%--                dateList2.push(e.getDate());--%>
    <%--                itemList2.push(e.getItem());--%>
    <%--                priceList2.push(e.getPrice());--%>
    <%--            })--%>
    <%--        }--%>
    <%--    });--%>
    <%--};--%>
</script>

<%
    }
%>



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

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>

                </div>

                <!-- Content Row -->
                <div class="row">

                    <!-- Earnings (Monthly) Card Example -->

                    <%--
                    현재가 100,000 100%   목표가 70,000 70%
                    100-70  = 30

                    100/30  = 3.3

                    1%당 3.3% 스타일 와이드 조정

                    목표가 / 현재가 = 달성%
                    70,000 / 100,000 = 완성률 70%
                    70,000 / 50,000 =  완성률 140%
                    --%>


                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-info shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Now
                                        </div>
                                        <div class="row no-gutters align-items-center">
                                            <div class="col-auto">
                                                <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">277,000</div>
                                                <%-- %값 --%>
                                            </div>
                                            <div class="col">
                                                <div class="progress progress-sm mr-2">
                                                    <div class="progress-bar bg-info" role="progressbar"
                                                         style="width: 90%" aria-valuenow="15" aria-valuemin="0"
                                                         aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Target</div>
                                        <div class="row no-gutters align-items-center">
                                            <div style="padding-right: 0">
                                                <div class="h5 mb-0  font-weight-bold text-gray-800">250,000</div>
                                                <%-- %값 --%>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>90.2% , +27,000</div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Content Row -->


                <div class="row" style="width: 100%">
                    <%

                        //                        List<DataVO> result = request.getParameter("result");


                        String search = (String) session.getAttribute("search");
                        List<DataVO> result = (List<DataVO>) session.getAttribute("result");
                        ArrayList<String> item = new ArrayList<>();
                        ArrayList<Integer> price = new ArrayList<>();
                        ArrayList<Date> date = new ArrayList<>();


                        if (result != null) {
                            System.out.println("값 받아옴");
//                            for (int i = 0; i < result.size(); i++) {
//                                item.add(result.get(i).getItem());
//                                System.out.println(result.get(i).getItem());
//                                price.add(result.get(i).getPrice());
//                                System.out.println(result.get(i).getPrice());
//                                date.add(result.get(i).getResultDate());
//                                System.out.println(result.get(i).getResultDate());
//                            }
                    %>

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
            <%--  End  Main  Content  --%>

        </div>
        <!-- End of Content Wrapper -->
        <c:import url="import-footer.jsp"/>
    </div>
    <%--<c:import url="import-topbutton.jsp"/>--%>
    <%-- End  Wrapper  --%>


    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>


</body>
</html>