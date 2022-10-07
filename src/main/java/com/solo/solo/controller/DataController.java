package com.solo.solo.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.solo.solo.domain.DataVO;
import com.solo.solo.domain.DataVOComparator;
import com.solo.solo.service.DataService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jdk.swing.interop.DispatcherWrapper;
import lombok.extern.jackson.Jacksonized;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.*;

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

//    @JsonIgnore
//    @RequestMapping(value = "/v1/search" , method = RequestMethod.POST)
//        public @ResponseBody List<DataVO> search(@RequestParam(value = "search" , required = false) String search , HttpServletRequest request  , HttpServletResponse response) throws IOException, ServletException, JSONException {
//            List<DataVO> result = ds.Search(search);
////            String url = "/index";
////            response.sendRedirect(url);
////            session.invalidate();
////            session.setAttribute("search",search);
////            session.setAttribute("result", result);
////        result.sort((o1,o2) -> o1.getResultDate().compareTo(o2.getResultDate()));
////        result.sort(Comparator.comparing(DataVO::getResultDate));
////        result.sort((o1, o2) -> o1.sort(o2));
////        Arrays.sort(result,new Comparator<DataVO>());
//
////        String searchKeyword = search;
////        request.setAttribute("search",search);
//
//
//
//        Collections.sort(result , new DataVOComparator());
//
//        for(DataVO d : result){
//            System.out.println("데이터 컨트롤러 시간 정렬 : "+d.getResultDate());
//        }
//
////        session.setAttribute("search",search);
////        session.setAttribute("result",result);
////        session.setMaxInactiveInterval(60*60);
//
////        System.out.println(result);
////        System.out.println(search);
//
//        String reA = (String) session.getAttribute(search);
//        String reB = (String) session.getAttribute(String.valueOf(result));
//
//
//        System.out.println("데이터 컨트롤러 시작===========================================");
//        System.out.println(result);
//        System.out.println(search);
//
//
//
//
//
//
//
////        request.setCharacterEncoding("UTF-8");
////        response.setCharacterEncoding("UTF-8");
//        request.setAttribute("search", search);
//        request.setAttribute("result", result);
//
//
////        pageContext.forward("responseTest4.jsp");
////        response.sendRedirect("/result");
//
//        String url = "/result";
//        request.getRequestDispatcher(url).forward(request, response);
//
//
//
//        System.out.println("데이터 컨트롤러 끝===========================================");
//
//
//
//
//
//
//        return result;
//    }


    //////////////////////////////////////////////////////////////

    @RequestMapping(value = "search" , method = RequestMethod.POST)
    public void search1(@RequestParam(value = "search" , required = false) String search , HttpServletRequest request  , HttpServletResponse response) throws IOException, ServletException, JSONException {
        List<DataVO> result = ds.Search(search);

        Collections.sort(result , new DataVOComparator());

        for(DataVO d : result){
            d.resultDate();
            System.out.println("데이터 컨트롤러 시간 정렬 : "+d.getDate());
            System.out.println("데이터 컨트롤러 시간 정렬2 : "+d.getResultDate2());
        }

        System.out.println("\n데이터 컨트롤러 시작===========================================\n");
        System.out.println(result);
        System.out.println(search);

        request.setAttribute("search", search);
        request.setAttribute("result", result);



        String url = "/result";
        System.out.println("\n데이터 컨트롤러 끝===========================================\n");

        request.getRequestDispatcher(url).forward(request, response);

//        return url;
    }

    //////////////////////////////////////////////////////////////

//    @RequestMapping(value = "/v1/search" , method = RequestMethod.GET)
//        public @ResponseBody JSONObject search(@RequestParam(value = "search" , required = false) String search , HttpServletRequest request  , HttpServletResponse response) throws IOException, JSONException {
//            List<DataVO> result = ds.Search(search);
//            String url = "/index";
//            response.sendRedirect(url);
//            session.setAttribute("search",search);
//            session.setAttribute("result", result);
//
//
//
//            JSONArray JSONArray = new JSONArray();
//            JSONObject resultJSON = new JSONObject();
//            for(int i=0; i< result.size(); i++){
//                JSONObject data = new JSONObject();
//                data.put("item",result.get(i).getItem());
//                data.put("price",result.get(i).getPrice());
//                data.put("date",result.get(i).getResultDate());
//                JSONArray.put(data);
//            }
//            resultJSON.put("result",JSONArray);
//
//        return resultJSON;
//    }


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