<%--
  Created by IntelliJ IDEA.
  User: qudal
  Date: 2022-08-01
  Time: 오후 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

    <title>Title</title>
</head>
<body>
<!-- 카카오 로그인 -->
<a class="p-2" href="https://kauth.kakao.com/oauth/authorize?client_id=8bd1f1ffb82c0dc7e2249a2b8ebe11c4&redirect_uri=http://localhost:8087/login/oauth2/code/kakao
&response_type=code">
    <img
            src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
            width="222"
            alt="카카오 로그인 버튼"
    />
</a>
</body>
</html>