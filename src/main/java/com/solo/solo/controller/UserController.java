package com.solo.solo.controller;

import com.solo.solo.domain.UserRequestDTO;
import com.solo.solo.domain.UserVO;
import com.solo.solo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/v1/getUser")
    public UserVO getUser(@RequestBody UserRequestDTO userRequestDTO) {
        System.out.println("////");
        UserVO user = userService.readUser(userRequestDTO);
        System.out.println(user);
        return user;
    }

    @PostMapping("/v1/getUserForId")
    public UserVO getUserForId(@RequestParam String id) {
        UserVO user = userService.readUserForId(id);
        return user;
    }

    @PostMapping("/v1/checkId")
    public String checkId(@RequestBody UserRequestDTO userRequestDTO) {
//        return userService.checkId(userRequestDTO).getId();
        return userService.duplId(userRequestDTO);
    }


    @PostMapping("/v1/addUser")
    public UserVO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserVO user = userService.createUser(userRequestDTO);
        if (user == null) {
            System.out.println("ID 중복 Insert 실패");
        } else {
            System.out.println("Insert 성공");
        }
        return user;
    }

    @PutMapping("/v1/updateUser")
    public void updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUser(userRequestDTO);
    }

    @DeleteMapping("/v1/deleteUser")
    public void deleteUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.deleteUser(userRequestDTO);
    }


    @PostMapping("/v1/login")
//    public void login(@RequestBody UserRequestDTO userRequestDTO , HttpServletRequest request , HttpServletResponse response){
    public void login(@RequestParam String id, @RequestParam String pw, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("v1/login 도착");
        UserVO user = getUserForId(id);
        String url = "";
        if (user.getPw().equals(pw)) {
            System.out.println("v1/login 성공1");
            url = "/main";
            HttpSession session = request.getSession();
            session.setAttribute("log", user.getId());
            System.out.println("v1/login 성공2");
        } else
            url = "/index";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/v1/logout")
    public void logout(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("log", null);
        String url = "/index";
        request.getRequestDispatcher(url).forward(request, response);
        System.out.println("로그아웃 성공");
    }


    @PostMapping("/test")
    public List<UserVO> getAllUser(@RequestBody UserRequestDTO userRequestDTO) {
        List<UserVO> result = userService.readAllUser(userRequestDTO);
        if (result.isEmpty())
            System.out.println("회원 정보 확인 실패");
        else
            System.out.println("회원 정보 확인 성공");

        return result;
    }
}
