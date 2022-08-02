package com.solo.solo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.solo.solo.domain.UserRepository;
import com.solo.solo.domain.UserRequestDTO;
import com.solo.solo.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoService {

    public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // POST 요청을 위해 기본값이 false인 setDoOutput을 true로

            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");

            sb.append("&client_id=8bd1f1ffb82c0dc7e2249a2b8ebe11c4"); //본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:8087/login/oauth2/code/kakao"); // 본인이 설정한 주소

            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            // 결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            // 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;
    }


    // 클래스 주입.
    @Autowired
    private UserRepository ur;

    // 메서드 리턴타입 KakaoDTO로 변경 및 import.
    public List<UserVO> getUserInfoKakao(String access_Token) {
        UserRequestDTO userInfo = new UserRequestDTO();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
            userInfo.setName(nickname);
            userInfo.setId(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String kakao = "kakao";
        // catch 아래 코드 추가.
        List<UserVO> result = ur.findUser(userInfo.getId() , kakao);
        // 위 코드는 먼저 정보가 저장되있는지 확인하는 코드.
        System.out.println("S:" + result);
        System.out.println(result);
        System.out.println(userInfo.getId());
        System.out.println(userInfo.getName());
        if(result.size()<1) {
            System.out.println("가입 진행");
            // result가 null이면 정보가 저장이 안되있는거므로 정보를 저장.
            userInfo.setSocial("kakao");
            ur.insertUser(userInfo.getId(),userInfo.getName(), kakao);
            // 위 코드가 정보를 저장하기 위해 Repository로 보내는 코드임.
            return ur.findUser(userInfo.getId(), kakao);
            // 위 코드는 정보 저장 후 컨트롤러에 정보를 보내는 코드임.
            //  result를 리턴으로 보내면 null이 리턴되므로 위 코드를 사용.
        } else {
            System.out.println("로그인 진행");
            return result;
            // 정보가 이미 있기 때문에 result를 리턴함.
        }

    }
}