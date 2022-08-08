package com.solo.solo.controller;

import com.solo.solo.domain.DataVO;
import com.solo.solo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class DataController {

    @Autowired
    DataService ds;

    @Autowired
    private HttpSession session;

//    @RequestMapping(value = "/v1/search" , method = RequestMethod.GET)
//    public void search(@RequestParam(value = "search" , required = true) String search){
//        List<DataVO> result = ds.Search(search);
//    }

    @RequestMapping(value = "/v1/search" , method = RequestMethod.GET)
    public @ResponseBody List<DataVO> search(@RequestParam(value = "search" , required = false) String search , HttpServletRequest request  , HttpServletResponse response) throws IOException {
        List<DataVO> result = ds.Search(search);
        String url = "/index";
        response.sendRedirect(url);
        session.setAttribute("search",search);
        session.setAttribute("result", result);
        return result;
    }

//    @RequestMapping(value = "/v1/getLowestPrice", method = RequestMethod.GET)
//    public @ResponseBody List<DataLowestPriceVO> getLowestPrice(@RequestParam(value = "name", required = false) String name){
//        List<DataLowestPriceVO> result = ds.readAllPrice(name);
//        if(result.isEmpty())
//            System.out.println("DB에 존재하지 않음");
//        else
//            System.out.println("확인 성공 DB Load");
//        return result;
//    }





}