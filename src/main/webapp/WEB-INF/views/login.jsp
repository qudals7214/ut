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

<a id="custom-login-btn" href="javascript:loginWithKakao()">
    <img
            src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
            width="222"
            alt="카카오 로그인 버튼"
    />
</a>
<p id="token-result"></p>
<script type="text/javascript">
    function loginWithKakao() {
        Kakao.Auth.authorize({
            redirectUri: 'http://localhost:8087/v1/login/kakao'
        })
    }

    // 아래는 데모를 위한 UI 코드입니다.
    displayToken()

    function displayToken() {
        const token = getCookie('authorize-access-token')
        if (token) {
            Kakao.Auth.setAccessToken(token)
            Kakao.Auth.getStatusInfo(({status}) => {
                if (status === 'connected') {
                    document.getElementById('token-result').innerText = 'login success. token: ' + Kakao.Auth.getAccessToken()
                } else {
                    Kakao.Auth.setAccessToken(null)
                }
            })
        }
    }

    function getCookie(name) {
        const value = "; " + document.cookie;
        const parts = value.split("; " + name + "=");
        if (parts.length === 2) return parts.pop().split(";").shift();
    }
</script>


</body>
</html>
