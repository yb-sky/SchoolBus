package com.talkweb.edu.controller;

import com.talkweb.edu.entity.CarApplicant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-02 10:25
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "hello,Index";
    }

    @RequestMapping("/page")
    public String indexPage(){
        return "index";
    }

}
