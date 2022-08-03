package com.solo.solo.controller;

import com.solo.solo.domain.DataLowestPriceVO;
import com.solo.solo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    DataService ds;

    @RequestMapping(value = "/v1/getLowestPrice", method = RequestMethod.GET)
    public @ResponseBody List<DataLowestPriceVO> getLowestPrice(@RequestParam(value = "name", required = false) String name){
        List<DataLowestPriceVO> result = ds.readAllPrice(name);
        if(result.isEmpty())
            System.out.println("DB에 존재하지 않음");
        else
            System.out.println("확인 성공 DB Load");
        return result;
    }





}