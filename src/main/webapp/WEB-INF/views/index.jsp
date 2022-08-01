<%--
  Created by IntelliJ IDEA.
  User: qudal
  Date: 2022-07-29
  Time: 오전 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
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


      </div>
      <%-- End Page Content --%>


    </div>
    <%--  End  Main  Content  --%>

  </div>
  <!-- End of Content Wrapper -->

</div>
<%-- End  Wrapper  --%>
<c:import url="import-footer.jsp"/>
</body>
</html>