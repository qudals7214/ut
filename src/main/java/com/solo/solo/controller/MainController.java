package com.solo.solo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/join")
    public String join() {
        return "join";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/table")
    public String table() {return "table";}

    @RequestMapping(value = "/chart")
    public String chart() {return "chart";}

    @RequestMapping(value = "/result")
    public String result() {return "result";}

    @RequestMapping(value = "/utilitiesCard")
    public String utilitiesCard() {return "utilities-card";}

    @RequestMapping(value = "/utilitiesChart")
    public String utilitiesChart() {return "utilities-chart";}

    @RequestMapping(value = "/utilitiesLike")
    public String utilitiesLike() {return "utilities-like";}

    @RequestMapping(value = "/utilitiesTable")
    public String utilitiesTable() {return "utilities-table";}

//    @RequestMapping(value = "/error404")
//    public String error() {return "error404";}
}
